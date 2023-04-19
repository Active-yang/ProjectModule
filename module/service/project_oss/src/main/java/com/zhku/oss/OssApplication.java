package com.zhku.oss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 吴梓轩
 * @since 2022-09-17
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.zhku"})
@MapperScan("com.zhku.oss.mapper")
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
    }
}
