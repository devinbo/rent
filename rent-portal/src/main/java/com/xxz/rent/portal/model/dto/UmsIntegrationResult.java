package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.UmsIntegrationChangeHistory;
import com.xxz.rent.model.UmsMemberIntegral;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-09-24 09:57
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Data
public class UmsIntegrationResult {

    /**
     * 总积分
     */
    @ApiModelProperty("当前剩余总积分")
    private Integer totolIntegration;

    @ApiModelProperty("积分消费记录明细")
    private List<UmsMemberIntegral> integralList;

}