package com.xxz.rent.portal.dao;

import com.xxz.rent.model.PmsProduct;

import java.util.List;

/**
 * @author xxz
 */
public interface SmsHomeRecommendProductDao {
    /**  功能描述 <br>
     * <获取推荐产品Dao>
     *
     * @param
     * @return java.util.List<com.xxz.rent.model.PmsProduct>
     * @date 2019-07-16 11:29
     */
    List<PmsProduct> goodUsedProductList();
}
