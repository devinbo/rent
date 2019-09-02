package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-02 16:09
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Data
public class ReplyParam {

    @ApiModelProperty("发布的产品ID")
    @NotNull(message = "发布产品ID不能为空！")
    private Long productId;
    @ApiModelProperty("该评论的ID,注意不是回复的ID")
    @NotNull(message = "该评论的ID")
    private Long commentId;
    @ApiModelProperty("被回复者ID")
    private Long toMemberId;
    @ApiModelProperty("回复类型：0->针对评论回复；1->回复别人的回复")
    @Range(min = 0, max = 1, message = "回复类型值只能为【0,1】")
    private Integer replyType;
    @ApiModelProperty("留言/回复内容")
    @NotBlank
    private String content;

}
