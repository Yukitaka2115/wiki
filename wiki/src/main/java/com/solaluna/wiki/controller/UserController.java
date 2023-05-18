package com.solaluna.wiki.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.solaluna.wiki.pojo.Result;
import com.solaluna.wiki.pojo.user.User;
import com.solaluna.wiki.pojo.user.params.LoginParams;
import com.solaluna.wiki.pojo.user.params.RegisterParams;
import com.solaluna.wiki.pojo.user.util.JwtUtil;
import com.solaluna.wiki.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtil jwtUtil;
    @GetMapping("/user/test")
    public Result test(){
        return Result.success("114514");
    }
    @PostMapping("/user/register")
    public Result register(@RequestBody RegisterParams registerParams){
        String username = registerParams.getUsername();
        String pwd = registerParams.getPwd();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(pwd)) {
            return Result.fail(401,"空白信息");
        }
        //根据用户名查询用户
        User user = userService.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .last("limit 1"));//检验重复
        if (user != null) {
            return Result.fail(402,"用户重复");
        }
        user = new User();
        user.setUsername(username);
        user.setPwd(pwd);
        userService.save(user);
        String token = jwtUtil.createToken(user.getId());
        return Result.success(token);
    }//1

    @PostMapping("/user/login")
    public Result login(@RequestBody LoginParams loginParams){
        String username = loginParams.getUsername();
        String pwd = loginParams.getPwd();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(pwd)) {
            return Result.fail(401,"空白信息");
        }
        //等价于 SELECT * FROM user WHERE ACCOUNT=#{account} AND PASSWORD=#{password} limit 1;
        User user = userService.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .eq(User::getPwd, pwd)
                .last("limit 1"));
        if (user == null) {
            return Result.fail(404,"登陆信息错误");
        }
        String token = jwtUtil.createToken(user.getId());
        return Result.success(token);
    }//1
}
