package com.lxy.communitymanagementsystem.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 小区 
 * @TableName assets_community
 */
@TableName(value ="assets_community")
@Data
public class Community implements Serializable {
    /**
     * 小区id
     */
    @TableId
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Community other = (Community) that;
        return (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getCommunityName() == null ? other.getCommunityName() == null : this.getCommunityName().equals(other.getCommunityName()))
            && (this.getCommunityCode() == null ? other.getCommunityCode() == null : this.getCommunityCode().equals(other.getCommunityCode()))
            && (this.getCommunityProvinceCode() == null ? other.getCommunityProvinceCode() == null : this.getCommunityProvinceCode().equals(other.getCommunityProvinceCode()))
            && (this.getCommunityCityCode() == null ? other.getCommunityCityCode() == null : this.getCommunityCityCode().equals(other.getCommunityCityCode()))
            && (this.getCommunityTownCode() == null ? other.getCommunityTownCode() == null : this.getCommunityTownCode().equals(other.getCommunityTownCode()))
            && (this.getCommunityDetailedAddress() == null ? other.getCommunityDetailedAddress() == null : this.getCommunityDetailedAddress().equals(other.getCommunityDetailedAddress()))
            && (this.getCommunityLongitude() == null ? other.getCommunityLongitude() == null : this.getCommunityLongitude().equals(other.getCommunityLongitude()))
            && (this.getCommunityLatitude() == null ? other.getCommunityLatitude() == null : this.getCommunityLatitude().equals(other.getCommunityLatitude()))
            && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getCommunitySort() == null ? other.getCommunitySort() == null : this.getCommunitySort().equals(other.getCommunitySort()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getCommunityName() == null) ? 0 : getCommunityName().hashCode());
        result = prime * result + ((getCommunityCode() == null) ? 0 : getCommunityCode().hashCode());
        result = prime * result + ((getCommunityProvinceCode() == null) ? 0 : getCommunityProvinceCode().hashCode());
        result = prime * result + ((getCommunityCityCode() == null) ? 0 : getCommunityCityCode().hashCode());
        result = prime * result + ((getCommunityTownCode() == null) ? 0 : getCommunityTownCode().hashCode());
        result = prime * result + ((getCommunityDetailedAddress() == null) ? 0 : getCommunityDetailedAddress().hashCode());
        result = prime * result + ((getCommunityLongitude() == null) ? 0 : getCommunityLongitude().hashCode());
        result = prime * result + ((getCommunityLatitude() == null) ? 0 : getCommunityLatitude().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getCommunitySort() == null) ? 0 : getCommunitySort().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", communityId=").append(communityId);
        sb.append(", communityName=").append(communityName);
        sb.append(", communityCode=").append(communityCode);
        sb.append(", communityProvinceCode=").append(communityProvinceCode);
        sb.append(", communityCityCode=").append(communityCityCode);
        sb.append(", communityTownCode=").append(communityTownCode);
        sb.append(", communityDetailedAddress=").append(communityDetailedAddress);
        sb.append(", communityLongitude=").append(communityLongitude);
        sb.append(", communityLatitude=").append(communityLatitude);
        sb.append(", deptId=").append(deptId);
        sb.append(", communitySort=").append(communitySort);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}