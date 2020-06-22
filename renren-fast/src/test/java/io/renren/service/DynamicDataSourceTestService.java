/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.service;

import io.renren.datasource.annotation.DataSource;
import io.renren.modules.app.dao.OwnerDao;
import io.renren.modules.app.entity.OwnerEntity;
import io.renren.modules.sys.dao.SysUserDao;
import io.renren.modules.sys.entity.SysUserEntity;
import lombok.extern.flogger.Flogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试多数据源
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
//@DataSource("slave1")
public class DynamicDataSourceTestService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private OwnerDao ownerDao;

    @Transactional
    public void updateUser(Long id){
        SysUserEntity user = new SysUserEntity();
        user.setUserId(id);
        user.setMobile("13500000000");
        sysUserDao.updateById(user);
    }

    @Transactional
    @DataSource("slave1")
    public void updateUserBySlave1(Long id){
        SysUserEntity user = new SysUserEntity();
        user.setUserId(id);
        user.setMobile("13500000001");
        sysUserDao.updateById(user);
    }

    @DataSource("slave2")
    @Transactional
    public void updateUserBySlave2(Long id){
        SysUserEntity user = new SysUserEntity();
        user.setUserId(id);
        user.setMobile("13500000002");
        sysUserDao.updateById(user);

        //测试事物
        int i = 1/0;
    }

    @DataSource("slave2")
    @Transactional
    public void testDatabase2(Long id){
        OwnerEntity entity=ownerDao.selectById(id);
        logger.debug("testDatabase->OwnerEntity：" + entity.toString());
}

    @DataSource("slave1")
    @Transactional
    public void testDatabase1(Long id){
        SysUserEntity entity=sysUserDao.selectById(id);
        logger.debug("testDatabase->SysUserEntity：" + entity.toString());
    }
}