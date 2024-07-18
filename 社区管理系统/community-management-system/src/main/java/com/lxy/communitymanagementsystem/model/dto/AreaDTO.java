package com.lxy.communitymanagementsystem.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/18 22:06
 * @Description：
 */
@Data
public class AreaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 城市编码
     */
    private Integer code;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 子城市
     */
    private List<AreaDTO> children;
}
