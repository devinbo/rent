package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.SmsCouponHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-18 18:44
 * @description：优惠券信息
 * @modified By：
 * @version: ：1.0
 */
@Data
public class SmsCouponHistoryResult extends SmsCouponHistory {

    @ApiModelProperty("优惠券名称")
    private String name;
    @ApiModelProperty("优惠金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "使用门槛；0表示无门槛")
    private BigDecimal minPoint;
    @ApiModelProperty(value = "有效期起")
    private Date start_time;
    @ApiModelProperty(value = "有效期止")
    private Date end_time;
    @ApiModelProperty(value = "种类：0->通用； 1->押金抵用券；2->租金抵用券")
    private Integer cate;
    @ApiModelProperty(value = "描述")
    private String note;
    @ApiModelProperty(value = "前端需求字段")
    private boolean visible = false;


}
