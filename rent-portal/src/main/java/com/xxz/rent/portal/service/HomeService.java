package com.xxz.rent.portal.service;

import com.xxz.rent.model.CmsSubject;
import com.xxz.rent.model.PmsProduct;
import com.xxz.rent.model.PmsProductCategory;
import com.xxz.rent.portal.model.dto.HomeContentResult;
import com.xxz.rent.portal.model.dto.PmsProductResult;

import java.util.List;

/**
 * 首页内容管理Service
 * Created by macro on 2019/1/28.
 */
public interface HomeService {

    /**
     * 获取首页内容
     */
    HomeContentResult content();

    /**
     * 首页商品推荐
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * 获取商品分类
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     */
    List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * 根据专题分类分页获取专题
     * @param cateId 专题分类id
     */
    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);

    /**  功能描述 <br>
     * <分页获取二手优选>
     *
     * @param pageSize
     * @param pageNum
     * @return java.util.List<com.xxz.rent.model.PmsProduct>
     * @date 2019-07-16 11:25
     */
    List<PmsProduct> goodUsedProductList(Integer pageSize, Integer pageNum);

    /**  功能描述 <br>
     * <根据产品分类加载产品信息>
     *
     * @param id
     * @param pageNum
     * @param pageSize
     * @return java.util.List<com.xxz.rent.model.PmsProduct>
     * @date 2019-07-16 15:24
     */
    List<PmsProduct> productList(Long id, Integer pageNum, Integer pageSize);

    /**  功能描述 <br>
     * <分页加载某一专题下产品>
     *
     * @param id
     * @param pageNum
     * @param pageSize
     * @return java.util.List<com.xxz.rent.model.PmsProduct>
     * @date 2019-07-16 15:54
     */
    List<PmsProduct> getPorductListBySubjectId(Long id, Integer pageNum, Integer pageSize);

    /**  功能描述 <br>
     * <查询某一产品详情>
     *
     * @param id
     * @return com.xxz.rent.model.PmsProduct
     * @date 2019-07-16 16:16
     */
    PmsProductResult getProductDetail(Long id);
}
