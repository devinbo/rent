package com.xxz.rent.portal.model.dto;

import com.xxz.rent.portal.bo.validate.PhonePattern;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-30 13:59
 * @description：绑定手机参数
 * @modified By：
 * @version: ：1.0
 */
@Data
public class BindPhoneParam {

    @NotBlank(message = "手机号码不能为空")
    @PhonePattern(message = "手机号格式错误")
    @ApiModelProperty("手机号")
    private String telephone;
    @NotBlank(message = "短信验证码不能未空")
    @ApiModelProperty("验证码")
    private String smsCode;
    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty("openid,接口获取微信用户资料信息")
    private String openid;
    @Range(max = 3, min = 0, message = "客户来源值为【0-3】")
    @ApiModelProperty(value = "注册/登陆来源 0->安卓；1->ios; 2->pc; 3->微信小程序", required = true, example = "0")
    Integer source;

}
