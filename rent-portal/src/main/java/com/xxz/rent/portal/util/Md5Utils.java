package com.xxz.rent.portal.util;

import org.springframework.util.DigestUtils;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-04 15:01
 * @description：
 * @modified By：
 * @version: ：1.0
 */
public class Md5Utils {

    private static final String salt = "91xiaoxiangzu.com";

    public static String md5DigestAsHexBySalt(String s) {
        return  DigestUtils.md5DigestAsHex((salt + s).getBytes());
    }
}
