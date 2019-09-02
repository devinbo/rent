package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.OtoSite;
import com.xxz.rent.service.OtoSiteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-23 18:02
 * @description：站点管理
 * @modified By：
 * @version: ：1.0
 */
@Api(tags = "OtoSiteController", description = "站点管理")
@RestController
@RequestMapping("/oto/site")
public class OtoSiteController {


    @Autowired
    private OtoSiteService siteService;

    @GetMapping("list")
    public CommonResult<CommonPage<OtoSite>> list(@RequestParam(required = false) String name, PageParam pageParam) {
        List<OtoSite> otoSiteList = siteService.list(name, pageParam);
        return CommonResult.success(CommonPage.restPage(otoSiteList));
    }

    @PostMapping("create")
    public CommonResult create(@RequestBody OtoSite otoSite) {
        int count = siteService.create(otoSite);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @PostMapping("update/{id}")
    public CommonResult update(@PathVariable("id") Long id, @RequestBody OtoSite otoSite) {
        int count = siteService.update(id, otoSite);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @PostMapping("delete/{id}")
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = siteService.delete(id);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
}
