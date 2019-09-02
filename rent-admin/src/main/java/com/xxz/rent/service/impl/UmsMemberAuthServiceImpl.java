package com.xxz.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.dao.UmsMemberAuthDao;
import com.xxz.rent.dto.MemberMessageResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.dto.UmsMemberAuthResult;
import com.xxz.rent.dto.UmsMemberResult;
import com.xxz.rent.mapper.*;
import com.xxz.rent.model.*;
import com.xxz.rent.service.UmsMemberAuthService;
import com.xxz.rent.service.UmsMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-15 17:43
 * @description：会员认证信息service
 * @modified By：
 * @version: ：1.0
 */
@Service
public class UmsMemberAuthServiceImpl implements UmsMemberAuthService {

    @Autowired
    private UmsMemberAuthDao umsMemberAuthDao;
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private UmsMemberAuthRelationMapper authRelationMapper;
    @Autowired
    private UmsMemberMessageMapper memberMessageMapper;
    @Autowired
    private UmsMemberSettingMapper settingMapper;
    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private UmsMemberFreemoneyLogMapper memberFreemoneyLogMapper;
    @Autowired
    private UmsMemberRealinformMapper memberRealinformMapper;
    @Autowired
    private UmsMemberLinkMapper memberLinkMapper;
    @Autowired
    private UmsMemberKinsfolkMapper memberKinsfolkMapper;

    @Override
    public List<UmsMemberAuthResult> list(String name, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        return umsMemberAuthDao.list(name);
    }

    @Override
    public int auditPerson(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote) {
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        List<UmsMemberAuthRelation> authRelationList = authRelationMapper.selectByExample(example);
        if(authRelationList == null || authRelationList.size() == 0) {
            return 0;
        }
        UmsMemberAuthRelation authRelation = authRelationList.get(0);
        authRelation.setBaseinfoStatus(status);
        int count = authRelationMapper.updateByPrimaryKeySelective(authRelation);
        if(freeMoney == null) {
            //查询默认设置提升的额度
            List<UmsMemberSetting> settings = settingMapper.selectByExample(new UmsMemberSettingExample());
            if(settings != null && settings.size() > 0) {
                UmsMemberSetting umsMemberSetting = settings.get(0);
                freeMoney = umsMemberSetting.getBaseinfoAmount();
            }else{
                freeMoney = new BigDecimal(0);
            }
        }
        BigDecimal currFreeMoney = createFreeMoney(authRelation.getMemberId(), freeMoney, "审核个人信息");
        //创建消息
        String content = "";
        if(Objects.equals(status, 1)) {
            content = "您的个人资料信息已审核通过，本次免押额度提升" + freeMoney.toString() + "元；当前可用免押额度为：" + currFreeMoney.toString();
        }else{
            content = "您的个人资料信息审核被拒绝，拒绝原因：" + (StringUtils.isEmpty(rejustNote) ?  "" : rejustNote) + "； 可修改后重新提交审核";
        }
        //创建审核消息，通知客户
        createAuditMessage(authRelation.getMemberId(), content);
        //添加用户操作记录
        createAuditLog(authRelation.getMemberId(), status == 1 ? "个人信息审核通过" : "个人信息审核拒绝" );
        return count;
    }


    @Override
    public int auditKinsfolk(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote) {
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        List<UmsMemberAuthRelation> authRelationList = authRelationMapper.selectByExample(example);
        if(authRelationList == null || authRelationList.size() == 0) {
            return 0;
        }
        UmsMemberAuthRelation authRelation = authRelationList.get(0);
        authRelation.setKinsfolkStatus(status);
        int count = authRelationMapper.updateByPrimaryKeySelective(authRelation);
        if(freeMoney == null) {
            //查询默认设置提升的额度
            List<UmsMemberSetting> settings = settingMapper.selectByExample(new UmsMemberSettingExample());
            if(settings != null && settings.size() > 0) {
                UmsMemberSetting umsMemberSetting = settings.get(0);
                freeMoney = umsMemberSetting.getKinsfolkAmount();
            }else{
                freeMoney = new BigDecimal(0);
            }
        }
        BigDecimal currFreeMoney = createFreeMoney(authRelation.getMemberId(), freeMoney, "审核亲属");
        //创建消息
        String content = "";
        if(Objects.equals(status, 1)) {
            content = "您的亲属资料信息已审核通过，本次免押额度提升" + freeMoney.toString() + "元；当前可用免押额度为：" + currFreeMoney.toString();
        }else{
            content = "您的亲属资料信息审核被拒绝，拒绝原因：" + (StringUtils.isEmpty(rejustNote) ?  "" : rejustNote) + "； 可修改后重新提交审核";
        }
        //创建审核消息，通知客户
        createAuditMessage(authRelation.getMemberId(), content);
        //添加用户操作记录
        createAuditLog(authRelation.getMemberId(), status == 1 ? "亲属信息审核通过" : "亲属信息审核拒绝" );
        return count;
    }

    @Override
    public int saveAllMember(UmsMemberResult memberResult) {
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(memberResult, umsMember);
        memberMapper.updateByPrimaryKeySelective(umsMember);

        //保存个人和实名信息
        UmsMemberRealinform realinform = memberResult.getUmsMemberRealinform();
        memberRealinformMapper.updateByPrimaryKeySelective(realinform);
        //保存亲属信息
        UmsMemberKinsfolk kinsfolk = memberResult.getUmsMemberKinsfolk();
        memberKinsfolkMapper.updateByPrimaryKeySelective(kinsfolk);
        //保存联系人信息
        UmsMemberLink memberLink = memberResult.getUmsMemberLink();
        memberLinkMapper.updateByPrimaryKeySelective(memberLink);
        return 1;
    }

    @Override
    public int auditLink(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote) {
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        List<UmsMemberAuthRelation> authRelationList = authRelationMapper.selectByExample(example);
        if(authRelationList == null || authRelationList.size() == 0) {
            return 0;
        }
        UmsMemberAuthRelation authRelation = authRelationList.get(0);
        authRelation.setLinkStatus(status);
        int count = authRelationMapper.updateByPrimaryKeySelective(authRelation);
        if(freeMoney == null) {
            //查询默认设置提升的额度
            List<UmsMemberSetting> settings = settingMapper.selectByExample(new UmsMemberSettingExample());
            if(settings != null && settings.size() > 0) {
                UmsMemberSetting umsMemberSetting = settings.get(0);
                freeMoney = umsMemberSetting.getLinkAmount();
            }else{
                freeMoney = new BigDecimal(0);
            }
        }
        BigDecimal currFreeMoney = createFreeMoney(authRelation.getMemberId(), freeMoney, "审核联系人");
        //创建消息
        String content = "";
        if(Objects.equals(status, 1)) {
            content = "您的联系人资料信息已审核通过，本次免押额度提升" + freeMoney.toString() + "元；当前可用免押额度为：" + currFreeMoney.toString();
        }else{
            content = "您的联系人资料信息审核被拒绝，拒绝原因：" + (StringUtils.isEmpty(rejustNote) ?  "" : rejustNote) + "； 可修改后重新提交审核";
        }
        //创建审核消息，通知客户
        createAuditMessage(authRelation.getMemberId(), content);
        //添加用户操作记录
        createAuditLog(authRelation.getMemberId(), status == 1 ? "联系人信息审核通过" : "联系人信息审核拒绝" );
        return count;
    }

    @Override
    public int auditMobile(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote) {
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        List<UmsMemberAuthRelation> authRelationList = authRelationMapper.selectByExample(example);
        if(authRelationList == null || authRelationList.size() == 0) {
            return 0;
        }
        UmsMemberAuthRelation authRelation = authRelationList.get(0);
        authRelation.setMobileStatus(status);
        int count = authRelationMapper.updateByPrimaryKeySelective(authRelation);
        if(freeMoney == null) {
            //查询默认设置提升的额度
            List<UmsMemberSetting> settings = settingMapper.selectByExample(new UmsMemberSettingExample());
            if(settings != null && settings.size() > 0) {
                UmsMemberSetting umsMemberSetting = settings.get(0);
                freeMoney = umsMemberSetting.getMobileAmount();
            }else{
                freeMoney = new BigDecimal(0);
            }
        }
        BigDecimal currFreeMoney = createFreeMoney(authRelation.getMemberId(), freeMoney, "审核手机");
        //创建消息
        String content = "";
        if(Objects.equals(status, 1)) {
            content = "您的运营商资料信息已审核通过，本次免押额度提升" + freeMoney.toString() + "元；当前可用免押额度为：" + currFreeMoney.toString();
        }else{
            content = "您的运营商资料信息审核被拒绝，拒绝原因：" + (StringUtils.isEmpty(rejustNote) ?  "" : rejustNote) + "； 可修改后重新提交审核";
        }
        //创建审核消息，通知客户
        createAuditMessage(authRelation.getMemberId(), content);
        //添加用户操作记录
        createAuditLog(authRelation.getMemberId(), status == 1 ? "运营商信息审核通过" : "运营商信息审核拒绝" );
        return count;
    }

    @Override
    public int auditTaobao(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote) {
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        List<UmsMemberAuthRelation> authRelationList = authRelationMapper.selectByExample(example);
        if(authRelationList == null || authRelationList.size() == 0) {
            return 0;
        }
        UmsMemberAuthRelation authRelation = authRelationList.get(0);
        authRelation.setTaobaoStatus(status);
        int count = authRelationMapper.updateByPrimaryKeySelective(authRelation);
        if(freeMoney == null) {
            //查询默认设置提升的额度
            List<UmsMemberSetting> settings = settingMapper.selectByExample(new UmsMemberSettingExample());
            if(settings != null && settings.size() > 0) {
                UmsMemberSetting umsMemberSetting = settings.get(0);
                freeMoney = umsMemberSetting.getTaobaoAmount();
            }else{
                freeMoney = new BigDecimal(0);
            }
        }
        BigDecimal currFreeMoney = createFreeMoney(authRelation.getMemberId(), freeMoney, "审核淘宝");
        //创建消息
        String content = "";
        if(Objects.equals(status, 1)) {
            content = "您的淘宝资料信息已审核通过，本次免押额度提升" + freeMoney.toString() + "元；当前可用免押额度为：" + currFreeMoney.toString();
        }else{
            content = "您的淘宝资料信息审核被拒绝，拒绝原因：" + (StringUtils.isEmpty(rejustNote) ?  "" : rejustNote) + "； 可修改后重新提交审核";
        }
        //创建审核消息，通知客户
        createAuditMessage(authRelation.getMemberId(), content);
        //添加用户操作记录
        createAuditLog(authRelation.getMemberId(), status == 1 ? "淘宝信息审核通过" : "淘宝信息审核拒绝" );
        return count;
    }

    @Override
    public int auditStudy(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote) {
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        List<UmsMemberAuthRelation> authRelationList = authRelationMapper.selectByExample(example);
        if(authRelationList == null || authRelationList.size() == 0) {
            return 0;
        }
        UmsMemberAuthRelation authRelation = authRelationList.get(0);
        authRelation.setStudyStatus(status);
        int count = authRelationMapper.updateByPrimaryKeySelective(authRelation);
        if(freeMoney == null) {
            //查询默认设置提升的额度
            List<UmsMemberSetting> settings = settingMapper.selectByExample(new UmsMemberSettingExample());
            if(settings != null && settings.size() > 0) {
                UmsMemberSetting umsMemberSetting = settings.get(0);
                freeMoney = umsMemberSetting.getStudyAmount();
            }else{
                freeMoney = new BigDecimal(0);
            }
        }
        BigDecimal currFreeMoney = createFreeMoney(authRelation.getMemberId(), freeMoney, "审核学信网");
        //创建消息
        String content = "";
        if(Objects.equals(status, 1)) {
            content = "您的学信网资料信息已审核通过，本次免押额度提升" + freeMoney.toString() + "元；当前可用免押额度为：" + currFreeMoney.toString();
        }else{
            content = "您的学信网信息审核被拒绝，拒绝原因：" + (StringUtils.isEmpty(rejustNote) ?  "" : rejustNote) + "； 可修改后重新提交审核";
        }
        //创建审核消息，通知客户
        createAuditMessage(authRelation.getMemberId(), content);
        //添加用户操作记录
        createAuditLog(authRelation.getMemberId(), status == 1 ? "学信网信息审核通过" : "学信网信息审核拒绝" );
        return count;
    }

    private void createAuditLog(Long memberId, String note) {
        memberService.addMemberOperation(memberId, 2, note);
    }

    //生成额度明细及其当前额度
    private BigDecimal createFreeMoney(Long memberId, BigDecimal freeMoney, String note) {
        //设置额度提升
        UmsMember member = memberMapper.selectByPrimaryKey(memberId);
        BigDecimal memberCurrFreeMoney = member.getFreeMoney() != null ? member.getFreeMoney().add(freeMoney) : freeMoney;
        member.setFreeMoney(memberCurrFreeMoney);
        memberMapper.updateByPrimaryKey(member);

        //查询额度明细
        UmsMemberFreemoneyLog freemoneyLog = new UmsMemberFreemoneyLog();
        freemoneyLog.setMemberId(memberId);
        freemoneyLog.setMoney(freeMoney);
        freemoneyLog.setCreateTime(new Date());
        freemoneyLog.setNote(note);
        memberFreemoneyLogMapper.insertSelective(freemoneyLog);
        return memberCurrFreeMoney;
    }

    private void createAuditMessage(Long memberId, String content) {
        UmsMemberMessage message = new UmsMemberMessage();
        message.setMemberId(memberId);
        message.setTitle("审核通知");
        message.setContent(content);
        memberMessageMapper.insertSelective(message);
    }
}
