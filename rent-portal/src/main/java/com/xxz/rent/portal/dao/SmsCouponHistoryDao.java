package com.xxz.rent.portal.dao;

import com.xxz.rent.model.SmsCoupon;
import com.xxz.rent.portal.model.dto.SmsCouponHistoryDetail;
import com.xxz.rent.portal.model.dto.SmsCouponHistoryResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员优惠券领取历史自定义Dao
 * Created by macro on 2018/8/29.
 */
public interface SmsCouponHistoryDao {
    List<SmsCouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);

    List<SmsCouponHistoryResult> list(@Param("memberId") Long memberId, @Param("useStatus") Integer useStatus);

    SmsCoupon getCouponByHistoryId(@Param("couponId") Long couponId);
}
