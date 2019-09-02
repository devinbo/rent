package com.xxz.rent.portal;

import cn.hutool.core.bean.BeanUtil;
import com.xxz.rent.portal.dao.PortalProductDao;
import com.xxz.rent.portal.model.dto.PromotionProduct;
import com.xxz.rent.portal.model.dto.ZhifbResult;
import com.xxz.rent.portal.service.OmsPayCallBackService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by macro on 2018/8/27.
 * 前台商品查询逻辑单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalProductDaoTests {
    @Autowired
    private PortalProductDao portalProductDao;

    @Autowired
    private OmsPayCallBackService payCallBackService;

    @Test
    public void testGetPromotionProductList(){
        Map<String, String> params = new HashMap<>();
        params.put("gmt_create", "2019-08-01 09:34:27");
        params.put("charset", "utf-8");
        params.put("seller_email", "wx13788957291@163.com");
        params.put("subject", "押金支付");
        params.put("sign", "bdUjotena9tH7/cf/sYz7UUe0Rmtka5Z43z2n4nj5WyKIPpsL2efuue49m1+lmGcIyjyb5JirdC4e30SRSZ+fziMstToK60YmiE6H5UmIZVaDyx5V/MZ18jjq8axas+6r+8EEzX4PMdQWlIJdQ1gYL1fm57qN8aUB4tw5y/Oh5By9po+Mnh5kLDnV64XNLT1pdzY2fDG0WaTL99BIRQrvbj8psD1lbjoaHawTmLZO0J7gc6UjiG4wso7/Gq1Zj9ubc4S/Ps+OfBb/QGf1t8yzNvobtq6fRh2PLJzxqgoYvABLrBbEGpvYejQxHYYMEf2lfQilCz8aHZo6GFQn4rY+A==");
        params.put("body", "支付租赁押金");
        params.put("buyer_id", "2088712912254324");
        params.put("invoice_amount", "0.01");
        params.put("notify_id", "2019080100222093428054320520311755");

        params.put("fund_bill_list", "[{\"amount\":\"0.01\",\"fundChannel\":\"PCREDIT\"}]");
        params.put("notify_type", "trade_status_sync");
        params.put("trade_status", "TRADE_SUCCESS");
        params.put("receipt_amount", "0.01");

        params.put("app_id", "2018052360203156");
        params.put("buyer_pay_amount", "0.01");
        params.put("sign_type", "RSA2");
        params.put("seller_id", "2088131302814058");
        params.put("gmt_payment", "2019-08-01 09:34:28");
        params.put("notify_time", "2019-08-01 09:34:28");
        params.put("passback_params", "orderId%3D35%3Btype%3D1");
        params.put("version", "1.0");
        params.put("out_trade_no", "0801093417-1593");
        params.put("total_amount", "0.01");
        params.put("trade_no", "2019080122001454320543742439");
        params.put("auth_app_id", "2018052360203156");
        params.put("buyer_logon_id", "183****8024");
        params.put("point_amount", "0.00");

        ZhifbResult payParam =  BeanUtil.mapToBean(params, ZhifbResult.class, true);
        payCallBackService.payCallBack(payParam);
    }
}
