package com.lxy.communitymanagementsystem.model.dto;

import com.lxy.communitymanagementsystem.constant.enums.ExceptionCode;
import com.lxy.communitymanagementsystem.constant.enums.ResponseCode;
import com.lxy.communitymanagementsystem.exception.BusinessException;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 19:46
 * @Description：自定义处理响应
 */
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

    public static <T> ResponseResult<T> failure() {
        return new ResponseResult<>(ResponseCode.FAILED.getCode(), ResponseCode.FAILED.getMessage());
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

    public static ResponseResult failure(ExceptionCode exceptionCode) {
        return new ResponseResult<>(exceptionCode.getCode(), exceptionCode.getMessage());
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

