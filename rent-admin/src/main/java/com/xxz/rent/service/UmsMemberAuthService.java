package com.xxz.rent.service;

import com.xxz.rent.dto.MemberMessageResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.dto.UmsMemberAuthResult;
import com.xxz.rent.dto.UmsMemberResult;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface UmsMemberAuthService {

    List<UmsMemberAuthResult> list(String name, PageParam pageParam);

    /**  功能描述 <br>
     * <审核个人信息>
     *
     *
     * @param memberId
     * @param status
     * @return int
     * @date 2019-07-17 11:06
     */
    int auditPerson(Long memberId, Integer status, BigDecimal feeMoney, String rejustNote);

    /**  功能描述 <br>
     * <审核亲属信息>
     *
     * @param memberId
     * @param status
     * @param freeMoney
     * @param rejustNote
     * @return int
     * @date 2019-07-17 14:14
     */
    int auditKinsfolk(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote);

    /**  功能描述 <br>
     * <会员信息参数>
     *
     * @param memberResult
     * @return int
     * @date 2019-07-17 18:33
     */
    int saveAllMember(UmsMemberResult memberResult);

    /**  功能描述 <br>
     * <联系人信息审核>
     *
     * @param memberId
     * @param status
     * @param freeMoney
     * @param rejustNote
     * @return int
     * @date 2019-07-17 19:14
     */
    int auditLink(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote);

    /**  功能描述 <br>
     * <运营商认证>
     *
     * @param memberId
     * @param status
     * @param freeMoney
     * @param rejustNote
     * @return int
     * @date 2019-07-18 09:29
     */
    int auditMobile(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote);

    int auditTaobao(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote);

    int auditStudy(Long memberId, Integer status, BigDecimal freeMoney, String rejustNote);
}
