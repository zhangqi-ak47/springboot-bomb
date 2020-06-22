package io.renren.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.OwnerEntity;
import io.renren.modules.app.service.OwnerService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-17 14:27:43
 */
@RestController
@RequestMapping("app/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:owner:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ownerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:owner:info")
    public R info(@PathVariable("id") Integer id){
		OwnerEntity owner = ownerService.getById(id);

        return R.ok().put("owner", owner);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:owner:save")
    public R save(@RequestBody OwnerEntity owner){
		ownerService.save(owner);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:owner:update")
    public R update(@RequestBody OwnerEntity owner){
		ownerService.updateById(owner);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:owner:delete")
    public R delete(@RequestBody Integer[] ids){
		ownerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
