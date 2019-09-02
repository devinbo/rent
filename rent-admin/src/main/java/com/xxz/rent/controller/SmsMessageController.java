package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.SmsMessage;
import com.xxz.rent.service.SmsMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-15 10:51
 * @description：系统消息Controller
 * @modified By：
 * @version: ：1.0
 */
@Api(tags = "SmsMessageController", description = "系统公告管理")
@RestController
@RequestMapping("/system/message")
public class SmsMessageController {

    @Autowired
    private SmsMessageService smsMessageService;

    @ApiOperation("分页加载公告")
    @GetMapping("/list")
    public CommonResult<CommonPage<SmsMessage>> list(String name, PageParam pageParam) {
        List<SmsMessage> smsMessageList = smsMessageService.list(name, pageParam);
        return CommonResult.success(CommonPage.restPage(smsMessageList));
    }

    @ApiOperation("加载单一公告")
    @PostMapping("/{id}")
    public CommonResult getMessage(@PathVariable("id") Long id) {
        SmsMessage smsMessage = smsMessageService.getMessage(id);
        return CommonResult.success(smsMessage);
    }

    @ApiOperation("添加消息")
    @PostMapping("/add")
    public CommonResult addMessage(@RequestBody SmsMessage smsMessage) {
        int count = smsMessageService.addMessage(smsMessage);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改消息")
    @PostMapping("/update/{id}")
    public CommonResult updateMessage(@PathVariable("id") Long id, @RequestBody SmsMessage smsMessage) {
        int count = smsMessageService.updateMessage(id, smsMessage);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除消息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteMessage(@PathVariable("id") Long id) {
        int count = smsMessageService.deleteMessage(id);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

}
