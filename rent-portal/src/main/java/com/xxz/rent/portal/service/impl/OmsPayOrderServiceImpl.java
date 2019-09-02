package com.xxz.rent.portal.service.impl;

import com.xxz.rent.dto.enumerate.OrderStatus;
import com.xxz.rent.mapper.OmsOrderMapper;
import com.xxz.rent.mapper.OmsOrderPaymentMapper;
import com.xxz.rent.mapper.OtoOrderMapper;
import com.xxz.rent.mapper.OtoOrderPaymentMapper;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.model.dto.PayAdvanceParam;
import com.xxz.rent.portal.service.OmsPayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-22 10:25
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class OmsPayOrderServiceImpl implements OmsPayOrderService {

    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OtoOrderMapper otoOrderMapper;
    @Autowired
    private OmsOrderPaymentMapper orderPaymentMapper;
    @Autowired
    private OtoOrderPaymentMapper otoOrderPaymentMapper;

    @Override
    public OmsOrder getOrderAdvanceInfo(PayAdvanceParam payAdvanceParam) {
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdEqualTo(payAdvanceParam.getOrderId())
                .andDeleteStatusEqualTo(0);
        List<OmsOrder> omsOrderList = orderMapper.selectByExample(example);
        if(omsOrderList == null || omsOrderList.size() == 0) {
            return null;
        }
        return omsOrderList.get(0);
    }

    @Override
    public OmsOrderPayment payment(Long paymentId) {
        OmsOrderPayment payment = orderPaymentMapper.selectByPrimaryKey(paymentId);
        return payment;
    }

    @Override
    public OtoOrder getOtoOrderAdvanceInfo(PayAdvanceParam payAdvanceParam) {
        OtoOrderExample example = new OtoOrderExample();
        example.createCriteria().andIdEqualTo(payAdvanceParam.getOrderId())
                .andDeleteStatusEqualTo(0);
        List<OtoOrder> otoOrderList = otoOrderMapper.selectByExample(example);
        if(otoOrderList == null || otoOrderList.size() == 0) {
            return null;
        }
        return otoOrderList.get(0);
    }

    @Override
    public OtoOrderPayment otoPayment(Long paymentId) {
        OtoOrderPayment otoOrderPayment = otoOrderPaymentMapper.selectByPrimaryKey(paymentId);
        return otoOrderPayment;
    }
}
