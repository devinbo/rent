package com.xxz.rent.mapper;

import com.xxz.rent.model.SysVersionOnline;
import com.xxz.rent.model.SysVersionOnlineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysVersionOnlineMapper {
    long countByExample(SysVersionOnlineExample example);

    int deleteByExample(SysVersionOnlineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysVersionOnline record);

    int insertSelective(SysVersionOnline record);

    List<SysVersionOnline> selectByExample(SysVersionOnlineExample example);

    SysVersionOnline selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysVersionOnline record, @Param("example") SysVersionOnlineExample example);

    int updateByExample(@Param("record") SysVersionOnline record, @Param("example") SysVersionOnlineExample example);

    int updateByPrimaryKeySelective(SysVersionOnline record);

    int updateByPrimaryKey(SysVersionOnline record);
}