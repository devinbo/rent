package com.xxz.rent.portal.service;

import com.xxz.rent.model.BbsArticle;
import com.xxz.rent.model.BbsCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BbsService {

    List<BbsCategory> categoryList();

    List<BbsArticle> articleList(int pageNum, int pageSize, Long cateId);

    BbsArticle get(Long id);
}
