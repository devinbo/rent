package com.xxz.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.mapper.UmsMemberOperationMapper;
import com.xxz.rent.model.UmsMemberOperation;
import com.xxz.rent.model.UmsMemberOperationExample;
import com.xxz.rent.service.UmsMemberOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-06-28 10:49
 * @description：会员资料操作记录
 * @modified By：
 * @version: ：1.0
 */
@Service
public class UmsMemberOperationServiceImpl implements UmsMemberOperationService {

    @Autowired
    private UmsMemberOperationMapper memberOperationMapper;

    @Override
    public List<UmsMemberOperation> list(Long memberId, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        UmsMemberOperationExample example = new UmsMemberOperationExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        example.setOrderByClause("operation_time desc");
        return memberOperationMapper.selectByExample(example);
    }
}
