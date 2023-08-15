package com.solaluna.wiki.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="返回类型参数")
public class Result {
    @Schema(name="返回代码")
    private int code;
    @Schema(name="返回信息")
    private String msg;
    @Schema(name="返回数据")
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
