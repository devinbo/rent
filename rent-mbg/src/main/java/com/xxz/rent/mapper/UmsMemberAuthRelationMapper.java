package com.xxz.rent.mapper;

import com.xxz.rent.model.UmsMemberAuthRelation;
import com.xxz.rent.model.UmsMemberAuthRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberAuthRelationMapper {
    long countByExample(UmsMemberAuthRelationExample example);

    int deleteByExample(UmsMemberAuthRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberAuthRelation record);

    int insertSelective(UmsMemberAuthRelation record);

    List<UmsMemberAuthRelation> selectByExample(UmsMemberAuthRelationExample example);

    UmsMemberAuthRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberAuthRelation record, @Param("example") UmsMemberAuthRelationExample example);

    int updateByExample(@Param("record") UmsMemberAuthRelation record, @Param("example") UmsMemberAuthRelationExample example);

    int updateByPrimaryKeySelective(UmsMemberAuthRelation record);

    int updateByPrimaryKey(UmsMemberAuthRelation record);
}