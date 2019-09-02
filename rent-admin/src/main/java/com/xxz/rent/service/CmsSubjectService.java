package com.xxz.rent.service;

import com.xxz.rent.dto.CmsSubjectParam;
import com.xxz.rent.dto.CmsSubjectResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.CmsSubject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品专题Service
 *
 * @author xxz
 */
@Transactional
public interface CmsSubjectService {
    /**
     * 查询所有专题
     */
    List<CmsSubject> listAll();

    /**
     * 分页查询专题
     */
    List<CmsSubject> list(String keyword, PageParam pageParam);

    /**  功能描述 <br>
     * <添加专题>
     *
     * @param cmsSubjectParam
     * @return int
     * @date 2019-07-05 14:53
     */
    int createSubject(CmsSubjectParam cmsSubjectParam);

    /**  功能描述 <br>
     * <修改专题>
     *
     * @param id
     * @param cmsSubjectParam
     * @return int
     * @date 2019-07-05 14:55
     */
    int updateSubject(Long id, CmsSubjectParam cmsSubjectParam);

    /**  功能描述 <br>
     * <删除专题>
     *
     * @param id
     * @return int
     * @date 2019-07-05 14:57
     */
    int deleteSubject(Long id);

    /**  功能描述 <br>
     * <根据ID获取专题>
     *
     * @param id
     * @return com.xxz.rent.model.CmsSubject
     * @date 2019-07-05 15:34
     */
    CmsSubjectResult getSubject(Long id);

    /**  功能描述 <br>
     * <根据关键字查询专题信息>
     *
     * @param keyword
     * @return java.util.List<com.xxz.rent.model.CmsSubject>
     * @date  20:01
     */
    List<CmsSubject> simpleList(String keyword);
}
