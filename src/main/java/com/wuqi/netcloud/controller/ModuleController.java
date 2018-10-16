package com.wuqi.netcloud.controller;

import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.service.ModuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @Resource
    private ModuleService moduleService;

    @RequestMapping("/common/list")
    public ResultWrapper allModules() {
        return this.moduleService.simpleModules();
    }

}
