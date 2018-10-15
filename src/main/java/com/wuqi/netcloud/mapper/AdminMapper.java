package com.wuqi.netcloud.mapper;

import com.wuqi.netcloud.entity.map.AdminExMap;
import com.wuqi.netcloud.mapper.condition.AdminExample;

import java.util.List;

public interface AdminMapper {

    int countByCondition(AdminExample example);

    List<AdminExMap> findAllByCondition(AdminExample example);

}
