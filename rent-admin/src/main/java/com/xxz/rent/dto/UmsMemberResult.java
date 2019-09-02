package com.xxz.rent.dto;

import com.xxz.rent.model.*;
import lombok.Data;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-06-26 16:18
 * @description：产品详细结果集
 * @modified By：
 * @version: ：1.0
 */
@Data
public class UmsMemberResult extends UmsMember {
    //收获地址信息
//    private List<UmsMemberReceiveAddress> umsMemberReceiveAddress;
    //个人信息
    private UmsMemberRealinform umsMemberRealinform;
    //个人认证项信息
    private UmsMemberAuthRelation umsMemberAuthRelation;
    //亲属信息
    private UmsMemberKinsfolk umsMemberKinsfolk;
    //常用联系人信息
    private UmsMemberLink umsMemberLink;

}
