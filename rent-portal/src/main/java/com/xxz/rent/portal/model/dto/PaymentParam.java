package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-19 19:46
 * @description：支付租金参数
 * @modified By：
 * @version: ：1.0
 */
@Data
public class PaymentParam {

    @ApiModelProperty("账单ID")
    @NotNull(message = "账单ID不能为空")
    private Long paymentId;
    @ApiModelProperty("支付类型； 0->支付宝； 1->微信")
    @Range(min = 0, max = 1, message = "支付类型只能为0，1")
    private Long type;

}
