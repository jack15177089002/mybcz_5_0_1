package com.baicizhan.client.business.jsonbean;

public class Response<T> {
    private T data;
    private ErrorInfo error;

    public Response() {
        this(ErrorInfo.NO_ERROR, null);
    }

    public Response(ErrorInfo errorInfo) {
        this(errorInfo, null);
    }

    public Response(ErrorInfo errorInfo, T t) {
        this.error = errorInfo;
        this.data = t;
    }

    public ErrorInfo getErrorInfo() {
        return this.error;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.error = errorInfo;
    }

    public Object getData() {
        return this.data;
    }

    public T getTypedData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }
}
