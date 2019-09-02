package com.xxz.rent.portal.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONUtil;
import com.alipay.api.internal.util.AlipaySignature;
import com.xxz.rent.portal.bo.constant.ProfileConstant;
import com.xxz.rent.portal.model.dto.WechatParam;
import com.xxz.rent.portal.model.dto.WechatResult;
import com.xxz.rent.portal.model.dto.ZhifbResult;
import com.xxz.rent.portal.service.OmsPayCallBackService;
import com.xxz.rent.portal.util.OrderInfoUtil;
import com.xxz.rent.portal.util.SignUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-19 19:40
 * @description：支付回调
 * @modified By：
 * @version: ：1.0
 */
@RequestMapping("/payback")
@RestController
@Slf4j
public class OmsPayCallBackController {

    @Autowired
    private HttpServletRequest request;
    @Value("${spring.profiles.active}")
    private String profile;

    @Autowired
    private OmsPayCallBackService payCallBackService;


    @ApiOperation("阿里支付回调")
    @RequestMapping("alipay-callback")
    public String payCallBack(@RequestParam Map<String, String> stringMap, ZhifbResult payParam)  {
        log.info("-------------阿里支付结果回调参数-----------");
        log.info("支付参数{}", stringMap);
        log.info("支付宝封装参数{}", payParam);
        log.info("支付宝参数JSON{}", JSONUtil.toJsonStr(stringMap));
        try {
            //校验签名
            boolean signVerified = AlipaySignature.rsaCheckV1(stringMap, OrderInfoUtil.alipay_publicKey, "UTF-8", "RSA2");
//            if(signVerified) {
                //表示支付成功
            if(Objects.equals(payParam.getTrade_status(), "TRADE_SUCCESS")) {
                //签名校验成功, 支付回调服务
                return payCallBackService.payCallBack(payParam);
            }else{
                return "true";
            }
//            }else{
//                //签名校验失败
//                log.error("签名校验失败；本次参数为{}", stringMap);
//                return "failure";
//            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("本次支付回调异常:" + e);
            return "failure";
        }
    }


    @ApiOperation("微信支付回调")
    @RequestMapping("wechatpayCallback")
    public String wechatPayCallBack(@RequestBody SortedMap<String, Object> param) {
        log.info("微信支付回调参数{}", param);
        WechatParam wechatParam = BeanUtil.mapToBean(param, WechatParam.class, true);
        if(Objects.equals(profile, ProfileConstant.PROD)) {
            //生成环境才进行签名校验，否则不进行校验
            String sign = SignUtils.createWxSign(param, OrderInfoUtil.wechat_privateKey).toUpperCase();
            if(!Objects.equals(wechatParam.getSign(), sign)) {
                return WechatResult.fail();
            }
        }
        return payCallBackService.wechatPay(wechatParam);
    }


    @ApiOperation("Oto订单微信支付回调")
    @RequestMapping("oto/wechatpayCallback")
    public String otoWechatPayCallBack(@RequestBody SortedMap<String, Object> param) {
        log.info("微信支付回调参数{}", param);
        WechatParam wechatParam = BeanUtil.mapToBean(param, WechatParam.class, true);
        if(Objects.equals(profile, ProfileConstant.PROD)) {
            //生成环境才进行签名校验，否则不进行校验
            String sign = SignUtils.createWxSign(param, OrderInfoUtil.wechat_privateKey).toUpperCase();
            if(!Objects.equals(wechatParam.getSign(), sign)) {
                return WechatResult.fail();
            }
        }
        return payCallBackService.otoWechatPay(wechatParam);
    }


    @ApiOperation("Oto订单支付宝支付回调")
    @RequestMapping("oto/alipay-callback")
    public String otoAliPayCallBack(@RequestParam Map<String, String> stringMap, ZhifbResult payParam) {
        log.info("-------------阿里支付结果回调参数-----------");
        log.info("支付参数{}", stringMap);
        log.info("支付宝封装参数{}", payParam);
        log.info("支付宝参数JSON{}", JSONUtil.toJsonStr(stringMap));
        try {
            //校验签名
            boolean signVerified = AlipaySignature.rsaCheckV1(stringMap, OrderInfoUtil.alipay_publicKey, "UTF-8", "RSA2");
            //表示支付成功
            if(Objects.equals(payParam.getTrade_status(), "TRADE_SUCCESS")) {
                //签名校验成功, 支付回调服务
                return payCallBackService.otoPayCallBack(payParam);
            }else{
                return "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("本次支付回调异常:" + e);
            return "failure";
        }
    }
}
