package com.xxz.rent.mapper;

import com.xxz.rent.model.BbsCategory;
import com.xxz.rent.model.BbsCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsCategoryMapper {
    long countByExample(BbsCategoryExample example);

    int deleteByExample(BbsCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BbsCategory record);

    int insertSelective(BbsCategory record);

    List<BbsCategory> selectByExample(BbsCategoryExample example);

    BbsCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BbsCategory record, @Param("example") BbsCategoryExample example);

    int updateByExample(@Param("record") BbsCategory record, @Param("example") BbsCategoryExample example);

    int updateByPrimaryKeySelective(BbsCategory record);

    int updateByPrimaryKey(BbsCategory record);
}