package com.zhku.waterfowl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 吴梓轩
 * @since 2022-08-15
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.zhku")
@MapperScan("com.zhku.waterfowl.mapper")
public class WaterfowlApplication {
    public static void main(String[] args) {
        SpringApplication.run(WaterfowlApplication.class,args);
    }
}
