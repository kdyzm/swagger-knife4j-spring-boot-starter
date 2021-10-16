package com.kdyzm.swagger.spring.mvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdyzm.swagger.spring.mvc.models.RegisterInfo;
import com.kdyzm.swagger.spring.mvc.models.SwaggerJson;
import com.kdyzm.swagger.spring.mvc.properties.SwaggerConfigProperties;
import io.swagger.models.Swagger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.JsonSerializer;

/**
 * @author kdyzm
 * @date 2021/7/6
 */
@Component
@Slf4j
public class SwaggerRegistryService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final JsonSerializer jsonSerializer;

    private RestTemplate restSwaggerTemplate;

    private final SwaggerConfigProperties swaggerConfigProperties;

    public SwaggerRegistryService(JsonSerializer jsonSerializer,
                                  @Qualifier("swagger-rest-template") RestTemplate restSwaggerTemplate,
                                  SwaggerConfigProperties swaggerConfigProperties) {
        this.jsonSerializer = jsonSerializer;
        this.restSwaggerTemplate = restSwaggerTemplate;
        this.swaggerConfigProperties = swaggerConfigProperties;
    }

    /**
     * 异步注册swagger信息，兼容服务发现模式与普通指定swagger注册中心地址的模式
     *
     * @param swagger
     * @return
     */
    @Async
    public ListenableFuture<Integer> register(Swagger swagger) {
        try {
            log.info("swagger config info={}", objectMapper.writeValueAsString(swaggerConfigProperties));
        } catch (JsonProcessingException e) {
            log.error("", e);
        }
        if (swagger != null) {
            try {
                String url = "";
                //优先使用配置的serverUrl
                if (!StringUtils.isEmpty(swaggerConfigProperties.getServerUrl())) {
                    restSwaggerTemplate = new RestTemplate();
                    url = swaggerConfigProperties.getServerUrl() + "/swagger/regist";
                }
                //退化使用serviceId
                else if (!StringUtils.isEmpty(swaggerConfigProperties.getServiceId())) {
                    url = "http://" + swaggerConfigProperties.getServiceId() + "/swagger/regist";
                } else {
                    log.error("swagger注册中心地址未配置，缺少serverUrl或者serviceId配置，跳过swagger注册");
                    return new AsyncResult<>(1);
                }
                String s = this.jsonSerializer.toJson(swagger).value();
                log.info("start register swagger");
                Boolean result = restSwaggerTemplate.postForObject(
                        url,
                        RegisterInfo.builder()
                                .groupInfo(swaggerConfigProperties.getGroup())
                                .swaggerJson(SwaggerJson.builder().groupName(swaggerConfigProperties.getGroup().getName()).content(s).build())
                                .build(),
                        Boolean.class
                );
                log.info("register swagger info ,result={}", result);
            } catch (Exception e) {
                log.error("register swagger faild", e);
            }
        }
        return new AsyncResult<>(0);
    }
}
