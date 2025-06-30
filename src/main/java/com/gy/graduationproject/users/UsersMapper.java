package com.gy.graduationproject.users;

import org.apache.ibatis.annotations.*;

//用户信息表的映射接口
@Mapper//声明为映射接口
public interface UsersMapper {

    //根据用户id查询用户信息
    @Select("select * from users where user_id=#{userId}")
    UsersEntity findByUserId(String userId);

    //注册时，向用户信息表插入数据
    @Insert("insert into users (user_id, user_password,user_create_time,user_update_time,user_nickname) " +
            "VALUES (#{userId}, #{userPassword},now(),now(),#{userId})")
    void addUser(String userId, String userPassword);

    //修改用户信息
    @Update("update users set user_nickname=#{userNickname},user_update_time=now() " +
            "where user_id=#{userId}")
    void updateUserNickname(@Param("userId") String userId, @Param("userNickname") String userNickname);

    //修改用户密码
    @Update("update users set user_password=#{newPassword},user_update_time=now() where user_id=#{userId}")
    void updateUserPassword(String userId, String newPassword);
}
