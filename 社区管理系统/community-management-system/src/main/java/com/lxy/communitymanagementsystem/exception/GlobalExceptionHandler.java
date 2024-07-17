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
        return ResponseResult.failure(e.getExceptionCode(),e.getMessage());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public ResponseResult exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e.getMessage());
        return ResponseResult.failure(ExceptionCode.DATA_INVALID);
    }

    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
//    @ExceptionHandler(value =Exception.class)
//    @ResponseBody
//    public ResponseResult exceptionHandler(HttpServletRequest req, Exception e){
//        log.error("未知异常！原因是:",e.getMessage());
//        return ResponseResult.failure(ExceptionCode.INTERNAL_SERVER_ERROR);
//    }
}