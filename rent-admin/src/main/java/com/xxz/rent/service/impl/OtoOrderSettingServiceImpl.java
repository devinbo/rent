package com.xxz.rent.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.xxz.rent.mapper.OtoOrderSettingMapper;
import com.xxz.rent.model.OtoOrderSetting;
import com.xxz.rent.model.OtoOrderSettingExample;
import com.xxz.rent.service.OtoOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-13 14:15
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class OtoOrderSettingServiceImpl implements OtoOrderSettingService {

    @Autowired
    private OtoOrderSettingMapper otoOrderSettingMapper;

    @Override
    public OtoOrderSetting get() {
        List<OtoOrderSetting> orderSettingList = otoOrderSettingMapper.selectByExample(new OtoOrderSettingExample());
        return CollectionUtil.isEmpty(orderSettingList) ? null : orderSettingList.get(0);
    }

    @Override
    public int update(OtoOrderSetting otoOrderSetting) {
        Long count = otoOrderSettingMapper.countByExample(new OtoOrderSettingExample());
        if(count > 0) {
            return otoOrderSettingMapper.updateByExampleSelective(otoOrderSetting, new OtoOrderSettingExample());
        }
        return otoOrderSettingMapper.insertSelective(otoOrderSetting);
    }

}
