package com.xxz.rent.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.dto.enumerate.OtoOrderStatus;
import com.xxz.rent.model.OtoOrder;
import com.xxz.rent.service.OtoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-13 11:27
 * @description：OTO订单管理
 * @modified By：
 * @version: ：1.0
 */
@RestController
@RequestMapping("/oto/order")
public class OtoOrderController {

    @Autowired
    private OtoOrderService otoOrderService;

    @GetMapping("/orderStatusList")
    public CommonResult<OtoOrderStatus[]> getOrderStatusList() {
        return CommonResult.success(OtoOrderStatus.values());
    }

    @GetMapping("/list")
    public CommonResult<CommonPage<OtoOrder>> list(String[] startTime, Integer status, String memberName, String productName, PageParam pageParam) {
        List<OtoOrder> otoOrderList = otoOrderService.list(startTime, status, memberName, productName, pageParam);
        return CommonResult.success(CommonPage.restPage(otoOrderList));
    }


}
