package com.xxz.rent.portal.service.impl;

import cn.hutool.json.JSONUtil;
import com.xxz.rent.dto.enumerate.OrderOperate;
import com.xxz.rent.dto.enumerate.OrderStatus;
import com.xxz.rent.dto.enumerate.OtoOrderStatus;
import com.xxz.rent.dto.enumerate.PaymentStatus;
import com.xxz.rent.mapper.*;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.model.dto.WechatParam;
import com.xxz.rent.portal.model.dto.WechatResult;
import com.xxz.rent.portal.model.dto.ZhifbResult;
import com.xxz.rent.portal.service.OmsPayCallBackService;
import com.xxz.rent.portal.service.OmsPortalOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-23 11:27
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
@Slf4j
public class OmsPayCallBackServiceImpl implements OmsPayCallBackService {

    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OtoOrderMapper otoOrderMapper;
    @Autowired
    private OmsOrderPaymentMapper paymentMapper;
    @Autowired
    private OtoOrderPaymentMapper otoOrderPaymentMapper;
    @Autowired
    private OmsOrderPayLogMapper omsOrderPayLogMapper;
    @Autowired
    private OmsOrderOperateHistoryMapper operateHistoryMapper;

    @Override
    public String wechatPay(WechatParam wechatParam) {
        if (wechatParam.getAttach() == null) {
            return WechatResult.fail();
        }
        try {
            boolean res = pay(wechatParam.getAttach(),
                    new BigDecimal(wechatParam.getTotal_fee())
                            .divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP)
                            .toString(), 2);
            if (res) {
                insertPayLog(1, 1, JSONUtil.toJsonStr(wechatParam), null);
                return WechatResult.success();
            } else {
                insertPayLog(1, 2, JSONUtil.toJsonStr(wechatParam), null);
                return WechatResult.fail();
            }
        } catch (Exception e) {
            log.info("微信支付回调异常：" + e);
            return WechatResult.fail();
        }
    }

    @Override
    public String payCallBack(ZhifbResult payParam) {
        String params = payParam.getPassback_params();
        if (params == null) {
            log.info("支付宝回调自定义参数为null");
            return "failure";
        }
        try {
            boolean res = pay(params, payParam.getTotal_amount(), 1);
            if (res) {
                insertPayLog(1, 1, JSONUtil.toJsonStr(payParam), null);
                return "true";
            } else {
                insertPayLog(1, 2, JSONUtil.toJsonStr(payParam), null);
                return "failure";
            }
        } catch (Exception e) {
            log.info("阿里支付回调异常：" + e);
            return "failure";
        }
    }

    @Override
    public String otoPayCallBack(ZhifbResult payParam) {
        String params = payParam.getPassback_params();
        if (params == null) {
            log.info("支付宝回调自定义参数为null");
            return "failure";
        }
        try {
            boolean res = otoPay(params, payParam.getTotal_amount(), 1);
            if (res) {
                insertOtoPayLog(1, 1, JSONUtil.toJsonStr(payParam), null);
                return "true";
            } else {
                insertOtoPayLog(1, 2, JSONUtil.toJsonStr(payParam), null);
                return "failure";
            }
        } catch (Exception e) {
            log.info("阿里支付回调异常：" + e);
            return "failure";
        }
    }


    @Override
    public String otoWechatPay(WechatParam wechatParam) {
        if (wechatParam.getAttach() == null) {
            return WechatResult.fail();
        }
        try {
            boolean res = otoPay(wechatParam.getAttach(),
                    new BigDecimal(wechatParam.getTotal_fee())
                            .divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP)
                            .toString(), 2);
            if (res) {
                insertOtoPayLog(1, 1, JSONUtil.toJsonStr(wechatParam), null);
                return WechatResult.success();
            } else {
                insertOtoPayLog(1, 2, JSONUtil.toJsonStr(wechatParam), null);
                return WechatResult.fail();
            }
        } catch (Exception e) {
            log.info("微信支付回调异常：" + e);
            return WechatResult.fail();
        }
    }

    /**
     * Oto 支付信息
     */
    private boolean otoPay(String attachUrlParams, String totalAmount, int payType) throws UnsupportedEncodingException {
        String attach = URLDecoder.decode(attachUrlParams, "UTF-8");
        log.info("OTO支付自定义参数{}", attach);
        List<NameValuePair> list = URLEncodedUtils.parse(attach, Charset.forName("UTF-8"));
        Long orderId = null;
        Integer type = null;
        Long paymentId = null;
        for (NameValuePair nameValuePair : list) {
            if (Objects.equals(nameValuePair.getName(), "orderId")) {
                orderId = Long.valueOf(nameValuePair.getValue());
            }
            if (Objects.equals(nameValuePair.getName(), "type")) {
                type = Integer.valueOf(nameValuePair.getValue());
            }
            if (Objects.equals(nameValuePair.getName(), "paymentId")) {
                paymentId = Long.valueOf(nameValuePair.getValue());
            }
        }
        if (type == null || (orderId == null && paymentId == null)) {
            log.info("自定义参数异常！");
            return false;
        }
        OtoOrderExample example = new OtoOrderExample();
        example.createCriteria().andIdEqualTo(orderId).andDeleteStatusEqualTo(0);
        List<OtoOrder> orderList = otoOrderMapper.selectByExample(example);
        if (orderList == null || orderList.size() == 0) {
            log.info("订单ID{}无效，或订单已被删除", orderId);
            return false;
        }
        OtoOrder otoOrder = orderList.get(0);
        if (!otoOrder.getStatus().equals(OrderStatus.PAY.getStatus())) {
            log.info("当前订单ID{}非待支付状态", orderId);
            return false;
        }

        if (type == 1) {
            //进行押金支付，更新订单为待审核
            otoOrder.setStatus(OrderStatus.WAITAUDIT.getStatus());
            otoOrder.setPaymentTime(new Date());
            otoOrder.setPayType(payType);
            otoOrderMapper.updateByPrimaryKeySelective(otoOrder);

            //插入订单操作记录
            insertOrderOperLog(orderId, "线上支付;本次支付金额："+ totalAmount);
            return true;
        } else if (type == 2) {
            //进行每期还款
            return otoPayEachMent(paymentId, otoOrder, totalAmount);
        } else {
            log.info("Type值{}无效", type);
            return false;
        }
    }

    /**
     * 进行每期还款
     *
     * @param paymentId
     */
    private boolean otoPayEachMent(Long paymentId, OtoOrder otoOrder, String totalAmount) {
        OtoOrderPayment orderPayment = otoOrderPaymentMapper.selectByPrimaryKey(paymentId);
        //检查本期是否是待还款状态
        if (OtoOrderStatus.PAY.getStatus() != orderPayment.getStatus() && 1 != orderPayment.getStatus()) {
            log.info("当前paymentID{}已经支付", paymentId);
            return false;
        }
        //结算本期
        orderPayment.setStatus(PaymentStatus.PAYED.getStatus());
        orderPayment.setRealPayTime(new Date());
        orderPayment.setRealPayMoney(new BigDecimal(totalAmount));
        otoOrderPaymentMapper.updateByPrimaryKeySelective(orderPayment);


        //设置下一期待支付
        OtoOrderPaymentExample example = new OtoOrderPaymentExample();
        example.createCriteria().andOrderIdEqualTo(otoOrder.getId())
                .andIdexEqualTo(orderPayment.getIdex() + 1);
        List<OtoOrderPayment> otoOrderPayments = otoOrderPaymentMapper.selectByExample(example);
        if (otoOrderPayments == null || otoOrderPayments.size() == 0) {
            //说明当前已经是最后一期了， 该订单已经结清
            otoOrder.setStatus(OrderStatus.PAYCOMPLETE.getStatus());
            otoOrderMapper.updateByPrimaryKeySelective(otoOrder);
        } else {
            //设置下一期待还
            OtoOrderPayment payment = otoOrderPayments.get(0);
            payment.setStatus(PaymentStatus.WAITPAY.getStatus());
            otoOrderPaymentMapper.updateByPrimaryKeySelective(payment);
            //设置主订单待支付信息
            otoOrder.setRentPayMoney(payment.getPayMoney());
            otoOrder.setRentPayTime(payment.getPayTime());
            otoOrder.setCurrPeriod(payment.getIdex());
            otoOrderMapper.updateByPrimaryKeySelective(otoOrder);
        }
        return true;
    }

    /**
     * 支付信息
     * @param attachUrlParams
     * @param totalAmount
     * @param payType 支付方式：1->支付宝 2->微信
     * @return
     * @throws UnsupportedEncodingException
     */
    private boolean pay(String attachUrlParams, String totalAmount, int payType) throws UnsupportedEncodingException {
        String attach = URLDecoder.decode(attachUrlParams, "UTF-8");
        log.info("自定义参数{}", attach);
        List<NameValuePair> list = URLEncodedUtils.parse(attach, Charset.forName("UTF-8"));
        Long orderId = null;
        Integer type = null;
        Long paymentId = null;
        for (NameValuePair nameValuePair : list) {
            if (Objects.equals(nameValuePair.getName(), "orderId")) {
                orderId = Long.valueOf(nameValuePair.getValue());
            }
            if (Objects.equals(nameValuePair.getName(), "type")) {
                type = Integer.valueOf(nameValuePair.getValue());
            }
            if (Objects.equals(nameValuePair.getName(), "paymentId")) {
                paymentId = Long.valueOf(nameValuePair.getValue());
            }
        }
        if (type == null || (orderId == null && paymentId == null)) {
            log.info("自定义参数异常！");
            return false;
        }
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdEqualTo(orderId).andDeleteStatusEqualTo(0);
        List<OmsOrder> orderList = orderMapper.selectByExample(example);
        if (orderList == null || orderList.size() == 0) {
            log.info("订单ID{}无效，或订单已被删除", orderId);
            return false;
        }
        OmsOrder omsOrder = orderList.get(0);
        if (!omsOrder.getStatus().equals(OrderStatus.PAY.getStatus())) {
            log.info("当前订单ID{}非待支付状态", orderId);
            return false;
        }

        if (type == 1) {
            //进行押金支付，更新订单为待审核
            omsOrder.setStatus(OrderStatus.WAITAUDIT.getStatus());
            omsOrder.setPaymentTime(new Date());
            omsOrder.setPayType(payType);
            orderMapper.updateByPrimaryKeySelective(omsOrder);

            //插入订单操作记录
            insertOrderOperLog(orderId, "线上支付;本次支付金额："+ totalAmount);
            return true;
        } else if (type == 2) {
            //进行每期还款
            return payEachMent(paymentId, omsOrder, totalAmount);
        } else {
            log.info("Type值{}无效", type);
            return false;
        }
    }

    /**
     * 进行每期还款
     *
     * @param paymentId
     * @param omsOrder
     */
    private boolean payEachMent(Long paymentId, OmsOrder omsOrder, String totalAmount) {
        OmsOrderPayment orderPayment = paymentMapper.selectByPrimaryKey(paymentId);
        //检查本期是否是待还款状态
        if (0 != orderPayment.getStatus() && 1 != orderPayment.getStatus()) {
            log.info("当前paymentID{}已经支付", paymentId);
            return false;
        }
        //结算本期
        orderPayment.setStatus(PaymentStatus.PAYED.getStatus());
        orderPayment.setRealPayTime(new Date());
        orderPayment.setRealPayMoney(new BigDecimal(totalAmount));
        paymentMapper.updateByPrimaryKeySelective(orderPayment);

        //设置下一期待支付
        OmsOrderPaymentExample example = new OmsOrderPaymentExample();
        example.createCriteria().andOrderIdEqualTo(omsOrder.getId())
                .andIdexEqualTo(orderPayment.getIdex() + 1);
        List<OmsOrderPayment> orderPayments = paymentMapper.selectByExample(example);
        if (orderPayments == null || orderPayments.size() == 0) {
            //说明当前已经是最后一期了， 该订单已经结清
            omsOrder.setStatus(OrderStatus.PAYCOMPLETE.getStatus());
            orderMapper.updateByPrimaryKeySelective(omsOrder);
        } else {
            //设置下一期待还
            OmsOrderPayment payment = orderPayments.get(0);
            payment.setStatus(PaymentStatus.WAITPAY.getStatus());
            paymentMapper.updateByPrimaryKeySelective(payment);
            //设置主订单待支付信息
            omsOrder.setRentPayMoney(payment.getPayMoney());
            omsOrder.setRentPayTime(payment.getPayTime());
            omsOrder.setCurrPeriod(payment.getIdex());
            orderMapper.updateByPrimaryKeySelective(omsOrder);
        }
        return true;
    }


    /**
     * 支付日志
     */
    private void insertOtoPayLog(int type, int status, String jsonPay, String problem) {
        OmsOrderPayLog log = new OmsOrderPayLog();
        log.setCreateTime(new Date());
        log.setStatus(status);
        log.setType(type);
        log.setProblem(problem);
        log.setPayDesc(jsonPay);
        omsOrderPayLogMapper.insertSelective(log);
    }

    /**
     * 支付日志
     */
    private void insertPayLog(int type, int status, String jsonPay, String problem) {
        OmsOrderPayLog log = new OmsOrderPayLog();
        log.setCreateTime(new Date());
        log.setStatus(status);
        log.setType(type);
        log.setProblem(problem);
        log.setPayDesc(jsonPay);
        omsOrderPayLogMapper.insertSelective(log);
    }

    /**
     * 订单支付操作记录
     */
    private void insertOrderOperLog(Long orderId, String note) {
        OmsOrderOperateHistory operateHistory = new OmsOrderOperateHistory();
        operateHistory.setOrderId(orderId);
        operateHistory.setOrderStatus(OrderStatus.WAITAUDIT.getStatus());
        operateHistory.setOperateType(OrderOperate.PAY.getOperateType());
        operateHistory.setContent(OrderOperate.PAY.getOperateContent());
        operateHistory.setNote(note);
        operateHistory.setOperateMan("系统");
        operateHistory.setCreateTime(new Date());
        operateHistoryMapper.insertSelective(operateHistory);
    }
}
