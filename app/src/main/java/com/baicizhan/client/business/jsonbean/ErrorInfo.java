package com.baicizhan.client.business.jsonbean;

import android.text.TextUtils;

public class ErrorInfo implements IBean {
    public static final ErrorInfo ARG_ERROR = new ErrorInfo(-1, "arg error");
    public static final ErrorInfo COMPETITOR_EXIT = new ErrorInfo(-5, "competitor exit");
    public static final ErrorInfo NOT_SELECT_ME = new ErrorInfo(2, "not select me");
    public static final ErrorInfo NO_ERROR = new ErrorInfo(0, null);
    public static final ErrorInfo SELF_EXIT = new ErrorInfo(-6, "self exit");
    public static final ErrorInfo STATUS_ERROR = new ErrorInfo(-2, "status error");
    public static final ErrorInfo WAITING = new ErrorInfo(1, "waiting");
    private int code;
    private String msg;

    public ErrorInfo() {
        this.code = 0;
        this.msg = null;
    }

    private ErrorInfo(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public String toString() {
        return "ErrorInfo [code=" + this.code + ", msg=" + this.msg + "]";
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ErrorInfo)) {
            return false;
        }
        ErrorInfo errorInfo = (ErrorInfo) obj;
        if (!TextUtils.isEmpty(this.msg) || !TextUtils.isEmpty(errorInfo.msg)) {
            if (this.msg == null) {
                return false;
            }
            if (!this.msg.equals(errorInfo.msg) || this.code != errorInfo.code) {
                return false;
            }
            return true;
        } else if (this.code != errorInfo.code) {
            return false;
        } else {
            return true;
        }
    }

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

    public boolean isValide() {
        switch (this.code) {
            case -6:
                if (this.msg == null || !this.msg.equals("self exit")) {
                    return false;
                }
                return true;
            case -5:
                if (this.msg == null || !this.msg.equals("competitor exit")) {
                    return false;
                }
                return true;
            case -4:
                if (this.msg == null || !this.msg.equals("self timeout")) {
                    return false;
                }
                return true;
            case -3:
                if (this.msg == null || !this.msg.equals("competitor timeout")) {
                    return false;
                }
                return true;
            case -2:
                if (this.msg == null || !this.msg.equals("status error")) {
                    return false;
                }
                return true;
            case -1:
                if (this.msg == null || !this.msg.equals("arg error")) {
                    return false;
                }
                return true;
            case 0:
                if (this.msg != null) {
                    return false;
                }
                return true;
            case 1:
                if (this.msg == null || !this.msg.equals("waiting")) {
                    return false;
                }
                return true;
            case 2:
                return this.msg != null && this.msg.equals("not select me");
            default:
                return true;
        }
    }
}
