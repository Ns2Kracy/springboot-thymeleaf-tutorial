package com.example.demo.exception;

public enum REnum {
    SUCCESS(0, "success"),
    ERROR(500, "error"),
    LOGIN_ERROR(1001, "login error"),
    UNKNOWN_ERROR(1002, "unknown error"),
    COMMON_ERROR(1003, "common error");

    private final Integer code;
    private final String msg;

    REnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
