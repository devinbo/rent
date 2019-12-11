package com.xxz.rent.mapper;

import com.xxz.rent.model.OtoOrder;
import com.xxz.rent.model.OtoOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtoOrderMapper {
    long countByExample(OtoOrderExample example);

    int deleteByExample(OtoOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OtoOrder record);

    int insertSelective(OtoOrder record);

    List<OtoOrder> selectByExample(OtoOrderExample example);

    OtoOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OtoOrder record, @Param("example") OtoOrderExample example);

    int updateByExample(@Param("record") OtoOrder record, @Param("example") OtoOrderExample example);

    int updateByPrimaryKeySelective(OtoOrder record);

    int updateByPrimaryKey(OtoOrder record);
}