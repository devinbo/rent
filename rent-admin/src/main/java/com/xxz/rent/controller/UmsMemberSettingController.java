package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.OmsOrderSetting;
import com.xxz.rent.model.UmsMemberSetting;
import com.xxz.rent.service.OmsOrderSettingService;
import com.xxz.rent.service.UmsMemberSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 订单设置Controller
 * Created by macro on 2018/10/16.
 */
@Controller
@Api(tags = "UmsMemberSettingController", description = "会员设置管理")
@RequestMapping("/memberSetting")
public class UmsMemberSettingController {

    @Autowired
    private UmsMemberSettingService memberSettingService;

    @ApiOperation("获取会员设置")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UmsMemberSetting> getItem() {
        UmsMemberSetting memberSetting = memberSettingService.getItem();
        return CommonResult.success(memberSetting);
    }

    @ApiOperation("修改会员设置设置")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody UmsMemberSetting memberSetting) {
        int count = memberSettingService.update(memberSetting);
        if(count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
