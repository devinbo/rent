package com.xxz.rent.dao;

import com.xxz.rent.dto.CmsSubjectResult;
import com.xxz.rent.model.PmsProduct;
import org.apache.ibatis.annotations.Param;

/**
 * @author xxz
 */
public interface CmsSubjectDao {

    /**  功能描述 <br>
     * <查询专题详细>
     *
     * @param id
     * @return com.xxz.rent.dto.CmsSubjectResult
     * @date 2019-07-06 10:22
     */
    CmsSubjectResult getSubject(@Param("id") Long id);

    /**  功能描述 <br>
     * <根据SubjectId查询该专题关联的产品信息>
     *
     * @param id
     * @return com.xxz.rent.model.CmsSubjectProductRelation
     * @date 2019-07-06 10:22
     */
    PmsProduct getProductBySubId(@Param("id") Long id);
}
