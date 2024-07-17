package com.lxy.communitymanagementsystem.controller;

import com.lxy.communitymanagementsystem.model.dto.ResponseResult;
import com.lxy.communitymanagementsystem.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private CommunityService communityService;

    @GetMapping("/hello")
    @ResponseBody
    public ResponseResult<String> hello() {

        return  ResponseResult.failure();
    }
}
