package com.xxz.rent.controller;

import com.xxz.rent.bo.AdminUserDetails;
import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.dto.UmsMemberResult;
import com.xxz.rent.model.*;
import com.xxz.rent.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-06-26 14:55
 * @description：会员管理
 * @modified By：
 * @version: ：1.0
 */
@Api(tags = "UmsMemberController", description = "会员管理")
@RestController
@RequestMapping("/member")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @GetMapping("list")
    @ApiOperation("会员列表")
    public CommonResult<CommonPage<UmsMember>> list(@ApiParam(name = "name", value = "会员手机/昵称/姓名") String name, PageParam pageParam) {
        List<UmsMember> adminList = umsMemberService.list(name, pageParam);
        return CommonResult.success(CommonPage.restPage(adminList));
    }


    @ApiOperation("冻结/解冻账户")
    @RequestMapping(value = "/update/blockStatus", method = RequestMethod.POST)
    public CommonResult updateBlockStatus(@RequestParam("ids") List<Long> ids,
                                          @RequestParam("blockStatus") Integer blockStatus) {
        int count = umsMemberService.updateBlockStatus(ids, blockStatus);
        if(count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("产品详细")
    @GetMapping(value = "/{id}")
    public CommonResult<UmsMemberResult> getDetail(@PathVariable("id") Long id) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        AdminUserDetails adminUserDetails = (AdminUserDetails) usernamePasswordAuthenticationToken.getPrincipal();
        System.out.println(adminUserDetails.getUmsAdmin());
        UmsMemberResult result = umsMemberService.getMemberDetail(id);
        return CommonResult.success(result);
    }

    @ApiOperation("修改会员基本资料信息")
    @PostMapping(value = "/update/{id}")
    public CommonResult update(@PathVariable("id") Long id, @RequestBody UmsMember umsMember) {
        int count = umsMemberService.update(id, umsMember);
        if(count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改会员实名资料信息")
    @PostMapping(value = "/realinform/update/{id}")
    public CommonResult updateRealInform(@PathVariable("id") Long id, @RequestBody UmsMemberRealinform umsMemberRealinform) {
        int count = umsMemberService.updateRealInform(id, umsMemberRealinform);
        if(count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改会员实名资料信息并通过认证")
    @PostMapping(value = "/realinform-auth/update/{id}")
    public CommonResult updateRealInformAndComplteAuth(@PathVariable("id") Long id, @RequestBody UmsMemberRealinform umsMemberRealinform) {
        int count = umsMemberService.updateRealInformAndComplteAuth(id, umsMemberRealinform);
        if(count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改会员收获地址")
    @PostMapping(value = "/receiveaddress/update/{id}")
    public CommonResult updateMemberReceiveAddress(@PathVariable("id") Long id, @RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress) {
        int count = umsMemberService.updateMemberReceiveAddress(id, umsMemberReceiveAddress);
        if(count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("修改会员亲属联系人信息")
    @PostMapping(value = "/kinsfolk/update/{id}")
    public CommonResult updateMemberKinsfolk(@PathVariable("id") Long id, @RequestBody UmsMemberKinsfolk umsMemberKinsfolk) {
        int count = umsMemberService.updateMemberKinsfolk(id, umsMemberKinsfolk);
        if(count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改会员常用联系人信息")
    @PostMapping(value = "/link/update/{id}")
    public CommonResult updateMemberLink(@PathVariable("id") Long id, @RequestBody UmsMemberLink umsMemberLink) {
        System.out.println();
        int count = umsMemberService.updateMemberLink(id, umsMemberLink);
        if(count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改会员备注信息")
    @PostMapping(value = "/note/update/{id}")
    public CommonResult updateMemberNote(@PathVariable("id") Long id, @RequestParam String note) {
        int count = umsMemberService.updateMemberNote(id, note);
        if(count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改会员备注信息")
    @PostMapping(value = "/auth-relation/update/{id}")
    public CommonResult updateMemberAuthRelation(@PathVariable("id") Long id, @RequestBody UmsMemberAuthRelation memberAuthRelation) {
        int count = umsMemberService.updateMemberAuthRelation(id, memberAuthRelation);
        if(count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("修改会员备注信息")
    @GetMapping(value = "/ship-address/list")
    public CommonResult<List<UmsMemberReceiveAddress>> getShipAddress(@RequestParam("memberId") Long memberId) {
        List<UmsMemberReceiveAddress> receiveAddressList = umsMemberService.getShipAddress(memberId);
        return CommonResult.success(receiveAddressList);
    }

    @ApiOperation("根据关键字")
    @GetMapping(value = "keyword-list")
    public CommonResult<List<UmsMember>> getMemberByKeyword(@RequestParam("keyword") String keyword) {
        return CommonResult.success(umsMemberService.getMemberByKeyword(keyword));
    }
}
