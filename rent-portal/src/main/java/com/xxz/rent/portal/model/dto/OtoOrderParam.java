package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-12 15:06
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Data
public class OtoOrderParam {

    @ApiModelProperty("发布到产品ID")
    @NotNull(message = "发布产品ID不能为空！")
    private Long id;
    @ApiModelProperty("期望的交易日期，为常见类型格式yyyy-MM-dd/yyyyMMdd等")
    @NotBlank(message = "交易日期不能为空！")
    private String tradeDate;
    @ApiModelProperty("交易方式，0->自提；1->邮寄")
    @Range(min = 0, max = 1, message = "交易方式值只能为【0，1】")
    private int tradeType;
    @Range(min = 0, message = "租赁时长必须大于0")
    @ApiModelProperty("租赁时长")
    private int period;
    @ApiModelProperty("订单备注")
    private String note;
    @ApiModelProperty("订单来源: 0->pc端;1->app端")
    private Integer sourceType;
}
