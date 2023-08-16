package com.solaluna.wiki.pojo.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("user")
@Schema(name="用户参数")
public class User {
    @TableId(type = IdType.AUTO)
    @Schema(name="用户ID，表主键")
    public Integer id;
    @Schema(name="用户类型：0普通，1管理员")
    public Integer role;
    @Schema(name="用户名")
    public String username;
    @Schema(name="密码")
    public String pwd;
}
