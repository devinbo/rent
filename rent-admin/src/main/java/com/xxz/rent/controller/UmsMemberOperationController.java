package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.UmsMemberOperation;
import com.xxz.rent.service.UmsMemberOperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-06-28 10:42
 * @description： 客户操作记录
 * @modified By：
 * @version: ：1.0
 */
@RestController
@RequestMapping("/member/operation")
@Api(tags = "UmsMemberOperationController", description = "操作记录")
public class UmsMemberOperationController {

    @Autowired
    private UmsMemberOperationService memberOperationService;

    @GetMapping("/list")
    @ApiOperation("操作记录列表")
    public CommonResult<CommonPage<UmsMemberOperation>> list(@RequestParam(name = "memberId") Long memberId, PageParam pageParam) {
        List<UmsMemberOperation> memberOperationList = memberOperationService.list(memberId, pageParam);
        return CommonResult.success(CommonPage.restPage(memberOperationList));
    }
}
