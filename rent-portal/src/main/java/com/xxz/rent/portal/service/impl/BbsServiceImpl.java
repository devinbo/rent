package com.xxz.rent.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.mapper.BbsArticleMapper;
import com.xxz.rent.mapper.BbsCategoryMapper;
import com.xxz.rent.model.BbsArticle;
import com.xxz.rent.model.BbsArticleExample;
import com.xxz.rent.model.BbsCategory;
import com.xxz.rent.model.BbsCategoryExample;
import com.xxz.rent.portal.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-02 11:40
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
    public List<BbsCategory> categoryList() {
        BbsCategoryExample example = new BbsCategoryExample();
        example.createCriteria().andDeleteFlgEqualTo(0).andShowFlgEqualTo(1);
        example.setOrderByClause("sort desc");
        return bbsCategoryMapper.selectByExample(example);
    }

    @Override
    public List<BbsArticle> articleList(int pageNum, int pageSize, Long cateId) {
        BbsArticleExample example = new BbsArticleExample();
        BbsArticleExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteFlgEqualTo(0)
                .andTypeEqualTo(0).andPublishFlgEqualTo(1);
        if(cateId != null && !isAllCateGory(cateId)) {
            criteria.andCategoryIdEqualTo(cateId);
        }

        PageHelper.startPage(pageNum, pageSize);
        return bbsArticleMapper.selectByExample(example);
    }

    private boolean isAllCateGory(Long cateId) {
        final String allName = "全部";
        BbsCategory bbsCategory = bbsCategoryMapper.selectByPrimaryKey(cateId);
        if(Objects.equals(bbsCategory.getName(), allName)) {
            return true;
        }
        return false;
    }

    @Override
    public BbsArticle get(Long id) {
        BbsArticle bbsArticle = bbsArticleMapper.selectByPrimaryKey(id);
        //修改浏览量
        Integer viewNum = bbsArticle.getViewNum() != null ? bbsArticle.getViewNum() : 0;
        bbsArticle.setViewNum(viewNum + 1);
        bbsArticleMapper.updateByPrimaryKeySelective(bbsArticle);
        return bbsArticle;
    }
}
