package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.PmsProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-10-10 10:51
 * @description：足迹列表
 * @modified By：
 * @version: ：1.0
 */
@Data
public class PmsBrowseResult {

    @ApiModelProperty("浏览日期")
    private Date browDate;
    @ApiModelProperty("浏览的产品列表")
    private List<PmsProduct> pmsProductList;

}
