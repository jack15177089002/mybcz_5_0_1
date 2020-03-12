package com.baicizhan.client.framework.network.http;

import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import com.baicizhan.client.framework.util.CloseHelper;
import com.baicizhan.client.framework.util.IBackoffPolicy;
import com.baicizhan.client.framework.util.StringHelper;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.message.BasicNameValuePair;
import p012ch.qos.logback.classic.spi.CallerData;

public class HttpRequest {
    private static final int BUFFERSIZE = 1024;
    private static final String end = "\r\n";
    private static final String twoHypens = "--";
    private boolean autoDecomp = true;
    private IBackoffPolicy bfpolicy;
    protected HashMap<String, byte[]> byteData = new HashMap<>();
    private int concurrence;
    private int connTimeout;
    private String destPath;
    protected Map<String, String> headData = new HashMap();
    private int maxRetry;
    private HTTP_METHOD method;
    protected LinkedList<BasicNameValuePair> postData = new LinkedList<>();
    private int readTimeout;
    private String url = "";

    public enum HTTP_METHOD {
        GET,
        POST
    }

    public HTTP_METHOD getMethod() {
        return this.method;
    }

    public void setMethod(HTTP_METHOD http_method) {
        this.method = http_method;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        if (str == null) {
            this.url = "";
        } else {
            this.url = str;
        }
    }

    public String getDestPath() {
        return this.destPath;
    }

    public void setDestPath(String str) {
        this.destPath = str;
    }

    public boolean isAutoDecompress() {
        return this.autoDecomp;
    }

    public void setAutoDecompress(boolean z) {
        this.autoDecomp = z;
    }

    public int getMaxRetry() {
        return this.maxRetry;
    }

    public void setMaxRetry(int i) {
        this.maxRetry = i;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public int getConnTimeout() {
        return this.connTimeout;
    }

    public void setConnTimeout(int i) {
        this.connTimeout = i;
    }

    public int getConcurrence() {
        return this.concurrence;
    }

    public void setConcurrence(int i) {
        this.concurrence = i;
    }

    public boolean hasRaw() {
        if (this.byteData == null || this.byteData.size() <= 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public String generateGetString(HttpStat httpStat) {
        StringBuilder sb = new StringBuilder(30);
        sb.append(this.url);
        if (this.url.indexOf(CallerData.f1661NA) < 0) {
            sb.append(CallerData.f1661NA);
        } else if (!this.url.endsWith(CallerData.f1661NA) && !this.url.endsWith("&")) {
            sb.append("&");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.postData.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append("&");
            }
            sb.append(((BasicNameValuePair) this.postData.get(i2)).getName());
            sb.append("=");
            sb.append(StringHelper.getUrlEncode(((BasicNameValuePair) this.postData.get(i2)).getValue()));
            i = i2 + 1;
        }
        if (httpStat != null) {
            httpStat.upDataSize = sb.length();
        }
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public void wrapHead(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.headData != null) {
            for (Entry entry : this.headData.entrySet()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void wrapPost2Conn(HttpURLConnection httpURLConnection, String str, HttpStat httpStat) {
        preDeplyMutliPost2Conn();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = null;
            try {
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
//                if (this.postData != null) {
//                    Iterator it = this.postData.iterator();
//                    while (it.hasNext()) {
//                        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) it.next();
//                        if (basicNameValuePair != null) {
//                            String name = basicNameValuePair.getName();
//                            String value = basicNameValuePair.getValue();
//                            dataOutputStream.writeBytes(new StringBuilder(twoHypens).append(str).append(end).toString());
//                            byte[] bytes = value.getBytes("UTF-8");
//                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
//                            dataOutputStream.writeBytes(end);
//                            dataOutputStream.write(bytes);
//                            dataOutputStream.writeBytes(end);
//                        }
//                    }
//                }
//                if (this.byteData != null) {
//                    for (Entry entry : this.byteData.entrySet()) {
//                        String str2 = (String) entry.getKey();
//                        byte[] bArr = (byte[]) entry.getValue();
//                        if (bArr != null) {
//                            dataOutputStream.writeBytes(new StringBuilder(twoHypens).append(str).append(end).toString());
//                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"file\"\r\n");
//                            dataOutputStream.writeBytes(end);
//                            dataOutputStream.write(bArr);
//                            dataOutputStream.writeBytes(end);
//                        }
//                    }
//                }
//                dataOutputStream.writeBytes(new StringBuilder(twoHypens).append(str).append("--\r\n").toString());
//                dataOutputStream.flush();
//                i = dataOutputStream.size();
            } finally {
                CloseHelper.close((OutputStream) dataOutputStream);
            }
        }
        if (httpStat != null) {
            httpStat.upDataSize = i;
        }
    }

    /* JADX INFO: finally extract failed */
    public void wrapPost2Conn(HttpURLConnection httpURLConnection, HttpStat httpStat) {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = postData2String().toString();
            DataOutputStream dataOutputStream = null;
            try {
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (LSwitcher.isOpened()) {
                C0789L.log.info("POST:" + this.url + CallerData.f1661NA + sb);
            }
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                CloseHelper.close((OutputStream) dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                CloseHelper.close((OutputStream) dataOutputStream);
//                throw th;
            }
        }
        if (httpStat != null) {
            httpStat.upDataSize = i;
        }
    }

    private StringBuilder postData2String() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.postData != null) {
            Iterator it = this.postData.iterator();
            int i = 0;
            while (it.hasNext()) {
                BasicNameValuePair basicNameValuePair = (BasicNameValuePair) it.next();
                if (basicNameValuePair != null) {
                    String name = basicNameValuePair.getName();
                    String value = basicNameValuePair.getValue();
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(name + "=");
                    sb.append(StringHelper.getUrlEncode(value));
                    i++;
                }
            }
        }
        return sb;
    }

    /* access modifiers changed from: protected */
    public void preDeplyMutliPost2Conn() {
    }

    public void setHeadData(HashMap<String, String> hashMap) {
        this.headData = hashMap;
    }

    public String getHeadData(String str) {
        if (this.headData != null) {
            return (String) this.headData.get(str);
        }
        return null;
    }

    public void setPostData(List<Entry<String, Object>> list) {
        if (list != null) {
            for (Entry entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.postData.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
//                        this.byteData.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void addPostData(LinkedList<BasicNameValuePair> linkedList) {
        this.postData.addAll(linkedList);
    }

    public void addPostData(String str, byte[] bArr) {
        this.byteData.put(str, bArr);
    }

    public void addPostData(String str, String str2) {
        this.postData.add(new BasicNameValuePair(str, str2));
    }

    public void addHeadData(String str, String str2) {
        if (this.headData != null) {
            this.headData.put(str, str2);
        }
    }

    public IBackoffPolicy getBackoffPolicy() {
        return this.bfpolicy;
    }

    public void setBackoffPolicy(IBackoffPolicy iBackoffPolicy) {
        this.bfpolicy = iBackoffPolicy;
    }
}
