package com.xxz.rent.mapper;

import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.OtoProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtoProductMapper {
    long countByExample(OtoProductExample example);

    int deleteByExample(OtoProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OtoProduct record);

    int insertSelective(OtoProduct record);

    List<OtoProduct> selectByExample(OtoProductExample example);

    OtoProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OtoProduct record, @Param("example") OtoProductExample example);

    int updateByExample(@Param("record") OtoProduct record, @Param("example") OtoProductExample example);

    int updateByPrimaryKeySelective(OtoProduct record);

    int updateByPrimaryKey(OtoProduct record);
}