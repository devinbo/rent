package com.xxz.rent.portal.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-30 13:49
 * @description：微信用户资料信息
 * @modified By：
 * @version: ：1.0
 */
@Data
public class WxUserInfo {

    private String openid;
    private String nickname;
    private String sex;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private List<String> privilege;
    private String unionid;

}
