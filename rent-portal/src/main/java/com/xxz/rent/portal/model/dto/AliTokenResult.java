package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author xhb
 * @Date
 * @Version 1.0
 **/
@Data
public class AliTokenResult {
    @ApiModelProperty(value = "阿里人脸识别验证token", required = true)
    private String token;
    @ApiModelProperty(value = "本次认证操作ID，上传认证结果集时用到", required = true)
    private String ticketId;
}
