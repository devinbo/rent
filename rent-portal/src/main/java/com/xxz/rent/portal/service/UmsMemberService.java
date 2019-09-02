package com.xxz.rent.portal.service;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.model.UmsMember;
import com.xxz.rent.portal.model.dto.BindPhoneParam;
import com.xxz.rent.portal.model.dto.LoginParam;
import com.xxz.rent.portal.model.dto.LoginResult;
import com.xxz.rent.portal.model.dto.WxMemberResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员管理Service
 * Created by macro on 2018/8/3.
 */
@Transactional
public interface UmsMemberService {


    /**
     * 根据会员编号获取会员
     */
    UmsMember getById(Long id);

    /**
     * 用户注册
     */
    CommonResult<LoginResult> loginOrRegister(LoginParam loginParam);

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 获取当前登录会员
     */
    UmsMember getCurrentMember();

    /**
     * 根据会员id修改会员积分
     */
    void updateIntegration(Long id,Integer integration);

    /**
     * 从数据库加载用户信息
     */
    UmsMember getCurrentMemberByDb();

    /**  功能描述 <br>
     * <获取微信信息>
     *
     * @param code
     * @return java.lang.String
     * @date 2019-07-30 13:29
     */
    WxMemberResult weixinInfo(String code);

    /**  功能描述 <br>
     * <绑定用户手机>
     *
     * @param phoneParam
     * @return com.xxz.rent.portal.model.dto.LoginResult
     * @date 2019-07-30 14:04
     */
    CommonResult<LoginResult> bindPhone(BindPhoneParam phoneParam);
}
