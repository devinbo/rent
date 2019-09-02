package com.xxz.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.mapper.OtoProductCategoryMapper;
import com.xxz.rent.model.OtoProductCategory;
import com.xxz.rent.model.OtoProductCategoryExample;
import com.xxz.rent.service.OtoCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-02 10:49
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class OtoCategoryServiceImpl implements OtoCategoryService {

    @Autowired
    private OtoProductCategoryMapper categoryMapper;

    @Override
    public List<OtoProductCategory> list(String name, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        OtoProductCategoryExample example = new OtoProductCategoryExample();
        if (!StringUtils.isEmpty(name)) {
            example.createCriteria().andNameLike("%" + name + "%");
        }
        return categoryMapper.selectByExample(example);
    }

    @Override
    public int create(OtoProductCategory otoProductCategory) {
        otoProductCategory.setCreateTime(new Date());
        return categoryMapper.insertSelective(otoProductCategory);
    }

    @Override
    public int update(Long id, OtoProductCategory otoProductCategory) {
        otoProductCategory.setId(id);
        return categoryMapper.updateByPrimaryKeySelective(otoProductCategory);
    }

    @Override
    public int delete(Long id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }
}
