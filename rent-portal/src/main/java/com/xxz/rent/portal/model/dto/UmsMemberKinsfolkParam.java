package com.xxz.rent.portal.model.dto;

import com.xxz.rent.portal.bo.validate.PhonePattern;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-11 19:17
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Data
public class UmsMemberKinsfolkParam {

    @ApiModelProperty(value = "亲属1姓名", required = true, example = "张三")
    @NotBlank(message = "姓名不能为空")
    private String name1;

    @ApiModelProperty(value = "性别 0->未知； 1->男； 2->女", required = true, example = "1")
    @Range(min = 0, max = 3, message = "性别值只能为0，1，2")
    private Integer sex1;

    @ApiModelProperty(value = "手机号", required = true, example = "13788957291")
    @PhonePattern(message = "手机号格式错误")
    private String phone1;

    @ApiModelProperty(value = "关系", required = true, example = "父亲")
    @NotBlank(message = "关系不能为空！")
    private String relation1;

    @ApiModelProperty(value = "亲属2姓名", required = true, example = "李红红")
    @NotBlank(message = "姓名不能为空")
    private String name2;

    @ApiModelProperty(value = "性别 0->未知； 1->男； 2->女", required = true, example = "2")
    @Range(min = 0, max = 3, message = "性别值只能为0，1，2")
    private Integer sex2;

    @ApiModelProperty(value = "手机号", required = true, example = "13788957019")
    @PhonePattern(message = "手机号格式错误")
    private String phone2;

    @ApiModelProperty(value = "关系", required = true, example = "母亲")
    @NotBlank(message = "关系不能为空！")
    private String relation2;

    @ApiModelProperty(value = "亲属1备注信息", example = "测试备注1")
    private String note1;

    @ApiModelProperty(value = "亲属2备注信息", example = "测试备注2")
    private String note2;
}
