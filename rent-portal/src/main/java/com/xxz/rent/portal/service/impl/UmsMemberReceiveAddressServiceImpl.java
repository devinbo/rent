package com.xxz.rent.portal.service.impl;

import com.xxz.rent.mapper.UmsMemberReceiveAddressMapper;
import com.xxz.rent.model.UmsMember;
import com.xxz.rent.model.UmsMemberReceiveAddress;
import com.xxz.rent.model.UmsMemberReceiveAddressExample;
import com.xxz.rent.portal.service.UmsMemberReceiveAddressService;
import com.xxz.rent.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户地址管理Service实现类
 * Created by macro on 2018/8/28.
 */
@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private UmsMemberReceiveAddressMapper addressMapper;

    @Override
    public int add(UmsMemberReceiveAddress address) {
        UmsMember currentMember = memberService.getCurrentMember();
        address.setMemberId(currentMember.getId());
        int count = addressMapper.insert(address);
        updateAddressStatus(address, currentMember.getId());
        return count;
    }

    @Override
    public int delete(Long id) {
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        return addressMapper.deleteByExample(example);
    }

    @Override
    public int update(Long id, UmsMemberReceiveAddress address) {
        address.setId(null);
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        int count = addressMapper.updateByExampleSelective(address,example);
        updateAddressStatus(address, currentMember.getId());
        return count;
    }

    private void updateAddressStatus(UmsMemberReceiveAddress address, Long memberId) {
        if (1 == address.getDefaultStatus()) {
            //只能设置一个默认
            UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
            example.createCriteria().andIdNotEqualTo(address.getId())
                    .andMemberIdEqualTo(memberId);
            UmsMemberReceiveAddress receiveAddress = new UmsMemberReceiveAddress();
            receiveAddress.setDefaultStatus(0);
            addressMapper.updateByExampleSelective(receiveAddress, example);
        }
    }

    @Override
    public List<UmsMemberReceiveAddress> list() {
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId());
        return addressMapper.selectByExample(example);
    }

    @Override
    public UmsMemberReceiveAddress getItem(Long id) {
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        List<UmsMemberReceiveAddress> addressList = addressMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(addressList)){
            return addressList.get(0);
        }
        return null;
    }
}
