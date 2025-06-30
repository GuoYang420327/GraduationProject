package com.gy.graduationproject.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//用户实体类
@Data//自动生成get set方法
@AllArgsConstructor//自动生成构造方法
@NoArgsConstructor//自动生成无参构造方法
public class UsersEntity {

    private String userId;                //用户账号

    @JsonIgnore//转换为json时忽略该属性（密码）
    private String userPassword;          //用户密码

    private String userNickname;          //用户昵称
    private String userJob;               //用户职位

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//转换为json时格式化时间
    private LocalDateTime userCreateTime; //用户创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//转换为json时格式化时间
    private LocalDateTime userUpdateTime; //用户更新时间

}
