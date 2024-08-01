package com.lxy.communitymanagementsystem.service;

import com.lxy.communitymanagementsystem.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author AngryYY
* @description 针对表【sys_user(用户信息表)】的数据库操作Service
* @createDate 2024-08-02 00:48:27
*/
public interface UserService extends IService<User> {
    User findByUserAccount(String userAccount);
}
