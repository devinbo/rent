package com.xxz.rent.mapper;

import com.xxz.rent.model.UmsMemberOperation;
import com.xxz.rent.model.UmsMemberOperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberOperationMapper {
    long countByExample(UmsMemberOperationExample example);

    int deleteByExample(UmsMemberOperationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberOperation record);

    int insertSelective(UmsMemberOperation record);

    List<UmsMemberOperation> selectByExample(UmsMemberOperationExample example);

    UmsMemberOperation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberOperation record, @Param("example") UmsMemberOperationExample example);

    int updateByExample(@Param("record") UmsMemberOperation record, @Param("example") UmsMemberOperationExample example);

    int updateByPrimaryKeySelective(UmsMemberOperation record);

    int updateByPrimaryKey(UmsMemberOperation record);
}