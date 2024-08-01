package com.lxy.communitymanagementsystem.service.impl;

import com.lxy.communitymanagementsystem.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/8/2 1:08
 * @Description：
 */
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    void findByUsername() {
        User user = userService.findByUserAccount("5571609286");
        System.out.println(user);
    }
}