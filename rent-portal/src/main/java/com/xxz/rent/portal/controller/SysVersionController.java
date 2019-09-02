package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.portal.model.dto.AppVersion;
import com.xxz.rent.portal.model.dto.AppVersionResult;
import com.xxz.rent.portal.service.SysVersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-14 11:37
 * @description：版本管理
 * @modified By：
 * @version: ：1.0
 */
@Api(tags = "SysVersionController", description = "版本管理")
@RestController()
@RequestMapping("sys")
public class SysVersionController {

    @Autowired
    private SysVersionService sysVersionService;

    @GetMapping("checkUpdate")
    @ApiModelProperty("检查版本更新")
    public CommonResult<AppVersionResult> checkUpdate(@Valid AppVersion appVersion, BindingResult bindingResult) {
        AppVersionResult appVersionResult = sysVersionService.checkUpdate(appVersion);
        return CommonResult.success(appVersionResult);
    }


}
