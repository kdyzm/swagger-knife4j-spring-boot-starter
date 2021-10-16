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
* 【请填写功能名称】对象 group_info
*
* @author kdyzm
* @date 2021-07-05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("group_info")
@ApiModel(value = "GroupInfo对象", description = "【请填写功能名称】表")
public class GroupInfo implements Serializable{
    private static final long serialVersionUID=1L;

    /** 自增主键 */
    @ApiModelProperty(value = "自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** groupName */
    @NotEmpty
    @ApiModelProperty(value = "groupName")
    @TableField("name")
    private String name;

    /** location */
    @NotEmpty
    @ApiModelProperty(value = "location")
    @TableField("location")
    private String location;

    /** version */
    @NotEmpty
    @ApiModelProperty(value = "version")
    @TableField("version")
    private String version;

    /** url */
    @NotEmpty
    @ApiModelProperty(value = "url")
    @TableField("url")
    private String url;

    /** 服务名（spring.application.name） */
    @ApiModelProperty(value = "服务名（spring.application.name）")
    @TableField("app_name")
    private String appName;

    /** 网关，无则不填 */
    @ApiModelProperty(value = "网关，无则不填")
    @TableField("gateway")
    private String gateway;

}