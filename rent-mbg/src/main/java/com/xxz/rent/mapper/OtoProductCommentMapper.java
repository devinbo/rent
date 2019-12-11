package com.xxz.rent.mapper;

import com.xxz.rent.model.OtoProductComment;
import com.xxz.rent.model.OtoProductCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtoProductCommentMapper {
    long countByExample(OtoProductCommentExample example);

    int deleteByExample(OtoProductCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OtoProductComment record);

    int insertSelective(OtoProductComment record);

    List<OtoProductComment> selectByExample(OtoProductCommentExample example);

    OtoProductComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OtoProductComment record, @Param("example") OtoProductCommentExample example);

    int updateByExample(@Param("record") OtoProductComment record, @Param("example") OtoProductCommentExample example);

    int updateByPrimaryKeySelective(OtoProductComment record);

    int updateByPrimaryKey(OtoProductComment record);
}