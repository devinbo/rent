package com.xxz.rent.mapper;

import com.xxz.rent.model.HomeHotWord;
import com.xxz.rent.model.HomeHotWordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeHotWordMapper {
    long countByExample(HomeHotWordExample example);

    int deleteByExample(HomeHotWordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeHotWord record);

    int insertSelective(HomeHotWord record);

    List<HomeHotWord> selectByExample(HomeHotWordExample example);

    HomeHotWord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeHotWord record, @Param("example") HomeHotWordExample example);

    int updateByExample(@Param("record") HomeHotWord record, @Param("example") HomeHotWordExample example);

    int updateByPrimaryKeySelective(HomeHotWord record);

    int updateByPrimaryKey(HomeHotWord record);
}