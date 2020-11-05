package com.xxz.rent.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.mapper.SmsCateAdvertiseMapper;
import com.xxz.rent.model.SmsCateAdvertise;
import com.xxz.rent.model.SmsCateAdvertiseExample;
import com.xxz.rent.service.SmsCateAdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-10 11:02
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class SmsCateAdvertiseServiceImpl implements SmsCateAdvertiseService {

    @Autowired
    private SmsCateAdvertiseMapper smsCateAdvertiseMapper;

    @Override
    public List<SmsCateAdvertise> list(String name, Long cateId, String endTime, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        SmsCateAdvertiseExample example = new SmsCateAdvertiseExample();
        SmsCateAdvertiseExample.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if(cateId != null) {
            criteria.andCateIdEqualTo(cateId);
        }
        if(!StrUtil.isEmpty(endTime)) {
            criteria.andEndTimeLessThanOrEqualTo(DateUtil.parse(endTime));
        }
        return smsCateAdvertiseMapper.selectByExample(example);
    }

    @Override
    public SmsCateAdvertise get(Long id) {
        return smsCateAdvertiseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return smsCateAdvertiseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int create(SmsCateAdvertise smsCateAdvertise) {
        return smsCateAdvertiseMapper.insertSelective(smsCateAdvertise);
    }

    @Override
    public int update(Long id, SmsCateAdvertise smsCateAdvertise) {
        smsCateAdvertise.setId(id);
        return smsCateAdvertiseMapper.updateByPrimaryKeySelective(smsCateAdvertise);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        SmsCateAdvertise smsCateAdvertise = new SmsCateAdvertise();
        smsCateAdvertise.setId(id);
        smsCateAdvertise.setStatus(status);
        return smsCateAdvertiseMapper.updateByPrimaryKeySelective(smsCateAdvertise);
    }
}
