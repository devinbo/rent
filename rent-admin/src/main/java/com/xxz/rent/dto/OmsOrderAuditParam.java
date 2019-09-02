package com.xxz.rent.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-08 11:31
 * @description：订单审核参数
 * @modified By：
 * @version: ：1.0
 */
@Data
public class OmsOrderAuditParam {
    @ApiModelProperty("审核状态： 0->拒绝；1->通过")
    private Integer status;
    @ApiModelProperty("审核备注/拒绝原因")
    private String refuseReason;
    @ApiModelProperty("产品SKUID")
    private String imeiNo;
}
