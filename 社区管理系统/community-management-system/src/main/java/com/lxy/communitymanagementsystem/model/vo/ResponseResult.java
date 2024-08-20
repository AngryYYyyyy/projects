package com.lxy.communitymanagementsystem.model.vo;

import com.lxy.communitymanagementsystem.constant.enums.ExceptionCode;
import com.lxy.communitymanagementsystem.constant.enums.ResponseCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 19:46
 * @Description：自定义处理响应
 */
@Setter
@Getter
public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }
    public static <T> ResponseResult<T> success(ExceptionCode exceptionCode,T data) {
        return new ResponseResult<>(exceptionCode.getCode(), exceptionCode.getMessage(), data);
    }

    public static <T> ResponseResult<T> failure() {
        return new ResponseResult<>(ResponseCode.FAILED.getCode(), ResponseCode.FAILED.getMessage());
    }
    public static ResponseResult failure(String message) {
        return new ResponseResult<>(ResponseCode.FAILED.getCode(), message);
    }
    public static ResponseResult failure(Integer code,String message) {
        return new ResponseResult<>(code, message);
    }

    public static <T> ResponseResult<T> validationFailure() {
        return new ResponseResult<>(ResponseCode.VALIDATION_FAILED.getCode(), ResponseCode.VALIDATION_FAILED.getMessage());
    }

    public static <T> ResponseResult<T> unauthorized() {
        return new ResponseResult<>(ResponseCode.UNAUTHORIZED.getCode(), ResponseCode.UNAUTHORIZED.getMessage());
    }

    public static <T> ResponseResult<T> forbidden() {
        return new ResponseResult<>(ResponseCode.FORBIDDEN.getCode(), ResponseCode.FORBIDDEN.getMessage());
    }


}

