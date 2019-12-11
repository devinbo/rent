package com.xxz.rent.mapper;

import com.xxz.rent.model.UmsMemberMessage;
import com.xxz.rent.model.UmsMemberMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberMessageMapper {
    long countByExample(UmsMemberMessageExample example);

    int deleteByExample(UmsMemberMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberMessage record);

    int insertSelective(UmsMemberMessage record);

    List<UmsMemberMessage> selectByExample(UmsMemberMessageExample example);

    UmsMemberMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberMessage record, @Param("example") UmsMemberMessageExample example);

    int updateByExample(@Param("record") UmsMemberMessage record, @Param("example") UmsMemberMessageExample example);

    int updateByPrimaryKeySelective(UmsMemberMessage record);

    int updateByPrimaryKey(UmsMemberMessage record);
}