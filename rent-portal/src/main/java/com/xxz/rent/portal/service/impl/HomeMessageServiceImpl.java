package com.xxz.rent.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.mapper.SmsMessageMapper;
import com.xxz.rent.mapper.UmsMemberMessageMapper;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.dao.SmsMessageDao;
import com.xxz.rent.portal.service.HomeMessageService;
import com.xxz.rent.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-16 13:29
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class HomeMessageServiceImpl implements HomeMessageService {

    @Autowired
    private UmsMemberMessageMapper memberMessageMapper;
    @Autowired
    private SmsMessageDao smsMessageDao;
    @Autowired
    private SmsMessageMapper smsMessageMapper;
    @Autowired
    private UmsMemberService memberService;

    @Override
    public Long hasNoReadMsg() {
        UmsMember umsMember = memberService.getCurrentMember();
        if(umsMember == null) {
            return 0L;
        }
        //查询用户未读消息
        UmsMemberMessageExample example = new UmsMemberMessageExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andMemberIdEqualTo(umsMember.getId())
                .andReadStatusEqualTo(0);
        Long mbCount = memberMessageMapper.countByExample(example);
        //查询未读读公告消息,
        // TODO 公告不再做未读操作
        //Long count = smsMessageDao.getUnReadMessageCount(umsMember.getId());
        return mbCount;
    }

    @Override
    public List<SmsMessage> getCommonMessage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SmsMessageExample example = new SmsMessageExample();
        example.createCriteria().andDeleteStatusEqualTo(0);
        example.setOrderByClause("create_time desc");
        return smsMessageMapper.selectByExample(example);
    }

    @Override
    public List<UmsMemberMessage> getMemberMessages(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UmsMember umsMember = memberService.getCurrentMember();
        UmsMemberMessageExample example = new UmsMemberMessageExample();
        example.createCriteria().andMemberIdEqualTo(umsMember.getId());
        example.setOrderByClause("create_time desc");
        return memberMessageMapper.selectByExample(example);
    }


}
