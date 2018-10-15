package com.wuqi.netcloud.entity;


public class AdminRoleEntity {

    private Integer adminId;
    private Integer roleId;

    public AdminRoleEntity() {
    }

    public AdminRoleEntity(Integer adminId, Integer roleId) {
        this.adminId = adminId;
        this.roleId = roleId;
    }


    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
