package com.xxz.rent.portal.component;

import com.xxz.rent.mapper.UmsMemberMapper;
import com.xxz.rent.model.UmsMember;
import com.xxz.rent.model.UmsMemberExample;
import com.xxz.rent.portal.model.bo.MemberDetails;
import com.xxz.rent.portal.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class SmsMemberService implements UserDetailsService {

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.memberTelephone}")
    private  String REDIS_KEY_MEMBERTELEPHONE;
    @Value("${redis.key.expire.member}")
    private Integer REDIS_KEY_EXPIRE_MEMBER;

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }


    public MemberDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        UmsMemberExample umsMemberExample = new UmsMemberExample();
        umsMemberExample.createCriteria().andPhoneEqualTo(mobile);
        List<UmsMember> umsMemberList = umsMemberMapper.selectByExample(umsMemberExample);
        if(umsMemberList != null && umsMemberList.size() > 0) {
            UmsMember member = umsMemberList.get(0);
            redisService.setObj(REDIS_KEY_MEMBERTELEPHONE + member.getPhone(), member, REDIS_KEY_EXPIRE_MEMBER);
            return new MemberDetails(member);
        }
        return null;
    }

    public MemberDetails getUser(String mobile) throws UsernameNotFoundException {
        Object member = redisService.getObj(REDIS_KEY_MEMBERTELEPHONE + mobile);
        if(member == null) {
            return loadUserByMobile(mobile);
        }
        return new MemberDetails((UmsMember) member);
    }
}
