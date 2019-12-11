package com.xxz.rent.mapper;

import com.xxz.rent.model.SmsMessageMemberReadRelation;
import com.xxz.rent.model.SmsMessageMemberReadRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsMessageMemberReadRelationMapper {
    long countByExample(SmsMessageMemberReadRelationExample example);

    int deleteByExample(SmsMessageMemberReadRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsMessageMemberReadRelation record);

    int insertSelective(SmsMessageMemberReadRelation record);

    List<SmsMessageMemberReadRelation> selectByExample(SmsMessageMemberReadRelationExample example);

    SmsMessageMemberReadRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsMessageMemberReadRelation record, @Param("example") SmsMessageMemberReadRelationExample example);

    int updateByExample(@Param("record") SmsMessageMemberReadRelation record, @Param("example") SmsMessageMemberReadRelationExample example);

    int updateByPrimaryKeySelective(SmsMessageMemberReadRelation record);

    int updateByPrimaryKey(SmsMessageMemberReadRelation record);
}