package com.wuqi.netcloud.service;

import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.controller.params.RoleParams;

public interface RoleManageService {

    ResultWrapper findRoleByPage(int page);

    ResultWrapper findRoleDetails(Integer roleId);

    ResultWrapper addRoleWithModules(RoleParams role);

    ResultWrapper deleteRoleAndModules(Integer roleId);

    ResultWrapper updateRoleWithModules(RoleParams role);
}
