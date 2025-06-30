package com.gy.graduationproject.usersQuestionsAccuracy;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//用户成绩实体类
@Data//自动生成get set方法
@AllArgsConstructor//自动生成构造方法
@NoArgsConstructor//自动生成无参构造方法
public class UsersQuestionsAccuracyEntity {
    private int id;
    private String userId;//用户id
    private String knowledge;//知识点
    private int accuracy;//正确率

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//转换为json时格式化时间
    private LocalDateTime createTime;//创建时间
}
