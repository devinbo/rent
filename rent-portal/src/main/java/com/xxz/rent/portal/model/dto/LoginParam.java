package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class LoginParam {

    @NotBlank(message = "手机号码不能为空")
    @ApiModelProperty(value = "手机号码", required = true)
    String telephone;
    @NotBlank(message = "短信验证码不能未空")
    @ApiModelProperty(value = "短信验证码", required = true)
    String smsCode;
    @NotNull
    @Range(max = 3, min = 0, message = "客户来源值为【0-3】")
    @ApiModelProperty(value = "注册/登陆来源 0->安卓；1->ios; 2->pc; 3->微信小程序", required = true)
    Integer source;
}
