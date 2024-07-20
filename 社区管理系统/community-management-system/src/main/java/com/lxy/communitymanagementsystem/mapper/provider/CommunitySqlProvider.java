package com.lxy.communitymanagementsystem.mapper.provider;

import com.lxy.communitymanagementsystem.model.dto.CommunityDTO;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/21 0:18
 * @Description：
 */
public class CommunitySqlProvider {
    public String listCommunities(CommunityDTO communityDTO) {
        return new SQL() {{
            SELECT("ac.*, ap.name as province_name, ac2.name as city_name, at.name as town_name");
            FROM("assets_community ac");
            LEFT_OUTER_JOIN("sys_area ap ON ac.community_province_code = ap.code");
            LEFT_OUTER_JOIN("sys_area ac2 ON ac.community_city_code = ac2.code");
            LEFT_OUTER_JOIN("sys_area at ON ac.community_town_code = at.code");
            if(communityDTO != null) {
                if (communityDTO.getCommunityName() != null && !communityDTO.getCommunityName().isEmpty()) {
                    WHERE("ac.community_name = #{communityDTO.communityName}");
                }
                if (communityDTO.getCommunityCode() != null && !communityDTO.getCommunityCode().isEmpty()) {
                    WHERE("ac.community_code = #{communityDTO.communityCode}");
                }
                if (communityDTO.getSortOrder() != null && !communityDTO.getSortOrder().isEmpty()) {
                    ORDER_BY("ac.community_sort " + communityDTO.getSortOrder());
                }
            }
        }}.toString();
    }
}
