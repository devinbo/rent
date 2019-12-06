package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.BbsArticle;
import com.xxz.rent.model.BbsCategory;
import com.xxz.rent.portal.service.BbsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-02 10:58
 * @description：发现管理
 * @modified By：
 * @version: ：1.0
 */
@Api(tags = "BbsController", description = "发现管理")
@RestController
@RequestMapping("/bbs")
public class BbsController {


    @Autowired
    private BbsService bbsService;

    @ApiOperation("加载所有分类信息")
    @GetMapping("category/list")
    public CommonResult<List<BbsCategory>> categoryList() {
        List<BbsCategory> bbsCategoryList = bbsService.categoryList();
        return CommonResult.success(bbsCategoryList);
    }



    @ApiOperation("分页加载文章信息")
    @GetMapping("article/list")
    public CommonResult<CommonPage<BbsArticle>> articleList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                            @RequestParam(required = false) @ApiParam(value = "分类ID") Long cateId) {
        List<BbsArticle> bbsArticleList = bbsService.articleList(pageNum, pageSize, cateId);
        return CommonResult.success(CommonPage.restPage(bbsArticleList));
    }

    @ApiOperation("查看详细")
    @GetMapping("article/{id}")
    public CommonResult<BbsArticle> get(@PathVariable("id") Long id) {
        return CommonResult.success(bbsService.get(id));
    }


}
