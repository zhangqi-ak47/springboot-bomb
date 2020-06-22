/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.app.controller;


import io.renren.common.utils.R;
import io.renren.common.utils.RedisUtils;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.object.UserInfoObject;
import io.renren.modules.app.form.LoginForm;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * APP登录授权-账户接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/app/account")
@Api("APP登录接口")
public class AppLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 登录
     */
    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录 在service里面做了校验了
        UserEntity userEntity = userService.login(form);

        //生成token
        String token = jwtUtils.generateToken(userEntity.getUserId());

        UserInfoObject userInfoObject =new UserInfoObject();
        userInfoObject.setToken(token);
        userInfoObject.setExpire(jwtUtils.getExpire());
        userInfoObject.setUserId(userEntity.getUserId());
        userInfoObject.setUsername(userEntity.getUsername());
        userInfoObject.setMobile(userEntity.getMobile());
        userInfoObject.setPassword(userEntity.getPassword());
        userInfoObject.setCreateTime(userEntity.getCreateTime());

        //用userid缓存 用户信息
        redisUtils.set(userEntity.getUserId()+"_app", userInfoObject);

        return R.ok().put("data", userInfoObject);

//        Map<String, Object> map = new HashMap<>();
//        map.put("token", token);
//        map.put("expire", jwtUtils.getExpire());
//
//        return R.ok(map);
    }

}
