package com.baicizhan.client.framework.network.http.download;

import com.baicizhan.client.framework.util.IBackoffPolicy;
import java.util.List;
import java.util.Map;

public interface IDownloadManager {

    public interface DownloadCallback {
        void onComplete(boolean z, String str, int i);

        void onGroupComplete(boolean z, List<String> list, int i);

        void onPause();

        void onProgress(int i);

        void onResume();

        void onStart();

        void onStartDecompress();

        void onStop();
    }

    public enum State {
        None,
        Downloading,
        Paused,
        Stopped,
        Successed,
        Failed
    }

    IDownloadManager addUrl(String str);

    IDownloadManager addUrl(String str, String str2);

    State currentState();

    int getConcurrence();

    int getConnTimeout();

    String getDestPath();

    int getMaxRetry();

    int getReadTimeout();

    String getUrl();

    Map<String, String> getUrls();

    boolean isAutoDecompress();

    boolean pause();

    boolean resume();

    IDownloadManager setAutoDecompress(boolean z);

    IDownloadManager setBackoffPolicy(IBackoffPolicy iBackoffPolicy);

    IDownloadManager setCallback(DownloadCallback downloadCallback);

    IDownloadManager setConcurrence(int i);

    IDownloadManager setConnTimeout(int i);

    IDownloadManager setDestPath(String str);

    IDownloadManager setMaxRetry(int i);

    IDownloadManager setReadTimeout(int i);

    IDownloadManager setUrl(String str);

    boolean start();

    boolean start(String str, int i, DownloadCallback downloadCallback);

    boolean start(String str, DownloadCallback downloadCallback);

    boolean start(String str, String str2, int i, DownloadCallback downloadCallback);

    boolean start(String str, String str2, DownloadCallback downloadCallback);

    boolean start(String str, String str2, boolean z, int i, int i2, int i3, int i4, IBackoffPolicy iBackoffPolicy, DownloadCallback downloadCallback);

    boolean start(String str, String str2, boolean z, int i, int i2, int i3, IBackoffPolicy iBackoffPolicy, DownloadCallback downloadCallback);

    boolean start(String str, String str2, boolean z, int i, DownloadCallback downloadCallback);

    boolean start(String str, String str2, boolean z, DownloadCallback downloadCallback);

    boolean start(String str, boolean z, int i, DownloadCallback downloadCallback);

    boolean start(String str, boolean z, DownloadCallback downloadCallback);

    boolean stop();
}
