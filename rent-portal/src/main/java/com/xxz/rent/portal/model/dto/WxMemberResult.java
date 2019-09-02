package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.UmsMember;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-01 14:45
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Data
public class WxMemberResult {

    @ApiModelProperty("是否已绑定过手机号： 0->未绑定； 1->已绑定")
    private int bindStatus;
    @ApiModelProperty("微信openid,进行绑定接口使用的id")
    private String openid;

    @ApiModelProperty("认证认证标志，请携带在请求头的Authorization中")
    private String token;
    @ApiModelProperty(value = "Token附载前缀", notes = "例：Authorization=Bearer + token值")
    private String tokenHead;
    @ApiModelProperty("会员信息")
    private UmsMember umsMember;
}
