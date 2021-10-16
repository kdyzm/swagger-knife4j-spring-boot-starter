package com.kdyzm.swagger.spring.mvc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kdyzm
 * @date 2021/7/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwaggerJson {

    private String groupName;
    private String content;
}
