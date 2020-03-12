package com.baicizhan.client.business.logoload.jsonbean;

public class ErrorInfo {
    private int code;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "errCode: " + this.code + "; msg: " + this.msg;
    }
}
