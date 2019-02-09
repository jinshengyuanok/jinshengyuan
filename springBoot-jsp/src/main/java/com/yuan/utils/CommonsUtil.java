package com.yuan.utils;

import com.yuan.model.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2018-07-06
 * Time: 9:51
 * description:公用方法类
 **/
public class CommonsUtil {
    /**
     * 获取小写的UUID,长度为32位
     * @return
     */
    public static String  getLowerUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
    /**
     * 获取大写的UUID,长度为32位
     * @return
     */
    public static String  getUpperUUID(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }


    /**
     * 字符串转Date
     * @param strTime
     * @return
     * @throws ParseException
     */
    public static Date strTimeToDateTime(String strTime){
        Date date = null;
        SimpleDateFormat dateFormat = null;
        if(isNotEmpty(strTime)){
            if(strTime.length() > 10){
                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }else{
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            }
            try {
                date = dateFormat.parse(strTime);
            } catch (ParseException e) {
                System.out.println("字符日期转为Date类型时出错！");
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     * 字符串不为空且不为null时,返回true
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        if(!"".equals(str) && !"null".equals(str) && str != null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 如果为空或null 返回 null,否则返回原字符串
     * @param str
     * @return
     */
    public static String isEmptyReturnNull(String str) {
        if ("".equals(str) || "null".equals(str) || str == null) {
            return null;
        } else {
            return str;
        }
    }

    /**
     * 获取session信息中的用户对象对象
     * @return
     */
    public static User getLoginUserInfo(){
        HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        SessionInfo sessionInfo =  (SessionInfo) session.getAttribute(ConstantUtil.SESSION_INFO_KEY);
        return sessionInfo.getUser();
    }

    /**
     * 获取HttpServletRequest
     * @return
     */
    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
