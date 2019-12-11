package com.xxz.rent.mapper;

import com.xxz.rent.model.SysVersion;
import com.xxz.rent.model.SysVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysVersionMapper {
    long countByExample(SysVersionExample example);

    int deleteByExample(SysVersionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysVersion record);

    int insertSelective(SysVersion record);

    List<SysVersion> selectByExample(SysVersionExample example);

    SysVersion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysVersion record, @Param("example") SysVersionExample example);

    int updateByExample(@Param("record") SysVersion record, @Param("example") SysVersionExample example);

    int updateByPrimaryKeySelective(SysVersion record);

    int updateByPrimaryKey(SysVersion record);
}