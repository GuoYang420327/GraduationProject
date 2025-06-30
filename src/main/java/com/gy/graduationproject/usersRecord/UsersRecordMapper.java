package com.gy.graduationproject.usersRecord;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//用户记录表的映射接口
@Mapper//声明为映射接口
public interface UsersRecordMapper {
    //添加用户记录
    @Insert("INSERT INTO users_record (user_id, video_name,video_knowledge,video_bv,video_p,video_cover, " +
            "create_time, update_time)" +
            "VALUES (#{userId}, #{videoName},#{videoKnowledge},#{videoBv},#{videoP}, #{videoCover},NOW(), NOW())" +
            "ON DUPLICATE KEY UPDATE " +
            "update_time = NOW()")
    void createUsersRecord(@Param("userId") String userId, @Param("videoName") String videoName,
                           @Param("videoKnowledge") String videoKnowledge, @Param("videoBv") String videoBv,
                           @Param("videoP") String videoP, @Param("videoCover") String videoCover);

    //根据用户名查询用户记录（按更新时间从新到旧排序）
    @Select("SELECT * FROM users_record WHERE user_id = #{userId} " +
            "ORDER BY update_time DESC")
    List<UsersRecordEntity> findUsersRecordByUserId(@Param("userId") String userId);


}
