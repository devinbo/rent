package com.xxz.rent.mapper;

import com.xxz.rent.model.UmsMemberOpertion;
import com.xxz.rent.model.UmsMemberOpertionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberOpertionMapper {
    long countByExample(UmsMemberOpertionExample example);

    int deleteByExample(UmsMemberOpertionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberOpertion record);

    int insertSelective(UmsMemberOpertion record);

    List<UmsMemberOpertion> selectByExample(UmsMemberOpertionExample example);

    UmsMemberOpertion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberOpertion record, @Param("example") UmsMemberOpertionExample example);

    int updateByExample(@Param("record") UmsMemberOpertion record, @Param("example") UmsMemberOpertionExample example);

    int updateByPrimaryKeySelective(UmsMemberOpertion record);

    int updateByPrimaryKey(UmsMemberOpertion record);
}