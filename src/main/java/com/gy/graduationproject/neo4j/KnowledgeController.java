package com.gy.graduationproject.neo4j;

import com.gy.graduationproject.Result;
import com.gy.graduationproject.questions.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController//返回json格式数据
@RequestMapping("/knowledge")//请求路径
public class KnowledgeController {
    //注入知识点服务接口
    @Autowired//自动注入
    private KnowledgeService knowledgeService;
    @Autowired
    private QuestionsService questionsService;

    //实现查找所有知识点功能
    @GetMapping("/findAllKnowledge")
    public Result<KnowledgeEntity> findAllKnowledge() {
        List<KnowledgeEntity> knowledge = knowledgeService.findAllKnowledge()
                .stream()
                .filter(k -> !"未分配".equals(k.get名称())) // 去除“未分配”知识点
                .collect(Collectors.toList());
        return new Result(0, "查找成功", knowledge);
    }

    //实现根据关键词查找知识点功能（搜索）
    @GetMapping("/findKnowledgeByKeyword")
    public Result<KnowledgeEntity> findKnowledgeByKeyword(String keyword) {
        List<KnowledgeEntity> knowledge = knowledgeService.findKnowledgeByKeyword(keyword)
                .stream()
                .filter(k -> !"未分配".equals(k.get名称())) // 去除“未分配”知识点
                .collect(Collectors.toList());
        return new Result(0, "查找成功", knowledge);
    }

    //实现创建知识点的功能
    @PostMapping("/createKnowledge")
    public Result<KnowledgeEntity> createKnowledge(String knowledgeName) {
        if (knowledgeName == "") {
            return new Result(1, "新建知识点失败，请输入知识点名称", null);
        }
        KnowledgeEntity knowledge = knowledgeService.findKnowledgeByKnowledgeName(knowledgeName);
        if (knowledge != null) {
            return new Result(1, "新建知识点失败，该知识点已存在", null);
        } else {
            knowledgeService.createKnowledge(knowledgeName);
            return new Result(0, "新建知识点成功", null);
        }
    }

    //实现修改知识点功能
    @PutMapping("/updateKnowledge")
    public Result<KnowledgeEntity> updateKnowledge(@RequestBody Map<String, String> params) {
        String oldKnowledgeName = params.get("oldKnowledgeName");
        String newKnowledgeName = params.get("newKnowledgeName");
        if (Objects.equals(oldKnowledgeName, newKnowledgeName)) {
            return new Result(1, "修改知识点失败，新旧知识点名称相同", null);
        }
        if (newKnowledgeName == "") {
            return new Result(1, "修改知识点失败，请输入知识点名称", null);
        }
        KnowledgeEntity knowledge = knowledgeService.findKnowledgeByKnowledgeName(newKnowledgeName);
        if (knowledge != null) {
            return new Result(1, "修改知识点失败，该知识点已存在", null);
        } else {
            knowledgeService.updateKnowledge(oldKnowledgeName, newKnowledgeName);
            return new Result(0, "修改知识点成功", null);
        }
    }

    //实现删除知识点功能
    @DeleteMapping("/deleteKnowledge")
    public Result<KnowledgeEntity> deleteKnowledge(String knowledgeName) {
        knowledgeService.deleteKnowledge(knowledgeName);
        questionsService.deleteQuestionKnowledge(knowledgeName);//删除知识点时，将对应题目的知识点设为未分配
        return new Result(0, "删除知识点成功", null);
    }
}
