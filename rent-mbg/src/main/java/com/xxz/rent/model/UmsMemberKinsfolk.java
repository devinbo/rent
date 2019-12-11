package com.xxz.rent.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UmsMemberKinsfolk implements Serializable {
    private Long id;

    @ApiModelProperty(value = "亲属1姓名")
    private String name1;

    @ApiModelProperty(value = "性别 0->未知； 1->男； 2->女")
    private Integer sex1;

    @ApiModelProperty(value = "手机号")
    private String phone1;

    @ApiModelProperty(value = "关系")
    private String relation1;

    @ApiModelProperty(value = "亲属2姓名")
    private String name2;

    @ApiModelProperty(value = "性别 0->未知； 1->男； 2->女")
    private Integer sex2;

    @ApiModelProperty(value = "手机号")
    private String phone2;

    @ApiModelProperty(value = "关系")
    private String relation2;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "亲属1备注信息")
    private String note1;

    @ApiModelProperty(value = "亲属2备注信息")
    private String note2;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public Integer getSex1() {
        return sex1;
    }

    public void setSex1(Integer sex1) {
        this.sex1 = sex1;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getRelation1() {
        return relation1;
    }

    public void setRelation1(String relation1) {
        this.relation1 = relation1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public Integer getSex2() {
        return sex2;
    }

    public void setSex2(Integer sex2) {
        this.sex2 = sex2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getRelation2() {
        return relation2;
    }

    public void setRelation2(String relation2) {
        this.relation2 = relation2;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name1=").append(name1);
        sb.append(", sex1=").append(sex1);
        sb.append(", phone1=").append(phone1);
        sb.append(", relation1=").append(relation1);
        sb.append(", name2=").append(name2);
        sb.append(", sex2=").append(sex2);
        sb.append(", phone2=").append(phone2);
        sb.append(", relation2=").append(relation2);
        sb.append(", memberId=").append(memberId);
        sb.append(", note1=").append(note1);
        sb.append(", note2=").append(note2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}