package com.solaluna.wiki.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class History {
    public int ID;
    public Date date;
    public String Event;
}
