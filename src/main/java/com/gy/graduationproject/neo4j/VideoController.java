package com.gy.graduationproject.neo4j;

import com.gy.graduationproject.Result;
import com.gy.graduationproject.usersQuestionsAccuracy.UsersQuestionsAccuracyEntity;
import com.gy.graduationproject.usersQuestionsAccuracy.UsersQuestionsAccuracyService;
import com.gy.graduationproject.usersRecord.UsersRecordEntity;
import com.gy.graduationproject.usersRecord.UsersRecordService;
import com.gy.graduationproject.utils.BilibiliCoverFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

@RestController//返回json格式数据
@RequestMapping("/video")//请求路径
public class VideoController {
    //注入视频服务接口
    @Autowired//自动注入
    private VideoService videoService;
    @Autowired
    private KnowledgeService knowledgeService;
    @Autowired
    private UsersQuestionsAccuracyService usersQuestionsAccuracyService;
    @Autowired
    private UsersRecordService usersRecordService;

    //实现查找所有视频功能
    @GetMapping("/findAllVideo")
    public Result<VideoEntity> findAllVideo() {
        List<VideoEntity> video = videoService.findAllVideo();
        return new Result(0, "查找成功", video);
    }

    //实现根据关键词查找视频功能（搜索标题）
    @GetMapping("/findVideoByKeyword")
    public Result<VideoEntity> findVideoByKeyword(String keyword) {
        List<VideoEntity> video = videoService.findVideoByKeyword(keyword);
        return new Result(0, "查找成功", video);
    }

    //实现根据视频的知识点属性查找视频的功能
    @GetMapping("/findVideoByKnowledge")
    public Result<VideoEntity> findVideoByKnowledge(String knowledge) {
        List<VideoEntity> video = videoService.findVideoByKnowledge(knowledge);
        return new Result(0, "查找成功", video);
    }

    //实现根据视频名称查找视频的功能
    @GetMapping("/findVideoByVideoName")
    public Result<VideoEntity> findVideoByVideoName(String videoName) {
        VideoEntity video = videoService.findVideoByVideoName(videoName);
        return new Result(0, "查找成功", video);
    }

    //实现新建视频的功能
    @PostMapping("/createVideo")
    public Result<VideoEntity> createVideo(String videoName, String videoUrl, String videoP, String videoKnowledge) throws IOException {
        if (videoName == "" || videoUrl == "" || videoP == "" || videoKnowledge == "") {
            return new Result(1, "新建视频失败，请输入完整信息", null);
        } else {
            VideoEntity video = videoService.findVideoByVideoName(videoName);
            if (video != null) {
                return new Result(1, "新建视频失败，该视频标题已存在", null);
            } else {
                String videoCover = BilibiliCoverFetcher.getCoverUrl(videoUrl);//获取视频封面
                if (videoCover != null) {
                    videoService.createVideo(videoName, videoUrl, videoP, videoCover, videoKnowledge);
                    return new Result(0, "新建视频成功", null);
                } else {
                    return new Result(1, "新建视频失败，视频链接无效", null);
                }
            }
        }
    }

    //实现修改视频功能
    @PutMapping("/updateVideo")
    public Result<VideoEntity> updateVideo(@RequestBody Map<String, String> params) throws IOException {
        String oldVideoName = params.get("oldVideoName");
        String newVideoName = params.get("newVideoName");
        String newVideoUrl = params.get("newVideoUrl");
        String newVideoP = params.get("newVideoP");
        String newVideoKnowledge = params.get("newVideoKnowledge");
        if (newVideoName == "" || newVideoUrl == "" || newVideoP == "" || newVideoKnowledge == "") {
            return new Result(1, "修改视频失败，请输入完整信息", null);
        }
        String videoCover = BilibiliCoverFetcher.getCoverUrl(newVideoUrl);//获取视频封面
        if (videoCover == null) {
            return new Result(1, "修改视频失败，视频链接无效", null);
        }
        videoService.updateVideo(oldVideoName, newVideoName, newVideoUrl, newVideoP, newVideoKnowledge, videoCover);
        return new Result(0, "修改视频成功", null);
    }

    //实现删除视频功能
    @DeleteMapping("/deleteVideo")
    public Result<VideoEntity> deleteVideo(String videoName) {
        videoService.deleteVideo(videoName);
        return new Result(0, "删除视频成功", null);
    }

    //实现推荐视频算法
    @GetMapping("/recommendVideo")
    public Result<VideoEntity> recommendVideo(String userId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //  获取所有视频video
        List<VideoEntity> video = videoService.findVideoByKeyword("");

        // 获取所有知识点信息knowledge1
        List<KnowledgeEntity> knowledge = knowledgeService.findAllKnowledge()
                .stream()
                .filter(k -> !"未分配".equals(k.get名称())) // 去除“未分配”知识点
                .collect(Collectors.toList());
        // 为每个知识点添加准确率
        List<Map<String, Object>> knowledge1 = knowledge.stream()
                .map(k -> {
                    // 查询每个知识点的准确率
                    UsersQuestionsAccuracyEntity accuracy = usersQuestionsAccuracyService
                            .getAccuracyByUserIdAndKnowledge1(userId, k.get名称());
                    // 查询该知识点对应的视频数量
                    int videoCount = videoService.findVideoByKnowledge(k.get名称()).size();
                    // 构建合并后的对象
                    Map<String, Object> map = new HashMap<>();
                    map.put("名称", k.get名称());
                    map.put("正确率", accuracy != null ? accuracy.getAccuracy() : null);
                    map.put("视频数量", videoCount); // 新增视频数量字段
                    return map;
                })
                .collect(Collectors.toList());

        //获取视频观看记录usersRecordList1
        List<UsersRecordEntity> usersRecordList = usersRecordService.findUsersRecordByUserId(userId);
        List<Map<String, Object>> usersRecordList1 = usersRecordList.stream()
                .map(record -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("videoName", record.getVideoName());
                    map.put("videoKnowledge", record.getVideoKnowledge());
                    map.put("updateTime", record.getUpdateTime().format(formatter));
                    return map;
                })
                .collect(Collectors.toList());

        /*算法维度说明
        1.知识点薄弱程度（40%）
            计算公式：(100 - 准确率) * 0.40
            准确率越低得分越高，优先推荐薄弱知识点视频
            未测试知识点默认赋予60分基础值（60 * 0.40）
        2.学习连贯性（25%）
            计算公式：(单知识点已观看数量 / 单知识点总视频数量) * 100 * 0.25
            根据该知识点已观看的视频数量占该知识点的所有视频数量的比例，动态调整分数，观看数量占比越多分数越高
            鼓励用户系统学习同一知识体系
        3.知识点覆盖完整性（10%）
            检测该知识点是否存在未观看视频
            存在未观看视频时赋予60分，否则20分
            促进用户完成知识点的全面学习
        4.知识点学习时效性（10%）
            计算该视频所在知识点最近一次学习的记录至今的天数
            计算公式：(100 - Math.min(间隔天数*10, 100)) * 0.10
            未学习过的知识点默认赋予60分基础值（60 * 0.10）
        5.视频学习时效性（10%）
            计算该视频最近一次学习的记录至今的天数
            计算公式：(100 - Math.min(间隔天数*10, 100)) * 0.10
            未学习过的知识点默认赋予60分基础值（60 * 0.10）
        6.防重复机制（5%）
            简单判断是否已观看
            未观看视频直接加5分*/

        // ===== 推荐算法 =====
        // 构建知识点-准确率映射
        Map<String, Integer> knowledgeAccuracy = knowledge1.stream()
                .collect(Collectors.toMap(
                        k -> (String)k.get("名称"),
                        k -> (Integer)k.get("正确率") != null ? (Integer)k.get("正确率") : -1
                ));

        // 构建知识点-视频总量映射
        Map<String, Integer> knowledgeVideoCountMap = knowledge1.stream()
                .collect(Collectors.toMap(
                        k -> (String)k.get("名称"),
                        k -> (Integer)k.get("视频数量")
                ));

        // 构建已观看视频集合
        Set<String> watchedVideos = usersRecordList1.stream()
                .map(r -> (String)r.get("videoName"))
                .collect(Collectors.toSet());

        // 视频评分计算
        List<VideoEntity> recommendedVideos = video.stream()
                .map(v -> {
                    // 计算各维度评分
                    double score = 0;
                    String knowledgePoint = v.get知识点();

                    // 1. 知识点薄弱程度（40%）
                    int accuracy = knowledgeAccuracy.getOrDefault(knowledgePoint, -1);
                    if (accuracy >= 0) {
                        score += (100 - accuracy) * 0.40;
                    } else {
                        score += 60 * 0.40; // 未测试知识点基础分
                    }

                    // 2. 学习连贯性（25%）
                    long sameKnowledgeCount = usersRecordList1.stream()
                            .filter(r -> r.get("videoKnowledge").equals(knowledgePoint))
                            .count();//  相同知识点已观看的视频数量
                    int totalVideos = knowledgeVideoCountMap.get(knowledgePoint); // 该知识点的视频总数
                    double watchedRatio = (double) sameKnowledgeCount / totalVideos;
                    score += watchedRatio * 100 * 0.25; // 按比例分配25%权重

                    // 3. 知识点覆盖完整性（10%）
                    boolean hasUnwatched = video.stream()
                            .anyMatch(vv -> vv.get知识点().equals(knowledgePoint)
                                    && !watchedVideos.contains(vv.get标题()));
                    score += (hasUnwatched ? 60 : 20) * 0.10;

                    // 4. 知识点学习时效性（10%）
                    Optional<Map<String, Object>> latestRecord = usersRecordList1.stream()
                            .filter(r -> r.get("videoKnowledge").equals(knowledgePoint))
                            .max(Comparator.comparing(r -> LocalDateTime.parse(
                                    (String)r.get("updateTime"), formatter)));
                    if (latestRecord.isPresent()) {
                        long days = ChronoUnit.DAYS.between(
                                LocalDateTime.parse(latestRecord.get().get("updateTime").toString(), formatter),
                                LocalDateTime.now()
                        );
                        score += (100 - Math.min(days*10, 100)) * 0.10;
                    } else {
                        score += 60 * 0.10;
                    }

                    // 5. 视频学习时效性（10%）
                    Optional<LocalDateTime> videoLatestWatch = usersRecordList1.stream()
                            .filter(r -> r.get("videoName").equals(v.get标题()))
                            .map(r -> LocalDateTime.parse((String)r.get("updateTime"), formatter))
                            .max(LocalDateTime::compareTo);

                    if (videoLatestWatch.isPresent()) {
                        long days = ChronoUnit.DAYS.between(videoLatestWatch.get(), LocalDateTime.now());
                        score += (100 - Math.min(days*10, 100)) * 0.10;
                    } else {
                        score += 60 * 0.10; // 未观看过给基础分
                    }

                    // 6. 防重复机制（5%）
                    score += watchedVideos.contains(v.get标题()) ? 0 : 5;

                    // 设置推荐分数到实体对象
                    v.set推荐分数(BigDecimal.valueOf(score).setScale(2, RoundingMode.HALF_UP));//  保留两位小数

                    return new AbstractMap.SimpleEntry<>(v, score);
                })
                // 按评分降序排序
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                // 转换为视频列表
                .map(AbstractMap.SimpleEntry::getKey)
                // 取前200条
                .limit(200)
                .collect(Collectors.toList());

        System.out.println(video);
        System.out.println(recommendedVideos);

        return new Result(0, "推荐成功", recommendedVideos);
    }
}
