package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.CmsSubject;
import com.xxz.rent.model.PmsProduct;
import com.xxz.rent.model.PmsProductCategory;
import com.xxz.rent.portal.model.dto.HomeContentResult;
import com.xxz.rent.portal.model.dto.PmsProductResult;
import com.xxz.rent.portal.service.HomeService;
import com.xxz.rent.portal.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页内容管理Controller
 *
 * @author xxz
 * @date 2019/1/28
 */
@Controller
@Api(tags = "HomeController", description = "首页内容管理")
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;
    @Autowired
    private RedisService redisService;


    @ApiOperation(value = "首页内容页信息展示", notes = "删除和移动端等标志字段，前端请忽略，无需再额外进行判断，返回等数据即为最终有效的")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<HomeContentResult> content() {
        HomeContentResult contentResult = homeService.content();

        return CommonResult.success(contentResult);
    }

    @ApiOperation(value = "分页获取热门排行商品", notes = "默认每页大小为4")
    @RequestMapping(value = "/recommendProductList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProduct>> recommendProductList(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = homeService.recommendProductList(pageSize, pageNum);
        return CommonResult.success(productList);
    }

    @ApiOperation(value = "分页获取二手优选商品", notes = "默认每页大小为5")
    @RequestMapping(value = "/goodUsedProductList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProduct>> goodUsedProductList(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = homeService.goodUsedProductList(pageSize, pageNum);
        return CommonResult.success(productList);
    }

    @ApiOperation(value = "获取首页商品分类", notes = "目前仅涉及一级分类")
    @RequestMapping(value = "/productCateList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductCategory>> getProductCateList() {
        List<PmsProductCategory> productCategoryList = homeService.getProductCateList(0L);
        return CommonResult.success(productCategoryList);
    }


    @ApiOperation(value = "根据分类ID分页加载产品")
    @RequestMapping(value = "/category/{id}/productList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProduct>> productList(@PathVariable("id") @ApiParam(value = "分类ID", required = true)  Long id,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> pmsProductList = homeService.productList(id, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(pmsProductList));
    }

    @ApiOperation(value = "分页加载某一专题产品")
    @RequestMapping(value = "/subject/{id}/productList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProduct>> getPorductListBySubjectId(@PathVariable("id") @ApiParam(value = "专题ID", required = true) Long id,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> pmsProductList = homeService.getPorductListBySubjectId(id, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(pmsProductList));
    }

    @ApiOperation(value = "根据产品ID查询产品")
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsProductResult> getProductDetail(@PathVariable("id") @ApiParam(value = "产品ID", required = true) Long id) {
        PmsProductResult pmsProductResult = homeService.getProductDetail(id);
        return CommonResult.success(pmsProductResult);
    }
}
