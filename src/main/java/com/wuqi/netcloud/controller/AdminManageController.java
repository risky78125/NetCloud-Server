package com.wuqi.netcloud.controller;

import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.controller.params.AdminBody;
import com.wuqi.netcloud.controller.params.AdminParams;
import com.wuqi.netcloud.service.AdminMangeService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/details/{adminId}")
    public ResultWrapper details(@PathVariable Integer adminId) {
        return this.adminMangeService.findAdminDetails(adminId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultWrapper addOne(@RequestBody AdminBody admin) {
        return this.adminMangeService.addAdminWithRoles(admin);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResultWrapper update(@RequestBody AdminBody admin) {
        return this.adminMangeService.updateAdminWithRoles(admin);
    }

    @RequestMapping(value = "/delete/{adminId}", method = RequestMethod.POST)
    public ResultWrapper delete(@PathVariable Integer adminId) {
        return this.adminMangeService.deleteAdminAndRoles(adminId);
    }

}
