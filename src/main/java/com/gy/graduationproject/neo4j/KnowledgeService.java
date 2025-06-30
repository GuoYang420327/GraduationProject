package com.gy.graduationproject.neo4j;

import java.util.List;

public interface KnowledgeService {

    List<KnowledgeEntity> findAllKnowledge();//查询所有知识点

    KnowledgeEntity findKnowledgeByKnowledgeName(String knowledgeName);//根据知识点名称查询知识点

    List<KnowledgeEntity> findKnowledgeByKeyword(String keyword);//根据关键词查找知识点（搜索）

    void createKnowledge(String knowledgeName);//创建知识点

    void updateKnowledge(String oldKnowledgeName, String newKnowledgeName);//修改知识点功能

    void deleteKnowledge(String knowledgeName);//删除知识点功能
}
