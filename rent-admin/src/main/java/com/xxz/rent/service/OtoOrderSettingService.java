package com.xxz.rent.service;

import com.xxz.rent.model.OtoOrderSetting;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xxz
 */
@Transactional
public interface OtoOrderSettingService {
    OtoOrderSetting get();

    int update(OtoOrderSetting otoOrderSetting);
}
