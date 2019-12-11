package com.xxz.rent.mapper;

import com.xxz.rent.model.UmsMemberSetting;
import com.xxz.rent.model.UmsMemberSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberSettingMapper {
    long countByExample(UmsMemberSettingExample example);

    int deleteByExample(UmsMemberSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberSetting record);

    int insertSelective(UmsMemberSetting record);

    List<UmsMemberSetting> selectByExample(UmsMemberSettingExample example);

    UmsMemberSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberSetting record, @Param("example") UmsMemberSettingExample example);

    int updateByExample(@Param("record") UmsMemberSetting record, @Param("example") UmsMemberSettingExample example);

    int updateByPrimaryKeySelective(UmsMemberSetting record);

    int updateByPrimaryKey(UmsMemberSetting record);
}