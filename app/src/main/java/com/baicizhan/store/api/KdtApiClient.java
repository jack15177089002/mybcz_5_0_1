package com.baicizhan.store.api;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import p012ch.qos.logback.classic.spi.CallerData;

public class KdtApiClient {
    public static final String APP_ID = "e901505ad869773b55";
    public static final String APP_SECRET = "510202737a68372d2bcaedb9740b0641";
    private static final String DefaultUserAgent = "KdtApiSdk Client v0.1";
    private static final String Version = "1.0";
    private static final String apiEntry = "http://open.koudaitong.com/api/entry?";
    private static final String format = "json";
    private static final String signMethod = "md5";
    private String appId;
    private String appSecret;

//    class InstanceHolder {
    public static final KdtApiClient instance = new KdtApiClient(KdtApiClient.APP_ID, KdtApiClient.APP_SECRET);

//        private InstanceHolder() {
//        }
//    }

    public KdtApiClient(String str, String str2) {
        if ("".equals(str) || "".equals(str2)) {
            throw new IllegalArgumentException("appId 和 appSecret 不能为空");
        }
        this.appId = str;
        this.appSecret = str2;
    }

//    public HttpResponse get(String str, HashMap<String, String> hashMap) {
//        String sb = new StringBuilder(apiEntry).append(getParamStr(str, hashMap)).toString();
//        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(sb);
//        httpGet.addHeader("User-Agent", DefaultUserAgent);
//        CloseableHttpResponse execute = null;
//        try {
//            execute = defaultHttpClient.execute(httpGet);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return execute;
//    }

    public String getParamStr(String str, HashMap<String, String> hashMap) {
        String str2 = "";
        try {
            return URLEncoder.encode(buildParamStr(buildCompleteParams(str, hashMap)), "UTF-8").replace("%3A", ":").replace("%2F", "/").replace("%26", "&").replace("%3D", "=").replace("%3F", CallerData.f1661NA);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    private String buildParamStr(HashMap<String, String> hashMap) {
        String str;
        Object[] array = hashMap.keySet().toArray();
        String str2 = "";
        int i = 0;
        while (i < array.length) {
            String str3 = (String) array[i];
            if (i == 0) {
                str = str2 + str3 + "=" + ((String) hashMap.get(str3));
            } else {
                str = str2 + "&" + str3 + "=" + ((String) hashMap.get(str3));
            }
            i++;
            str2 = str;
        }
        return str2;
    }

    private HashMap<String, String> buildCompleteParams(String str, HashMap<String, String> hashMap) {
        HashMap<String, String> commonParams = getCommonParams(str);
        for (String str2 : hashMap.keySet()) {
            if (commonParams.containsKey(str2)) {
                try {
                    throw new Exception("参数名冲突");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            commonParams.put(str2, hashMap.get(str2));
        }
        commonParams.put(KdtApiProtocol.SIGN_KEY, KdtApiProtocol.sign(this.appSecret, commonParams));
        return commonParams;
    }

    private HashMap<String, String> getCommonParams(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(KdtApiProtocol.APP_ID_KEY, this.appId);
        hashMap.put(KdtApiProtocol.METHOD_KEY, str);
        hashMap.put(KdtApiProtocol.TIMESTAMP_KEY, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put(KdtApiProtocol.FORMAT_KEY, format);
        hashMap.put(KdtApiProtocol.SIGN_METHOD_KEY, signMethod);
        hashMap.put(KdtApiProtocol.VERSION_KEY, "1.0");
        return hashMap;
    }

    public static KdtApiClient getInstance() {
        return instance;
    }
}
