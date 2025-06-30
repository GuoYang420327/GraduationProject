package com.gy.graduationproject.neo4j;

import com.gy.graduationproject.utils.BilibiliCoverFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service//声明为服务层组件
public class VideoServiceImpl implements VideoService {
    //注入用户信息表的映射接口
    @Autowired//自动注入
    private VideoRepository videoRepository;

    //查找所有视频
    @Override//重写
    public List<VideoEntity> findAllVideo() {
        List<VideoEntity> video = videoRepository.findAll();
        return video;
    }

    //根据关键词查找视频（搜索标题）
    @Override
    public List<VideoEntity> findVideoByKeyword(String keyword) {
        List<VideoEntity> video = videoRepository.findVideoByKeyword(keyword);
        return video;
    }

    //根据视频的知识点属性查找视频
    @Override
    public List<VideoEntity> findVideoByKnowledge(String knowledge) {
        List<VideoEntity> video = videoRepository.findVideoByKnowledge(knowledge);
        return video;
    }

    //根据视频名称查找视频
    @Override
    public VideoEntity findVideoByVideoName(String videoName) {
        VideoEntity video = videoRepository.findVideoByVideoName(videoName);
        return video;
    }

    //创建视频
    @Override
    public void createVideo(String videoName, String videoUrl, String videoP, String videoCover, String videoKnowledge) {
        videoRepository.createVideo(videoName, videoUrl, videoP, videoCover, videoKnowledge);
    }

    //修改视频
    @Override
    public void updateVideo(String oldVideoName, String newVideoName, String newVideoUrl, String newVideoP, String newVideoKnowledge, String videoCover) {
        videoRepository.updateVideo(oldVideoName, newVideoName, newVideoUrl, newVideoP, newVideoKnowledge, videoCover);
    }

    //删除视频功能
    @Override
    public void deleteVideo(String videoName) {
        videoRepository.deleteVideo(videoName);
    }
}
