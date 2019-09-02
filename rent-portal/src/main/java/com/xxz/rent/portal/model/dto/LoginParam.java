package com.xxz.rent.portal.model.dto;

import com.xxz.rent.portal.bo.validate.PhonePattern;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @author xxz
 */
@Data
public class LoginParam {

    @NotBlank(message = "手机号码不能为空")
    @PhonePattern(message = "手机号格式错误")
    @ApiModelProperty(value = "手机号码", required = true, example = "13788957291")
    String telephone;
    @NotBlank(message = "短信验证码不能未空")
    @ApiModelProperty(value = "短信验证码,开发/仿真环境可使用888888", required = true, example = "888888")
    String smsCode;
    @NotNull
    @Range(max = 3, min = 0, message = "客户来源值为【0-3】")
    @ApiModelProperty(value = "注册/登陆来源 0->安卓；1->ios; 2->pc; 3->微信小程序", required = true, example = "0")
    Integer source;
}
