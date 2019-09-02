package com.xxz.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.dao.CmsSubjectDao;
import com.xxz.rent.dao.CmsSubjectProductRelationDao;
import com.xxz.rent.dto.CmsSubjectParam;
import com.xxz.rent.dto.CmsSubjectResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.mapper.CmsSubjectMapper;
import com.xxz.rent.mapper.CmsSubjectProductRelationMapper;
import com.xxz.rent.model.CmsSubject;
import com.xxz.rent.model.CmsSubjectExample;
import com.xxz.rent.model.CmsSubjectProductRelation;
import com.xxz.rent.model.CmsSubjectProductRelationExample;
import com.xxz.rent.service.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 商品专题Service实现类
 *
 * @author xhb
 */
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper subjectMapper;
    @Autowired
    private CmsSubjectDao subjectDao;
    @Autowired
    private CmsSubjectProductRelationDao subjectProductRelationDao;
    @Autowired
    private CmsSubjectProductRelationMapper subjectProductRelationMapper;

    @Override
    public List<CmsSubject> listAll() {
        return subjectMapper.selectByExample(new CmsSubjectExample());
    }

    @Override
    public List<CmsSubject> list(String keyword, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        CmsSubjectExample example = new CmsSubjectExample();
        CmsSubjectExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andTitleLike("%" + keyword + "%");
        }
        return subjectMapper.selectByExample(example);
    }

    @Override
    public int createSubject(CmsSubjectParam cmsSubjectParam) {
        cmsSubjectParam.setProductCount(cmsSubjectParam.getProductRelationList() != null ? cmsSubjectParam.getProductRelationList().size() : 0);
        int count = subjectMapper.insertSelective(cmsSubjectParam);
        List<CmsSubjectProductRelation> list = cmsSubjectParam.getProductRelationList();
        for (CmsSubjectProductRelation relation : list) {
            relation.setSubjectId(cmsSubjectParam.getId());
        }
        subjectProductRelationDao.insertList(list);
        return count;
    }

    @Override
    public int updateSubject(Long id, CmsSubjectParam cmsSubjectParam) {
        cmsSubjectParam.setId(id);
        cmsSubjectParam.setProductCount(cmsSubjectParam.getProductRelationList() != null ? cmsSubjectParam.getProductRelationList().size() : 0);
        int count = subjectMapper.updateByPrimaryKeySelective(cmsSubjectParam);
        dealSubjectRelationProdcut(id);
        List<CmsSubjectProductRelation> list = cmsSubjectParam.getProductRelationList();
        for (CmsSubjectProductRelation relation : list) {
            relation.setSubjectId(cmsSubjectParam.getId());
        }
        subjectProductRelationDao.insertList(list);
        return count;
    }

    private void dealSubjectRelationProdcut(Long id) {
        CmsSubjectProductRelationExample example = new CmsSubjectProductRelationExample();
        example.createCriteria().andSubjectIdEqualTo(id);
        subjectProductRelationMapper.deleteByExample(example);
    }

    @Override
    public int deleteSubject(Long id) {
        return subjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CmsSubjectResult getSubject(Long id) {
        return subjectDao.getSubject(id);
    }

    @Override
    public List<CmsSubject> simpleList(String keyword) {
        CmsSubjectExample example = new CmsSubjectExample();
        example.createCriteria().andTitleLike("%" + keyword + "%");
        return subjectMapper.selectByExample(example);
    }

}
