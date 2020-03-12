//package com.android.volley.toolbox;
//
//import com.android.volley.Request;
//import com.android.volley.toolbox.HttpClientStack.HttpPatch;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.ProtocolException;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLSocketFactory;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.ProtocolVersion;
//import org.apache.http.entity.BasicHttpEntity;
//import org.apache.http.message.BasicHeader;
//import org.apache.http.message.BasicHttpResponse;
//import org.apache.http.message.BasicStatusLine;
//
//public class HurlStack implements HttpStack {
//    private static final String HEADER_CONTENT_TYPE = "Content-Type";
//    private final SSLSocketFactory mSslSocketFactory;
//    private final UrlRewriter mUrlRewriter;
//
//    public interface UrlRewriter {
//        String rewriteUrl(String str);
//    }
//
//    public HurlStack() {
//        this(null);
//    }
//
//    public HurlStack(UrlRewriter urlRewriter) {
//        this(urlRewriter, null);
//    }
//
//    public HurlStack(UrlRewriter urlRewriter, SSLSocketFactory sSLSocketFactory) {
//        this.mUrlRewriter = urlRewriter;
//        this.mSslSocketFactory = sSLSocketFactory;
//    }
//
//    public HttpResponse performRequest(Request<?> request, Map<String, String> map) {
//        String str;
//        String url = request.getUrl();
//        HashMap<String,String> hashMap = new HashMap();
//        hashMap.putAll(request.getHeaders());
//        hashMap.putAll(map);
//        if (this.mUrlRewriter != null) {
//            str = this.mUrlRewriter.rewriteUrl(url);
//            if (str == null) {
//                try {
//                    throw new IOException("URL blocked by rewriter: " + url);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } else {
//            str = url;
//        }
//        HttpURLConnection openConnection = null;
//        try {
//            openConnection = openConnection(new URL(str), request);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        for (String str2 : hashMap.keySet()) {
//            openConnection.addRequestProperty(str2, (String) hashMap.get(str2));
//        }
//        setConnectionParametersForRequest(openConnection, request);
//        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
//        try {
//            if (openConnection.getResponseCode() == -1) {
//                try {
//                    throw new IOException("Could not retrieve response code from HttpUrlConnection.");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        BasicHttpResponse basicHttpResponse = null;
//        try {
//            basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, openConnection.getResponseCode(), openConnection.getResponseMessage()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        basicHttpResponse.setEntity(entityFromConnection(openConnection));
//        for (Entry entry : openConnection.getHeaderFields().entrySet()) {
//            if (entry.getKey() != null) {
//                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
//            }
//        }
//        return basicHttpResponse;
//    }
//
//    private static HttpEntity entityFromConnection(HttpURLConnection httpURLConnection) {
//        InputStream errorStream;
//        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
//        try {
//            errorStream = httpURLConnection.getInputStream();
//        } catch (IOException e) {
//            errorStream = httpURLConnection.getErrorStream();
//        }
//        basicHttpEntity.setContent(errorStream);
//        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
//        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
//        basicHttpEntity.setContentType(httpURLConnection.getContentType());
//        return basicHttpEntity;
//    }
//
//    /* access modifiers changed from: protected */
//    public HttpURLConnection createConnection(URL url) {
//        try {
//            return (HttpURLConnection) url.openConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private HttpURLConnection openConnection(URL url, Request<?> request) {
//        HttpURLConnection createConnection = createConnection(url);
//        int timeoutMs = request.getTimeoutMs();
//        createConnection.setConnectTimeout(timeoutMs);
//        createConnection.setReadTimeout(timeoutMs);
//        createConnection.setUseCaches(false);
//        createConnection.setDoInput(true);
//        if ("https".equals(url.getProtocol()) && this.mSslSocketFactory != null) {
//            ((HttpsURLConnection) createConnection).setSSLSocketFactory(this.mSslSocketFactory);
//        }
//        return createConnection;
//    }
//
//    static void setConnectionParametersForRequest(HttpURLConnection httpURLConnection, Request<?> request) {
//        httpURLConnection.setDoOutput(true);
//        try {
//        switch (request.getMethod()) {
//            case -1:
//                byte[] postBody = request.getPostBody();
//                if (postBody != null) {
//                        httpURLConnection.setRequestMethod("POST");
//                        httpURLConnection.addRequestProperty(HEADER_CONTENT_TYPE, request.getPostBodyContentType());
//                        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
//                        dataOutputStream.write(postBody);
//                        dataOutputStream.close();
//                        return;
//                }
//                return;
//            case 0:
//                httpURLConnection.setRequestMethod("GET");
//                return;
//            case 1:
//                httpURLConnection.setRequestMethod("POST");
//                addBodyIfExists(httpURLConnection, request);
//                return;
//            case 2:
//                httpURLConnection.setRequestMethod("PUT");
//                addBodyIfExists(httpURLConnection, request);
//                return;
//            case 3:
//                httpURLConnection.setRequestMethod("DELETE");
//                return;
//            case 4:
//                httpURLConnection.setRequestMethod("HEAD");
//                return;
//            case 5:
//                httpURLConnection.setRequestMethod("OPTIONS");
//                return;
//            case 6:
//                httpURLConnection.setRequestMethod("TRACE");
//                return;
//            case 7:
//                httpURLConnection.setRequestMethod(HttpPatch.METHOD_NAME);
//                addBodyIfExists(httpURLConnection, request);
//                return;
//            default:
//                throw new IllegalStateException("Unknown method type.");
//        }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void addBodyIfExists(HttpURLConnection httpURLConnection, Request<?> request) {
//        byte[] body = request.getBody();
//        if (body != null) {
//            httpURLConnection.setDoOutput(true);
//            httpURLConnection.addRequestProperty(HEADER_CONTENT_TYPE, request.getBodyContentType());
//            try {
//                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
//                dataOutputStream.write(body);
//                dataOutputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
