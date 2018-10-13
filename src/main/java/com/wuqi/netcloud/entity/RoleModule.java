package com.wuqi.netcloud.entity;


public class RoleModule {

    private Integer roleId;
    private Integer moduleId;

    public RoleModule() {
    }

    public RoleModule(Integer roleId, Integer moduleId) {
        this.roleId = roleId;
        this.moduleId = moduleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

}
