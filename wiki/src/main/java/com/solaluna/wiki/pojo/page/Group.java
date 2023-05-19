package com.solaluna.wiki.pojo.page;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("group")
public class Group {
    @TableId(type = IdType.AUTO)
    private int id;
    private String chara;
    private String grade;
    private String group;

    public Group(String chara, String grade, String group) {

    }
}
