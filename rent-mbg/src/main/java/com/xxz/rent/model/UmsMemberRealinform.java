package com.xxz.rent.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UmsMemberRealinform implements Serializable {
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "身份证号")
    private String identificationNumber;

    @ApiModelProperty(value = "性别：0->未知；1->男；2->女")
    private Integer sex;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "名族")
    private String ethnicGroup;

    @ApiModelProperty(value = "人脸照")
    private String facePic;

    @ApiModelProperty(value = "身份证正面")
    private String idCardBackPic;

    @ApiModelProperty(value = "身份证反面")
    private String idCardFrontPic;

    @ApiModelProperty(value = "身份证有效期截止日期")
    private String idCardExpiry;

    @ApiModelProperty(value = "身份证有效期开始日期")
    private Date idCardStartDate;

    @ApiModelProperty(value = "现居住地址")
    private String currentAddress;

    @ApiModelProperty(value = "公司地址")
    private String companyAddress;

    @ApiModelProperty(value = "银行卡照片")
    private String bankcardPic;

    @ApiModelProperty(value = "芝麻分视频")
    private String zmfVideo;

    @ApiModelProperty(value = "工作证/学生证")
    private String staffPic;

    @ApiModelProperty(value = "所在学校")
    private String school;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "客户类型 0->学生； 1->成人")
    private Integer memberType;

    @ApiModelProperty(value = "月收入")
    private BigDecimal monthIncome;

    @ApiModelProperty(value = "月消费")
    private BigDecimal monthConsume;

    private static final long serialVersionUID = 1L;

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

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEthnicGroup() {
        return ethnicGroup;
    }

    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

    public String getFacePic() {
        return facePic;
    }

    public void setFacePic(String facePic) {
        this.facePic = facePic;
    }

    public String getIdCardBackPic() {
        return idCardBackPic;
    }

    public void setIdCardBackPic(String idCardBackPic) {
        this.idCardBackPic = idCardBackPic;
    }

    public String getIdCardFrontPic() {
        return idCardFrontPic;
    }

    public void setIdCardFrontPic(String idCardFrontPic) {
        this.idCardFrontPic = idCardFrontPic;
    }

    public String getIdCardExpiry() {
        return idCardExpiry;
    }

    public void setIdCardExpiry(String idCardExpiry) {
        this.idCardExpiry = idCardExpiry;
    }

    public Date getIdCardStartDate() {
        return idCardStartDate;
    }

    public void setIdCardStartDate(Date idCardStartDate) {
        this.idCardStartDate = idCardStartDate;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getBankcardPic() {
        return bankcardPic;
    }

    public void setBankcardPic(String bankcardPic) {
        this.bankcardPic = bankcardPic;
    }

    public String getZmfVideo() {
        return zmfVideo;
    }

    public void setZmfVideo(String zmfVideo) {
        this.zmfVideo = zmfVideo;
    }

    public String getStaffPic() {
        return staffPic;
    }

    public void setStaffPic(String staffPic) {
        this.staffPic = staffPic;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public BigDecimal getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(BigDecimal monthIncome) {
        this.monthIncome = monthIncome;
    }

    public BigDecimal getMonthConsume() {
        return monthConsume;
    }

    public void setMonthConsume(BigDecimal monthConsume) {
        this.monthConsume = monthConsume;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", identificationNumber=").append(identificationNumber);
        sb.append(", sex=").append(sex);
        sb.append(", address=").append(address);
        sb.append(", ethnicGroup=").append(ethnicGroup);
        sb.append(", facePic=").append(facePic);
        sb.append(", idCardBackPic=").append(idCardBackPic);
        sb.append(", idCardFrontPic=").append(idCardFrontPic);
        sb.append(", idCardExpiry=").append(idCardExpiry);
        sb.append(", idCardStartDate=").append(idCardStartDate);
        sb.append(", currentAddress=").append(currentAddress);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", bankcardPic=").append(bankcardPic);
        sb.append(", zmfVideo=").append(zmfVideo);
        sb.append(", staffPic=").append(staffPic);
        sb.append(", school=").append(school);
        sb.append(", memberId=").append(memberId);
        sb.append(", memberType=").append(memberType);
        sb.append(", monthIncome=").append(monthIncome);
        sb.append(", monthConsume=").append(monthConsume);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}