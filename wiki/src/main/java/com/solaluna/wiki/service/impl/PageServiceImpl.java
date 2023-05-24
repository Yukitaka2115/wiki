package com.solaluna.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.solaluna.wiki.mapper.PageMapper;
import com.solaluna.wiki.pojo.page.Page;
import com.solaluna.wiki.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements PageService {
    @Autowired
    private PageMapper pageMapper;

    public Page getByTitle(String title) {
        QueryWrapper<Page> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", title);
        return pageMapper.selectOne(queryWrapper);
    }
}
