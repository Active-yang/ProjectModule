package com.zhku.acl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author WZX
 * @since 2022-10-25
 */

@SpringBootApplication
//开启定时器注解
@EnableScheduling
@ComponentScan(basePackages = "com.zhku")
@MapperScan("com.zhku.acl.mapper")
public class AclApplication {
    public static void main(String[] args) {
        SpringApplication.run(AclApplication.class, args);
    }
}
