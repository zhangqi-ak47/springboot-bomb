package io.renren.modules.app.dao;

import io.renren.datasource.annotation.DataSource;
import io.renren.modules.app.entity.OwnerEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-17 14:27:43
 */
@Mapper
public interface OwnerDao extends BaseMapper<OwnerEntity> {
	
}
