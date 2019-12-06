package com.xxz.rent.portal.service;

import com.xxz.rent.model.UmsMemberAuthRelation;
import com.xxz.rent.model.UmsMemberKinsfolk;
import com.xxz.rent.model.UmsMemberLink;
import com.xxz.rent.model.UmsMemberRealinform;
import com.xxz.rent.portal.model.dto.MemberResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author xxz
 */
@Transactional
public interface UmsMemberInfoService {
    /**  功能描述 <br>
     * <加载客户所有资料>
     *
     * @param
     * @return com.xxz.rent.portal.model.dto.MemberResult
     * @date 2019-07-12 10:23
     */
    MemberResult allInfo();

    /**  功能描述 <br>
     * <加载客户实名资料信息>
     *
     * @param
     * @return com.xxz.rent.portal.model.dto.MemberResult
     * @date 2019-07-12 10:32
     */
    UmsMemberRealinform realinform();

    /**  功能描述 <br>
     * <加载会员亲属资料信息>
     *
     * @param
     * @return com.xxz.rent.model.UmsMemberKinsfolk
     * @date 2019-07-12 10:38
     */
    UmsMemberKinsfolk kinsfolk();

    /**  功能描述 <br>
     * <加载常用联系人资料信息>
     *
     * @param
     * @return com.xxz.rent.model.UmsMemberLink
     * @date 2019-07-12 10:42
     */
    UmsMemberLink link();

    /**  功能描述 <br>
     * <加载客户的认证关系>
     *
     * @param
     * @return com.xxz.rent.model.UmsMemberAuthRelation
     * @date 2019-07-12 10:46
     */
    UmsMemberAuthRelation authRelation();

    /**  功能描述 <br>
     * <上传用户头像>
     *
     * @param file
     * @return void
     * @date 2019-07-30 09:57
     */
    String uploadHeadIcon(MultipartFile file) throws IOException;

    /**  功能描述 <br>
     * <修改用户资料信息>
     *
     * @param nick
     * @return int
     * @date 2019-07-30 10:10
     */
    int updateNick(String nick);
}
