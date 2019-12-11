package com.xxz.rent.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OmsOrderPayment implements Serializable {
    private Long id;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "状态：0->待支付；1->逾期；2->已支付； 3:尚未开始")
    private Integer status;

    @ApiModelProperty(value = "应支付费用")
    private BigDecimal payMoney;

    @ApiModelProperty(value = "实际支付费用")
    private BigDecimal realPayMoney;

    @ApiModelProperty(value = "每期基本费用")
    private BigDecimal baseMoney;

    @ApiModelProperty(value = "活动优惠金额")
    private BigDecimal preferentialMoney;

    @ApiModelProperty(value = "应付款时间")
    private Date payTime;

    @ApiModelProperty(value = "实际付款时间")
    private Date realPayTime;

    @ApiModelProperty(value = "第几期")
    private Integer idex;

    @ApiModelProperty(value = "逾期费用")
    private BigDecimal overdueMoney;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public BigDecimal getRealPayMoney() {
        return realPayMoney;
    }

    public void setRealPayMoney(BigDecimal realPayMoney) {
        this.realPayMoney = realPayMoney;
    }

    public BigDecimal getBaseMoney() {
        return baseMoney;
    }

    public void setBaseMoney(BigDecimal baseMoney) {
        this.baseMoney = baseMoney;
    }

    public BigDecimal getPreferentialMoney() {
        return preferentialMoney;
    }

    public void setPreferentialMoney(BigDecimal preferentialMoney) {
        this.preferentialMoney = preferentialMoney;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getRealPayTime() {
        return realPayTime;
    }

    public void setRealPayTime(Date realPayTime) {
        this.realPayTime = realPayTime;
    }

    public Integer getIdex() {
        return idex;
    }

    public void setIdex(Integer idex) {
        this.idex = idex;
    }

    public BigDecimal getOverdueMoney() {
        return overdueMoney;
    }

    public void setOverdueMoney(BigDecimal overdueMoney) {
        this.overdueMoney = overdueMoney;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", status=").append(status);
        sb.append(", payMoney=").append(payMoney);
        sb.append(", realPayMoney=").append(realPayMoney);
        sb.append(", baseMoney=").append(baseMoney);
        sb.append(", preferentialMoney=").append(preferentialMoney);
        sb.append(", payTime=").append(payTime);
        sb.append(", realPayTime=").append(realPayTime);
        sb.append(", idex=").append(idex);
        sb.append(", overdueMoney=").append(overdueMoney);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}