package com.baicizhan.client.framework.network.http;

import android.os.Handler;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class HttpManager {
    public static final int MSG_DOWN_FAILED = 3;
    public static final int MSG_DOWN_SUCCESS = 2;
    public static final int MSG_START_DECOMPRESS = 1;
    public static final int MSG_UPD_DOWN_PROGRESS = 0;
    public static final int MSG_UPD_UP_PROGRESS = 4;
    public static final int MSG_UP_FAILED = 6;
    public static final int MSG_UP_SUCCESS = 5;
    private HttpContext context;

    public HttpManager(HttpContext httpContext) {
        this.context = httpContext;
    }

    public HttpContext getContext() {
        return this.context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c6, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c7, code lost:
        r16 = r6;
        r6 = r5;
        r5 = r8;
        r8 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e3, code lost:
        com.baicizhan.client.framework.log.C0789L.log.error("trace download ex, timeout. ", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ea, code lost:
        r17.context.getResponse().responseCode = -13;
        r8 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fc, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0109, code lost:
        com.baicizhan.client.framework.log.C0789L.log.error("trace download ex 1 ", (java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0110, code lost:
        r17.context.getResponse().responseCode = -100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x011d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012a, code lost:
        com.baicizhan.client.framework.log.C0789L.log.error("trace download ex 2 ", (java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0131, code lost:
        r17.context.getResponse().responseCode = -101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014b, code lost:
        com.baicizhan.client.framework.log.C0789L.log.error("trace download ex 3 ", (java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0152, code lost:
        r17.context.getResponse().responseCode = -10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0160, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x016d, code lost:
        com.baicizhan.client.framework.log.C0789L.log.error("trace download throwable ", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x017e, code lost:
        if (r17.context.getResponse().responseCode >= 0) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0180, code lost:
        r17.context.getResponse().responseCode = -10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0199, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x019a, code lost:
        r16 = r5;
        r5 = r8;
        r8 = r16;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f8 A[LOOP:0: B:8:0x005e->B:41:0x00f8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fc A[ExcHandler: FileNotFoundException (r2v19 'e' java.io.FileNotFoundException A[CUSTOM_DECLARE]), Splitter:B:11:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011d A[ExcHandler: NoNeed2DownloadException (r2v16 'e' com.baicizhan.client.framework.network.http.NoNeed2DownloadException A[CUSTOM_DECLARE]), Splitter:B:11:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x013e A[ExcHandler: Exception (r2v13 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:11:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0160 A[ExcHandler: Throwable (r2v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:11:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00d7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean downloadFile(Handler r18) {
        /*
            r17 = this;
            r0 = r17
            com.baicizhan.client.framework.network.http.HttpContext r2 = r0.context
            com.baicizhan.client.framework.network.http.HttpRequest r5 = r2.getRequest()
            int r6 = r5.getReadTimeout()
            int r2 = r5.getMaxRetry()
            int r7 = r5.getConnTimeout()
            java.lang.String r3 = r5.getDestPath()
            boolean r4 = r5.isAutoDecompress()
            com.baicizhan.client.framework.util.IBackoffPolicy r10 = r5.getBackoffPolicy()
            r0 = r17
            com.baicizhan.client.framework.network.http.HttpContext r5 = r0.context
            com.baicizhan.client.framework.network.http.HttpResponse r11 = r5.getResponse()
            if (r6 > 0) goto L_0x0036
            com.baicizhan.client.framework.network.http.HttpTaskSetting r5 = com.baicizhan.client.framework.network.http.HttpTaskSetting.getInstance()
            com.baicizhan.client.framework.network.http.TimeOutData r5 = r5.getTimeOutData()
            int r6 = r5.getTimeOutAuto()
        L_0x0036:
            if (r2 > 0) goto L_0x01a4
            com.baicizhan.client.framework.network.http.HttpTaskSetting r2 = com.baicizhan.client.framework.network.http.HttpTaskSetting.getInstance()
            int r2 = r2.getRetryCount()
            r9 = r2
        L_0x0041:
            if (r7 > 0) goto L_0x004f
            com.baicizhan.client.framework.network.http.HttpTaskSetting r2 = com.baicizhan.client.framework.network.http.HttpTaskSetting.getInstance()
            com.baicizhan.client.framework.network.http.TimeOutData r2 = r2.getConnectTimeOutData()
            int r7 = r2.getTimeOutAuto()
        L_0x004f:
            r2 = 0
            r11.retrying = r2
            r5 = 0
            com.baicizhan.client.framework.network.http.HttpImpl r2 = new com.baicizhan.client.framework.network.http.HttpImpl
            r0 = r17
            com.baicizhan.client.framework.network.http.HttpContext r8 = r0.context
            r2.<init>(r8)
            r8 = r5
            r5 = r6
        L_0x005e:
            r0 = r17
            com.baicizhan.client.framework.network.http.HttpContext r6 = r0.context
            com.baicizhan.client.framework.network.http.HttpResponse r6 = r6.getResponse()
            boolean r6 = r6.isCancel
            if (r6 != 0) goto L_0x00bd
            if (r10 == 0) goto L_0x01a1
            int r6 = r11.retrying     // Catch:{ SocketTimeoutException -> 0x00c6, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            long r12 = r10.getBackoff(r9, r6)     // Catch:{ SocketTimeoutException -> 0x00c6, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            int r6 = (int) r12
            boolean r5 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            if (r5 == 0) goto L_0x00a0
            boolean r5 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            if (r5 == 0) goto L_0x00a0
            org.slf4j.Logger r5 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            java.lang.String r12 = "trace download, backoff timeout [{}], connection timout [{}], retrying [{}]"
            r13 = 3
            java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            r14 = 0
            java.lang.Integer r15 = java.lang.Integer.valueOf(r6)     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            r13[r14] = r15     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            r14 = 1
            java.lang.Integer r15 = java.lang.Integer.valueOf(r7)     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            r13[r14] = r15     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            r14 = 2
            int r15 = r11.retrying     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            r13[r14] = r15     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            r5.info(r12, r13)     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
        L_0x00a0:
            r5 = r18
            boolean r8 = r2.downloadFile(r3, r4, r5, r6, r7)     // Catch:{ SocketTimeoutException -> 0x0191, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            boolean r5 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ SocketTimeoutException -> 0x0199, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            if (r5 == 0) goto L_0x00bd
            boolean r5 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()     // Catch:{ SocketTimeoutException -> 0x0199, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            if (r5 == 0) goto L_0x00bd
            org.slf4j.Logger r5 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ SocketTimeoutException -> 0x0199, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            java.lang.String r12 = "trace download ret: [{}]"
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r8)     // Catch:{ SocketTimeoutException -> 0x0199, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
            r5.info(r12, r13)     // Catch:{ SocketTimeoutException -> 0x0199, FileNotFoundException -> 0x00fc, NoNeed2DownloadException -> 0x011d, Exception -> 0x013e, Throwable -> 0x0160 }
        L_0x00bd:
            if (r8 == 0) goto L_0x018e
            r2 = 2
        L_0x00c0:
            r0 = r18
            r0.sendEmptyMessage(r2)
            return r8
        L_0x00c6:
            r6 = move-exception
            r16 = r6
            r6 = r5
            r5 = r8
            r8 = r16
        L_0x00cd:
            int r12 = r11.retrying
            int r12 = r12 + 1
            r11.retrying = r12
            int r12 = r11.retrying
            if (r12 < r9) goto L_0x00f8
            boolean r2 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r2 == 0) goto L_0x00ea
            boolean r2 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()
            if (r2 == 0) goto L_0x00ea
            org.slf4j.Logger r2 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.String r3 = "trace download ex, timeout. "
            r2.error(r3, r8)
        L_0x00ea:
            r0 = r17
            com.baicizhan.client.framework.network.http.HttpContext r2 = r0.context
            com.baicizhan.client.framework.network.http.HttpResponse r2 = r2.getResponse()
            r3 = -13
            r2.responseCode = r3
            r8 = r5
            goto L_0x00bd
        L_0x00f8:
            r8 = r5
            r5 = r6
            goto L_0x005e
        L_0x00fc:
            r2 = move-exception
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r3 == 0) goto L_0x0110
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()
            if (r3 == 0) goto L_0x0110
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.String r4 = "trace download ex 1 "
            r3.error(r4, r2)
        L_0x0110:
            r0 = r17
            com.baicizhan.client.framework.network.http.HttpContext r2 = r0.context
            com.baicizhan.client.framework.network.http.HttpResponse r2 = r2.getResponse()
            r3 = -100
            r2.responseCode = r3
            goto L_0x00bd
        L_0x011d:
            r2 = move-exception
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r3 == 0) goto L_0x0131
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()
            if (r3 == 0) goto L_0x0131
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.String r4 = "trace download ex 2 "
            r3.error(r4, r2)
        L_0x0131:
            r0 = r17
            com.baicizhan.client.framework.network.http.HttpContext r2 = r0.context
            com.baicizhan.client.framework.network.http.HttpResponse r2 = r2.getResponse()
            r3 = -101(0xffffffffffffff9b, float:NaN)
            r2.responseCode = r3
            goto L_0x00bd
        L_0x013e:
            r2 = move-exception
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r3 == 0) goto L_0x0152
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()
            if (r3 == 0) goto L_0x0152
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.String r4 = "trace download ex 3 "
            r3.error(r4, r2)
        L_0x0152:
            r0 = r17
            com.baicizhan.client.framework.network.http.HttpContext r2 = r0.context
            com.baicizhan.client.framework.network.http.HttpResponse r2 = r2.getResponse()
            r3 = -10
            r2.responseCode = r3
            goto L_0x00bd
        L_0x0160:
            r2 = move-exception
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r3 == 0) goto L_0x0174
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()
            if (r3 == 0) goto L_0x0174
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.String r4 = "trace download throwable "
            r3.error(r4, r2)
        L_0x0174:
            r0 = r17
            com.baicizhan.client.framework.network.http.HttpContext r2 = r0.context
            com.baicizhan.client.framework.network.http.HttpResponse r2 = r2.getResponse()
            int r2 = r2.responseCode
            if (r2 < 0) goto L_0x00bd
            r0 = r17
            com.baicizhan.client.framework.network.http.HttpContext r2 = r0.context
            com.baicizhan.client.framework.network.http.HttpResponse r2 = r2.getResponse()
            r3 = -10
            r2.responseCode = r3
            goto L_0x00bd
        L_0x018e:
            r2 = 3
            goto L_0x00c0
        L_0x0191:
            r5 = move-exception
            r16 = r5
            r5 = r8
            r8 = r16
            goto L_0x00cd
        L_0x0199:
            r5 = move-exception
            r16 = r5
            r5 = r8
            r8 = r16
            goto L_0x00cd
        L_0x01a1:
            r6 = r5
            goto L_0x00a0
        L_0x01a4:
            r9 = r2
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.network.http.HttpManager.downloadFile(android.os.Handler):boolean");
    }

    public void get(int i) {
        int i2;
        HttpRequest request = this.context.getRequest();
        int readTimeout = request.getReadTimeout();
        int connTimeout = request.getConnTimeout();
        if (readTimeout <= 0) {
            i2 = HttpTaskSetting.getInstance().getTimeOutData().getTimeOutAuto();
        } else {
            i2 = readTimeout;
        }
        if (i <= 0) {
            i = HttpTaskSetting.getInstance().getRetryCount();
        }
        if (connTimeout <= 0) {
            connTimeout = HttpTaskSetting.getInstance().getConnectTimeOutData().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = 0;
        boolean z = true;
        while (!this.context.getResponse().isCancel && z && i3 < i) {
            HttpStat httpStat = new HttpStat();
            try {
                httpStat.retry = i3 + 1;
                new HttpImpl(this.context).getNetData(i2, connTimeout, httpStat);
                if (this.context.getResponse().responseCode != 200) {
                    httpStat.exception = String.valueOf(this.context.getResponse().responseCode) + "|retryCount:" + i3;
                    z = isNeedRetry(this.context.getResponse().responseCode);
                    this.context.putStat(httpStat);
                    httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                    this.context.putStat(httpStat);
                    i3++;
                } else {
                    httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                    this.context.putStat(httpStat);
                    return;
                }
//            } catch (SocketException e) {
//                httpStat.exception = String.valueOf(this.context.getResponse().responseCode) + "|retryCount:" + i3 + "|" + e.getClass() + "|" + e.getMessage();
//                this.context.getResponse().responseCode = -12;
//                this.context.putStat(httpStat);
//                httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
//                this.context.putStat(httpStat);
//                z = true;
//            } catch (SocketTimeoutException e2) {
//                httpStat.exception = String.valueOf(this.context.getResponse().responseCode) + "|retryCount:" + i3 + "|" + e2.getClass() + "|" + e2.getMessage();
//                this.context.getResponse().responseCode = -13;
//                this.context.putStat(httpStat);
//                httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
//                this.context.putStat(httpStat);
//                z = true;
            } catch (Exception e3) {
                httpStat.exception = String.valueOf(this.context.getResponse().responseCode) + "|retryCount:" + i3 + "|" + e3.getClass() + "|" + e3.getMessage();
                this.context.getResponse().responseCode = -10;
                if (LSwitcher.isOpened() && LSwitcher.isOpenOnNet()) {
                    C0789L.log.error("error = " + e3.getMessage());
                }
                this.context.putStat(httpStat);
                httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                this.context.putStat(httpStat);
                return;
            } catch (Throwable th) {
                httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                this.context.putStat(httpStat);
                throw th;
            }
        }
    }

    public boolean uploadFile(Handler handler) {
        int i;
        int i2;
        ApacheHttpRequest apacheHttpRequest = this.context.getApacheHttpRequest();
        int readTimeout = apacheHttpRequest.getReadTimeout();
        int maxRetry = apacheHttpRequest.getMaxRetry();
        int connTimeout = apacheHttpRequest.getConnTimeout();
        if (readTimeout <= 0) {
            i = HttpTaskSetting.getInstance().getTimeOutData().getTimeOutAuto();
        } else {
            i = readTimeout;
        }
        if (maxRetry <= 0) {
            i2 = HttpTaskSetting.getInstance().getRetryCount();
        } else {
            i2 = maxRetry;
        }
        if (connTimeout <= 0) {
            connTimeout = HttpTaskSetting.getInstance().getConnectTimeOutData().getTimeOutAuto();
        }
        int i3 = 0;
        boolean z = true;
        boolean z2 = false;
//        while (!this.context.getApacheHttpResponse().cancelable.mCanceled && z && i3 < i2) {
//            try {
//                z2 = new HttpImpl(this.context).uploadFile(handler, i, connTimeout, null);
//                if (this.context.getApacheHttpResponse().responseCode == 200) {
//                    break;
//                }
//                z = isNeedRetry(this.context.getApacheHttpResponse().responseCode);
//                z2 = false;
//                i3++;
//            } catch (SocketException e) {
//                this.context.getApacheHttpResponse().responseCode = -12;
//                z = true;
//            } catch (SocketTimeoutException e2) {
//                this.context.getApacheHttpResponse().responseCode = -13;
//                z = true;
//            } catch (Exception e3) {
//                this.context.getApacheHttpResponse().responseCode = -10;
//                if (LSwitcher.isOpened() && LSwitcher.isOpenOnNet()) {
//                    C0789L.log.error("error = " + e3.getMessage());
//                }
//            }
//        }
        handler.sendEmptyMessage(z2 ? 5 : 6);
        return z2;
    }

    private void postRawNetData() {
        int i;
        int i2;
        HttpRequest request = this.context.getRequest();
        int readTimeout = request.getReadTimeout();
        int maxRetry = request.getMaxRetry();
        int connTimeout = request.getConnTimeout();
        if (readTimeout <= 0) {
            i = HttpTaskSetting.getInstance().getTimeOutData().getTimeOutAuto();
        } else {
            i = readTimeout;
        }
        if (maxRetry <= 0) {
            i2 = HttpTaskSetting.getInstance().getRetryCount();
        } else {
            i2 = maxRetry;
        }
        if (connTimeout <= 0) {
            connTimeout = HttpTaskSetting.getInstance().getConnectTimeOutData().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = 0;
        boolean z = true;
        while (!this.context.getResponse().isCancel && z && i3 < i2) {
            HttpStat httpStat = new HttpStat();
            httpStat.retry = i3 + 1;
            try {
                new HttpImpl(this.context).postBytesNetData(i, connTimeout, httpStat);
                if (this.context.getResponse().responseCode != 200) {
                    httpStat.exception = String.valueOf(this.context.getResponse().responseCode) + "|retryCount:" + i3;
                    z = isNeedRetry(this.context.getResponse().responseCode);
                    this.context.putStat(httpStat);
                    httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                    this.context.putStat(httpStat);
                    i3++;
                } else {
                    httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                    this.context.putStat(httpStat);
                    return;
                }
//            } catch (SocketException e) {
//                this.context.getResponse().responseCode = -12;
//                if (LSwitcher.isOpened() && LSwitcher.isOpenOnNet()) {
//                    C0789L.log.error("SocketException " + e.getMessage());
//                }
//                this.context.putStat(httpStat);
//                httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
//                this.context.putStat(httpStat);
//                z = true;
//            } catch (SocketTimeoutException e2) {
//                this.context.getResponse().responseCode = -13;
//                if (LSwitcher.isOpened() && LSwitcher.isOpenOnNet()) {
//                    C0789L.log.error("SocketTimeoutException " + e2.getMessage());
//                }
//                this.context.putStat(httpStat);
//                httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
//                this.context.putStat(httpStat);
//                z = true;
            } catch (UnsupportedOperationException e3) {
                this.context.getResponse().responseCode = -14;
                this.context.putStat(httpStat);
                httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                this.context.putStat(httpStat);
                z = false;
            } catch (Throwable th) {
                httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                this.context.putStat(httpStat);
                throw th;
            }
        }
    }

    private boolean isNeedRetry(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        if (i == 502 || i == 503 || i == 504) {
            return false;
        }
        return true;
    }

    public void post() {
        if (this.context.getRequest().hasRaw()) {
            postRawNetData();
        } else {
            postNetData();
        }
    }

    private void postNetData() {
        int i;
        int i2;
        HttpRequest request = this.context.getRequest();
        int readTimeout = request.getReadTimeout();
        int maxRetry = request.getMaxRetry();
        int connTimeout = request.getConnTimeout();
        if (readTimeout <= 0) {
            i = HttpTaskSetting.getInstance().getTimeOutData().getTimeOutAuto();
        } else {
            i = readTimeout;
        }
        if (maxRetry <= 0) {
            i2 = HttpTaskSetting.getInstance().getRetryCount();
        } else {
            i2 = maxRetry;
        }
        if (connTimeout <= 0) {
            connTimeout = HttpTaskSetting.getInstance().getConnectTimeOutData().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = 0;
        boolean z = true;
        while (!this.context.getResponse().isCancel && z && i3 < i2) {
            HttpStat httpStat = new HttpStat();
            httpStat.retry = i3 + 1;
            try {
                new HttpImpl(this.context).postNetData(i, connTimeout, httpStat);
                if (this.context.getResponse().responseCode != 200) {
                    httpStat.exception = String.valueOf(this.context.getResponse().responseCode) + "|retryCount:" + i3;
                    z = isNeedRetry(this.context.getResponse().responseCode);
                    this.context.putStat(httpStat);
                    httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                    this.context.putStat(httpStat);
                    i3++;
                } else {
                    httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                    this.context.putStat(httpStat);
                    return;
                }
//            } catch (SocketException e) {
//                this.context.getResponse().responseCode = -12;
//                if (LSwitcher.isOpened() && LSwitcher.isOpenOnNet()) {
//                    C0789L.log.error("SocketException " + e.getMessage());
//                }
//                this.context.putStat(httpStat);
//                httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
//                this.context.putStat(httpStat);
//                z = true;
//            } catch (SocketTimeoutException e2) {
//                this.context.getResponse().responseCode = -13;
//                if (LSwitcher.isOpened() && LSwitcher.isOpenOnNet()) {
//                    C0789L.log.error("SocketTimeoutException " + e2.getMessage());
//                }
//                this.context.putStat(httpStat);
//                httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
//                this.context.putStat(httpStat);
//                z = true;
            } catch (UnsupportedOperationException e3) {
                this.context.getResponse().responseCode = -14;
                this.context.putStat(httpStat);
                httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                this.context.putStat(httpStat);
                z = false;
            } catch (Throwable th) {
                httpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                this.context.putStat(httpStat);
                throw th;
            }
        }
    }
}
