package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-09 10:01
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Data
public class OtoPreOrderResult {

    @ApiModelProperty("发布信息ID")
    private Long id;
    @ApiModelProperty("发布信息标题")
    private String title;
    @ApiModelProperty("产品图片")
    private String pic;
    @ApiModelProperty("租赁单位;0->日；1->周；2->月；3->年")
    private Integer rentUnit;
    @ApiModelProperty("产品价值/产品保证金")
    private BigDecimal productPrice;
    @ApiModelProperty("最迟归还日期")
    private Date rentLatestDate;
    @ApiModelProperty("应付押金，0->标示无需支付押金")
    private BigDecimal payMoney;
    @ApiModelProperty("最低租期")
    private Long minPeriod;
    @ApiModelProperty("最长租期， 如果值为0或null或最大起租数小于最低租期标示不限制最长租期")
    private Long maxPeriod;

}
