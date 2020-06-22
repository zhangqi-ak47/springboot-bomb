package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.datasource.annotation.DataSource;
import io.renren.modules.app.entity.ProjectEntity;
import io.renren.modules.app.entity.ProjectOwnerVo;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-17 14:27:43
 */
public interface ProjectService extends IService<ProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<Map<String, Object>> queryPageRelevance(PageUtils pageUtils);

    List<ProjectOwnerVo> queryPageRelevanceVO(PageUtils pageUtils);
}

