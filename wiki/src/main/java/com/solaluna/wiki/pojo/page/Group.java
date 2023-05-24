package com.solaluna.wiki.pojo.page;

import lombok.Data;

@Data

public class Group {
    private String chara;
    private String grade;
    private String group;

    public Group(String chara, String grade, String group) {
        this.chara = chara;
        this.grade = grade;
        this.group = group;
    }
}
