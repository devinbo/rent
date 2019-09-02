package com.xxz.rent.dao;

import com.xxz.rent.dto.PmsProductResult;
import com.xxz.rent.dto.PmsProductResult;
import com.xxz.rent.model.PmsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 商品自定义Dao
 * Created by macro on 2018/4/26.
 */
public interface PmsProductDao {
    /**
     * 获取商品编辑信息
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);

    /**  功能描述 <br>
     * <>
     *
     * @param cateId
     * @return java.util.List<com.xxz.rent.model.PmsProduct>
     * @date 2019-07-06 14:41
     */
    List<PmsProduct> getProductByCateId(@Param("cateId") Long cateId);

    /**  功能描述 <br>
     * <移除产品的分类信息>
     *
     * @param id
     * @return int
     * @date 2019-07-06 18:32
     */
    int deleteCate(@Param("id") Long id);
}
