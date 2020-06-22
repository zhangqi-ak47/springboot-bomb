package io.renren.modules.app.service.impl;

import io.renren.datasource.annotation.DataSource;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.OwnerDao;
import io.renren.modules.app.entity.OwnerEntity;
import io.renren.modules.app.service.OwnerService;


@Service("ownerService")
@DataSource("slave2")
public class OwnerServiceImpl extends ServiceImpl<OwnerDao, OwnerEntity> implements OwnerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OwnerEntity> page = this.page(
                new Query<OwnerEntity>().getPage(params),
                new QueryWrapper<OwnerEntity>()
        );

        return new PageUtils(page);
    }

}