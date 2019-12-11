package com.xxz.rent.mapper;

import com.xxz.rent.model.SmsHomeActivity;
import com.xxz.rent.model.SmsHomeActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsHomeActivityMapper {
    long countByExample(SmsHomeActivityExample example);

    int deleteByExample(SmsHomeActivityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeActivity record);

    int insertSelective(SmsHomeActivity record);

    List<SmsHomeActivity> selectByExample(SmsHomeActivityExample example);

    SmsHomeActivity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsHomeActivity record, @Param("example") SmsHomeActivityExample example);

    int updateByExample(@Param("record") SmsHomeActivity record, @Param("example") SmsHomeActivityExample example);

    int updateByPrimaryKeySelective(SmsHomeActivity record);

    int updateByPrimaryKey(SmsHomeActivity record);
}