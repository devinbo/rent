package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-19 12:43
 * @description：订单申请结果
 * @modified By：
 * @version: ：1.0
 */
@Data
public class ApplyResult {

    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("订单待支付金额，如果为0表示无需进行支付")
    private BigDecimal payAmount;

}
