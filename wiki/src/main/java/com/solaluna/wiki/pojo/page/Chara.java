package com.solaluna.wiki.pojo.page;

import lombok.Data;


@Data
public class Chara {
    private String chara;
    private String cast;
    private String info;

    public Chara(String chara, String cast, String info) {
        this.chara = chara;
        this.cast = cast;
        this.info = info;
    }
}

