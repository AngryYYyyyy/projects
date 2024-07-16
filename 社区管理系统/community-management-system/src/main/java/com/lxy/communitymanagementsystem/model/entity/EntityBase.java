package com.lxy.communitymanagementsystem.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 实体基类，所有实体类的通用字段和方法都在这里定义。
 * 用于提供数据表记录的基础字段如创建者、创建时间等。
 *
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/16 21:57
 * @Description：基础实体类，包含实体共有的属性和配置。
 */
public class EntityBase implements Serializable {
    private static final long serialVersionUID = 1L;  // 序列化ID，用于实体类的版本控制。

    /**
     * 搜索值，用于存储临时的搜索条件或关键字，不持久化到数据库。
     * @TableField(exist = false) 表明这个字段不是数据库表的列，仅用于业务逻辑。
     */
    @TableField(exist = false)
    private String searchValue;

    /**
     * 创建者，记录数据创建人的用户标识，仅在插入数据时自动填充。
     * @TableField(fill = FieldFill.INSERT) 插入时填充字段。
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间，记录数据的创建时间，仅在插入数据时自动填充。
     * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 指定日期时间格式。
     * @TableField(fill = FieldFill.INSERT) 插入数据时自动填充。
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新者，记录最后修改数据的用户标识，仅在更新数据时自动填充。
     * @TableField(fill = FieldFill.UPDATE) 更新数据时填充字段。
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

    /**
     * 更新时间，记录数据的最后更新时间，仅在更新数据时自动填充。
     * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 指定日期时间格式。
     * @TableField(fill = FieldFill.UPDATE) 更新数据时自动填充。
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 备注信息，用于存储备注或额外信息。
     */
    private String remark;

    /**
     * 请求参数，用于传递不固定的参数值，方便扩展功能，不持久化到数据库。
     * @TableField(exist = false) 表明这个字段不是数据库表的列，仅用于业务逻辑。
     */
    @TableField(exist = false)
    private Map<String, Object> params;
}