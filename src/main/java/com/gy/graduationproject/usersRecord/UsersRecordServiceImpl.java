package com.gy.graduationproject.usersRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//用户记录服务实现类
@Service//声明为服务层组件
public class UsersRecordServiceImpl implements UsersRecordService {
    //注入用户信息表的映射接口
    @Autowired//自动注入
    private UsersRecordMapper usersRecordMapper;

    //添加用户记录
    @Override
    public void createUsersRecord(String userId, String videoName,
                                  String videoKnowledge, String videoBv,
                                  String videoP, String videoCover) {
        usersRecordMapper.createUsersRecord(userId, videoName, videoKnowledge, videoBv, videoP, videoCover);
    }

    //根据用户名查询用户记录
    @Override
    public List<UsersRecordEntity> findUsersRecordByUserId(String userId) {
        List<UsersRecordEntity> usersRecordList = usersRecordMapper.findUsersRecordByUserId(userId);
        return usersRecordList;
    }


}
