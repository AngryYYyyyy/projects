package com.lxy.communitymanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxy.communitymanagementsystem.model.entity.Building;
import com.lxy.communitymanagementsystem.service.BuildingService;
import com.lxy.communitymanagementsystem.mapper.BuildingMapper;
import org.springframework.stereotype.Service;

/**
* @author AngryYY
* @description 针对表【assets_building(楼栋 )】的数据库操作Service实现
* @createDate 2024-07-17 21:42:38
*/
@Service
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building>
    implements BuildingService{
}




