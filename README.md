# swagger-knife4j-spring-boot-starter

## 一、项目模块和公益服务
本项目分为三个子模块项目：

|模块|功能|
|---|---|
|swagger-register-server|swagger注册中心，预览地址：http://swagger.kdyzm.cn/doc.html (受限于服务器和带宽资源，访问速度会比较慢)|
|swagger-spring-boot-starter|使用springboot项目的客户端swagger插件，该插件会手机客户端swagger信息并上传到swagger注册中心|
|swagger-spring-boot-starter-test|使用案例|

为了帮助项目能快速启动和测试和预览，提供了三个在线公益服务

| 服务名字            | 域名             | 访问地址                                              |
| ------------------- | ---------------- | ----------------------------------------------------- |
| nacos地址           | nacos.kdyzm.cn   | http://nacos.kdyzm.cn/nacos (不提供管理端账号密码)    |
| eureka地址          | eureka.kdyzm.cn  | http://eureka.kdyzm.cn （无需账号密码访问）           |
| swagger注册中心地址 | swagger.kdyzm.cn | http://swagger.kdyzm.cn/doc.html （无需账号密码访问） |

mysql数据库服务需要自己搭建

## 二、项目启动和测试

### 1、启动swagger-register-server

该项目启动需要连接mysql数据库以及nacos。

- nacos我搭建了一个在线版本，可以直接使用（这里不提供管理端的账号密码），nacos在线地址：nacos.kdyzm.cn
- mysql需要自己创建数据库，运行脚本 https://gitee.com/kdyzm/swagger-register-server/blob/master/sql/init.sql 创建相关的数据库和表结构以及初始化部分数据。

准备好外部依赖之后，启动项目即可，启动成功之后，访问项目的/doc.html，即可看到knife4j的文档页面。

这里我提供了线上部署好的版本：http://swagger.kdyzm.cn ，如果不想本地启动测试，可以直接使用线上版本的。

### 2、编译打包swagger-spring-boot-starter

上一步启动好了swagger-register-server，接下来需要打包swagger-spring-boot-starter已提供微服务客户端使用。

因为这里并没有上传maven中央仓库，所以有条件的可以上传nexus私服，没条件的可以直接运行命令`mvn clean install`将jar包安装到本地maven仓库以便使用。

### 3、创建测试项目

可以使用intelij自带的工具初始化一个spring boot的项目，这里使用了2.3.4.REALEASE版本的springboot版本号（经过测试发现，nacos版本号过高会导致服务发现功能故障，版本号低一些程序功能会更稳定）。

利用intilij自带的spring initiallizer工具可以很方便的快速搭建起来web开发框架。写完Controller接口之后，开始整合swagger-spring-boot-starter，测试项目地址源代码：https://gitee.com/kdyzm/swagger-spring-boot-starter-test

#### 第一步：引入依赖

``` xml
<!-- swagger功能组件 -->
<dependency>
    <groupId>com.kdyzm</groupId>
    <artifactId>swagger-spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

#### 第二步：配置swagger信息

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
    #swagger注册中心地址，若无此配置项，会自动使用服务发现功能查找swagger-register-server的ip地址和端口号
    server-url: http://swagger.kdyzm.cn
```

#### 第三步：激活swagger profile

只是做了前两步，不会对项目产生任何影响，也不会产生swagger文档，必须激活swagger profile才会生效

项目启动之后如果没有任何报错，打开文档地址：http://swagger.kdyzm.cn/doc.html 查看文档上传效果。


具体细节可参考 swagger-spring-boot-starter-test 使用案例。