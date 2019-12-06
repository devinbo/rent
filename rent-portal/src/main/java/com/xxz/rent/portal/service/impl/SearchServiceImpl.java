package com.xxz.rent.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.mapper.HomeHotWordMapper;
import com.xxz.rent.mapper.OtoProductMapper;
import com.xxz.rent.mapper.PmsProductMapper;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-16 15:44
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private PmsProductMapper pmsProductMapper;
    @Autowired
    private HomeHotWordMapper homeHotWordMapper;
    @Autowired
    private OtoProductMapper otoProductMapper;

    @Override
    public List<PmsProduct> query(String word, int pageNum, int pageSize) {
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andPublishStatusEqualTo(1)
                .andNameLike("%" + word + "%");
        PageHelper.startPage(pageNum, pageSize);
        return pmsProductMapper.selectByExample(example);
    }

    @Override
    public List<HomeHotWord> getHotWord() {
        return homeHotWordMapper.selectByExample(new HomeHotWordExample());
    }

    @Override
    public List<OtoProduct> queryPublish(String word, int pageNum, int pageSize) {
        OtoProductExample otoProductExample = new OtoProductExample();
        otoProductExample.createCriteria().andCategoryNameLike("%" + word + "%");
        PageHelper.startPage(pageNum, pageSize);
        return otoProductMapper.selectByExample(otoProductExample);
    }


}
