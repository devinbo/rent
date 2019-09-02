package com.xxz.rent.portal.service;

import com.github.pagehelper.page.PageParams;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.OmsOrderPayment;
import com.xxz.rent.portal.model.dto.ConfirmOrderResult;
import com.xxz.rent.portal.model.dto.OmsOrderResult;
import com.xxz.rent.portal.model.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 前台订单管理Service
 *
 * @author xxz
 */
@Transactional
public interface OmsPortalOrderService {

    List<OmsOrderResult> list(int status, int pageNum, int pageSize);

    OmsOrderResult getOrderDetail(Long id);

    List<OmsOrderPayment> getOrderBills(Long orderId);
}
