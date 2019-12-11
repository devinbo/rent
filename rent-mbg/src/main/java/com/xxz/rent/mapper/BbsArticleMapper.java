package com.xxz.rent.mapper;

import com.xxz.rent.model.BbsArticle;
import com.xxz.rent.model.BbsArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsArticleMapper {
    long countByExample(BbsArticleExample example);

    int deleteByExample(BbsArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BbsArticle record);

    int insertSelective(BbsArticle record);

    List<BbsArticle> selectByExampleWithBLOBs(BbsArticleExample example);

    List<BbsArticle> selectByExample(BbsArticleExample example);

    BbsArticle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BbsArticle record, @Param("example") BbsArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") BbsArticle record, @Param("example") BbsArticleExample example);

    int updateByExample(@Param("record") BbsArticle record, @Param("example") BbsArticleExample example);

    int updateByPrimaryKeySelective(BbsArticle record);

    int updateByPrimaryKeyWithBLOBs(BbsArticle record);

    int updateByPrimaryKey(BbsArticle record);
}