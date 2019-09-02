package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.OtoProductCategory;
import com.xxz.rent.model.OtoProductReply;
import com.xxz.rent.portal.model.dto.*;
import com.xxz.rent.portal.service.OtoProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-02 14:02
 * @description：oto产品管理
 * @modified By：
 * @version: ：1.0
 */
@RestController
@RequestMapping("oto/product")
@Api(tags = "OtoProductController", description = "发布信息管理")
public class OtoProductController {

    @Autowired
    private OtoProductService otoProductService;

    private int maxPicLen = 8;

    @PostMapping("add")
    @ApiOperation("发布产品信息")
    public CommonResult add(@RequestParam MultipartFile[] pic, @Validated OtoProductParam productParam, BindingResult bindingResult) {
        if (pic == null || pic.length == 0) {
            return CommonResult.failed("产品图片不能为空");
        } else if (pic.length > maxPicLen) {
            return CommonResult.failed("最多上传8张产品图片");
        }
        int count = otoProductService.add(pic, productParam);
        if (count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @GetMapping("/{id}")
    @ApiOperation("查询发布的指定产品信息")
    public CommonResult<OtoProductResult> get(@PathVariable("id") Long id) {
        OtoProductResult result = otoProductService.get(id);
        return CommonResult.success(result);
    }


    @GetMapping("/category-list")
    @ApiOperation("查询所有分类信息")
    public CommonResult<List<OtoProductCategory>> getAllProdCate() {
        List<OtoProductCategory> list = otoProductService.getAllProdCate();
        return CommonResult.success(list);
    }


    @PostMapping("/comment/add")
    @ApiOperation("留言")
    public CommonResult comment(@Valid @RequestBody CommentParam commentParam, BindingResult bindingResult) {
        int count = otoProductService.comment(commentParam);
        if (count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @PostMapping("/reply/add")
    @ApiOperation("回复")
    public CommonResult reply(@RequestBody ReplyParam replyParam, BindingResult bindingResult) {
        int count = otoProductService.reply(replyParam);
        if (count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "分页查询评论", notes = "每个评论下的最多10条回复")
    @GetMapping("/comment/list")
    public CommonResult<CommonPage<OtoCommentResult>> commentList(@ApiParam(value = "发布的产品ID", required = true) @RequestParam Long productId,
                                                @ApiParam(value = "每页大小", defaultValue = "5") @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OtoCommentResult> commentResultList = otoProductService.commentList(productId, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(commentResultList));
    }

    @ApiOperation(value = "分页查询回复", notes = "根据评论ID查询回复信息")
    @GetMapping("/reply/list")
    public CommonResult<CommonPage<OtoProductReply>> replyList(@ApiParam(value = "顶层评论ID(OtoCommentResult中的ID),非回复ID", required = true) @RequestParam Long id,
                                                               @ApiParam(value = "每页大小", defaultValue = "5") @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OtoProductReply> productReplyList = otoProductService.replyList(id, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(productReplyList));
    }


    @ApiOperation(value = "确认租赁详情", notes = "确认租赁页面详情")
    @GetMapping("/preApply")
    public CommonResult<OtoPreOrderResult> preApply(Long id) {
        OtoPreOrderResult preOrderResult = otoProductService.preApply(id);
        return CommonResult.success(preOrderResult);
    }


}
