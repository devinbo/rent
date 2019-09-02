package com.xxz.rent.dto;

import com.xxz.rent.model.UmsMemberMessage;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-15 13:51
 * @description：会员消息结果集
 * @modified By：
 * @version: ：1.0
 */
public class MemberMessageResult extends UmsMemberMessage {

    @Getter
    @Setter
    private String memberName;
    @Getter
    @Setter
    private String memberPhone;

}
