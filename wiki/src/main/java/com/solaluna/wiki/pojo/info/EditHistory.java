package com.solaluna.wiki.pojo.info;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("edithistory")
public class EditHistory {
    @TableId(type = IdType.AUTO)
    public int id;
    @TableField(fill = FieldFill.INSERT)
    public Timestamp editTime;
    @TableField("editor_name")
    public String editorName;
    @TableField("editPage_id")
    public int editedPageId;
}
