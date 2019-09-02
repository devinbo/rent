package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.*;
import com.xxz.rent.dto.*;
import com.xxz.rent.model.OmsOrder;
import com.xxz.rent.model.OmsOrderOperateHistory;
import com.xxz.rent.service.OmsOrderService;
import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.OmsOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单管理Controller
 *
 * @author macro
 * @date 2018/10/11
 */
@Controller
@Api(tags = "OmsOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {
    @Autowired
    private OmsOrderService orderService;

    @ApiOperation("查询订单")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrder>> list(OmsOrderQueryParam queryParam, PageParam pageParam) {
        List<OmsOrder> orderList = orderService.list(queryParam, pageParam);
        return CommonResult.success(CommonPage.restPage(orderList));
    }

    @ApiOperation("查询订单操作记录")
    @RequestMapping(value = "/operate/list/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrderOperateHistory>> getOperateList(@PathVariable("id") Long id, PageParam pageParam) {
        List<OmsOrderOperateHistory> operateList = orderService.getOperateList(id, pageParam);
        return CommonResult.success(CommonPage.restPage(operateList));
    }

    @ApiOperation("批量发货")
    @RequestMapping(value = "/update/delivery", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delivery(@RequestBody List<OmsOrderDeliveryParam> deliveryParamList) {
        int count = orderService.delivery(deliveryParamList);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量关闭订单")
    @RequestMapping(value = "/update/close", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult close(@RequestParam("ids") List<Long> ids, @RequestParam String note) {
        int count = orderService.close(ids, note);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = orderService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderDetail> detail(@PathVariable Long id) {
        OmsOrderDetail orderDetailResult = orderService.detail(id);
        return CommonResult.success(orderDetailResult);
    }

    @ApiOperation("修改收货人信息")
    @RequestMapping(value = "/update/receiverInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateReceiverInfo(@RequestBody OmsReceiverInfoParam receiverInfoParam) {
        int count = orderService.updateReceiverInfo(receiverInfoParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改订单费用信息")
    @RequestMapping(value = "/update/moneyInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateReceiverInfo(@RequestBody OmsMoneyInfoParam moneyInfoParam) {
        int count = orderService.updateMoneyInfo(moneyInfoParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("备注订单")
    @RequestMapping(value = "/update/note", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateNote(@RequestParam("id") Long id,
                                   @RequestParam("note") String note,
                                   @RequestParam("status") Integer status) {
        int count = orderService.updateNote(id, note, status);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单审核")
    @RequestMapping(value = "/audit/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult auditOrder(@PathVariable("id") Long id, OmsOrderAuditParam auditParam) {
        int count = orderService.auditOrder(id, auditParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单签约")
    @RequestMapping(value = "/{id}/sign", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult signOrder(@PathVariable("id") Long id,
                                  @RequestParam String start_time,
                                  @RequestParam(required = false) String file) {
        int count = orderService.signOrder(id, start_time, file);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("租赁买断")
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult buyOrder(@PathVariable("id") Long id, @RequestParam(value = "note", required = false) String note) {
        int count = orderService.buyOrder(id, note);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("租赁归还产品")
    @RequestMapping(value = "/back/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult backOrder(@PathVariable("id") Long id, @RequestParam(value = "note", required = false) String note) {
        int count = orderService.backOrder(id, note);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
