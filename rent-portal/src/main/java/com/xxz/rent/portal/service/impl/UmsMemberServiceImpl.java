package com.xxz.rent.portal.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.common.api.ResultCode;
import com.xxz.rent.common.api.constant.SmsConstant;
import com.xxz.rent.common.api.dto.SmsModel;
import com.xxz.rent.common.api.utils.SendSmsUtil;
import com.xxz.rent.mapper.*;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.bo.exception.BusinessLogicException;
import com.xxz.rent.portal.component.SmsMemberService;
import com.xxz.rent.portal.model.bo.MemberDetails;
import com.xxz.rent.portal.model.dto.*;
import com.xxz.rent.portal.service.RedisService;
import com.xxz.rent.portal.service.UmsMemberService;
import com.xxz.rent.portal.util.JwtTokenUtil;
import com.xxz.rent.portal.util.PublicUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 会员管理Service实现类
 *
 * @author xxz
 */
@Service
@Slf4j
public class UmsMemberServiceImpl implements UmsMemberService {

    @Value("${spring.profiles.active}")
    private String profiles;

    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private UmsMemberAuthRelationMapper memberAuthRelationMapper;
    @Autowired
    private UmsMemberLoginLogMapper memberLoginLogMapper;
    @Autowired
    private SmsMemberService smsMemberService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UmsMemberSettingMapper memberSettingMapper;
    @Autowired
    private UmsMemberIntegralMapper memberIntegralMapper;
    @Autowired
    private UmsMemberService umsMemberService;

    @Value("${redis.key.prefix.memberTelephone}")
    private String redisKeyMemberTelephone;
    @Value("${redis.key.expire.member}")
    private Integer redisKeyExpireMember;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Value("${redis.key.prefix.authCode}")
    private String redisKeyPrefixAuthCode;
    @Value("${redis.key.expire.authCode}")
    private Long authCodeExpireSeconds;
    @Value("${wechat.appSecret}")
    private String appSecret;
    @Value("${wechat.accessTokenUrl}")
    private String accessTokenUrl;
    @Value("${wechat.appId}")
    private String appId;
    @Value("${wechat.userInfoUrl}")
    private String userInfoUrl;


    @Autowired
    private HttpServletRequest request;

    private String headIcon = "https://xiaoxiangzu.oss-cn-hangzhou.aliyuncs.com/common/head.png";

    @Override
    public UmsMember getById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public CommonResult loginOrRegister(LoginParam loginParam) {
        //验证验证码
        if (!verifyAuthCode(loginParam.getSmsCode(), loginParam.getTelephone())) {
            return CommonResult.failed("验证码错误");
        }
        //查询是否已有该用户
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(loginParam.getTelephone());
        List<UmsMember> umsMembers = memberMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(umsMembers)) {
            //创建基本信息
            Long memberId = createBaseMember(loginParam.getTelephone(), loginParam.getSource());
            //初始化认证项信息
            createMemberAuthItem(memberId);
        }
        //进行登陆操作
        MemberDetails memberDetails = smsMemberService.getUser(loginParam.getTelephone());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(memberDetails, null, memberDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(memberDetails);
        //登陆记录
        insertLoginLog(memberDetails.getUmsMember());

        LoginResult result = new LoginResult();
        result.setToken(token);
        result.setTokenHead(tokenHead);
        result.setUmsMember(memberDetails.getUmsMember());
        return CommonResult.success(result);
    }

    /**
     * 创建会员认证项信息
     *
     * @param memberId
     */
    private void createMemberAuthItem(Long memberId) {
        UmsMemberAuthRelation memberAuthRelation = new UmsMemberAuthRelation();
        memberAuthRelation.setMemberId(memberId);
        memberAuthRelationMapper.insertSelective(memberAuthRelation);
    }

    /**
     * 会员注册，创建会员基本信息
     *
     * @param telePhone
     * @param source
     */
    private Long createBaseMember(String telePhone, Integer source) {
        //没有该用户进行添加操作
        UmsMember umsMember = new UmsMember();
        umsMember.setPhone(telePhone);
        umsMember.setStatus(1);
        //设置默认昵称
        umsMember.setNickname(createDefaultNick(telePhone));
        umsMember.setSourceType(source);
        umsMember.setIcon(headIcon);
        //设置用户额度
        List<UmsMemberSetting> memberSettings = memberSettingMapper.selectByExample(new UmsMemberSettingExample());
        if (memberSettings != null && memberSettings.size() > 0) {
            UmsMemberSetting umsMemberSetting = memberSettings.get(0);
            //设置用户等初始化额度和积分
            umsMember.setIntegration(umsMemberSetting.getRegistIntegral());
            umsMember.setHistoryIntegration(umsMemberSetting.getRegistIntegral());
            umsMember.setFreeMoney(umsMemberSetting.getMemberFreeAmount());
            if (umsMemberSetting.getRegistIntegral() != null && umsMemberSetting.getRegistIntegral() != 0) {
                //记录积分信息
                UmsMemberIntegral memberIntegral = new UmsMemberIntegral();
                memberIntegral.setMemberId(umsMember.getId());
                //积分类型 0->注册；1->支付租金；2->商场消费
                memberIntegral.setType(0);
                memberIntegralMapper.insertSelective(memberIntegral);
            }
        }
        memberMapper.insertSelective(umsMember);
        return umsMember.getId();
    }

    private void insertLoginLog(UmsMember umsMember) {
        UmsMemberLoginLog memberLoginLog = new UmsMemberLoginLog();
        memberLoginLog.setCreateTime(new Date());
        memberLoginLog.setMemberId(umsMember.getId());
        memberLoginLog.setIp(PublicUtil.getIpAddr(request));
        memberLoginLogMapper.insertSelective(memberLoginLog);
    }

    /**
     * 创建用户昵称
     * @param telePhone
     */
    private String createDefaultNick(String telePhone) {
        StringBuilder sbd = new StringBuilder(telePhone);
        sbd.replace(3, 7, "****");
        return "用户" + sbd;
    }

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        //生成6为随机验证码
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //开始发送短信验证码
        SmsModel smsModel = new SmsModel();
        smsModel.setCode(sb.toString());
        CommonResult commonResult = SendSmsUtil.send(telephone, SmsConstant.TEMPLATE_LOGIN, JSONUtil.toJsonStr(smsModel));
        if (commonResult.getCode() == ResultCode.SUCCESS.getCode()) {
            //验证码绑定手机号并存储到redis
            redisService.set(redisKeyPrefixAuthCode + telephone, sb.toString());
            redisService.expire(redisKeyPrefixAuthCode + telephone, authCodeExpireSeconds);
            return CommonResult.success();
        } else {
            return commonResult;
        }
    }


    @Override
    public UmsMember getCurrentMember() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        if (auth == null || auth.getPrincipal() == null
                || Objects.equals("anonymousUser", auth.getPrincipal())) {
            //匿名用户的话，就返回null
            return null;
        }
        MemberDetails memberDetails = (MemberDetails) auth.getPrincipal();
        return memberDetails.getUmsMember();
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {
        UmsMember record = new UmsMember();
        record.setId(id);
        record.setIntegration(integration);
        memberMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public UmsMember getCurrentMemberByDb() {
        return memberMapper.selectByPrimaryKey(getCurrentMember().getId());
    }

    @Override
    public WxMemberResult weixinInfo(String code) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("appid", appId);
            params.put("secret", appSecret);
            params.put("code", code);
            params.put("grant_type", "authorization_code");
            String responseStr = HttpUtil.createGet(accessTokenUrl).form(params).execute().body();
            Map<String, Object> access = JSONUtil.toBean(responseStr, Map.class);
            String accessToken = (String) access.get("access_token");
            String openId = (String) access.get("openid");
            Map<String, Object> userInfoParam = new HashMap<>();
            userInfoParam.put("access_token", accessToken);
            userInfoParam.put("openid", openId);
            //加载客户信息
            String respStr = HttpUtil.createGet(userInfoUrl).form(userInfoParam).execute().body();
            WxUserInfo wxUserInfo = JSONUtil.toBean(respStr, WxUserInfo.class);

            //判断该客户是否已经登陆
            UmsMember umsMember = getMemberByWxOpenId(wxUserInfo.getOpenid());
            WxMemberResult result = new WxMemberResult();
            if (umsMember == null) {
                //尚未绑定，那么就进行绑定并登陆
                //保存临时信息, 绑定用户才能生成用户信息
                redisService.setObj(wxUserInfo.getOpenid(), wxUserInfo, 3600 * 2);
                result.setBindStatus(0);
                result.setOpenid(wxUserInfo.getOpenid());
                return result;
            } else {
                //进行登陆操作
                //进行登陆操作
                MemberDetails memberDetails = smsMemberService.getUser(umsMember.getPhone());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(memberDetails, null, memberDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String token = jwtTokenUtil.generateToken(memberDetails);
                //登陆记录
                insertLoginLog(memberDetails.getUmsMember());
                result.setBindStatus(1);
                result.setToken(token);
                result.setTokenHead(tokenHead);
                result.setUmsMember(umsMember);
                return result;
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new BusinessLogicException("服务错误，请稍微尝试！");
        }

    }

    private UmsMember getMemberByWxOpenId(String openid) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andWechatOpenidEqualTo(openid);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (memberList == null || memberList.size() == 0) {
            return null;
        }
        UmsMember umsMember = memberList.get(0);
        if (0 == umsMember.getStatus()) {
            throw new BusinessLogicException("该账号被禁用");
        }
        return umsMember;
    }

    @Override
    public CommonResult<LoginResult> bindPhone(BindPhoneParam phoneParam) {
        //验证验证码
        if (!verifyAuthCode(phoneParam.getSmsCode(), phoneParam.getTelephone())) {
            return CommonResult.failed("验证码错误");
        }
        //查询是否已有该用户
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(phoneParam.getTelephone());
        List<UmsMember> umsMembers = memberMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(umsMembers)) {

            //创建基本信息
            Long memberId = createWxMember(phoneParam.getTelephone(), phoneParam.getSource(), phoneParam.getOpenid());
            //初始化认证项信息
            createMemberAuthItem(memberId);
        }
        //绑定当前微信信息
        bindWxUserInfo(phoneParam.getTelephone(), phoneParam.getOpenid());


        //进行登陆操作
        MemberDetails memberDetails = smsMemberService.getUser(phoneParam.getTelephone());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(memberDetails, null, memberDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(memberDetails);
        //登陆记录
        insertLoginLog(memberDetails.getUmsMember());

        LoginResult result = new LoginResult();
        result.setToken(token);
        result.setTokenHead(tokenHead);
        result.setUmsMember(memberDetails.getUmsMember());
        return CommonResult.success(result);
    }

    private void bindWxUserInfo(String telephone, String openid) {
        Object obj = redisService.getObj(openid);
        if (obj == null) {
            throw new BusinessLogicException("微信授权已过期，请重新授权！");
        }
        WxUserInfo wxUserInfo = (WxUserInfo) obj;
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<UmsMember> umsMemberList = memberMapper.selectByExample(example);
        UmsMember umsMember = umsMemberList.get(0);
        if(0 == umsMember.getStatus()) {
            throw new BusinessLogicException("该账号已被禁用，请更换手机号");
        }
        umsMember.setNickname(wxUserInfo.getNickname());
        umsMember.setGender(Integer.valueOf(wxUserInfo.getSex()));

        //设置微信信息
        umsMember.setWechatNick(wxUserInfo.getNickname());
        umsMember.setWechatOpenid(wxUserInfo.getOpenid());
        umsMember.setWechatHeadPic(wxUserInfo.getHeadimgurl());
        umsMember.setCity(wxUserInfo.getCity());
        umsMember.setWechatCountry(wxUserInfo.getCountry());
        umsMember.setWechatProvince(wxUserInfo.getProvince());

        memberMapper.updateByPrimaryKeySelective(umsMember);
    }

    private Long createWxMember(String telePhone, Integer source, String openid) {

        //没有该用户进行添加操作
        UmsMember umsMember = new UmsMember();
        umsMember.setPhone(telePhone);
        umsMember.setStatus(1);
        //设置默认昵称
        umsMember.setNickname(createDefaultNick(telePhone));
        umsMember.setSourceType(source);
        umsMember.setIcon(headIcon);


        //设置用户额度
        List<UmsMemberSetting> memberSettings = memberSettingMapper.selectByExample(new UmsMemberSettingExample());
        if (memberSettings != null && memberSettings.size() > 0) {
            UmsMemberSetting umsMemberSetting = memberSettings.get(0);
            //设置用户等初始化额度和积分
            umsMember.setIntegration(umsMemberSetting.getRegistIntegral());
            umsMember.setHistoryIntegration(umsMemberSetting.getRegistIntegral());
            umsMember.setFreeMoney(umsMemberSetting.getMemberFreeAmount());
            if (umsMemberSetting.getRegistIntegral() != null && umsMemberSetting.getRegistIntegral() != 0) {
                //记录积分信息
                UmsMemberIntegral memberIntegral = new UmsMemberIntegral();
                memberIntegral.setMemberId(umsMember.getId());
                //积分类型 0->注册；1->支付租金；2->商场消费
                memberIntegral.setType(0);
                memberIntegralMapper.insertSelective(memberIntegral);
            }
        }
        memberMapper.insertSelective(umsMember);
        return umsMember.getId();
    }

    /**
     * 校验验证码
     *
     * @param authCode
     * @param telephone
     * @return
     */
    private boolean verifyAuthCode(String authCode, String telephone) {
        //开发，仿真环境调试
        if (!Objects.equals(profiles, "prod") && Objects.equals(authCode, "888888")) {
            return true;
        }
        //苹果及其他市场测试人员登陆账号，验证码
        if (Objects.equals(telephone, "13788957291") && Objects.equals(authCode, "251230")) {
            return true;
        }
        if (StringUtils.isEmpty(authCode)) {
            return false;
        }
        String realAuthCode = redisService.get(redisKeyPrefixAuthCode + telephone);
        return authCode.equals(realAuthCode);
    }

    /**
     * 校验手机号
     */
    private boolean checkPhone(String phone) {
        String regex = "^1[3|4|5|6|7|8|9][0-9]\\d{4,8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        return m.matches();
    }


}
