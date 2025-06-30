package com.gy.graduationproject.neo4j;

import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    List<VideoEntity> findAllVideo();//查询所有视频

    List<VideoEntity> findVideoByKeyword(String keyword);//根据关键词查找视频（搜索标题）

    List<VideoEntity> findVideoByKnowledge(String knowledge);//根据视频的知识点属性查找视频

    VideoEntity findVideoByVideoName(String videoName);//根据视频名称查找视频

    void createVideo(String videoName, String videoUrl, String videoP, String videoCover, String videoKnowledge);//创建视频

    void updateVideo(String oldVideoName, String newVideoName,
                     String newVideoUrl, String newVideoP,
                     String newVideoKnowledge, String videoCover);//修改视频

    void deleteVideo(String videoName);//删除视频功能
}
