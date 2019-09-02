package com.xxz.rent.service;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.dto.UmsMemberResult;
import com.xxz.rent.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
public interface UmsMemberService {
    /**  功能描述 <br>
     * <分页获取会员列表信息>
     *
     * @param name
     * @param pageParam
     * @return java.util.List<com.xxz.rent.model.UmsMember>
     * @date 2019-06-26 15:03
     */
    List<UmsMember> list(String name, PageParam pageParam);

    /**  功能描述 <br>
     * <批量冻结/解冻会员>
     *
     * @param ids
     * @param blockStatus 0->冻结 1->解冻/正常
     * @return int
     * @date 2019-06-26 15:23
     */
    int updateBlockStatus(List<Long> ids, Integer blockStatus);

    /**  功能描述 <br>
     * <会员详细资料>
     *
     * @param id
     * @return com.xxz.rent.dto.UmsMemberResult
     * @date 2019-06-26 19:18
     */
    UmsMemberResult getMemberDetail(Long id);

    /**  功能描述 <br>
     * <修改会员基本资料信息>
     *
     * @param id
     * @param umsMember
     * @return int
     * @date 2019-06-28 14:04
     */
    int update(Long id, UmsMember umsMember);

    /**  功能描述 <br>
     * <修改会员实名资料信息>
     *
     * @param id
     * @param umsMemberRealinform
     * @return int
     * @date 2019-06-28 15:55
     */
    int updateRealInform(Long id, UmsMemberRealinform umsMemberRealinform);

    /**  功能描述 <br>
     * <修改会员实名资料信息并完成通过身份认证>
     *
     * @param id
     * @param umsMemberRealinform
     * @return int
     * @date 2019-06-28 16:23
     */
    int updateRealInformAndComplteAuth(Long id, UmsMemberRealinform umsMemberRealinform);

    /**  功能描述 <br>
     * <修改会员收获地址>
     *
     * @param id
     * @param umsMemberReceiveAddress
     * @return int
     * @date 2019-06-28 16:36
     */
    int updateMemberReceiveAddress(Long id, UmsMemberReceiveAddress umsMemberReceiveAddress);

    /**  功能描述 <br>
     * <修改亲属联系人资料>
     *
     * @param id
     * @param umsMemberKinsfolk
     * @return int
     * @date 2019-06-28 17:10
     */
    int updateMemberKinsfolk(Long id, UmsMemberKinsfolk umsMemberKinsfolk);

    /**  功能描述 <br>
     * <修改常用联系人资料>
     *
     * @param id
     * @param umsMemberLink
     * @return int
     * @date 2019-06-28 17:12
     */
    int updateMemberLink(Long id, UmsMemberLink umsMemberLink);

    /**  功能描述 <br>
     * <修改会员备注信息>
     *
     * @param id
     * @param note
     * @return int
     * @date 2019-06-29 09:49
     */
    int updateMemberNote(Long id, String note);

    /**  功能描述 <br>
     * <修改会员认证信息>
     *
     * @param id
     * @param memberAuthRelation
     * @return int
     * @date 2019-06-29 13:14
     */
    int updateMemberAuthRelation(Long id, UmsMemberAuthRelation memberAuthRelation);

    /**  功能描述 <br>
     * <根据会员Id加载所有收获地址>
     *
     * @param id memberId
     * @return java.util.List<com.xxz.rent.model.UmsMemberReceiveAddress>
     * @date 2019-07-04 18:28
     */
    List<UmsMemberReceiveAddress> getShipAddress(Long id);

    /**  功能描述 <br>
     * <通过关键字获取会员信息>
     *
     * @param keyword
     * @return com.xxz.rent.common.api.CommonResult<java.util.List<com.xxz.rent.model.UmsMember>>
     * @date 2019-07-15 16:35
     */
    List<UmsMember> getMemberByKeyword(String keyword);


    void addMemberOperation(Long memberId, int type, String note);
}
