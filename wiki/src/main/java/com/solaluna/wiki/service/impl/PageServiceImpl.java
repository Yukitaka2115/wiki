package com.solaluna.wiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.solaluna.wiki.mapper.PageMapper;
import com.solaluna.wiki.pojo.page.Page;
import com.solaluna.wiki.service.PageService;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements PageService {
}
