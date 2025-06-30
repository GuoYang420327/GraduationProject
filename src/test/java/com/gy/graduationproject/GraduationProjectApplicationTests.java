package com.gy.graduationproject;

import com.gy.graduationproject.neo4j.VideoEntity;
import com.gy.graduationproject.neo4j.VideoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GraduationProjectApplicationTests {
    @Autowired
    VideoRepository videoRepository;

    @Test
    public void test(){
        List<VideoEntity> aaa = videoRepository.findAll();
        System.out.println(aaa);
    }

}
