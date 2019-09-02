package com.xxz.rent.portal.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cloudauth.model.v20180916.*;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.xxz.rent.dto.enumerate.AuthStatus;
import com.xxz.rent.mapper.*;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.bo.exception.BusinessLogicException;
import com.xxz.rent.portal.model.dto.*;
import com.xxz.rent.portal.service.OssService;
import com.xxz.rent.portal.service.UmsMemberAuthService;
import com.xxz.rent.portal.service.UmsMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author xhb
 * @Date
 * @Version 1.0
 **/
@Service
@Slf4j
public class UmsMemberAuthServiceImpl implements UmsMemberAuthService {

    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private UmsMemberService umsMemberService;
    @Autowired
    private UmsMemberAuthRelationMapper memberAuthRelationMapper;
    @Autowired
    private UmsMemberRealinformMapper memberRealinformMapper;
    @Autowired
    private UmsMemberSettingMapper memberSettingMapper;
    @Autowired
    private UmsMemberKinsfolkMapper memberKinsfolkMapper;
    @Autowired
    private UmsMemberLinkMapper memberLinkMapper;

    @Autowired
    private OssService ossService;

    @Value("${alicloud.prBasic}")
    private String prBasic;
    @Value("${alicloud.regionId}")
    private String regionId;
    @Value("${alicloud.accessKeyId}")
    private String accessKeyId;
    @Value("${alicloud.accessKeySecret}")
    private String accessKeySecret;


    @Override
    public AliTokenResult getAliColudToken() throws Exception {
        AliTokenResult result = new AliTokenResult();
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        String ticketId = UUID.randomUUID().toString();
        result.setTicketId(ticketId);
        //认证token, 表达一次认证会话
        String token = null;
        GetVerifyTokenRequest getVerifyTokenRequest = new GetVerifyTokenRequest();
        getVerifyTokenRequest.setBiz(prBasic);
        getVerifyTokenRequest.setTicketId(ticketId);
        try {
            GetVerifyTokenResponse response = client.getAcsResponse(getVerifyTokenRequest);
            //token默认30分钟时效，每次发起认证时都必须实时获取
            token = response.getData().getVerifyToken().getToken();
            result.setToken(token);
        } catch (Exception e) {
            log.error("获取阿里云人脸认证Token失败：" + e.getMessage());
            throw new Exception("服务异常！");
        }
        return result;
    }

    @Override
    public MemberRealInformResult identityCard(String ticketId) throws ClientException, IOException {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        GetStatusRequest getStatusRequest = new GetStatusRequest();
        getStatusRequest.setBiz(prBasic);
        getStatusRequest.setTicketId(ticketId);
        GetStatusResponse response = client.getAcsResponse(getStatusRequest);
        //-1 未认证, 0 认证中, 1 认证通过, 2 认证不通过
        int statusCode = response.getData().getStatusCode();
        System.out.println(statusCode);
        Assert.isTrue(statusCode == 1, "该身份认证尚未通过，请重新认证身份");
        //7. 服务端获取认证资料
        GetMaterialsRequest getMaterialsRequest = new GetMaterialsRequest();
        getMaterialsRequest.setBiz(prBasic);
        getMaterialsRequest.setTicketId(ticketId);
        GetMaterialsResponse getMaterialsResponse = client.getAcsResponse(getMaterialsRequest);
        GetMaterialsResponse.Data data = getMaterialsResponse.getData();
        //保存用户身份认证信息
        UmsMemberRealinform realinform = addMemberIdentity(data);
        //更新用户姓名
        updateMemberNameAndSexAndIntegral(realinform);
        return getMemberRealInformResult();


    }

    @Override
    public MemberRealInformResult taobaoAuth() {
        UmsMember umsMember = umsMemberService.getCurrentMember();
        UmsMemberAuthRelation authRelation = new UmsMemberAuthRelation();
        //设置待审核
        authRelation.setTaobaoStatus(AuthStatus.WAITAUDIT.getStatus());

        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(umsMember.getId());

        memberAuthRelationMapper.updateByExampleSelective(authRelation, example);
        return getMemberRealInformResult();
    }

    @Override
    public MemberRealInformResult mobileAuth() {
        UmsMember umsMember = umsMemberService.getCurrentMember();
        UmsMemberAuthRelation authRelation = new UmsMemberAuthRelation();
        //设置待审核
        authRelation.setMobileStatus(AuthStatus.WAITAUDIT.getStatus());
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(umsMember.getId());
        memberAuthRelationMapper.updateByExampleSelective(authRelation, example);
        return getMemberRealInformResult();
    }

    @Override
    public MemberRealInformResult studyAuth() {
        UmsMember umsMember = umsMemberService.getCurrentMember();
        UmsMemberAuthRelation authRelation = new UmsMemberAuthRelation();
        //设置待审核
        authRelation.setStudyStatus(AuthStatus.WAITAUDIT.getStatus());
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(umsMember.getId());
        memberAuthRelationMapper.updateByExampleSelective(authRelation, example);
        return getMemberRealInformResult();
    }

    @Override
    public MemberRealInformResult personAuth(MultipartFile bankcardPic, MultipartFile zmfVideo, MultipartFile staffPic, MemberBaseInfoParam memberBaseInfoParam) throws IOException {
        UmsMember umsMember = umsMemberService.getCurrentMember();
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(umsMember.getId());
        List<UmsMemberAuthRelation> authRelationList = memberAuthRelationMapper.selectByExample(example);
        if (authRelationList == null || authRelationList.size() == 0) {
            throw new BusinessLogicException("请先完成实名认证！");
        } else {
            UmsMemberAuthRelation authRelation = authRelationList.get(0);
            if (AuthStatus.NOAUTH.getStatus() == authRelation.getIdentityStatus()) {
                throw new BusinessLogicException("请先完成实名认证！");
            }
            //更新认证项
            authRelation.setBaseinfoStatus(AuthStatus.WAITAUDIT.getStatus());
            memberAuthRelationMapper.updateByPrimaryKeySelective(authRelation);

            //保存实名信息
            UmsMemberRealinform realinform = new UmsMemberRealinform();
            realinform.setCompanyAddress(memberBaseInfoParam.getCompanyAddress());
            realinform.setCurrentAddress(memberBaseInfoParam.getCurrentAddress());
            realinform.setMonthIncome(memberBaseInfoParam.getMonthIncome());
            realinform.setMonthConsume(memberBaseInfoParam.getMonthConsume());
            realinform.setBankcardPic(ossService.uploadWithFile(bankcardPic));
            realinform.setZmfVideo(ossService.uploadWithFile(zmfVideo));
            realinform.setStaffPic(ossService.uploadWithFile(staffPic));
            realinform.setSchool(memberBaseInfoParam.getSchool());
            realinform.setMemberType(memberBaseInfoParam.getMemberType());

            UmsMemberRealinformExample realinformExample = new UmsMemberRealinformExample();
            realinformExample.createCriteria().andMemberIdEqualTo(umsMember.getId());
            memberRealinformMapper.updateByExampleSelective(realinform, realinformExample);
            return getMemberRealInformResult();
        }
    }

    @Override
    public MemberRealInformResult kinsfolk(UmsMemberKinsfolkParam kinsfolkParam) {
        UmsMemberKinsfolk kinsfolk = new UmsMemberKinsfolk();
        BeanUtils.copyProperties(kinsfolkParam, kinsfolk);
        UmsMember umsMember = umsMemberService.getCurrentMember();
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(umsMember.getId());
        List<UmsMemberAuthRelation> authRelationList = memberAuthRelationMapper.selectByExample(example);
        if (authRelationList == null || authRelationList.size() == 0) {
            throw new BusinessLogicException("请先完成实名认证！");
        } else {
            UmsMemberAuthRelation authRelation = authRelationList.get(0);
            if (AuthStatus.NOAUTH.getStatus() == authRelation.getIdentityStatus()) {
                throw new BusinessLogicException("请先完成实名认证！");
            }
            //更新认证项
            authRelation.setKinsfolkStatus(AuthStatus.WAITAUDIT.getStatus());
            memberAuthRelationMapper.updateByPrimaryKeySelective(authRelation);

            //更新亲属信息
            UmsMemberKinsfolkExample kinsfolkExample = new UmsMemberKinsfolkExample();
            kinsfolkExample.createCriteria().andMemberIdEqualTo(umsMember.getId());
            if (memberKinsfolkMapper.countByExample(kinsfolkExample) == 0) {
                kinsfolk.setMemberId(umsMember.getId());
                memberKinsfolkMapper.insertSelective(kinsfolk);
            } else {
                kinsfolk.setId(null);
                kinsfolk.setMemberId(null);
                memberKinsfolkMapper.updateByExampleSelective(kinsfolk, kinsfolkExample);
            }
            return getMemberRealInformResult();
        }
    }

    @Override
    public MemberRealInformResult link(UmsMemberLinkParam memberLinkParam) {
        UmsMemberLink memberLink = new UmsMemberLink();
        BeanUtils.copyProperties(memberLinkParam, memberLink);

        UmsMember umsMember = umsMemberService.getCurrentMember();
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(umsMember.getId());
        List<UmsMemberAuthRelation> authRelationList = memberAuthRelationMapper.selectByExample(example);
        if (authRelationList == null || authRelationList.size() == 0) {
            throw new BusinessLogicException("请先完成实名认证！");
        } else {
            UmsMemberAuthRelation authRelation = authRelationList.get(0);
            if (AuthStatus.NOAUTH.getStatus() == authRelation.getIdentityStatus()) {
                throw new BusinessLogicException("请先完成实名认证！");
            }
            //更新认证项
            authRelation.setLinkStatus(AuthStatus.WAITAUDIT.getStatus());
            memberAuthRelationMapper.updateByPrimaryKeySelective(authRelation);

            //更新亲属信息
            UmsMemberLinkExample linkExample = new UmsMemberLinkExample();
            linkExample.createCriteria().andMemberIdEqualTo(umsMember.getId());
            if (memberLinkMapper.countByExample(linkExample) > 0) {
                memberLink.setId(null);
                memberLink.setMemberId(null);
                memberLinkMapper.updateByExampleSelective(memberLink, linkExample);
            } else {
                memberLink.setMemberId(umsMember.getId());
                memberLinkMapper.insertSelective(memberLink);
            }
            return getMemberRealInformResult();
        }
    }

    private void updateMemberNameAndSexAndIntegral(UmsMemberRealinform realinform) {
        UmsMember umsMember = umsMemberService.getCurrentMemberByDb();
        umsMember.setName(realinform.getName());
        umsMember.setGender(realinform.getSex());
        //设置积分
        List<UmsMemberSetting> memberSettings = memberSettingMapper.selectByExample(new UmsMemberSettingExample());
        if (memberSettings != null && memberSettings.size() > 0) {
            UmsMemberSetting setting = memberSettings.get(0);
            umsMember.setFreeMoney(umsMember.getFreeMoney().add(setting.getRealinformAmount()));
        }
        memberMapper.updateByPrimaryKeySelective(umsMember);
        //更新用户项信息
        UmsMemberAuthRelation authRelation = new UmsMemberAuthRelation();
        //直接认证通过
        authRelation.setIdentityStatus(1);
        authRelation.setUpdateTime(new Date());
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(umsMember.getId());
        memberAuthRelationMapper.updateByExampleSelective(authRelation, example);
    }

    private MemberRealInformResult getMemberRealInformResult() {
        MemberRealInformResult result = new MemberRealInformResult();
        int nextStep = nextAuthStep(umsMemberService.getCurrentMember().getId());
        result.setStep(nextStep);

        UmsMember umsMember = umsMemberService.getCurrentMember();
        UmsMemberRealinformExample example = new UmsMemberRealinformExample();
        example.createCriteria().andMemberIdEqualTo(umsMember.getId());
        List<UmsMemberRealinform> memberRealinformList = memberRealinformMapper.selectByExample(example);
        if (memberRealinformList != null && memberRealinformList.size() > 0) {
            UmsMemberRealinform realinformDb = memberRealinformList.get(0);
            result.setName(realinformDb.getName());
            result.setIdentification(realinformDb.getIdentificationNumber());
            result.setPhone(umsMember.getPhone());
        }
        return result;
    }

    /**
     * 功能描述 <br>
     * <保存用户的身份证信息>
     *
     * @param data
     * @return void
     * @date 2019-06-25 11:17
     */
    private UmsMemberRealinform addMemberIdentity(GetMaterialsResponse.Data data) throws IOException {
        UmsMember umsMember = umsMemberService.getCurrentMember();
        UmsMemberRealinform realinform = new UmsMemberRealinform();
        realinform.setMemberId(umsMember.getId());
        realinform.setSex("m".equalsIgnoreCase(data.getSex()) ? 0 : 1);
        realinform.setName(data.getName());
        realinform.setEthnicGroup(data.getEthnicGroup());
        realinform.setAddress(getStrAddress(data.getAddress()));

        realinform.setFacePic(ossService.uploadWithUrl(data.getFacePic()));
        realinform.setIdCardFrontPic(ossService.uploadWithUrl(data.getIdCardFrontPic()));
        realinform.setIdCardBackPic(ossService.uploadWithUrl(data.getIdCardBackPic()));
        realinform.setIdCardExpiry(data.getIdCardExpiry());
        realinform.setIdCardStartDate(DateUtil.parse(data.getIdCardStartDate(), "yyyyMMdd").toJdkDate());
        realinform.setIdentificationNumber(data.getIdentificationNumber());

        //更新实名信息
        UmsMemberRealinformExample example = new UmsMemberRealinformExample();
        example.createCriteria().andMemberIdEqualTo(umsMember.getId());
        List<UmsMemberRealinform> memberRealinformList = memberRealinformMapper.selectByExample(example);
        if (memberRealinformList != null && memberRealinformList.size() > 0) {
            UmsMemberRealinform realinformDb = memberRealinformList.get(0);
            realinform.setId(realinformDb.getId());
            memberRealinformMapper.updateByPrimaryKeySelective(realinform);
        } else {
            memberRealinformMapper.insertSelective(realinform);
        }

        //更新认证项信息， 认证项中实名认证已完成
        return realinform;
    }

    //解析JSON地址为字符串
    private String getStrAddress(String address) {
        if(JSONUtil.isJson(address)) {
            Map map = JSONUtil.toBean(address, Map.class);
            Map<String, Object> addressMap = (Map<String, Object>) map.get("address");
            Map<String, String> provinceMap = (Map<String, String>) addressMap.get("province");
            Map<String, String>  cityMap = (Map<String, String> ) addressMap.get("city");
            Map<String, String>  townMap = (Map<String, String> ) addressMap.get("town");
            Map<String, String>  areaMap = (Map<String, String> ) addressMap.get("area");
            String detail =  map.get("detail") != null ? (String) map.get("detail") : "";
            String province = provinceMap.get("text") != null ? provinceMap.get("text") : "";
            String city = cityMap.get("text") != null ? cityMap.get("text") : "";
            String town = townMap.get("text") != null ? townMap.get("text") : "";
            String area = areaMap.get("text") != null ? areaMap.get("text") : "";
            return province + city + town + area + detail;
        }else{
            log.error("解析身份证地址信息失败；非有效JSON");
            return address;
        }
    }

    //下一认证步骤 0->已全部认证或申请； 1->身份认证；2->个人信息认证； 3->亲属信息； 4->常用联系人信息； 5->运营商信息； 6->淘宝； 7->学信网
    public int nextAuthStep(Long memberId) {
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        List<UmsMemberAuthRelation> authRelationList = memberAuthRelationMapper.selectByExample(example);
        if (authRelationList == null || authRelationList.size() == 0) {
            return 1;
        }
        UmsMemberAuthRelation authRelation = authRelationList.get(0);
        //0->尚未认证； 1->已通过； 2->未通过; 3->待审核
        if (0 == authRelation.getIdentityStatus()) {
            return 1;
        } else if (0 == authRelation.getBaseinfoStatus()) {
            return 2;
        } else if (0 == authRelation.getKinsfolkStatus()) {
            return 3;
        } else if (0 == authRelation.getLinkStatus()) {
            return 4;
        } else if (0 == authRelation.getMobileStatus()) {
            return 5;
        } else if (0 == authRelation.getTaobaoStatus()) {
            return 6;
        } else if (0 == authRelation.getStudyStatus()) {
            return 7;
        }
        return 0;
    }

}
