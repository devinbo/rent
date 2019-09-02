package com.xxz.rent.service.impl;

import com.xxz.rent.mapper.UmsMemberSettingMapper;
import com.xxz.rent.model.UmsMemberSetting;
import com.xxz.rent.model.UmsMemberSettingExample;
import com.xxz.rent.service.UmsMemberSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-12 18:52
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class UmsMemberSettingServiceImpl implements UmsMemberSettingService {

    @Autowired
    private UmsMemberSettingMapper memberSettingMapper;

    @Override
    public UmsMemberSetting getItem() {
        List<UmsMemberSetting> umsMemberSettingList = memberSettingMapper.selectByExample(new UmsMemberSettingExample());
        if (umsMemberSettingList == null || umsMemberSettingList.size() == 0) {
            return new UmsMemberSetting();
        } else {
            return umsMemberSettingList.get(0);
        }
    }

    @Override
    public int update(UmsMemberSetting memberSetting) {
        if (memberSetting.getId() != null) {
            return memberSettingMapper.updateByPrimaryKey(memberSetting);
        } else {
            return memberSettingMapper.insertSelective(memberSetting);
        }
    }
}
