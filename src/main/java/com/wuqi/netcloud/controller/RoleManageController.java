package com.wuqi.netcloud.controller;

import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.controller.params.RoleBody;
import com.wuqi.netcloud.service.RoleManageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/role")
public class RoleManageController {

    @Resource
    private RoleManageService roleManageService;

    @RequestMapping("/list")
    public ResultWrapper list(@RequestParam(defaultValue = "1") Integer page) {
        return this.roleManageService.findRoleByPage(page);
    }

    @RequestMapping("/details/{roleId}")
    public ResultWrapper findOne(@PathVariable Integer roleId) {
        return this.roleManageService.findRoleDetails(roleId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultWrapper add(@RequestBody RoleBody role) {
        return this.roleManageService.addRoleWithModules(role);
    }

    @RequestMapping(value = "/delete/{roleId}", method = RequestMethod.POST)
    public ResultWrapper delete(@PathVariable Integer roleId) {
        return this.roleManageService.deleteRoleAndModules(roleId);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResultWrapper modify(@RequestBody RoleBody role) {
        return this.roleManageService.updateRoleWithModules(role);
    }

    // ---------------为其他模块提供的接口-----------

    @RequestMapping("/common/list")
    public ResultWrapper commonList() {
        return this.roleManageService.simpleList();
    }
}
