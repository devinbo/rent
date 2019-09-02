package com.xxz.rent.portal.controller;

import com.github.pagehelper.page.PageParams;
import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.SmsMessage;
import com.xxz.rent.model.UmsMemberMessage;
import com.xxz.rent.portal.service.HomeMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-16 13:24
 * @description：首页消息管理
 * @modified By：
 * @version: ：1.0
 */
@Api(tags = "HomeMessageController", description = "首页消息管理")
@RestController
@RequestMapping("/home/message")
public class HomeMessageController {

    @Autowired
    private HomeMessageService messageService;

    @ApiOperation(value = "是否有未读消息", notes = "仅针对于会员ID,不针对公告，即登陆之后，才会有未读情况出现。 data返回为未读消息数量，大于0即表示有未读")
    @GetMapping("unread-count")
    public CommonResult<Long> hasUnReadMsg() {
        Long count = messageService.hasNoReadMsg();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "分页查询公告", notes = "")
    @GetMapping("common-type")
    public CommonResult<CommonPage<SmsMessage>> getCommonMessage(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<SmsMessage> messageList = messageService.getCommonMessage(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(messageList));
    }

    @ApiOperation(value = "分页查询会员消息", notes = "")
    @GetMapping("member-type")
    public CommonResult<CommonPage<UmsMemberMessage>> getMemberMessages(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsMemberMessage> messageList = messageService.getMemberMessages(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(messageList));
    }
}
