package com.wuqi.netcloud.service.impl;

import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.controller.params.AdminBody;
import com.wuqi.netcloud.controller.params.AdminParams;
import com.wuqi.netcloud.entity.AdminEntity;
import com.wuqi.netcloud.entity.AdminRoleEntity;
import com.wuqi.netcloud.entity.map.AdminExMap;
import com.wuqi.netcloud.exception.JsonResultException;
import com.wuqi.netcloud.mapper.AdminMapper;
import com.wuqi.netcloud.mapper.AdminRoleMapper;
import com.wuqi.netcloud.mapper.condition.AdminExample;
import com.wuqi.netcloud.mapper.condition.PageableExample;
import com.wuqi.netcloud.service.AdminMangeService;
import com.wuqi.netcloud.utils.TimeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminMangeServiceImpl implements AdminMangeService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Override
    public ResultWrapper findByCondition(AdminParams params) {

        AdminExample example = new AdminExample();
        example.setModuleId(params.getModuleId());
        String roleName = params.getRoleName();
        roleName = roleName != null && roleName.length() > 0 ? ("%" + roleName + "%") : null;
        example.setRoleName(roleName);
        PageableExample pageable = PageableExample.create(params.getPage(), params.getCount());
        example.setOffset(pageable.getOffset());
        example.setCount(pageable.getCount());
        List<AdminExMap> list = this.adminMapper.findAllByCondition(example);
        int count = this.adminMapper.countByCondition(example);

        return ResultWrapper.success(count, example.getCount(), list);
    }

    @Override
    public ResultWrapper findAdminDetails(Integer adminId) {
        AdminEntity admin =  this.adminMapper.findDetailsById(adminId);
        return ResultWrapper.success(admin);
    }

    @Transactional
    @Override
    public ResultWrapper addAdminWithRoles(AdminBody admin) {
        List<Integer> roleIds = admin.getRoleIds();
        if (roleIds == null || roleIds.size() == 0) {
            throw new JsonResultException(400, "请至少选择一个角色");
        }
        admin.setEnrolldate(TimeUtils.currentDate());
        this.adminMapper.addOne(admin);
        List<AdminRoleEntity> list = new ArrayList<>();
        Integer adminId = admin.getAdminId();
        for (Integer roleId : roleIds) {
            list.add(new AdminRoleEntity(adminId, roleId));
        }
        this.adminRoleMapper.addAll(list);
        return ResultWrapper.success("管理员" + admin.getAdminCode() + "插入成功");
    }

    @Transactional
    @Override
    public ResultWrapper updateAdminWithRoles(AdminBody admin) {
        List<Integer> roleIds = admin.getRoleIds();
        if (roleIds == null || roleIds.size() == 0) {
            throw new JsonResultException(400, "请至少选择一个角色");
        }
        this.adminMapper.updateOne(admin);
        Integer adminId = admin.getAdminId();
        this.adminRoleMapper.deleteByAdminId(adminId);
        List<AdminRoleEntity> list = new ArrayList<>();
        for (Integer roleId : roleIds) {
            list.add(new AdminRoleEntity(adminId, roleId));
        }
        this.adminRoleMapper.addAll(list);
        AdminEntity one = this.adminMapper.findOne(admin.getAdminId());
        return ResultWrapper.success("管理员" + one.getAdminCode() + "修改成功");
    }

    @Transactional
    @Override
    public ResultWrapper deleteAdminAndRoles(Integer adminId) {
        this.adminRoleMapper.deleteByAdminId(adminId);
        this.adminMapper.deleteById(adminId);
        return ResultWrapper.success("删除成功");
    }
}
