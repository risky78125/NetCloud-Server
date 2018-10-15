package com.wuqi.netcloud.controller.params;

import com.wuqi.netcloud.entity.AdminEntity;

import java.util.List;

public class AdminBody extends AdminEntity {

    private List<Integer> roleIds;

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }
}
