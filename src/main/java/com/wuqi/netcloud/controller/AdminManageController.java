package com.wuqi.netcloud.controller;

import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.controller.params.AdminParams;
import com.wuqi.netcloud.service.AdminMangeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminManageController {

    @Resource
    private AdminMangeService adminMangeService;

    @RequestMapping("/list")
    public ResultWrapper list(AdminParams params) {
        return this.adminMangeService.findByCondition(params);
    }

}
