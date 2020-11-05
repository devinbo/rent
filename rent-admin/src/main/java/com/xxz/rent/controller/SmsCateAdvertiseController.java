package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.SmsCateAdvertise;
import com.xxz.rent.service.SmsCateAdvertiseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-10 10:57
 * @description：分类页面广告管理
 * @modified By：
 * @version: ：1.0
 */
@RestController
@RequestMapping("/sms/cateAdvertise")
public class SmsCateAdvertiseController {

    @Autowired
    private SmsCateAdvertiseService smsCateAdvertiseService;

    @ApiOperation("分页列表")
    @GetMapping("list")
    public CommonResult<CommonPage<SmsCateAdvertise>> list(String name, Long cateId, String endTime, PageParam pageParam) {
        List<SmsCateAdvertise> smsCateAdvertiseList = smsCateAdvertiseService.list(name, cateId, endTime, pageParam);
        return CommonResult.success(CommonPage.restPage(smsCateAdvertiseList));
    }


    @ApiOperation("查询详细")
    @GetMapping("/{id}")
    public CommonResult<SmsCateAdvertise> get(@PathVariable Long id) {
        return CommonResult.success(smsCateAdvertiseService.get(id));
    }

    @ApiOperation("删除广告")
    @PostMapping("/delete")
    public CommonResult delete(Long id) {
        int count = smsCateAdvertiseService.delete(id);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("添加广告")
    @PostMapping("/create")
    public CommonResult create(@RequestBody SmsCateAdvertise smsCateAdvertise) {
        int count = smsCateAdvertiseService.create(smsCateAdvertise);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改广告")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id, @RequestBody SmsCateAdvertise smsCateAdvertise) {
        int count = smsCateAdvertiseService.update(id, smsCateAdvertise);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改上下线状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, Integer status) {
        int count = smsCateAdvertiseService.updateStatus(id, status);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }



}
