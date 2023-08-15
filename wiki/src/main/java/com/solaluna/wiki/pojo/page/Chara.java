package com.solaluna.wiki.pojo.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(name="角色子参数")
public class Chara {
    @Schema(name = "角色")
    private String chara;
    @Schema(name = "cv")
    private String cast;
    @Schema(name = "信息")
    private String info;

    public Chara(String chara, String cast, String info) {
        this.chara = chara;
        this.cast = cast;
        this.info = info;
    }
}

