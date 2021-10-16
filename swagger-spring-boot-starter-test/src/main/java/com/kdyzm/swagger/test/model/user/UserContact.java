package com.kdyzm.swagger.test.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kdyzm
 * @date 2021/10/15
 */
@Data
@ApiModel("用户联系人")
public class UserContact {

    @ApiModelProperty(value = "手机号", required = true, example = "135858476654")
    private String mobile;

    @ApiModelProperty(value = "联系人姓名", required = true, example = "李四")
    private String name;

    @ApiModelProperty(value = "联系人类型", example = "朋友")
    private String relation;
}
