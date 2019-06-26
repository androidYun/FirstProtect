package com.xhs.first.pojo;

public class BaseMsg<T> {
    private int code;

    private String message = "";


    private T data;

    public BaseMsg() {
    }

    public BaseMsg(T data) {
        this.data = data;
        this.code = 200;
    }

    public static BaseMsg getErrorMessageBean(String errorMessage) {
        BaseMsg<String> errorBean = new BaseMsg<String>(null);
        errorBean.message = errorMessage;
        errorBean.data = null;
        errorBean.code = 203;
        return errorBean;
    }

    public BaseMsg<T> getSuccessData(T t) {
        BaseMsg baseMsg = new BaseMsg(t);
        baseMsg.data = t;
        baseMsg.code = 200;
        return baseMsg;
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
}
