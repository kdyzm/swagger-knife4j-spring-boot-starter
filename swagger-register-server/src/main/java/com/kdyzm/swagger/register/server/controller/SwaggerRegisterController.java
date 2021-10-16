package com.kdyzm.swagger.register.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kdyzm.swagger.register.server.controller.models.RegisterInfo;
import com.kdyzm.swagger.register.server.entity.GroupInfo;
import com.kdyzm.swagger.register.server.entity.SwaggerJson;
import com.kdyzm.swagger.register.server.mapper.IGroupInfoMapper;
import com.kdyzm.swagger.register.server.mapper.ISwaggerJsonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author kdyzm
 * @date 2021/7/5
 */
@RestController
@RequestMapping("/swagger")
@Slf4j
@AllArgsConstructor
@Api(tags = {"swagger注册中心接口集合"})
public class SwaggerRegisterController {

    private ISwaggerJsonMapper swaggerJsonMapper;

    private IGroupInfoMapper groupInfoMapper;

    @ApiOperation("swagger注册接口")
    @PostMapping("/regist")
    @ResponseBody
    public Boolean regist(@RequestBody RegisterInfo registerInfo) {
        log.info("receive swagger register info from server ={} , groupName={}", registerInfo.getGroupInfo().getAppName(), registerInfo.getGroupInfo().getName());
        GroupInfo groupInfo = registerInfo.getGroupInfo();
        SwaggerJson swaggerJson = registerInfo.getSwaggerJson();
        String appName = groupInfo.getAppName();
        String name = groupInfo.getName();
        GroupInfo groupInfo1 = groupInfoMapper.selectOne(new LambdaQueryWrapper<GroupInfo>().eq(GroupInfo::getAppName, appName));
        SwaggerJson swaggerJson1 = swaggerJsonMapper.selectOne(new LambdaQueryWrapper<SwaggerJson>().eq(SwaggerJson::getGroupName, name));
        if (Objects.isNull(groupInfo1)) {
            groupInfoMapper.insert(groupInfo);
        } else {
            groupInfo.setId(groupInfo1.getId());
            groupInfoMapper.updateById(groupInfo);
        }
        if (Objects.isNull(swaggerJson1)) {
            swaggerJsonMapper.insert(swaggerJson);
        } else {
            swaggerJson.setId(swaggerJson1.getId());
            swaggerJsonMapper.updateById(swaggerJson);
        }
        return true;
    }

    @ApiOperation(value = "获取swagger注册详情接口",notes = "Knife4j根据此接口获取接口列表详情并渲染")
    @GetMapping("/detail")
    @ResponseBody
    public String getSwaggerDetail(@RequestParam("groupName") String groupName) {
        SwaggerJson swaggerJson = swaggerJsonMapper.selectOne(
                new LambdaQueryWrapper<SwaggerJson>().eq(SwaggerJson::getGroupName, groupName)
        );
        return swaggerJson.getContent();
    }

}
