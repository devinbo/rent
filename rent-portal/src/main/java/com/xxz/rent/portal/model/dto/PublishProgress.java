package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-23 14:05
 * @description：发布进度
 * @modified By：
 * @version: ：1.0
 */
@Api("操作进度")
@Data
public class PublishProgress {

    @ApiModelProperty("进度名称")
    private String name;
    @ApiModelProperty("进度时间")
    private Date time;
    @ApiModelProperty("进度详细说明；例：拒绝原因，快递点位置")
    private String note;
    @ApiModelProperty("经纬度，仅针对于代理点才有")
    private String location;
    @ApiModelProperty("是否已经完成")
    private boolean isCompleted;

}
