package com.xxz.rent.mapper;

import com.xxz.rent.model.SmsMessage;
import com.xxz.rent.model.SmsMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsMessageMapper {
    long countByExample(SmsMessageExample example);

    int deleteByExample(SmsMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsMessage record);

    int insertSelective(SmsMessage record);

    List<SmsMessage> selectByExample(SmsMessageExample example);

    SmsMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsMessage record, @Param("example") SmsMessageExample example);

    int updateByExample(@Param("record") SmsMessage record, @Param("example") SmsMessageExample example);

    int updateByPrimaryKeySelective(SmsMessage record);

    int updateByPrimaryKey(SmsMessage record);
}