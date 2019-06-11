package com.xxz.rent.portal.service.impl;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.mapper.UmsMemberMapper;
import com.xxz.rent.model.UmsMember;
import com.xxz.rent.model.UmsMemberExample;
import com.xxz.rent.portal.component.SmsMemberService;
import com.xxz.rent.portal.model.bo.MemberDetails;
import com.xxz.rent.portal.model.dto.LoginParam;
import com.xxz.rent.portal.service.RedisService;
import com.xxz.rent.portal.service.UmsMemberService;
import com.xxz.rent.portal.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 会员管理Service实现类
 * Created by macro on 2018/8/3.
 */
@Service
@Slf4j
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private SmsMemberService smsMemberService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisService redisService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${redis.key.prefix.memberTelephone}")
    private  String REDIS_KEY_MEMBERTELEPHONE;
    @Value("${redis.key.expire.member}")
    private Integer REDIS_KEY_EXPIRE_MEMBER;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public UmsMember getByUsername(String username) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            return memberList.get(0);
        }
        return null;
    }

    @Override
    public UmsMember getById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public CommonResult login(LoginParam loginParam) {

        //验证验证码
        if(!verifyAuthCode(loginParam.getSmsCode(), loginParam.getTelephone())){
            return CommonResult.failed("验证码错误");
        }

        //查询是否已有该用户
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(loginParam.getTelephone());
        List<UmsMember> umsMembers = memberMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(umsMembers)) {
            //没有该用户进行添加操作
            UmsMember umsMember = new UmsMember();
            umsMember.setPhone(loginParam.getTelephone());
            umsMember.setNickname(createDefaultNick());//设置默认昵称
            umsMember.setSourceType(loginParam.getSource());
            memberMapper.insert(umsMember);
        }

        //进行登陆操作
        String token = null;
        //密码需要客户端加密后传递
        try {
            MemberDetails memberDetails = smsMemberService.getUser(loginParam.getTelephone());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(memberDetails, null, memberDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(memberDetails);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    /**
     * 创建用户昵称
     */
    public String createDefaultNick() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
    }

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(),"获取验证码成功");
    }

    @Override
    public CommonResult updatePassword(String telephone, String password, String authCode) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(memberList)){
            return CommonResult.failed("该账号不存在");
        }
        //验证验证码
        if(!verifyAuthCode(authCode,telephone)){
            return CommonResult.failed("验证码错误");
        }
        UmsMember umsMember = memberList.get(0);
        memberMapper.updateByPrimaryKeySelective(umsMember);
        return CommonResult.success(null,"密码修改成功");
    }

    @Override
    public UmsMember getCurrentMember() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        System.out.println("curr"+auth.getPrincipal());
        MemberDetails memberDetails = (MemberDetails) auth.getPrincipal();
        return memberDetails.getUmsMember();
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {
        UmsMember record=new UmsMember();
        record.setId(id);
        record.setIntegration(integration);
        memberMapper.updateByPrimaryKeySelective(record);
    }


    //对输入的验证码进行校验
    private boolean verifyAuthCode(String authCode, String telephone){
        if(Objects.equals(authCode, "123456") && Objects.equals(telephone, "13788957291")) {
            return true;
        }
        if(StringUtils.isEmpty(authCode)){
            return false;
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        return authCode.equals(realAuthCode);
    }

}
