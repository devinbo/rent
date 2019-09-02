package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-12 10:14
 * @description：客户所有资料信息
 * @modified By：
 * @version: ：1.0
 */
@Data
public class MemberResult extends UmsMember {

    @ApiModelProperty("亲戚联系人资料")
    private UmsMemberKinsfolk memberKinsfolk;
    @ApiModelProperty("常用联系人资料")
    private UmsMemberLink memberLink;
    @ApiModelProperty("实名及其基本资料")
    private UmsMemberRealinform memberRealinform;
    @ApiModelProperty("认证项信息")
    private UmsMemberAuthRelation memberAuthRelation;

}
