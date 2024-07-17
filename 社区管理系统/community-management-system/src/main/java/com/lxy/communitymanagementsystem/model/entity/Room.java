package com.lxy.communitymanagementsystem.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 房间 
 * @TableName assets_room
 */
@TableName(value ="assets_room")
@Data
public class Room implements Serializable {
    /**
     * 房间id
     */
    private Long roomId;

    /**
     * 小区id
     */
    private Long communityId;

    /**
     * 楼栋id
     */
    private Long buildingId;

    /**
     * 单元id
     */
    private Long unitId;

    /**
     * 楼层
     */
    private Integer roomLevel;

    /**
     * 房间编号
     */
    private String roomCode;

    /**
     * 房间名称
     */
    private String roomName;

    /**
     * 房屋建筑面积
     */
    private BigDecimal roomAcreage;

    /**
     * 算费系数
     */
    private BigDecimal roomCost;

    /**
     * 房屋状态
     */
    private String roomStatus;

    /**
     * 是否商铺
     */
    private String roomIsShop;

    /**
     * 是否商品房
     */
    private String roomSCommercialHouse;

    /**
     * 房屋户型
     */
    private String roomHouseType;

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
        Room other = (Room) that;
        return (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getCommunityId() == null ? other.getCommunityId() == null : this.getCommunityId().equals(other.getCommunityId()))
            && (this.getBuildingId() == null ? other.getBuildingId() == null : this.getBuildingId().equals(other.getBuildingId()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getRoomLevel() == null ? other.getRoomLevel() == null : this.getRoomLevel().equals(other.getRoomLevel()))
            && (this.getRoomCode() == null ? other.getRoomCode() == null : this.getRoomCode().equals(other.getRoomCode()))
            && (this.getRoomName() == null ? other.getRoomName() == null : this.getRoomName().equals(other.getRoomName()))
            && (this.getRoomAcreage() == null ? other.getRoomAcreage() == null : this.getRoomAcreage().equals(other.getRoomAcreage()))
            && (this.getRoomCost() == null ? other.getRoomCost() == null : this.getRoomCost().equals(other.getRoomCost()))
            && (this.getRoomStatus() == null ? other.getRoomStatus() == null : this.getRoomStatus().equals(other.getRoomStatus()))
            && (this.getRoomIsShop() == null ? other.getRoomIsShop() == null : this.getRoomIsShop().equals(other.getRoomIsShop()))
            && (this.getRoomSCommercialHouse() == null ? other.getRoomSCommercialHouse() == null : this.getRoomSCommercialHouse().equals(other.getRoomSCommercialHouse()))
            && (this.getRoomHouseType() == null ? other.getRoomHouseType() == null : this.getRoomHouseType().equals(other.getRoomHouseType()))
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
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getCommunityId() == null) ? 0 : getCommunityId().hashCode());
        result = prime * result + ((getBuildingId() == null) ? 0 : getBuildingId().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getRoomLevel() == null) ? 0 : getRoomLevel().hashCode());
        result = prime * result + ((getRoomCode() == null) ? 0 : getRoomCode().hashCode());
        result = prime * result + ((getRoomName() == null) ? 0 : getRoomName().hashCode());
        result = prime * result + ((getRoomAcreage() == null) ? 0 : getRoomAcreage().hashCode());
        result = prime * result + ((getRoomCost() == null) ? 0 : getRoomCost().hashCode());
        result = prime * result + ((getRoomStatus() == null) ? 0 : getRoomStatus().hashCode());
        result = prime * result + ((getRoomIsShop() == null) ? 0 : getRoomIsShop().hashCode());
        result = prime * result + ((getRoomSCommercialHouse() == null) ? 0 : getRoomSCommercialHouse().hashCode());
        result = prime * result + ((getRoomHouseType() == null) ? 0 : getRoomHouseType().hashCode());
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
        sb.append(", roomId=").append(roomId);
        sb.append(", communityId=").append(communityId);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", unitId=").append(unitId);
        sb.append(", roomLevel=").append(roomLevel);
        sb.append(", roomCode=").append(roomCode);
        sb.append(", roomName=").append(roomName);
        sb.append(", roomAcreage=").append(roomAcreage);
        sb.append(", roomCost=").append(roomCost);
        sb.append(", roomStatus=").append(roomStatus);
        sb.append(", roomIsShop=").append(roomIsShop);
        sb.append(", roomSCommercialHouse=").append(roomSCommercialHouse);
        sb.append(", roomHouseType=").append(roomHouseType);
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