package com.xxz.rent.mapper;

import com.xxz.rent.model.OtoProductCategory;
import com.xxz.rent.model.OtoProductCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtoProductCategoryMapper {
    long countByExample(OtoProductCategoryExample example);

    int deleteByExample(OtoProductCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OtoProductCategory record);

    int insertSelective(OtoProductCategory record);

    List<OtoProductCategory> selectByExampleWithBLOBs(OtoProductCategoryExample example);

    List<OtoProductCategory> selectByExample(OtoProductCategoryExample example);

    OtoProductCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OtoProductCategory record, @Param("example") OtoProductCategoryExample example);

    int updateByExampleWithBLOBs(@Param("record") OtoProductCategory record, @Param("example") OtoProductCategoryExample example);

    int updateByExample(@Param("record") OtoProductCategory record, @Param("example") OtoProductCategoryExample example);

    int updateByPrimaryKeySelective(OtoProductCategory record);

    int updateByPrimaryKeyWithBLOBs(OtoProductCategory record);

    int updateByPrimaryKey(OtoProductCategory record);
}