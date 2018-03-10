package com.yotwei.blog.dto;

import com.alibaba.fastjson.JSON;
import com.mchange.v2.lang.Coerce;

/**
 * Created by YotWei on 2018/3/9.
 */
public class ResponseBean {

    private int code;
    private String message;
    private Object data;

    public ResponseBean(int code, String message, Object data) {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static final int CODE_SUCCESS = 200;
    public static final int CODE_ERROR = 400;

    public static ResponseBean success(Object data) {
        return new ResponseBean(CODE_SUCCESS, "ok", data);
    }

    public static ResponseBean error(String errMsg) {
        return new ResponseBean(CODE_ERROR, errMsg, null);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
