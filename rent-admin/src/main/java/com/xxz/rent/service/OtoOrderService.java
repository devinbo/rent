package com.xxz.rent.service;

import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.OtoOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface OtoOrderService {

    List<OtoOrder> list(String[] startTime, Integer status, String memberName, String productName, PageParam pageParam);
}
