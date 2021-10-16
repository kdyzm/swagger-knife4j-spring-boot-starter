package com.kdyzm.swagger.register.server.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kdyzm.swagger.register.server.mapper.IGroupInfoMapper;
import com.kdyzm.swagger.register.server.entity.GroupInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kdyzm
 * @date 2021/7/5
 */
@Component
@Primary
@AllArgsConstructor
@Slf4j
public class DocumentationConfig implements SwaggerResourcesProvider {

    private IGroupInfoMapper groupInfoMapper;

    @Override
    public List<SwaggerResource> get() {
        List<GroupInfo> groupInfos = groupInfoMapper.selectList(new LambdaQueryWrapper<>());
        if (CollectionUtils.isEmpty(groupInfos)) {
            return new ArrayList<>();
        }
        return groupInfos.stream().map(item ->
                swaggerResource(item.getName(), item.getLocation(), item.getVersion())).collect(Collectors.toList()
        );
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        swaggerResource.setUrl(location);
        return swaggerResource;
    }
}
