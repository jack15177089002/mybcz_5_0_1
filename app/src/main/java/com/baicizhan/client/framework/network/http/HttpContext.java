package com.baicizhan.client.framework.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HttpContext {
    private ApacheHttpRequest mApacheRequest = new ApacheHttpRequest();
    private ApacheHttpResponse mApacheResponse = new ApacheHttpResponse();
    protected HttpRequest request = new HttpRequest();
    protected HttpResponse response = new HttpResponse();
    private LinkedList<HttpStat> statList = new LinkedList<>();

    public HttpRequest getRequest() {
        return this.request;
    }

    public HttpResponse getResponse() {
        return this.response;
    }

    public List<HttpStat> getStatList() {
        return Collections.unmodifiableList(this.statList);
    }

    public void putStat(HttpStat httpStat) {
        if (httpStat != null) {
            this.statList.add(httpStat);
        }
    }

    public ApacheHttpRequest getApacheHttpRequest() {
        return this.mApacheRequest;
    }

    public ApacheHttpResponse getApacheHttpResponse() {
        return this.mApacheResponse;
    }
}
