package com.kdyzm.swagger.register.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author kdyzm
 * @date 2021/7/1
 */
@Configuration
@EnableSwagger2
public class Knife4jConfiguration {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("swagger注册中心api接口文档标题")
                        .description("swagger注册中心api接口文档")
                        .termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("一枝梅", "https://blog.kdyzm.cn", "kdyzm@foxmail.com"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("swagger注册中心")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.kdyzm.swagger.register.server.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
