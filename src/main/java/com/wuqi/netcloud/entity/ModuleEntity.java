package com.wuqi.netcloud.entity;


import java.io.Serializable;

public class ModuleEntity implements Serializable {

    private Integer moduleId;
    private String moduleName;

    @Override
    public String toString() {
        return "ModuleEntity{" +
                "moduleId=" + moduleId +
                ", moduleName='" + moduleName + '\'' +
                '}';
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
