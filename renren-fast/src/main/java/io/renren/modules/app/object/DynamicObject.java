package io.renren.modules.app.object;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by cc191954 on 14-8-9.
 * 动态的各种类型都在这里
 */
public class DynamicObject {

    @Data
    public static class Owner implements Serializable {
        public String avatar = "";
        public String global_key = "";
        public String name = "";
        public String path = "";
    }

}


