package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.OmsOrder;
import lombok.Getter;
import lombok.Setter;


/**
 * @author ：xhb
 * @date ：Created in 2019-07-23 14:38
 * @description：订单列表结果集
 * @modified By：
 * @version: ：1.0
 */
public class OmsOrderResult extends OmsOrder {

    @Getter
    @Setter
    private String productName;
    @Setter
    @Getter
    private String productPic;
    @Getter
    @Setter
    private String productAttr;
}
