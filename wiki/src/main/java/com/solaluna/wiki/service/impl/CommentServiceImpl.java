package com.solaluna.wiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.solaluna.wiki.mapper.CommentMapper;
import com.solaluna.wiki.pojo.page.Comment;
import com.solaluna.wiki.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
