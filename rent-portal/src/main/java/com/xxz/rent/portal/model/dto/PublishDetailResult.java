package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-15 14:06
 * @description：发布信息详情
 * @modified By：
 * @version: ：1.0
 */
@Data
public class PublishDetailResult {

    @ApiModelProperty("图片")
    private String pic;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("每期租金")
    private String rentEachPrice;
    @ApiModelProperty("租期单位")
    private String rentUnit;
    @ApiModelProperty("最短起租数")
    private Integer minRentNum;
    @ApiModelProperty("最长租数")
    private Integer maxRentNum;

    @ApiModelProperty("进度")
    private List<PublishProgress> progressList;



}
