package io.renren.modules.app.entity;

import lombok.Data;

@Data
public class ProjectOwnerVo extends ProjectEntity {

    private Integer oId;
    /**
     *
     */
    private String avatar;
    /**
     *
     */
    private String globalKey;
    /**
     *
     */
    private String oName;
    /**
     *
     */
    private String path;

}
