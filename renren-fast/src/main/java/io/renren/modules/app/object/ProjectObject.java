package io.renren.modules.app.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by cc191954 on 14-8-8.
 */

@Data
public class ProjectObject implements Serializable {

    private static final long serialVersionUID = 7015515666165386726L;

    @SerializedName("groupId")
    @Expose
    public int groupId;
    @SerializedName("plan")
    @Expose
    public int plan;
    @SerializedName("isTeam")
    @Expose
    public boolean isTeam;
    @SerializedName("max_member")
    @Expose
    public int maxMember;
    @SerializedName("recommended")
    @Expose
    public int recommended;
    @SerializedName("backend_project_path")
    @Expose
    private String backend_project_path = ""; // "/user/cc/project/hell"
    @SerializedName("name")
    @Expose
    public String name = "";
    @SerializedName("owner_id")
    @Expose
    public int owner_id;
    @SerializedName("owner_user_home")
    @Expose
    public String ownerUserHome = "";
    @SerializedName("owner_user_name")
    @Expose
    public String owner_user_name = "";
    @SerializedName("owner_user_picture")
    @Expose
    public String owner_user_picture = "";
    // 企业版里面去掉了 /u 感觉很多地方都要修改了
    @SerializedName("project_path")
    @Expose
    public String project_path = ""; // "/u/cc/p/hell"
    public String ssh_url = "";
    public String current_user_role = "";
    @SerializedName("current_user_role_id")
    @Expose
    public int current_user_role_id; // 0 表示不是项目成员
    public String depot_path = "";
    @SerializedName("description")
    @Expose
    public String description = "";
    public String git_url = "";
    public String https_url = "";
    @SerializedName("icon")
    @Expose
    public String icon = "";
    @SerializedName("fork_count")
    @Expose
    public int fork_count;
    @SerializedName("forked")
    @Expose
    public boolean forked;
    @SerializedName("created_at")
    @Expose
    public long created_at;
    @SerializedName("star_count")
    @Expose
    public int star_count;
    @SerializedName("stared")
    @Expose
    public boolean stared;
    @SerializedName("status")
    @Expose
    public int status;
    @SerializedName("un_read_activities_count")
    @Expose
    public int unReadActivitiesCount;
    @SerializedName("updated_at")
    @Expose
    public long updateAt;
    @SerializedName("watch_count")
    @Expose
    public int watch_count;
    @SerializedName("watched")
    @Expose
    public boolean watched;
    @SerializedName("is_public")
    @Expose
    public boolean isPublic;
    @SerializedName("member_num")
    @Expose
    public int memberNum; // 这个属性很坑的，getManagerProjects 才能取到，
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("pin")
    @Expose
    public boolean pin;
    @SerializedName("type")
    @Expose
    public int type;
    @SerializedName("shared")
    @Expose
    public boolean shared;

    private String fork_path = "";
    private DynamicObject.Owner owner;

}
