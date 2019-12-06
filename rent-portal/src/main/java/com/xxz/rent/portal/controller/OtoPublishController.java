package com.xxz.rent.portal.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.OtoOrderPayment;
import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.OtoSite;
import com.xxz.rent.portal.model.dto.OtoOrderPaymentResult;
import com.xxz.rent.portal.model.dto.PublishDetailResult;
import com.xxz.rent.portal.model.dto.PublishResult;
import com.xxz.rent.portal.service.OtoPublishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-15 11:30
 * @description：我的发布
 * @modified By：
 * @version: ：1.0
 */
@RestController
@Api(tags = "OtoPublishController", description = "我的发布信息")
@RequestMapping("/oto/publish")
public class OtoPublishController {

    @Autowired
    private OtoPublishService otoPublishService;

    @ApiOperation(value = "查询我的发布列表")
    @GetMapping("list")
    public CommonResult<CommonPage<OtoProduct>> list(@ApiParam(value = "状态： 0->已签约；1->已上架；2->待审核") @RequestParam(value = "status") Integer status,
                                                     @ApiParam(value = "当前页") @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                     @ApiParam(value = "每页大小") @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<OtoProduct> otoProductList = otoPublishService.list(status, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(otoProductList));
    }


    @ApiOperation(value = "下架产品")
    @PostMapping("/soldOut")
    public CommonResult soldOut(@ApiParam(value = "发布产品ID", required = true) @RequestParam Long id) {
        int count = otoPublishService.soldOut(id);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    public CommonResult delete(@ApiParam(value = "发布产品ID", required = true) @RequestParam Long id) {
        int count = otoPublishService.delete(id);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "发布信息进度详情")
    @GetMapping("/detail")
    public CommonResult<PublishDetailResult> detail(@ApiParam(value = "发布产品ID", required = true) @RequestParam Long id) {
        PublishDetailResult publishDetailResult = otoPublishService.detail(id);
        return CommonResult.success(publishDetailResult);
    }

    @ApiOperation(value = "代理点查看")
    @GetMapping("/agency")
    public CommonResult<CommonPage<OtoSite>> agencyList(@ApiParam(value = "关键字，搜索")@RequestParam(required = false) String key,
                                                        @ApiParam(value = "城市名称，不填写默认为苏州市，如需查询所有该字段值为all") @RequestParam(required = false) String city) {
        List<OtoSite> otoSiteList = otoPublishService.agencyList(key, city);
        return CommonResult.success(CommonPage.restPage(otoSiteList));
    }

    @ApiOperation(value = "查看租金")
    @GetMapping("/rentDetail")
    public CommonResult<OtoOrderPaymentResult> rentDetail(@ApiParam(value = "订单ID", required = true) @RequestParam Long id){
        OtoOrderPaymentResult result = otoPublishService.rentDetail(id);
        return CommonResult.success(result);
    }
}
