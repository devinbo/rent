package com.xxz.rent.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OtoOrder implements Serializable {
    private Long id;

    @ApiModelProperty(value = "发布产品信息ID")
    private Long productId;

    @ApiModelProperty(value = "产品标题")
    private String productTitle;

    @ApiModelProperty(value = "订单状态：0->待付押金；1->待审核；2->签约中；3->已归还；4->已买断；5->已取消；6->已拒绝；7->待买断；8->待签约；9->已结清")
    private Integer status;

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "提交时间")
    private Date createTime;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "用户姓名")
    private String memberUsername;

    @ApiModelProperty(value = "会员手机号")
    private String memberPhone;

    @ApiModelProperty(value = "商品金额/签约金额")
    private BigDecimal signAmount;

    @ApiModelProperty(value = "应支付押金")
    private BigDecimal payAmount;

    @ApiModelProperty(value = "优惠价抵扣金额")
    private BigDecimal integrationAmount;

    @ApiModelProperty(value = "会员使用的免押额度")
    private BigDecimal useFreeMoney;

    @ApiModelProperty(value = "支付时间")
    private Date paymentTime;

    @ApiModelProperty(value = "支付方式：0->未支付；1->支付宝；2->微信")
    private Integer payType;

    @ApiModelProperty(value = "订单来源：0->PC订单；1->app订单")
    private Integer sourceType;

    @ApiModelProperty(value = "订单备注")
    private String note;

    @ApiModelProperty(value = "使用的优惠券名称")
    private String couponName;

    @ApiModelProperty(value = "当前待支付金额")
    private BigDecimal rentPayMoney;

    @ApiModelProperty(value = "待支付租金时间")
    private Date rentPayTime;

    @ApiModelProperty(value = "每期租金")
    private BigDecimal eachPrice;

    @ApiModelProperty(value = "当前期数/第几期")
    private Integer currPeriod;

    @ApiModelProperty(value = "期数")
    private Integer periods;

    @ApiModelProperty(value = "期数单位: 0->日；1->周；2->月；3->年")
    private Integer unit;

    @ApiModelProperty(value = "签约文件，合同")
    private String signFile;

    @ApiModelProperty(value = "期望交易方式：0->自提；1->邮寄")
    private Integer tradeType;

    @ApiModelProperty(value = "期望交易日期")
    private Date tradeDate;

    @ApiModelProperty(value = "删除标示：0->未删除； 1->已删除")
    private Integer deleteStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public BigDecimal getSignAmount() {
        return signAmount;
    }

    public void setSignAmount(BigDecimal signAmount) {
        this.signAmount = signAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getIntegrationAmount() {
        return integrationAmount;
    }

    public void setIntegrationAmount(BigDecimal integrationAmount) {
        this.integrationAmount = integrationAmount;
    }

    public BigDecimal getUseFreeMoney() {
        return useFreeMoney;
    }

    public void setUseFreeMoney(BigDecimal useFreeMoney) {
        this.useFreeMoney = useFreeMoney;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public BigDecimal getRentPayMoney() {
        return rentPayMoney;
    }

    public void setRentPayMoney(BigDecimal rentPayMoney) {
        this.rentPayMoney = rentPayMoney;
    }

    public Date getRentPayTime() {
        return rentPayTime;
    }

    public void setRentPayTime(Date rentPayTime) {
        this.rentPayTime = rentPayTime;
    }

    public BigDecimal getEachPrice() {
        return eachPrice;
    }

    public void setEachPrice(BigDecimal eachPrice) {
        this.eachPrice = eachPrice;
    }

    public Integer getCurrPeriod() {
        return currPeriod;
    }

    public void setCurrPeriod(Integer currPeriod) {
        this.currPeriod = currPeriod;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getSignFile() {
        return signFile;
    }

    public void setSignFile(String signFile) {
        this.signFile = signFile;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", productTitle=").append(productTitle);
        sb.append(", status=").append(status);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", createTime=").append(createTime);
        sb.append(", memberId=").append(memberId);
        sb.append(", memberUsername=").append(memberUsername);
        sb.append(", memberPhone=").append(memberPhone);
        sb.append(", signAmount=").append(signAmount);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", integrationAmount=").append(integrationAmount);
        sb.append(", useFreeMoney=").append(useFreeMoney);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", payType=").append(payType);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", note=").append(note);
        sb.append(", couponName=").append(couponName);
        sb.append(", rentPayMoney=").append(rentPayMoney);
        sb.append(", rentPayTime=").append(rentPayTime);
        sb.append(", eachPrice=").append(eachPrice);
        sb.append(", currPeriod=").append(currPeriod);
        sb.append(", periods=").append(periods);
        sb.append(", unit=").append(unit);
        sb.append(", signFile=").append(signFile);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", tradeDate=").append(tradeDate);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}