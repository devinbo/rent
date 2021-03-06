package com.xxz.rent.service.impl;

import com.xxz.rent.mapper.CmsPrefrenceAreaMapper;
import com.xxz.rent.model.CmsPrefrenceArea;
import com.xxz.rent.model.CmsPrefrenceAreaExample;
import com.xxz.rent.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 * Created by macro on 2018/6/1.
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
