package com.kdyzm.swagger.spring.mvc.config;

import com.kdyzm.swagger.spring.mvc.properties.SwaggerApiInfo;
import com.kdyzm.swagger.spring.mvc.properties.SwaggerConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author kdyzm
 * @date 2021/7/6
 */
@EnableSwagger2
@Configuration
@Slf4j
public class SwaggerConfiguration {

    @Bean
    public Docket userPath(SwaggerConfigProperties swaggerConfigProperties) {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName(swaggerConfigProperties.getGroup().getName())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerConfigProperties.getBasePackage()))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo(swaggerConfigProperties.getApi(), swaggerConfigProperties));
        return docket;
    }

    private ApiInfo apiInfo(SwaggerApiInfo apiInfo, SwaggerConfigProperties swaggerConfigProperties) {
        return new ApiInfoBuilder()
                .title(apiInfo.getTitle())
                .description(swaggerConfigProperties.getDescription())
                .termsOfServiceUrl(apiInfo.getTermsOfServiceUrl())
                .contact(new Contact(apiInfo.getContactName(), "", ""))
                .version(apiInfo.getVersion())
                .build();
    }
}
