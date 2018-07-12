package com.yotwei.blog.enity;

/**
 * Created by YotWei on 2018/7/11.
 */
public class ResponseBean<T> {

    public static final int CODE_SUCCESS = 200;
    public static final int CODE_ERROR = 400;

    private int code;
    private String message;
    private T data;

    private ResponseBean(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponseBean success() {
        return new ResponseBean<>(CODE_SUCCESS, "OK", null);
    }

    public static <T> ResponseBean<T> error(T data) {
        return new ResponseBean<T>(CODE_ERROR, "error", data);
    }
}
