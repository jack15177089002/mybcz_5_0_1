package com.baicizhan.client.framework.network.http;

import java.io.IOException;

public class NoNeed2DownloadException extends IOException {
    private static final long serialVersionUID = 4600763045531689666L;

    public NoNeed2DownloadException() {
        super("The file to request has been downloaded completely.");
    }

    public NoNeed2DownloadException(String str) {
        super(str);
    }

    public NoNeed2DownloadException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
