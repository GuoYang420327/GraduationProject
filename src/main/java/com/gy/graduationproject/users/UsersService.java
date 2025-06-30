package com.gy.graduationproject.users;

import com.gy.graduationproject.users.UsersEntity;


//用户服务接口
public interface UsersService {
    UsersEntity findByUserId(String userId);//根据用户id查询用户信息

    void register(String userId, String userPassword);//注册时，向用户信息表插入数据

    void updateUserNickname(String userId, String userNickname);//修改用户昵称

    void updateUserPassword(String UserId, String newPassword);//修改用户密码
}
