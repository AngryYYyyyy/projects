package com.lxy.communitymanagementsystem.constant.enums;

import lombok.Getter;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/8/20 17:13
 * @Description：
 */
@Getter
public enum UserStatus {
    OK("0","正常"),DISABLE("1","停用"),DELETED("2","删除");

    private final String code;
    private final String info;

    UserStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }

}
