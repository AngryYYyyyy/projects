package com.lxy.communitymanagementsystem.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/18 21:30
 * @Description：
 */
@Data
public class CommunityVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 小区名称
     */
    private String communityName;

    /**
     * 详细地址
     */
    private String communityDetailedAddress;
    /*省区名称*/
    private String communityProvenceName;
    /*市区名称*/
    private String communityCityName;
    /*县区名称*/
    private String communityTownName;

    /**
     * 物业id
     */
    private Long deptId;



    /**
     * 备注
     */
    private String remark;
    /*------------------------------------------------------------*/

}
