package com.xxz.rent.service.impl;

import cn.hutool.core.date.DateUtil;
import com.xxz.rent.dao.OmsOrderPaymentDao;
import com.xxz.rent.dto.enumerate.OrderOperate;
import com.xxz.rent.dto.enumerate.OrderStatus;
import com.xxz.rent.dto.enumerate.PaymentStatus;
import com.xxz.rent.mapper.OmsOrderPaymentMapper;
import com.xxz.rent.model.OmsOrder;
import com.xxz.rent.model.OmsOrderPayment;
import com.xxz.rent.model.OmsOrderPaymentExample;
import com.xxz.rent.service.OmsOrderPaymentService;
import com.xxz.rent.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-08 16:19
 * @description：费用信息
 * @modified By：
 * @version: ：1.0
 */
@Service
public class OmsOrderPaymentServiceImpl implements OmsOrderPaymentService {

    @Autowired
    private OmsOrderPaymentMapper orderPaymentMapper;

    @Autowired
    private OmsOrderPaymentDao orderPaymentDao;

    @Autowired
    private OmsOrderService omsOrderService;


    @Override
    public List<OmsOrderPayment> list(Long orderId) {
        OmsOrderPaymentExample example = new OmsOrderPaymentExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        return orderPaymentMapper.selectByExample(example);
    }

    @Override
    public int completePayment(Long id, String realPayTime, Integer completeType) {
        OmsOrderPayment orderPayment = orderPaymentMapper.selectByPrimaryKey(id);
        orderPayment.setRealPayTime(DateUtil.parseDate(realPayTime).toJdkDate());
        orderPayment.setRealPayMoney(orderPayment.getPayMoney());
        orderPayment.setStatus(PaymentStatus.PAYED.getStatus());
        int count = orderPaymentMapper.updateByPrimaryKeySelective(orderPayment);
        //获取下一期信息
        OmsOrderPayment payment = orderPaymentDao.getNextPayment(id);
        if(payment == null) {
            //说明当前是最后一起， 进行订单结算操作
            int c = omsOrderService.overOrder(orderPayment.getOrderId(), completeType);
            Assert.isTrue(c != 0, "操作失败");
        }else{
            //设置下一期待支付
            OmsOrderPayment nextOrderPayment = orderPaymentMapper.selectByPrimaryKey(id + 1);
            nextOrderPayment.setStatus(PaymentStatus.WAITPAY.getStatus());
            orderPaymentMapper.updateByPrimaryKeySelective(nextOrderPayment);

            //设置订单待还为下一期待信息
            OmsOrder omsOrder = new OmsOrder();
            omsOrder.setRentPayTime(nextOrderPayment.getPayTime());
            omsOrder.setRentPayMoney(nextOrderPayment.getPayMoney());

        }
        //添加操作记录
        omsOrderService.insertOrderOperate(orderPayment.getOrderId(),
                OrderStatus.SIGNING.getStatus(), OrderOperate.BALANCE, "结算第" + orderPayment.getIdex() + "期租金");
        return count;
    }


}
