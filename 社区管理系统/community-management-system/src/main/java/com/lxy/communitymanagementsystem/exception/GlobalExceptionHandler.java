package com.lxy.communitymanagementsystem.exception;

import com.lxy.communitymanagementsystem.constant.enums.ExceptionCode;
import com.lxy.communitymanagementsystem.model.dto.ResponseResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 20:31
 * @Description：
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseResult BusinessExceptionHandler(HttpServletRequest req, BusinessException e){
        log.error("发生业务异常！原因是：",e.getMessage());
        return ResponseResult.failure(e.getExceptionCode());
    }

}