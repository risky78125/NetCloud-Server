package com.wuqi.netcloud.service;

import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.controller.params.AdminBody;
import com.wuqi.netcloud.controller.params.AdminParams;

public interface AdminMangeService {
    ResultWrapper findByCondition(AdminParams params);

    ResultWrapper findAdminDetails(Integer adminId);

    ResultWrapper addAdminWithRoles(AdminBody admin);

    ResultWrapper updateAdminWithRoles(AdminBody admin);

    ResultWrapper deleteAdminAndRoles(Integer adminId);
}
