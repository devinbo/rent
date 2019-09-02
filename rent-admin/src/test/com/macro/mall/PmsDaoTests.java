package com.macro.mall;


import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.HttpUtil;
import com.aliyun.oss.model.PutObjectResult;
import com.xxz.rent.MallAdminApplication;
import com.xxz.rent.dao.PmsMemberPriceDao;
import com.xxz.rent.dao.PmsProductDao;
import com.xxz.rent.dto.PmsProductResult;
import com.xxz.rent.model.PmsMemberPrice;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.protocol.HTTP;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallAdminApplication.class)
public class PmsDaoTests {
    @Autowired
    private PmsMemberPriceDao memberPriceDao;
    @Autowired
    private PmsProductDao productDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsDaoTests.class);

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    @Value("${aliyun.oss.dir.prefix}")
    private String dirPrefix;

    private String ossUrl = "https://xiaoxiangzu.oss-cn-hangzhou.aliyuncs.com";

    @Test
    @Transactional
    @Rollback
    public void testInsertBatch(){
        List<PmsMemberPrice> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            PmsMemberPrice memberPrice = new PmsMemberPrice();
            memberPrice.setProductId(1L);
            memberPrice.setMemberLevelId((long) (i+1));
            memberPrice.setMemberPrice(new BigDecimal("22"));
            list.add(memberPrice);
        }
        int count = memberPriceDao.insertList(list);
        Assert.assertEquals(5,count);
    }

    @Test
    public void  testGetProductUpdateInfo(){
        PmsProductResult productResult = productDao.getUpdateInfo(7L);
        String json = JSONUtil.parse(productResult).toString();
        LOGGER.info(json);
    }


    @Test
    public void testOssUpload() throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        //http://verify-img.cn-shanghai.img.aliyun-inc.com/68f938fb5d9648eaaf752c52e8be2cb8OSS.JPG?Expires=1561630330&OSSAccessKeyId=IJ95qE4nJQY6t6Lk&Signature=WoNHC50WVP%2FigJNa8hlbh4TbXtY%3D
        // 上传网络流。
        InputStream inputStream = new URL("http://pic25.nipic.com/20121205/10197997_003647426000_2.jpg").openStream();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String filename = UUID.randomUUID().toString() + ".jpg";
        String objectName = dirPrefix + sdf.format(new Date()) + File.separator + filename;
        System.out.println(objectName);
        PutObjectResult result = ossClient.putObject(bucketName, objectName, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
