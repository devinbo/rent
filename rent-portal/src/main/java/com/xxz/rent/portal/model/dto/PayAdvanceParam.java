package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-19 19:46
 * @description：支付押金参数
 * @modified By：
 * @version: ：1.0
 */
@Data
public class PayAdvanceParam {

    @ApiModelProperty("订单ID")
    @NotNull(message = "订单ID不能为空")
    private Long orderId;
    @ApiModelProperty("支付类型； 0->支付宝； 1->微信")
    @Range(min = 0, max = 1, message = "支付类型只能为0，1")
    private Long type;

}
