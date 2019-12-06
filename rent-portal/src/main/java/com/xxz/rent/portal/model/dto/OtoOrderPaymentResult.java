package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.OtoOrderPayment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-26 08:58
 * @description：租金及其产品明细
 * @modified By：
 * @version: ：1.0
 */
@Data
public class OtoOrderPaymentResult {

    @ApiModelProperty("产品标题")
    private String productTitle;

    @ApiModelProperty("订单状态")
    private Integer status;

    @ApiModelProperty("订单编号")
    private Integer orderSn;

    @ApiModelProperty(value = "提交时间")
    private Date createTime;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "用户姓名")
    private String memberUsername;

    @ApiModelProperty(value = "会员手机号")
    private String memberPhone;

    @ApiModelProperty(value = "当前待支付金额")
    private BigDecimal rentPayMoney;

    @ApiModelProperty(value = "待支付租金时间")
    private Date rentPayTime;

    @ApiModelProperty(value = "每期租金")
    private BigDecimal eachPrice;

    @ApiModelProperty(value = "当前期数/第几期")
    private Integer currPeriod;

    @ApiModelProperty(value = "商品金额/签约金额")
    private BigDecimal signAmount;

    @ApiModelProperty(value = "产品图片")
    private String pic;

    @ApiModelProperty("订单租金列表")
    private List<OtoOrderPayment> otoOrderPaymentList;


}
