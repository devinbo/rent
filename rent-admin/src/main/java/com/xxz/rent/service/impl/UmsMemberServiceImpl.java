package com.xxz.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dao.UmsMemberDao;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.dto.UmsMemberResult;
import com.xxz.rent.mapper.*;
import com.xxz.rent.model.*;
import com.xxz.rent.service.UmsAdminService;
import com.xxz.rent.service.UmsMemberService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-06-26 15:02
 * @description：会员管理Service
 * @modified By：
 * @version: ：1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private UmsMemberMapper memberMapper;

    @Autowired
    private UmsMemberKinsfolkMapper memberKinsfolkMapper;
    @Autowired
    private UmsMemberLinkMapper memberLinkMapper;
    @Autowired
    private UmsMemberReceiveAddressMapper memberReceiveAddressMapper;
    @Autowired
    private UmsMemberAuthRelationMapper memberAuthRelationMapper;
    @Autowired
    private UmsMemberRealinformMapper memberRealinformMapper;
    @Autowired
    private UmsMemberDao umsMemberDao;
    @Autowired
    private UmsMemberOperationMapper memberOperationMapper;
    @Autowired
    private UmsAdminService umsAdminService;

    @Override
    public List<UmsMember> list(String name, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        UmsMemberExample example = new UmsMemberExample();
        if (!StringUtils.isEmpty(name)) {
            example.createCriteria().andPhoneLike("%" + name + "%");
            example.or().andNameLike("%" + name + "%");
            example.or().andNicknameLike("%" + name + "%");
        }

        return memberMapper.selectByExample(example);
    }

    @Override
    public int updateBlockStatus(List<Long> ids, Integer blockStatus) {
        UmsMember umsMember = new UmsMember();
        umsMember.setStatus(blockStatus);
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andIdIn(ids);
        return memberMapper.updateByExampleSelective(umsMember, example);
    }

    @Override
    public UmsMemberResult getMemberDetail(Long id) {
        return umsMemberDao.getMemberDetail(id);
    }

    @Override
    public int update(Long id, UmsMember umsMember) {
        addMemberOperationByUpdate(id, "修改基本资料");
        umsMember.setId(id);
        return memberMapper.updateByPrimaryKeySelective(umsMember);
    }

    @Override
    public int updateRealInform(Long id, UmsMemberRealinform umsMemberRealinform) {
        addMemberOperationByUpdate(id, "修改实名资料");
        umsMemberRealinform.setId(id);
        return memberRealinformMapper.updateByPrimaryKeySelective(umsMemberRealinform);
    }

    @Override
    public int updateRealInformAndComplteAuth(Long id, UmsMemberRealinform umsMemberRealinform) {
        addMemberOperationByUpdate(id, "修改实名资料并认证通过");
        umsMemberRealinform.setId(id);
        int count = memberRealinformMapper.updateByPrimaryKeySelective(umsMemberRealinform);
        UmsMemberAuthRelation umsMemberAuthRelation = new UmsMemberAuthRelation();
        //通过实名认证
        umsMemberAuthRelation.setIdentityStatus(1);
        //通过个人资料认证
        umsMemberAuthRelation.setBaseinfoStatus(1);
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(id);
        memberAuthRelationMapper.updateByExampleSelective(umsMemberAuthRelation, example);
        return count;
    }

    @Override
    public int updateMemberReceiveAddress(Long id, UmsMemberReceiveAddress umsMemberReceiveAddress) {
        addMemberOperationByUpdate(id, "修改会员收货地址");
        umsMemberReceiveAddress.setId(id);
        return memberReceiveAddressMapper.updateByPrimaryKeySelective(umsMemberReceiveAddress);
    }

    @Override
    public int updateMemberKinsfolk(Long id, UmsMemberKinsfolk umsMemberKinsfolk) {
        addMemberOperationByUpdate(id, "修改亲属资料信息");
        umsMemberKinsfolk.setId(id);
        return memberKinsfolkMapper.updateByPrimaryKeySelective(umsMemberKinsfolk);
    }

    @Override
    public int updateMemberLink(Long id, UmsMemberLink umsMemberLink) {
        addMemberOperationByUpdate(id, "修改常用联系人资料信息");
        umsMemberLink.setId(id);
        return memberLinkMapper.updateByPrimaryKeySelective(umsMemberLink);
    }

    @Override
    public int updateMemberNote(Long id, String note) {
        UmsMember umsMember = new UmsMember();
        umsMember.setNote(note);
        umsMember.setId(id);
        return memberMapper.updateByPrimaryKeySelective(umsMember);
    }

    @Override
    public int updateMemberAuthRelation(Long id, UmsMemberAuthRelation memberAuthRelation) {
        addMemberOperationByUpdate(id, "修改会员认证项信息");
        memberAuthRelation.setId(id);
        return memberAuthRelationMapper.updateByPrimaryKeySelective(memberAuthRelation);
    }

    @Override
    public List<UmsMemberReceiveAddress> getShipAddress(Long id) {
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(id);
        return memberReceiveAddressMapper.selectByExample(example);
    }

    @Override
    public List<UmsMember> getMemberByKeyword(String keyword) {
        return umsMemberDao.getMemberByKeyword(keyword);
    }

    /**
     * 操作记录
     * @param type 操作类型 0->新建；1->修改；2->审核；3->冻结/解冻
     * @param note
     */
    @Override
    public void addMemberOperation(Long memberId, int type, String note) {
        UmsMemberOperation umsMemberOperation = new UmsMemberOperation();
        UmsAdmin umsAdmin = umsAdminService.getCurrLoginInfo();
        umsMemberOperation.setOperationUser(umsAdmin.getRealName());
        umsMemberOperation.setMemberId(memberId);
        umsMemberOperation.setOperationNote(note);
        umsMemberOperation.setOperationType(type);
        umsMemberOperation.setOperationTime(new Date());
        memberOperationMapper.insert(umsMemberOperation);
    }

    private void addMemberOperationByUpdate(Long memberId, String note) {
        addMemberOperation(memberId, 1,  note);
    }
}
