package com.xxz.rent.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class UmsMemberSetting implements Serializable {
    private Long id;

    @ApiModelProperty(value = "注册赠送积分")
    private Integer registIntegral;

    @ApiModelProperty(value = "会员初始化额度")
    private BigDecimal memberFreeAmount;

    @ApiModelProperty(value = "完成实名制提升额度")
    private BigDecimal realinformAmount;

    @ApiModelProperty(value = "完成基本信息提升额度")
    private BigDecimal baseinfoAmount;

    @ApiModelProperty(value = "完成亲属信息提升额度")
    private BigDecimal kinsfolkAmount;

    @ApiModelProperty(value = "完成联系人信息提升额度")
    private BigDecimal linkAmount;

    @ApiModelProperty(value = "完成淘宝信息提升额度")
    private BigDecimal taobaoAmount;

    @ApiModelProperty(value = "完成运营商提升额度")
    private BigDecimal mobileAmount;

    @ApiModelProperty(value = "完成学信网提升额度")
    private BigDecimal studyAmount;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRegistIntegral() {
        return registIntegral;
    }

    public void setRegistIntegral(Integer registIntegral) {
        this.registIntegral = registIntegral;
    }

    public BigDecimal getMemberFreeAmount() {
        return memberFreeAmount;
    }

    public void setMemberFreeAmount(BigDecimal memberFreeAmount) {
        this.memberFreeAmount = memberFreeAmount;
    }

    public BigDecimal getRealinformAmount() {
        return realinformAmount;
    }

    public void setRealinformAmount(BigDecimal realinformAmount) {
        this.realinformAmount = realinformAmount;
    }

    public BigDecimal getBaseinfoAmount() {
        return baseinfoAmount;
    }

    public void setBaseinfoAmount(BigDecimal baseinfoAmount) {
        this.baseinfoAmount = baseinfoAmount;
    }

    public BigDecimal getKinsfolkAmount() {
        return kinsfolkAmount;
    }

    public void setKinsfolkAmount(BigDecimal kinsfolkAmount) {
        this.kinsfolkAmount = kinsfolkAmount;
    }

    public BigDecimal getLinkAmount() {
        return linkAmount;
    }

    public void setLinkAmount(BigDecimal linkAmount) {
        this.linkAmount = linkAmount;
    }

    public BigDecimal getTaobaoAmount() {
        return taobaoAmount;
    }

    public void setTaobaoAmount(BigDecimal taobaoAmount) {
        this.taobaoAmount = taobaoAmount;
    }

    public BigDecimal getMobileAmount() {
        return mobileAmount;
    }

    public void setMobileAmount(BigDecimal mobileAmount) {
        this.mobileAmount = mobileAmount;
    }

    public BigDecimal getStudyAmount() {
        return studyAmount;
    }

    public void setStudyAmount(BigDecimal studyAmount) {
        this.studyAmount = studyAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", registIntegral=").append(registIntegral);
        sb.append(", memberFreeAmount=").append(memberFreeAmount);
        sb.append(", realinformAmount=").append(realinformAmount);
        sb.append(", baseinfoAmount=").append(baseinfoAmount);
        sb.append(", kinsfolkAmount=").append(kinsfolkAmount);
        sb.append(", linkAmount=").append(linkAmount);
        sb.append(", taobaoAmount=").append(taobaoAmount);
        sb.append(", mobileAmount=").append(mobileAmount);
        sb.append(", studyAmount=").append(studyAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}