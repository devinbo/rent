package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.portal.model.dto.UmsIntegrationResult;
import com.xxz.rent.portal.service.UmsIntegrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-24 09:48
 * @description：用户积分管理
 * @modified By：
 * @version: ：1.0
 */
@Api(tags = "UmsIntegrationController", description = "用户积分管理")
@RestController("/ums/integration")
public class UmsIntegrationController {

    @Autowired
    private UmsIntegrationService umsIntegrationService;

    @ApiOperation("查询积分消费记录")
    @GetMapping("list")
    public CommonResult<UmsIntegrationResult> list(@ApiParam @RequestParam(defaultValue = "1", required = false) int pageNum,
                                                   @ApiParam @RequestParam(defaultValue = "5", required = false) int pageSize) {
        return CommonResult.success(umsIntegrationService.list(pageNum, pageSize));
    }



}
