package com.lxy.communitymanagementsystem.controller;

import com.lxy.communitymanagementsystem.constant.consist.Constants;
import com.lxy.communitymanagementsystem.model.vo.ResponseResult;
import com.lxy.communitymanagementsystem.utils.ChainedMap;
import com.lxy.communitymanagementsystem.utils.RedisCache;
import com.lxy.communitymanagementsystem.utils.UUIDUtils;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/8/1 21:11
 * @Description：
 */
@RestController
public class CaptchaController {

    private static final String CAPTCHA_CODE_KEY = "captchaCode:";
    @Autowired
    private RedisCache redisCache;

    /**
     * 生成验证码
     * @param
     * @return:
     */
    @GetMapping("/captcha")
    public ResponseResult<ChainedMap> createCodeImage( ){
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);

        //生成验证码,及验证码唯一标识
        String uuid = UUIDUtils.simpleUUID();
        String key = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = specCaptcha.text().toLowerCase();

        //保存到redis
        redisCache.setCacheObject(key, captcha, 1000, TimeUnit.SECONDS);

        return ResponseResult.success(ChainedMap.create().set("uuid",uuid).set("img",specCaptcha.toBase64()));
    }
}
