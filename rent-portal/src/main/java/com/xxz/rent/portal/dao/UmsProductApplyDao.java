package com.xxz.rent.portal.dao;

import com.xxz.rent.portal.model.dto.PreOrderResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xxz
 */
public interface UmsProductApplyDao {

    PreOrderResult productApplyDao(@Param("skuId") Long skuId);

    List<PreOrderResult.CouponUseInfo> getCanUseCoupon(@Param("productCategoryId") Long productCategoryId, @Param("productId") Long productId, @Param("memberId") Long memberId);
}
