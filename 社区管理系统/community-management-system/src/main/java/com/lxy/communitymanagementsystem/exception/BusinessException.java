package com.lxy.communitymanagementsystem.exception;

import com.lxy.communitymanagementsystem.constant.enums.ExceptionCode;
import lombok.Getter;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 20:34
 * @Description：
 */
@Getter
public class BusinessException extends RuntimeException {

    public BusinessException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
    }
    public BusinessException(String message) {
        super(message);

    }
}
