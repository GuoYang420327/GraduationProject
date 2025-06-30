package com.gy.graduationproject.neo4j;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.io.Serializable;

//知识点结点
@Data//自动生成get set方法
@AllArgsConstructor//自动生成构造方法
@NoArgsConstructor//自动生成无参构造方法
@Node("知识点")//对应修改结点标签
public class KnowledgeEntity implements Serializable {
    @Id//主键
    @GeneratedValue//生成主键
    private Long id;

    @Property//属性
    private String 名称;
}
