package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.UmsMemberAuthRelation;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-02 14:51
 * @description：发布详细结果集
 * @modified By：
 * @version: ：1.0
 */
@Data
public class OtoProductResult {

    @ApiModelProperty("发布的产品信息")
    private OtoProduct product;
    @ApiModelProperty("发布者信息")
    private UmsMemberPublishResult member;
    @ApiModelProperty("评论内容，此处只加载最新10条评论")
    private List<OtoCommentResult> commentList;


}
