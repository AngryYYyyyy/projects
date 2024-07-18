package com.lxy.communitymanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxy.communitymanagementsystem.model.dto.CommunityDTO;
import com.lxy.communitymanagementsystem.model.entity.Community;
import com.lxy.communitymanagementsystem.model.vo.CommunityVO;
import com.lxy.communitymanagementsystem.service.CommunityService;
import com.lxy.communitymanagementsystem.mapper.CommunityMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author AngryYY
* @description 针对表【assets_community(小区 )】的数据库操作Service实现
* @createDate 2024-07-17 21:39:48
*/
@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community>
    implements CommunityService{
    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public List<CommunityDTO> listCommunitiesPage(CommunityDTO communityDTO) {
        Page<CommunityDTO> page = new Page<>(communityDTO.getCurrent(),communityDTO.getSize());
        Page<CommunityDTO> communityDTOPage = communityMapper.listCommunitiesPage(page, communityDTO);
        return communityDTOPage.getRecords();
    }

    @Override
    public List<CommunityDTO> listCommunitiesByCondition(CommunityDTO communityDTO) {
        return communityMapper.listCommunitiesByCondition(communityDTO);
    }

    @Override
    public Integer addCommunity(Community community) {
        return communityMapper.insert(community);
    }
}




