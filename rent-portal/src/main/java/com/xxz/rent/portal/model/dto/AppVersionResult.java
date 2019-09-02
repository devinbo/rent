package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-14 13:35
 * @description：版本管理Service
 * @modified By：
 * @version: ：1.0
 */
@Data
public class AppVersionResult {

    @ApiModelProperty("版本号")
    private String version;
    @ApiModelProperty("下载链接，各大主流市场链接")
    private String url;
    @ApiModelProperty("新版本更新标示：true表示需要更新，false表示不需要更新")
    private boolean updateFlg = false;

}
