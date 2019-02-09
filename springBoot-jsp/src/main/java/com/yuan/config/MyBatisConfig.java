package com.yuan.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2018-10-22
 * Time: 14:35
 * description: 注解版的MyBatis相关配置,
 **/
//@MapperScan("com.yuan.dao") //这个注解的位置与放在springBoot启动类上二选一
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
       return new ConfigurationCustomizer() {
           @Override
           public void customize(Configuration configuration) {
               configuration.setMapUnderscoreToCamelCase(true);//开启驼峰命名规则
           }
       };
    }
}
