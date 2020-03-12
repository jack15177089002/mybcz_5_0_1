//package com.baicizhan.client.business.thrift;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Map;
//import org.apache.http.HttpEntity;
//import org.apache.http.client.HttpClient;
//import org.p100a.p101a.p107f.C2119f;
//import org.p100a.p101a.p107f.C2120g;
//import org.p100a.p101a.p107f.TTransportFactory;
//
//public class TEnhancedHttpClient extends C2119f {
//    private static final int COMPRESS_THRESHOLD = 256;
//    public static final String COOKIE_HEADER_KEY = "Cookie";
//    private static final boolean ENABLE_COMPRESS_POST = true;
//    private int connectTimeout_ = 5000;
//    private CookieInflator cookieInflator_ = null;
//    private Map<String, String> customHeaders_ = null;
//    private InputStream inputStream_ = null;
//    private int maxRetryCount_ = 1;
//    private int readTimeout_ = 10000;
//    private final ByteArrayOutputStream requestBuffer_ = new ByteArrayOutputStream();
//    private RetryPolicy retryPolicy_ = null;
//    private UrlPolicy urlPolicy_ = null;
//    private String url_ = null;
//
//    public class Factory extends TTransportFactory {
//        private final HttpClient client = null;
//        private final String url;
//
//        public Factory(String str) {
//            this.url = str;
//        }
//
//        public C2119f getTransport(C2119f fVar) {
////            try {
////                return new TEnhancedHttpClient(this.url);
////            } catch (C2120g e) {
//                return null;
////            }
//        }
//    }
//
//    public TEnhancedHttpClient(String str) {
//        this.url_ = str;
//    }
//
//    public TEnhancedHttpClient(UrlPolicy urlPolicy) {
//        this.urlPolicy_ = urlPolicy;
//    }
//
//    public void setConnectTimeout(int i) {
//        this.connectTimeout_ = i;
//    }
//
//    public void setReadTimeout(int i) {
//        this.readTimeout_ = i;
//    }
//
//    public void setMaxRetryCount(int i) {
//        this.maxRetryCount_ = i;
//    }
//
//    public void setRetryPolicy(RetryPolicy retryPolicy) {
//        this.retryPolicy_ = retryPolicy;
//    }
//
//    public void setCookieInflator(CookieInflator cookieInflator) {
//        this.cookieInflator_ = cookieInflator;
//    }
//
//    public void setCustomHeaders(Map<String, String> map) {
//        this.customHeaders_ = map;
//    }
//
//    public void setCustomHeader(String str, String str2) {
//        if (this.customHeaders_ == null) {
//            this.customHeaders_ = new ArrayMap();
//        }
//        this.customHeaders_.put(str, str2);
//    }
//
//    public void open() {
//    }
//
//    public void close() {
//        if (this.inputStream_ != null) {
//            try {
//                this.inputStream_.close();
//            } catch (IOException e) {
//            }
//            this.inputStream_ = null;
//        }
//    }
//
//    public boolean isOpen() {
//        return true;
//    }
//
//    public int read(byte[] bArr, int i, int i2) {
////        if (this.inputStream_ == null) {
////            throw new C2120g("Response buffer is empty, no request.");
////        }
////        try {
////            int read = this.inputStream_.read(bArr, i, i2);
////            if (read != -1) {
////                return read;
////            }
////            throw new C2120g("No more data available.");
////        } catch (IOException e) {
////            throw new C2120g((Throwable) e);
////        }
//
//        //test
//        return -1;
//    }
//
//    public void write(byte[] bArr, int i, int i2) {
//        this.requestBuffer_.write(bArr, i, i2);
//    }
//
//    private static void consume(HttpEntity httpEntity) {
////        if (httpEntity != null && httpEntity.isStreaming()) {
////            InputStream content = httpEntity.getContent();
////            if (content != null) {
////                content.close();
////            }
////        }
//    }
//
//    private URL getSafeURL(int i) {
//        try {
//            if (this.urlPolicy_ != null) {
//                return new URL(this.urlPolicy_.getUrl(i, this.maxRetryCount_));
//            }
//            return new URL(this.url_);
//        } catch (MalformedURLException e) {
////            throw new C2120g((Throwable) e);
//        }
//
//        return null;
//    }
//
//    private int getRetryConnectTimeout(int i) {
//        if (this.retryPolicy_ != null) {
//            return this.retryPolicy_.getConnectTimeout(i, this.maxRetryCount_);
//        }
//        return this.connectTimeout_;
//    }
//
//    private int getRetryReadTimeout(int i) {
//        if (this.retryPolicy_ != null) {
//            return this.retryPolicy_.getReadTimeout(i, this.maxRetryCount_);
//        }
//        return this.readTimeout_;
//    }
//
//    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public void flush() {
//        /*
//            r10 = this;
//            r9 = 3
//            r2 = 0
//            com.baicizhan.client.business.thrift.CookieInflator r1 = r10.cookieInflator_
//            if (r1 != 0) goto L_0x000e
//            org.a.a.f.g r1 = new org.a.a.f.g
//            java.lang.String r2 = "Coookie missed"
//            r1.<init>(r2)
//            throw r1
//        L_0x000e:
//            com.baicizhan.client.business.thrift.CookieInflator r1 = r10.cookieInflator_
//            java.lang.String r6 = r1.getCookie()
//            java.io.ByteArrayOutputStream r1 = r10.requestBuffer_
//            byte[] r7 = r1.toByteArray()
//            java.io.ByteArrayOutputStream r1 = r10.requestBuffer_
//            r1.reset()
//            int r1 = r7.length
//            r3 = 256(0x100, float:3.59E-43)
//            if (r1 <= r3) goto L_0x0147
//            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00c2 }
//            r3.<init>()     // Catch:{ IOException -> 0x00c2 }
//            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x00c2 }
//            r4.<init>(r3)     // Catch:{ IOException -> 0x00c2 }
//            r4.write(r7)     // Catch:{ IOException -> 0x00c2 }
//            r4.flush()     // Catch:{ IOException -> 0x00c2 }
//            r4.close()     // Catch:{ IOException -> 0x00c2 }
//            byte[] r1 = r3.toByteArray()     // Catch:{ IOException -> 0x00c2 }
//            r4.close()     // Catch:{ IOException -> 0x00c2 }
//            r3.close()     // Catch:{ IOException -> 0x00c2 }
//            r4 = r1
//        L_0x0042:
//            r1 = 0
//            r5 = r1
//            r1 = r2
//        L_0x0045:
//            int r2 = r10.maxRetryCount_
//            if (r5 >= r2) goto L_0x0126
//            java.net.URL r1 = r10.getSafeURL(r5)     // Catch:{ Throwable -> 0x00bc }
//            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Throwable -> 0x00bc }
//            r0 = r1
//            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Throwable -> 0x00bc }
//            r3 = r0
//            int r1 = r10.getRetryConnectTimeout(r5)     // Catch:{ Throwable -> 0x00bc }
//            r3.setConnectTimeout(r1)     // Catch:{ Throwable -> 0x00bc }
//            int r1 = r10.getRetryReadTimeout(r5)     // Catch:{ Throwable -> 0x00bc }
//            r3.setReadTimeout(r1)     // Catch:{ Throwable -> 0x00bc }
//            java.lang.String r1 = "POST"
//            r3.setRequestMethod(r1)     // Catch:{ Throwable -> 0x00bc }
//            java.lang.String r1 = "Content-Type"
//            java.lang.String r2 = "application/x-thrift"
//            r3.setRequestProperty(r1, r2)     // Catch:{ Throwable -> 0x00bc }
//            java.lang.String r1 = "Accept"
//            java.lang.String r2 = "application/x-thrift"
//            r3.setRequestProperty(r1, r2)     // Catch:{ Throwable -> 0x00bc }
//            java.lang.String r1 = "User-Agent"
//            java.lang.String r2 = "Java/THttpClient"
//            r3.setRequestProperty(r1, r2)     // Catch:{ Throwable -> 0x00bc }
//            java.lang.String r1 = "Accept-Encoding"
//            java.lang.String r2 = "gzip, deflate, sdch"
//            r3.setRequestProperty(r1, r2)     // Catch:{ Throwable -> 0x00bc }
//            if (r4 != 0) goto L_0x00c6
//            java.lang.String r1 = "Compress-Type"
//            java.lang.String r2 = "plain"
//            r3.setRequestProperty(r1, r2)     // Catch:{ Throwable -> 0x00bc }
//        L_0x008d:
//            java.lang.String r1 = "Cookie"
//            r3.setRequestProperty(r1, r6)     // Catch:{ Throwable -> 0x00bc }
//            java.util.Map<java.lang.String, java.lang.String> r1 = r10.customHeaders_     // Catch:{ Throwable -> 0x00bc }
//            if (r1 == 0) goto L_0x00ce
//            java.util.Map<java.lang.String, java.lang.String> r1 = r10.customHeaders_     // Catch:{ Throwable -> 0x00bc }
//            java.util.Set r1 = r1.entrySet()     // Catch:{ Throwable -> 0x00bc }
//            java.util.Iterator r8 = r1.iterator()     // Catch:{ Throwable -> 0x00bc }
//        L_0x00a0:
//            boolean r1 = r8.hasNext()     // Catch:{ Throwable -> 0x00bc }
//            if (r1 == 0) goto L_0x00ce
//            java.lang.Object r1 = r8.next()     // Catch:{ Throwable -> 0x00bc }
//            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ Throwable -> 0x00bc }
//            java.lang.Object r2 = r1.getKey()     // Catch:{ Throwable -> 0x00bc }
//            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x00bc }
//            java.lang.Object r1 = r1.getValue()     // Catch:{ Throwable -> 0x00bc }
//            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Throwable -> 0x00bc }
//            r3.setRequestProperty(r2, r1)     // Catch:{ Throwable -> 0x00bc }
//            goto L_0x00a0
//        L_0x00bc:
//            r2 = move-exception
//            int r1 = r5 + 1
//            r5 = r1
//            r1 = r2
//            goto L_0x0045
//        L_0x00c2:
//            r1 = move-exception
//            r4 = r2
//            goto L_0x0042
//        L_0x00c6:
//            java.lang.String r1 = "Compress-Type"
//            java.lang.String r2 = "gzip"
//            r3.setRequestProperty(r1, r2)     // Catch:{ Throwable -> 0x00bc }
//            goto L_0x008d
//        L_0x00ce:
//            r1 = 1
//            r3.setDoOutput(r1)     // Catch:{ Throwable -> 0x00bc }
//            r3.connect()     // Catch:{ Throwable -> 0x00bc }
//            if (r4 != 0) goto L_0x00fb
//            java.io.OutputStream r1 = r3.getOutputStream()     // Catch:{ Throwable -> 0x00bc }
//            r1.write(r7)     // Catch:{ Throwable -> 0x00bc }
//        L_0x00de:
//            int r1 = r3.getResponseCode()     // Catch:{ Throwable -> 0x00bc }
//            r2 = 200(0xc8, float:2.8E-43)
//            if (r1 == r2) goto L_0x0103
//            org.a.a.f.g r2 = new org.a.a.f.g     // Catch:{ Throwable -> 0x00bc }
//            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00bc }
//            java.lang.String r8 = "HTTP Response code: "
//            r3.<init>(r8)     // Catch:{ Throwable -> 0x00bc }
//            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ Throwable -> 0x00bc }
//            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x00bc }
//            r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x00bc }
//            throw r2     // Catch:{ Throwable -> 0x00bc }
//        L_0x00fb:
//            java.io.OutputStream r1 = r3.getOutputStream()     // Catch:{ Throwable -> 0x00bc }
//            r1.write(r4)     // Catch:{ Throwable -> 0x00bc }
//            goto L_0x00de
//        L_0x0103:
//            java.lang.String r1 = "Content-Encoding"
//            java.lang.String r1 = r3.getHeaderField(r1)     // Catch:{ Throwable -> 0x00bc }
//            if (r1 == 0) goto L_0x011f
//            java.lang.String r2 = "gzip"
//            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Throwable -> 0x00bc }
//            if (r1 == 0) goto L_0x011f
//            java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ Throwable -> 0x00bc }
//            java.io.InputStream r2 = r3.getInputStream()     // Catch:{ Throwable -> 0x00bc }
//            r1.<init>(r2)     // Catch:{ Throwable -> 0x00bc }
//            r10.inputStream_ = r1     // Catch:{ Throwable -> 0x00bc }
//        L_0x011e:
//            return
//        L_0x011f:
//            java.io.InputStream r1 = r3.getInputStream()     // Catch:{ Throwable -> 0x00bc }
//            r10.inputStream_ = r1     // Catch:{ Throwable -> 0x00bc }
//            goto L_0x011e
//        L_0x0126:
//            if (r1 == 0) goto L_0x013f
//            boolean r2 = r1 instanceof org.p100a.p101a.p107f.C2120g
//            if (r2 == 0) goto L_0x012f
//            org.a.a.f.g r1 = (org.p100a.p101a.p107f.C2120g) r1
//            throw r1
//        L_0x012f:
//            boolean r2 = r1 instanceof java.net.SocketTimeoutException
//            if (r2 == 0) goto L_0x0139
//            org.a.a.f.g r2 = new org.a.a.f.g
//            r2.<init>(r9, r1)
//            throw r2
//        L_0x0139:
//            org.a.a.f.g r2 = new org.a.a.f.g
//            r2.<init>(r1)
//            throw r2
//        L_0x013f:
//            org.a.a.f.g r1 = new org.a.a.f.g
//            java.lang.String r2 = "retry exhausted"
//            r1.<init>(r9, r2)
//            throw r1
//        L_0x0147:
//            r4 = r2
//            goto L_0x0042
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.thrift.TEnhancedHttpClient.flush():void");
//    }
//}
