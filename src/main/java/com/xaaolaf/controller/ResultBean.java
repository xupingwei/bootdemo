package com.xaaolaf.controller;

/**
 * Created by xupingwei on 2017/5/7.
 * 返回的结果bean
 */
public class ResultBean<T> {
    private int code;    //1:  成功  0：失败
    private String msg = "";   // 失败时结果
    private T result;    //返回真实结果

    public int getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        if (code == ResultCode.OK) {
            this.code = 1;   //成功
        } else {
            this.code = 0;   //失败
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
