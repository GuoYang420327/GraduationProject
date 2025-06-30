package com.gy.graduationproject.neo4j;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//声明为存储库
public interface VideoRepository extends Neo4jRepository<VideoEntity, Long> {
    //实现根据关键词查找视频功能（搜索标题）（按标题排序）
    @Query("MATCH (n:`视频`) where toLower(n.标题) CONTAINS toLower($keyword) RETURN n ORDER BY n.标题")
    List<VideoEntity> findVideoByKeyword(@Param("keyword") String keyword);

    //实现根据视频的知识点属性查找视频的功能（按标题排序）
    @Query("MATCH (n:`视频`) where n.知识点=$knowledge RETURN n ORDER BY n.标题")
    List<VideoEntity> findVideoByKnowledge(@Param("knowledge") String knowledge);

    //实现根据视频名称查找视频的功能
    @Query("MATCH (n:`视频`) where n.标题=$videoName RETURN n")
    VideoEntity findVideoByVideoName(@Param("videoName") String videoName);

    //实现创建视频功能
    @Query("MERGE (n:`视频`{标题:$videoName,地址:$videoUrl,分P:$videoP,封面:$videoCover,知识点:$videoKnowledge}) " +
            "WITH n " +
            "MATCH (z:`知识点`{名称:$videoKnowledge}) " +
            "MERGE (z)-[:包含]->(n)")
    void createVideo(@Param("videoName") String videoName, @Param("videoUrl") String videoUrl,
                     @Param("videoP") String videoP, @Param("videoCover") String videoCover,
                     @Param("videoKnowledge") String videoKnowledge);

    //实现修改视频功能
    @Query("MATCH (v:`视频` {标题:$oldVideoName}) " +
            "WITH v, v.知识点 AS oldKnowledge " +
            "MATCH (zOld:`知识点` {名称:oldKnowledge}) " +
            "OPTIONAL MATCH (zOld)-[r:包含]->(v) " +
            "DELETE r " +
            "WITH v " +
            "SET v.标题 = $newVideoName, " +
            "v.地址 = $newVideoUrl, " +
            "v.分P = $newVideoP, " +
            "v.封面 = $videoCover, " +
            "v.知识点 = $newVideoKnowledge " +
            "WITH v " +
            "MATCH (zNew:`知识点` {名称:$newVideoKnowledge}) " +
            "MERGE (zNew)-[:包含]->(v)")
    void updateVideo(@Param("oldVideoName") String oldVideoName, @Param("newVideoName") String newVideoName,
                     @Param("newVideoUrl") String newVideoUrl, @Param("newVideoP") String newVideoP,
                     @Param("newVideoKnowledge") String newVideoKnowledge, @Param("videoCover") String videoCover);

    //删除视频功能
    @Query("MATCH (v:`视频` {标题:$videoName}) " +
            "DETACH DELETE v")
    void deleteVideo(@Param("videoName") String videoName);
}
