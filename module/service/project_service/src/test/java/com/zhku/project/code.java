package com.zhku.project;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author xiaoyang
 * @date 2023/4/19 19:23
 */
public class code {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/joolun_ry?serverTimezone=GMT%2B8", "root", "1234")
                .globalConfig(builder -> {
                    builder.author("yang") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件（不要随意开启）
                            .outputDir("D:/JAVA/module/waterfowl/service/project_service/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.zhku") // 设置父包名
                            .moduleName("project") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    "D:/JAVA/module/waterfowl/service/project_service/src/main/java/com/zhku/project/mapper/xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("gen_table");// 设置需要生成的表名
                            //.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker 引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
