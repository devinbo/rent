package com.xxz.rent.service;

import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.OtoSite;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface OtoSiteService {

    List<OtoSite> list(String name, PageParam pageParam);

    int create(OtoSite otoSite);

    int update(Long id, OtoSite otoSite);

    int delete(Long id);
}
