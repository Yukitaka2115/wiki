package com.solaluna.wiki.pojo.page;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.solaluna.wiki.config.typeHandler.CharaTypeHandler;
import com.solaluna.wiki.config.typeHandler.GroupTypeHandler;
import com.solaluna.wiki.config.typeHandler.MapTypeHandler;
import lombok.Data;

import java.util.Map;

@Data
@TableName("page")
public class Page {
    @TableId(type = IdType.AUTO)
    public int id;
    public String title;
    public String brief;
    public String background;
    @TableField(typeHandler = MapTypeHandler.class)
    public Map<String,String> history;
    @TableField(typeHandler = CharaTypeHandler.class)
    public Chara mainCharacter;
    @TableField(typeHandler = CharaTypeHandler.class)
    public Chara relatives;
    @TableField(typeHandler = GroupTypeHandler.class)
    public Group team;
}
