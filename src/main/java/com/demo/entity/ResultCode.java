package com.demo.entity;

/**
 * 响应码枚举，参考HTTP状态码的语义
 * @author xuzhongknag on 2019/12/07
 */
public enum ResultCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    private int code;

    private ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
