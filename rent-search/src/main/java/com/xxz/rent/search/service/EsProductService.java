package com.xxz.rent.search.service;

import com.xxz.rent.search.domain.EsProduct;
import com.xxz.rent.search.domain.EsProductRelatedInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 商品搜索管理Service
 * Created by macro on 2018/6/19.
 */
public interface EsProductService {
    /**
     * 从数据库中导入所有商品到ES
     */
    int importAll();

    /**
     * 根据id删除商品
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     */
    EsProduct create(Long id);

    /**
     * 批量删除商品
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索名称或者副标题
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 根据关键字搜索名称或者副标题复合查询
     */
    Page<EsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize,Integer sort);

    /**
     * 根据商品id推荐相关商品
     */
    Page<EsProduct> recommend(Long id, Integer pageNum, Integer pageSize);

    /**
     * 获取搜索词相关品牌、分类、属性
     */
    EsProductRelatedInfo searchRelatedInfo(String keyword);

    /**  功能描述 <br>
     * <搜索某一分类下的产品>
     *
     * @param cateId
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return org.springframework.data.domain.Page<com.xxz.rent.search.domain.EsProduct>
     * @date 2019-07-30 14:40
     */
    Page<EsProduct> searchWithCate(String cateId, String keyword, Integer pageNum, Integer pageSize);
}
