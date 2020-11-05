package com.xxz.rent.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.mapper.BbsArticleMapper;
import com.xxz.rent.mapper.BbsCategoryMapper;
import com.xxz.rent.model.BbsArticle;
import com.xxz.rent.model.BbsArticleExample;
import com.xxz.rent.model.BbsCategory;
import com.xxz.rent.model.BbsCategoryExample;
import com.xxz.rent.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-02 13:44
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class BbsServiceImpl implements BbsService {

    @Autowired
    private BbsCategoryMapper bbsCategoryMapper;
    @Autowired
    private BbsArticleMapper bbsArticleMapper;

    @Override
    public List<BbsCategory> categoryList(String name, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        BbsCategoryExample example = new BbsCategoryExample();
        BbsCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteFlgEqualTo(0);
        if (!StrUtil.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        return bbsCategoryMapper.selectByExample(example);
    }

    @Override
    public int createCategory(BbsCategory bbsCategory) {
        bbsCategory.setDeleteFlg(0);
        bbsCategory.setCreateTime(new Date());
        return bbsCategoryMapper.insertSelective(bbsCategory);
    }

    @Override
    public int updateCategory(Long id, BbsCategory bbsCategory) {
        bbsCategory.setId(id);
        return bbsCategoryMapper.updateByPrimaryKeySelective(bbsCategory);
    }

    @Override
    public int deleteCategory(Long id) {
        BbsCategory bbsCategory = new BbsCategory();
        bbsCategory.setId(id);
        bbsCategory.setDeleteFlg(1);
        return bbsCategoryMapper.updateByPrimaryKeySelective(bbsCategory);
    }

    @Override
    public List<BbsArticle> articleList(String name, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        BbsArticleExample example = new BbsArticleExample();
        if (!StrUtil.isEmpty(name)) {
            example.createCriteria().andTitleLike("%" + name + "%");
        }
        return bbsArticleMapper.selectByExample(example);
    }

    @Override
    public BbsArticle get(Long id) {
        return bbsArticleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BbsCategory> categoryAllList() {
        BbsCategoryExample example = new BbsCategoryExample();
        return bbsCategoryMapper.selectByExample(example);
    }

    @Override
    public int createArticle(BbsArticle bbsArticle) {
        BbsCategory bbsCategory = bbsCategoryMapper.selectByPrimaryKey(bbsArticle.getCategoryId());
        bbsArticle.setCategoryName(bbsCategory.getName());
        bbsArticle.setCreateTime(new Date());
        return bbsArticleMapper.insertSelective(bbsArticle);
    }

    @Override
    public int updateArticle(Long id, BbsArticle bbsArticle) {
        bbsArticle.setId(id);
        BbsCategory bbsCategory = bbsCategoryMapper.selectByPrimaryKey(bbsArticle.getCategoryId());
        bbsArticle.setCategoryName(bbsCategory.getName());
        return bbsArticleMapper.updateByPrimaryKeySelective(bbsArticle);
    }

}
