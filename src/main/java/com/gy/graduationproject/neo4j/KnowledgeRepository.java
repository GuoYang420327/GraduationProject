package com.gy.graduationproject.neo4j;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//声明为存储库
public interface KnowledgeRepository extends Neo4jRepository<KnowledgeEntity, Long> {
    //根据知识点名称查询知识点
    @Query("MATCH (n:`知识点`) where n.名称=$knowledgeName RETURN n")
    KnowledgeEntity findKnowledgeByKnowledgeName(@Param("knowledgeName") String knowledgeName);

    //根据关键词查找知识点（搜索）
    @Query("MATCH (n:`知识点`) where toLower(n.名称) CONTAINS toLower($keyword) RETURN n")
    List<KnowledgeEntity> findKnowledgeByKeyword(@Param("keyword") String keyword);

    //创建知识点
    @Query("MATCH (c:课程 {名称:'Java语言课程'})" +
            "MERGE(n:`知识点`{名称:$knowledgeName})" +
            "MERGE (c)-[:包含]->(n) ")
    void createKnowledge(@Param("knowledgeName") String knowledgeName);

    //修改知识点功能
    @Query("MATCH (n:`知识点`) where n.名称=$oldKnowledgeName SET n.名称=$newKnowledgeName " +
            "WITH n " +
            "MATCH (v:`视频`)<-[:包含]-(n) " +
            "SET v.知识点 = $newKnowledgeName")
    void updateKnowledge(@Param("oldKnowledgeName") String oldKnowledgeName, @Param("newKnowledgeName") String newKnowledgeName);

    //删除知识点功能
    @Query("MATCH (n:`知识点` {名称: $knowledgeName})-[:包含]->(v:`视频`) " +
            "SET v.知识点 = '未分配' " +
            "WITH n, v " +
            "MATCH (un:`知识点` {名称: '未分配'}) " +
            "MERGE (un)-[:包含]->(v) " +
            "WITH n " +
            "DETACH DELETE n")
    void deleteKnowledge(@Param("knowledgeName") String knowledgeName);
}
