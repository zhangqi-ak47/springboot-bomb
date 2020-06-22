package io.renren.modules.sys.object;

import io.renren.modules.sys.entity.SysUserEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserObject extends SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String token;
    private long expire;

}
