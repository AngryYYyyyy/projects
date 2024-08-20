package com.lxy.communitymanagementsystem.service.impl;

import com.lxy.communitymanagementsystem.mapper.UserMapper;
import com.lxy.communitymanagementsystem.model.dto.LoginUser;
import com.lxy.communitymanagementsystem.model.vo.LoginUserVO;
import com.lxy.communitymanagementsystem.service.LoginService;
import com.lxy.communitymanagementsystem.utils.JwtUtils;
import com.lxy.communitymanagementsystem.utils.RedisCache;
import com.lxy.communitymanagementsystem.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 登录服务实现类，提供了基于用户名和密码的用户认证方法，并通过 JWT 管理会话。
 * @Author AngryYY
 * @description 自定义认证实现，验证登录凭证并使用 JWT 管理会话。
 * @createDate 2024-08-19 19:54:19
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;  // 管理用户认证的对象

    @Autowired
    private RedisCache redisCache;  // 用于存储用户会话信息的 Redis 缓存

    @Autowired
    private UserMapper userMapper;  // 用户数据访问对象

    /**
     * 处理登录请求，通过认证用户并返回一个 JWT 令牌。
     * @param loginUserVO 要认证的用户，包含用户名和密码。
     * @return String 如果认证成功，返回 JWT 令牌。
     */
    @Override
    public String login(LoginUserVO loginUserVO) {
        // 尝试使用提供的用户名和密码进行认证
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUserVO.getUsername(), loginUserVO.getPassword()));

        // 检查认证结果，如果认证失败则抛出异常
        if (Objects.isNull(authentication)) {
            throw new RuntimeException("登录失败");
        }


        // 认证成功则，生成并返回 JWT
        String uuid = UUIDUtils.simpleUUID();
        String jwt = JwtUtils.createToken(uuid);

        // 将用户详情存储在 Redis 中，以便通过 JWT 管理会话
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String redisKey = "login:" + uuid;
        redisCache.setCacheObject(redisKey, loginUser);

        return jwt;
    }
}
