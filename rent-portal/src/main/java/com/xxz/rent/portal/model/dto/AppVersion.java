package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-14 11:54
 * @description：app检查更新
 * @modified By：
 * @version: ：1.0
 */
@Data
public class AppVersion {

    @ApiModelProperty(value = "版本号, 格式： 1.1、1.1.1; 只能包含数字和点")
    @NotBlank(message = "版本号不能为空")
    private String version;
    @ApiModelProperty(value = "系统：0->安卓；1->ios")
    @Range(min = 0, max = 1, message = "系统值只能为【0，1】")
    private Integer type;


}
