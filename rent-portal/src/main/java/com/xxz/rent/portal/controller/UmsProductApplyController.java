package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.portal.model.dto.ApplyParam;
import com.xxz.rent.portal.model.dto.ApplyResult;
import com.xxz.rent.portal.model.dto.PreOrderResult;
import com.xxz.rent.portal.service.UmsProductApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-18 11:26
 * @description：产品申请管理
 * @modified By：
 * @version: ：1.0
 */
@Api(tags = "UmsPorductApplyController", description = "产品申请管理")
@RestController
@RequestMapping("product/apply")
public class    UmsProductApplyController {

    @Autowired
    private UmsProductApplyService productApplyService;

    @ApiOperation("查询订单待确认页面的信息")
    @GetMapping("/preOrderInfo")
    public CommonResult<PreOrderResult> getPreOrderInfo(@ApiParam(required = true, value = "选中的产品SKUID") @RequestParam Long skuId) {
        PreOrderResult orderResult = productApplyService.getPreOrderInfo(skuId);
        return CommonResult.success(orderResult);
    }

    @ApiOperation("确认申请产品")
    @PostMapping("")
    public CommonResult<ApplyResult> apply(@RequestBody ApplyParam applyParam) {
        ApplyResult applyResult = productApplyService.apply(applyParam);
        return CommonResult.success(applyResult);
    }

}
