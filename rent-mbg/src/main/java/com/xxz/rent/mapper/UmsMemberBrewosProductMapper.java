package com.xxz.rent.mapper;

import com.xxz.rent.model.UmsMemberBrewosProduct;
import com.xxz.rent.model.UmsMemberBrewosProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberBrewosProductMapper {
    long countByExample(UmsMemberBrewosProductExample example);

    int deleteByExample(UmsMemberBrewosProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberBrewosProduct record);

    int insertSelective(UmsMemberBrewosProduct record);

    List<UmsMemberBrewosProduct> selectByExample(UmsMemberBrewosProductExample example);

    UmsMemberBrewosProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberBrewosProduct record, @Param("example") UmsMemberBrewosProductExample example);

    int updateByExample(@Param("record") UmsMemberBrewosProduct record, @Param("example") UmsMemberBrewosProductExample example);

    int updateByPrimaryKeySelective(UmsMemberBrewosProduct record);

    int updateByPrimaryKey(UmsMemberBrewosProduct record);
}