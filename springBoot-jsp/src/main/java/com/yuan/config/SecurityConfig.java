/*
package com.yuan.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        */
/**
         * 定义授权规则
         *//*

        //super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll().
                antMatchers("/account/**").hasRole("VIP1").
                antMatchers("/user/**").hasRole("VIP2");
        //开启自动配置的登录功能
        http.formLogin();
        //1. /login请求来到登录界面。效果，如果没有登录，则跳转至登录页面

        //2.重定向到/login?error表示请求失败


    }

    */
/**
     * 定义认证规则,用户信息可以从数据库中获取，这里为了方便，则放在内存中测试
     * @param auth
     * @throws Exception
     *//*

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);

        auth.inMemoryAuthentication().withUser("zhangsan").password("123").roles("VIP1","VIP2").
        and().withUser("lisi").password("123").roles("VIP1").and().withUser("wangwu").password("123").roles("VIP2");
    }
}
*/
