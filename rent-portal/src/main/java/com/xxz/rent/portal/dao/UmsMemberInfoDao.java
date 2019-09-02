package com.xxz.rent.portal.dao;

import com.xxz.rent.portal.model.dto.MemberResult;
import org.apache.ibatis.annotations.Param;

/**
 * @author xxz
 */
public interface UmsMemberInfoDao {

    MemberResult getAllInfo(@Param("id") Long id);
}
