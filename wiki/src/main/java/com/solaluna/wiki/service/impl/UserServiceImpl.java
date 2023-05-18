package com.solaluna.wiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.solaluna.wiki.mapper.UserMapper;
import com.solaluna.wiki.pojo.user.User;
import com.solaluna.wiki.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
