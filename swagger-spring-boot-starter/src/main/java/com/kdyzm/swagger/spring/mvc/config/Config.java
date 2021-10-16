package com.kdyzm.swagger.spring.mvc.config;

import com.kdyzm.swagger.spring.mvc.properties.SwaggerConfigProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * @author kdyzm
 * @date 2021/7/6
 */
@Configuration
@EnableConfigurationProperties({SwaggerConfigProperties.class})
@Import({SwaggerConfiguration.class, DiscovertyConfiguration.class})
@ComponentScan("com.kdyzm.swagger.spring.mvc")
@Profile("swagger")
public class Config {

}
