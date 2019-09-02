package com.xxz.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.dao.UmsMemberMessageDao;
import com.xxz.rent.dto.MemberMessageResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.mapper.UmsMemberMessageMapper;
import com.xxz.rent.model.SmsMessage;
import com.xxz.rent.model.UmsMemberMessage;
import com.xxz.rent.model.UmsMemberMessageExample;
import com.xxz.rent.service.UmsAdminService;
import com.xxz.rent.service.UmsMemberMessageService;
import com.xxz.rent.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-15 13:40
 * @description：会员消息Service
 * @modified By：
 * @version: ：1.0
 */
@Service
public class UmsMemberMessageServiceImpl implements UmsMemberMessageService {

    @Autowired
    private UmsMemberMessageMapper memberMessageMapper;

    @Autowired
    private UmsMemberMessageDao memberMessageDao;
    @Autowired
    private UmsAdminService umsAdminService;

    @Override
    public List<MemberMessageResult> list(String name, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        return memberMessageDao.list(name);
    }

    @Override
    public MemberMessageResult getMessage(Long id) {
        return memberMessageDao.getMessage(id);
    }

    @Override
    public int addMessage(UmsMemberMessage umsMemberMessage) {
        umsMemberMessage.setCreateTime(new Date());
        umsMemberMessage.setCreateUser(umsAdminService.getCurrLoginInfo().getUsername());
        return memberMessageMapper.insertSelective(umsMemberMessage);
    }

    @Override
    public int updateMessage(Long id, UmsMemberMessage umsMemberMessage) {
        umsMemberMessage.setId(id);
        return memberMessageMapper.updateByPrimaryKey(umsMemberMessage);
    }

    @Override
    public int deleteMessage(Long id) {
        UmsMemberMessage message = new UmsMemberMessage();
        message.setId(id);
        message.setDeleteStatus(1);
        return memberMessageMapper.updateByPrimaryKeySelective(message);
    }
}
