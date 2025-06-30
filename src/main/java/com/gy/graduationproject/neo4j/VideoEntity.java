package com.gy.graduationproject.neo4j;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gy.graduationproject.utils.BilibiliCoverFetcher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

//视频结点
@Data//自动生成get set方法
@AllArgsConstructor//自动生成构造方法
@NoArgsConstructor//自动生成无参构造方法
@Node("视频")//对应修改结点标签
public class VideoEntity implements Serializable {
    @Id//主键
    @GeneratedValue//生成主键
    private Long id;

    @Property//属性
    private String 知识点;

    @Property//属性
    private String 标题;

    @Property//属性
    private String 地址;

    @Property//属性
    private String 分P;

    @Property//属性
    private String 封面;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0.00")
    @Transient // 避免持久化到数据库
    private BigDecimal 推荐分数;
}
