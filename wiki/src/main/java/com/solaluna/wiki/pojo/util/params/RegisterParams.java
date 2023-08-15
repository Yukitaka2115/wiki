package com.solaluna.wiki.pojo.util.params;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="注册参数")
public class RegisterParams {
    @Schema(name="用户名")
    String username;
    @Schema(name="密码")
    String pwd;
}
