package com.wuqi.netcloud.mapper;

import com.wuqi.netcloud.mapper.condition.PageableExample;
import com.wuqi.netcloud.entity.RoleEntity;
import com.wuqi.netcloud.entity.map.RoleExMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {

    @Resource
    private RoleMapper roleMapper;

    @Test
    public void findTotalSize() {
        System.out.println("------- findTotalSize -----------");
        System.out.println(roleMapper.findTotalSize());
    }

    @Test
    public void findWithModulesByPage() {
        System.out.println("------- findWithModulesByPage -----------");
        PageableExample params = new PageableExample(3, 2);
        List<RoleExMap> list = roleMapper.findWithModulesByPage(params);
        list.forEach(System.out::println);
    }

    @Test
    public void findRoleDetailsById() {
        System.out.println("------- findRoleDetailsById -----------");
        RoleEntity role = roleMapper.findRoleDetailsById(300);
        System.out.println(role.getRoleId() + ", " + role.getRoleName());
        role.getModuleList().forEach(module -> System.out.println(module.getModuleId() + "--" + module.getModuleName() + "--" + module.isSelected()));
    }

    @Test
    public void addOne() {
        System.out.println("------- addOne -----------");
    }

    @Test
    public void deleteByRoleId() {
        System.out.println("------- deleteByRoleId -----------");
    }

    @Test
    public void update() {
        System.out.println("------- update -----------");
    }
}