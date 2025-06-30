package com.gy.graduationproject.questions;

import com.gy.graduationproject.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//题目控制器类
@RestController//返回json格式数据
@RequestMapping("/questions")//请求路径
public class QuestionsController {
    @Autowired//自动注入
    private QuestionsService questionsService;

    //根据知识点获取题目
    @GetMapping("/getQuestionsByKnowledge")
    public Result<QuestionsEntity> getQuestionsByKnowledge(String knowledge) {
        List<QuestionsEntity> questionsList = questionsService.getQuestionsByKnowledge(knowledge);
        return new Result(0, "题目获取成功", questionsList);
    }

    //新建题目
    @PostMapping("/addQuestion")
    public Result<QuestionsEntity> addQuestion(String questionKnowledge, String question,
                                               String answerA, String answerB, String answerC, String answerD,
                                               String rightAnswer, String analysis) {
        if (questionKnowledge == "" || question == "" || answerA == "" || answerB == "" || answerC == "" || answerD == ""
                || rightAnswer == "" || analysis == "") {
            return new Result(1, "请填写完整题目信息", null);
        }
        questionsService.addQuestion(questionKnowledge, question,
                answerA, answerB, answerC, answerD,
                rightAnswer, analysis);
        return new Result(0, "题目添加成功", null);
    }

    //修改题目
    @PutMapping("/updateQuestion")
    public Result<QuestionsEntity> updateQuestion(@RequestBody Map<String, String> params) {
        String id = params.get("id");
        String questionKnowledge = params.get("questionKnowledge");
        String question = params.get("question");
        String answerA = params.get("answerA");
        String answerB = params.get("answerB");
        String answerC = params.get("answerC");
        String answerD = params.get("answerD");
        String rightAnswer = params.get("rightAnswer");
        String analysis = params.get("analysis");
        if (questionKnowledge == "" || question == "" ||
                answerA == "" || answerB == "" || answerC == "" || answerD == "" ||
                rightAnswer == "" || analysis == "") {
            return new Result(1, "请填写完整题目信息", null);
        }
        questionsService.updateQuestion(id, questionKnowledge, question,
                answerA, answerB, answerC, answerD,
                rightAnswer, analysis);
        return new Result(0, "题目修改成功", null);
    }

    //删除题目
    @DeleteMapping("/deleteQuestion")
    public Result<QuestionsEntity> deleteQuestion(String id) {
        questionsService.deleteQuestion(id);
        return new Result(0, "题目删除成功", null);
    }
}
