package com.gy.graduationproject.questions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//题目实体类
@Data//自动生成get set方法
@AllArgsConstructor//自动生成构造方法
@NoArgsConstructor//自动生成无参构造方法
public class QuestionsEntity {
    private int id;
    private String questionKnowledge;//所属知识点
    private String question;//题干
    private String answerA;//选项A
    private String answerB;//选项B
    private String answerC;//选项C
    private String answerD;//选项D
    private String rightAnswer;//正确答案
    private String analysis;//答案解析
}
