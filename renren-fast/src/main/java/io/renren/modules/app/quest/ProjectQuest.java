package io.renren.modules.app.quest;

import io.renren.common.utils.PageUtils;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "业务分页表单")
public class ProjectQuest extends PageUtils {

    public int type;

}
