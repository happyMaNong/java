package com.tlp.exception.entity;

/**
 * @className: MyException
 * @description:
 * @author: tianlingpeng
 * @create: 2019-05-27 16:10
 */
public class MyException extends RuntimeException {
    public String code;
    public String msg;
    public String errorMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
