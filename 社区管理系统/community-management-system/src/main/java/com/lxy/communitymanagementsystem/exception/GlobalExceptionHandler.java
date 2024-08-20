package com.lxy.communitymanagementsystem.exception;

import com.lxy.communitymanagementsystem.model.vo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 20:31
 * @Description：
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理自定义的业务异常
     * @param e
     * @return
     */

    @ExceptionHandler(value = BusinessException.class)
    public ResponseResult BusinessExceptionHandler(BusinessException e){
        log.error("发生业务异常！原因是：",e.getMessage());
        return ResponseResult.failure(e.getMessage());
    }

}