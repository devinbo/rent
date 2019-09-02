package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.UmsMember;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-10 15:09
 * @description：登陆结果集
 * @modified By：
 * @version: ：1.0
 */
@Data
public class LoginResult {

    @ApiModelProperty("认证认证标志，请携带在请求头的Authorization中")
    private String token;
    @ApiModelProperty(value = "Token附载前缀", notes = "例：Authorization=Bearer + token值")
    private String tokenHead;
    @ApiModelProperty("会员信息")
    private UmsMember umsMember;
}
