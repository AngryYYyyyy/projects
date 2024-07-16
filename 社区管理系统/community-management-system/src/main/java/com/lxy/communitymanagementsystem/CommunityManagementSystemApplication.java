package com.lxy.communitymanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lxy.communitymanagementsystem.mapper")
public class CommunityManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommunityManagementSystemApplication.class, args);
    }
}
