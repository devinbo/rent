package com.xxz.rent.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.mapper.UmsIntegrationChangeHistoryMapper;
import com.xxz.rent.mapper.UmsMemberIntegralMapper;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.model.dto.UmsIntegrationResult;
import com.xxz.rent.portal.service.UmsIntegrationService;
import com.xxz.rent.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-24 10:03
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class UmsIntegrationServiceImpl implements UmsIntegrationService {

    @Autowired
    private UmsMemberIntegralMapper integralMapper;
    @Autowired
    private UmsMemberService umsMemberService;


    @Override
    public UmsIntegrationResult list(int pageNum, int pageSize) {
        UmsMember umsMember = umsMemberService.getCurrentMemberByDb();
        UmsIntegrationResult result = new UmsIntegrationResult();
        result.setTotolIntegration(umsMember.getIntegration());

        PageHelper.startPage(pageNum, pageSize);
        UmsMemberIntegralExample example = new UmsMemberIntegralExample();
        example.createCriteria().andMemberIdEqualTo(umsMember.getId());
        List<UmsMemberIntegral> list = integralMapper.selectByExample(example);
        result.setIntegralList(new PageInfo<>(list).getList());
        return result;
    }



}
