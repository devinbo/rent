package com.xxz.rent.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class OtoOrderSetting implements Serializable {
    private Long id;

    @ApiModelProperty(value = "支付超时自动取消时间")
    private Integer normalOrderOvertime;

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
        sb.append(", overdueRate=").append(overdueRate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}