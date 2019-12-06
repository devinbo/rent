package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.UmsMemberAuthRelation;
import com.xxz.rent.model.UmsMemberKinsfolk;
import com.xxz.rent.model.UmsMemberLink;
import com.xxz.rent.model.UmsMemberRealinform;
import com.xxz.rent.portal.model.dto.MemberResult;
import com.xxz.rent.portal.service.UmsMemberInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-12 10:12
 * @description：客户资料controller
 * @modified By：
 * @version: ：1.0
 */
@RestController
@Api(tags = "UmsMemberInfoController", description = "客户资料管理（获取所有客户信息）")
@RequestMapping("/member/info")
public class UmsMemberInfoController {

    @Autowired
    private UmsMemberInfoService memberInfoService;

    @ApiOperation(value = "加载客户的所有资料", notes = "资料主要包括：会员基本资料，实名资料，亲属资料，联系人资料，认证项资料")
    @GetMapping("/all")
    public CommonResult<MemberResult> allInfo() {
        MemberResult memberResult = memberInfoService.allInfo();
        return CommonResult.success(memberResult);
    }

    @ApiOperation(value = "加载客户的实名及其身份信息", notes = "尚未人脸识别认证时，将返回code=500,message=尚未实名认证")
    @GetMapping("/realinform")
    public CommonResult<UmsMemberRealinform> realinform() {
        UmsMemberRealinform realinform = memberInfoService.realinform();
        return CommonResult.success(realinform);
    }

    @ApiOperation(value = "加载客户的亲属信息", notes = "尚未认证亲戚资料，将返回code=500,message=尚未认证亲戚信息")
    @GetMapping("/kinsfolk")
    public CommonResult<UmsMemberKinsfolk> kinsfolk() {
        UmsMemberKinsfolk kinsfolk = memberInfoService.kinsfolk();
        return CommonResult.success(kinsfolk);
    }

    @ApiOperation(value = "加载客户的常用联系人信息", notes = "尚未认证联系人资料，将返回code=500,message=尚未认证常用联系人资料")
    @GetMapping("/link")
    public CommonResult<UmsMemberLink> link() {
        UmsMemberLink link = memberInfoService.link();
        return CommonResult.success(link);
    }

    @ApiOperation(value = "加载客户的认证项信息")
    @GetMapping("/auth-item")
    public CommonResult<UmsMemberAuthRelation> authRelation() {
        UmsMemberAuthRelation authRelation = memberInfoService.authRelation();
        return CommonResult.success(authRelation);
    }


    @ApiOperation(value = "上传用户头像")
    @PostMapping("/upload/head-icon")
    public CommonResult uploadHeadIcon(@RequestPart(value = "file", required = true) MultipartFile file) throws IOException {
        String url = memberInfoService.uploadHeadIcon(file);
        return CommonResult.success(url);
    }

    @ApiOperation(value = "修改用户昵称")
    @PostMapping("/update/nick")
    public CommonResult updateNick(@RequestParam String nick) {
        int count = memberInfoService.updateNick(nick);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "修改用户基本信息")
    @PostMapping("/update")
    public CommonResult update(@RequestParam String nick) {
        int count = memberInfoService.updateNick(nick);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }


}
