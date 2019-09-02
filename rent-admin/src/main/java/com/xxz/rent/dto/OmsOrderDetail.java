package com.xxz.rent.dto;

import com.xxz.rent.model.OmsOrder;
import com.xxz.rent.model.OmsOrderItem;
import com.xxz.rent.model.OmsOrderOperateHistory;
import com.xxz.rent.model.OmsOrder;
import com.xxz.rent.model.OmsOrderItem;
import com.xxz.rent.model.OmsOrderOperateHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 *
 * @author xxz
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    private OmsOrderItem orderItem;
    @Getter
    @Setter
    private UmsMemberResult member;
}
