package com.solaluna.wiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.solaluna.wiki.pojo.info.EditHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EditHistoryMapper extends BaseMapper<EditHistory> {
}
