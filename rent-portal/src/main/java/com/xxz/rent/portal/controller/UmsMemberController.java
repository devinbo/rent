package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.portal.model.dto.LoginParam;
import com.xxz.rent.portal.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 会员登录注册管理Controller
 * Created by macro on 2018/8/3.
 */
@RestController
@Api(tags = "UmsMemberController", description = "客户登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("登陆/注册")
    @PostMapping(value = "/token")
    public CommonResult register(@Validated @RequestBody LoginParam loginParam, BindingResult bindingResult) {
        return memberService.login(loginParam);
    }

    @ApiOperation("获取验证码")
    @PostMapping(value = "/auth_code")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }


}
