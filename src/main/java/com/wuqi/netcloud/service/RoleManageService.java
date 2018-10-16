package com.wuqi.netcloud.service;

import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.controller.params.RoleBody;

public interface RoleManageService {

    ResultWrapper findRoleByPage(int page);

    ResultWrapper findRoleDetails(Integer roleId);

    ResultWrapper addRoleWithModules(RoleBody role);

    ResultWrapper deleteRoleAndModules(Integer roleId);

    ResultWrapper updateRoleWithModules(RoleBody role);

    ResultWrapper simpleList();
}
