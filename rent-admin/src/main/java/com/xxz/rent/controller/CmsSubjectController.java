package com.xxz.rent.controller;

import com.xxz.rent.common.api.CommonPage;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.CmsSubjectParam;
import com.xxz.rent.dto.CmsSubjectResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.CmsSubject;
import com.xxz.rent.service.CmsSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品专题Controller
 *
 * @author xxz
 */
@Controller
@Api(tags = "CmsSubjectController", description = "商品专题管理")
@RequestMapping("/subject")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService subjectService;

    @ApiOperation("获取全部商品专题")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> listAll() {
        List<CmsSubject> subjectList = subjectService.listAll();
        return CommonResult.success(subjectList);
    }

    @ApiOperation(value = "根据专题名称分页获取专题")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CmsSubject>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                        PageParam pageParam) {
        List<CmsSubject> subjectList = subjectService.list(keyword, pageParam);
        return CommonResult.success(CommonPage.restPage(subjectList));
    }

    @ApiOperation(value = "根据ID获取专题")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CmsSubjectResult> getSubject(@PathVariable("id") Long id) {
        CmsSubjectResult cmsSubjectResult = subjectService.getSubject(id);
        return CommonResult.success(cmsSubjectResult);
    }

    @ApiOperation(value = "添加专题")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createSubject(@RequestBody CmsSubjectParam cmsSubjectParam) {
        int count = subjectService.createSubject(cmsSubjectParam);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "修改专题")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateSubject(@PathVariable("id") Long id, @RequestBody CmsSubjectParam cmsSubjectParam) {
        int count = subjectService.updateSubject(id, cmsSubjectParam);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "删除专题")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteSubject(@PathVariable("id") Long id) {
        int count = subjectService.deleteSubject(id);
        if(count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }


    @ApiOperation(value = "根据关键字查询专题")
    @RequestMapping(value = "/simpleList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> simpleList(@RequestParam(value = "keyword", required = false) String keyword) {
        List<CmsSubject> subjectList = subjectService.simpleList(keyword);
        return CommonResult.success(subjectList);
    }


}
