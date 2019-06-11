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
 * Created by macro on 2018/10/11.
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    private List<OmsOrderOperateHistory> historyList;
}
