package com.xxz.rent.portal.service;

import com.aliyuncs.exceptions.ClientException;
import com.xxz.rent.portal.model.dto.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author xxz
 */
@Transactional
public interface UmsMemberAuthService {
    /**  功能描述 <br>
     * <获取阿里实名认证TOKEN>
     *
     * @param
     * @return com.xxz.rent.portal.model.dto.AliTokenResult
     * @date 2019-07-04 19:46
     */
    AliTokenResult getAliColudToken() throws Exception;

    /**  功能描述 <br>
     * <身份认证结果集>
     *
     * @param ticketId
     * @return int
     * @date 2019-06-25 11:07
     */
    MemberRealInformResult identityCard(String ticketId) throws ClientException, IOException;

    /**  功能描述 <br>
     * <淘宝认证>
     *
     * @param
     * @return int
     * @date 2019-07-11 14:20
     */
    MemberRealInformResult taobaoAuth();

    /**  功能描述 <br>
     * <运营商认证>
     *
     * @param
     * @return com.xxz.rent.portal.model.dto.MemberRealInformResult
     * @date 2019-07-11 14:38
     */
    MemberRealInformResult mobileAuth();

    /**  功能描述 <br>
     * <学信网认证>
     *
     * @param
     * @return com.xxz.rent.portal.model.dto.MemberRealInformResult
     * @date 2019-07-11 14:39
     */
    MemberRealInformResult studyAuth();
    
    /**  功能描述 <br>
     * <个人信息认证>
     *
     *
     * @param bankcardPic
     * @param zmfVideo
     * @param staffPic
     * @param memberBaseInfoParam
     * @return com.xxz.rent.portal.model.dto.MemberRealInformResult
     * @date 2019-07-11 14:51
     */
    MemberRealInformResult personAuth(MultipartFile bankcardPic, MultipartFile zmfVideo, MultipartFile staffPic, MemberBaseInfoParam memberBaseInfoParam) throws IOException;

    /**  功能描述 <br>
     * <亲属信息认证>
     *
     * @param kinsfolk
     * @return com.xxz.rent.portal.model.dto.MemberRealInformResult
     * @date 2019-07-11 18:23
     */
    MemberRealInformResult kinsfolk(UmsMemberKinsfolkParam kinsfolk);

    /**  功能描述 <br>
     * <常用联系人认证>
     *
     * @param memberLink
     * @return com.xxz.rent.portal.model.dto.MemberRealInformResult
     * @date 2019-07-11 18:27
     */
    MemberRealInformResult link(UmsMemberLinkParam memberLink);
}
