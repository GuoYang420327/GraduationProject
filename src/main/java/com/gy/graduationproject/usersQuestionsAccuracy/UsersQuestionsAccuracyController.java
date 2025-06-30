package com.gy.graduationproject.usersQuestionsAccuracy;

import com.gy.graduationproject.Result;
import com.gy.graduationproject.questions.QuestionsEntity;
import com.gy.graduationproject.questions.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//题目控制器类
@RestController//返回json格式数据
@RequestMapping("/usersQuestionsAccuracy")//请求路径
public class UsersQuestionsAccuracyController {
    @Autowired//自动注入
    private UsersQuestionsAccuracyService usersQuestionsAccuracyService;

    //获取用户某知识点的答题准确率
    @GetMapping("/getAccuracyByUserIdAndKnowledge")
    public Result<UsersQuestionsAccuracyEntity> getAccuracyByUserIdAndKnowledge(String userId, String knowledge) {
        List<UsersQuestionsAccuracyEntity> accuracy = usersQuestionsAccuracyService.getAccuracyByUserIdAndKnowledge(userId, knowledge);
        return new Result(0, "正确率获取成功", accuracy);
    }

    //创建用户某知识点的答题准确率（用户答题）
    @PostMapping("/createAccuracy")
    public Result<UsersQuestionsAccuracyEntity> createAccuracy(String userId, String knowledge, Integer accuracy) {
        usersQuestionsAccuracyService.createAccuracy(userId, knowledge, accuracy);
        return new Result(0, "正确率创建成功", null);
    }

}
