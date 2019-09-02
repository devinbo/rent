package com.xxz.rent.portal.dao;

import com.xxz.rent.model.CmsSubject;
import com.xxz.rent.model.PmsBrand;
import com.xxz.rent.model.PmsProduct;
import com.xxz.rent.model.SmsHomeActivity;
import com.xxz.rent.portal.model.dto.CmsSubjectResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 首页内容管理自定义Dao
 * Created by macro on 2019/1/28.
 */
public interface HomeDao {

    /**
     * 获取推荐品牌
     */
    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset,@Param("limit") Integer limit);


    /**
     * 获取人气推荐
     */
    List<PmsProduct> getHotProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 获取推荐专题
     */
    List<CmsSubjectResult> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取活动列表
     * @return
     */
    List<SmsHomeActivity> getActivityList();

    /**
     * 获取
     * return
     */
    List<PmsProduct> getGoodUsedProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**  功能描述 <br>
     * <根据分类加载产品信息>
     *
     * @param id
     * @return java.util.List<com.xxz.rent.model.PmsProduct>
     * @date 2019-07-16 15:59
     */
    List<PmsProduct> getPorductListBySubjectId(@Param("id") Long id);
}
