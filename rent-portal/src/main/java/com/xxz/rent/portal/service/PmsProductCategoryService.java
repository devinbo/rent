package com.xxz.rent.portal.service;


import com.xxz.rent.model.PmsProductCategory;
import com.xxz.rent.portal.model.dto.PmsCateAvdResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface PmsProductCategoryService {

    List<PmsProductCategory> allList();

    PmsCateAvdResult productList(Long cateId);
}
