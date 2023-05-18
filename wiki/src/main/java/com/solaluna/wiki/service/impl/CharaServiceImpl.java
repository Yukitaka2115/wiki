package com.solaluna.wiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.solaluna.wiki.mapper.CharaMapper;
import com.solaluna.wiki.pojo.page.Chara;
import com.solaluna.wiki.service.CharaService;
import org.springframework.stereotype.Service;

@Service
public class CharaServiceImpl extends ServiceImpl<CharaMapper,Chara> implements CharaService {
}
