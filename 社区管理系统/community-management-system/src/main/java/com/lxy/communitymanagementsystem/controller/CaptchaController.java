package com.lxy.communitymanagementsystem.controller;

import com.lxy.communitymanagementsystem.constant.consist.Constants;
import com.lxy.communitymanagementsystem.model.dto.ResponseResult;
import com.lxy.communitymanagementsystem.utils.ChainedMap;
import com.lxy.communitymanagementsystem.utils.UUIDUtils;
import com.wf.captcha.SpecCaptcha;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/8/1 21:11
 * @Description：
 */
@RestController
public class CaptchaController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 生成验证码
     * @param response
     * @return: com.mashibing.springsecurity_example.common.ResponseResult
     */
    @GetMapping("/captchaImage")
    public ResponseResult getCode(HttpServletResponse response){
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);

        //生成验证码,及验证码唯一标识
        String uuid = UUIDUtils.simpleUUID();
        String key = Constants.CAPTCHA_CODE_KEY + uuid;
        String code = specCaptcha.text().toLowerCase();

        //保存到redis
        redisTemplate.opsForValue().set(key, code, Duration.ofMinutes(30));

        return ResponseResult.success(ChainedMap.create().set("uuid",uuid).set("img",specCaptcha.toBase64()));
    }
}
