package com.xxz.rent.portal.service;

import com.xxz.rent.portal.model.dto.AppVersion;
import com.xxz.rent.portal.model.dto.AppVersionResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xxz
 */
@Transactional
public interface SysVersionService {

    /**  功能描述 <br>
     * <检测是否有新版本>
     *
     * @param appVersion
     * @return com.xxz.rent.portal.model.dto.AppVersionResult
     * @date 2019-08-14 13:48
     */
    AppVersionResult checkUpdate(AppVersion appVersion);
}
