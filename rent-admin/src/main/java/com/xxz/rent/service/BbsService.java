package com.xxz.rent.service;

import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.BbsArticle;
import com.xxz.rent.model.BbsCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface BbsService {


    List<BbsCategory> categoryList(String name, PageParam pageParam);

    int createCategory(BbsCategory bbsCategory);

    int updateCategory(Long id, BbsCategory bbsCategory);

    int deleteCategory(Long id);

    List<BbsArticle> articleList(String name, PageParam pageParam);

    BbsArticle get(Long id);

    List<BbsCategory> categoryAllList();

    int createArticle(BbsArticle bbsArticle);

    int updateArticle(Long id, BbsArticle bbsArticle);
}
