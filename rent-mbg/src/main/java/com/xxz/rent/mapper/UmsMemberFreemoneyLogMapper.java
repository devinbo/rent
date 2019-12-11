package com.xxz.rent.mapper;

import com.xxz.rent.model.UmsMemberFreemoneyLog;
import com.xxz.rent.model.UmsMemberFreemoneyLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberFreemoneyLogMapper {
    long countByExample(UmsMemberFreemoneyLogExample example);

    int deleteByExample(UmsMemberFreemoneyLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberFreemoneyLog record);

    int insertSelective(UmsMemberFreemoneyLog record);

    List<UmsMemberFreemoneyLog> selectByExample(UmsMemberFreemoneyLogExample example);

    UmsMemberFreemoneyLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberFreemoneyLog record, @Param("example") UmsMemberFreemoneyLogExample example);

    int updateByExample(@Param("record") UmsMemberFreemoneyLog record, @Param("example") UmsMemberFreemoneyLogExample example);

    int updateByPrimaryKeySelective(UmsMemberFreemoneyLog record);

    int updateByPrimaryKey(UmsMemberFreemoneyLog record);
}