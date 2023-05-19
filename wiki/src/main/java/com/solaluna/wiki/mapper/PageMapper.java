package com.solaluna.wiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.solaluna.wiki.pojo.page.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageMapper extends BaseMapper<Page> {
}
