package com.wuqi.netcloud.entity.map;

import com.wuqi.netcloud.entity.RoleEntity;

public class RoleExMap extends RoleEntity {

    private String moduleNames;

    @Override
    public String toString() {
        return "RoleExMap{" +
                "moduleNames='" + moduleNames + '\'' +
                "} " + super.toString();
    }

    public String getModuleNames() {
        return moduleNames;
    }

    public void setModuleNames(String moduleNames) {
        this.moduleNames = moduleNames;
    }
}
