package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户认证管理
 */
@RestController
@RequestMapping("/member/auth")
public class UmsMemberAuthController {

    @ApiOperation(value = "身份信息认证", notes = "身份证正反面+人脸采集认证")
    @PostMapping("identity-card")
    public CommonResult identityCard() {
        return CommonResult.success(null);
    }


    @PostMapping("person")
    public CommonResult person() {
        return CommonResult.success(null);
    }


    @PostMapping("kinsfolk")
    public CommonResult kinsfolk() {
        return CommonResult.success(null);
    }
}
