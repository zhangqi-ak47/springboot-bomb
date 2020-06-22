package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-17 14:27:43
 */
@Data
@TableName("project")
public class ProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer groupId;
	/**
	 * 
	 */
	private Integer plan;
	/**
	 * 
	 */
	private Boolean team;
	/**
	 * 
	 */
	private Integer maxMember;
	/**
	 * 
	 */
	private Integer recommended;
	/**
	 * 
	 */
	private String backendProjectPath;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Integer ownerId;
	/**
	 * 
	 */
	private String ownerUserHome;
	/**
	 * 
	 */
	private String ownerUserName;
	/**
	 * 
	 */
	private String ownerUserPicture;
	/**
	 * 
	 */
	private String projectPath;
	/**
	 * 
	 */
	private String sshUrl;
	/**
	 * 
	 */
	private String currentUserRole;
	/**
	 * 
	 */
	private Integer currentUserRoleId;
	/**
	 * 
	 */
	private String depotPath;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private String gitUrl;
	/**
	 * 
	 */
	private String httpsUrl;
	/**
	 * 
	 */
	private String icon;
	/**
	 * 
	 */
	private Integer forkCount;
	/**
	 * 
	 */
	private Boolean forked;
	/**
	 * 
	 */
	private Integer createdAt;
	/**
	 * 
	 */
	private Integer starCount;
	/**
	 * 
	 */
	private Boolean stared;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 
	 */
	private Integer unReadActivitiesCount;
	/**
	 * 
	 */
	private Integer updateAt;
	/**
	 * 
	 */
	private Integer watchCount;
	/**
	 * 
	 */
	private Boolean watched;
	/**
	 * 
	 */
	private Boolean isPublic;
	/**
	 * 
	 */
	private Integer memberNum;
	/**
	 * 
	 */
	private Boolean pin;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private Boolean shared;
	/**
	 * 
	 */
	private String forkPath;

}
