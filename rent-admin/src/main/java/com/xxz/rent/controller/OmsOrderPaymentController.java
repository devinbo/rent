package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.OmsOrderQueryParam;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.OmsOrder;
import com.xxz.rent.model.OmsOrderPayment;
import com.xxz.rent.service.OmsOrderPaymentService;
import com.xxz.rent.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-08 16:14
 * @description：费用管理Controller
 * @modified By：
 * @version: ：1.0
 */
@RestController
@Api(tags = "OmsOrderPaymentController", description = "费用管理")
@RequestMapping("/order/payment")
public class OmsOrderPaymentController {

    @Autowired
    private OmsOrderPaymentService orderPaymentService;

    @ApiOperation("查询费用")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<OmsOrderPayment>> list(@RequestParam("orderId") Long orderId) {
        List<OmsOrderPayment> orderPaymentList = orderPaymentService.list(orderId);
        return CommonResult.success(orderPaymentList);
    }

    @ApiOperation("结算本期租金")
    @RequestMapping(value = "/complete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult completePayment(@PathVariable("id") Long id,
                                        @RequestParam("realPayTime") String realPayTime,
                                        @RequestParam("completeType") Integer completeType) {
        int count = orderPaymentService.completePayment(id, realPayTime, completeType);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
}
