package com.gy.graduationproject.neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//声明为服务层组件
public class KnowledgeServiceImpl implements KnowledgeService {
    //注入用户信息表的映射接口
    @Autowired//自动注入
    private KnowledgeRepository knowledgeRepository;

    //查找所有知识点
    @Override//重写
    public List<KnowledgeEntity> findAllKnowledge() {
        List<KnowledgeEntity> knowledge = knowledgeRepository.findAll();
        return knowledge;
    }

    //根据知识点名称查找知识点
    @Override
    public KnowledgeEntity findKnowledgeByKnowledgeName(String knowledgeName) {
        KnowledgeEntity knowledge = knowledgeRepository.findKnowledgeByKnowledgeName(knowledgeName);
        return knowledge;
    }

    //根据关键词查找知识点（搜索）
    @Override
    public List<KnowledgeEntity> findKnowledgeByKeyword(String keyword) {
        List<KnowledgeEntity> knowledge = knowledgeRepository.findKnowledgeByKeyword(keyword);
        return knowledge;
    }

    //创建知识点
    @Override
    public void createKnowledge(String knowledgeName) {
        knowledgeRepository.createKnowledge(knowledgeName);
    }

    //修改知识点功能
    @Override
    public void updateKnowledge(String oldKnowledgeName, String newKnowledgeName) {
        knowledgeRepository.updateKnowledge(oldKnowledgeName, newKnowledgeName);
    }

    //删除知识点功能
    @Override
    public void deleteKnowledge(String knowledgeName) {
        knowledgeRepository.deleteKnowledge(knowledgeName);
    }
}
