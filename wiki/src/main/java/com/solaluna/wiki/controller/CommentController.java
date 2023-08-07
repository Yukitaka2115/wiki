package com.solaluna.wiki.controller;

import com.solaluna.wiki.pojo.Result;
import com.solaluna.wiki.pojo.page.Comment;
import com.solaluna.wiki.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class CommentController {
    @Autowired
    CommentService service;
    @PostMapping("/comment/testAdd")
    public Result addComment(@RequestBody Comment commentParam){
        int pageId = commentParam.getPage_id();
        int userId = commentParam.getUser_id();
        String content = commentParam.getComment();
        Timestamp time = commentParam.getTime();
        int userRole = commentParam.getUser_role();
        Comment comment = new Comment();
        comment.setPage_id(pageId);
        comment.setUser_id(userId);
        comment.setComment(content);
        comment.setTime(time);
        comment.setUser_role(userRole);
        service.save(comment);
        return Result.success(comment);
    }

    @GetMapping("/comment/get")
    public Result getComment(@RequestBody Comment commentParam){
        Comment comment = service.getById(commentParam.id);
        if(comment == null){
            return Result.fail(406,"无效id");
        }
        return Result.success(comment);
    }
}
