package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.OtoOrderSetting;
import com.xxz.rent.service.OtoOrderService;
import com.xxz.rent.service.OtoOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-13 14:16
 * @description：订单设置管理
 * @modified By：
 * @version: ：1.0
 */
@RestController
@RequestMapping("/oto/orderSetting")
public class OtoOrderSettingController {

    @Autowired
    private OtoOrderSettingService otoOrderSettingService;

    @GetMapping("get")
    public CommonResult<OtoOrderSetting> get() {
        return CommonResult.success(otoOrderSettingService.get());
    }

    @PostMapping("update")
    public CommonResult update(@RequestBody OtoOrderSetting otoOrderSetting) {
        int count = otoOrderSettingService.update(otoOrderSetting);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
}
