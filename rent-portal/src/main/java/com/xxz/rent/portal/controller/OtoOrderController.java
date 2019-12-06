package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.portal.model.dto.OtoApplyResult;
import com.xxz.rent.portal.model.dto.OtoOrderParam;
import com.xxz.rent.portal.service.OtoOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-12 14:08
 * @description：Oto订单管理
 * @modified By：
 * @version: ：1.0
 */
@RestController
@RequestMapping("/oto/order")
@Api(tags = "OtoOrderController", description = "笑享平台订单管理")
public class OtoOrderController {

    @Autowired
    private OtoOrderService otoOrderService;

    @ApiOperation(value = "发起租赁", notes = "确认租赁页面发起申请")
    @PostMapping("/apply")
    public CommonResult<OtoApplyResult> appay(@Valid @RequestBody OtoOrderParam otoOrderParam, BindingResult bindingResult) {
        return CommonResult.success(otoOrderService.apply(otoOrderParam));
    }


}
