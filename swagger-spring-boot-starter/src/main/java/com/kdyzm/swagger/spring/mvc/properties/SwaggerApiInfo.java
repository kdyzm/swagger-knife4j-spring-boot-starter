package com.kdyzm.swagger.spring.mvc.properties;

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
public class SwaggerApiInfo {

    @NotEmpty
    @Getter
    private String title;

    @Getter
    private String description;

    private String version;

    @NotEmpty
    @Getter
    private String termsOfServiceUrl;
    private String contactName;
    private String license;
    private String licenseUrl;

    public String getVersion() {
        if (StringUtils.isEmpty(this.version)) {
            return "2.0";
        }
        return version;
    }

    public String getContactName() {
        if (StringUtils.isEmpty(this.contactName)) {
            return "xxx@qq.com";
        }
        return contactName;
    }

    public String getLicense() {
        if (StringUtils.isEmpty(this.license)) {
            return "";
        }
        return license;
    }

    public String getLicenseUrl() {
        if (StringUtils.isEmpty(this.licenseUrl)) {
            return "";
        }
        return licenseUrl;
    }
}
