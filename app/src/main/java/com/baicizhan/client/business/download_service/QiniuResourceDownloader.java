package com.baicizhan.client.business.download_service;

import android.text.TextUtils;
import com.baicizhan.client.business.util.ConstantsUtil;
import com.baicizhan.client.business.util.LogWrapper;
import com.baicizhan.client.framework.network.http.download.SyncDownloadManager;
import com.baicizhan.client.framework.network.http.download.SyncDownloadManager.Builder;
import java.io.File;
import java.util.Arrays;

public class QiniuResourceDownloader {
    private static final String[] DEFAULT_DNS;
    private static final String TAG = QiniuResourceDownloader.class.getSimpleName();
    private static String[] sDns;
    private float dataRate;
    private int errorCode;
    private int initialDnsIndex;
    private SyncDownloadManager sdm = new Builder().build();

    static {
        String[] strArr = {ConstantsUtil.DEFAULT_DNS, ConstantsUtil.DEFAULT_DNS_CAND};
        DEFAULT_DNS = strArr;
        sDns = strArr;
    }

    public static void setDns(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            LogWrapper.m2793d(TAG, "setDns " + Arrays.toString(strArr));
            sDns = strArr;
        }
    }

    public static String[] getDns() {
        return sDns;
    }

    public void setInitialDnsIndex(int i) {
        this.initialDnsIndex = i % sDns.length;
    }

    private static String getResourceUrl(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str2.startsWith("http")) {
            return str2;
        }
        String replace = str2.replace(" ", "%20");
        if (replace.charAt(0) == '/') {
            return str + replace;
        }
        return String.format("%s/%s", new Object[]{str, replace});
    }

    public static String getResourceUrl(String str) {
        return getResourceUrl(sDns[0], str);
    }

    public QiniuResourceDownloader() {
        setConnectTimeout(3000);
        setReadTimeout(5000);
        this.sdm.setMaxRetry(2);
    }

    public void setConnectTimeout(int i) {
        this.sdm.setConnTimeout(i);
    }

    public void setReadTimeout(int i) {
        this.sdm.setReadTimeout(i);
    }

    public void setPerDNSMaxRetryCount(int i) {
        this.sdm.setMaxRetry(i);
    }

    public float getDataRate() {
        return this.dataRate;
    }

    public File download(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
//            throw new Exception("url null");
        }
        File file = new File(str2);
        for (int i = 0; i < sDns.length; i++) {
            String resourceUrl = getResourceUrl(sDns[(this.initialDnsIndex + i) % sDns.length], str);
            file.delete();
            this.sdm.setUrl(resourceUrl);
            this.sdm.setDestPath(str2);
            LogWrapper.m2796v(TAG, "try download " + i + ": " + resourceUrl + " -> " + str2);
            long currentTimeMillis = System.currentTimeMillis();
            boolean start = this.sdm.start();
            long currentTimeMillis2 = System.currentTimeMillis();
            LogWrapper.m2796v(TAG, "download file result: " + start + "; code:" + this.sdm.getResCode());
            this.errorCode = this.sdm.getResCode();
            if (start) {
                long j = currentTimeMillis2 - currentTimeMillis;
                if (j > 0) {
                    this.dataRate = (((float) file.length()) * 1000.0f) / ((float) j);
                } else {
                    this.dataRate = 9.223372E18f;
                }
                if (file.exists() && file.length() > 0) {
                    return file;
                }
            } else if (this.errorCode >= 400 && this.errorCode < 500) {
                return null;
            }
        }
//        throw new Exception("download failed, errorCode: " + this.errorCode + ", urlPath: " + str);

        return null;
    }
}
