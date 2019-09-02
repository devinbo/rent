package com.xxz.rent.portal.service;

import com.xxz.rent.portal.model.dto.WechatParam;
import com.xxz.rent.portal.model.dto.ZhifbResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xxz
 */
@Transactional
public interface OmsPayCallBackService {

    String wechatPay(WechatParam wechatParam);

    String payCallBack(ZhifbResult payParam);

    String otoPayCallBack(ZhifbResult payParam);

    String otoWechatPay(WechatParam wechatParam);
}
