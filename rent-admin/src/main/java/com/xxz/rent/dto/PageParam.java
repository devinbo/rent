package com.xxz.rent.dto;

import com.xxz.rent.common.api.utils.CommonUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author xhb
 * @Date
 * @Version 1.0
 **/
public class PageParam {
    @ApiModelProperty("当前页")
    private Integer pageSize = 5;
    @ApiModelProperty("当前叶大小")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "排序方式", example = "sort desc")
    private String orderBy;


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {

        this.pageNum = pageNum;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = CommonUtils.HumpToUnderline(orderBy);
    }
}
