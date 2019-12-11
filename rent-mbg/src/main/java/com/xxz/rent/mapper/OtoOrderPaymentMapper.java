package com.xxz.rent.mapper;

import com.xxz.rent.model.OtoOrderPayment;
import com.xxz.rent.model.OtoOrderPaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtoOrderPaymentMapper {
    long countByExample(OtoOrderPaymentExample example);

    int deleteByExample(OtoOrderPaymentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OtoOrderPayment record);

    int insertSelective(OtoOrderPayment record);

    List<OtoOrderPayment> selectByExample(OtoOrderPaymentExample example);

    OtoOrderPayment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OtoOrderPayment record, @Param("example") OtoOrderPaymentExample example);

    int updateByExample(@Param("record") OtoOrderPayment record, @Param("example") OtoOrderPaymentExample example);

    int updateByPrimaryKeySelective(OtoOrderPayment record);

    int updateByPrimaryKey(OtoOrderPayment record);
}