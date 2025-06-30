package com.gy.graduationproject.users;

import com.gy.graduationproject.Result;
import com.gy.graduationproject.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//用户控制器类
@RestController//返回json格式数据
@RequestMapping("/users")//请求路径
public class UsersController {
    //注入用户服务接口
    @Autowired//自动注入
    private UsersService usersService;

    //实现注册功能
    @PostMapping("/register")//请求路径
    public Result register(String userId, String userPassword) {
        if (userId != null && !userId.isEmpty() && userPassword != null && !userPassword.isEmpty()) { //检查账号或密码是否为空
            UsersEntity user = usersService.findByUserId(userId);
            if (user == null) {
                usersService.register(userId, userPassword);
                return new Result(0, "账号不存在，注册成功", null); //账号不存在，注册成功
            } else {
                return new Result(1, "账号已存在，注册失败", null); //账号已存在，注册失败
            }
        } else {
            return new Result(1, "参数异常！账号或密码不能为空！", null); //账号或密码不能为空
        }
    }

    //实现登录功能
    @PostMapping("/login")//请求路径
    public Result login(String userId, String userPassword) {
        if (userId != null && !userId.isEmpty() && userPassword != null && !userPassword.isEmpty()) { //检查账号或密码是否为空
            UsersEntity user = usersService.findByUserId(userId);
            if (user == null) {
                return new Result(1, "账号不存在，登录失败", null); //账号不存在，登录失败
            } else if (user.getUserPassword().equals(userPassword)) {
                //生成token
                Map<String, Object> claims = new HashMap<>();
                claims.put("userId", user.getUserId());//将用户id存入claims
                String token = JwtUtil.genToken(claims);

                return new Result(0, "登录成功", token); //登录成功
            } else {
                return new Result(1, "密码错误，登录失败", null); //密码错误，登录失败
            }
        } else {
            return new Result(1, "参数异常！账号或密码不能为空！", null); //账号或密码不能为空
        }
    }

    //实现根据token获取用户信息功能
    @GetMapping("/getUserInfo")
    public Result<UsersEntity> userInfo(@RequestHeader(name = "Authorization") String token) {
        Map<String, Object> map = JwtUtil.parseToken(token);//解析token
        String userId = (String) map.get("userId");//获取用户id
        UsersEntity user = usersService.findByUserId(userId);
        return new Result(0, "查找成功", user);
    }

    //实现修改用户昵称功能
    @PutMapping("/updateUserNickname")
    public Result updateUserNickname(@RequestHeader(name = "Authorization") String token, @RequestBody Map<String, String> params) {
        Map<String, Object> map = JwtUtil.parseToken(token);//解析token
        String userId = (String) map.get("userId");//获取用户id
        String userNickname = params.get("userNickname");
        if (userNickname != null && !userNickname.isEmpty()) {//检查用户昵称是否为空
            usersService.updateUserNickname(userId, userNickname);
            return new Result(0, "用户昵称更新成功", null);
        } else {
            return new Result(1, "参数异常！用户昵称不能为空！", null); //用户昵称不能为空
        }
    }

    //实现修改用户密码功能
    @PatchMapping("/updateUserPassword")
    public Result updateUserPassword(@RequestHeader(name = "Authorization") String token, @RequestBody Map<String, String> params) {
        String oldPassword = params.get("oldPassword");//获取旧密码
        String newPassword = params.get("newPassword");//获取新密码
        String repeatPassword = params.get("repeatPassword");//获取重复密码
        if (oldPassword == null || oldPassword.isEmpty()
                || newPassword == null || newPassword.isEmpty()
                || repeatPassword == null || repeatPassword.isEmpty()) {
            return new Result(1, "参数异常！缺少参数！", null); //密码不能为空
        }
        Map<String, Object> map = JwtUtil.parseToken(token);//解析token
        String userId = (String) map.get("userId");//获取用户id
        UsersEntity user = usersService.findByUserId(userId);
        if (!user.getUserPassword().equals(oldPassword)) {//检查旧密码是否正确
            return new Result(1, "原密码错误！", null); //旧密码错误
        }
        if (!newPassword.equals(repeatPassword)) {//检查新密码和重复密码是否一致
            return new Result(1, "异常！两次密码不一致！", null);//两次密码不一致
        }
        if (newPassword.equals(oldPassword)) {//检查新密码和旧密码是否相同
            return new Result(1, "异常！新密码不能与旧密码相同！", null);//新密码不能与旧密码相同
        }
        usersService.updateUserPassword(userId, newPassword);
        return new Result(0, "密码修改成功", null);
    }

}
