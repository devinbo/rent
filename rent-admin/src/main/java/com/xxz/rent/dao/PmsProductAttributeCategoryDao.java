package com.xxz.rent.dao;

import com.xxz.rent.dto.PmsProductAttributeCategoryItem;
import com.xxz.rent.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * 自定义商品属性分类Dao
 * Created by macro on 2018/5/24.
 */
public interface PmsProductAttributeCategoryDao {
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
