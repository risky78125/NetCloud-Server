package com.wuqi.netcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.wuqi.netcloud.mapper")
public class NetCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetCloudApplication.class, args);
    }
}
