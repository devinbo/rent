package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.MemberMessageResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.dto.UmsMemberAuthResult;
import com.xxz.rent.dto.UmsMemberResult;
import com.xxz.rent.service.UmsMemberAuthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-15 17:38
 * @description：会员审核Controller
 * @modified By：
 * @version: ：1.0
 */
@RestController
@RequestMapping("/member/auth/")
public class UmsMemberAuthController {

    @Autowired
    private UmsMemberAuthService umsMemberAuthService;

    @GetMapping("list")
    public CommonResult<CommonPage<UmsMemberAuthResult>> list(String name, PageParam pageParam) {
        List<UmsMemberAuthResult> memberAuthResultList = umsMemberAuthService.list(name, pageParam);
        return CommonResult.success(CommonPage.restPage(memberAuthResultList));
    }

    @ApiOperation("个人信息审核")
    @PostMapping("person")
    public CommonResult auditPerson(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote) {
        int count = umsMemberAuthService.auditPerson(memberId, status, freeMoney, rejustNote);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("亲属信息审核")
    @PostMapping("kinsfolk")
    public CommonResult auditKinsfolk(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote) {
        int count = umsMemberAuthService.auditKinsfolk(memberId, status, freeMoney, rejustNote);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("联系人信息审核")
    @PostMapping("link")
    public CommonResult auditLink(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote) {
        int count = umsMemberAuthService.auditLink(memberId, status, freeMoney, rejustNote);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("运营商审核")
    @PostMapping("mobile")
    public CommonResult auditMobile(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote) {
        int count = umsMemberAuthService.auditMobile(memberId, status, freeMoney, rejustNote);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("淘宝信息审核")
    @PostMapping("taobao")
    public CommonResult auditTaobao(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote) {
        int count = umsMemberAuthService.auditTaobao(memberId, status, freeMoney, rejustNote);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("学信网信息审核")
    @PostMapping("study")
    public CommonResult auditStudy(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote) {
        int count = umsMemberAuthService.auditStudy(memberId, status, freeMoney, rejustNote);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("保存用户信息")
    @PostMapping("saveAllMember")
    public CommonResult saveAllMember(@RequestBody UmsMemberResult memberResult) {
        int count = umsMemberAuthService.saveAllMember(memberResult);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
}
