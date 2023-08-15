package com.solaluna.wiki.pojo.page;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.solaluna.wiki.config.typeHandler.CharaTypeHandler;
import com.solaluna.wiki.config.typeHandler.GroupTypeHandler;
import com.solaluna.wiki.config.typeHandler.MapTypeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

@Data
@TableName("page")
@Schema(name="页面参数")
public class Page {
    @TableId(type = IdType.AUTO)
    @Schema(name="主键")
    public int id;
    @Schema(name="标题")
    public String title;
    @Schema(name="简介")
    public String brief;
    @Schema(name="背景")
    public String background;
    @TableField(typeHandler = MapTypeHandler.class)
    @Schema(name="历史")
    public Map<String,String> history;
    @TableField(typeHandler = CharaTypeHandler.class)
    @Schema(name="主要角色")
    public Chara mainchara;
    @TableField(typeHandler = CharaTypeHandler.class)
    @Schema(name="其他角色")
    public Chara relatives;
    @TableField(typeHandler = GroupTypeHandler.class)
    @Schema(name="小组")
    public Group team;
}
