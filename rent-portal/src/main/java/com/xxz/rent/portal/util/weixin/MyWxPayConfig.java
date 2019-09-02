package com.xxz.rent.portal.util.weixin;

import java.io.InputStream;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-01 17:13
 * @description：
 * @modified By：
 * @version: ：1.0
 */
public class MyWxPayConfig extends WXPayConfig{

    @Override
    String getAppID() {
        return "wx13e6963ce014537b";
    }

    @Override
    String getMchID() {
        return "1540260361";
    }

    @Override
    String getKey() {
        return "5bb08b912bfdf2a1d43c08ae16222aa0";
    }

    @Override
    InputStream getCertStream() {
        return null;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new DomainInfo("api.mch.weixin.qq.com", true);
            }
        };
    }
}
