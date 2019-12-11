package com.xxz.rent.mapper;

import com.xxz.rent.model.OmsOrderPayment;
import com.xxz.rent.model.OmsOrderPaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderPaymentMapper {
    long countByExample(OmsOrderPaymentExample example);

    int deleteByExample(OmsOrderPaymentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderPayment record);

    int insertSelective(OmsOrderPayment record);

    List<OmsOrderPayment> selectByExample(OmsOrderPaymentExample example);

    OmsOrderPayment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsOrderPayment record, @Param("example") OmsOrderPaymentExample example);

    int updateByExample(@Param("record") OmsOrderPayment record, @Param("example") OmsOrderPaymentExample example);

    int updateByPrimaryKeySelective(OmsOrderPayment record);

    int updateByPrimaryKey(OmsOrderPayment record);
}