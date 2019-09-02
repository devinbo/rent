package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-18 11:57
 * @description：Sku属性信息
 * @modified By：
 * @version: ：1.0
 */
@Data
@ApiModel("sku属性信息")
public class SkuProps {

    @ApiModelProperty("属性名")
    private String name;
    @ApiModelProperty("属性值集合，用逗号分割")
    private String value;

}
