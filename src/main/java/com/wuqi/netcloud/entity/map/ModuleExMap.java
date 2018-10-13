package com.wuqi.netcloud.entity.map;

import com.wuqi.netcloud.entity.ModuleEntity;

public class ModuleExMap extends ModuleEntity {

    private boolean isSelected;

    @Override
    public String toString() {
        return "ModuleExMap{" +
                "isSelected=" + isSelected +
                "} " + super.toString();
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
