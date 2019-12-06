package com.xxz.rent.portal.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.xxz.rent.mapper.SysVersionMapper;
import com.xxz.rent.mapper.SysVersionOnlineMapper;
import com.xxz.rent.model.SysVersion;
import com.xxz.rent.model.SysVersionExample;
import com.xxz.rent.model.SysVersionOnline;
import com.xxz.rent.model.SysVersionOnlineExample;
import com.xxz.rent.portal.model.dto.AppVersion;
import com.xxz.rent.portal.model.dto.AppVersionResult;
import com.xxz.rent.portal.service.SysVersionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-14 13:49
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Slf4j
@Service
public class SysVersionServiceImpl implements SysVersionService {

    @Autowired
    private SysVersionMapper sysVersionMapper;
    @Autowired
    private SysVersionOnlineMapper sysVersionOnlineMapper;

    @Override
    public AppVersionResult checkUpdate(AppVersion appVersion) {
        AppVersionResult result = new AppVersionResult();
        SysVersionExample example = new SysVersionExample();
        example.createCriteria().andTypeEqualTo(appVersion.getType());
        List<SysVersion> sysVersionList = sysVersionMapper.selectByExample(example);
        if (!CollectionUtil.isEmpty(sysVersionList)) {
            try{
                SysVersion sysVersion = sysVersionList.get(0);
                String newVersion = StrUtil.padAfter(sysVersion.getVersion().replaceAll("\\.", ""), 6, "0");
                String oldVersion = StrUtil.padAfter(appVersion.getVersion().replaceAll("\\.", ""), 6, "0");
                if(Integer.valueOf(newVersion) > Integer.valueOf(oldVersion)) {
                    result.setVersion(sysVersion.getVersion());
                    result.setUpdateFlg(true);
                    result.setUrl(sysVersion.getUrl());
                }
                return result;
            }catch (Exception e) {
                log.error(e.getMessage());
                return result;
            }
        } else {
            return result;
        }
    }

    @Override
    public SysVersionOnline online(AppVersion appVersion) {
        SysVersionOnlineExample example = new SysVersionOnlineExample();
        example.createCriteria().andVersionEqualTo(appVersion.getVersion()).andTypeEqualTo(appVersion.getType());
        List<SysVersionOnline> list = sysVersionOnlineMapper.selectByExample(example);
        if(list == null || list.size() == 0) {
            SysVersionOnline online = new SysVersionOnline();
            online.setVersion(appVersion.getVersion());
            online.setOnline(0);
            return online;
        }
        return list.get(0);
    }
}
