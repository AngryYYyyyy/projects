package com.lxy.communitymanagementsystem.exception;

import com.lxy.communitymanagementsystem.constant.enums.ExceptionCode;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 20:34
 * @Description：
 */
public class BusinessException extends RuntimeException {
    private final ExceptionCode exceptionCode;

    public BusinessException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }

    public BusinessException(String message, ExceptionCode exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }
}
