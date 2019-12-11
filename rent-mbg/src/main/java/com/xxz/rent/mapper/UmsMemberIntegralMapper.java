package com.xxz.rent.mapper;

import com.xxz.rent.model.UmsMemberIntegral;
import com.xxz.rent.model.UmsMemberIntegralExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberIntegralMapper {
    long countByExample(UmsMemberIntegralExample example);

    int deleteByExample(UmsMemberIntegralExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberIntegral record);

    int insertSelective(UmsMemberIntegral record);

    List<UmsMemberIntegral> selectByExample(UmsMemberIntegralExample example);

    UmsMemberIntegral selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberIntegral record, @Param("example") UmsMemberIntegralExample example);

    int updateByExample(@Param("record") UmsMemberIntegral record, @Param("example") UmsMemberIntegralExample example);

    int updateByPrimaryKeySelective(UmsMemberIntegral record);

    int updateByPrimaryKey(UmsMemberIntegral record);
}