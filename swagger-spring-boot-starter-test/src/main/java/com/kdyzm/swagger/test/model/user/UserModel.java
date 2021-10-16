package com.kdyzm.swagger.test.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author kdyzm
 * @date 2021/10/15
 */
@ApiModel("用户Model")
@Data
public class UserModel {

    @ApiModelProperty(value = "姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "年龄", required = true, example = "12")
    private Integer age;

    @ApiModelProperty(value = "教育程度", required = false, example = "大学")
    private String education;

    @ApiModelProperty(value = "联系人信息", required = true)
    private List<UserContact> contacts;
}
