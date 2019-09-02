package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-02 15:06
 * @description：发布结果集信息
 * @modified By：
 * @version: ：1.0
 */
@Data
public class UmsMemberPublishResult {

    @ApiModelProperty("发布者ID")
    private Long id;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty(value = "头像")
    private String icon;
    @ApiModelProperty(value = "历史出租数")
    private Integer rentCount;
    @ApiModelProperty(value = "信誉度：0->优； 1-良好；2->一般； 3->欠佳； 4->差")
    private Integer creditworthiness = 1;


}
