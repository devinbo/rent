package com.xxz.rent.portal.service;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.portal.model.dto.CartPromotionItem;
import com.xxz.rent.portal.model.dto.SmsCouponHistoryDetail;
import com.xxz.rent.portal.model.dto.SmsCouponHistoryResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户优惠券管理Service
 * Created by macro on 2018/8/29.
 */
@Transactional
public interface UmsMemberCouponService {
    /**
     * 会员添加优惠券
     */
    @Transactional
    CommonResult add(Long couponId);

    /**
     * 获取优惠券列表
     * @param useStatus 优惠券的使用状态
     * @return
     */
    List<SmsCouponHistoryResult> list(Integer useStatus);

    /**
     * 根据购物车信息获取可用优惠券
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type);
}
