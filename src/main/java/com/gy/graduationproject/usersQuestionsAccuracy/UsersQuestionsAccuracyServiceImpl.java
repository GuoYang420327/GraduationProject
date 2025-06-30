package com.gy.graduationproject.usersQuestionsAccuracy;

import com.gy.graduationproject.questions.QuestionsEntity;
import com.gy.graduationproject.questions.QuestionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service//声明为服务层组件
public class UsersQuestionsAccuracyServiceImpl implements UsersQuestionsAccuracyService {
    @Autowired//自动注入
    private UsersQuestionsAccuracyMapper usersQuestionsAccuracyMapper;

    //根据知识点获取答题准确率5
    @Override
    public List<UsersQuestionsAccuracyEntity> getAccuracyByUserIdAndKnowledge(String userId, String knowledge) {
        List<UsersQuestionsAccuracyEntity> accuracy = usersQuestionsAccuracyMapper.getAccuracyByUserIdAndKnowledge(userId, knowledge);
        return accuracy;
    }

    //根据知识点获取答题准确率1
    @Override
    public UsersQuestionsAccuracyEntity getAccuracyByUserIdAndKnowledge1(String userId, String knowledge) {
        UsersQuestionsAccuracyEntity accuracy = usersQuestionsAccuracyMapper.getAccuracyByUserIdAndKnowledge1(userId, knowledge);
        return accuracy;
    }

    //创建用户某知识点的答题准确率（用户答题）
    @Override
    public void createAccuracy(String userId, String knowledge, int accuracy) {
        usersQuestionsAccuracyMapper.createAccuracy(userId, knowledge, accuracy);
    }


}
