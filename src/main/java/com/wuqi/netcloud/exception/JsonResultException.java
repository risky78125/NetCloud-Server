package com.wuqi.netcloud.exception;

public class JsonResultException extends RuntimeException {

    private int code;

    public JsonResultException() {
    }

    public JsonResultException(int code) {
        this(code, "未知系统错误");
    }

    public JsonResultException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
