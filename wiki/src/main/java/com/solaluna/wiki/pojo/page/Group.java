package com.solaluna.wiki.pojo.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="小组子参数")
public class Group {
    @Schema(name="角色")
    private String chara;
    @Schema(name="年级")
    private String grade;
    @Schema(name="小组")
    private String group;

    public Group(String chara, String grade, String group) {
        this.chara = chara;
        this.grade = grade;
        this.group = group;
    }
}
