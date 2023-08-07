package com.solaluna.wiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.solaluna.wiki.pojo.page.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
