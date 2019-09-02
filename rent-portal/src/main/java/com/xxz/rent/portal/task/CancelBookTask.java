package com.xxz.rent.portal.task;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.enumerate.OrderStatus;
import com.xxz.rent.dto.enumerate.OtoOrderStatus;
import com.xxz.rent.mapper.OmsOrderMapper;
import com.xxz.rent.mapper.OtoOrderMapper;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.model.dto.OmsOrderDetail;
import com.xxz.rent.portal.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-19 15:15
 * @description：取消超时未支付押金的订单
 * @modified By：
 * @version: ：1.0
 */
@Transactional
@Component
@Slf4j
public class CancelBookTask extends KeyExpirationEventMessageListener {

    @Autowired
    private RedisService redisService;
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OtoOrderMapper otoOrderMapper;

    @Value("redis:key:prefix:waitPay")
    private String WAITPAY;
    @Value("redis:key:prefix:otoWaitPay")
    private String OTOWAITPAY;

    public CancelBookTask(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 监听redis中key的失效
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String key = message.toString();
        if(key.startsWith(WAITPAY)) {
            String id = key.substring(WAITPAY.length());
            log.info("开始取消超时未支付订单：" + id);
            cancelBook(id);
        }else if(key.startsWith(OTOWAITPAY)) {
            String id = key.substring(OTOWAITPAY.length());
            log.info("开始取消OTO超时为支付订单：" + id);
            cancelOtoBook(id);
        }
    }


    private void cancelBook(String id) {
        Long orderId = Long.valueOf(id);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdEqualTo(orderId).andDeleteStatusEqualTo(0)
                .andStatusEqualTo(OrderStatus.PAY.getStatus());
        List<OmsOrder> omsOrders = orderMapper.selectByExample(example);
        if(omsOrders != null && omsOrders.size() > 0) {
            OmsOrder omsOrder = omsOrders.get(0);
            omsOrder.setStatus(OrderStatus.CANCEL.getStatus());
            orderMapper.updateByPrimaryKeySelective(omsOrder);
        }
    }

    private void cancelOtoBook(String id) {
        Long orderId = Long.valueOf(id);
        OtoOrderExample example = new OtoOrderExample();
        example.createCriteria().andIdEqualTo(orderId).andDeleteStatusEqualTo(0)
                .andStatusEqualTo(OtoOrderStatus.PAY.getStatus());
        List<OtoOrder> otoOrderList = otoOrderMapper.selectByExample(example);
        if(!CollUtil.isEmpty(otoOrderList)) {
            OtoOrder otoOrder = otoOrderList.get(0);
            otoOrder.setStatus(OtoOrderStatus.CANCEL.getStatus());
            otoOrderMapper.updateByPrimaryKeySelective(otoOrder);
        }
    }
}
