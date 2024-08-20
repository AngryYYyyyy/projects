package com.lxy.communitymanagementsystem.controller;

import com.lxy.communitymanagementsystem.model.vo.LoginUserVO;
import com.lxy.communitymanagementsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/8/20 17:25
 * @Description：
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 处理用户登录请求。
     * 用户通过提交用户名和密码来请求登录，如果认证成功，返回一个JWT令牌。
     * @param user 用户登录信息，封装在 User 对象中
     * @return ResponseEntity 返回包含JWT令牌的响应实体
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserVO user) {
        try {
            // 调用登录服务，进行用户认证，并接收返回的JWT令牌
            String jwt = loginService.login(user);

            // 检查JWT是否成功生成
            if (jwt == null || jwt.isEmpty()) {
                // 未认证成功，返回401状态码
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
            }

            // 创建响应实体，包含JWT令牌，并返回
            return ResponseEntity.ok(jwt);
        } catch (Exception e) {
            // 处理异常情况，返回500状态码
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }
}
