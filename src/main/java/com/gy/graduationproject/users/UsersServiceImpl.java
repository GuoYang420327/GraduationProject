package com.gy.graduationproject.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//用户服务实现类
@Service//声明为服务层组件
public class UsersServiceImpl implements UsersService {
    //注入用户信息表的映射接口
    @Autowired//自动注入
    private UsersMapper usersMapper;

    //根据用户id查询用户信息
    @Override//重写
    public UsersEntity findByUserId(String userId) {
        UsersEntity user = usersMapper.findByUserId(userId);
        return user;
    }

    //注册时，向用户信息表插入数据
    @Override//重写
    public void register(String userId, String userPassword) {
        usersMapper.addUser(userId, userPassword);
    }

    //修改用户昵称
    @Override//重写
    public void updateUserNickname(String userId, String userNickname) {
        usersMapper.updateUserNickname(userId, userNickname);
    }

    //修改用户密码
    @Override//重写
    public void updateUserPassword(String userId, String newPassword) {
        usersMapper.updateUserPassword(userId, newPassword);
    }

}
