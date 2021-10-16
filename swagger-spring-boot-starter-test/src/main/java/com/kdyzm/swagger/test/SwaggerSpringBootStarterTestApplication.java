package com.kdyzm.swagger.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author kdyzm
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SwaggerSpringBootStarterTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerSpringBootStarterTestApplication.class, args);
    }

}
