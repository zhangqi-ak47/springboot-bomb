/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.app.controller;


import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.form.RegisterForm;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.utils.EmailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * 注册-操作接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/app/operation")
@Api("APP注册接口")
public class AppRegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailUtils emailUtils;

    @PostMapping("register")
    @ApiOperation("注册")
    @Transactional//事务注解
    public R register(@RequestBody RegisterForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        UserEntity user = new UserEntity();
        user.setMobile(form.getMobile());
        user.setUsername(form.getUsername());
        user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        user.setCreateTime(new Date());
        userService.save(user);

        try {
            emailUtils.sendEmail(form.getMobile(), "账户注册", "注册网址URL：www.baidu.com");
            return R.ok();
        }catch (Exception e){
            e.printStackTrace();
            //事务回滚操作
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.error(1, "邮件发送失败");
        }
    }

    @GetMapping("forget")
    @ApiOperation("忘记密码")
    public R forget(@RequestParam Map<String, Object> params){
        //表单校验
        ValidatorUtils.validateMap(params, "mobile");

        UserEntity userEntity=userService.queryByMobile(params.get("mobile").toString());
        if (userEntity==null){
            return R.error(1, "账户不存在");
        }
        try {
            emailUtils.sendEmail(params.get("mobile").toString(), "账户注册", "注册网址URL：www.baidu.com");
            return R.ok();
        }catch (Exception e){
            e.printStackTrace();
            return R.error(1, "邮件发送失败");
        }

    }


}
