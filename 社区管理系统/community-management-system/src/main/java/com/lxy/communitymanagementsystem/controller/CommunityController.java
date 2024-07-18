package com.lxy.communitymanagementsystem.controller;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.lxy.communitymanagementsystem.model.dto.CommunityDTO;
import com.lxy.communitymanagementsystem.model.dto.CommunityExcelDTO;
import com.lxy.communitymanagementsystem.model.dto.ResponseResult;
import com.lxy.communitymanagementsystem.model.entity.Community;
import com.lxy.communitymanagementsystem.model.vo.CommunityVO;
import com.lxy.communitymanagementsystem.service.CommunityService;
import com.lxy.communitymanagementsystem.utils.ExcelUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.ibatis.annotations.Delete;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 22:01
 * @Description：
 */
@CommonsLog
@RestController
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @GetMapping("/list")
    public ResponseResult listCommunities(@RequestBody CommunityDTO communityDTO) {
        ModelMapper modelMapper = new ModelMapper();
        List<CommunityVO> list = communityService.listCommunitiesPage(communityDTO).stream().map(dto ->
                modelMapper.map(dto, CommunityVO.class)
        ).collect(Collectors.toList());
        return ResponseResult.success(list);
    }

    @PostMapping("/add")
    public ResponseResult addCommunity(@RequestBody Community community) {
        Integer row = communityService.addCommunity(community);
        return ResponseResult.success(row);
    }

    @PutMapping("/update")
    public ResponseResult updateCommunity(@RequestBody Community community) {
        boolean b = communityService.updateById(community);
        return ResponseResult.success(b);
    }

    @DeleteMapping("/delete")
    public ResponseResult deleteCommunity(@RequestBody List<Integer> ids) {
        boolean b = communityService.removeBatchByIds(ids);
        return ResponseResult.success(b);
    }


    @GetMapping("/import")
    public ResponseResult importCommunities() {
        return ResponseResult.success("h");
    }

    @GetMapping("/export")
    public ResponseResult exportCommunities(HttpServletResponse response) {
        List<CommunityDTO> communityDTOS = communityService.listCommunitiesByCondition(null);
        System.out.println(communityDTOS);
        ModelMapper modelMapper = new ModelMapper();
        List<CommunityExcelDTO> list = communityDTOS.stream().map(community -> modelMapper.map(community, CommunityExcelDTO.class)).collect(Collectors.toList());
        System.out.println(list);
        ExcelUtils.exportExcel(list, CommunityExcelDTO.class, "community",
                response, new ExportParams("community title", "Sheet1"));
        return ResponseResult.success("导出Excel");
    }

}
