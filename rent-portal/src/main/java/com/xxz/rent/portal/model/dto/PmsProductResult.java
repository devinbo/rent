package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.PmsProduct;
import com.xxz.rent.model.PmsSkuStock;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-18 11:28
 * @description：产品详情结果集
 * @modified By：
 * @version: ：1.0
 */
@ApiModel("订单详情页的数据信息")
public class PmsProductResult extends PmsProduct {

    @ApiModelProperty("有效的SKU属性集合")
    @Setter
    @Getter
    private List<PmsSkuStock> pmsSkuStockList;

    @ApiModelProperty("该产品的属性：属性值集合")
    @Setter
    @Getter
    private List<SkuProps> skuPropsList;
}
