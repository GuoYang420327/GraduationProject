package com.gy.graduationproject.usersRecord;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//用户记录实体类
@Data//自动生成get set方法
@AllArgsConstructor//自动生成构造方法
@NoArgsConstructor//自动生成无参构造方法
public class UsersRecordEntity {
    private String userId;                //用户账号

    private String videoName;             //视频名称

    private String videoKnowledge;        //视频所属知识点

    private String videoBv;               //视频地址

    private String videoP;                //分P

    private String videoCover;            //视频封面

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//转换为json时格式化时间
    private LocalDateTime createTime; //用户记录创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//转换为json时格式化时间
    private LocalDateTime updateTime; //用户记录更新时间
}
