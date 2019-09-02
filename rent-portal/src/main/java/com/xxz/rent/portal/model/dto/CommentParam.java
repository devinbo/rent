package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
public class CommentParam {

    @ApiModelProperty("发布的产品ID")
    @NotNull(message = "发布产品ID不能为空！")
    private Long productId;
    @ApiModelProperty("留言内容")
    @NotBlank
    private String content;

}
