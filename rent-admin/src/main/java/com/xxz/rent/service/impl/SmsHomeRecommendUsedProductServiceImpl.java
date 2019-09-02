package com.xxz.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.mapper.SmsHomeRecommendProductMapper;
import com.xxz.rent.mapper.SmsHomeRecommendUsedProductMapper;
import com.xxz.rent.model.SmsHomeRecommendProduct;
import com.xxz.rent.model.SmsHomeRecommendProductExample;
import com.xxz.rent.model.SmsHomeRecommendUsedProduct;
import com.xxz.rent.model.SmsHomeRecommendUsedProductExample;
import com.xxz.rent.service.SmsHomeRecommendProductService;
import com.xxz.rent.service.SmsHomeRecommendUsedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 首页人气推荐管理Service实现类
 * Created by macro on 2018/11/7.
 */
@Service
public class SmsHomeRecommendUsedProductServiceImpl implements SmsHomeRecommendUsedProductService {
    @Autowired
    private SmsHomeRecommendUsedProductMapper recommendUsedProductMapper;
    @Override
    public int create(List<SmsHomeRecommendUsedProduct> homeRecommendUsedProductList) {
        for (SmsHomeRecommendUsedProduct recommendUsedProduct : homeRecommendUsedProductList) {
            recommendUsedProduct.setRecommendStatus(1);
            recommendUsedProduct.setSort(0);
            recommendUsedProductMapper.insert(recommendUsedProduct);
        }
        return homeRecommendUsedProductList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendUsedProduct recommendUsedProduct = new SmsHomeRecommendUsedProduct();
        recommendUsedProduct.setId(id);
        recommendUsedProduct.setSort(sort);
        return recommendUsedProductMapper.updateByPrimaryKeySelective(recommendUsedProduct);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeRecommendUsedProductExample example = new SmsHomeRecommendUsedProductExample();
        example.createCriteria().andIdIn(ids);
        return recommendUsedProductMapper.deleteByExample(example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeRecommendUsedProductExample example = new SmsHomeRecommendUsedProductExample();
        example.createCriteria().andIdIn(ids);
        SmsHomeRecommendUsedProduct record = new SmsHomeRecommendUsedProduct();
        record.setRecommendStatus(recommendStatus);
        return recommendUsedProductMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<SmsHomeRecommendUsedProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeRecommendUsedProductExample example = new SmsHomeRecommendUsedProductExample();
        SmsHomeRecommendUsedProductExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(productName)){
            criteria.andProductNameLike("%"+productName+"%");
        }
        if(recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return recommendUsedProductMapper.selectByExample(example);
    }
}
