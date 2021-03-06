package com.xxz.rent.dao;

import com.xxz.rent.model.PmsMemberPrice;
import com.xxz.rent.model.PmsMemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义会员价格Dao
 * Created by macro on 2018/4/26.
 */
public interface PmsMemberPriceDao {
    int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);
}
