package com.xxz.rent.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.mapper.OtoProductCategoryMapper;
import com.xxz.rent.mapper.OtoProductMapper;
import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.OtoProductCategory;
import com.xxz.rent.model.OtoProductCategoryExample;
import com.xxz.rent.model.OtoProductExample;
import com.xxz.rent.portal.service.OtoHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-02 13:42
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class OtoHomeServiceImpl implements OtoHomeService {

    @Autowired
    private OtoProductCategoryMapper productCategoryMapper;

    @Autowired
    private OtoProductMapper productMapper;


    @Override
    public List<OtoProductCategory> cateList() {
        OtoProductCategoryExample example = new OtoProductCategoryExample();
        example.createCriteria().andNavStatusEqualTo(1).andShowStatusEqualTo(1);
        example.setOrderByClause("sort desc");
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public List<OtoProduct> list(Long categoryId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        OtoProductExample example = new OtoProductExample();
        OtoProductExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        example.setOrderByClause("sort desc");
        if(categoryId != null) {
            criteria.andCategoryIdEqualTo(categoryId);
        }
        return productMapper.selectByExample(example);
    }
}
