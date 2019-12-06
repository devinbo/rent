package com.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cloudauth.model.v20180916.*;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.xxz.rent.dto.enumerate.OtoOrderStatus;
import com.xxz.rent.portal.util.Md5Utils;
import com.xxz.rent.portal.util.OrderInfoUtil;
import com.xxz.rent.portal.util.SignUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.util.*;

public class BaseTest {


    @Test
    public void test() {

//        //创建DefaultAcsClient实例并初始化
//        DefaultProfile profile = DefaultProfile.getProfile(
//                "cn-hangzhou", //默认
//                "LTAIdF00HsZdZi3k", //您的Access Key ID
//                "NBb4yxDYb5El4vMyRkGxIlWv0crwvA"); //您的Access Key Secret
//        IAcsClient client = new DefaultAcsClient(profile);
//        String biz = "xxz-service"; //您在控制台上创建的、采用RPMin认证方案的认证场景标识, 创建方法：https://help.aliyun.com/document_detail/59975.html
//        String ticketId = UUID.randomUUID().toString(); //认证ID, 由使用方指定, 发起不同的认证任务需要更换不同的认证ID
//        System.out.println(ticketId);
////提交认证材料
//        SubmitVerificationRequest submitRequest = new SubmitVerificationRequest();
//        submitRequest.setBiz(biz);
//        submitRequest.setTicketId(ticketId);
////创建要提交的认证材料列表, 请根据 认证方案 中的说明传入相应字段
//        List<SubmitVerificationRequest.Material> verifyMaterials = new ArrayList<SubmitVerificationRequest.Material>();
//        SubmitVerificationRequest.Material identificationNumber = new SubmitVerificationRequest.Material();
//        identificationNumber.setMaterialType("IdentificationNumber");
//        identificationNumber.setValue("342225199205192819");
//        verifyMaterials.add(identificationNumber);
//        SubmitVerificationRequest.Material name = new SubmitVerificationRequest.Material();
//        name.setMaterialType("Name");
//        name.setValue("邢昊波");
//        verifyMaterials.add(name);
//        //传入图片资料，请控制单张图片大小在 2M 内，避免拉取超时
//        SubmitVerificationRequest.Material facePic = new SubmitVerificationRequest.Material();
//        facePic.setMaterialType("FacePic");
//        facePic.setValue("https://xiaoxiangzu.oss-cn-hangzhou.aliyuncs.com/images/20190621/%E4%BA%BA%E5%83%8F%E6%B5%8B%E8%AF%95%E7%85%A7.jpeg");
//        verifyMaterials.add(facePic);
//        SubmitVerificationRequest.Material idCardFrontPic = new SubmitVerificationRequest.Material();
//        idCardFrontPic.setMaterialType("IdCardFrontPic");
//        idCardFrontPic.setValue("https://xiaoxiangzu.oss-cn-hangzhou.aliyuncs.com/images/20190621/121561542456_.pic.jpg"); //http方式上传图片, 此http地址须可公网访问
//        verifyMaterials.add(idCardFrontPic);
//        SubmitVerificationRequest.Material idCardBackPic = new SubmitVerificationRequest.Material();
//        idCardBackPic.setMaterialType("IdCardBackPic");
//        idCardBackPic.setValue("https://xiaoxiangzu.oss-cn-hangzhou.aliyuncs.com/images/20190621/111561542453_.pic.jpg"); //oss方式上传图片, 此oss文件地址须可公开访问
//        verifyMaterials.add(idCardBackPic);
//        submitRequest.setMaterials(verifyMaterials);
//        try {
//            SubmitVerificationResponse response = client.getAcsResponse(submitRequest);
//            //后续业务处理
//            SubmitVerificationResponse.Data data = response.getData();
//            System.out.println(data.getVerifyStatus());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Test
    public void test2() throws ClientException {
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-hangzhou", //默认
                "LTAIdF00HsZdZi3k", //您的Access Key ID
                "NBb4yxDYb5El4vMyRkGxIlWv0crwvA"); //您的Access Key Secret
        IAcsClient client = new DefaultAcsClient(profile);
//        GetStatusRequest getStatusRequest = new GetStatusRequest();
//        getStatusRequest.setBiz("xxz-service");
//        getStatusRequest.setTicketId("1954ca89-9627-4f94-9e61-29a97415868e");
//        GetStatusResponse response = client.getAcsResponse(getStatusRequest);
        //-1 未认证, 0 认证中, 1 认证通过, 2 认证不通过
//        int statusCode = response.getData().getStatusCode();
//        if(statusCode == 1) {
            //7. 服务端获取认证资料
            GetMaterialsRequest getMaterialsRequest = new GetMaterialsRequest();
            getMaterialsRequest.setBiz("xxz-service");
            getMaterialsRequest.setTicketId("4d3464d3-d01b-4f63-ab66-b8c359bcdf6c");
            GetMaterialsResponse getMaterialsResponse = client.getAcsResponse(getMaterialsRequest);
            GetMaterialsResponse.Data data = getMaterialsResponse.getData();

            System.out.println(data.getSex());
            System.out.println(data.getName());
            System.out.println(data.getAddress());
            System.out.println(data.getAuthority());
            System.out.println(data.getEthnicGroup());
            System.out.println(data.getFacePic());
            System.out.println(data.getIdCardBackPic());
            System.out.println(data.getIdCardFrontPic());
            System.out.println(data.getIdCardExpiry());
            System.out.println(data.getIdCardStartDate());
            System.out.println(data.getIdCardType());
            System.out.println(data.getIdentificationNumber());

    }


    public void uploadAliOSS(String url) {

    }

    @Test
    public void testJson() {
        String json = "{\"address\":{\"area\":{\"text\":\"枞阳县\",\"value\":\"340823\",\"key\":\"area\"},\"province\":{\"text\":\"安徽省\",\"value\":\"340000\",\"key\":\"province\"},\"town\":{\"value\":\"0\",\"key\":\"town\"},\"city\":{\"text\":\"安庆市\",\"value\":\"340800\",\"key\":\"city\"}},\"detail\":\"汤沟镇中心村民主组19号\"}";
        Map map = JSONUtil.toBean(json, Map.class);
        Map<String, Object> address = (Map<String, Object>) map.get("address");
        Map<String, String> provinceMap = (Map<String, String>) address.get("province");
        Map<String, String>  cityMap = (Map<String, String> ) address.get("city");
        Map<String, String>  townMap = (Map<String, String> ) address.get("town");
        Map<String, String>  areaMap = (Map<String, String> ) address.get("area");
        String detail =  map.get("detail") != null ? (String) map.get("detail") : "";
        String province = provinceMap.get("text") != null ? provinceMap.get("text") : "";
        String city = cityMap.get("text") != null ? cityMap.get("text") : "";
        String town = townMap.get("text") != null ? townMap.get("text") : "";
        String area = areaMap.get("text") != null ? areaMap.get("text") : "";
        System.out.println(province + city + town + area + detail);
    }


    //36d0b6c91e05605bd3db95700b4d1e2f
    @Test
    public void testIndex() {
        SortedMap map = new TreeMap();
        map.put("appid", "wx13e6963ce014537b");
        map.put("body", "租赁押金");
        map.put("mch_id", "1540260361");
        map.put("nonce_str", "TlKvQAbTyourbrIrlNZZHvrcvKYTlYAY");
        map.put("notify_url", "http://47.99.103.214:8085/payback/wechatpay-callback");
        map.put("spbill_create_ip", "192.168.1.130");
        map.put("total_fee", "2699.00");
        map.put("trade_type", "APP");

        String sign = SignUtils.createWxSign(map, "sMNZ3dJKgFZJZGcOHgix5me6r18W6yUA");
        System.out.println(sign);
    }

    @Test
    public void test5() {
        String s = "appid=wx13e6963ce014537b&body=test&mch_id=1540260361&nonce_str=eePceRCPsjAfDqDHHALFBwGwTxeXJKmK&notify_url=http://47.99.103.214:8085/payback/wechatpay-callback&out_trade_no=7314383651&spbill_create_ip=192.168.1.130&total_fee=269900&trade_type=APP&key=5bb08b912bfdf2a1d43c08ae16222aa0";

        System.out.println(DigestUtils.md5DigestAsHex(s.getBytes()));

    }

    @Test
    public void test6() throws AlipayApiException {
        Map<String, String> params = new HashMap<>();
        params.put("gmt_create", "2019-08-01 09:34:27");
        params.put("charset", "utf-8");
        params.put("seller_email", "wx13788957291@163.com");
        params.put("subject", "押金支付");
        params.put("sign", "bdUjotena9tH7/cf/sYz7UUe0Rmtka5Z43z2n4nj5WyKIPpsL2efuue49m1+lmGcIyjyb5JirdC4e30SRSZ+fziMstToK60YmiE6H5UmIZVaDyx5V/MZ18jjq8axas+6r+8EEzX4PMdQWlIJdQ1gYL1fm57qN8aUB4tw5y/Oh5By9po+Mnh5kLDnV64XNLT1pdzY2fDG0WaTL99BIRQrvbj8psD1lbjoaHawTmLZO0J7gc6UjiG4wso7/Gq1Zj9ubc4S/Ps+OfBb/QGf1t8yzNvobtq6fRh2PLJzxqgoYvABLrBbEGpvYejQxHYYMEf2lfQilCz8aHZo6GFQn4rY+A==");
        params.put("body", "支付租赁押金");
        params.put("buyer_id", "2088712912254324");
        params.put("invoice_amount", "0.01");
        params.put("notify_id", "2019080100222093428054320520311755");

        params.put("fund_bill_list", "[{\"amount\":\"0.01\",\"fundChannel\":\"PCREDIT\"}]");
        params.put("notify_type", "trade_status_sync");
        params.put("trade_status", "TRADE_SUCCESS");
        params.put("receipt_amount", "0.01");

        params.put("app_id", "2018052360203156");
        params.put("buyer_pay_amount", "0.01");
        params.put("sign_type", "RSA2");
        params.put("seller_id", "2088131302814058");
        params.put("gmt_payment", "2019-08-01 09:34:28");
        params.put("notify_time", "2019-08-01 09:34:28");
        params.put("passback_params", "orderId%3D61%3Btype%3D1");
        params.put("version", "1.0");
        params.put("out_trade_no", "0801093417-1593");
        params.put("total_amount", "0.01");
        params.put("trade_no", "2019080122001454320543742439");
        params.put("auth_app_id", "2018052360203156");
        params.put("buyer_logon_id", "183****8024");
        params.put("point_amount", "0.00");


        boolean signVerified = AlipaySignature.rsaCheckV1(params, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1oRPk/N0Hzt6oTmnGRQWUdRkgrDamL1ACzZWC5y+d1GiOb4pWnpBYnHgh7ty8Y29uWsPILCE8dy+391oMi7WYq1OEmO1ZRzleuZoiNUDQmoHSLL6aKREB9DM/jNPYTEDbEaYoTaO8o15z2pqyYJimR3ahu38mcdhbsim9EFq7L6Of30uv4PMfccg9jPNm2LUXz/5eakfxWP4ZJKot4KMQi2zer1XeMH+XDVFpp56+5cQkgwbwILEXhN416nrlNPQT2TBApp2jnrLCnJ4HBAoLx16Ta1It8LFpW6V1256cbJbBXehstNJtEL/XsxMBiHxiCNbJ4xF3/jD3gq25zPlCQIDAQAB", "UTF-8", "RSA2");
        System.out.println(signVerified);
    }


    @Test
    public void test7() throws AlipayApiException {
        String s = "{\"gmt_create\":\"2019-08-01 10:33:16\",\"charset\":\"utf-8\",\"seller_email\":\"wx13788957291@163.com\",\"subject\":\"押金支付\",\"sign\":\"kXFP2DwekXZZ5NpVQaJlEZpKJr/ms/UdCEQq3/EN34HF/JBnq47hTHC4pOyj3zaUEJbgVpyo4CV08Ga6wszAk8bgicHGPRLUbAgdGNKU3SMxREKvcXQ4p1gJuZo03WqZ+maXbLqV05gAMItzEMllorf7BEGOdVCqfUczfshBiQ9umRnMDwbHRvNNRE7+C2mqfDGCidmC63Qvo273xF1UnUdi9gtUvlNqLorlutLwBIk+dN3fSXv+fqEQ3KWNE0Pp8njZA0M0PZT/CWGJqH58nzjifCLCxITIUcNKZQ3IRC8msLV8xMhmSqjn8IgupKG0MoCMXIHFOPw1XGWl6Q3zTA==\",\"body\":\"支付租赁押金\",\"buyer_id\":\"2088712912254324\",\"invoice_amount\":\"0.01\",\"notify_id\":\"2019080100222103317054320520634584\",\"fund_bill_list\":\"[{\\\"amount\\\":\\\"0.01\\\",\\\"fundChannel\\\":\\\"PCREDIT\\\"}]\",\"notify_type\":\"trade_status_sync\",\"trade_status\":\"TRADE_SUCCESS\",\"receipt_amount\":\"0.01\",\"app_id\":\"2018052360203156\",\"buyer_pay_amount\":\"0.01\",\"sign_type\":\"RSA2\",\"seller_id\":\"2088131302814058\",\"gmt_payment\":\"2019-08-01 10:33:17\",\"notify_time\":\"2019-08-01 10:33:17\",\"passback_params\":\"orderId%3D63%3Btype%3D1\",\"version\":\"1.0\",\"out_trade_no\":\"080110330818392\",\"total_amount\":\"0.01\",\"trade_no\":\"2019080122001454320542535200\",\"auth_app_id\":\"2018052360203156\",\"buyer_logon_id\":\"183****8024\",\"point_amount\":\"0.00\"}";
        Map<String, String> params = JSONUtil.toBean(s, Map.class);
        boolean b = AlipaySignature.rsaCheckV1(params, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1oRPk/N0Hzt6oTmnGRQWUdRkgrDamL1ACzZWC5y+d1GiOb4pWnpBYnHgh7ty8Y29uWsPILCE8dy+391oMi7WYq1OEmO1ZRzleuZoiNUDQmoHSLL6aKREB9DM/jNPYTEDbEaYoTaO8o15z2pqyYJimR3ahu38mcdhbsim9EFq7L6Of30uv4PMfccg9jPNm2LUXz/5eakfxWP4ZJKot4KMQi2zer1XeMH+XDVFpp56+5cQkgwbwILEXhN416nrlNPQT2TBApp2jnrLCnJ4HBAoLx16Ta1It8LFpW6V1256cbJbBXehstNJtEL/XsxMBiHxiCNbJ4xF3/jD3gq25zPlCQIDAQAB", "UTF-8", "RSA2");
        System.out.println(b);
    }

    @Test
    public void test8() {
        String s = "appid=wx13e6963ce014537b&nonceStr=pBytPBRcTRgjvsIPLbiOKfCDIHtCWviY&package=Sign=WXPay&partnerid=1540260361&prepayid=wx011522398342733a3ad0da041777595800&timeStamp=1564644159&key=MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDWhE+T83QfO3qhOacZFBZR1GSCsNqYvUALNlYLnL53UaI5vilaekFiceCHu3Lxjb25aw8gsITx3L7f3WgyLtZirU4SY7VlHOV65miI1QNCagdIsvpopEQH0Mz+M09hMQNsRpihNo7yjXnPamrJgmKZHdqG7fyZx2FuyKb0QWrsvo5/fS6/g8x9xyD2M82bYtRfP/l5qR/FY/hkkqi3goxCLbN6vVd4wf5cNUWmnnr7lxCSDBvAgsReE3jXqeuU09BPZMECmnaOessKcngcECgvHXpNrUi3wsWlbpXXbnpxslsFd6Gy00m0Qv9ezEwGIfGII1snjEXf+MPeCrbnM+UJAgMBAAECggEAQejVKngarZ3wx6iXFrV9Rhcj6qO8BkHfc5J2TYsTWkXSujsbKZl2jXC/s/R8FIugR2AFfd2+ezF/0/iLEyAg7qCg5DWOfkqql2BDrgcEwVsiccvL9GrEHEKjOVc6hHoyuwnVy3Kf6RZe3sOrm85bzP/HLL3iZr1Dym4MHfAbkjFKOTQYYQITmOKtrnx/WqQ1lV0IeyxC5csSLM3qt5gcb7XYaK6F/Psniuq9uXv6J3XZvkAQnJ4EEkQwGqUe7dPAt76Y17eQB/4WgkgthSb6BWYyMO5OtrtKjdTBuMQq9+a6kZjYYmm4xOnz/718DedeBAGOXq/s2/QRtc42FC0CgQKBgQDwn2EQdaG/N+CLpjOJ+uuNtlmwgBaQxytL3fqgmWi1KHk7gPE+/CX3K9k0/XM5XNGCwC3qP1aFK2Z28JG4+/8MJ6nEa7QO+W66WWLTP/rPbrsuzz8N66kW3HkWzsfobWD08VPq2TfoqsvfcItkdcIZJqzXwwgt5xVlnQRjaBU6jQKBgQDkOdaHl/a95yFjj/Kpprn+bUPiWThEHAw6Tw9Xe1ThriuRUePpjfyx+1csx8L1f6YcXOFcXbGt9G1OzyBqf8bZxk1wdOycrf1WJ11aCUlUhpxgJtpzsJ0S2g4DfVZGZVOA0uap/kwBjNaD/X2tjA8kAkTzeOEcmfuAtZVhZneTbQKBgQCexNs8DBIU5R7BpoG9WpaQpDCb+HhrQS/9WFPmIjNnzXPo4lTMdX3rkMA6ab3crLUFbB8fwHkrV469jlDo2UXZ1FX9Z/+gHc+FIDPIJiAtPOg/o7n8SnIAxqsTdI+NepaOKKpxfLCaUhBBt7YSLG1NQSqtF2BPQXnp2Wgq22OehQKBgQDTlWN0NchE6oCj4xIfgjiwze+/auOlETOs4xrgCbD5wRUXFoprPn1lLBT3qQLvwrXnWZx8m0hcc1zbUV9GHMvnndaxSVULNKrHMptzG2Tmfh1/bsXbt4MHtSyEw7A2dz3hEqVSODWSwlUl7N6VBGINCiWOaySX9ZGbE703nV2CSQKBgAKVnDkt/mzJZdX9BHozd49wUFK8QegX7XdupDri0JU55zjgZzfltEnttlX2dVpaJG6u8Nd643o7BDEzSyVJtzc45pdysuJdjZ5g4f7Fif1wcKFBZfhKCXqpxAioFqW8wuae2A1WimrMBmGN1T/YdzFZUEAyUl5/xA/jm3qSyDRm";
        System.out.println(DigestUtils.md5DigestAsHex(s.getBytes()));
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " running...");
            try {
                Thread.sleep(2000);
            }catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end...");
        }
    }

    @Test
    public void test9() {
        String s = StrUtil.padAfter("0.9".replaceAll("\\.", ""), 6, "0");
        System.out.println(Integer.valueOf(s));
    }

    @Test
    public void test10() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(CollectionUtil.sub(list, 0, 5));
    }
}
