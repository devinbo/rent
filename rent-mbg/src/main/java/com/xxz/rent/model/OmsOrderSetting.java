package com.xxz.rent.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class OmsOrderSetting implements Serializable {
    private Long id;

    @ApiModelProperty(value = "正常订单超时时间(分)")
    private Integer normalOrderOvertime;

    @ApiModelProperty(value = "每期租金赠送积分 （千分之）")
    private Integer paymentIntegral;

    @ApiModelProperty(value = "订单逾期费率（万分之）")
    private Integer overdueRate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNormalOrderOvertime() {
        return normalOrderOvertime;
    }

    public void setNormalOrderOvertime(Integer normalOrderOvertime) {
        this.normalOrderOvertime = normalOrderOvertime;
    }

    public Integer getPaymentIntegral() {
        return paymentIntegral;
    }

    public void setPaymentIntegral(Integer paymentIntegral) {
        this.paymentIntegral = paymentIntegral;
    }

    public Integer getOverdueRate() {
        return overdueRate;
    }

    public void setOverdueRate(Integer overdueRate) {
        this.overdueRate = overdueRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", normalOrderOvertime=").append(normalOrderOvertime);
        sb.append(", paymentIntegral=").append(paymentIntegral);
        sb.append(", overdueRate=").append(overdueRate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}