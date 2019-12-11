package com.xxz.rent.mapper;

import com.xxz.rent.model.OmsOrderPayLog;
import com.xxz.rent.model.OmsOrderPayLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderPayLogMapper {
    long countByExample(OmsOrderPayLogExample example);

    int deleteByExample(OmsOrderPayLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderPayLog record);

    int insertSelective(OmsOrderPayLog record);

    List<OmsOrderPayLog> selectByExample(OmsOrderPayLogExample example);

    OmsOrderPayLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsOrderPayLog record, @Param("example") OmsOrderPayLogExample example);

    int updateByExample(@Param("record") OmsOrderPayLog record, @Param("example") OmsOrderPayLogExample example);

    int updateByPrimaryKeySelective(OmsOrderPayLog record);

    int updateByPrimaryKey(OmsOrderPayLog record);
}