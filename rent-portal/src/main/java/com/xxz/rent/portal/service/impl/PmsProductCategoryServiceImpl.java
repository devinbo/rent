package com.xxz.rent.portal.service.impl;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.mapper.PmsProductCategoryMapper;
import com.xxz.rent.mapper.PmsProductMapper;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.dao.PmsProductCategoryDao;
import com.xxz.rent.portal.model.dto.PmsCateAvdResult;
import com.xxz.rent.portal.service.PmsProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-09 13:41
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {

    @Autowired
    private PmsProductCategoryMapper pmsProductCategoryMapper;

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Autowired
    private PmsProductCategoryDao pmsProductCategoryDao;


    @Override
    public List<PmsProductCategory> allList() {
        return pmsProductCategoryMapper.selectByExample(new PmsProductCategoryExample());
    }

    @Override
    public PmsCateAvdResult productList(Long cateId) {
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andProductCategoryIdEqualTo(cateId).andDeleteStatusEqualTo(0);
        List<PmsProduct> pmsProductList = pmsProductMapper.selectByExample(example);
        SmsCateAdvertise smsCateAdvertise = pmsProductCategoryDao.getCateAdvertise(cateId);

        PmsCateAvdResult pmsCateAvdResult = new PmsCateAvdResult();
        pmsCateAvdResult.setPmsProductList(pmsProductList);
        pmsCateAvdResult.setSmsCateAdvertise(smsCateAdvertise);
        return pmsCateAvdResult;
    }


}
