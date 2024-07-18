package com.lxy.communitymanagementsystem.service;

import com.lxy.communitymanagementsystem.model.dto.AreaDTO;
import com.lxy.communitymanagementsystem.model.entity.Area;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author AngryYY
* @description 针对表【sys_area(区域表)】的数据库操作Service
* @createDate 2024-07-18 22:05:35
*/
public interface AreaService extends IService<Area> {
    List<AreaDTO> listAreaDTO() ;

}
