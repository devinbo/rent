package com.xxz.rent.portal.service;

import com.xxz.rent.portal.model.dto.OtoApplyResult;
import com.xxz.rent.portal.model.dto.OtoOrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xxz
 */
@Transactional
public interface OtoOrderService {

    OtoApplyResult apply(OtoOrderParam otoOrderParam);
}
