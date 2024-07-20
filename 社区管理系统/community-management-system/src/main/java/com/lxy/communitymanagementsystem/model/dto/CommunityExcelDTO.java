package com.lxy.communitymanagementsystem.model.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.Date;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/19 0:13
 * @Description：
 */
@ExcelTarget("community")
@Data
public class CommunityExcelDTO {

    @Excel(name = "小区名称", orderNum = "1")
    private String communityName;

    @Excel(name = "小区编码", orderNum = "2")
    private String communityCode;

    @Excel(name = "省", orderNum = "3")
    private String communityProvinceName;

    @Excel(name = "市", orderNum = "4")
    private String communityCityName;

    @Excel(name = "区/县", orderNum = "5")
    private String communityTownName;

    @Excel(name = "详细地址", orderNum = "6")
    private String communityDetailedAddress;

    @Excel(name = "省区划码", orderNum = "7")
    private String communityProvinceCode;

    @Excel(name = "市区划码", orderNum = "8")
    private String communityCityCode;

    @Excel(name = "区县区划码", orderNum = "9")
    private String communityTownCode;

    @Excel(name = "创建时间", exportFormat = "yyyy年MM月dd日", orderNum = "10")
    private Date createTime;

    @Excel(name = "备注", orderNum = "11")
    private String remark;
}

