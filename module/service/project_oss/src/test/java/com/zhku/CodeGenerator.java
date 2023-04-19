package com.zhku;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://47.106.171.221:3306/waterfowl?serverTimezone=GMT%2B8", "waterfowl", "wzx")
                .globalConfig(builder -> {
                    builder.author("wzx") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件（不要随意开启）
                            .outputDir("D://ThoU/项目/水禽/waterfowl/service/waterfowl_oss/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.zhku") // 设置父包名
                            .moduleName("oss") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    "D://ThoU/项目/水禽/waterfowl/service/waterfowl_oss/src/main/java/com/zhku/oss/mapper/xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("monitor_pic") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker 引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
