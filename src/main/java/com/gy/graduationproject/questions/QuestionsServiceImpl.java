package com.gy.graduationproject.questions;

import com.gy.graduationproject.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service//声明为服务层组件
public class QuestionsServiceImpl implements QuestionsService {
    @Autowired//自动注入
    private QuestionsMapper QuestionsMapper;

    //根据知识点获取题目
    @Override
    public List<QuestionsEntity> getQuestionsByKnowledge(String knowledge) {
        List<QuestionsEntity> questionsList = QuestionsMapper.getQuestionsByKnowledge(knowledge);
        return questionsList;
    }

    //新建题目
    @Override
    public void addQuestion(String questionKnowledge, String question,
                            String answerA, String answerB, String answerC, String answerD,
                            String rightAnswer, String analysis) {
        QuestionsMapper.addQuestion(questionKnowledge, question,
                answerA, answerB, answerC, answerD,
                rightAnswer, analysis);
    }

    //修改题目
    @Override
    public void updateQuestion(String id, String questionKnowledge, String question,
                               String answerA, String answerB, String answerC, String answerD,
                               String rightAnswer, String analysis) {
        QuestionsMapper.updateQuestion(id, questionKnowledge, question,
                answerA, answerB, answerC, answerD,
                rightAnswer, analysis);
    }

    //删除题目
    @Override
    public void deleteQuestion(String id) {
        QuestionsMapper.deleteQuestion(id);
    }

    //删除知识点时，将对应题目的知识点设为未分配
    @Override
    public void deleteQuestionKnowledge(String questionKnowledge) {
        QuestionsMapper.deleteQuestionKnowledge(questionKnowledge);
    }


}
