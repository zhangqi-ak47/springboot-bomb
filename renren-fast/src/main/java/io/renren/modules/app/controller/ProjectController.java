package io.renren.modules.app.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.datasource.annotation.DataSource;
import io.renren.modules.app.entity.ProjectEntity;
import io.renren.modules.app.service.ProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-17 14:27:43
 */
@RestController
@RequestMapping("app/project")
@DataSource("slave2")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:project:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = projectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:project:info")//进行了权限查询操作
    public R info(@PathVariable("id") Integer id){
		ProjectEntity project = projectService.getById(id);

        return R.ok().put("project", project);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:project:save")
    public R save(@RequestBody ProjectEntity project){
		projectService.save(project);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:project:update")
    public R update(@RequestBody ProjectEntity project){
		projectService.updateById(project);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:project:delete")
    public R delete(@RequestBody Integer[] ids){
		projectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
