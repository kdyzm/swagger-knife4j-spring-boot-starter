package com.kdyzm.swagger.spring.mvc.properties;

import com.kdyzm.swagger.spring.mvc.utils.IpUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author kdyzm
 * @date 2021/7/6
 */
@Data
@ConfigurationProperties(prefix = "swagger.config")
public class SwaggerConfigProperties {

    @Value("${server.port}")
    private transient String serverPort;
    /**
     * 应当通过代码获取当前服务的ip地址和端口号
     */
    private String host;

    private String basePath;

    private String basePackage;

    private String description;

    /**
     * 服务端ip地址
     */
    private String serverUrl;

    private SwaggerGroupInfo group;

    private SwaggerApiInfo api;

    public String getHost() {
        String hostIP = IpUtils.getHostIP();
        return hostIP + ":" + serverPort;
    }

    public String getBasePath() {
        if (StringUtils.isEmpty(this.basePath)) {
            return "/";
        }
        return this.basePath;
    }
}
