package com.xxz.rent.portal.controller;

import com.aliyuncs.exceptions.ClientException;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.UmsMemberKinsfolk;
import com.xxz.rent.model.UmsMemberLink;
import com.xxz.rent.portal.model.dto.*;
import com.xxz.rent.portal.service.UmsMemberAuthService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Objects;

/**
 * 用户认证管理
 * @author xxz
 */
@RestController
@Api(tags = "UmsMemberAuthController",description = "用户身份信息认证")
@RequestMapping("/member/auth")
public class UmsMemberAuthController {

    @Autowired
    private UmsMemberAuthService authService;

    @ApiOperation(value = "身份信息认证结果", notes = "身份证正反面+人脸采集认证")
    @PostMapping("identity-card")
    public CommonResult<MemberRealInformResult> identityCard(@ApiParam(required = true, value = "接口aliloud-token返回的凭证ID") @RequestParam String ticketId) throws ClientException, IOException {
        MemberRealInformResult memberRealInformResult= authService.identityCard(ticketId);
        return CommonResult.success(memberRealInformResult);
    }


    @PostMapping("person")
    @ApiOperation(value = "个人信息认证")
    public CommonResult<MemberRealInformResult> personAuth(@ApiParam(value = "银行卡照片", required = true) @RequestParam MultipartFile bankcardPic,
                                                           @ApiParam(value = "芝麻分视频", required = true)  @RequestParam MultipartFile zmfVideo,
                                                           @ApiParam(value = "工作证/学生证", required = true) @RequestParam MultipartFile staffPic,
                                                               @Validated MemberBaseInfoParam memberBaseInfoParam, BindingResult bindingResult) throws IOException {
        if(Objects.isNull(bankcardPic) || bankcardPic.isEmpty()) {
            CommonResult.validateFailed("银行卡不能为空");
        }
        if(Objects.isNull(zmfVideo) || zmfVideo.isEmpty()) {
            CommonResult.validateFailed("芝麻分视频不能为空");
        }
        if(Objects.isNull(staffPic) || staffPic.isEmpty()) {
            CommonResult.validateFailed("工作证/学生证不能为空");
        }
        MemberRealInformResult realInformResult = authService.personAuth(bankcardPic, zmfVideo, staffPic, memberBaseInfoParam);
        return CommonResult.success(realInformResult);
    }


    @PostMapping("kinsfolk")
    @ApiOperation(value = "亲属认证")
    public CommonResult<MemberRealInformResult> kinsfolk(@RequestBody @Validated UmsMemberKinsfolkParam kinsfolkParam, BindingResult bindingResult) {
        MemberRealInformResult realInformResult = authService.kinsfolk(kinsfolkParam);
        return CommonResult.success(realInformResult);
    }

    @PostMapping("link")
    @ApiOperation(value = "常用联系人认证")
    public CommonResult<MemberRealInformResult> link(@RequestBody @Validated UmsMemberLinkParam memberLinkParam, BindingResult bindingResult) {
        MemberRealInformResult realInformResult = authService.link(memberLinkParam);
        return CommonResult.success(realInformResult);
    }

    @GetMapping("alicloud-token")
    @ApiOperation(value = "获取人脸识别token")
    public CommonResult<AliTokenResult> getAliCloudToken () throws Exception {
        AliTokenResult aliColudToken = authService.getAliColudToken();
        return CommonResult.success(aliColudToken);
    }

    @PostMapping("mobile")
    @ApiOperation(value = "运营商认证")
    public CommonResult<MemberRealInformResult> mobileAuth() {
        MemberRealInformResult memberRealInformResult = authService.mobileAuth();
        return CommonResult.success(memberRealInformResult);
    }

    @PostMapping("taobao")
    @ApiOperation(value = "淘宝认证")
    public CommonResult<MemberRealInformResult> taobaoAuth() {
        MemberRealInformResult memberRealInformResult = authService.taobaoAuth();
        return CommonResult.success(memberRealInformResult);
    }


    @PostMapping("study")
    @ApiOperation(value = "学信网认证")
    public CommonResult studyAuth() {
        MemberRealInformResult memberRealInformResult = authService.studyAuth();
        return CommonResult.success(memberRealInformResult);
    }
}
