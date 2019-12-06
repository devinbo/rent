package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.PmsProduct;
import com.xxz.rent.portal.model.dto.OtoBrowseResult;
import com.xxz.rent.portal.model.dto.PmsBrowseResult;
import com.xxz.rent.portal.service.PmsBrowseService;
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
 * @date ：Created in 2019-10-10 10:45
 * @description：产品浏览足迹管理
 * @modified By：
 * @version: ：1.0
 */
@Api(tags = "PmsBrowseController", description = "浏览管理")
@RestController
@RequestMapping("/pms/browse")
public class PmsBrowseController {

    @Autowired
    private PmsBrowseService pmsBrowseService;

    @ApiOperation(value = "自营平台浏览列表, 每个日期下边最多只保留9个足迹")
    @GetMapping("/selfList")
    public CommonResult<CommonPage<PmsBrowseResult>> selfBrowseList(@ApiParam(value = "当前页") @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                                    @ApiParam(value = "每页大小") @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<PmsBrowseResult> pmsBrowseResultList = pmsBrowseService.selfBrowseList(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(pmsBrowseResultList));
    }


    @ApiOperation(value = "笑享平台浏览列表, 每个日期下边最多只保留9个足迹")
    @GetMapping("/otoList")
    public CommonResult<CommonPage<OtoBrowseResult>> otoBrowseList(@ApiParam(value = "当前页") @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                                   @ApiParam(value = "每页大小") @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<OtoBrowseResult> otoBrowseResultList = pmsBrowseService.otoBrowseList(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(otoBrowseResultList));
    }
}
