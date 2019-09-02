package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.portal.model.dto.BindPhoneParam;
import com.xxz.rent.portal.model.dto.LoginParam;
import com.xxz.rent.portal.model.dto.LoginResult;
import com.xxz.rent.portal.model.dto.WxMemberResult;
import com.xxz.rent.portal.service.UmsMemberService;
import com.xxz.rent.portal.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 会员登录注册管理Controller
 *
 * @author xxz
 */
@RestController
@Api(tags = "UmsMemberController", description = "客户登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("登陆/注册")
    @PostMapping(value = "/token")

    public CommonResult<LoginResult> loginOrRegister(@Validated @RequestBody LoginParam loginParam, BindingResult bindingResult) {
        return memberService.loginOrRegister(loginParam);
    }

    @ApiOperation(value = "获取短信验证码", produces = "telephone=13788957291")
    @GetMapping(value = "/auth-code")
    public CommonResult getAuthCode(@ApiParam(value = "手机号", required = true)
                                        @RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation(value = "刷新Token", notes = "返回data即为刷新后token")
    @GetMapping(value = "refreshToken")
    public CommonResult<String> refreshToken(@ApiParam(value = "待刷新TOKEN", required = true) @RequestParam String token) {
        if(token.startsWith(tokenHead)) {
            token = token.substring(this.tokenHead.length());
        }
        if(jwtTokenUtil.canRefresh(token)) {
            return CommonResult.success(jwtTokenUtil.refreshToken(token));
        }else{
            return CommonResult.failed("无效Token或无法刷新");
        }
    }


    @ApiOperation(value = "加载用户微信信息", notes = "返回data为openid,后续绑定手机的参数")
    @PostMapping(value = "/weixin-info")
    public CommonResult<WxMemberResult> weixinInfo(
            @ApiParam(value = "用户授权后，返回给前端的Code")
            @RequestParam("code") String code) {
        WxMemberResult result = memberService.weixinInfo(code);
        return CommonResult.success(result);
    }


    @ApiOperation(value = "微信绑定手机账号")
    @PostMapping(value = "/weixin/bind-phone")
    public CommonResult<LoginResult> bindPhone(@RequestBody BindPhoneParam phoneParam) {
        return memberService.bindPhone(phoneParam);
    }

}
