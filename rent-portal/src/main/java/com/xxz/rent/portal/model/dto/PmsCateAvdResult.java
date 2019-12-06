package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.PmsProduct;
import com.xxz.rent.model.SmsCateAdvertise;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-09 14:23
 * @description：分类+广告信息
 * @modified By：
 * @version: ：1.0
 */
@Data
public class PmsCateAvdResult {


    @ApiModelProperty("对应的右侧广告位信息")
    private SmsCateAdvertise smsCateAdvertise;

    @ApiModelProperty("产品集合")
    private List<PmsProduct> pmsProductList;

}
