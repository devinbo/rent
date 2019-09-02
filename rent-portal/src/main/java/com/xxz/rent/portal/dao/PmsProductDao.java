package com.xxz.rent.portal.dao;

import com.xxz.rent.model.PmsProduct;
import com.xxz.rent.portal.model.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author xxz
 */
public interface PmsProductDao {

    PmsProductResult getProductDetail(@Param("id") Long id);

    List<Map<String, Object>> getProductSkuAttributes(@Param("productAttributeCategoryId") Long productAttributeCategoryId);

    PmsProduct getProductBySkuId(@Param("skuId") Long skuId);

}
