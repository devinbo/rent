package com.xxz.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.mapper.OtoSiteMapper;
import com.xxz.rent.model.OtoSite;
import com.xxz.rent.model.OtoSiteExample;
import com.xxz.rent.service.OtoSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-23 18:05
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class OtoSiteServiceImpl implements OtoSiteService {

    @Autowired
    private OtoSiteMapper siteMapper;

    @Override
    public List<OtoSite> list(String name, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        OtoSiteExample example = new OtoSiteExample();
        OtoSiteExample.Criteria criteria = example.createCriteria().andDeleteStatusEqualTo(0);
        if(!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        return siteMapper.selectByExample(example);
    }

    @Override
    public int create(OtoSite otoSite) {
        otoSite.setDeleteStatus(0);
        return siteMapper.insertSelective(otoSite);
    }

    @Override
    public int update(Long id, OtoSite otoSite) {
        otoSite.setId(id);
        return siteMapper.updateByPrimaryKeySelective(otoSite);
    }

    @Override
    public int delete(Long id) {
        OtoSite site = new OtoSite();
        site.setId(id);
        site.setDeleteStatus(0);
        return siteMapper.updateByPrimaryKeySelective(site);
    }

}
