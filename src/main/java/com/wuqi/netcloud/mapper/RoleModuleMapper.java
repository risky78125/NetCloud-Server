package com.wuqi.netcloud.mapper;

import com.wuqi.netcloud.entity.RoleModuleEntity;

import java.util.List;

public interface RoleModuleMapper {

    int addAll(List<RoleModuleEntity> roleModuleList);

    int deleteByRoleId(Integer roleId);
}
