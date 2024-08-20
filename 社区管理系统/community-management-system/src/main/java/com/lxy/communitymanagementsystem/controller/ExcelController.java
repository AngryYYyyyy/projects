package com.lxy.communitymanagementsystem.controller;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.lxy.communitymanagementsystem.model.dto.CommunityDTO;
import com.lxy.communitymanagementsystem.model.dto.CommunityExcelDTO;
import com.lxy.communitymanagementsystem.model.entity.Community;
import com.lxy.communitymanagementsystem.model.vo.ResponseResult;
import com.lxy.communitymanagementsystem.service.CommunityService;
import com.lxy.communitymanagementsystem.utils.ExcelUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/8/20 16:13
 * @Description：
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    private CommunityService communityService;
    /**
     * @Description: 根据Excel导入社区信息
     * @return ResponseResult 导入操作的响应结果
     * @Author: AngryYYYYYY
     * @Date: 2024/7/20
     */
    /*TODO 后续要添加异步功能*/
    @PostMapping("/excel")
    public ResponseResult<String> importCommunities(MultipartFile file) {
        List<CommunityExcelDTO> communityExcelDTOs = (List<CommunityExcelDTO>) ExcelUtils.importExcel(file, CommunityExcelDTO.class);
        List<Community> communities = communityExcelDTOs.stream().map(communityExcelDTO -> new ModelMapper().map(communityExcelDTO, Community.class)).collect(Collectors.toList());
        boolean b = communityService.saveBatch(communities);
        return b?ResponseResult.success("导入操作成功"):ResponseResult.failure();
    }

    /**
     * @Description: 导出社区信息的Excel文件
     * @param response HttpServletResponse 响应对象
     * @return ResponseResult 导出操作的响应结果
     * @Author: AngryYYYYYY
     * @Date: 2024/7/20
     */
    /*TODO 后续要添加异步功能*/
    @GetMapping("/excel")
    public ResponseResult<String> exportCommunities(HttpServletResponse response) {
        List<CommunityDTO> communityDTOS = communityService.getListCommunities(null,false);

        List<CommunityExcelDTO> CommunityExcelDTOs = communityDTOS.stream().map(community -> new ModelMapper().map(community, CommunityExcelDTO.class)).collect(Collectors.toList());

        ExcelUtils.exportExcel(CommunityExcelDTOs, CommunityExcelDTO.class, "community.xlsx",
                response, new ExportParams("community title", "Sheet1", ExcelType.XSSF));
        return ResponseResult.success("导出Excel成功");
    }
}
