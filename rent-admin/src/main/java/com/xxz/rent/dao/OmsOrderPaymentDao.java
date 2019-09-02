package com.xxz.rent.dao;

import com.xxz.rent.model.OmsOrderPayment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xxz
 */
public interface OmsOrderPaymentDao {
    int insertList(@Param("list") List<OmsOrderPayment> orderPaymentList);

    OmsOrderPayment getNextPayment(@Param("id") Long id);
}
