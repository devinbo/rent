package com.xxz.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.mapper.SmsMessageMapper;
import com.xxz.rent.model.SmsMessage;
import com.xxz.rent.model.SmsMessageExample;
import com.xxz.rent.service.SmsMessageService;
import com.xxz.rent.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-15 10:54
 * @description：消息管理service
 * @modified By：
 * @version: ：1.0
 */
@Service
public class SmsMessageServiceImpl implements SmsMessageService {
    @Autowired
    private SmsMessageMapper smsMessageMapper;
    @Autowired
    private UmsAdminService umsAdminService;

    @Override
    public List<SmsMessage> list(String name, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        SmsMessageExample example = new SmsMessageExample();
        example.createCriteria().andDeleteStatusEqualTo(0);
        if(!StringUtils.isEmpty(name)) {
            example.getOredCriteria().get(0).andTitleLike("%" + name + "%");
        }
        return smsMessageMapper.selectByExample(example);
    }

    @Override
    public SmsMessage getMessage(Long id) {
        return smsMessageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addMessage(SmsMessage smsMessage) {
        smsMessage.setCreateUser(umsAdminService.getCurrLoginInfo().getUsername());
        smsMessage.setCreateTime(new Date());
        return smsMessageMapper.insertSelective(smsMessage);
    }

    @Override
    public int updateMessage(Long id, SmsMessage smsMessage) {
        smsMessage.setId(id);
        return smsMessageMapper.updateByPrimaryKey(smsMessage);
    }

    @Override
    public int deleteMessage(Long id) {
        SmsMessage message = new SmsMessage();
        message.setId(id);
        message.setDeleteStatus(1);
        return smsMessageMapper.updateByPrimaryKeySelective(message);
    }


}
