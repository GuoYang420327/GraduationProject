package com.gy.graduationproject.questions;

import com.gy.graduationproject.Result;

import java.util.List;
import java.util.Map;

public interface QuestionsService {
    List<QuestionsEntity> getQuestionsByKnowledge(String knowledge);//根据知识点获取题目

    void addQuestion(String questionKnowledge, String question,
                     String answerA, String answerB, String answerC, String answerD,
                     String rightAnswer, String analysis);//新建题目

    void updateQuestion(String id, String questionKnowledge, String question,
                        String answerA, String answerB, String answerC, String answerD,
                        String rightAnswer, String analysis);//修改题目

    void deleteQuestion(String id);//删除题目

    void deleteQuestionKnowledge(String questionKnowledge);//删除知识点时，将对应题目的知识点设为未分配
}
