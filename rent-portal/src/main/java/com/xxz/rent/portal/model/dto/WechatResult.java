package com.xxz.rent.portal.model.dto;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.XmlUtil;
import lombok.Data;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-23 11:18
 * @description：微信回调返回结果集
 * @modified By：
 * @version: ：1.0
 */
@Data
public class WechatResult {

    private String return_code;
    private String return_msg;

    public WechatResult(String return_code, String return_msg) {
        this.return_code = return_code;
        this.return_msg = return_msg;
    }

    public static String success() {
        WechatResult wechatResult = new WechatResult("SUCCESS", "OK");
        return XmlUtil.mapToXmlStr(BeanUtil.beanToMap(wechatResult), "xml");
    }

    public static String fail() {
        WechatResult wechatResult = new WechatResult("ERROR", "FAIL");
        return XmlUtil.mapToXmlStr(BeanUtil.beanToMap(wechatResult), "xml");
    }



}
