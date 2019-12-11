package com.xxz.rent.mapper;

import com.xxz.rent.model.UmsMemberKinsfolk;
import com.xxz.rent.model.UmsMemberKinsfolkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberKinsfolkMapper {
    long countByExample(UmsMemberKinsfolkExample example);

    int deleteByExample(UmsMemberKinsfolkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberKinsfolk record);

    int insertSelective(UmsMemberKinsfolk record);

    List<UmsMemberKinsfolk> selectByExample(UmsMemberKinsfolkExample example);

    UmsMemberKinsfolk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberKinsfolk record, @Param("example") UmsMemberKinsfolkExample example);

    int updateByExample(@Param("record") UmsMemberKinsfolk record, @Param("example") UmsMemberKinsfolkExample example);

    int updateByPrimaryKeySelective(UmsMemberKinsfolk record);

    int updateByPrimaryKey(UmsMemberKinsfolk record);
}