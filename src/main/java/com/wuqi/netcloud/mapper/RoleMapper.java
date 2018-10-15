package com.wuqi.netcloud.mapper;

import com.wuqi.netcloud.mapper.condition.PageableExample;
import com.wuqi.netcloud.entity.RoleEntity;
import com.wuqi.netcloud.entity.map.RoleExMap;

import java.util.List;

public interface RoleMapper {

    int findTotalSize();

    List<RoleExMap> findWithModulesByPage(PageableExample params);

    RoleEntity findRoleDetailsById(Integer roleId);

    int addOne(RoleEntity role);

    int deleteByRoleId(Integer roleId);

    int update(RoleEntity role);
}
