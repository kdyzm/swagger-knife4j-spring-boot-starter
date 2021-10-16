package com.kdyzm.swagger.spring.mvc;

import com.kdyzm.swagger.spring.mvc.properties.SwaggerConfigProperties;
import io.swagger.models.Swagger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import springfox.documentation.service.Documentation;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;
import springfox.documentation.swagger2.web.Swagger2Controller;
//import springfox.documentation.swagger2.web.Swagger2ControllerWebMvc;

/**
 * @author kdyzm
 * @date 2021/7/6
 */
@Component
@Slf4j
@AllArgsConstructor
public class SwaggerMvcGenerator {

    private final ServiceModelToSwagger2Mapper mapper;

    private final DocumentationCache documentationCache;

    private final SwaggerConfigProperties swaggerConfigProperties;

    /**
     * 这里仿写swagger-ui获取swagger信息的方式
     *
     * @see Swagger2ControllerWebMvc#getDocumentation(java.lang.String, javax.servlet.http.HttpServletRequest)
     * @see Swagger2Controller#getDocumentation(java.lang.String, javax.servlet.http.HttpServletRequest)
     */
    public Swagger getSwagger() {
        Swagger swagger = null;
        if (this.mapper != null && this.documentationCache != null) {
            Documentation documentation = this.documentationCache.documentationByGroup(swaggerConfigProperties.getGroup().getName());
            if (documentation != null) {
                swagger = this.mapper.mapDocumentation(documentation);
                swagger.setHost(swaggerConfigProperties.getHost());
                swagger.setBasePath(swaggerConfigProperties.getBasePath());
                swagger.getInfo().setTermsOfService("http://" + swaggerConfigProperties.getHost());
            }
        }
        return swagger;
    }
}
