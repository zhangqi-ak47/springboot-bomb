package io.renren.modules.app.service.impl;

import io.renren.datasource.annotation.DataSource;
import io.renren.modules.app.entity.ProjectOwnerVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ProjectDao;
import io.renren.modules.app.entity.ProjectEntity;
import io.renren.modules.app.service.ProjectService;


@Service("projectService")
@DataSource("slave2")
public class ProjectServiceImpl extends ServiceImpl<ProjectDao, ProjectEntity> implements ProjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        int type= 0;
        Object oType=params.get("type");
        if (oType!=null){
            type= (int) oType;
        }

        IPage<ProjectEntity> page = this.page(
                new Query<ProjectEntity>().getPage(params),
                new QueryWrapper<ProjectEntity>()
                .eq(type>0, "team", true)
                .like(type>0, "name", "mi")
                .ge(type>0, "id", 4)
                .le(type>0, "id", 10)
                .between(type>0, "group_id", 7, 9)
        );

        return new PageUtils(page);
    }

    @Override
    public List<Map<String, Object>> queryPageRelevance(PageUtils pageUtils) {
        return getBaseMapper().queryPageRelevance(pageUtils);
    }

    @Override
    public List<ProjectOwnerVo> queryPageRelevanceVO(PageUtils pageUtils) {
        return getBaseMapper().queryPageRelevanceVO(pageUtils);
    }


}