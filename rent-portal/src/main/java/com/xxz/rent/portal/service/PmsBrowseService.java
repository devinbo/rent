package com.xxz.rent.portal.service;

import com.xxz.rent.portal.model.dto.OtoBrowseResult;
import com.xxz.rent.portal.model.dto.PmsBrowseResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface PmsBrowseService {

    List<PmsBrowseResult> selfBrowseList(int pageNum, int pageSize);

    List<OtoBrowseResult> otoBrowseList(int pageNum, int pageSize);
}
