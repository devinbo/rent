package com.xxz.rent.portal.controller;

import com.github.pagehelper.page.PageParams;
import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.OmsOrderPayment;
import com.xxz.rent.portal.model.dto.ConfirmOrderResult;
import com.xxz.rent.portal.model.dto.OmsOrderResult;
import com.xxz.rent.portal.model.dto.OrderParam;
import com.xxz.rent.portal.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单管理Controller
 *
 * @author xxz
 */
@RestController
@Api(tags = "OmsPortalOrderController",description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("自营订单列表")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<OmsOrderResult>> list(@ApiParam(value = "状态；0->查询全部;1->进行中/签约中;2->已完成；3->已取消", allowableValues = "0,1,2,3")
                                                 @RequestParam Integer status,
                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<OmsOrderResult> omsOrderResultList = portalOrderService.list(status, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(omsOrderResultList));
    }


    @ApiOperation("查询订单")
    @GetMapping("/{id}")
    public CommonResult<OmsOrderResult> getOrderDetail(@PathVariable("id") Long id) {
        OmsOrderResult orderResult = portalOrderService.getOrderDetail(id);
        if(orderResult == null) {
            return CommonResult.failed("订单ID无效或已被删");
        }
        return CommonResult.success(orderResult);
    }

    @ApiOperation(value = "查询订单的账单信息", notes = "排序方式按 当前待还 > 尚未开始 > 已还")
    @GetMapping("/bills")
    public CommonResult<List<OmsOrderPayment>> getOrderBills(@ApiParam(value = "订单ID", required = true) @RequestParam Long orderId) {
        List<OmsOrderPayment> orderPaymentList = portalOrderService.getOrderBills(orderId);
        return CommonResult.success(orderPaymentList);
    }


    @ApiOperation(value = "取消订单", notes = "只能取消待支付的订单")
    @PostMapping("/cancel")
    public CommonResult cancel(@RequestParam Long id) {
        int count = portalOrderService.cancel(id);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "删除订单")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam Long id) {
        int count = portalOrderService.delete(id);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
}
