package com.lxy.communitymanagementsystem.controller;

import com.lxy.communitymanagementsystem.model.dto.AreaDTO;
import com.lxy.communitymanagementsystem.model.dto.ResponseResult;
import com.lxy.communitymanagementsystem.model.entity.Area;
import com.lxy.communitymanagementsystem.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/18 22:09
 * @Description：
 */
@RestController
@RequestMapping("area")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @GetMapping("/list")
    public ResponseResult listArea() {
        List<AreaDTO> areas = areaService.listAreaDTO();
        return ResponseResult.success(areas);
    }
}
