package com.xxz.rent.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class OtoProductReply implements Serializable {
    private Long id;

    @ApiModelProperty(value = "评论ID")
    private Long commentId;

    @ApiModelProperty(value = "回复类型 1:针对评论  2:针对回复")
    private Integer replyType;

    @ApiModelProperty(value = "回复人ID")
    private Long memberId;

    @ApiModelProperty(value = "被回复人ID")
    private Long toMemberId;

    @ApiModelProperty(value = "回复内容")
    private String content;

    @ApiModelProperty(value = "回复人昵称")
    private String memberNickname;

    @ApiModelProperty(value = "回复人头像")
    private String memberPic;

    @ApiModelProperty(value = "被回复人昵称")
    private String toMemberNickname;

    @ApiModelProperty(value = "被回复人头像")
    private String toMemberPic;

    @ApiModelProperty(value = "回复时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getToMemberId() {
        return toMemberId;
    }

    public void setToMemberId(Long toMemberId) {
        this.toMemberId = toMemberId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getMemberPic() {
        return memberPic;
    }

    public void setMemberPic(String memberPic) {
        this.memberPic = memberPic;
    }

    public String getToMemberNickname() {
        return toMemberNickname;
    }

    public void setToMemberNickname(String toMemberNickname) {
        this.toMemberNickname = toMemberNickname;
    }

    public String getToMemberPic() {
        return toMemberPic;
    }

    public void setToMemberPic(String toMemberPic) {
        this.toMemberPic = toMemberPic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", commentId=").append(commentId);
        sb.append(", replyType=").append(replyType);
        sb.append(", memberId=").append(memberId);
        sb.append(", toMemberId=").append(toMemberId);
        sb.append(", content=").append(content);
        sb.append(", memberNickname=").append(memberNickname);
        sb.append(", memberPic=").append(memberPic);
        sb.append(", toMemberNickname=").append(toMemberNickname);
        sb.append(", toMemberPic=").append(toMemberPic);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}