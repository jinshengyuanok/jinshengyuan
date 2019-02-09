package com.yuan.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2018-07-06
 * Time: 9:51
 * description:获取用户IP地址的工具类
 **/

public class UserIPUtil {

    public static String getUserIPAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        /*if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "本地";
        }*/
        return ip;
    }
}
