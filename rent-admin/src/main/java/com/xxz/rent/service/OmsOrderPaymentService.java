package com.xxz.rent.service;

import com.xxz.rent.model.OmsOrderPayment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OmsOrderPaymentService {

    /**  功能描述 <br>
     * <查询指定订单的所有期租金>
     *
     * @param orderId
     * @return java.util.List<com.xxz.rent.model.OmsOrderPayment>
     * @date 2019-07-09 10:16
     */
    List<OmsOrderPayment> list(Long orderId);

    /**  功能描述 <br>
     * <结算指定期账单>
     *
     * @param id
     * @param realPayTime
     * @param completeType
     * @return int
     * @date 2019-07-09 10:15
     */
    int completePayment(Long id, String realPayTime, Integer completeType);
}
