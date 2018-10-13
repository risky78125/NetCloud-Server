package com.wuqi.netcloud.entity;


import com.wuqi.netcloud.entity.map.ModuleExMap;

import java.io.Serializable;
import java.util.List;

public class RoleEntity implements Serializable {

    private Integer roleId;
    private String roleName;

    private List<ModuleExMap> moduleList;

    @Override
    public String toString() {
        return "RoleEntity{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", moduleList=" + moduleList +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<ModuleExMap> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<ModuleExMap> moduleList) {
        this.moduleList = moduleList;
    }
}
