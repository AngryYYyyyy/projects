package com.lxy.communitymanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxy.communitymanagementsystem.model.dto.CommunityDTO;
import com.lxy.communitymanagementsystem.model.entity.Community;
import com.lxy.communitymanagementsystem.service.CommunityService;
import com.lxy.communitymanagementsystem.mapper.CommunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
    public List<CommunityDTO> listCommunities(CommunityDTO communityDTO) {
        return communityMapper.queryList(communityDTO);
    }
}




