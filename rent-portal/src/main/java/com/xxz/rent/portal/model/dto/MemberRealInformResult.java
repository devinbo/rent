package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author ：xhb
 * @date ：Created in 2019-07-11 10:19
 * @description：用户实名结果集信息
 * @modified By：
 * @version: ：1.0
 */
@Data
public class MemberRealInformResult {
    @ApiModelProperty("会员姓名")
    private String name;
    @ApiModelProperty("身份证号码")
    private String identification;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("下个待认证项：0->已全部认证或申请；1->身份认证； 2->个人信息认证； 3->亲属认证； 4->联系人认证；" +
            "5->手机号认证； 6-> 淘宝; 7->学信网认证")
    private Integer step;

}
