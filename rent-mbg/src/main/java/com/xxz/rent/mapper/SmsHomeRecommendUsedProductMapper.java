package com.xxz.rent.mapper;

import com.xxz.rent.model.SmsHomeRecommendUsedProduct;
import com.xxz.rent.model.SmsHomeRecommendUsedProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsHomeRecommendUsedProductMapper {
    long countByExample(SmsHomeRecommendUsedProductExample example);

    int deleteByExample(SmsHomeRecommendUsedProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeRecommendUsedProduct record);

    int insertSelective(SmsHomeRecommendUsedProduct record);

    List<SmsHomeRecommendUsedProduct> selectByExample(SmsHomeRecommendUsedProductExample example);

    SmsHomeRecommendUsedProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsHomeRecommendUsedProduct record, @Param("example") SmsHomeRecommendUsedProductExample example);

    int updateByExample(@Param("record") SmsHomeRecommendUsedProduct record, @Param("example") SmsHomeRecommendUsedProductExample example);

    int updateByPrimaryKeySelective(SmsHomeRecommendUsedProduct record);

    int updateByPrimaryKey(SmsHomeRecommendUsedProduct record);
}