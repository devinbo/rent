package com.xxz.rent.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UmsMemberAuthRelation implements Serializable {
    private Long id;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "身份证认证状态 0->尚未认证  1->已通过 2->未通过")
    private Integer identityStatus;

    @ApiModelProperty(value = "基本资料认证 0->尚未认证  1->已通过 2->未通过  3->待审核")
    private Integer baseinfoStatus;

    @ApiModelProperty(value = "亲属认证 0->尚未认证  1->已通过 2->未通过  3->待审核")
    private Integer kinsfolkStatus;

    @ApiModelProperty(value = "联系人认证 0->尚未认证  1->已通过 2->未通过  3->待审核")
    private Integer linkStatus;

    @ApiModelProperty(value = "运营商认证 0->尚未认证  1->已通过 2->未通过  3->待审核")
    private Integer mobileStatus;

    @ApiModelProperty(value = "淘宝认证 0->尚未认证  1->已通过 2->未通过  3->待审核")
    private Integer taobaoStatus;

    @ApiModelProperty(value = "学信网认证 0->尚未认证  1->已通过 2->未通过  3->待审核")
    private Integer studyStatus;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getIdentityStatus() {
        return identityStatus;
    }

    public void setIdentityStatus(Integer identityStatus) {
        this.identityStatus = identityStatus;
    }

    public Integer getBaseinfoStatus() {
        return baseinfoStatus;
    }

    public void setBaseinfoStatus(Integer baseinfoStatus) {
        this.baseinfoStatus = baseinfoStatus;
    }

    public Integer getKinsfolkStatus() {
        return kinsfolkStatus;
    }

    public void setKinsfolkStatus(Integer kinsfolkStatus) {
        this.kinsfolkStatus = kinsfolkStatus;
    }

    public Integer getLinkStatus() {
        return linkStatus;
    }

    public void setLinkStatus(Integer linkStatus) {
        this.linkStatus = linkStatus;
    }

    public Integer getMobileStatus() {
        return mobileStatus;
    }

    public void setMobileStatus(Integer mobileStatus) {
        this.mobileStatus = mobileStatus;
    }

    public Integer getTaobaoStatus() {
        return taobaoStatus;
    }

    public void setTaobaoStatus(Integer taobaoStatus) {
        this.taobaoStatus = taobaoStatus;
    }

    public Integer getStudyStatus() {
        return studyStatus;
    }

    public void setStudyStatus(Integer studyStatus) {
        this.studyStatus = studyStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", identityStatus=").append(identityStatus);
        sb.append(", baseinfoStatus=").append(baseinfoStatus);
        sb.append(", kinsfolkStatus=").append(kinsfolkStatus);
        sb.append(", linkStatus=").append(linkStatus);
        sb.append(", mobileStatus=").append(mobileStatus);
        sb.append(", taobaoStatus=").append(taobaoStatus);
        sb.append(", studyStatus=").append(studyStatus);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}