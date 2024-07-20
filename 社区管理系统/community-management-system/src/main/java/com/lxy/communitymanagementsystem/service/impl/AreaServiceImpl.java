package com.lxy.communitymanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxy.communitymanagementsystem.model.dto.AreaDTO;
import com.lxy.communitymanagementsystem.model.entity.Area;
import com.lxy.communitymanagementsystem.service.AreaService;
import com.lxy.communitymanagementsystem.mapper.AreaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author AngryYY
* @description 针对表【sys_area(区域表)】的数据库操作Service实现
* @createDate 2024-07-18 22:05:35
*/
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area>
    implements AreaService{
    @Override
    public List<AreaDTO> listAreaDTO() {
        List<Area> listArea = list();
        return listArea.stream().filter(area -> area.getParentid().equals(0)).map(area -> {
            AreaDTO areaDTO = new AreaDTO();
            areaDTO.setCode(area.getCode());
            areaDTO.setName(area.getName());
            areaDTO.setChildren(getChildrenArea(area,listArea));
            return areaDTO;
        }).toList();
    }
    public List<AreaDTO> getChildrenArea(Area parentArea, List<Area> listArea) {
        List<Area> childrenArea = listArea.stream().filter(area -> area.getParentid().equals(parentArea.getCode())).toList();
        if(childrenArea.isEmpty()){
            return null;
        }
        return childrenArea.stream().map(area -> {
            AreaDTO areaDTO = new AreaDTO();
            areaDTO.setCode(area.getCode());
            areaDTO.setName(area.getName());
            areaDTO.setChildren(getChildrenArea(area, listArea));
            return areaDTO;
        }).collect(Collectors.toList());
    }
}




