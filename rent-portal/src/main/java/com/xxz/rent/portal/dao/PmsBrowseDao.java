package com.xxz.rent.portal.dao;

import com.xxz.rent.portal.model.dto.OtoBrowseResult;
import com.xxz.rent.portal.model.dto.PmsBrowseResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xxz
 */
public interface PmsBrowseDao {

    List<PmsBrowseResult> groupByBrowseList(@Param("memberId") Long memberId);

    List<OtoBrowseResult> otoBrowseList(@Param("memberId") Long memberId);
}
