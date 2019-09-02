package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-02 14:07
 * @description：发布信息参数
 * @modified By：
 * @version: ：1.0
 */
@Data
public class OtoProductParam {

    @NotNull(message = "分类ID不能为空")
    @ApiModelProperty(value = "分类ID")
    private Long categoryId;
    @NotBlank(message = "标题不能为空")
    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "详细描述")
    private String note;

    @ApiModelProperty(value = "标签；用逗号分隔")
    private String tags;
    @Range(min = 0, max = 3, message = "出租单位值在【0-3】")
    @ApiModelProperty(value = "出租单位 0->日；1->周；2->月；3->年")
    private Integer rentUnit;

    @NotNull(message = "租金不能为空")
    @DecimalMin(value = "0", message = "租金必须大于0")
    @ApiModelProperty(value = "每期租金")
    private BigDecimal rentEachPrice;

    @Min(value = 0, message = "最短出租数不能小于0")
    @ApiModelProperty(value = "最短起租数，单位同出租单位")
    private Integer rentLeastNum;

    @ApiModelProperty(value = "出租最迟归还日期, 格式：yyyy-MM-dd")
    @NotBlank(message = "最晚还款日期不能为空")
    private String rentLatest;

    @DecimalMin(value = "0", message = "商品价值必须大于0")
    @ApiModelProperty(value = "商品价值")
    private BigDecimal productPrice;

    @NotBlank(message = "分类名称不能为空")
    @ApiModelProperty(value = "分类名称")
    private String categoryName;

}
