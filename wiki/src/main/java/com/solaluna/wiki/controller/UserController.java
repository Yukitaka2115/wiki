package com.solaluna.wiki.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.solaluna.wiki.pojo.Result;
import com.solaluna.wiki.pojo.page.Comment;
import com.solaluna.wiki.pojo.user.User;
import com.solaluna.wiki.pojo.util.JwtUtils;
import com.solaluna.wiki.pojo.util.params.LoginParams;
import com.solaluna.wiki.pojo.util.params.RegisterParams;
import com.solaluna.wiki.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 41572
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtils jwtUtil;
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

    @PostMapping("/comment")
    public Result addComment(@RequestBody Comment comment, @RequestHeader("Authorization") String token) {
        // 解析 JWT 获取用户名和角色
        String username = JwtUtils.getUsernameFromToken(token);
        int role = JwtUtils.getUserRoleFromToken(token);

        // 判断用户的角色，进行相应的处理
        if (role == 0) {
            // 管理员身份处理逻辑
            boolean isAdminAllowed = checkAdminPermissions(comment);
            if (isAdminAllowed) {
                // 执行管理员允许的操作
                return Result.success("管理员评论添加成功");
            } else {
                // 返回权限不足的错误信息
                return Result.fail(400,"权限不足");
            }
        } else {
            // 普通用户身份处理逻辑
            boolean isUserAllowed = checkUserPermissions(comment);
            if (isUserAllowed) {
                // 执行普通用户允许的操作
                return Result.success("用户评论添加成功");
            } else {
                // 返回权限不足的错误信息
                return Result.fail(400,"权限不足");
            }
        }
    }

    private boolean checkUserPermissions(Comment comment) {
        return comment.getUser_id()==(comment.user_id);
    }

    private boolean checkAdminPermissions(Comment comment) {
        return comment.getUser_role()==(comment.user_role);
    }
}
