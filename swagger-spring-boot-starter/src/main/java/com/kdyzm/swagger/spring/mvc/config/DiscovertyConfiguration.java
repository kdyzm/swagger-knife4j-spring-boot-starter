package com.kdyzm.swagger.spring.mvc.config;

import org.springframework.cloud.client.ConditionalOnDiscoveryEnabled;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author kdyzm
 * @date 2021/7/6
 */
@Configuration
@ConditionalOnDiscoveryEnabled
public class DiscovertyConfiguration {
    
    @Primary
    @Bean(name = "swagger-rest-template")
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    };
}
