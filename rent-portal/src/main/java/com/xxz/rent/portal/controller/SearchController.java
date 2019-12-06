package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.HomeHotWord;
import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.PmsProduct;
import com.xxz.rent.portal.service.SearchService;
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
 * @date ：Created in 2019-09-10 10:15
 * @description：搜索管理类
 * @modified By：
 * @version: ：1.0
 */
@RequestMapping("/common/search/")
@Api(tags = "SearchController", description = "搜索管理")
@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @ApiOperation("产品首页搜索")
    @GetMapping("/product/query")
    public CommonResult<CommonPage<PmsProduct>> query(@RequestParam @ApiParam(required = true) String word,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return CommonResult.success(CommonPage.restPage(searchService.query(word, pageNum, pageSize)));
    }

    @ApiOperation("加载首页热门搜索热词")
    @GetMapping("/hot")
    public CommonResult<List<HomeHotWord>> getHotWord() {
        return CommonResult.success(searchService.getHotWord());
    }

    @ApiOperation("/发布信息搜索")
    @GetMapping("/publish/query")
    public CommonResult<CommonPage<OtoProduct>> queryPublish(@RequestParam @ApiParam(required = true) String word,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return CommonResult.success(CommonPage.restPage(searchService.queryPublish(word, pageNum, pageSize)));
    }
}
