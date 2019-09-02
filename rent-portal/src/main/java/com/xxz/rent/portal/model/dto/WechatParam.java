package com.xxz.rent.portal.model.dto;

import lombok.Data;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-23 10:58
 * @description：微信支付回调参数
 * @modified By：
 * @version: ：1.0
 */
@Data
public class WechatParam {
    private String appid;
    private String mch_id;
    private String device_info;
    private String nonce_str;
    private String sign;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String openid;

    private String is_subscribe;
    private String trade_type;
    private String bank_type;
    /**
     * 单位分
     */
    private String total_fee;
    private String fee_type;
    private String cash_fee;
    private String cash_fee_type;
    private int coupon_fee;
    private int coupon_count;
    private String coupon_id_$n;
    private int coupon_fee_$n;
    private String transaction_id;
    private String out_trade_no;
    private String attach;
    private String time_end;

}
