package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.OtoProductCategory;
import com.xxz.rent.portal.service.OtoHomeService;
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
 * @date ：Created in 2019-08-01 14:30
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Api(tags = "OtoHomeController", description = "笑享首页信息")
@RestController
@RequestMapping("/oto")
public class OtoHomeController {

    @Autowired
    private OtoHomeService otoHomeService;

    @ApiOperation(value = "首页产品分类列表")
    @GetMapping("/category/list")
    public CommonResult<List<OtoProductCategory>> cateList() {
        List<OtoProductCategory> productCategoryList = otoHomeService.cateList();
        return CommonResult.success(productCategoryList);
    }

    @ApiOperation(value = "首页产品列表查询全部及指定分类下的产品")
    @GetMapping("/product/list")
    public CommonResult<CommonPage<OtoProduct>> list(
            @ApiParam("分类ID, 查询全部时，设置该列为空")
            Long categoryId,
            @ApiParam(value = "页面大小", defaultValue = "10")
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @ApiParam(value = "当前页", defaultValue = "1")
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OtoProduct> otoProductList = otoHomeService.list(categoryId, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(otoProductList));
    }


}
