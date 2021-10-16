package com.kdyzm.swagger.register.server.controller.models;

import com.kdyzm.swagger.register.server.entity.GroupInfo;
import com.kdyzm.swagger.register.server.entity.SwaggerJson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kdyzm
 * @date 2021/7/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("swagger注册请求体")
public class RegisterInfo {

    @ApiModelProperty("swagger注册详情")
    private SwaggerJson swaggerJson;

    @ApiModelProperty("swagger注册group信息")
    private GroupInfo groupInfo;
}
