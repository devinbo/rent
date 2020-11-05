package com.xxz.rent.service;

import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.SmsCateAdvertise;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface SmsCateAdvertiseService {

    List<SmsCateAdvertise> list(String name, Long cateId, String endTime, PageParam pageParam);

    SmsCateAdvertise get(Long id);

    int delete(Long id);

    int create(SmsCateAdvertise smsCateAdvertise);

    int update(Long id, SmsCateAdvertise smsCateAdvertise);

    int updateStatus(Long id, Integer status);
}
