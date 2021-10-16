# swagger-spring-boot-starter-test

该项目是使用swagger-spring-boot-starter组件的示例项目。

## 第一步：引入依赖

``` xml
<!-- swagger功能组件 -->
<dependency>
    <groupId>com.kdyzm</groupId>
    <artifactId>swagger-spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## 第二步：配置swagger信息
在配置文件中新增配置
``` yaml
swagger:
  config:
    #每个人只关心自己的包名，方便和前端文档对接
    base-package: com.kdyzm.swagger.test
    description: swagger测试项目
    group:
      #swagger注册唯一标识，每个人都要不一样
      appName: ${spring.application.name}
      name: swagger测试项目
    api:
      title: swagger测试项目
      contactName: kdyzm@foxmail.com
    #swagger注册中心地址
    server-url: http://49.234.14.191:8102
```

## 第三步：激活swagger profile
只是做了前两步，不会对项目产生任何影响，也不会产生swagger文档，必须激活swagger profile才会生效

项目启动之后如果没有任何报错，打开文档地址：http://49.234.14.191:8102/doc.html 查看文档上传效果。
