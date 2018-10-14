package com.wuqi.netcloud.service.impl;

import com.wuqi.netcloud.commons.PageableParams;
import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.controller.params.RoleParams;
import com.wuqi.netcloud.entity.ModuleEntity;
import com.wuqi.netcloud.entity.RoleEntity;
import com.wuqi.netcloud.entity.RoleModule;
import com.wuqi.netcloud.entity.map.RoleExMap;
import com.wuqi.netcloud.exception.JsonResultException;
import com.wuqi.netcloud.mapper.ModuleMapper;
import com.wuqi.netcloud.mapper.RoleMapper;
import com.wuqi.netcloud.mapper.RoleModuleMapper;
import com.wuqi.netcloud.service.RoleManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleManageServiceImpl implements RoleManageService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleModuleMapper roleModuleMapper;

    @Resource
    private ModuleMapper moduleMapper;

    @Override
    public ResultWrapper findRoleByPage(int page) {
        PageableParams params = PageableParams.create(page);
        int totalSize = this.roleMapper.findTotalSize();
        List<RoleExMap> list = this.roleMapper.findWithModulesByPage(params);
        return ResultWrapper.success(totalSize, params, list);
    }

    @Override
    public ResultWrapper findRoleDetails(Integer roleId) {
        RoleEntity role = this.roleMapper.findRoleDetailsById(roleId);
        return ResultWrapper.success(role);
    }

    @Transactional
    @Override
    public ResultWrapper addRoleWithModules(RoleParams role) {
        try {
            this.roleMapper.addOne(role);
            Integer roleId = role.getRoleId();
            List<RoleModule> rms = new ArrayList<>();
            for (Integer moduleId : role.getModuleIds()) {
                RoleModule rm = new RoleModule(roleId, moduleId);
                rms.add(rm);
            }
            System.out.println(1 / 0);
            this.roleModuleMapper.addAll(rms);
            return ResultWrapper.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new JsonResultException(500, "角色插入失败");
        }
    }

    @Transactional
    @Override
    public ResultWrapper deleteRoleAndModules(Integer roleId) {
        this.roleModuleMapper.deleteByRoleId(roleId);
        this.roleMapper.deleteByRoleId(roleId);
        return ResultWrapper.success();
    }

    @Transactional
    @Override
    public ResultWrapper updateRoleWithModules(RoleParams role) {
        this.roleMapper.update(role);
        Integer roleId = role.getRoleId();
        this.roleModuleMapper.deleteByRoleId(roleId);
        List<RoleModule> rms = new ArrayList<>();
        for (Integer moduleId : role.getModuleIds()) {
            RoleModule rm = new RoleModule(roleId, moduleId);
            rms.add(rm);
        }
        this.roleModuleMapper.addAll(rms);
        return ResultWrapper.success();
    }

    @Override
    public ResultWrapper allModules() {
        List<ModuleEntity> list = this.moduleMapper.findAll();
        return ResultWrapper.success(list.size(), list);
    }
}
