package io.renren.modules.app.controller;

import com.alibaba.fastjson.JSON;
import io.renren.common.utils.*;
import io.renren.modules.app.annotation.Login;
import io.renren.modules.app.entity.ProjectOwnerVo;
import io.renren.modules.app.object.DynamicObject.Owner;
import io.renren.modules.app.object.ProjectObject;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.quest.ProjectQuest;
import io.renren.modules.app.service.OwnerService;
import io.renren.modules.app.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * APP业务逻辑接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/app/business")
@Api("APP业务逻辑接口")
public class AppBusinessController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    ProjectService projectService;
    @Autowired
    OwnerService ownerService;

    @Login
    @PostMapping("project")
    @ApiOperation("获取业务数据")
    public R projectData(@RequestBody ProjectQuest form){
        /*Map<String, Object> mapForm=new HashMap<>();
        mapForm.put("page", form.getCurrPage()+"");
        mapForm.put("limit", form.getPageSize()+"");
        mapForm.put("id", form.getType());*/

//        PageUtils pageUtils2=projectService.queryPage(new MapUtils().queryPage(form));

        Map<String, Object> mapForm=new MapUtils().queryPage(form);
        mapForm.put("type", form.getType());
        PageUtils pageUtils2=projectService.queryPage(mapForm);
        logger.debug(" list-page:"+JSON.toJSONString(pageUtils2));


//        PageUtils pageUtils=projectService.queryPage(new MapUtils().queryPage(form));

        List<Map<String, Object>> lm=projectService.queryPageRelevance(form);
        /*for (Map map:lm){
            Iterator entries = map.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                String key = (String)entry.getKey();
//                String value = (String)entry.getValue();
                System.out.println("Key = " + key + ", Value = " + entry.getValue());
            }
        }*/

        logger.debug(lm.size()+" list-map:"+JSON.toJSONString(lm));
//        logger.debug(lm.size()+" list-map2:"+JSON.toJSONString(pageUtils));

//        pageUtils.setCurrPage(2);
//        pageUtils.setPageSize(3);
        List<ProjectOwnerVo> lBean=projectService.queryPageRelevanceVO(form);
        form.setList(lBean);

        logger.debug("list-bean:"+lBean.toString());
        logger.debug("list-bean2:"+JSON.toJSONString(lBean));
        logger.debug("list-bean3:"+JSON.toJSONString(form));

        UserEntity userEntity=redisUtils.get(HttpContextUtils.getUserId() +"", UserEntity.class);
//        logger.debug(userEntity.toString());

        return R.ok().put("data", form);

        /*ProjectObject object=new ProjectObject();
        object.setGroupId(0);
        object.setPlan(0);
        object.setTeam(false);
        object.setMaxMember(0);
        object.setRecommended(0);
        object.setBackend_project_path("");
        object.setName("");
        object.setOwner_id(0);
        object.setOwnerUserHome("");
        object.setOwner_user_name("");
        object.setOwner_user_picture("");
        object.setProject_path("");
        object.setSsh_url("");
        object.setCurrent_user_role("");
        object.setCurrent_user_role_id(0);
        object.setDepot_path("");
        object.setDescription("");
        object.setGit_url("");
        object.setHttps_url("");
        object.setIcon("");
        object.setFork_count(0);
        object.setForked(false);
        object.setCreated_at(0L);
        object.setStar_count(0);
        object.setStared(false);
        object.setStatus(0);
        object.setUnReadActivitiesCount(0);
        object.setUpdateAt(0L);
        object.setWatch_count(0);
        object.setWatched(false);
        object.setPublic(false);
        object.setMemberNum(0);
        object.setId(0);
        object.setPin(false);
        object.setType(0);
        object.setShared(false);
        object.setFork_path("");

        Owner owner=new Owner();
        owner.setAvatar("");
        owner.setGlobal_key("");
        owner.setName("");
        owner.setPath("");

        object.setOwner(owner);

        List<ProjectObject> listData=new ArrayList<>();
        listData.add(object);
        listData.add(object);
        listData.add(object);

        return R.ok().put("data", new PageUtils(listData, 10, form.getPageSize(), form.getCurrPage()));*/
    }


}
