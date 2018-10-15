package com.wuqi.netcloud.service;

import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.controller.params.AdminParams;

public interface AdminMangeService {
    ResultWrapper findByCondition(AdminParams params);
}
