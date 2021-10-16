package com.kdyzm.swagger.spring.mvc;

import io.swagger.models.Swagger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author kdyzm
 * @date 2021/7/6
 */
@Component
@Slf4j
public class SwaggerReporter implements ApplicationListener<ContextRefreshedEvent>, ApplicationContextAware {

    private final SwaggerMvcGenerator swaggerGenerator;

    private final SwaggerRegistryService swaggerRegistryService;

    private ApplicationContext applicationContext;

    public SwaggerReporter(SwaggerMvcGenerator swaggerGenerator, SwaggerRegistryService swaggerRegistryService) {
        this.swaggerGenerator = swaggerGenerator;
        this.swaggerRegistryService = swaggerRegistryService;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext() == this.applicationContext) {
            this.handleSwagger();
        }
    }

    /**
     * 生成和上传swagger信息
     */
    private void handleSwagger() {
        Swagger swagger = null;
        try {
            swagger = this.swaggerGenerator.getSwagger();
        } catch (Exception var3) {
            log.error("get swagger error", var3);
        }
        if (swagger != null) {
            ListenableFuture<Integer> future = this.swaggerRegistryService.register(swagger);
            future.addCallback((count) -> {
                log.info(count + " swaggerserver has bean registered");
            }, (ex) -> {
                log.info("swagger exception occured", ex);
            });
        }

    }
}
