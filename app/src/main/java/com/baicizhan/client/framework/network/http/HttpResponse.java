package com.baicizhan.client.framework.network.http;

import com.baicizhan.client.framework.util.Cancelable;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class HttpResponse {
    public Cancelable cancelable = new Cancelable();
    public String contentDisposition = "";
    public String contentEncoding = "";
    public String contentLength = "";
    public String contentType = "";
    private String downPath;
    public int downSize;
    public Map<String, List<String>> heads;
    public volatile boolean isCancel = false;
    public int responseCode;
    public byte[] retBytes;
    public int retrying = 0;

    public boolean isFileSegSuccess() {
        if (this.responseCode == 200 || this.responseCode == 206) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void getResponseHead(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
//            this.responseCode = httpURLConnection.getResponseCode();
            this.contentEncoding = httpURLConnection.getContentEncoding();
            this.contentType = httpURLConnection.getContentType();
            this.heads = httpURLConnection.getHeaderFields();
            this.contentDisposition = httpURLConnection.getHeaderField("Content-Disposition");
        }
    }

    public boolean isNetOK() {
        if (this.responseCode == 200 || this.responseCode / 100 == 3) {
            return true;
        }
        return false;
    }

    public void setDownloadPath(String str) {
        this.downPath = str;
    }

    public String getDownloadPath() {
        return this.downPath;
    }
}
