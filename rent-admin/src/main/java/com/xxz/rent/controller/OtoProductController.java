package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.OtoCommentResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.OtoProductReply;
import com.xxz.rent.service.OtoProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-06 11:28
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@RestController
@RequestMapping("/oto/product")
public class OtoProductController {

    @Autowired
    private OtoProductService productService;

    @GetMapping("list")
    public CommonResult<CommonPage<OtoProduct>> list(String name, String[] startTime, Integer status, PageParam pageParam) {
        List<OtoProduct> otoProductList = productService.list(name, startTime, status, pageParam);
        return CommonResult.success(CommonPage.restPage(otoProductList));
    }

    @GetMapping("/{id}")
    public CommonResult<OtoProduct> get(@PathVariable("id") Long id) {
        return CommonResult.success(productService.get(id));
    }

    @PostMapping("updatePrice")
    public CommonResult updatePrice(@RequestParam Long id, BigDecimal productPrice) {
        int count = productService.updatePrice(id, productPrice);
        if(count > 0) {
            return CommonResult.success();
        }else{
            return CommonResult.failed();
        }
    }

    @PostMapping("audit")
    public CommonResult audit(@RequestParam Long id, @RequestParam Integer status, Integer goodStatus, Integer reliableStatus, String refuseReason) {
        int count = productService.audit(id, status, refuseReason, goodStatus, reliableStatus);
        if(count > 0) {
            return CommonResult.success();
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "分页查询评论", notes = "每个评论下的最多10条回复")
    @GetMapping("/comment/list")
    public CommonResult<CommonPage<OtoCommentResult>> commentList(@ApiParam(value = "发布的产品ID", required = true) @RequestParam Long productId,
                                                                  @ApiParam(value = "每页大小", defaultValue = "5") @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OtoCommentResult> commentResultList = productService.commentList(productId, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(commentResultList));
    }

    @ApiOperation(value = "分页查询回复", notes = "根据评论ID查询回复信息")
    @GetMapping("/reply/list")
    public CommonResult<CommonPage<OtoProductReply>> replyList(@ApiParam(value = "顶层评论ID(OtoCommentResult中的ID),非回复ID", required = true) @RequestParam Long id,
                                                               @ApiParam(value = "每页大小", defaultValue = "5") @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OtoProductReply> productReplyList = productService.replyList(id, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(productReplyList));
    }
}
