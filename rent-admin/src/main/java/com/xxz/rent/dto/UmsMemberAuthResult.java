package com.xxz.rent.dto;

import com.xxz.rent.model.UmsMemberAuthRelation;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-15 17:39
 * @description：待认证的客户信息
 * @modified By：
 * @version: ：1.0
 */
public class UmsMemberAuthResult extends UmsMemberAuthRelation {

    @Getter
    @Setter
    private String memberPhone;
    @Setter
    @Getter
    private String memberName;

}
