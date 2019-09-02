package com.xxz.rent.portal.service;

import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.OtoProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface OtoHomeService {
    /**  功能描述 <br>
     * <分类列表>
     *
     * @param
     * @return java.util.List<com.xxz.rent.model.OtoProductCategory>
     * @date 2019-08-02 13:43
     */
    List<OtoProductCategory> cateList();

    /**  功能描述 <br>
     * <查询指定分类产品>
     *
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @return java.util.List<com.xxz.rent.model.OtoProduct>
     * @date 2019-08-02 13:50
     */
    List<OtoProduct> list(Long categoryId, Integer pageNum, Integer pageSize);
}
