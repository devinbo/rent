package com.xxz.rent.mapper;

import com.xxz.rent.model.OtoOrderOperateHistory;
import com.xxz.rent.model.OtoOrderOperateHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtoOrderOperateHistoryMapper {
    long countByExample(OtoOrderOperateHistoryExample example);

    int deleteByExample(OtoOrderOperateHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OtoOrderOperateHistory record);

    int insertSelective(OtoOrderOperateHistory record);

    List<OtoOrderOperateHistory> selectByExample(OtoOrderOperateHistoryExample example);

    OtoOrderOperateHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OtoOrderOperateHistory record, @Param("example") OtoOrderOperateHistoryExample example);

    int updateByExample(@Param("record") OtoOrderOperateHistory record, @Param("example") OtoOrderOperateHistoryExample example);

    int updateByPrimaryKeySelective(OtoOrderOperateHistory record);

    int updateByPrimaryKey(OtoOrderOperateHistory record);
}