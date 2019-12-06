package com.xxz.rent.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.page.PageParams;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.enumerate.OrderStatus;
import com.xxz.rent.mapper.*;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.bo.exception.BusinessLogicException;
import com.xxz.rent.portal.component.CancelOrderSender;
import com.xxz.rent.portal.dao.OmsOrderDao;
import com.xxz.rent.portal.dao.PortalOrderDao;
import com.xxz.rent.portal.dao.PortalOrderItemDao;
import com.xxz.rent.portal.dao.SmsCouponHistoryDao;
import com.xxz.rent.portal.model.dto.*;
import com.xxz.rent.portal.service.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 前台订单管理Service
 *
 * @author xxz
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private OmsOrderDao orderDao;
    @Autowired
    private OmsOrderPaymentMapper orderPaymentMapper;

    @Override
    public List<OmsOrderResult> list(int status, int pageNum, int pageSize) {
        UmsMember member = memberService.getCurrentMember();
        PageHelper.startPage(pageNum, pageSize);
        List<OmsOrderResult> omsOrderResults = orderDao.list(status, member.getId());
        return omsOrderResults;
    }

    @Override
    public OmsOrderResult getOrderDetail(Long id) {
        UmsMember member = memberService.getCurrentMember();
        OmsOrderResult omsOrderResult = orderDao.getOrderDetail(id, member.getId());
        return omsOrderResult;
    }

    @Override
    public List<OmsOrderPayment> getOrderBills(Long orderId) {
        OmsOrderPaymentExample example = new OmsOrderPaymentExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<OmsOrderPayment> orderPaymentList = orderPaymentMapper.selectByExample(example);
        //定义一个排列规则
        List<Integer> regulation = Arrays.asList(new Integer[]{0, 1, 3, 2});
        Collections.sort(orderPaymentList, new Comparator<OmsOrderPayment>() {
            @Override
            public int compare(OmsOrderPayment o1, OmsOrderPayment o2) {
                return regulation.indexOf(o1.getStatus()) - regulation.indexOf(o2.getStatus());
            }
        });
        return orderPaymentList;
    }

    @Override
    public int cancel(Long id) {
        OmsOrder omsOrder = orderMapper.selectByPrimaryKey(id);
        if(omsOrder == null) {
            throw new BusinessLogicException("无效订单");
        }
        Assert.isTrue(omsOrder.getStatus() == OrderStatus.PAY.getStatus(), "该订单无法取消");
        omsOrder.setStatus(OrderStatus.CANCEL.getStatus());
        return orderMapper.updateByPrimaryKeySelective(omsOrder);
    }

    @Override
    public int delete(Long id) {
        OmsOrder omsOrder = orderMapper.selectByPrimaryKey(id);
        if(omsOrder == null) {
            throw new BusinessLogicException("无效订单");
        }
        Assert.isTrue(omsOrder.getStatus() == OrderStatus.CANCEL.getStatus(), "该订单无法删除");
        omsOrder.setDeleteStatus(1);
        return orderMapper.updateByPrimaryKeySelective(omsOrder);
    }


}
