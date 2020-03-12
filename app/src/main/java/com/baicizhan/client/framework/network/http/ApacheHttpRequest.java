package com.baicizhan.client.framework.network.http;

import java.io.File;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;

public class ApacheHttpRequest extends HttpRequest {
    private HttpPost mAHttpPost;
    private HttpHost mAHttpProxy;
    private File mFile2up;

    public void setApacheHttpPost(HttpPost httpPost) {
        this.mAHttpPost = httpPost;
    }

    public HttpPost getApacheHttpPost() {
        return this.mAHttpPost;
    }

    public void setApacheHttpProxy(HttpHost httpHost) {
        this.mAHttpProxy = httpHost;
    }

    public HttpHost getApacheHttpProxy() {
        return this.mAHttpProxy;
    }

    public void setFile2Upload(File file) {
        this.mFile2up = file;
    }

    public void setFile2Upload(String str) {
        this.mFile2up = new File(str);
    }

    public File getFile2Upload() {
        return this.mFile2up;
    }

    public String getPath2Upload() {
        return this.mFile2up.getAbsolutePath();
    }
}
