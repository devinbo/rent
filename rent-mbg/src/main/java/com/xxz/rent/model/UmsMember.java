package com.xxz.rent.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UmsMember implements Serializable {
    private Long id;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "帐号启用状态:0->禁用；1->启用")
    private Integer status;

    @ApiModelProperty(value = "注册时间")
    private Date createTime;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "性别：0->未知；1->男；2->女")
    private Integer gender;

    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "所做城市")
    private String city;

    @ApiModelProperty(value = "职业")
    private String job;

    @ApiModelProperty(value = "个性签名")
    private String personalizedSignature;

    @ApiModelProperty(value = "用户注册来源 0->安卓; 1->ios; 2->pc 3->微信小程序")
    private Integer sourceType;

    @ApiModelProperty(value = "积分")
    private Integer integration;

    @ApiModelProperty(value = "成长值")
    private Integer growth;

    @ApiModelProperty(value = "历史积分数量")
    private Integer historyIntegration;

    @ApiModelProperty(value = "自营订单数量")
    private Integer orderCount;

    @ApiModelProperty(value = "个人出租总数")
    private Integer rentCount;

    @ApiModelProperty(value = "个人租用总数")
    private Integer hireCount;

    @ApiModelProperty(value = "真实姓名")
    private String name;

    @ApiModelProperty(value = "全部认证: 0->为认证 1->已全部认证")
    private Integer completeStatus;

    @ApiModelProperty(value = "基本资料: 0->待完善 1->已完善")
    private Integer baseinfoStatus;

    @ApiModelProperty(value = "微信openid")
    private String wechatOpenid;

    @ApiModelProperty(value = "微信昵称")
    private String wechatNick;

    @ApiModelProperty(value = "微信头像")
    private String wechatHeadPic;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "客户备注")
    private String note;

    @ApiModelProperty(value = "客户免押额度")
    private BigDecimal freeMoney;

    @ApiModelProperty(value = "微信省份")
    private String wechatProvince;

    @ApiModelProperty(value = "微信城市")
    private String wechatCity;

    @ApiModelProperty(value = "微信国家")
    private String wechatCountry;

    @ApiModelProperty(value = "信誉度：0->优； 1-良好；2->一般； 3->欠佳； 4->差")
    private Integer creditworthiness;

    @ApiModelProperty(value = "支付宝账号")
    private String alipayNo;

    @ApiModelProperty(value = "微信账号")
    private String wechatNo;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getHistoryIntegration() {
        return historyIntegration;
    }

    public void setHistoryIntegration(Integer historyIntegration) {
        this.historyIntegration = historyIntegration;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getRentCount() {
        return rentCount;
    }

    public void setRentCount(Integer rentCount) {
        this.rentCount = rentCount;
    }

    public Integer getHireCount() {
        return hireCount;
    }

    public void setHireCount(Integer hireCount) {
        this.hireCount = hireCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(Integer completeStatus) {
        this.completeStatus = completeStatus;
    }

    public Integer getBaseinfoStatus() {
        return baseinfoStatus;
    }

    public void setBaseinfoStatus(Integer baseinfoStatus) {
        this.baseinfoStatus = baseinfoStatus;
    }

    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid;
    }

    public String getWechatNick() {
        return wechatNick;
    }

    public void setWechatNick(String wechatNick) {
        this.wechatNick = wechatNick;
    }

    public String getWechatHeadPic() {
        return wechatHeadPic;
    }

    public void setWechatHeadPic(String wechatHeadPic) {
        this.wechatHeadPic = wechatHeadPic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getFreeMoney() {
        return freeMoney;
    }

    public void setFreeMoney(BigDecimal freeMoney) {
        this.freeMoney = freeMoney;
    }

    public String getWechatProvince() {
        return wechatProvince;
    }

    public void setWechatProvince(String wechatProvince) {
        this.wechatProvince = wechatProvince;
    }

    public String getWechatCity() {
        return wechatCity;
    }

    public void setWechatCity(String wechatCity) {
        this.wechatCity = wechatCity;
    }

    public String getWechatCountry() {
        return wechatCountry;
    }

    public void setWechatCountry(String wechatCountry) {
        this.wechatCountry = wechatCountry;
    }

    public Integer getCreditworthiness() {
        return creditworthiness;
    }

    public void setCreditworthiness(Integer creditworthiness) {
        this.creditworthiness = creditworthiness;
    }

    public String getAlipayNo() {
        return alipayNo;
    }

    public void setAlipayNo(String alipayNo) {
        this.alipayNo = alipayNo;
    }

    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickname=").append(nickname);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", icon=").append(icon);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", city=").append(city);
        sb.append(", job=").append(job);
        sb.append(", personalizedSignature=").append(personalizedSignature);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", integration=").append(integration);
        sb.append(", growth=").append(growth);
        sb.append(", historyIntegration=").append(historyIntegration);
        sb.append(", orderCount=").append(orderCount);
        sb.append(", rentCount=").append(rentCount);
        sb.append(", hireCount=").append(hireCount);
        sb.append(", name=").append(name);
        sb.append(", completeStatus=").append(completeStatus);
        sb.append(", baseinfoStatus=").append(baseinfoStatus);
        sb.append(", wechatOpenid=").append(wechatOpenid);
        sb.append(", wechatNick=").append(wechatNick);
        sb.append(", wechatHeadPic=").append(wechatHeadPic);
        sb.append(", email=").append(email);
        sb.append(", note=").append(note);
        sb.append(", freeMoney=").append(freeMoney);
        sb.append(", wechatProvince=").append(wechatProvince);
        sb.append(", wechatCity=").append(wechatCity);
        sb.append(", wechatCountry=").append(wechatCountry);
        sb.append(", creditworthiness=").append(creditworthiness);
        sb.append(", alipayNo=").append(alipayNo);
        sb.append(", wechatNo=").append(wechatNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}