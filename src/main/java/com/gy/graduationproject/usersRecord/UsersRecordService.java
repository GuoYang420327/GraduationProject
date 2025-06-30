package com.gy.graduationproject.usersRecord;

import java.util.List;

//用户记录服务接口
public interface UsersRecordService {
    void createUsersRecord(String userId, String videoName,
                           String videoKnowledge, String videoBv,
                           String videoP, String videoCover);//添加用户记录

    List<UsersRecordEntity> findUsersRecordByUserId(String userId);//根据用户名查询用户记录

}
