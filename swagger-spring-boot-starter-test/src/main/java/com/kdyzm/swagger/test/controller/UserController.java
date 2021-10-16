package com.kdyzm.swagger.test.controller;

import com.kdyzm.swagger.test.model.WrapperResult;
import com.kdyzm.swagger.test.model.user.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author kdyzm
 * @date 2021/10/15
 */
@Slf4j
@Api(tags = "用户接口相关")
@RestController
@RequestMapping("/user")
public class UserController {


    @ApiOperation("多条件查询用户列表：POST请求")
    @PostMapping("/list-by-condition-post")
    public WrapperResult<List<UserModel>> listByCondtion(@RequestBody UserModel req) {
        return null;
    }

    @ApiOperation("多条件查询用户列表：GET请求")
    @GetMapping("/list-by-condition-get")
    public WrapperResult<List<UserModel>> listByCondition1(@ModelAttribute UserModel userModel) {
        return null;
    }

    @ApiOperation("更新用户信息")
    @PutMapping
    public WrapperResult<UserModel> updateUser(@RequestBody UserModel userModel) {
        return null;
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping
    public WrapperResult<UserModel> removeUser(@RequestParam("userId") String userId) {
        return null;
    }


    @ApiOperation("上传用户头像")
    @PostMapping("/upload-head-photo")
    public WrapperResult<UserModel> uploadHeadPhoto(@RequestParam("file") MultipartFile file) {
        return null;
    }


}
