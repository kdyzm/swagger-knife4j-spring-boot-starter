package com.kdyzm.swagger.test.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kdyzm
 * @date 2021/10/15
 */
@Data
@ApiModel("系统响应体")
public class WrapperResult<T> {

    @ApiModelProperty(required = false, value = "响应体",example = "")
    private T data;

    @ApiModelProperty(required = false, value = "响应描述",example = "OK")
    private String msg;

    @ApiModelProperty(required = false, value = "响应码,200:成功，500：失败",example = "200")
    private Integer code;

}
