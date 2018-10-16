package com.wuqi.netcloud.service.impl;

import com.wuqi.netcloud.commons.ResultWrapper;
import com.wuqi.netcloud.entity.ModuleEntity;
import com.wuqi.netcloud.mapper.ModuleMapper;
import com.wuqi.netcloud.service.ModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Resource
    private ModuleMapper moduleMapper;

    @Override
    public ResultWrapper simpleModules() {
        List<ModuleEntity> list = this.moduleMapper.findAll();
        return ResultWrapper.success(list.size(), list);
    }
}
