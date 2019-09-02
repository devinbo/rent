package com.xxz.rent.portal.service;

import com.xxz.rent.portal.model.dto.ApplyParam;
import com.xxz.rent.portal.model.dto.ApplyResult;
import com.xxz.rent.portal.model.dto.PreOrderResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xxz
 */
@Transactional
public interface UmsProductApplyService {

    PreOrderResult getPreOrderInfo(Long skuId);

    ApplyResult apply(ApplyParam applyParam);

}
