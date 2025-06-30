package com.gy.graduationproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//自动生成get set方法
@AllArgsConstructor//自动生成构造方法
@NoArgsConstructor//自动生成无参构造方法
public class Result<T> {
    private Integer code;//状态码
    private String message;//状态消息
    private T data;//返回数据
}
