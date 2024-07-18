package com.lxy.communitymanagementsystem.service;

import com.lxy.communitymanagementsystem.model.dto.CommunityDTO;
import com.lxy.communitymanagementsystem.model.entity.Community;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lxy.communitymanagementsystem.model.vo.CommunityVO;

import java.util.List;

/**
* @author AngryYY
* @description 针对表【assets_community(小区 )】的数据库操作Service
* @createDate 2024-07-17 21:39:48
*/
public interface CommunityService extends IService<Community> {
     List<CommunityDTO> listCommunitiesPage(CommunityDTO communityDTO) ;
     List<CommunityDTO> listCommunitiesByCondition(CommunityDTO communityDTO) ;
     Integer addCommunity(Community community);
}
