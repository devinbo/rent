package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.SmsHomeActivity;
import com.xxz.rent.service.OmsActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-12 13:36
 * @description：首页活动controller
 * @modified By：
 * @version: ：1.0
 */
@RestController
@Api(tags = "OmsActivityController", description = "首页活动管理")
@RequestMapping("/activity")
public class OmsActivityController {

    @Autowired
    private OmsActivityService activityService;

    @ApiOperation("分页加载数据")
    @GetMapping("list")
    public CommonResult<CommonPage<SmsHomeActivity>> list(@RequestParam(name = "name", required = false) String name, PageParam pageParam) {
        List<SmsHomeActivity> activityList = activityService.list(name, pageParam);
        return CommonResult.success(CommonPage.restPage(activityList));
    }

    @ApiOperation("添加活动")
    @PostMapping("/create")
    public CommonResult create(@RequestBody SmsHomeActivity smsHomeActivity) {
        int count = activityService.create(smsHomeActivity);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改活动")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable("id") Long id, @RequestBody SmsHomeActivity smsHomeActivity) {
        int count = activityService.update(id, smsHomeActivity);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除活动")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = activityService.delete(ids);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("加载广告")
    @GetMapping("/{id}")
    public CommonResult<SmsHomeActivity> get(@PathVariable("id") Long id) {
        SmsHomeActivity smsHomeActivity = activityService.get(id);
        return CommonResult.success(smsHomeActivity);
    }

}
