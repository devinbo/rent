package com.xxz.rent.portal.model.dto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-11 14:48
 * @description：会员身份基本信息
 * @modified By：
 * @version: ：1.0
 */
@Data
public class MemberBaseInfoParam {

    @ApiModelProperty(value = "居住地址", example = "苏州时吴中区阳光水韵花园2号201室", required = true)
    @NotBlank(message = "居住地址不能为空")
    private String currentAddress;

    @ApiModelProperty(value = "公司地址;客户类型为成人时才需要填写")
    private String companyAddress;


    @ApiModelProperty(value = "所在学校;客户类型为学生时才需要填写", example = "苏州职业技术学院")
    private String school;

    @ApiModelProperty(value = "客户类型 0->学生； 1->成人", example = "0", allowableValues = "0, 1", required = true)
    @Range(min = 0, max = 1, message = "客户类型只能为0，1")
    private Integer memberType;

    @ApiModelProperty(value = "月收入", example = "2000", required = true)
    @NotNull(message = "月收入不能为空")
    private BigDecimal monthIncome;

    @ApiModelProperty(value = "月消费", example = "1000", required = true)
    @NotNull(message = "月消费不能为空")
    private BigDecimal monthConsume;
}
