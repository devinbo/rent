package com.xxz.rent.portal.model.dto;

import com.xxz.rent.portal.bo.validate.PhonePattern;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-11 19:10
 * @description：会员联系人参数
 * @modified By：
 * @version: ：1.0
 */
@Data
public class UmsMemberLinkParam {

    @ApiModelProperty(value = "常用联系人姓名1", required = true, example = "李四")
    @NotBlank(message = "姓名不能为空")
    private String name1;

    @ApiModelProperty(value = "常用联系人性别 0->未知 ，1->男，2->女" , required = true, example = "1")
    @Range(min = 0, max = 2, message = "值只能为0，1，2")
    private Integer sex1;

    @ApiModelProperty(value = "联系人1手机号" , required = true, example = "13788957291")
    @PhonePattern(message = "手机号格式错误")
    private String phone1;

    @ApiModelProperty(value = "关系", required = true, example = "朋友")
    private String relation1;

    @ApiModelProperty(value = "常用联系人2姓名", required = true, example = "周义")
    @NotBlank(message = "姓名不能为空")
    private String name2;

    @ApiModelProperty(value = "0->未知 1->男 2->女", required = true, example = "1")
    @Range(min = 0, max = 2, message = "值只能为0，1，2")
    private Integer sex2;

    @ApiModelProperty(value = "联系人2手机号" , required = true, example = "13788957291")
    @PhonePattern(message = "手机号格式错误")
    private String phone2;

    @ApiModelProperty(value = "联系人2关系" , required = true, example = "基友")
    private String relation2;

    @ApiModelProperty(value = "联系人备注1", example = "测试备注1")
    private String note1;

    @ApiModelProperty(value = "联系人备注2", example = "测试备注2")
    private String note2;
}
