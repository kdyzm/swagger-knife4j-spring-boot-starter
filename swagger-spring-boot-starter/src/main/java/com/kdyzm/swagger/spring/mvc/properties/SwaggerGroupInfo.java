package com.kdyzm.swagger.spring.mvc.properties;

import com.kdyzm.swagger.spring.mvc.constants.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @author kdyzm
 * @date 2021/7/6
 */
@Setter
@Validated
public class SwaggerGroupInfo {

    @NotEmpty
    @Getter
    private String name;

    private String location;

    private String version;

    private String url;

    /**
     * 不需要配置，可以根据spring.aplication.name获取
     */
    @Getter
    private String appName;

    /**
     * 如果有，需要配置，保留字段
     */
    private String gateway;

    public String getLocation() {
        if (!StringUtils.isEmpty(this.location)) {
            return this.location;
        }
        return this.getUrl();
    }

    public String getVersion() {
        if (StringUtils.isEmpty(this.version)) {
            return "2.0";
        }
        return version;
    }

    public String getUrl() {
        if (!StringUtils.isEmpty(this.url)) {
            return this.url;
        }
        return Constants.SWAGGER_REGISTER_CENTER_DETAIL_PATH + name;
    }

    public String getGateway() {
        return gateway;
    }
}
