package com.yuan.component;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 定义国际化实现类
 */

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("language");//获取中英文切换的参数
        Locale locale = Locale.getDefault();//如果未指定Locale类,则使用系统默认的
        if(!isEmpty(language)){
            String[] split = language.split("_");//截取国家与语言代码
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

    public  boolean isEmpty(final String target) {
        return target == null || target.length() == 0;
    }
}
