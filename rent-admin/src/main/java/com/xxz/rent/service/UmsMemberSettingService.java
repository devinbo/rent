package com.xxz.rent.service;

import com.xxz.rent.model.UmsMemberSetting;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UmsMemberSettingService {
    /**  功能描述 <br>
     * <获取会员设置信息>
     *
     * @param
     * @return com.xxz.rent.model.UmsMemberSetting
     * @date 2019-07-12 18:52
     */
    UmsMemberSetting getItem();

    /**
     * 会员设置
     * @param memberSetting
     * @return
     */
    int update(UmsMemberSetting memberSetting);
}
