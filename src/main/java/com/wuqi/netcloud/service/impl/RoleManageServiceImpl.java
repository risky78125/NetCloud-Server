package com.wuqi.netcloud.service.impl;

import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.controller.params.RoleBody;
import com.wuqi.netcloud.entity.RoleEntity;
import com.wuqi.netcloud.entity.RoleModuleEntity;
import com.wuqi.netcloud.entity.map.RoleExMap;
import com.wuqi.netcloud.exception.JsonResultException;
import com.wuqi.netcloud.mapper.RoleMapper;
import com.wuqi.netcloud.mapper.RoleModuleMapper;
import com.wuqi.netcloud.mapper.condition.PageableExample;
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

    @Override
    public ResultWrapper findRoleByPage(int page) {
        PageableExample params = PageableExample.create(page);
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
    public ResultWrapper addRoleWithModules(RoleBody role) {
        this.roleMapper.addOne(role);
        Integer roleId = role.getRoleId();
        List<RoleModuleEntity> rms = new ArrayList<>();
        List<Integer> moduleIds = role.getModuleIds();
        if (moduleIds == null || moduleIds.size() == 0) throw new JsonResultException(400, "请至少选择一个权限");
        for (Integer moduleId : moduleIds) {
            RoleModuleEntity rm = new RoleModuleEntity(roleId, moduleId);
            rms.add(rm);
        }
        this.roleModuleMapper.addAll(rms);
        return ResultWrapper.success("新增角色\"" + role.getRoleName() + "\"成功");
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
    public ResultWrapper updateRoleWithModules(RoleBody role) {
        this.roleMapper.update(role);
        Integer roleId = role.getRoleId();
        this.roleModuleMapper.deleteByRoleId(roleId);
        List<RoleModuleEntity> rms = new ArrayList<>();
        List<Integer> moduleIds = role.getModuleIds();
        if (moduleIds == null || moduleIds.size() == 0) throw new JsonResultException(400, "请至少选择一个权限");
        for (Integer moduleId : moduleIds) {
            RoleModuleEntity rm = new RoleModuleEntity(roleId, moduleId);
            rms.add(rm);
        }
        this.roleModuleMapper.addAll(rms);
        return ResultWrapper.success("更新角色\"" + role.getRoleName() + "\"成功");
    }

    @Override
    public ResultWrapper simpleList() {
        List<RoleEntity> list = this.roleMapper.simpleList();
        return ResultWrapper.success(list.size(), list);
    }
}
