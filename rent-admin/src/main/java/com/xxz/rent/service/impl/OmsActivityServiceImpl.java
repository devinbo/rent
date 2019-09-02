package com.xxz.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.mapper.SmsHomeActivityMapper;
import com.xxz.rent.model.SmsHomeActivity;
import com.xxz.rent.model.SmsHomeActivityExample;
import com.xxz.rent.service.OmsActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-12 13:42
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class OmsActivityServiceImpl implements OmsActivityService {

    @Autowired
    private SmsHomeActivityMapper activityMapper;

    @Override
    public List<SmsHomeActivity> list(String name, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        SmsHomeActivityExample example = new SmsHomeActivityExample();
        if(!StringUtils.isEmpty(name)) {
            example.createCriteria().andNameLike("%" + name + "%");
        }
        return activityMapper.selectByExample(example);
    }

    @Override
    public int create(SmsHomeActivity smsHomeActivity) {
        int count = activityMapper.insertSelective(smsHomeActivity);
        return count;
    }

    @Override
    public int update(Long id, SmsHomeActivity smsHomeActivity) {
        smsHomeActivity.setId(id);
        return activityMapper.updateByPrimaryKey(smsHomeActivity);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeActivityExample example = new SmsHomeActivityExample();
        example.createCriteria().andIdIn(ids);

        SmsHomeActivity activity = new SmsHomeActivity();
        activity.setDeleteStatus(1);
        return activityMapper.updateByExampleSelective(activity, example);
    }

    @Override
    public SmsHomeActivity get(Long id) {
        return activityMapper.selectByPrimaryKey(id);
    }
}
