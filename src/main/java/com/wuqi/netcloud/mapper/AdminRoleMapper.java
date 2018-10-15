package com.wuqi.netcloud.mapper;

import com.wuqi.netcloud.entity.AdminRoleEntity;

import java.util.List;

public interface AdminRoleMapper {
    int addAll(List<AdminRoleEntity> list);

    int deleteByAdminId(Integer adminId);
}
