package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.datasource.annotation.DataSource;
import io.renren.modules.app.entity.OwnerEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-17 14:27:43
 */
public interface OwnerService extends IService<OwnerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

