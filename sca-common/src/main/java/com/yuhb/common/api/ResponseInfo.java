package com.yuhb.common.api;

/**
 * Created by yu.hb on 2020-01-03
 */
public enum ResponseInfo {
    SUCCESS(200, "success"),
    USER_NOT_FOUND(300, "用户不存在或未登录"),
    USER_INVALID(400, "用户被禁用"),
    ERROR(500, "系统繁忙"),

    AUTH_ERROR(1000, "登录失效，请重新登录"),
    LIMIT_ERROR(1001,"操作太频繁啦")
    ;


    public final int code;

    public final String msg;

    private ResponseInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
