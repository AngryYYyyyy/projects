package com.lxy.communitymanagementsystem.controller;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.lxy.communitymanagementsystem.model.dto.CommunityDTO;
import com.lxy.communitymanagementsystem.model.dto.CommunityExcelDTO;
import com.lxy.communitymanagementsystem.model.dto.ResponseResult;
import com.lxy.communitymanagementsystem.model.entity.Community;
import com.lxy.communitymanagementsystem.model.vo.CommunityVO;
import com.lxy.communitymanagementsystem.service.CommunityService;
import com.lxy.communitymanagementsystem.utils.ExcelUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.apachecommons.CommonsLog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 22:01
 * @Description：社区控制器，处理与社区相关的请求
 */
@CommonsLog
@RestController
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    /**
     * @Description: 根据communityName、communityCode多条件动态分页查询信息
     * @param communityDTO 包含查询条件的社区DTO对象
     * @return ResponseResult 包含社区列表的响应结果
     * @Author: AngryYYYYYY
     * @Date: 2024/7/20
     */
    @GetMapping("/communities")
    public ResponseResult listCommunities(@RequestBody CommunityDTO communityDTO) {
        ModelMapper modelMapper = new ModelMapper();
        List<CommunityVO> list = communityService.listCommunities(communityDTO,true).stream().map(dto ->
                modelMapper.map(dto, CommunityVO.class)
        ).collect(Collectors.toList());
        return ResponseResult.success(list);
    }

    /**
     * @Description: 添加新的社区信息
     * @param community 包含社区信息的对象
     * @return ResponseResult 添加操作的响应结果
     * @Author: AngryYYYYYY
     * @Date: 2024/7/20
     */
    @PostMapping("/communities")
    public ResponseResult addCommunity(@RequestBody Community community) {
        Integer row = communityService.addCommunity(community);
        return ResponseResult.success(row);
    }

    /**
     * @Description: 更新现有的社区信息
     * @param community 包含更新信息的社区对象
     * @return ResponseResult 更新操作的响应结果
     * @Author: AngryYYYYYY
     * @Date: 2024/7/20
     */
    @PutMapping("/communities")
    public ResponseResult updateCommunity(@RequestBody Community community) {
        boolean b = communityService.updateById(community);
        return b?ResponseResult.success("更新操作成功"):ResponseResult.failure();
    }

    /**
     * @Description: 批量删除社区信息
     * @param ids 包含要删除的社区ID列表
     * @return ResponseResult 删除操作的响应结果
     * @Author: AngryYYYYYY
     * @Date: 2024/7/20
     */
    @DeleteMapping("/communities")
    public ResponseResult deleteCommunity(@RequestBody List<Integer> ids) {
        boolean b = communityService.removeBatchByIds(ids);
        return b?ResponseResult.success("删除操作成功"):ResponseResult.failure();
    }

    /**
     * @Description: 根据Excel导入社区信息
     * @return ResponseResult 导入操作的响应结果
     * @Author: AngryYYYYYY
     * @Date: 2024/7/20
     */
    /*TODO 后续要添加异步功能*/
    @PutMapping("/excel")
    public ResponseResult importCommunities(MultipartFile file) {
        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(1);
        importParams.setHeadRows(1);
        List<CommunityExcelDTO> communityExcelDTOs = (List<CommunityExcelDTO>) ExcelUtils.importExcel(file, CommunityExcelDTO.class, importParams);
        System.out.println(communityExcelDTOs);
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
    public ResponseResult exportCommunities(HttpServletResponse response) {
        List<CommunityDTO> communityDTOS = communityService.listCommunities(null,false);

        ModelMapper modelMapper = new ModelMapper();
        List<CommunityExcelDTO> CommunityExcelDTOs = communityDTOS.stream().map(community -> modelMapper.map(community, CommunityExcelDTO.class)).collect(Collectors.toList());

        ExcelUtils.exportExcel(CommunityExcelDTOs, CommunityExcelDTO.class, "community.xlsx",
                response, new ExportParams("community title", "Sheet1", ExcelType.XSSF));
        return ResponseResult.success("导出Excel成功");
    }
}

