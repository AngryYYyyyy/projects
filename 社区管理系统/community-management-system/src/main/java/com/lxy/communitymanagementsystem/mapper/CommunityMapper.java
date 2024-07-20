package com.lxy.communitymanagementsystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxy.communitymanagementsystem.mapper.provider.CommunitySqlProvider;
import com.lxy.communitymanagementsystem.model.dto.CommunityDTO;
import com.lxy.communitymanagementsystem.model.entity.Community;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
* @author AngryYY
* @description 针对表【assets_community(小区 )】的数据库操作Mapper
* @createDate 2024-07-17 21:39:48
* @Entity com.lxy.communitymanagementsystem.model.entity.Community
*/
public interface CommunityMapper extends BaseMapper<Community> {

    @SelectProvider(type = CommunitySqlProvider.class, method = "listCommunities")
    Page<CommunityDTO> listCommunitiesPage(@Param("page") Page<CommunityDTO> page, @Param("communityDTO") CommunityDTO communityDTO);

    @SelectProvider(type = CommunitySqlProvider.class, method = "listCommunities")
    List<CommunityDTO> listCommunities(@Param("communityDTO") CommunityDTO communityDTO);
}

