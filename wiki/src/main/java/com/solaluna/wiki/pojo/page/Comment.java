package com.solaluna.wiki.pojo.page;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author 41572
 */
@Data
@TableName("comment")
@Schema(name="评论参数")
public class Comment {
    @TableId(type = IdType.AUTO)
    @Schema(name="主键")
    public int id;
    @Schema(name="页面ID")
    public int page_id;
    @Schema(name="用户ID")
    public int user_id;
    @Schema(name="评论")
    public String comment;
    @Schema(name="评论时间")
    public Timestamp time;
    @Schema(name="用户角色")
    public int user_role;
}
