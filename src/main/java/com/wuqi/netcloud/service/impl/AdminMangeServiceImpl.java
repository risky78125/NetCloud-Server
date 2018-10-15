package com.wuqi.netcloud.service.impl;

import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.controller.params.AdminParams;
import com.wuqi.netcloud.entity.map.AdminExMap;
import com.wuqi.netcloud.mapper.AdminMapper;
import com.wuqi.netcloud.mapper.condition.AdminExample;
import com.wuqi.netcloud.mapper.condition.PageableExample;
import com.wuqi.netcloud.service.AdminMangeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminMangeServiceImpl implements AdminMangeService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public ResultWrapper findByCondition(AdminParams params) {

        AdminExample example = new AdminExample();
        example.setModuleId(params.getModuleId());
        String roleName = params.getRoleName();
        roleName = roleName != null ? ("%" + roleName + "%") : null;
        example.setRoleName(roleName);
        PageableExample pageable = PageableExample.create(params.getPage(), params.getCount());
        example.setOffset(pageable.getOffset());
        example.setCount(pageable.getCount());
        List<AdminExMap> list = this.adminMapper.findAllByCondition(example);
        int count = this.adminMapper.countByCondition(example);

        return ResultWrapper.success(count, example.getCount(), list);
    }
}
