package com.wuqi.netcloud.mapper;

import com.wuqi.netcloud.entity.AdminEntity;
import com.wuqi.netcloud.mapper.condition.AdminExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminMapperTest {

    @Resource
    private AdminMapper adminMapper;

    @Test
    public void countByCondition() {
        AdminExample example = new AdminExample();
        System.out.println(adminMapper.countByCondition(example));
    }

    @Test
    public void findAllByCondition() {
    }

    @Test
    public void findDetailsById() {
        AdminEntity admin = this.adminMapper.findDetailsById(5000);
        System.out.println(admin.getAdminId());
        admin.getRoleList().forEach(System.out::println);
    }

    @Test
    public void addOne() {
    }

    @Test
    public void updateOne() {
    }

    @Test
    public void deleteById() {
    }
}