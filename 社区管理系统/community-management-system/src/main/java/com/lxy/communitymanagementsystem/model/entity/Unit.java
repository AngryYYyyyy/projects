package com.lxy.communitymanagementsystem.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 单元 
 * @TableName assets_unit
 */
@TableName(value ="assets_unit")
@Data
public class Unit implements Serializable {
    /**
     * 单元id
     */
    @TableId
    private Long unitId;

    /**
     * 小区id
     */
    private Long communityId;

    /**
     * 楼栋id
     */
    private Long buildingId;

    /**
     * 单元名称
     */
    private String unitName;

    /**
     * 单元编号
     */
    private String unitCode;

    /**
     * 层数
     */
    private Integer unitLevel;

    /**
     * 建筑面积
     */
    private BigDecimal unitAcreage;

    /**
     * 是否有电梯
     */
    private String unitHaveElevator;

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
        Unit other = (Unit) that;
        return (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getBuildingId() == null ? other.getBuildingId() == null : this.getBuildingId().equals(other.getBuildingId()))
            && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
            && (this.getUnitCode() == null ? other.getUnitCode() == null : this.getUnitCode().equals(other.getUnitCode()))
            && (this.getUnitLevel() == null ? other.getUnitLevel() == null : this.getUnitLevel().equals(other.getUnitLevel()))
            && (this.getUnitAcreage() == null ? other.getUnitAcreage() == null : this.getUnitAcreage().equals(other.getUnitAcreage()))
            && (this.getUnitHaveElevator() == null ? other.getUnitHaveElevator() == null : this.getUnitHaveElevator().equals(other.getUnitHaveElevator()))
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
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getBuildingId() == null) ? 0 : getBuildingId().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getUnitCode() == null) ? 0 : getUnitCode().hashCode());
        result = prime * result + ((getUnitLevel() == null) ? 0 : getUnitLevel().hashCode());
        result = prime * result + ((getUnitAcreage() == null) ? 0 : getUnitAcreage().hashCode());
        result = prime * result + ((getUnitHaveElevator() == null) ? 0 : getUnitHaveElevator().hashCode());
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
        sb.append(", unitId=").append(unitId);
        sb.append(", communityId=").append(communityId);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", unitName=").append(unitName);
        sb.append(", unitCode=").append(unitCode);
        sb.append(", unitLevel=").append(unitLevel);
        sb.append(", unitAcreage=").append(unitAcreage);
        sb.append(", unitHaveElevator=").append(unitHaveElevator);
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