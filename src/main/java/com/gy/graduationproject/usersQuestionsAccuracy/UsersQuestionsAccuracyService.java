package com.gy.graduationproject.usersQuestionsAccuracy;

import com.gy.graduationproject.questions.QuestionsEntity;

import java.util.List;
import java.util.Map;

public interface UsersQuestionsAccuracyService {
    List<UsersQuestionsAccuracyEntity> getAccuracyByUserIdAndKnowledge(String userId, String knowledge);//根据知识点获取答题准确率5

    UsersQuestionsAccuracyEntity getAccuracyByUserIdAndKnowledge1(String userId, String knowledge);//根据知识点获取答题准确率1

    void createAccuracy(String userId, String knowledge, int accuracy);//创建用户某知识点的答题准确率（用户答题）
}
