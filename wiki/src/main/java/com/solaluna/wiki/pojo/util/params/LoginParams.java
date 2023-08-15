package com.solaluna.wiki.pojo.util.params;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="登陆参数")
public class LoginParams {
    @Schema(name="用户名")
    String username;
    @Schema(name="密码")
    String pwd;
    @Schema(name="用户类型")
    int userRole;
}
