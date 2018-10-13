package com.wuqi.netcloud.controller.params;


import com.wuqi.netcloud.entity.RoleEntity;

import java.util.List;

public class RoleParams extends RoleEntity {

    private List<Integer> moduleIds;

    public List<Integer> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<Integer> moduleIds) {
        this.moduleIds = moduleIds;
    }
}
