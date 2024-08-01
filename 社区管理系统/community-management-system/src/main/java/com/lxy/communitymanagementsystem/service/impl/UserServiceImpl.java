package com.lxy.communitymanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxy.communitymanagementsystem.mapper.UserMapper;
import com.lxy.communitymanagementsystem.model.entity.User;
import com.lxy.communitymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author AngryYY
* @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @createDate 2024-08-02 00:48:27
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserAccount(String userAccount) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>().eq(User::getUserAccount, userAccount);
        User user = getOneOpt(wrapper).get();
        return user;
    }
}




