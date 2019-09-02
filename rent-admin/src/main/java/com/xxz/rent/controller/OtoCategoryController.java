package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.OtoSite;
import com.xxz.rent.service.OtoCategoryService;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.OtoProductCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-02 10:43
 * @description：笑享平台分类管理
 * @modified By：
 * @version: ：1.0
 */
@RestController
@RequestMapping("oto/category")
@Api(tags = "OtoCategoryController", description = "分类管理")
public class OtoCategoryController {


    @Autowired
    private OtoCategoryService categoryService;

    @GetMapping("list")
    @ApiOperation("分类列表")
    public CommonResult<CommonPage<OtoProductCategory>> list(String name, PageParam pageParam) {
        List<OtoProductCategory> productCategoryList = categoryService.list(name, pageParam);
        return CommonResult.success(CommonPage.restPage(productCategoryList));
    }

    @PostMapping("create")
    public CommonResult create(@RequestBody OtoProductCategory otoProductCategory) {
        int count = categoryService.create(otoProductCategory);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @PostMapping("update/{id}")
    public CommonResult update(@PathVariable("id") Long id, @RequestBody OtoProductCategory otoProductCategory) {
        int count = categoryService.update(id, otoProductCategory);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @PostMapping("delete/{id}")
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = categoryService.delete(id);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
}
