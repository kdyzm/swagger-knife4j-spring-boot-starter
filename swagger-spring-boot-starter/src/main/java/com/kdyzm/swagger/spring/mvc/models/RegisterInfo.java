package com.kdyzm.swagger.spring.mvc.models;

import com.kdyzm.swagger.spring.mvc.properties.SwaggerGroupInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kdyzm
 * @date 2021/7/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterInfo {

    private SwaggerJson swaggerJson;

    private SwaggerGroupInfo groupInfo;
}
