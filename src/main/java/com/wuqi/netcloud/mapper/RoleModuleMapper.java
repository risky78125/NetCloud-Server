package com.wuqi.netcloud.mapper;

import com.wuqi.netcloud.entity.RoleModule;

import java.util.List;

public interface RoleModuleMapper {

    int addAll(List<RoleModule> roleModuleList);

    int deleteByRoleId(Integer roleId);
}
