package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.PmsProduct;
import com.xxz.rent.model.PmsProductCategory;
import com.xxz.rent.portal.model.dto.PmsCateAvdResult;
import com.xxz.rent.portal.service.PmsProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-09 13:35
 * @description：产品分类管理
 * @modified By：
 * @version: ：1.0
 */
@Api(tags = "PmsProductCategoryController", description = "分类管理")
@RestController
@RequestMapping("/pms/category")
public class PmsProductCategoryController {

    @Autowired
    private PmsProductCategoryService pmsProductCategoryService;

    @ApiOperation("加载所有产品分类信息")
    @GetMapping("/list")
    public CommonResult<List<PmsProductCategory>> allList() {
        return CommonResult.success(pmsProductCategoryService.allList());
    }

    @ApiOperation("加载分类下的产品信息及其广告位信息")
    @GetMapping("/productList")
    public CommonResult<PmsCateAvdResult> productList(@RequestParam @ApiParam Long cateId) {
        return CommonResult.success(pmsProductCategoryService.productList(cateId));
    }


}

