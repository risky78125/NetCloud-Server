package com.wuqi.netcloud.entity.map;

import com.wuqi.netcloud.entity.RoleEntity;

public class RoleExMap extends RoleEntity {

    private String moduleNames;
    private boolean isSelected;

    @Override
    public String toString() {
        return "RoleExMap{" +
                "moduleNames='" + moduleNames + '\'' +
                ", isSelected=" + isSelected +
                "} " + super.toString();
    }

    public String getModuleNames() {
        return moduleNames;
    }

    public void setModuleNames(String moduleNames) {
        this.moduleNames = moduleNames;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
