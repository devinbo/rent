package com.xxz.rent.mapper;

import com.xxz.rent.model.OtoOrderSetting;
import com.xxz.rent.model.OtoOrderSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtoOrderSettingMapper {
    long countByExample(OtoOrderSettingExample example);

    int deleteByExample(OtoOrderSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OtoOrderSetting record);

    int insertSelective(OtoOrderSetting record);

    List<OtoOrderSetting> selectByExample(OtoOrderSettingExample example);

    OtoOrderSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OtoOrderSetting record, @Param("example") OtoOrderSettingExample example);

    int updateByExample(@Param("record") OtoOrderSetting record, @Param("example") OtoOrderSettingExample example);

    int updateByPrimaryKeySelective(OtoOrderSetting record);

    int updateByPrimaryKey(OtoOrderSetting record);
}