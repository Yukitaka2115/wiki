package com.solaluna.wiki.pojo;

import lombok.Data;

@Data
public class Result {

    private int code;
    private String msg;
    private Object data;
    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(200, "请求成功", data);
    }
    public static Result success(String msg, Object data) {
        return new Result(200,msg,data);
    }
    public static Result fail(int code, String msg) {
        return new Result(code, msg, null);
    }
    public static Result error(String msg){return new Result(600,msg,null);}
}
