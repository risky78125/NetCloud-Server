package com.wuqi.netcloud.mapper;

import com.wuqi.netcloud.controller.params.AdminBody;
import com.wuqi.netcloud.entity.AdminEntity;
import com.wuqi.netcloud.entity.map.AdminExMap;
import com.wuqi.netcloud.mapper.condition.AdminExample;

import java.util.List;

public interface AdminMapper {

    int countByCondition(AdminExample example);

    List<AdminExMap> findAllByCondition(AdminExample example);

    AdminEntity findDetailsById(Integer adminId);

    int addOne(AdminBody admin);

    int updateOne(AdminBody admin);

    int deleteById(Integer adminId);
}
