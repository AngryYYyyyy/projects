package com.lxy.communitymanagementsystem.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/8/20 17:59
 * @Description：
 */
@Setter
@Getter
public class LoginUserVO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 唯一标识
     */
    private String uuid = "";

}

