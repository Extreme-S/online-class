package com.example.online_xdclass.exception;

/**
 * 小滴课堂
 * 自定义异常类
 */
public class XDException extends RuntimeException{

    private Integer code;

    private String msg;

    public XDException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
