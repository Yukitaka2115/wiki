package com.solaluna.wiki.pojo.page;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author 41572
 */
@Data
@TableName("comment")
public class Comment {
    public int id;
    public int page_id;
    public int user_id;
    public String comment;
    public Timestamp time;
    public int user_role;
}
