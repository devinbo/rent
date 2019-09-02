package com.xxz.rent.service;

import com.xxz.rent.dto.OssCallbackResult;
import com.xxz.rent.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * oss上传管理Service
 * Created by macro on 2018/5/17.
 */
public interface OssService {

    OssPolicyResult policy();

    OssCallbackResult callback(HttpServletRequest request);

    String uploadWithUrl(String url, String dirPrefix) throws IOException;
}
