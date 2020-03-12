package com.baicizhan.client.framework.network.http;

import android.os.Build.VERSION;
import android.os.Handler;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import com.baicizhan.client.framework.network.http.NetUtil.NetTpyeEnmu;
import com.baicizhan.client.framework.util.Cancelable;
import com.baicizhan.client.framework.util.CloseHelper;
import com.baicizhan.client.framework.util.archive.FileDecompressHelper;
import com.baicizhan.client.framework.util.archive.GzipHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketException;
import java.net.URL;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import p012ch.qos.logback.classic.spi.CallerData;

class HttpImpl {
    private static final int BUFFERSIZE = 102400;
    private static final int POSTDATATIMEOUT = 15000;
    private static String boundary = "--------7da3d81520810*";
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private HttpContext context;
    private HttpURLConnection mConn;
    private Timer timer;
    private TimerTask timerTask = new TimerTask() {
        public void run() {
            try {
                HttpImpl.this.cancelNetConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    static {
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        } else {
            System.setProperty("http.keepAlive", "true");
        }
    }

    public HttpImpl(HttpContext httpContext) {
        if (httpContext == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.context = httpContext;
    }

    public void cancelNetConnect() {
        this.context.getResponse().isCancel = true;
        CloseHelper.close(this.mConn);
    }

    private HttpURLConnection getConnect(URL url) {
        NetTpyeEnmu netType = NetUtil.getNetType();
        try {
            if (netType == NetTpyeEnmu.UNAVAIL) {
                return null;
            }
            if (netType == NetTpyeEnmu.NET || netType == NetTpyeEnmu.WAP) {
                String defaultHost = NetUtil.getDefaultHost();
                if (defaultHost != null && defaultHost.length() > 0) {
                    if (isCMCCServer(defaultHost)) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(NetUtil.getDefaultHost());
                        String file = url.getFile();
                        if (file != null && file.startsWith(CallerData.f1661NA)) {
                            sb.append("/");
                        }
                        sb.append(file);
                        URL url2 = new URL(sb.toString());
                        this.mConn = (HttpURLConnection) url2.openConnection();
                        this.context.getRequest().addHeadData("X-Online-Host", url.getHost());
                        if (LSwitcher.isOpened() && LSwitcher.isOpenOnNet()) {
                            C0789L.log.info("set cmcc server proxy in mobile net, new url [{}], old url [{}]", (Object) url2, (Object) url);
                        }
                    } else {
                        if (LSwitcher.isOpened() && LSwitcher.isOpenOnNet()) {
                            C0789L.log.info("set inet proxy in mobile net");
                        }
                        this.mConn = (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress(NetUtil.getDefaultHost(), NetUtil.getDefaultPort())));
                    }
                }
            }
            this.mConn = (HttpURLConnection) url.openConnection();
            return this.mConn;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006b A[SYNTHETIC, Splitter:B:26:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.http.client.methods.HttpPost getHttpPost(URL r7) {
        /*
            r6 = this;
            r0 = 0
            com.baicizhan.client.framework.network.http.NetUtil$NetTpyeEnmu r1 = com.baicizhan.client.framework.network.http.NetUtil.getNetType()
            com.baicizhan.client.framework.network.http.NetUtil$NetTpyeEnmu r2 = com.baicizhan.client.framework.network.http.NetUtil.NetTpyeEnmu.UNAVAIL     // Catch:{ Exception -> 0x0087 }
            if (r1 != r2) goto L_0x000a
        L_0x0009:
            return r0
        L_0x000a:
            com.baicizhan.client.framework.network.http.NetUtil$NetTpyeEnmu r2 = com.baicizhan.client.framework.network.http.NetUtil.NetTpyeEnmu.NET     // Catch:{ Exception -> 0x0087 }
            if (r1 == r2) goto L_0x0012
            com.baicizhan.client.framework.network.http.NetUtil$NetTpyeEnmu r2 = com.baicizhan.client.framework.network.http.NetUtil.NetTpyeEnmu.WAP     // Catch:{ Exception -> 0x0087 }
            if (r1 != r2) goto L_0x00b8
        L_0x0012:
            java.lang.String r1 = com.baicizhan.client.framework.network.http.NetUtil.getDefaultHost()     // Catch:{ Exception -> 0x0087 }
            if (r1 == 0) goto L_0x00b8
            int r2 = r1.length()     // Catch:{ Exception -> 0x0087 }
            if (r2 <= 0) goto L_0x00b8
            boolean r1 = r6.isCMCCServer(r1)     // Catch:{ Exception -> 0x0087 }
            if (r1 == 0) goto L_0x008d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0087 }
            r2 = 80
            r1.<init>(r2)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = "http://"
            r1.append(r2)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = com.baicizhan.client.framework.network.http.NetUtil.getDefaultHost()     // Catch:{ Exception -> 0x0087 }
            r1.append(r2)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = r7.getFile()     // Catch:{ Exception -> 0x0087 }
            if (r2 == 0) goto L_0x004a
            java.lang.String r3 = "?"
            boolean r3 = r2.startsWith(r3)     // Catch:{ Exception -> 0x0087 }
            if (r3 == 0) goto L_0x004a
            java.lang.String r3 = "/"
            r1.append(r3)     // Catch:{ Exception -> 0x0087 }
        L_0x004a:
            r1.append(r2)     // Catch:{ Exception -> 0x0087 }
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0087 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0087 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0087 }
            org.apache.http.client.methods.HttpPost r1 = new org.apache.http.client.methods.HttpPost     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0087 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = "X-Online-Host"
            java.lang.String r3 = r7.getHost()     // Catch:{ Exception -> 0x00a7 }
            r1.addHeader(r2, r3)     // Catch:{ Exception -> 0x00a7 }
            r2 = r0
        L_0x0069:
            if (r1 != 0) goto L_0x00b6
            org.apache.http.client.methods.HttpPost r0 = new org.apache.http.client.methods.HttpPost     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x00b1 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00b1 }
        L_0x0074:
            com.baicizhan.client.framework.network.http.HttpContext r1 = r6.context     // Catch:{ Exception -> 0x0087 }
            com.baicizhan.client.framework.network.http.ApacheHttpRequest r1 = r1.getApacheHttpRequest()     // Catch:{ Exception -> 0x0087 }
            r1.setApacheHttpPost(r0)     // Catch:{ Exception -> 0x0087 }
            com.baicizhan.client.framework.network.http.HttpContext r1 = r6.context     // Catch:{ Exception -> 0x0087 }
            com.baicizhan.client.framework.network.http.ApacheHttpRequest r1 = r1.getApacheHttpRequest()     // Catch:{ Exception -> 0x0087 }
            r1.setApacheHttpProxy(r2)     // Catch:{ Exception -> 0x0087 }
            goto L_0x0009
        L_0x0087:
            r1 = move-exception
        L_0x0088:
            r1.printStackTrace()
            goto L_0x0009
        L_0x008d:
            org.apache.http.client.methods.HttpPost r1 = new org.apache.http.client.methods.HttpPost     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x0087 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0087 }
            org.apache.http.HttpHost r0 = new org.apache.http.HttpHost     // Catch:{ Exception -> 0x00ac }
            java.lang.String r2 = com.baicizhan.client.framework.network.http.NetUtil.getDefaultHost()     // Catch:{ Exception -> 0x00ac }
            int r3 = com.baicizhan.client.framework.network.http.NetUtil.getDefaultPort()     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = "http"
            r0.<init>(r2, r3, r4)     // Catch:{ Exception -> 0x00ac }
            r2 = r0
            goto L_0x0069
        L_0x00a7:
            r0 = move-exception
            r5 = r0
            r0 = r1
            r1 = r5
            goto L_0x0088
        L_0x00ac:
            r0 = move-exception
            r5 = r0
            r0 = r1
            r1 = r5
            goto L_0x0088
        L_0x00b1:
            r0 = move-exception
            r5 = r0
            r0 = r1
            r1 = r5
            goto L_0x0088
        L_0x00b6:
            r0 = r1
            goto L_0x0074
        L_0x00b8:
            r2 = r0
            r1 = r0
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.network.http.HttpImpl.getHttpPost(java.net.URL):org.apache.http.client.methods.HttpPost");
    }

    /* JADX INFO: finally extract failed */
    public void getNetData(int i, int i2, HttpStat httpStat) {
        httpStat.executeStatus = -1;
        if (this.context.getResponse().isCancel) {
            throw new HttpCancelException();
        }
        String generateGetString = this.context.getRequest().generateGetString(httpStat);
        URL url = new URL(generateGetString);
        if (this.context.getResponse().isCancel) {
            throw new HttpCancelException();
        }
        httpStat.executeStatus = -2;
        HttpURLConnection connect = getConnect(url);
        httpStat.executeStatus = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.mConn == null) {
                throw new SocketException("network not available.");
            }
            this.mConn.setRequestMethod("GET");
            this.mConn.setConnectTimeout(i2);
            this.mConn.setReadTimeout(i);
            this.context.getRequest().wrapHead(connect);
            if (this.context.getResponse().isCancel) {
                throw new HttpCancelException();
            }
            httpStat.dnsTime = new Date().getTime() - currentTimeMillis;
            if (LSwitcher.isOpened() && LSwitcher.isOpenOnNet()) {
                C0789L.log.info("GET:" + generateGetString);
            }
            httpStat.executeStatus = -4;
            connect.connect();
            httpStat.executeStatus = -5;
            httpStat.connectTime = (new Date().getTime() - currentTimeMillis) - httpStat.dnsTime;
            if (this.context.getResponse().isCancel) {
                throw new HttpCancelException();
            }
            httpStat.executeStatus = -8;
            this.context.getResponse().getResponseHead(this.mConn);
            httpStat.responsedCode = this.context.getResponse().responseCode;
            byte[] response = getResponse(this.mConn);
            if (response != null) {
                httpStat.downloadSize = response.length;
                this.context.getResponse().retBytes = decodeByGZIP(this.context.getResponse().contentEncoding, response);
            }
            httpStat.executeStatus = -9;
            httpStat.rspTime = new Date().getTime() - currentTimeMillis;
            if (this.mConn != null) {
                this.mConn.disconnect();
            }
        } catch (Throwable th) {
            if (this.mConn != null) {
                this.mConn.disconnect();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final byte[] decodeByGZIP(String str, byte[] bArr) {
        if (str == null || !str.toLowerCase(Locale.US).contains("gzip")) {
            return bArr;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(BUFFERSIZE);
        GzipHelper.decompress(byteArrayInputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] getResponse(HttpURLConnection r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 102400(0x19000, float:1.43493E-40)
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>(r1)
            if (r7 == 0) goto L_0x0055
            r1 = 102400(0x19000, float:1.43493E-40)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0050 }
            java.io.InputStream r0 = r7.getInputStream()     // Catch:{ all -> 0x0050 }
        L_0x0014:
            com.baicizhan.client.framework.network.http.HttpContext r3 = r6.context     // Catch:{ all -> 0x002a }
            com.baicizhan.client.framework.network.http.HttpResponse r3 = r3.getResponse()     // Catch:{ all -> 0x002a }
            boolean r3 = r3.isCancel     // Catch:{ all -> 0x002a }
            if (r3 != 0) goto L_0x0035
            int r3 = r0.read(r1)     // Catch:{ all -> 0x002a }
            r4 = -1
            if (r3 == r4) goto L_0x0035
            r4 = 0
            r2.write(r1, r4, r3)     // Catch:{ all -> 0x002a }
            goto L_0x0014
        L_0x002a:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x002e:
            com.baicizhan.client.framework.util.CloseHelper.close(r2)
            com.baicizhan.client.framework.util.CloseHelper.close(r1)
            throw r0
        L_0x0035:
            com.baicizhan.client.framework.network.http.HttpContext r1 = r6.context     // Catch:{ all -> 0x002a }
            com.baicizhan.client.framework.network.http.HttpResponse r1 = r1.getResponse()     // Catch:{ all -> 0x002a }
            boolean r1 = r1.isCancel     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0045
            com.baicizhan.client.framework.network.http.HttpCancelException r1 = new com.baicizhan.client.framework.network.http.HttpCancelException     // Catch:{ all -> 0x002a }
            r1.<init>()     // Catch:{ all -> 0x002a }
            throw r1     // Catch:{ all -> 0x002a }
        L_0x0045:
            byte[] r1 = r2.toByteArray()     // Catch:{ all -> 0x002a }
        L_0x0049:
            com.baicizhan.client.framework.util.CloseHelper.close(r2)
            com.baicizhan.client.framework.util.CloseHelper.close(r0)
            return r1
        L_0x0050:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x002e
        L_0x0055:
            r1 = r0
            goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.network.http.HttpImpl.getResponse(java.net.HttpURLConnection):byte[]");
    }

    private boolean isCMCCServer(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public void postBytesNetData(int i, int i2, HttpStat httpStat) {
        httpStat.executeStatus = -1;
        try {
            URL url = new URL(this.context.getRequest().getUrl());
            if (this.context.getResponse().isCancel) {
                throw new HttpCancelException();
            }
            httpStat.executeStatus = -2;
            HttpURLConnection connect = getConnect(url);
            httpStat.executeStatus = -3;
            System.currentTimeMillis();
            if (this.mConn == null) {
                throw new SocketException("network not available.");
            }
            this.mConn.setRequestMethod("POST");
            this.mConn.setDoOutput(true);
            this.mConn.setDoInput(true);
            this.mConn.setConnectTimeout(i2);
            this.mConn.setReadTimeout(i);
            this.mConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.context.getResponse().isCancel) {
                throw new HttpCancelException();
            }
            this.context.getRequest().wrapHead(connect);
            if (this.context.getResponse().isCancel) {
                throw new HttpCancelException();
            }
            long time = new Date().getTime();
            httpStat.dnsTime = new Date().getTime() - time;
            httpStat.executeStatus = -4;
            connect.connect();
            httpStat.executeStatus = -5;
            httpStat.connectTime = (new Date().getTime() - time) - httpStat.dnsTime;
            if (this.context.getResponse().isCancel) {
                throw new HttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.timerTask, 45000);
            }
            httpStat.executeStatus = -6;
            this.context.getRequest().wrapPost2Conn(connect, boundary, httpStat);
            httpStat.executeStatus = -7;
            if (this.context.getResponse().isCancel) {
                throw new HttpCancelException();
            }
            httpStat.executeStatus = -8;
            this.context.getResponse().getResponseHead(this.mConn);
            httpStat.responsedCode = this.context.getResponse().responseCode;
            byte[] response = getResponse(this.mConn);
            if (response != null) {
                httpStat.downloadSize = response.length;
                this.context.getResponse().retBytes = decodeByGZIP(this.context.getResponse().contentEncoding, response);
            }
            if (this.context.getResponse().retBytes != null) {
                httpStat.downloadSize = this.context.getResponse().retBytes.length;
            }
            httpStat.rspTime = new Date().getTime() - time;
            httpStat.executeStatus = -9;
            if (this.timer != null) {
                this.timer.cancel();
            }
            CloseHelper.close(this.mConn);
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            CloseHelper.close(this.mConn);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x02d4 A[Catch:{ IOException -> 0x02da, all -> 0x047b }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02df A[Catch:{ IOException -> 0x02da, all -> 0x047b }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f A[Catch:{ IOException -> 0x0466, all -> 0x007e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean downloadFile(String r28, boolean r29, Handler r30, int r31, int r32) {
        /*
            r27 = this;
            r9 = 0
            r6 = 0
            r7 = 0
            java.net.URL r8 = new java.net.URL     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r0 = r27
            com.baicizhan.client.framework.network.http.HttpContext r10 = r0.context     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            com.baicizhan.client.framework.network.http.HttpRequest r10 = r10.getRequest()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.lang.String r10 = r10.getUrl()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r8.<init>(r10)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.net.HttpURLConnection r10 = getConnection(r8)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r0 = r27
            r0.mConn = r10     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r0 = r27
            java.net.HttpURLConnection r10 = r0.mConn     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            if (r10 != 0) goto L_0x0094
            boolean r6 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            if (r6 == 0) goto L_0x0035
            boolean r6 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            if (r6 == 0) goto L_0x0035
            org.slf4j.Logger r6 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.lang.String r8 = "trace download, get null connection, throw socket exception."
            r6.error(r8)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
        L_0x0035:
            java.net.SocketException r6 = new java.net.SocketException     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r6.<init>()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            throw r6     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
        L_0x003b:
            r6 = move-exception
            r8 = r9
        L_0x003d:
            boolean r9 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ IOException -> 0x0466 }
            if (r9 == 0) goto L_0x0065
            boolean r9 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()     // Catch:{ IOException -> 0x0466 }
            if (r9 == 0) goto L_0x0065
            org.slf4j.Logger r9 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x0466 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0466 }
            java.lang.String r11 = "trace download ex, resp code "
            r10.<init>(r11)     // Catch:{ IOException -> 0x0466 }
            r0 = r27
            java.net.HttpURLConnection r11 = r0.mConn     // Catch:{ IOException -> 0x0466 }
            int r11 = r11.getResponseCode()     // Catch:{ IOException -> 0x0466 }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ IOException -> 0x0466 }
            java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x0466 }
            r9.error(r10, r6)     // Catch:{ IOException -> 0x0466 }
        L_0x0065:
            r0 = r27
            java.net.HttpURLConnection r9 = r0.mConn     // Catch:{ IOException -> 0x0466 }
            java.io.InputStream r9 = r9.getErrorStream()     // Catch:{ IOException -> 0x0466 }
            if (r9 == 0) goto L_0x007d
            r10 = 102400(0x19000, float:1.43493E-40)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x0466 }
        L_0x0074:
            int r11 = r9.read(r10)     // Catch:{ IOException -> 0x0466 }
            if (r11 > 0) goto L_0x0074
            r9.close()     // Catch:{ IOException -> 0x0466 }
        L_0x007d:
            throw r6     // Catch:{ all -> 0x007e }
        L_0x007e:
            r6 = move-exception
            r9 = r8
            r8 = r7
        L_0x0081:
            com.baicizhan.client.framework.util.CloseHelper.close(r9)
            r0 = r27
            java.net.HttpURLConnection r7 = r0.mConn
            com.baicizhan.client.framework.util.CloseHelper.close(r7)
            com.baicizhan.client.framework.util.CloseHelper.close(r8)
            r7 = 0
            r0 = r27
            r0.mConn = r7
            throw r6
        L_0x0094:
            r0 = r27
            java.net.HttpURLConnection r10 = r0.mConn     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r0 = r32
            r10.setConnectTimeout(r0)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r0 = r27
            java.net.HttpURLConnection r10 = r0.mConn     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r0 = r31
            r10.setReadTimeout(r0)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r0 = r27
            java.net.HttpURLConnection r10 = r0.mConn     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r11 = 0
            r10.setInstanceFollowRedirects(r11)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r0 = r27
            com.baicizhan.client.framework.network.http.HttpContext r10 = r0.context     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            com.baicizhan.client.framework.network.http.HttpResponse r10 = r10.getResponse()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            boolean r10 = r10.isCancel     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            if (r10 == 0) goto L_0x00e5
            boolean r6 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            if (r6 == 0) goto L_0x00cf
            boolean r6 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            if (r6 == 0) goto L_0x00cf
            org.slf4j.Logger r6 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.lang.String r8 = "trace download, download is canceled, dest path [{}]"
            r0 = r28
            r6.info(r8, r0)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
        L_0x00cf:
            r6 = 0
            com.baicizhan.client.framework.util.CloseHelper.close(r6)
            r0 = r27
            java.net.HttpURLConnection r6 = r0.mConn
            com.baicizhan.client.framework.util.CloseHelper.close(r6)
            r6 = 0
            com.baicizhan.client.framework.util.CloseHelper.close(r6)
            r6 = 0
            r0 = r27
            r0.mConn = r6
            r6 = 0
        L_0x00e4:
            return r6
        L_0x00e5:
            if (r28 != 0) goto L_0x0116
            java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.lang.String r8 = com.baicizhan.client.framework.util.Common.md5(r8)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.io.File r8 = com.baicizhan.client.framework.util.FileHelper.createFileIfNotFound(r8)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r16 = r8
        L_0x00f5:
            boolean r8 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            if (r8 == 0) goto L_0x010a
            boolean r8 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            if (r8 == 0) goto L_0x010a
            org.slf4j.Logger r8 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.lang.String r10 = "trace download, dest file: [{}]"
            r0 = r16
            r8.info(r10, r0)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
        L_0x010a:
            if (r16 != 0) goto L_0x011d
            java.io.FileNotFoundException r6 = new java.io.FileNotFoundException     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r6.<init>()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            throw r6     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
        L_0x0112:
            r6 = move-exception
            r8 = r7
            goto L_0x0081
        L_0x0116:
            java.io.File r8 = com.baicizhan.client.framework.util.FileHelper.createFileIfNotFound(r28)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r16 = r8
            goto L_0x00f5
        L_0x011d:
            boolean r8 = r16.isDirectory()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            if (r8 == 0) goto L_0x0159
            boolean r6 = com.baicizhan.client.framework.util.FileHelper.deleteDir(r16)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            boolean r8 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            if (r8 == 0) goto L_0x013e
            boolean r8 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            if (r8 == 0) goto L_0x013e
            org.slf4j.Logger r8 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.lang.String r10 = "delete dir? [{}]"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r8.info(r10, r6)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
        L_0x013e:
            java.io.FileNotFoundException r6 = new java.io.FileNotFoundException     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r8.<init>()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r0 = r16
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.lang.String r10 = " is a directory. Network data cannot be downloaded to a directory."
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r6.<init>(r8)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            throw r6     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
        L_0x0159:
            r0 = r27
            com.baicizhan.client.framework.network.http.HttpContext r8 = r0.context     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            com.baicizhan.client.framework.network.http.HttpResponse r8 = r8.getResponse()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.lang.String r10 = r16.getAbsolutePath()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r8.setDownloadPath(r10)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            long r18 = r16.length()     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r10 = 1
            r0 = r16
            r8.<init>(r0, r10)     // Catch:{ IOException -> 0x003b, all -> 0x0112 }
            r10 = 0
            int r7 = (r18 > r10 ? 1 : (r18 == r10 ? 0 : -1))
            if (r7 <= 0) goto L_0x019c
            r0 = r27
            java.net.HttpURLConnection r7 = r0.mConn     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.String r10 = "Range"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.String r12 = "bytes="
            r11.<init>(r12)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.String r12 = java.lang.String.valueOf(r18)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.String r12 = "-"
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r7.addRequestProperty(r10, r11)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
        L_0x019c:
            r0 = r27
            java.net.HttpURLConnection r7 = r0.mConn     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r7.connect()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r0 = r27
            com.baicizhan.client.framework.network.http.HttpContext r7 = r0.context     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            com.baicizhan.client.framework.network.http.HttpResponse r7 = r7.getResponse()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r0 = r27
            java.net.HttpURLConnection r10 = r0.mConn     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r7.getResponseHead(r10)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r0 = r27
            java.net.HttpURLConnection r7 = r0.mConn     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.String r7 = r7.getContentType()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.String r10 = "text/vnd.wap.wml"
            boolean r7 = r7.contains(r10)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            if (r7 == 0) goto L_0x020b
            boolean r6 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            if (r6 == 0) goto L_0x01df
            boolean r6 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            if (r6 == 0) goto L_0x01df
            org.slf4j.Logger r6 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.String r7 = "trace download, content type is about mobile info [{}]"
            r0 = r27
            com.baicizhan.client.framework.network.http.HttpContext r10 = r0.context     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            com.baicizhan.client.framework.network.http.HttpResponse r10 = r10.getResponse()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.String r10 = r10.contentType     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r6.info(r7, r10)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
        L_0x01df:
            r0 = r27
            java.net.HttpURLConnection r6 = r0.mConn     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r6.disconnect()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r0 = r27
            com.baicizhan.client.framework.network.http.HttpContext r6 = r0.context     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            com.baicizhan.client.framework.network.http.HttpResponse r6 = r6.getResponse()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r7 = -17
            r6.responseCode = r7     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            boolean r6 = r27.downloadFile(r28, r29, r30, r31, r32)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r7 = 0
            com.baicizhan.client.framework.util.CloseHelper.close(r7)
            r0 = r27
            java.net.HttpURLConnection r7 = r0.mConn
            com.baicizhan.client.framework.util.CloseHelper.close(r7)
            com.baicizhan.client.framework.util.CloseHelper.close(r8)
            r7 = 0
            r0 = r27
            r0.mConn = r7
            goto L_0x00e4
        L_0x020b:
            r10 = 0
            r0 = r27
            java.net.HttpURLConnection r7 = r0.mConn     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.String r12 = "Content-Range"
            java.lang.String r7 = r7.getHeaderField(r12)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            if (r7 == 0) goto L_0x022e
            java.lang.String r12 = "/"
            int r12 = r7.indexOf(r12)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r13 = -1
            if (r12 == r13) goto L_0x022e
            int r10 = r12 + 1
            java.lang.String r7 = r7.substring(r10)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r10 = 0
            long r10 = com.baicizhan.client.framework.util.JavaTypesHelper.toLong(r7, r10)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
        L_0x022e:
            r12 = 0
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 != 0) goto L_0x0482
            r0 = r27
            com.baicizhan.client.framework.network.http.HttpContext r7 = r0.context     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            com.baicizhan.client.framework.network.http.HttpResponse r7 = r7.getResponse()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            int r7 = r7.responseCode     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r12 = 200(0xc8, float:2.8E-43)
            if (r7 != r12) goto L_0x0482
            r0 = r27
            java.net.HttpURLConnection r7 = r0.mConn     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.String r12 = "Content-Length"
            java.lang.String r7 = r7.getHeaderField(r12)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            if (r7 == 0) goto L_0x0482
            r10 = 0
            long r10 = com.baicizhan.client.framework.util.JavaTypesHelper.toLong(r7, r10)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r14 = r10
        L_0x0255:
            r10 = 0
            int r7 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r7 <= 0) goto L_0x02ce
            int r7 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r7 < 0) goto L_0x02ce
            r6 = 0
            r7 = 0
            r10 = 0
            com.baicizhan.client.framework.network.http.HttpProgressor r11 = new com.baicizhan.client.framework.network.http.HttpProgressor     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r0 = r18
            r11.<init>(r0, r14)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r0 = r30
            android.os.Message r6 = r0.obtainMessage(r6, r7, r10, r11)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r0 = r30
            r0.sendMessage(r6)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            if (r28 != 0) goto L_0x028f
            if (r29 == 0) goto L_0x028f
            r0 = r27
            r1 = r16
            r2 = r30
            java.lang.String r6 = r0.decompressIfNeed(r1, r2)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            if (r6 == 0) goto L_0x028f
            r0 = r27
            com.baicizhan.client.framework.network.http.HttpContext r7 = r0.context     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            com.baicizhan.client.framework.network.http.HttpResponse r7 = r7.getResponse()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r7.setDownloadPath(r6)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
        L_0x028f:
            boolean r6 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            if (r6 == 0) goto L_0x02aa
            boolean r6 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            if (r6 == 0) goto L_0x02aa
            org.slf4j.Logger r6 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.String r7 = "trace download, no need down, file length [{}], content length [{}]"
            java.lang.Long r10 = java.lang.Long.valueOf(r18)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.lang.Long r11 = java.lang.Long.valueOf(r14)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r6.info(r7, r10, r11)     // Catch:{ IOException -> 0x02da, all -> 0x047b }
        L_0x02aa:
            boolean r6 = r27.isFileSegSuccess()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            if (r6 != 0) goto L_0x02b6
            r6 = 0
            int r6 = (r18 > r6 ? 1 : (r18 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x02cc
        L_0x02b6:
            r6 = 1
        L_0x02b7:
            r7 = 0
            com.baicizhan.client.framework.util.CloseHelper.close(r7)
            r0 = r27
            java.net.HttpURLConnection r7 = r0.mConn
            com.baicizhan.client.framework.util.CloseHelper.close(r7)
            com.baicizhan.client.framework.util.CloseHelper.close(r8)
            r7 = 0
            r0 = r27
            r0.mConn = r7
            goto L_0x00e4
        L_0x02cc:
            r6 = 0
            goto L_0x02b7
        L_0x02ce:
            boolean r7 = r27.isFileSegSuccess()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            if (r7 != 0) goto L_0x02df
            java.lang.UnsupportedOperationException r6 = new java.lang.UnsupportedOperationException     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r6.<init>()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            throw r6     // Catch:{ IOException -> 0x02da, all -> 0x047b }
        L_0x02da:
            r6 = move-exception
            r7 = r8
            r8 = r9
            goto L_0x003d
        L_0x02df:
            r0 = r27
            java.net.HttpURLConnection r7 = r0.mConn     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ IOException -> 0x02da, all -> 0x047b }
            r9 = 102400(0x19000, float:1.43493E-40)
            byte[] r0 = new byte[r9]     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r17 = r0
            r10 = 0
            r12 = 0
            r20 = 0
            int r9 = (r14 > r20 ? 1 : (r14 == r20 ? 0 : -1))
            if (r9 <= 0) goto L_0x02fc
            r12 = 50
            long r12 = r14 / r12
        L_0x02fc:
            r9 = 0
            if (r30 == 0) goto L_0x032f
            r20 = 0
            int r20 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r20 <= 0) goto L_0x032f
            r20 = 0
            int r20 = (r14 > r20 ? 1 : (r14 == r20 ? 0 : -1))
            if (r20 <= 0) goto L_0x032f
            r20 = 0
            r21 = 0
            r22 = 0
            com.baicizhan.client.framework.network.http.HttpProgressor r23 = new com.baicizhan.client.framework.network.http.HttpProgressor     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r0 = r23
            r1 = r18
            r0.<init>(r1, r14)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r0 = r30
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            android.os.Message r20 = r0.obtainMessage(r1, r2, r3, r4)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r0 = r30
            r1 = r20
            r0.sendMessage(r1)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
        L_0x032f:
            boolean r20 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            if (r20 == 0) goto L_0x0372
            boolean r20 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            if (r20 == 0) goto L_0x0372
            org.slf4j.Logger r20 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            java.lang.String r21 = "trace download, start downloading progress, isCancel [{}], file length [{}], content length [{}]"
            r22 = 3
            r0 = r22
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r22 = r0
            r23 = 0
            r0 = r27
            com.baicizhan.client.framework.network.http.HttpContext r0 = r0.context     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r24 = r0
            com.baicizhan.client.framework.network.http.HttpResponse r24 = r24.getResponse()     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r0 = r24
            boolean r0 = r0.isCancel     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r24 = r0
            java.lang.Boolean r24 = java.lang.Boolean.valueOf(r24)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r22[r23] = r24     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r23 = 1
            java.lang.Long r24 = java.lang.Long.valueOf(r18)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r22[r23] = r24     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r23 = 2
            java.lang.Long r24 = java.lang.Long.valueOf(r14)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r22[r23] = r24     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r20.info(r21, r22)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
        L_0x0372:
            r0 = r27
            com.baicizhan.client.framework.network.http.HttpContext r0 = r0.context     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r20 = r0
            com.baicizhan.client.framework.network.http.HttpResponse r20 = r20.getResponse()     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r0 = r20
            boolean r0 = r0.isCancel     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r20 = r0
            if (r20 != 0) goto L_0x03fb
            r0 = r17
            int r20 = r7.read(r0)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r21 = -1
            r0 = r20
            r1 = r21
            if (r0 == r1) goto L_0x03fb
            r0 = r27
            com.baicizhan.client.framework.network.http.HttpContext r0 = r0.context     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r21 = r0
            com.baicizhan.client.framework.network.http.HttpResponse r21 = r21.getResponse()     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r22 = 0
            r0 = r22
            r1 = r21
            r1.retrying = r0     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r21 = 0
            r0 = r17
            r1 = r21
            r2 = r20
            r8.write(r0, r1, r2)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r0 = r20
            long r0 = (long) r0     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r22 = r0
            long r10 = r10 + r22
            int r9 = r9 + r20
            r20 = 0
            int r20 = (r14 > r20 ? 1 : (r14 == r20 ? 0 : -1))
            if (r20 <= 0) goto L_0x0372
            if (r30 == 0) goto L_0x0372
            long r0 = (long) r9     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r20 = r0
            int r20 = (r20 > r12 ? 1 : (r20 == r12 ? 0 : -1))
            if (r20 > 0) goto L_0x03cb
            int r20 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r20 != 0) goto L_0x0372
        L_0x03cb:
            r9 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            com.baicizhan.client.framework.network.http.HttpProgressor r23 = new com.baicizhan.client.framework.network.http.HttpProgressor     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            long r24 = r10 + r18
            r0 = r23
            r1 = r24
            r0.<init>(r1, r14)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r0 = r30
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            android.os.Message r20 = r0.obtainMessage(r1, r2, r3, r4)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r0 = r30
            r1 = r20
            r0.sendMessage(r1)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            goto L_0x0372
        L_0x03f3:
            r6 = move-exception
            r26 = r8
            r8 = r7
            r7 = r26
            goto L_0x003d
        L_0x03fb:
            r8.flush()     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            boolean r9 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            if (r9 == 0) goto L_0x0415
            boolean r9 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            if (r9 == 0) goto L_0x0415
            org.slf4j.Logger r9 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            java.lang.String r12 = "trace download, data length [{}]"
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r9.info(r12, r13)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
        L_0x0415:
            r12 = 0
            int r9 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r9 <= 0) goto L_0x045e
            long r10 = r10 + r18
            int r9 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r9 < 0) goto L_0x043d
            if (r28 != 0) goto L_0x043c
            if (r29 == 0) goto L_0x043c
            r0 = r27
            r1 = r16
            r2 = r30
            java.lang.String r6 = r0.decompressIfNeed(r1, r2)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            if (r6 == 0) goto L_0x043c
            r0 = r27
            com.baicizhan.client.framework.network.http.HttpContext r9 = r0.context     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            com.baicizhan.client.framework.network.http.HttpResponse r9 = r9.getResponse()     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r9.setDownloadPath(r6)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
        L_0x043c:
            r6 = 1
        L_0x043d:
            com.baicizhan.client.framework.util.CloseHelper.close(r7)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            r0 = r27
            java.net.HttpURLConnection r9 = r0.mConn     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            com.baicizhan.client.framework.util.CloseHelper.close(r9)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            com.baicizhan.client.framework.util.CloseHelper.close(r8)     // Catch:{ IOException -> 0x03f3, all -> 0x047e }
            com.baicizhan.client.framework.util.CloseHelper.close(r7)
            r0 = r27
            java.net.HttpURLConnection r7 = r0.mConn
            com.baicizhan.client.framework.util.CloseHelper.close(r7)
            com.baicizhan.client.framework.util.CloseHelper.close(r8)
            r7 = 0
            r0 = r27
            r0.mConn = r7
            goto L_0x00e4
        L_0x045e:
            r10 = 0
            int r9 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r9 != 0) goto L_0x043d
            r6 = 1
            goto L_0x043d
        L_0x0466:
            r6 = move-exception
            boolean r9 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x007e }
            if (r9 == 0) goto L_0x047a
            boolean r9 = com.baicizhan.client.framework.log.LSwitcher.isOpenOnNet()     // Catch:{ all -> 0x007e }
            if (r9 == 0) goto L_0x047a
            org.slf4j.Logger r9 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x007e }
            java.lang.String r10 = "trace download ex when read error stream"
            r9.error(r10, r6)     // Catch:{ all -> 0x007e }
        L_0x047a:
            throw r6     // Catch:{ all -> 0x007e }
        L_0x047b:
            r6 = move-exception
            goto L_0x0081
        L_0x047e:
            r6 = move-exception
            r9 = r7
            goto L_0x0081
        L_0x0482:
            r14 = r10
            goto L_0x0255
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.network.http.HttpImpl.downloadFile(java.lang.String, boolean, android.os.Handler, int, int):boolean");
    }

    private static HttpURLConnection getConnection(URL url) {
        try {
            if (NetUtil.getNetType() == NetTpyeEnmu.UNAVAIL) {
                return null;
            }
            return (HttpURLConnection) url.openConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isFileSegSuccess() {
        if (this.context.getResponse().responseCode == 200 || this.context.getResponse().responseCode == 206) {
            return true;
        }
        if (LSwitcher.isOpened() && LSwitcher.isOpenOnNet()) {
            C0789L.log.error("trace download, download failed, response code [{}]", (Object) Integer.valueOf(this.context.getResponse().responseCode));
        }
        return false;
    }

    public void postNetData(int i, int i2, HttpStat httpStat) {
        httpStat.executeStatus = -1;
        try {
            URL url = new URL(this.context.getRequest().getUrl());
            if (this.context.getResponse().isCancel) {
                throw new HttpCancelException();
            }
            httpStat.executeStatus = -2;
            HttpURLConnection connect = getConnect(url);
            httpStat.executeStatus = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mConn == null) {
                throw new SocketException("network not available.");
            }
            this.mConn.setRequestMethod("POST");
            this.mConn.setDoOutput(true);
            this.mConn.setDoInput(true);
            this.mConn.setConnectTimeout(i2);
            this.mConn.setReadTimeout(i);
            this.mConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.context.getResponse().isCancel) {
                throw new HttpCancelException();
            }
            this.context.getRequest().wrapHead(connect);
            if (this.context.getResponse().isCancel) {
                throw new HttpCancelException();
            }
            httpStat.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            httpStat.executeStatus = -4;
            connect.connect();
            httpStat.executeStatus = -5;
            httpStat.connectTime = (System.currentTimeMillis() - currentTimeMillis) - httpStat.dnsTime;
            if (this.context.getResponse().isCancel) {
                throw new HttpCancelException();
            }
            httpStat.executeStatus = -6;
            this.context.getRequest().wrapPost2Conn(connect, httpStat);
            httpStat.executeStatus = -7;
            if (this.context.getResponse().isCancel) {
                throw new HttpCancelException();
            }
            httpStat.executeStatus = -8;
            this.context.getResponse().getResponseHead(this.mConn);
            httpStat.responsedCode = this.context.getResponse().responseCode;
            byte[] response = getResponse(this.mConn);
            if (response != null) {
                httpStat.downloadSize = response.length;
                this.context.getResponse().downSize = response.length;
                this.context.getResponse().retBytes = decodeByGZIP(this.context.getResponse().contentEncoding, response);
            }
            httpStat.rspTime = new Date().getTime() - currentTimeMillis;
            httpStat.executeStatus = -9;
        } finally {
            CloseHelper.close(this.mConn);
        }
    }

    private String decompressIfNeed(File file, Handler handler) {
        String lowerCase = this.context.getRequest().getUrl().toLowerCase(Locale.US);
        String lowerCase2 = this.context.getResponse().contentType.toLowerCase(Locale.US);
        Cancelable cancelable = this.context.getResponse().cancelable;
        if (lowerCase == null || lowerCase2 == null) {
            return null;
        }
        if (lowerCase2.startsWith("application/x-gzip")) {
            if (lowerCase.lastIndexOf(".tar.gz") > 0) {
                handler.sendEmptyMessage(1);
                File file2 = new File(file + ".tar.gz");
                file.renameTo(file2);
                return new FileDecompressHelper().decompTarGz(file2, cancelable);
            }
            handler.sendEmptyMessage(1);
            File file3 = new File(file + ".gz");
            file.renameTo(file3);
            return new FileDecompressHelper().decompGz(file3, cancelable);
        } else if (lowerCase2.startsWith("application/zip")) {
            handler.sendEmptyMessage(1);
            File file4 = new File(file + ".zip");
            file.renameTo(file4);
            return new FileDecompressHelper().decompZip(file4, cancelable);
        } else if (lowerCase.lastIndexOf(".tar.gz") > 0) {
            handler.sendEmptyMessage(1);
            File file5 = new File(file + ".tar.gz");
            file.renameTo(file5);
            return new FileDecompressHelper().decompTarGz(file5, cancelable);
        } else if (lowerCase.lastIndexOf(".gz") > 0) {
            handler.sendEmptyMessage(1);
            File file6 = new File(file + ".gz");
            file.renameTo(file6);
            return new FileDecompressHelper().decompGz(file6, cancelable);
        } else if (lowerCase.lastIndexOf(".zip") <= 0) {
            return null;
        } else {
            handler.sendEmptyMessage(1);
            File file7 = new File(file + ".zip");
            file.renameTo(file7);
            return new FileDecompressHelper().decompZip(file7, cancelable);
        }
    }

    public boolean uploadFile(Handler handler, int i, int i2, HttpStat httpStat) {
        postNetData(i, i2, httpStat);
        return true;
    }
}
