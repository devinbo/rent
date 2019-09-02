package com.xxz.rent.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.xxz.rent.bo.exception.BusinessLogicException;
import com.xxz.rent.dao.OmsOrderDao;
import com.xxz.rent.dao.OmsOrderOperateHistoryDao;
import com.xxz.rent.dao.OmsOrderPaymentDao;
import com.xxz.rent.dto.*;
import com.xxz.rent.dto.enumerate.OrderOperate;
import com.xxz.rent.dto.enumerate.OrderStatus;
import com.xxz.rent.dto.enumerate.PaymentStatus;
import com.xxz.rent.dto.enumerate.RentUnit;
import com.xxz.rent.mapper.*;
import com.xxz.rent.model.*;
import com.xxz.rent.service.OmsOrderService;
import com.xxz.rent.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 订单管理Service实现类
 * Created by macro on 2018/10/11.
 */
@Service
@Slf4j
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OmsOrderDao orderDao;
    @Autowired
    private OmsOrderOperateHistoryDao orderOperateHistoryDao;
    @Autowired
    private OmsOrderOperateHistoryMapper orderOperateHistoryMapper;
    @Autowired
    private OmsOrderItemMapper orderItemMapper;
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private OmsOrderPaymentMapper orderPaymentMapper;
    @Autowired
    private OmsOrderPaymentDao orderPaymentDao;
    @Autowired
    private OmsOrderSettingMapper orderSettingMapper;
    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;
    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private UmsMemberFreemoneyLogMapper memberFreemoneyLogMapper;



    @Override
    public List<OmsOrder> list(OmsOrderQueryParam queryParam,  PageParam pageParam) {
        PageHelper.startPage(pageParam);
        return orderDao.getList(queryParam);
    }

    @Override
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList) {
        //批量发货
        int count = orderDao.delivery(deliveryParamList);
        //添加操作记录
        List<OmsOrderOperateHistory> operateHistoryList = deliveryParamList.stream()
                .map(omsOrderDeliveryParam -> {
                    OmsOrderOperateHistory history = new OmsOrderOperateHistory();
                    history.setOrderId(omsOrderDeliveryParam.getOrderId());
                    history.setCreateTime(new Date());
                    history.setOperateMan("后台管理员");
                    history.setOrderStatus(2);
                    history.setNote("完成发货");
                    return history;
                }).collect(Collectors.toList());
        orderOperateHistoryDao.insertList(operateHistoryList);
        return count;
    }

    @Override
    public int close(List<Long> ids, String note) {
        List<OmsOrderOperateHistory> historyList = ids.stream().map(orderId -> {
            OmsOrder record = orderMapper.selectByPrimaryKey(orderId);
            if(!record.getStatus().equals(OrderStatus.PAY.getStatus())) {
                throw new BusinessLogicException("该订单无法取消");
            }

            record.setStatus(OrderStatus.CANCEL.getStatus());
            record.setNote(record.getNote());
            //退还客户使用的额度
            updateMemberFreeMoney(record, "订单被取消，退还额度");


            //处理优惠券信息
            Long couponId = record.getCouponId();
            updateCouponStatus(couponId, record.getMemberId(), 0);


            //TODO 退还使用积分
            OmsOrderOperateHistory history = new OmsOrderOperateHistory();
            history.setOrderId(orderId);
            history.setCreateTime(new Date());
            history.setOperateMan(adminService.getCurrLoginInfo().getUsername());
            history.setOrderStatus(OrderStatus.CANCEL.getStatus());
            history.setNote("订单取消:" + note);
            return history;
        }).collect(Collectors.toList());
        int count = orderOperateHistoryDao.insertList(historyList);
        return count;
    }

    /**
     * 退还客户额度
     * @param record
     */
    private void updateMemberFreeMoney(OmsOrder record, String note) {
        orderMapper.updateByPrimaryKeySelective(record);
        UmsMember umsMember = memberMapper.selectByPrimaryKey(record.getMemberId());
        BigDecimal orderFreeMoney = record.getFreeMoney() == null ? new BigDecimal(0) : record.getFreeMoney();
        umsMember.setFreeMoney(umsMember.getFreeMoney().add(orderFreeMoney));
        memberMapper.updateByPrimaryKeySelective(umsMember);
        //插入操作记录
        UmsMemberFreemoneyLog log = new UmsMemberFreemoneyLog();
        log.setMemberId(record.getMemberId());
        log.setNote(note);
        log.setMoney(orderFreeMoney.negate());
        log.setCreateTime(new Date());
        memberFreemoneyLogMapper.insertSelective(log);
    }

    /**
     * 将优惠券信息更改为指定状态
     *
     * @param couponId  优惠券id
     * @param memberId  会员id
     * @param useStatus 0->未使用；1->已使用
     */
    private void updateCouponStatus(Long couponId, Long memberId, Integer useStatus) {
        if (couponId == null) {
            return;
        }
        //查询第一张优惠券
        SmsCouponHistoryExample example = new SmsCouponHistoryExample();
        example.createCriteria().andMemberIdEqualTo(memberId)
                .andCouponIdEqualTo(couponId).andUseStatusEqualTo(useStatus == 0 ? 1 : 0);
        List<SmsCouponHistory> couponHistoryList = couponHistoryMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(couponHistoryList)) {
            SmsCouponHistory couponHistory = couponHistoryList.get(0);
            couponHistory.setUseTime(new Date());
            couponHistory.setUseStatus(useStatus);
            couponHistoryMapper.updateByPrimaryKeySelective(couponHistory);
        }
    }


    @Override
    public int delete(List<Long> ids) {
        OmsOrder record = new OmsOrder();
        record.setDeleteStatus(1);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        return orderMapper.updateByExampleSelective(record, example);
    }

    @Override
    public OmsOrderDetail detail(Long id) {
        return orderDao.getDetail(id);
    }

    @Override
    public int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam) {
        OmsOrder order = new OmsOrder();
        order.setId(receiverInfoParam.getOrderId());
        order.setReceiverName(receiverInfoParam.getReceiverName());
        order.setReceiverPhone(receiverInfoParam.getReceiverPhone());
        order.setReceiverPostCode(receiverInfoParam.getReceiverPostCode());
        order.setReceiverDetailAddress(receiverInfoParam.getReceiverDetailAddress());
        order.setReceiverProvince(receiverInfoParam.getReceiverProvince());
        order.setReceiverCity(receiverInfoParam.getReceiverCity());
        order.setReceiverRegion(receiverInfoParam.getReceiverRegion());
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        //插入操作记录
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(receiverInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(receiverInfoParam.getStatus());
        history.setNote("修改收货人信息");
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam) {
        OmsOrder order = new OmsOrder();
        order.setId(moneyInfoParam.getOrderId());
        order.setFreightAmount(moneyInfoParam.getFreightAmount());
        order.setDiscountAmount(moneyInfoParam.getDiscountAmount());
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        //插入操作记录
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(moneyInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(moneyInfoParam.getStatus());
        history.setNote("修改费用信息");
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public int updateNote(Long id, String note, Integer status) {
        OmsOrder order = new OmsOrder();
        order.setId(id);
        order.setNote(note);
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(id);
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(status);
        history.setNote("修改备注信息：" + note);
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public List<OmsOrderOperateHistory> getOperateList(Long id, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        OmsOrderOperateHistoryExample example = new OmsOrderOperateHistoryExample();
        example.createCriteria().andOrderIdEqualTo(id);
        return orderOperateHistoryMapper.selectByExample(example);
    }

    @Override
    public int auditOrder(Long id, OmsOrderAuditParam auditParam) {
        OmsOrder omsOrder = orderMapper.selectByPrimaryKey(id);
        omsOrder.setRefuseReason(auditParam.getRefuseReason());
        omsOrder.setImeiNo(auditParam.getImeiNo());
        int status;
        if (Objects.equals(auditParam.getStatus(), 0)) {
            //审核拒绝
            omsOrder.setStatus(OrderStatus.REFUSED.getStatus());
            status = OrderStatus.REFUSED.getStatus();

            //退还客户使用的额度
            updateMemberFreeMoney(omsOrder, "订单被拒绝，退还额度");
            //退还优惠券信息
            Long couponId = omsOrder.getCouponId();
            updateCouponStatus(couponId, omsOrder.getMemberId(), 0);
        } else {
            //审核通过
            omsOrder.setStatus(OrderStatus.SIGN.getStatus());
            status = OrderStatus.SIGN.getStatus();
        }
        int count = orderMapper.updateByPrimaryKeySelective(omsOrder);
        //添加操作记录
        insertOrderOperate(id, status, OrderOperate.AUDIT, auditParam.getRefuseReason());
        return count;
    }

    @Override
    public int signOrder(Long id, String start_time, String file) {
        OmsOrder omsOrder = orderMapper.selectByPrimaryKey(id);
        //处理费用信息
        OmsOrderItemExample example = new OmsOrderItemExample();
        example.createCriteria().andOrderIdEqualTo(id);
        List<OmsOrderItem> omsOrderItemList = orderItemMapper.selectByExample(example);
        if (omsOrderItemList == null || omsOrderItemList.size() == 0) {
            log.error("订单ID:" + id + ",为异常订单;异常原因：缺失产品信息。");
            return 0;
        }
        OmsOrderItem orderItem = omsOrderItemList.get(0);
        omsOrder.setEachPrice(orderItem.getProductEachPrice());
        omsOrder.setPeriods(orderItem.getProductPeriods());
        omsOrder.setUnit(orderItem.getProductUnit());
        omsOrder.setStatus(OrderStatus.SIGNING.getStatus());
        omsOrder.setSigeStartTime(DateUtil.parse(start_time, "yyyy-MM-dd"));
        omsOrder.setSignFile(file);

        //生成每期费用
        createPayMent(orderItem, omsOrder);
        int count = orderMapper.updateByPrimaryKeySelective(omsOrder);
        //插入操作备注信息
        insertOrderOperate(id, OrderStatus.SIGNING.getStatus(), OrderOperate.SIGN, "签约完成");
        return count;
    }

    @Override
    public int overOrder(Long orderId, Integer completeType) {
        //处理主订单，将待还时间，金额设置为null
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setId(orderId);
        if(1 == completeType ) {
            //买断
            omsOrder.setStatus(OrderStatus.BUY.getStatus());
        }else if(2 == completeType) {
            //归还
            omsOrder.setStatus(OrderStatus.RETURN.getStatus());
        }else {
            return 0;
        }
        return orderMapper.updateByPrimaryKeySelective(omsOrder);
    }

    private void createPayMent(OmsOrderItem orderItem, OmsOrder omsOrder) {
        List<OmsOrderPayment> orderPaymentList = new ArrayList<>();
        Integer periods = orderItem.getProductPeriods();
        for (int i = 1; i <= periods; i++) {
            OmsOrderPayment orderPayment = new OmsOrderPayment();
            orderPayment.setIdex(i);
            orderPayment.setOrderId(orderItem.getOrderId());
            orderPayment.setBaseMoney(orderItem.getProductEachPrice());
            orderPayment.setPayMoney(orderItem.getProductEachPrice());
            if (i == 1) {
                //设置首期待支付
                orderPayment.setStatus(PaymentStatus.WAITPAY.getStatus());
            } else {
                orderPayment.setStatus(PaymentStatus.NOCREATE.getStatus());
            }
            Date startDate = omsOrder.getSigeStartTime();

            //设置还款日期
            Integer unit = orderItem.getProductUnit();
            if (unit == RentUnit.DAY.getValue()) {
                //以日为单位
                orderPayment.setPayTime(DateUtil.offsetDay(startDate, i));
            } else if (unit == RentUnit.WEEK.getValue()) {
                //以周为单位
                orderPayment.setPayTime(DateUtil.offsetWeek(startDate, i));
            } else if (unit == RentUnit.MONTH.getValue()) {
                //以月为单位
                orderPayment.setPayTime(DateUtil.offsetMonth(startDate, i));
            } else if (unit == RentUnit.YEAR.getValue()) {
                orderPayment.setPayTime(DateUtil.offset(startDate, DateField.YEAR, i));
            }
            orderPaymentList.add(orderPayment);
        }
        //设置签约截止日期
        omsOrder.setSigeEndTime(orderPaymentList.get(periods - 1).getPayTime());

        //处理活动产生的优惠
        Integer promotionType = orderItem.getPromotionType();
        //参数首期减免活动
        if (promotionType != null && promotionType == 1) {
            OmsOrderPayment orderPayment = orderPaymentList.get(0);
            if (promotionIsValid(orderItem.getPromotionStartTime(), orderItem.getPromotionEndTime(), orderItem.getCreateTime())) {
                //下单时候参与了活动 首期实际租金： 基本-活动优惠
                BigDecimal payMoney = orderPayment.getPayMoney().subtract(orderItem.getFirstEachPriceSub());
                orderPayment.setPayMoney(payMoney);
                orderPayment.setPreferentialMoney(orderItem.getFirstEachPriceSub());
            }
        }
        omsOrder.setRentPayMoney(orderPaymentList.get(0).getPayMoney());
        omsOrder.setRentPayTime(orderPaymentList.get(0).getPayTime());
        orderPaymentDao.insertList(orderPaymentList);
    }

    /**
     * 判断活动是否有效
     *
     * @return
     */
    private boolean promotionIsValid(Date startDate, Date endDate, Date creteDate) {
        if (creteDate == null) {
            return false;
        }
        if (startDate == null && endDate == null) {
            return true;
        } else if (startDate == null && endDate.getTime() > creteDate.getTime()) {
            return true;
        } else if (endDate == null && startDate.getTime() < creteDate.getTime()) {
            return true;
        } else if (startDate.getTime() < creteDate.getTime() && endDate.getTime() > creteDate.getTime()) {
            return true;
        }
        return false;
    }

    @Override
    public void insertOrderOperate(Long orderId, int orderStatus, OrderOperate orderOperate, String note) {
        OmsOrderOperateHistory operateHistory = new OmsOrderOperateHistory();
        operateHistory.setOrderId(orderId);
        operateHistory.setOrderStatus(orderStatus);
        operateHistory.setOperateType(orderOperate.getOperateType());
        operateHistory.setContent(orderOperate.getOperateContent());
        operateHistory.setNote(note);
        operateHistory.setOperateMan(adminService.getCurrLoginInfo().getUsername());
        operateHistory.setCreateTime(new Date());
        orderOperateHistoryMapper.insertSelective(operateHistory);
    }

    @Override
    public int buyOrder(Long id, String note) {
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setId(id);
        omsOrder.setStatus(OrderStatus.BUY.getStatus());
        //订单完成类型： 0->未完成； 1->归还；2->买断
        omsOrder.setCompleteType(2);
        int count = orderMapper.updateByPrimaryKeySelective(omsOrder);

        //操作记录
        Integer status = orderMapper.selectByPrimaryKey(id).getStatus();
        insertOrderOperate(id, status, OrderOperate.BUY, null);
        return count;
    }

    @Override
    public int backOrder(Long id, String note) {
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setId(id);
        omsOrder.setStatus(OrderStatus.RETURN.getStatus());
        //订单完成类型： 0->未完成； 1->归还；2->买断
        omsOrder.setCompleteType(1);
        int count = orderMapper.updateByPrimaryKeySelective(omsOrder);
        //操作记录
        Integer status = orderMapper.selectByPrimaryKey(id).getStatus();
        insertOrderOperate(id, status, OrderOperate.BACK, null);
        return count;
    }
}
