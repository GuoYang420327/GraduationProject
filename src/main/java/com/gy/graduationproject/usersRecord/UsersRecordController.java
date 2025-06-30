package com.gy.graduationproject.usersRecord;

import com.gy.graduationproject.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//用户记录控制器类
@RestController//返回json格式数据
@RequestMapping("/usersRecord")//请求路径
public class UsersRecordController {
    //注入用户记录服务接口
    @Autowired//自动注入
    private UsersRecordService usersRecordService;

    //添加用户记录
    @PostMapping("/createUsersRecord")
    public Result<UsersRecordEntity> createUsersRecord(String userId, String videoName,
                                                       String videoKnowledge, String videoBv,
                                                       String videoP, String videoCover) {
        usersRecordService.createUsersRecord(userId, videoName, videoKnowledge, videoBv, videoP, videoCover);
        return new Result(0, "添加成功", null);
    }

    //根据用户名查询用户记录
    @GetMapping("/findUsersRecordByUserId")
    public Result<UsersRecordEntity> findUsersRecordByUserId(String userId) {
        List<UsersRecordEntity> usersRecordList = usersRecordService.findUsersRecordByUserId(userId);
        return new Result(0, "查询成功", usersRecordList);
    }

}
