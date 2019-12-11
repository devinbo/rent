package com.xxz.rent.mapper;

import com.xxz.rent.model.SmsCateAdvertise;
import com.xxz.rent.model.SmsCateAdvertiseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsCateAdvertiseMapper {
    long countByExample(SmsCateAdvertiseExample example);

    int deleteByExample(SmsCateAdvertiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsCateAdvertise record);

    int insertSelective(SmsCateAdvertise record);

    List<SmsCateAdvertise> selectByExample(SmsCateAdvertiseExample example);

    SmsCateAdvertise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsCateAdvertise record, @Param("example") SmsCateAdvertiseExample example);

    int updateByExample(@Param("record") SmsCateAdvertise record, @Param("example") SmsCateAdvertiseExample example);

    int updateByPrimaryKeySelective(SmsCateAdvertise record);

    int updateByPrimaryKey(SmsCateAdvertise record);
}