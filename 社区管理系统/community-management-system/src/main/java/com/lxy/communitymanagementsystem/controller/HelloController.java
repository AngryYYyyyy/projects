package com.lxy.communitymanagementsystem.controller;

import com.lxy.communitymanagementsystem.model.vo.ResponseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/16 21:28
 * @Description：
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    @PreAuthorize("hasRole('admin')")
    public ResponseResult<String> hello() {
        return  ResponseResult.success("hello");
    }
}
