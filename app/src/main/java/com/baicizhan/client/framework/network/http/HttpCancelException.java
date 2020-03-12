package com.baicizhan.client.framework.network.http;

import java.io.IOException;

public class HttpCancelException extends IOException {
    private static final long serialVersionUID = 6712119810502114101L;

    public HttpCancelException() {
        super("request cancelled.");
    }

    public HttpCancelException(String str) {
        super(str);
    }

    public HttpCancelException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
