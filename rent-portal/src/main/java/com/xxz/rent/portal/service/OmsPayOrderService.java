package com.xxz.rent.portal.service;

import com.xxz.rent.model.OmsOrder;
import com.xxz.rent.model.OmsOrderPayment;
import com.xxz.rent.model.OtoOrder;
import com.xxz.rent.model.OtoOrderPayment;
import com.xxz.rent.portal.model.dto.PayAdvanceParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xxz
 */
@Transactional
public interface OmsPayOrderService {

    /**  功能描述 <br>
     * <加载押金信息>
     *
     * @param payAdvanceParam
     * @return com.xxz.rent.model.OmsOrder
     * @date 2019-07-22 10:27
     */
    OmsOrder getOrderAdvanceInfo(PayAdvanceParam payAdvanceParam);

    OmsOrderPayment payment(Long paymentId);

    OtoOrder getOtoOrderAdvanceInfo(PayAdvanceParam payAdvanceParam);

    OtoOrderPayment otoPayment(Long paymentId);
}
