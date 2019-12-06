package com.xxz.rent.portal.service;

import com.xxz.rent.portal.model.dto.UmsIntegrationResult;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UmsIntegrationService {

    UmsIntegrationResult list(int pageNum, int pageSize);

}
