package com.xxz.rent.dao;

import com.xxz.rent.dto.OmsOrderDeliveryParam;
import com.xxz.rent.dto.OmsOrderDetail;
import com.xxz.rent.dto.OmsOrderQueryParam;
import com.xxz.rent.model.OmsOrder;
import com.xxz.rent.dto.OmsOrderDeliveryParam;
import com.xxz.rent.dto.OmsOrderDetail;
import com.xxz.rent.dto.OmsOrderQueryParam;
import com.xxz.rent.model.OmsOrder;
import com.xxz.rent.model.OmsOrderItem;
import com.xxz.rent.model.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 * Created by macro on 2018/10/12.
 */
public interface OmsOrderDao {
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);

    /**  功能描述 <br>
     * <获取订单操作记录>
     *
     * @param orderId
     * @return java.util.List<com.xxz.rent.model.OmsOrderItem>
     * @date 2019-07-02 10:07
     */
    List<OmsOrderItem> getOrderOperate(@Param("id") Long orderId);

    /**  功能描述 <br>
     * <订单项信息>
     *
     * @param orderId
     * @return java.util.List<com.xxz.rent.model.OmsOrderOperateHistory>
     * @date 2019-07-02 10:52
     */
    List<OmsOrderOperateHistory> getOrderItemById(@Param("id") Long orderId);

    /**  功能描述 <br>
     * <结清订单>
     *
     * @param orderId
     * @return int
     * @date 2019-07-09 13:35
     */
    int overOrder(@Param("orderId") Long orderId);
}
