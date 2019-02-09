package com.yuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//自动扫描的Mapper包，如果这里不指定，则需要在每个Mapper接口中添加@Mapper主键(这两种方法二选一)
@MapperScan("com.yuan.dao")
public class JinshengyuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(JinshengyuanApplication.class, args);
    }

}

