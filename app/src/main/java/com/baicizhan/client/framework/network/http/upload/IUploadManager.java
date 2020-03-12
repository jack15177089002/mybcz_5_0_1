package com.baicizhan.client.framework.network.http.upload;

public interface IUploadManager {

    public interface UploadCallback {
        void onComplete(boolean z, int i);

        void onProgress(int i);

        void onStart();

        void onStop();
    }

    IUploadManager addPart(String str, String str2);

    IUploadManager addUrl(String str);

    IUploadManager addUrl(String str, String str2);

    IUploadManager setCallback(UploadCallback uploadCallback);

    IUploadManager setConcurrence(int i);

    IUploadManager setConnTimeout(int i);

    IUploadManager setMaxRetry(int i);

    IUploadManager setReadTimeout(int i);

    IUploadManager setSrcPath(String str);

    IUploadManager setUrl(String str);

    boolean start();

    boolean stop();
}
