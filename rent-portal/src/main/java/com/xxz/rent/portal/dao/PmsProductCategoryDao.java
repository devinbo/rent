package com.xxz.rent.portal.dao;

import com.xxz.rent.model.SmsCateAdvertise;
import com.xxz.rent.portal.model.dto.PmsCateAvdResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xxz
 */
public interface PmsProductCategoryDao {

    List<PmsCateAvdResult> list();

    SmsCateAdvertise getCateAdvertise(@Param("cateId") Long cateId);
}
