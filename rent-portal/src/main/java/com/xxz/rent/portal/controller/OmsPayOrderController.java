package com.xxz.rent.portal.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.enumerate.OrderStatus;
import com.xxz.rent.dto.enumerate.OtoOrderStatus;
import com.xxz.rent.dto.enumerate.PaymentStatus;
import com.xxz.rent.mapper.OmsOrderPaymentMapper;
import com.xxz.rent.model.OmsOrder;
import com.xxz.rent.model.OmsOrderPayment;
import com.xxz.rent.model.OtoOrder;
import com.xxz.rent.model.OtoOrderPayment;
import com.xxz.rent.portal.bo.constant.ProfileConstant;
import com.xxz.rent.portal.model.dto.PayAdvanceParam;
import com.xxz.rent.portal.model.dto.PaymentParam;
import com.xxz.rent.portal.service.OmsPayOrderService;
import com.xxz.rent.portal.util.OrderInfoUtil;
import com.xxz.rent.portal.util.PublicUtil;
import com.xxz.rent.portal.util.weixin.MyWxPayConfig;
import com.xxz.rent.portal.util.weixin.WXPay;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.util.matcher.IpAddressMatcher;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-19 16:51
 * @description：支付接口controller
 * @modified By：
 * @version: ：1.0
 */
@Slf4j
@RestController
@Api(tags = "OmsPayOrderController", description = "支付管理")
@RequestMapping("pay")
public class OmsPayOrderController {


    @Autowired
    private OmsPayOrderService omsPayOrderService;

    @Value("${alipay.privateKey}")
    private String alipayPrivateKey;
    @Value("${spring.profiles.active}")
    public String profile;

    @Autowired
    private HttpServletRequest request;

    @ApiOperation("支付押金")
    @PostMapping("/advanced-type")
    public CommonResult<String> pay(@Valid @RequestBody PayAdvanceParam payAdvanceParam, BindingResult bindingResult) throws UnsupportedEncodingException {
        //查询本次待支付金额
        OmsOrder omsOrder = omsPayOrderService.getOrderAdvanceInfo(payAdvanceParam);
        if (omsOrder == null) {
            return CommonResult.failed("无效订单");
        } else if (!Objects.equals(omsOrder.getStatus(), OrderStatus.PAY.getStatus())) {
            return CommonResult.failed("不是待支付订单");
        }
        //封装回调参数
        String back_params = createAdvanceBizNameValuePair(omsOrder.getId());
        if (payAdvanceParam.getType() == 0) {
            //支付宝支付
            String sign = OrderInfoUtil.buildAlipayOrderParamMap("押金支付",
                    omsOrder.getPayAmount(), "支付租赁押金", back_params, "https://portal.91xiaoxiangzu.com/payback/alipay-callback");
            return CommonResult.success(sign);
        } else {
            //微信支付
//            Map<String, Object> result = OrderInfoUtil.buildWechatpayOrderParamMap(omsOrder.getPayAmount(),
//                    "租赁押金", PublicUtil.getIpAddr(request),  back_params);
            System.out.println(omsOrder.getPayAmount());

            Map<String, String> data = new HashMap<String, String>();
            data.put("body", "笑享租-押金支付");
            data.put("out_trade_no", getOutTradeNo());
            data.put("device_info", "");
            data.put("fee_type", "CNY");
            data.put("total_fee", String.valueOf(omsOrder.getPayAmount().multiply(new BigDecimal(100)).intValue()));
            data.put("spbill_create_ip", PublicUtil.getIpAddr(request));
            if (Objects.equals(profile, ProfileConstant.PROD)) {
//                data.put("notify_url", "https://www.91xiaoxiangzu.com/app/payback/wechatpay-callback");
                data.put("notify_url", "https://portal.91xiaoxiangzu.com/payback/wechatpayCallback");
            } else {
                data.put("notify_url", "https://portal.91xiaoxiangzu.com/payback/wechatpayCallback");
            }
            // 此处指定为App支付
            data.put("trade_type", "APP");
            data.put("attach", back_params);
            System.out.println(data);
            try {
                WXPay wxpay = new WXPay(new MyWxPayConfig());
                Map<String, String> resp = wxpay.unifiedOrder(data);
                log.info(resp.toString());
                if(Objects.equals(resp.get("return_code"), "SUCCESS")) {
                    String jsonPay = wxpay.startPay(resp);
                    return CommonResult.success(jsonPay);
                }else{
                    return CommonResult.failed("生成预订单失败！");
                }
            } catch (Exception e) {
                log.info(e.getMessage());
                return CommonResult.failed("服务异常！");
            }
        }
    }

    /**
     * 要求外部订单号必须唯一。
     *
     * @return
     */
    private static String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);
        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }

    /**
     * 创建押金待支付信息
     */
    private String createAdvanceBizNameValuePair(Long orderId) throws UnsupportedEncodingException {
        StringBuilder sbd = new StringBuilder();
        sbd.append("orderId=");
        sbd.append(orderId);
        sbd.append(";");
        sbd.append("type=1");
        return URLEncoder.encode(sbd.toString(), "UTF-8");
    }


    @ApiOperation("支付每期的租金")
    @PostMapping("/payment-type")
    public CommonResult<String> payment(@Valid @RequestBody PaymentParam paymentParam, BindingResult bindingResult) throws UnsupportedEncodingException {
        //查询本次待支付金额
        OmsOrderPayment orderPayment = omsPayOrderService.payment(paymentParam.getPaymentId());
        if (orderPayment == null) {
            return CommonResult.failed("无效账单");
        } else if (!Objects.equals(orderPayment.getStatus(), PaymentStatus.WAITPAY.getStatus())) {
            return CommonResult.failed("不是待支付账单");
        }
        //封装回调参数
        String back_params = createPaymentBizNameValuePair(orderPayment);
        if (paymentParam.getType() == 0) {
            //支付宝支付
            String sign = OrderInfoUtil.buildAlipayOrderParamMap("租金",
                    orderPayment.getPayMoney(), "支付租金", back_params, "https://portal.91xiaoxiangzu.com/payback/alipay-callback");
            return CommonResult.success(sign);
        } else {
            //微信支付
            Map<String, Object> result = OrderInfoUtil.buildWechatpayOrderParamMap(orderPayment.getPayMoney(),
                    "支付租金", PublicUtil.getIpAddr(request),  back_params);
            if(result == null) {
                return CommonResult.failed("服务异常！");
            }
            return CommonResult.success(JSONUtil.toJsonStr(result));
        }
    }

    private String createOtoPaymentBizNameValuePair(OtoOrderPayment otoOrderPayment) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        result.append("paymentId=");
        result.append(otoOrderPayment.getId());
        result.append(";");
        result.append("type=2");
        return URLEncoder.encode(result.toString(), "UTF-8");
    }


    private String createPaymentBizNameValuePair(OmsOrderPayment orderPayment) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        result.append("paymentId=");
        result.append(orderPayment.getId());
        result.append(";");
        result.append("type=2");
        return URLEncoder.encode(result.toString(), "UTF-8");
    }

    /********OTO支付信息*******/
    @ApiOperation("笑享平台支付押金")
    @PostMapping("/oto/advanced-type")
    public CommonResult<String> otoPay(@Valid @RequestBody PayAdvanceParam payAdvanceParam, BindingResult bindingResult) throws UnsupportedEncodingException {
        //查询本次待支付金额
        OtoOrder otoOrder = omsPayOrderService.getOtoOrderAdvanceInfo(payAdvanceParam);
        if (otoOrder == null) {
            return CommonResult.failed("无效订单");
        } else if (!Objects.equals(otoOrder.getStatus(), OtoOrderStatus.PAY.getStatus())) {
            return CommonResult.failed("不是待支付订单");
        }
        //封装回调参数
        String back_params = createAdvanceBizNameValuePair(otoOrder.getId());
        if (payAdvanceParam.getType() == 0) {
            //支付宝支付
            String sign = OrderInfoUtil.buildAlipayOrderParamMap("押金支付",
                    otoOrder.getPayAmount(), "支付租赁押金", back_params, "https://portal.91xiaoxiangzu.com/payback/oto/alipay-callback");
            return CommonResult.success(sign);
        } else {
            Map<String, String> data = new HashMap<String, String>();
            data.put("body", "笑享租-押金支付");
            data.put("out_trade_no", getOutTradeNo());
            data.put("device_info", "");
            data.put("fee_type", "CNY");
            data.put("total_fee", String.valueOf(otoOrder.getPayAmount().multiply(new BigDecimal(100)).intValue()));
            data.put("spbill_create_ip", PublicUtil.getIpAddr(request));
            if (Objects.equals(profile, ProfileConstant.PROD)) {
//                data.put("notify_url", "https://www.91xiaoxiangzu.com/app/payback/wechatpay-callback");
                data.put("notify_url", "http://47.99.103.214:8085/payback/oto/wechatpayCallback");
            } else {
                data.put("notify_url", "https://portal.91xiaoxiangzu.com/payback/oto/wechatpayCallback");
            }
            // 此处指定为App支付
            data.put("trade_type", "APP");
            data.put("attach", back_params);
            try {
                WXPay wxpay = new WXPay(new MyWxPayConfig());
                Map<String, String> resp = wxpay.unifiedOrder(data);
                log.info(resp.toString());
                if(Objects.equals(resp.get("return_code"), "SUCCESS")) {
                    String jsonPay = wxpay.startPay(resp);
                    return CommonResult.success(jsonPay);
                }else{
                    return CommonResult.failed("生成预订单失败！");
                }
            } catch (Exception e) {
                log.info(e.getMessage());
                return CommonResult.failed("服务异常！");
            }
        }
    }


    @ApiOperation("笑享平台支付每期的租金")
    @PostMapping("/oto/payment-type")
    public CommonResult<String> otoPayment(@Valid @RequestBody PaymentParam paymentParam, BindingResult bindingResult) throws UnsupportedEncodingException {
        //查询本次待支付金额
        OtoOrderPayment otoOrderPayment = omsPayOrderService.otoPayment(paymentParam.getPaymentId());
        if (otoOrderPayment == null) {
            return CommonResult.failed("无效账单");
        } else if (!Objects.equals(otoOrderPayment.getStatus(), PaymentStatus.WAITPAY.getStatus())) {
            return CommonResult.failed("不是待支付账单");
        }
        //封装回调参数
        String back_params = createOtoPaymentBizNameValuePair(otoOrderPayment);
        if (paymentParam.getType() == 0) {
            //支付宝支付
            String sign = OrderInfoUtil.buildAlipayOrderParamMap("租金",
                    otoOrderPayment.getPayMoney(), "支付租金", back_params,
                    "https://portal.91xiaoxiangzu.com/payback/alipay-callback");
            return CommonResult.success(sign);
        } else {
            //微信支付
            Map<String, Object> result = OrderInfoUtil.buildWechatpayOrderParamMap(otoOrderPayment.getPayMoney(),
                    "支付租金", PublicUtil.getIpAddr(request),  back_params);
            if(result == null) {
                return CommonResult.failed("服务异常！");
            }
            return CommonResult.success(JSONUtil.toJsonStr(result));
        }
    }
}
