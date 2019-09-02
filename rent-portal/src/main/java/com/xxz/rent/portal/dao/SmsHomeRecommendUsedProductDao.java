package com.xxz.rent.portal.dao;

import com.xxz.rent.model.PmsProduct;

import java.util.List;

/**
 * @author xxz
 */
public interface SmsHomeRecommendUsedProductDao {
    /**  功能描述 <br>
     * <二手优选>
     *
     * @param
     * @return java.util.List<com.xxz.rent.model.PmsProduct>
     * @date 2019-07-16 11:32
     */
    List<PmsProduct> recommendProductList();
}
