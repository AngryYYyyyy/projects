package com.lxy.communitymanagementsystem.controller;

import com.lxy.communitymanagementsystem.model.dto.AreaDTO;
import com.lxy.communitymanagementsystem.model.dto.ResponseResult;
import com.lxy.communitymanagementsystem.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/18 22:09
 * @Description：地区控制器，处理与地区相关的请求
 */
@RestController
public class AreaController {

    @Autowired
    private AreaService areaService;

    /**
     * @Description: 以下拉列表形式获取地区信息
     * @return ResponseResult 包含地区列表的响应结果
     * @Author: AngryYYYYYY
     * @Date: 2024/7/20
     */
    @GetMapping("/area")
    public ResponseResult listArea() {
        List<AreaDTO> areas = areaService.listAreaDTO();
        return ResponseResult.success(areas);
    }
}

