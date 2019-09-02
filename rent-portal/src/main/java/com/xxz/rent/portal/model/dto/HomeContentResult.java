package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.*;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 首页内容返回信息封装
 *
 * @author xxz
 * @date 2019/1/28
 */
@Getter
@Setter
public class HomeContentResult {

    @ApiModelProperty("轮播广告")
    //轮播广告
    private List<SmsHomeAdvertise> advertiseList;

    @ApiModelProperty(value = "首页具有的分类", notes = "分类返回的数据较多时，请自行筛选出6个")
    //首页展示的分类
    private List<PmsProductCategory> categoryList;

    @ApiModelProperty("热门排行")
    //热门排行
    private List<PmsProduct> hotProductList;

    @ApiModelProperty("精选二手")
    //精选二手
    private List<PmsProduct> goodUsedProductList;

    @ApiModelProperty("活动列表")
    //活动列表
    private List<SmsHomeActivity> activityList;

    @ApiModelProperty("推荐专题")
    //推荐专题
    private List<CmsSubjectResult> subjectList;
}
