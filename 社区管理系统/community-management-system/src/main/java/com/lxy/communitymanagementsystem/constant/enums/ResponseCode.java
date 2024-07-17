package com.lxy.communitymanagementsystem.constant.enums;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 19:45
 * @Description：响应处理枚举类
 */
public enum ResponseCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATION_FAILED(400, "参数检验失败"),
    UNAUTHORIZED(401, "未登录或Token已过期"),
    FORBIDDEN(403, "没有相关权限");

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

