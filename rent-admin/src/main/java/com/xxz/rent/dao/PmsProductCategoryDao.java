package com.xxz.rent.dao;

import com.xxz.rent.dto.PmsProductCategoryWithChildrenItem;
import com.xxz.rent.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * 商品分类自定义Dao
 * Created by macro on 2018/5/25.
 */
public interface PmsProductCategoryDao {
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
