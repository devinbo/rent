package com.xxz.rent.mapper;

import com.xxz.rent.model.UmsMemberLink;
import com.xxz.rent.model.UmsMemberLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberLinkMapper {
    long countByExample(UmsMemberLinkExample example);

    int deleteByExample(UmsMemberLinkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberLink record);

    int insertSelective(UmsMemberLink record);

    List<UmsMemberLink> selectByExample(UmsMemberLinkExample example);

    UmsMemberLink selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberLink record, @Param("example") UmsMemberLinkExample example);

    int updateByExample(@Param("record") UmsMemberLink record, @Param("example") UmsMemberLinkExample example);

    int updateByPrimaryKeySelective(UmsMemberLink record);

    int updateByPrimaryKey(UmsMemberLink record);
}