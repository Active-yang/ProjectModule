# ProjectModule

#### 介绍
这个一套整合Spring Boot+Mybatis-Plus框架模板，内置有阿里云OSS图片，视频上传服务模块，Swagger，RESTful风格的返回接口，（token方式）登录模块代码生成器模块，使用者只需要做到极少量的配置就可进行后端接口的开发，做到日常开发开箱即用的效果，免去了耗费大量时间搭建项目框架。

#### 安装教程
直接拉去上面github的代码在本地即可

#### 使用说明
模板在module模块中，其中：
    （一）common模块：
        1）common_utils模块：里面是RESTful风格接口的相关类；
        2）service_base模块：里面是配置文件，相关功能代码里相关注释很清楚；
    （二）service模块：
        1）project_acl模块：里面是使用token方式做登录功能的接口例子
        2）project_oss模块：里面是将图片上传到阿里云OSS和将图片传到前端的接口例子
        3）project_service模块：是一套CRUD接口例子，而且test报下的code类是代码生成器，方便日常开发
        
        希望能帮助需要的人！

