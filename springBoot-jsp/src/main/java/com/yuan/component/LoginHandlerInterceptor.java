package com.yuan.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2018-10-19
 * Time: 10:14
 * description: 登录拦截器，主要用于登录校验
 **/
@Configuration
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("userInfo");//从Session中获取用户信息
        //如果用户未登陆，则跳转至登录页面
        if(user == null){
            request.setAttribute("msg","您没有登录权限");
            request.getRequestDispatcher("/login").forward(request,response);
        }else{
            //如果用户已登录，直接放行
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
