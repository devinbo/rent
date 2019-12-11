package com.xxz.rent.mapper;

import com.xxz.rent.model.UmsMemberRealinform;
import com.xxz.rent.model.UmsMemberRealinformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberRealinformMapper {
    long countByExample(UmsMemberRealinformExample example);

    int deleteByExample(UmsMemberRealinformExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberRealinform record);

    int insertSelective(UmsMemberRealinform record);

    List<UmsMemberRealinform> selectByExample(UmsMemberRealinformExample example);

    UmsMemberRealinform selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberRealinform record, @Param("example") UmsMemberRealinformExample example);

    int updateByExample(@Param("record") UmsMemberRealinform record, @Param("example") UmsMemberRealinformExample example);

    int updateByPrimaryKeySelective(UmsMemberRealinform record);

    int updateByPrimaryKey(UmsMemberRealinform record);
}