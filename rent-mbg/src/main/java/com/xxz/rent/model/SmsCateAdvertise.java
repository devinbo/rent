package com.xxz.rent.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class SmsCateAdvertise implements Serializable {
    private Long id;

    @ApiModelProperty(value = "在指定分类下展示")
    private Long cateId;

    @ApiModelProperty(value = "分类名称")
    private String cateName;

    @ApiModelProperty(value = "广告名称")
    private String name;

    @ApiModelProperty(value = "宣传图片")
    private String pic;

    @ApiModelProperty(value = "广告类型  0->仅展示,无跳转动作 1->跳分类; 2->跳产品; 3->跳外链")
    private Integer linkType;

    @ApiModelProperty(value = "状态: 0->下线; 1->上线")
    private Integer status;

    @ApiModelProperty(value = "需要跳转至分类ID")
    private Long toCateId;

    @ApiModelProperty(value = "需要跳转至到产品ID")
    private Long toProductId;

    @ApiModelProperty(value = "外链地址")
    private String toUrl;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "截止时间")
    private Date endTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "默认广告  1->默认")
    private Integer defaultStatus;

    @ApiModelProperty(value = "广告备注")
    private String note;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getToCateId() {
        return toCateId;
    }

    public void setToCateId(Long toCateId) {
        this.toCateId = toCateId;
    }

    public Long getToProductId() {
        return toProductId;
    }

    public void setToProductId(Long toProductId) {
        this.toProductId = toProductId;
    }

    public String getToUrl() {
        return toUrl;
    }

    public void setToUrl(String toUrl) {
        this.toUrl = toUrl;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cateId=").append(cateId);
        sb.append(", cateName=").append(cateName);
        sb.append(", name=").append(name);
        sb.append(", pic=").append(pic);
        sb.append(", linkType=").append(linkType);
        sb.append(", status=").append(status);
        sb.append(", toCateId=").append(toCateId);
        sb.append(", toProductId=").append(toProductId);
        sb.append(", toUrl=").append(toUrl);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", defaultStatus=").append(defaultStatus);
        sb.append(", note=").append(note);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}