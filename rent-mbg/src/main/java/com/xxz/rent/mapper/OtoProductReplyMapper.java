package com.xxz.rent.mapper;

import com.xxz.rent.model.OtoProductReply;
import com.xxz.rent.model.OtoProductReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtoProductReplyMapper {
    long countByExample(OtoProductReplyExample example);

    int deleteByExample(OtoProductReplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OtoProductReply record);

    int insertSelective(OtoProductReply record);

    List<OtoProductReply> selectByExample(OtoProductReplyExample example);

    OtoProductReply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OtoProductReply record, @Param("example") OtoProductReplyExample example);

    int updateByExample(@Param("record") OtoProductReply record, @Param("example") OtoProductReplyExample example);

    int updateByPrimaryKeySelective(OtoProductReply record);

    int updateByPrimaryKey(OtoProductReply record);
}