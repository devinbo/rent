package com.xxz.rent.service;

import com.xxz.rent.dto.*;
import com.xxz.rent.dto.enumerate.OrderOperate;
import com.xxz.rent.model.OmsOrder;
import com.xxz.rent.model.OmsOrderOperateHistory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单管理Service
 * Created by macro on 2018/10/11.
 */
@Transactional
public interface OmsOrderService {
    /**
     * 订单查询
     */
    List<OmsOrder> list(OmsOrderQueryParam queryParam, PageParam pageParam);

    /**
     * 批量发货
     */
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 批量关闭订单
     */
    int close(List<Long> ids, String note);

    /**
     * 批量删除订单
     */
    int delete(List<Long> ids);

    /**
     * 获取指定订单详情
     */
    OmsOrderDetail detail(Long id);

    /**
     * 修改订单收货人信息
     */
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    /**
     * 修改订单费用信息
     */
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    /**
     * 修改订单备注
     */
    int updateNote(Long id, String note, Integer status);

    /**  功能描述 <br>
     * <查询订单操作记录>
     *
     * @param id
     * @param pageParam
     * @return java.util.List<com.xxz.rent.model.OmsOrderOperateHistory>
     * @date 2019-07-04 11:16
     */
    List<OmsOrderOperateHistory> getOperateList(Long id, PageParam pageParam);

    /**  功能描述 <br>
     * <订单审核>
     *
     * @param id
     * @param auditParam
     * @return int
     * @date 2019-07-08 11:35
     */
    int auditOrder(Long id, OmsOrderAuditParam auditParam);

    /**  功能描述 <br>
     * <开始签约订单>
     *
     * @param id
     * @return int
     * @date 2019-07-08 13:55
     */
    int signOrder(Long id, String start_time, String file);

    /**  功能描述 <br>
     * <结清订单 - 完结该订单>
     *
     * @param orderId
     * @param completeType 结算类型1-》买断 2-》归还
     * @return int
     * @date 2019-07-09 13:31
     */
    int overOrder(Long orderId, Integer completeType);

    /**  功能描述 <br>
     * <操作记录>
     *
     * @param orderId
     * @param orderStatus
     * @param orderOperate
     * @param note
     * @return void
     * @date 2019-07-09 15:20
     */
    void insertOrderOperate(Long orderId, int orderStatus, OrderOperate orderOperate, String note);

    /**  功能描述 <br>
     * <买断>
     *
     * @param id
     * @param note
     * @return int
     * @date 2019-07-09 17:01
     */
    int buyOrder(Long id, String note);

    /**  功能描述 <br>
     * <归还>
     *
     * @param id
     * @param note
     * @return int
     * @date 2019-07-09 17:01
     */
    int backOrder(Long id, String note);
}
