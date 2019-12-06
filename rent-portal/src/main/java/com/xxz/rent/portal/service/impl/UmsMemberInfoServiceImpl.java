package com.xxz.rent.portal.service.impl;

import com.xxz.rent.mapper.*;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.bo.exception.BusinessLogicException;
import com.xxz.rent.portal.dao.UmsMemberInfoDao;
import com.xxz.rent.portal.model.dto.MemberResult;
import com.xxz.rent.portal.service.OssService;
import com.xxz.rent.portal.service.UmsMemberInfoService;
import com.xxz.rent.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-12 10:22
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class UmsMemberInfoServiceImpl implements UmsMemberInfoService {

    @Autowired
    private UmsMemberInfoDao memberInfoDao;
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private UmsMemberRealinformMapper memberRealinformMapper;
    @Autowired
    private UmsMemberKinsfolkMapper memberKinsfolkMapper;
    @Autowired
    private UmsMemberLinkMapper memberLinkMapper;
    @Autowired
    private UmsMemberAuthRelationMapper memberAuthRelationMapper;
    @Autowired
    private OssService ossService;
    @Autowired
    private UmsMemberMapper memberMapper;

    @Override
    public MemberResult allInfo() {
        UmsMember member = memberService.getCurrentMember();
        return memberInfoDao.getAllInfo(member.getId());
    }

    @Override
    public UmsMemberRealinform realinform() {
        UmsMemberRealinformExample example = new UmsMemberRealinformExample();
        example.createCriteria().andMemberIdEqualTo(memberService.getCurrentMember().getId());
        List<UmsMemberRealinform> realinformList =  memberRealinformMapper.selectByExample(example);
        if(realinformList == null || realinformList.size() == 0) {
            throw new BusinessLogicException("该客户尚未进行实名认证");
        }
        return realinformList.get(0);
    }

    @Override
    public UmsMemberKinsfolk kinsfolk() {
        UmsMemberKinsfolkExample example = new UmsMemberKinsfolkExample();
        example.createCriteria().andMemberIdEqualTo(memberService.getCurrentMember().getId());
        List<UmsMemberKinsfolk> kinsfolkList = memberKinsfolkMapper.selectByExample(example);
        if(kinsfolkList == null || kinsfolkList.size() == 0) {
            throw new BusinessLogicException("该客户尚未认证亲戚信息");
        }
        return kinsfolkList.get(0);
    }

    @Override
    public UmsMemberLink link() {
        UmsMemberLinkExample example = new UmsMemberLinkExample();
        example.createCriteria().andMemberIdEqualTo(memberService.getCurrentMember().getId());
        List<UmsMemberLink> memberLinkList = memberLinkMapper.selectByExample(example);
        if(memberLinkList == null || memberLinkList.size() == 0) {
            throw new BusinessLogicException("业务逻辑异常！");
        }
        return memberLinkList.get(0);
    }

    @Override
    public UmsMemberAuthRelation authRelation() {
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(memberService.getCurrentMember().getId());
        List<UmsMemberAuthRelation> relationList = memberAuthRelationMapper.selectByExample(example);
        if(relationList == null || relationList.size() == 0) {
            throw new BusinessLogicException("尚未进行常用联系人认证");
        }
        return relationList.get(0);
    }

    @Override
    public String uploadHeadIcon(MultipartFile file) throws IOException {
        String url = ossService.uploadWithFile(file);
        UmsMember member = memberService.getCurrentMember();
        member.setIcon(url);
        //保存用户信息
        memberMapper.updateByPrimaryKeySelective(member);
        return url;
    }

    @Override
    public int updateNick(String nick) {
        UmsMember member = memberService.getCurrentMember();
        member.setNickname(nick);
        return memberMapper.updateByPrimaryKeySelective(member);
    }
}
