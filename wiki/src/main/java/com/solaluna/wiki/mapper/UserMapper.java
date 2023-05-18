package com.solaluna.wiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.solaluna.wiki.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
