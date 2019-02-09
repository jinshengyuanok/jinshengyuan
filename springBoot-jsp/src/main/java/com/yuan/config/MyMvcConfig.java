package com.yuan.config;

import com.yuan.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 使用 WebMvcConfigurationSupport 来扩展Spring MVC 的功能，spring boot自动配置 与Spring MVC协同工作
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2018-10-18
 * Time: 12:47
 * description:
 **/
//@EnableWebMvc //如果加入此注解则放弃spring boot 对Spring MVC所有功能的自动配置功能(Stpring Boot自动配置失效)，全面接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 实现与注册addViewControllers方法
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //让下面几种请求来到login页面
        registry.addViewController("/").setViewName("login");//启动时直接进入login页面
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.jsp").setViewName("login");
        registry.addViewController("/yuan").setViewName("login");
    }

    /***
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /* List<String> excludePathPatterns = new ArrayList<>();
        excludePathPatterns.add("/");
        excludePathPatterns.add("yuan");
        excludePathPatterns.add("/login");
        excludePathPatterns.add("/login.html");*/
        //registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.html","/","/login");
    }

    /**
     * 注册国际化资源
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
