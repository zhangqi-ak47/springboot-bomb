package io.renren.modules.app.dao;

import io.renren.common.utils.PageUtils;
import io.renren.datasource.annotation.DataSource;
import io.renren.modules.app.entity.ProjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.app.entity.ProjectOwnerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-17 14:27:43
 */
@Mapper
public interface ProjectDao extends BaseMapper<ProjectEntity> {

    @Select("SELECT project.*,owner.*, owner.name as oName, owner.id as oId FROM project,owner WHERE project.owner_id=owner.id LIMIT #{startPage}, #{pageSize}")
    List<Map<String, Object>> queryPageRelevance(PageUtils pageUtils);

    @Select("SELECT project.*,owner.*, owner.name as oName, owner.id as oId FROM project,owner WHERE project.owner_id=owner.id LIMIT #{startPage}, #{pageSize}")
    List<ProjectOwnerVo> queryPageRelevanceVO(PageUtils pageUtils);
}
