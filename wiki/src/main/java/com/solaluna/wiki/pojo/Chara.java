package com.solaluna.wiki.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("chara")
public class Chara {
    @TableId(type = IdType.AUTO)
    public int id;
    public String chara;
    public String cast;
    public String info;
}
