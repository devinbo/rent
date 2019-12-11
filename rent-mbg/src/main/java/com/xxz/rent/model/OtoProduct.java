package com.xxz.rent.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OtoProduct implements Serializable {
    private Long id;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "分类ID")
    private Long categoryId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "详细描述")
    private String note;

    @ApiModelProperty(value = "标签；用逗号分隔")
    private String tags;

    @ApiModelProperty(value = "详情图片地址")
    private String albumPics;

    @ApiModelProperty(value = "首页图片")
    private String pic;

    @ApiModelProperty(value = "出租单位 0->日；1->周；2->月；3->年")
    private Integer rentUnit;

    @ApiModelProperty(value = "每期租金")
    private BigDecimal rentEachPrice;

    @ApiModelProperty(value = "最短起租数，单位同出租单位")
    private Integer rentLeastNum;

    @ApiModelProperty(value = "出租最迟归还日期")
    private Date rentLatestDate;

    @ApiModelProperty(value = "商品价值")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "创建日期")
    private Date createTime;

    @ApiModelProperty(value = "审核日期")
    private Date auditTime;

    @ApiModelProperty(value = "发布日期")
    private Date publishTime;

    @ApiModelProperty(value = "状态：0->待审核；1->发布中；2->待签约；3->签约中；4:->已完成；5->已拒绝")
    private Integer status;

    @ApiModelProperty(value = "优质推荐：0->不推荐；1->推荐")
    private Integer goodStatus;

    @ApiModelProperty(value = "产品所在站点")
    private Long siteId;

    @ApiModelProperty(value = "信誉保证：0->不保证；1->信誉保证")
    private Integer reliableStatus;

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "删除标示：0->未删； 1->已删")
    private Integer deleteStatus;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "留言次数")
    private Integer leaveNum;

    @ApiModelProperty(value = "浏览量")
    private Integer viewNum;

    @ApiModelProperty(value = "发布位置")
    private String publishSite;

    @ApiModelProperty(value = "会员手机号")
    private String memberPhone;

    @ApiModelProperty(value = "会员姓名")
    private String memberName;

    @ApiModelProperty(value = "会员昵称")
    private String memberNickname;

    @ApiModelProperty(value = "站点名称")
    private String siteName;

    @ApiModelProperty(value = "拒绝原因")
    private String refuseReason;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAlbumPics() {
        return albumPics;
    }

    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getRentUnit() {
        return rentUnit;
    }

    public void setRentUnit(Integer rentUnit) {
        this.rentUnit = rentUnit;
    }

    public BigDecimal getRentEachPrice() {
        return rentEachPrice;
    }

    public void setRentEachPrice(BigDecimal rentEachPrice) {
        this.rentEachPrice = rentEachPrice;
    }

    public Integer getRentLeastNum() {
        return rentLeastNum;
    }

    public void setRentLeastNum(Integer rentLeastNum) {
        this.rentLeastNum = rentLeastNum;
    }

    public Date getRentLatestDate() {
        return rentLatestDate;
    }

    public void setRentLatestDate(Date rentLatestDate) {
        this.rentLatestDate = rentLatestDate;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(Integer goodStatus) {
        this.goodStatus = goodStatus;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Integer getReliableStatus() {
        return reliableStatus;
    }

    public void setReliableStatus(Integer reliableStatus) {
        this.reliableStatus = reliableStatus;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getLeaveNum() {
        return leaveNum;
    }

    public void setLeaveNum(Integer leaveNum) {
        this.leaveNum = leaveNum;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public String getPublishSite() {
        return publishSite;
    }

    public void setPublishSite(String publishSite) {
        this.publishSite = publishSite;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", title=").append(title);
        sb.append(", note=").append(note);
        sb.append(", tags=").append(tags);
        sb.append(", albumPics=").append(albumPics);
        sb.append(", pic=").append(pic);
        sb.append(", rentUnit=").append(rentUnit);
        sb.append(", rentEachPrice=").append(rentEachPrice);
        sb.append(", rentLeastNum=").append(rentLeastNum);
        sb.append(", rentLatestDate=").append(rentLatestDate);
        sb.append(", productPrice=").append(productPrice);
        sb.append(", createTime=").append(createTime);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", status=").append(status);
        sb.append(", goodStatus=").append(goodStatus);
        sb.append(", siteId=").append(siteId);
        sb.append(", reliableStatus=").append(reliableStatus);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", sort=").append(sort);
        sb.append(", leaveNum=").append(leaveNum);
        sb.append(", viewNum=").append(viewNum);
        sb.append(", publishSite=").append(publishSite);
        sb.append(", memberPhone=").append(memberPhone);
        sb.append(", memberName=").append(memberName);
        sb.append(", memberNickname=").append(memberNickname);
        sb.append(", siteName=").append(siteName);
        sb.append(", refuseReason=").append(refuseReason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}