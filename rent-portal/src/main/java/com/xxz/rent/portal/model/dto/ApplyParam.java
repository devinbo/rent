package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-19 11:21
 * @description：订单申请参数
 * @modified By：
 * @version: ：1.0
 */
@Data
public class ApplyParam {

    @NotBlank(message = "SKUID不能为空")
    @ApiModelProperty(value = "选中的产品SKUID", example = "174")
    private Long skuId;
    @ApiModelProperty(value = "使用的优惠券ID")
    private Long couponId;
    @ApiModelProperty("请求备注")
    private String note;
    @NotBlank(message = "收货人ID不能为空")
    @ApiModelProperty(value = "收货人ID", example = "1")
    private Long receiverId;
}
