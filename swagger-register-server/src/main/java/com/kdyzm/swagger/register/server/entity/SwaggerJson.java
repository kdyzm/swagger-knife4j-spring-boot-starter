package com.kdyzm.swagger.register.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


/**
 * 【请填写功能名称】对象 swagger_json
 *
 * @author kdyzm
 * @date 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("swagger_json")
@ApiModel(value = "SwaggerJson对象", description = "【请填写功能名称】表")
public class SwaggerJson implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ApiModelProperty(value = "Id", required = false, example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    @NotEmpty
    @ApiModelProperty(value = "", required = true)
    @TableField("group_name")
    private String groupName;

    /**
     * swagger具体信息
     */
    @NotEmpty
    @ApiModelProperty(value = "swagger具体信息")
    @TableField("content")
    private String content;

}