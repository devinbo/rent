package com.xxz.rent.portal.dao;

import com.xxz.rent.portal.model.dto.OmsOrderResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xxz
 */
public interface OmsOrderDao {

    boolean countBySameProduct(@Param("porductId") Long porductId);

    List<OmsOrderResult> list(@Param("status") int status, @Param("memberId") Long memberId);

    OmsOrderResult getOrderDetail(@Param("id") Long id, @Param("memberId") Long memberId);
}
