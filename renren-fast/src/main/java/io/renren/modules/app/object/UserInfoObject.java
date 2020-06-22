package io.renren.modules.app.object;

import io.renren.modules.app.entity.UserEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoObject extends UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String token;
    private long expire;

}
