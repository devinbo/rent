package com.xxz.rent.portal.service;

import com.xxz.rent.model.HomeHotWord;
import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.PmsProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface SearchService {

    List<PmsProduct> query(String word, int pageNum, int pageSize);

    List<HomeHotWord> getHotWord();

    List<OtoProduct> queryPublish(String word, int pageNum, int pageSize);
}
