package com.xxz.rent.portal.util;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.portal.bo.constant.ProfileConstant;
import com.xxz.rent.portal.bo.exception.BusinessLogicException;
import com.xxz.rent.portal.model.enumerate.PromotionStatus;
import com.xxz.rent.portal.util.weixin.WXPayConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xxz
 */
@Slf4j
@Component
public class OrderInfoUtil {


    public static String alipay_appid;
    public static String alipay_publicKey;
    public static String alipay_privateKey;
    public static String profile;

    public static String wechat_appid;
    public static String wechat_mch_id;
    public static String wechat_privateKey;

    public static String wechat_url;


    @Value("${spring.profiles.active}")
    public void setProfile(String profile) {
        OrderInfoUtil.profile = profile;
    }

    @Value("${alipay.appId}")
    public void setAlipay_appid(String alipay_appid) {
        OrderInfoUtil.alipay_appid = alipay_appid;
    }
    @Value("${alipay.publicKey}")
    public void setAlipay_publicKey(String alipay_publicKey) {
        OrderInfoUtil.alipay_publicKey = alipay_publicKey;
    }
    @Value("${alipay.privateKey}")
    public void setAlipay_privateKey(String alipay_privateKey) {
        OrderInfoUtil.alipay_privateKey = alipay_privateKey;
    }

    @Value("${wechat.appid}")
    public void setWechat_appid(String wechat_appid) {
        OrderInfoUtil.wechat_appid = wechat_appid;
    }
    @Value("${wechat.mchId}")
    public void setWechat_mch_id(String wechat_mch_id) {
        OrderInfoUtil.wechat_mch_id = wechat_mch_id;
    }
    @Value("${wechat.privateKey}")
    public void setWechat_privateKey(String wechat_privateKey) {
        OrderInfoUtil.wechat_privateKey = wechat_privateKey;
    }
    @Value("${wechat.url}")
    public void setWechat_url(String wechat_url) {
        OrderInfoUtil.wechat_url = wechat_url;
    }

    /**
     * 构造授权参数列表
     */
    public static Map<String, String> buildAuthInfoMap(String pid, String app_id, String target_id) {
        Map<String, String> keyValues = new HashMap<String, String>();

        // 商户签约拿到的app_id，如：2013081700024223
        keyValues.put("app_id", app_id);

        // 商户签约拿到的pid，如：2088102123816631
        keyValues.put("pid", pid);

        // 服务接口名称， 固定值
        keyValues.put("apiname", "com.alipay.account.auth");

        // 商户类型标识， 固定值
        keyValues.put("app_name", "mc");

        // 业务类型， 固定值
        keyValues.put("biz_type", "openservice");

        // 产品码， 固定值
        keyValues.put("product_id", "APP_FAST_LOGIN");

        // 授权范围， 固定值
        keyValues.put("scope", "kuaijie");

        // 商户唯一标识，如：kkkkk091125
        keyValues.put("target_id", target_id);

        // 授权类型， 固定值
        keyValues.put("auth_type", "AUTHACCOUNT");

        // 签名类型
        keyValues.put("sign_type", "RSA");

        return keyValues;
    }

    /**
     * 构造支付订单参数列表
     *
     * @param proName
     * @param total_amount
     * @param desp
     * @return
     */
    public static String buildAlipayOrderParamMap(String proName, BigDecimal total_amount, String desp, String passback_params, String notify_url) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        String timestamp = format.format(date);

        Map<String, String> keyValues = new HashMap<String, String>();
        //合作身份者id
        keyValues.put("app_id", alipay_appid);
        Map<String, Object> contentParam = new HashMap<>();
        contentParam.put("timeout_express", "30m");
        contentParam.put("product_code", "QUICK_MSECURITY_PAY");
        contentParam.put("total_amount", total_amount.toString());
        contentParam.put("subject", proName);
        contentParam.put("body", desp);
        contentParam.put("out_trade_no", getOutTradeNo());
        contentParam.put("passback_params", passback_params);
        keyValues.put("biz_content", JSONUtil.toJsonStr(contentParam));
        keyValues.put("notify_url", notify_url);
        //回调url
//        if (Objects.equals(profile, ProfileConstant.PROD)) {
////            keyValues.put("notify_url", "https://www.91xiaoxiangzu.com/xxzapp/pay/zhifb_msg");
//
//            keyValues.put("notify_url", "http://47.99.103.214:8085/payback/alipay-callback");
//        } else {
//            keyValues.put("notify_url", "http://47.99.103.214:8085/payback/alipay-callback");
//        }

        keyValues.put("charset", "utf-8");
        keyValues.put("method", "alipay.trade.app.pay");
        //加密方式
        keyValues.put("sign_type", "RSA2");
        //时间戳
        keyValues.put("timestamp", timestamp);
        //版本号
        keyValues.put("version", "1.0");

        System.out.println(keyValues);
        String orderParam = OrderInfoUtil.buildOrderParam(keyValues);
        String sign = OrderInfoUtil.getSign(keyValues, alipay_privateKey);
        String orderInfo = orderParam + "&" + sign;
        return orderInfo;
    }


    public static Map<String, Object> buildWechatpayOrderParamMap(BigDecimal total_amount,
                                                                  String body,
                                                                  String spbill_create_ip,
                                                                  String passback_params) {
        /**
         * 沙盒环境下，处理key和金额，沙盒环境下，金额固定为1.01
         */
//        if(!Objects.equals(profile, ProfileConstant.PROD)) {
//            wechat_privateKey = sandboxSignkey();
//            total_amount = new BigDecimal(1.01);
//        }

        try {
            //生成的随机字符串
            String nonce_str = RandomStringUtils.randomAlphabetic(32);
            //组装参数，用户生成统一下单接口的签名
            log.info("----------微信下单接口签名-------");
            Map<String, String> packageParams = new HashMap<>(10);
            packageParams.put("appid", wechat_appid);
            packageParams.put("attach", passback_params);
            packageParams.put("mch_id", wechat_mch_id);
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("body", body);
            //商户订单号,自己的订单ID
            String orderNo = RandomStringUtils.randomNumeric(10);
            packageParams.put("out_trade_no", orderNo);
            //支付金额，这边需要转成字符串类型，否则后面的签名会失败
            String totalFee = String.valueOf(total_amount.multiply(new BigDecimal(100)).intValue());
            packageParams.put("total_fee", totalFee);
            packageParams.put("spbill_create_ip", spbill_create_ip);

            //回调url
            if (Objects.equals(profile, ProfileConstant.PROD)) {
                packageParams.put("notify_url", "http://47.99.103.214:8085/payback/wechatpay-callback");
//                packageParams.put("notify_url", "https://www.91xiaoxiangzu.com/app/payback/wechatpay-callback");
            } else {
                packageParams.put("notify_url", "http://47.99.103.214:8085/payback/wechatpay-callback");
            }
            //支付方式
            packageParams.put("trade_type", "APP");

            // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            String prestr = buildOrderParam(packageParams);
            log.info("----------wehchat_prestr:" + prestr);
            log.info("----------调用统一下单接口-------");
            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
            SortedMap<String, Object> mapPar = new TreeMap<>(packageParams);
            String sign = SignUtils.createWxSign(mapPar, wechat_privateKey).toUpperCase();
            packageParams.put("sign", sign);
            log.info("----------wechat_sign:" + sign);
            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
            String xml = XmlUtil.mapToXmlStr(packageParams, "xml");
            //调用统一下单接口，并接受返回的结果
            String result = HttpUtil.createPost(wechat_url).body(xml).execute().body();
            log.info("----------wechat_result:" + result);
            // 将解析结果存储在HashMap中
            Map map = XmlUtil.xmlToMap(result);
            String return_code = (String) map.get("return_code");
            String result_code = (String) map.get("result_code");

            if (Objects.equals(return_code, "SUCCESS") || return_code.equals(result_code)) {
                //返回的预付单信息
                Map<String, Object> payMap = new HashMap<>(10);
                //返回给小程序端需要的参数
                String prepay_id = (String) map.get("prepay_id");
                payMap.put("appid", wechat_appid);
                payMap.put("partnerid", wechat_mch_id);
                payMap.put("noncestr", nonce_str);
                payMap.put("prepayid", prepay_id);
                payMap.put("package", "Sign=WXPay");
                Long timeStamp = System.currentTimeMillis() / 1000;
                payMap.put("timestamp", timeStamp);
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                SortedMap<String, Object> sortParams = new TreeMap<>(payMap);
                System.out.println(sortParams);
                String paySign = SignUtils.createWxSign(sortParams, wechat_privateKey).toUpperCase();
                log.info("=======================第二次签名：" + paySign + "==================");
                payMap.put("sign", paySign);
                return payMap;
            } else {
                log.info("----------统一下单失败-------");
                return null;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }

    }



    private static String sandboxSignkey() {
        SortedMap<String, Object> data = new TreeMap<>();
        // 商户号
        data.put("mch_id", wechat_mch_id);
        // 获取随机字符串
        data.put("nonce_str", RandomStringUtils.randomAlphanumeric(32));
        // 生成签名
        String sign = SignUtils.createWxSign(data, wechat_privateKey);
        data.put("sign", sign);
        String result = HttpUtil.createPost("https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey").body(XmlUtil.mapToXmlStr(data, "xml")).execute().body();
        Map map = XmlUtil.xmlToMap(result);
        if(map != null && Objects.equals(map.get("return_code"), "SUCCESS")) {
            return String.valueOf(map.get("sandbox_signkey"));
        }else{
            throw new BusinessLogicException("沙盒环境获取KEY失败！");
        }
    }


    /**
     * 构造支付订单参数信息
     * 所有一级value进行加密
     *
     * @param map 支付订单参数
     * @return
     */
    public static String buildOrderParam(Map<String, String> map) {
        List<String> keys = new ArrayList<String>(map.keySet());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.size() - 1; i++) {
            String key = keys.get(i);
            String value = map.get(key);
            sb.append(buildKeyValue(key, value, true));
            sb.append("&");
        }

        String tailKey = keys.get(keys.size() - 1);
        String tailValue = map.get(tailKey);
        sb.append(buildKeyValue(tailKey, tailValue, true));

        return sb.toString();
    }

    /**
     * 拼接键值对
     */
    private static String buildKeyValue(String key, String value, boolean isEncode) {
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append("=");
        if (isEncode) {
            try {
                sb.append(URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                sb.append(value);
            }
        } else {
            sb.append(value);
        }
        return sb.toString();
    }

    /**
     * 对支付参数信息进行签名
     *
     * @param map 待签名授权信息
     * @return
     */
    public static String getSign(Map<String, String> map, String rsaKey) {
        List<String> keys = new ArrayList<String>(map.keySet());
        // key排序
        Collections.sort(keys);

        StringBuilder authInfo = new StringBuilder();
        for (int i = 0; i < keys.size() - 1; i++) {
            String key = keys.get(i);
            String value = map.get(key);
            authInfo.append(buildKeyValue(key, value, false));
            authInfo.append("&");
        }

        String tailKey = keys.get(keys.size() - 1);
        String tailValue = map.get(tailKey);
        authInfo.append(buildKeyValue(tailKey, tailValue, false));

        String oriSign = SignUtils.sign(authInfo.toString(), rsaKey, true);
        String encodedSign = "";

        try {
            encodedSign = URLEncoder.encode(oriSign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new BusinessLogicException();
        }
        return "sign=" + encodedSign;
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

}
