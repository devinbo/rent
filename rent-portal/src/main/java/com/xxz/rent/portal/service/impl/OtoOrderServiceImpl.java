package com.xxz.rent.portal.service.impl;

import cn.hutool.core.date.DateUtil;
import com.xxz.rent.dto.enumerate.OtoOrderStatus;
import com.xxz.rent.dto.enumerate.OtoProductStatus;
import com.xxz.rent.dto.enumerate.RentUnit;
import com.xxz.rent.mapper.OtoOrderMapper;
import com.xxz.rent.mapper.OtoOrderSettingMapper;
import com.xxz.rent.mapper.OtoProductMapper;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.bo.exception.BusinessLogicException;
import com.xxz.rent.portal.model.dto.OtoApplyResult;
import com.xxz.rent.portal.model.dto.OtoOrderParam;
import com.xxz.rent.portal.service.OtoOrderService;
import com.xxz.rent.portal.service.RedisService;
import com.xxz.rent.portal.service.UmsMemberService;
import com.xxz.rent.portal.util.PublicUtil;
import com.zengtengpeng.annotation.Lock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author ：xhb
 * @date ：Created in 2019-08-12 14:10
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class OtoOrderServiceImpl implements OtoOrderService {

    @Autowired
    private OtoProductMapper otoProductMapper;
    @Autowired
    private OtoOrderMapper otoOrderMapper;
    @Autowired
    private OtoOrderSettingMapper otoOrderSettingMapper;
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.orderId}")
    private String REDIS_KEY_PREFIX_ORDER_ID;
    @Value("redis:key:prefix:otoWaitPay")
    private String OTOWAITPAY;

    @Lock(keys = "'rent:portal:lock:' + #otoOrderParam.id")
    @Override
    public OtoApplyResult apply(OtoOrderParam otoOrderParam) {
        OtoProduct otoProduct = otoProductMapper.selectByPrimaryKey(otoOrderParam.getId());
        if (otoProduct == null) {
            throw new BusinessLogicException("发布产品ID不存在！");
        } else if (otoProduct.getStatus() == null || otoProduct.getStatus() != OtoProductStatus.PUBLISH.getStatus()) {
            throw new BusinessLogicException("无法申请该产品，该信息不是发布中状态！");
        }
        UmsMember umsMember = memberService.getCurrentMemberByDb();
        if (umsMember.getName() == null) {
            throw new BusinessLogicException("请先完成实名认证！");
        }

        OtoOrder otoOrder = new OtoOrder();
        otoOrder.setCreateTime(new Date());
        //设置产品信息
        otoOrder.setProductId(otoProduct.getId());
        otoOrder.setProductTitle(otoProduct.getTitle());
        otoOrder.setSignAmount(otoProduct.getProductPrice());
        otoOrder.setEachPrice(otoProduct.getRentEachPrice());
        //设置会员信息
        otoOrder.setMemberUsername(umsMember.getName());
        otoOrder.setMemberId(umsMember.getId());
        otoOrder.setMemberPhone(umsMember.getPhone());
        //设置交易信息
        otoOrder.setTradeDate(otoOrderParam.getTradeDate() != null ? DateUtil.parse(otoOrderParam.getTradeDate()) : null);
        otoOrder.setTradeType(otoOrderParam.getTradeType());
        //设置订单编号
        otoOrder.setOrderSn(generateOrderSn(otoOrder));
        otoOrder.setNote(otoOrderParam.getNote());
        otoOrder.setSourceType(otoOrderParam.getSourceType() == null ? 1 : otoOrderParam.getSourceType());


        //设置用户费用信息
        BigDecimal productPrice = otoProduct.getProductPrice() == null ? new BigDecimal(0) : otoProduct.getProductPrice();
        UmsMember member = memberService.getCurrentMemberByDb();
        BigDecimal freeMoney = member.getFreeMoney() == null ? new BigDecimal(0) : member.getFreeMoney();
        if (freeMoney.compareTo(productPrice) >= 0) {
            //说明会员额度够扣减，无需进行支付, 订单直接进入到审核阶段
            otoOrder.setUseFreeMoney(productPrice);
            otoOrder.setPayAmount(new BigDecimal(0));
            otoOrder.setStatus(OtoOrderStatus.WAITAUDIT.getStatus());
        } else {
            otoOrder.setPayAmount(productPrice.subtract(freeMoney));
            otoOrder.setStatus(OtoOrderStatus.PAY.getStatus());
            otoOrder.setPayType(0);

            //待支付订单，设置超时取消支付, 为设置时候，默认时间5分钟
            setCancelOrder(otoOrder);
        }
        //设置租金,租期信息
        otoOrder.setUnit(otoProduct.getRentUnit());
        otoOrder.setPeriods(otoOrderParam.getPeriod());

        //最少起租数
        int leastNum = otoProduct.getRentLeastNum() == null ? 0 : otoProduct.getRentLeastNum();
        if (otoOrderParam.getPeriod() < leastNum) {
            throw new BusinessLogicException("租期不能低于最短起租数！");
        }
        int maxPeriod = getMaxPeriod(otoProduct.getRentLatestDate(), otoProduct.getRentUnit());
        if (maxPeriod > leastNum && otoOrderParam.getPeriod() > maxPeriod) {
            throw new BusinessLogicException("租期不能高于最长租期");
        }

        //todo 优惠券暂不实现

        otoOrderMapper.insertSelective(otoOrder);
        //修改当前发布信息状态
        otoProduct.setStatus(OtoProductStatus.AWAITSIGN.getStatus());
        otoProductMapper.updateByPrimaryKeySelective(otoProduct);

        OtoApplyResult otoApplyResult = new OtoApplyResult();
        otoApplyResult.setOrderId(otoOrder.getId());
        otoApplyResult.setPayAmount(otoOrder.getPayAmount());
        return otoApplyResult;
    }

    private void setCancelOrder(OtoOrder otoOrder) {
        List<OtoOrderSetting> orderSettingList = otoOrderSettingMapper.selectByExample(new OtoOrderSettingExample());
        //默认超时为5分钟
        Integer overTime = 5;
        //从数据库加载设置信息
        if(orderSettingList != null && orderSettingList.size() > 0) {
            OtoOrderSetting orderSetting = orderSettingList.get(0);
            overTime = orderSetting.getNormalOrderOvertime();
        }
        redisService.setObj(OTOWAITPAY + otoOrder.getId(), 1, overTime * 60);
    }


    /**
     * 生成18位订单编号:8位日期+2位平台号码+2位支付方式+6位以上自增id
     */
    private String generateOrderSn(OtoOrder order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_KEY_PREFIX_ORDER_ID + date;
        Long increment = redisService.increment(key, 1);
        sb.append(date);
        sb.append(String.format("%02d", order.getSourceType() == null ? 1 : order.getSourceType()));
        String incrementStr = increment.toString();
        if (incrementStr.length() <= 6) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }

    private int getMaxPeriod(Date latestDate, int rentUnit) {
        Date nowDate = new Date();
        if (rentUnit == RentUnit.DAY.getValue()) {
            long betweenDay = DateUtil.betweenDay(nowDate, latestDate, true);
            return (int) betweenDay;
        } else if (rentUnit == RentUnit.WEEK.getValue()) {
            long betweenDay = DateUtil.betweenDay(nowDate, latestDate, true);
            return (int) betweenDay / 7;
        } else if (rentUnit == RentUnit.MONTH.getValue()) {
            long betweenMonth = DateUtil.betweenMonth(nowDate, latestDate, true);
            return (int) betweenMonth;
        } else if (rentUnit == RentUnit.YEAR.getValue()) {
            long betweenYear = DateUtil.betweenYear(nowDate, latestDate, true);
            return (int) betweenYear;
        }
        return 0;
    }
}
