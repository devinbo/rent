package com.xxz.rent.mapper;

import com.xxz.rent.model.OtoOrderPayLog;
import com.xxz.rent.model.OtoOrderPayLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtoOrderPayLogMapper {
    long countByExample(OtoOrderPayLogExample example);

    int deleteByExample(OtoOrderPayLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OtoOrderPayLog record);

    int insertSelective(OtoOrderPayLog record);

    List<OtoOrderPayLog> selectByExample(OtoOrderPayLogExample example);

    OtoOrderPayLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OtoOrderPayLog record, @Param("example") OtoOrderPayLogExample example);

    int updateByExample(@Param("record") OtoOrderPayLog record, @Param("example") OtoOrderPayLogExample example);

    int updateByPrimaryKeySelective(OtoOrderPayLog record);

    int updateByPrimaryKey(OtoOrderPayLog record);
}