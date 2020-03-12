package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache.Entry;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class BasicNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;
    private static int DEFAULT_POOL_SIZE = 4096;
    private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(DEFAULT_POOL_SIZE));
    }

    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.mHttpStack = httpStack;
        this.mPool = byteArrayPool;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
        attemptRetryOnException("socket", r13, new com.android.volley.TimeoutError());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009b, code lost:
        attemptRetryOnException("connection", r13, new com.android.volley.TimeoutError());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c0, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r13.getUrl(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c4, code lost:
        r0 = r2.getStatusLine().getStatusCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ce, code lost:
        if (r0 == 301) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d4, code lost:
        com.android.volley.VolleyLog.m2462e("Request at %s has been redirected to %s", r13.getOriginUrl(), r13.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ea, code lost:
        if (0 != 0) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ec, code lost:
        r2 = new com.android.volley.NetworkResponse(r0, null, r1, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f4, code lost:
        if (r0 == 401) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fa, code lost:
        attemptRetryOnException("auth", r13, new com.android.volley.AuthFailureError(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010b, code lost:
        throw new com.android.volley.NoConnectionError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010c, code lost:
        com.android.volley.VolleyLog.m2462e("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r13.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0125, code lost:
        if (r0 == 301) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012b, code lost:
        attemptRetryOnException("redirect", r13, new com.android.volley.AuthFailureError(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013c, code lost:
        throw new com.android.volley.ServerError(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0143, code lost:
        throw new com.android.volley.NetworkError((com.android.volley.NetworkResponse) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0148, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0149, code lost:
        r1 = r7;
        r2 = r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:2:0x000b] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a A[ExcHandler: ConnectTimeoutException (e org.apache.http.conn.ConnectTimeoutException), Splitter:B:2:0x000b] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7 A[ExcHandler: MalformedURLException (r0v8 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000b] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0106 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.android.volley.NetworkResponse performRequest(com.android.volley.Request<?> r13) {
        /*
            r12 = this;
            long r10 = android.os.SystemClock.elapsedRealtime()
        L_0x0004:
            r2 = 0
            r5 = 0
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x00c1 }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x00c1 }
            com.android.volley.Cache$Entry r3 = r13.getCacheEntry()     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x00c1 }
            r12.addCacheHeaders(r0, r3)     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x00c1 }
            com.android.volley.toolbox.HttpStack r3 = r12.mHttpStack     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x00c1 }
            org.apache.http.HttpResponse r8 = r3.performRequest(r13, r0)     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x00c1 }
            org.apache.http.StatusLine r6 = r8.getStatusLine()     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0144 }
            int r9 = r6.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0144 }
            org.apache.http.Header[] r0 = r8.getAllHeaders()     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0144 }
            java.util.Map r7 = convertHeaders(r0)     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0144 }
            r0 = 304(0x130, float:4.26E-43)
            if (r9 != r0) goto L_0x0048
            com.android.volley.NetworkResponse r0 = new com.android.volley.NetworkResponse     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            r2 = 304(0x130, float:4.26E-43)
            com.android.volley.Cache$Entry r1 = r13.getCacheEntry()     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            if (r1 != 0) goto L_0x0041
            r1 = 0
        L_0x003c:
            r3 = 1
            r0.<init>(r2, r1, r7, r3)     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
        L_0x0040:
            return r0
        L_0x0041:
            com.android.volley.Cache$Entry r1 = r13.getCacheEntry()     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            byte[] r1 = r1.data     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            goto L_0x003c
        L_0x0048:
            r0 = 301(0x12d, float:4.22E-43)
            if (r9 == r0) goto L_0x0050
            r0 = 302(0x12e, float:4.23E-43)
            if (r9 != r0) goto L_0x005b
        L_0x0050:
            java.lang.String r0 = "Location"
            java.lang.Object r0 = r7.get(r0)     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            r13.setRedirectUrl(r0)     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
        L_0x005b:
            org.apache.http.HttpEntity r0 = r8.getEntity()     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            if (r0 == 0) goto L_0x008f
            org.apache.http.HttpEntity r0 = r8.getEntity()     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            byte[] r5 = r12.entityToBytes(r0)     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
        L_0x0069:
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            long r2 = r0 - r10
            r1 = r12
            r4 = r13
            r1.logSlowRequests(r2, r4, r5, r6)     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            r0 = 200(0xc8, float:2.8E-43)
            if (r9 < r0) goto L_0x007c
            r0 = 299(0x12b, float:4.19E-43)
            if (r9 <= r0) goto L_0x0093
        L_0x007c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            throw r0     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
        L_0x0082:
            r0 = move-exception
            java.lang.String r0 = "socket"
            com.android.volley.TimeoutError r1 = new com.android.volley.TimeoutError
            r1.<init>()
            attemptRetryOnException(r0, r13, r1)
            goto L_0x0004
        L_0x008f:
            r0 = 0
            byte[] r5 = new byte[r0]     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            goto L_0x0069
        L_0x0093:
            com.android.volley.NetworkResponse r0 = new com.android.volley.NetworkResponse     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            r1 = 0
            r0.<init>(r9, r5, r7, r1)     // Catch:{ SocketTimeoutException -> 0x0082, ConnectTimeoutException -> 0x009a, MalformedURLException -> 0x00a7, IOException -> 0x0148 }
            goto L_0x0040
        L_0x009a:
            r0 = move-exception
            java.lang.String r0 = "connection"
            com.android.volley.TimeoutError r1 = new com.android.volley.TimeoutError
            r1.<init>()
            attemptRetryOnException(r0, r13, r1)
            goto L_0x0004
        L_0x00a7:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Bad URL "
            r2.<init>(r3)
            java.lang.String r3 = r13.getUrl()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x00c1:
            r0 = move-exception
        L_0x00c2:
            if (r2 == 0) goto L_0x0106
            org.apache.http.StatusLine r0 = r2.getStatusLine()
            int r0 = r0.getStatusCode()
            r2 = 301(0x12d, float:4.22E-43)
            if (r0 == r2) goto L_0x00d4
            r2 = 302(0x12e, float:4.23E-43)
            if (r0 != r2) goto L_0x010c
        L_0x00d4:
            java.lang.String r2 = "Request at %s has been redirected to %s"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            java.lang.String r6 = r13.getOriginUrl()
            r3[r4] = r6
            r4 = 1
            java.lang.String r6 = r13.getUrl()
            r3[r4] = r6
            com.android.volley.VolleyLog.m2462e(r2, r3)
        L_0x00ea:
            if (r5 == 0) goto L_0x013d
            com.android.volley.NetworkResponse r2 = new com.android.volley.NetworkResponse
            r3 = 0
            r2.<init>(r0, r5, r1, r3)
            r1 = 401(0x191, float:5.62E-43)
            if (r0 == r1) goto L_0x00fa
            r1 = 403(0x193, float:5.65E-43)
            if (r0 != r1) goto L_0x0123
        L_0x00fa:
            java.lang.String r0 = "auth"
            com.android.volley.AuthFailureError r1 = new com.android.volley.AuthFailureError
            r1.<init>(r2)
            attemptRetryOnException(r0, r13, r1)
            goto L_0x0004
        L_0x0106:
            com.android.volley.NoConnectionError r1 = new com.android.volley.NoConnectionError
            r1.<init>(r0)
            throw r1
        L_0x010c:
            java.lang.String r2 = "Unexpected response code %d for %s"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            r3[r4] = r6
            r4 = 1
            java.lang.String r6 = r13.getUrl()
            r3[r4] = r6
            com.android.volley.VolleyLog.m2462e(r2, r3)
            goto L_0x00ea
        L_0x0123:
            r1 = 301(0x12d, float:4.22E-43)
            if (r0 == r1) goto L_0x012b
            r1 = 302(0x12e, float:4.23E-43)
            if (r0 != r1) goto L_0x0137
        L_0x012b:
            java.lang.String r0 = "redirect"
            com.android.volley.AuthFailureError r1 = new com.android.volley.AuthFailureError
            r1.<init>(r2)
            attemptRetryOnException(r0, r13, r1)
            goto L_0x0004
        L_0x0137:
            com.android.volley.ServerError r0 = new com.android.volley.ServerError
            r0.<init>(r2)
            throw r0
        L_0x013d:
            com.android.volley.NetworkError r0 = new com.android.volley.NetworkError
            r1 = 0
            r0.<init>(r1)
            throw r0
        L_0x0144:
            r0 = move-exception
            r2 = r8
            goto L_0x00c2
        L_0x0148:
            r0 = move-exception
            r1 = r7
            r2 = r8
            goto L_0x00c2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.BasicNetwork.performRequest(com.android.volley.Request):com.android.volley.NetworkResponse");
    }

    private void logSlowRequests(long j, Request<?> request, byte[] bArr, StatusLine statusLine) {
        if (DEBUG || j > ((long) SLOW_REQUEST_THRESHOLD_MS)) {
            String str = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.m2461d(str, objArr);
        }
    }

    private static void attemptRetryOnException(String str, Request<?> request, VolleyError volleyError) {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        retryPolicy.retry(volleyError);
        request.addMarker(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
    }

    private void addCacheHeaders(Map<String, String> map, Entry entry) {
        if (entry != null) {
            if (entry.etag != null) {
                map.put("If-None-Match", entry.etag);
            }
            if (entry.serverDate > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(entry.serverDate)));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void logError(String str, String str2, long j) {
        VolleyLog.m2464v("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j), str2);
    }

    private byte[] entityToBytes(HttpEntity httpEntity) {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = null;
            try {
                content = httpEntity.getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (content == null) {
                throw new ServerError();
            }
            bArr = this.mPool.getBuf(1024);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                poolingByteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
            try {
            } catch (Exception e) {
                VolleyLog.m2464v("Error occured when calling consumingContent", new Object[0]);
            }
            return byteArray;
        } catch (ServerError serverError) {
            serverError.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                VolleyLog.m2464v("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.returnBuf(bArr);
            poolingByteArrayOutputStream.close();
        }

        return null;
    }

    private static Map<String, String> convertHeaders(Header[] headerArr) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < headerArr.length; i++) {
            hashMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return hashMap;
    }
}
