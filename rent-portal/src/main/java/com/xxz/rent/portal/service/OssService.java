package com.xxz.rent.portal.service;


import com.xxz.rent.commondto.OssCallbackResult;
import com.xxz.rent.commondto.OssPolicyResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * oss上传管理Service
 * Created by macro on 2018/5/17.
 */
@Transactional
public interface OssService {

    OssPolicyResult policy();

    OssCallbackResult callback(HttpServletRequest request);

    String uploadWithUrl(String url) throws IOException;

    String uploadWithFile(MultipartFile file) throws IOException;
}
