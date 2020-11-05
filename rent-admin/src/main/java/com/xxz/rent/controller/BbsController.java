package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.BbsArticle;
import com.xxz.rent.model.BbsCategory;
import com.xxz.rent.service.BbsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-02 13:40
 * @description：BBS管理
 * @modified By：
 * @version: ：1.0
 */
@RequestMapping("/bbs")
@RestController
@Api(tags = "BbsController", description = "发现管理")
public class BbsController {

    @Autowired
    private BbsService bbsService;

    @ApiOperation("所有分类列表")
    @GetMapping("/category/allList")
    public CommonResult<List<BbsCategory>> categoryAllList() {
        List<BbsCategory> bbsCategoryList = bbsService.categoryAllList();
        return CommonResult.success(bbsCategoryList);
    }

    @ApiOperation("分页查询分类列表")
    @GetMapping("/category/list")
    public CommonResult<CommonPage<BbsCategory>> categoryList(String name, PageParam pageParam) {
        List<BbsCategory> bbsCategoryList = bbsService.categoryList(name, pageParam);
        return CommonResult.success(CommonPage.restPage(bbsCategoryList));
    }

    @ApiOperation("添加分类")
    @PostMapping("/category/create")
    public CommonResult createCategory(@RequestBody BbsCategory bbsCategory) {
        int count = bbsService.createCategory(bbsCategory);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改分类")
    @PostMapping("/category/update/{id}")
    public CommonResult updateCategory(@PathVariable Long id, @RequestBody BbsCategory bbsCategory) {
        int count = bbsService.updateCategory(id, bbsCategory);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除分类")
    @PostMapping("/category/delete/{id}")
    public CommonResult deleteCategory(@PathVariable Long id) {
        int count = bbsService.deleteCategory(id);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }


    @ApiOperation("文章列表")
    @GetMapping("/article/list")
    public CommonResult<CommonPage<BbsArticle>> articleList(String name, PageParam pageParam) {
        List<BbsArticle> bbsArticleList = bbsService.articleList(name, pageParam);
        return CommonResult.success(CommonPage.restPage(bbsArticleList));
    }

    @ApiOperation("加载某一文章")
    @GetMapping("/article/{id}")
    public CommonResult get(@PathVariable(value = "id") Long id) {
        return CommonResult.success(bbsService.get(id));
    }


    @ApiOperation("创建文章")
    @PostMapping("/article/create")
    public CommonResult createArticle(@RequestBody BbsArticle bbsArticle) {
        int count = bbsService.createArticle(bbsArticle);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改文章")
    @PostMapping("/article/update/{id}")
    public CommonResult updateArticle(@PathVariable Long id, @RequestBody BbsArticle bbsArticle) {
        int count = bbsService.updateArticle(id, bbsArticle);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
}
