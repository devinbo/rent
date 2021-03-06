package com.xxz.rent.service;

import com.xxz.rent.dto.PmsProductCategoryParam;
import com.xxz.rent.dto.PmsProductCategoryWithChildrenItem;
import com.xxz.rent.model.PmsProduct;
import com.xxz.rent.model.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品分类Service
 *
 * @author xxz
 */
public interface PmsProductCategoryService {
    @Transactional
    int create(PmsProductCategoryParam pmsProductCategoryParam);

    @Transactional
    int update(Long id, PmsProductCategoryParam pmsProductCategoryParam);

    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    int delete(Long id);

    PmsProductCategory getItem(Long id);

    int updateNavStatus(List<Long> ids, Integer navStatus);

    int updateShowStatus(List<Long> ids, Integer showStatus);

    List<PmsProductCategoryWithChildrenItem> listWithChildren();

    List<PmsProductCategory> firstList();

    List<PmsProductCategory> search(String name);
}
