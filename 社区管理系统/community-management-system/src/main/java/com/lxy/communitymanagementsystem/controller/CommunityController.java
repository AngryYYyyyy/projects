package com.lxy.communitymanagementsystem.controller;

import com.lxy.communitymanagementsystem.model.dto.CommunityDTO;
import com.lxy.communitymanagementsystem.model.dto.ResponseResult;
import com.lxy.communitymanagementsystem.model.entity.Community;
import com.lxy.communitymanagementsystem.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 22:01
 * @Description：
 */
@RestController
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @GetMapping("/list")
    public ResponseResult listCommunities(@RequestBody CommunityDTO communityDTO) {
        List<CommunityDTO> communities = communityService.listCommunities(communityDTO);
        communities.forEach(System.out::println);
        return ResponseResult.success(communities);
    }
}
