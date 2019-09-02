package com.xxz.rent.controller;

import com.xxz.rent.bo.AdminUserDetails;
import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.MemberMessageResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.dto.UmsMemberResult;
import com.xxz.rent.model.*;
import com.xxz.rent.service.UmsMemberMessageService;
import com.xxz.rent.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-06-26 14:55
 * @description：会员消息管理
 * @modified By：
 * @version: ：1.0
 */
@Api(tags = "UmsMemberMessageController", description = "会员消息管理")
@RestController
@RequestMapping("/member/message")
public class UmsMemberMessageController {

    @Autowired
    private UmsMemberMessageService umsMemberMessageService;

    @GetMapping("list")
    @ApiOperation("会员列表")
    public CommonResult<CommonPage<MemberMessageResult>> list(@ApiParam(name = "name") String name, PageParam pageParam) {
        List<MemberMessageResult> memberMessageResultList = umsMemberMessageService.list(name, pageParam);
        return CommonResult.success(CommonPage.restPage(memberMessageResultList));
    }

    @ApiOperation("加载单一公告")
    @PostMapping("/{id}")
    public CommonResult<MemberMessageResult> getMessage(@PathVariable("id") Long id) {
        MemberMessageResult memberMessageResult = umsMemberMessageService.getMessage(id);
        return CommonResult.success(memberMessageResult);
    }

    @ApiOperation("添加消息")
    @PostMapping("/add")
    public CommonResult addMessage(@RequestBody UmsMemberMessage umsMemberMessage) {
        int count = umsMemberMessageService.addMessage(umsMemberMessage);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改消息")
    @PostMapping("/update/{id}")
    public CommonResult updateMessage(@PathVariable("id") Long id, @RequestBody UmsMemberMessage umsMemberMessage) {
        int count = umsMemberMessageService.updateMessage(id, umsMemberMessage);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除消息消息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteMessage(@PathVariable("id") Long id) {
        int count = umsMemberMessageService.deleteMessage(id);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
}
