package com.demo.entity;

/**
 * 此对象统一封装API返回信息
 * @author xuzhongknag on 2019/12/07
 */
public class RestResult {
    private int code;
    private String message;
    private Object data;

    public RestResult(){

    }

    public RestResult setCode(ResultCode code) {
        this.code = code.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public RestResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RestResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RestResult setData(Object data) {
        this.data = data;
        return this;
    }
}
