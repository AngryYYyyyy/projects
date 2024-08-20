package com.lxy.communitymanagementsystem.controller;

import com.lxy.communitymanagementsystem.model.dto.CommunityDTO;
import com.lxy.communitymanagementsystem.model.entity.Community;
import com.lxy.communitymanagementsystem.model.vo.CommunityVO;
import com.lxy.communitymanagementsystem.model.vo.ResponseResult;
import com.lxy.communitymanagementsystem.service.CommunityService;
import lombok.extern.apachecommons.CommonsLog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 22:01
 * @Description：社区控制器，处理与社区相关的请求
 */
@CommonsLog
@RestController
@RequestMapping("community")
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
    @GetMapping("/list")
    public ResponseResult<List<CommunityVO>> getListCommunities(@RequestBody CommunityDTO communityDTO) {
        List<CommunityVO> list = communityService.getListCommunities(communityDTO,true).stream().map(dto ->
                new ModelMapper().map(dto, CommunityVO.class)
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
    @PostMapping()
    public ResponseResult<String> createCommunity(@RequestBody Community community) {
        boolean b = communityService.save(community);
        return b?ResponseResult.success("添加操作成功"):ResponseResult.failure();
    }

    /**
     * @Description: 更新现有的社区信息
     * @param community 包含更新信息的社区对象
     * @return ResponseResult 更新操作的响应结果
     * @Author: AngryYYYYYY
     * @Date: 2024/7/20
     */
    @PutMapping()
    public ResponseResult<String> updateCommunity(@RequestBody Community community) {
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
    @DeleteMapping("/list")
    public ResponseResult<String> deleteCommunity(@RequestBody List<Integer> ids) {
        boolean b = communityService.removeBatchByIds(ids);
        return b?ResponseResult.success("删除操作成功"):ResponseResult.failure();
    }


}

