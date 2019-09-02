package com.xxz.rent.portal.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xxz.rent.model.SmsCoupon;
import com.xxz.rent.model.UmsMemberReceiveAddress;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-18 15:04
 * @description：待确认申请结果集
 * @modified By：
 * @version: ：1.0
 */
@Data
public class PreOrderResult {

    @ApiModelProperty("产品ID")
    private Long productId;
    @ApiModelProperty("产品SKUID")
    private Long SkuId;
    @ApiModelProperty("收获地址信息")
    private UmsMemberReceiveAddress address;
    @ApiModelProperty("产品图片")
    private String pic;
    @ApiModelProperty("产品名称")
    private String name;
    @ApiModelProperty("产品属性")
    private String sp;
    @ApiModelProperty("产品签约价")
    private BigDecimal price;
    @ApiModelProperty("产品每期价格")
    private BigDecimal eachPrice;
    @ApiModelProperty("产品首期价格")
    private BigDecimal firstIssuePrice;
    @ApiModelProperty("产品租期")
    private Integer period;
    @ApiModelProperty("租期单位； 0->日；1->周；2->月；3->年")
    private Integer unit;
    @ApiModelProperty("产品参与优惠活动类型； 0->无优惠；1->首期租金减免；2->免押金")
    private Integer promotionType;
    @ApiModelProperty("运费； 值为null，0请标示为免押金； 目前流程都是免押金")
    private BigDecimal freight;
    @ApiModelProperty("押金, 值为0时，确认申请成功之后，无需进行支付操作")
    private BigDecimal advanceMoney;

    @ApiModelProperty("可用优惠券信息")
    private List<CouponUseInfo> couponList;
    @ApiModelProperty("当前客户免押额度")
    private BigDecimal freeDecimal;


    @JsonIgnore
    private BigDecimal firstEachPriceSub;


    public static class CouponUseInfo {

        private Long id;
        private String name;
        private BigDecimal amount;
        private BigDecimal minPoint;
        private Date startTime;
        private Date endTime;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public BigDecimal getMinPoint() {
            return minPoint;
        }

        public void setMinPoint(BigDecimal minPoint) {
            this.minPoint = minPoint;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }
    }

}
