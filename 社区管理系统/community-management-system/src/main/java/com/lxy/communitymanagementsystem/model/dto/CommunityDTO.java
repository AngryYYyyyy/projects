package com.lxy.communitymanagementsystem.model.dto;



import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 22:09
 * @Description：
 */
@Data
public class CommunityDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 小区id
     */
    private Long communityId;

    /**
     * 小区名称
     */
    private String communityName;

    /**
     * 小区编码
     */
    private String communityCode;

    /**
     * 省区划码
     */
    private String communityProvinceCode;

    /**
     * 市区划码
     */
    private String communityCityCode;

    /**
     * 区县区划码
     */
    private String communityTownCode;

    /**
     * 详细地址
     */
    private String communityDetailedAddress;

    /**
     * 经度
     */
    private String communityLongitude;

    /**
     * 纬度
     */
    private String communityLatitude;

    /**
     * 物业id
     */
    private Long deptId;

    /**
     * 排序
     */
    private Integer communitySort;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;
    /*------------------------------------------------------------*/

    /*省区名称*/
    private String provinceName;
    /*市区名称*/
    private String cityName;
    /*县区名称*/
    private String townName;
    /*排序顺序*/
    private String sortOrder;
    /*------------------------------------------------------------*/
    private Integer current;
    private Integer size;
}
