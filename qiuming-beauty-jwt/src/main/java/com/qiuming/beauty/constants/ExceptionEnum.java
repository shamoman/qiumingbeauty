package com.qiuming.beauty.constants;

/**
 * 异常枚举
 */
public enum ExceptionEnum {
    ERROR_PARAM(1001, "参数错误"),
    PASSWORD_DO_NOT_SAME(1002, "两次输入的密码不一致"),
    ;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
