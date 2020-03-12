package com.baicizhan.client.framework.network.http.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baicizhan.client.framework.network.http.HttpContext;
import com.baicizhan.client.framework.network.http.HttpManager;
import com.baicizhan.client.framework.network.http.HttpProgressor;
import com.baicizhan.client.framework.network.http.HttpRequest;
import com.baicizhan.client.framework.network.http.HttpRequest.HTTP_METHOD;
import com.baicizhan.client.framework.network.http.backoff.DefaultBFPolicy;
import com.baicizhan.client.framework.util.IBackoffPolicy;
import java.lang.ref.WeakReference;

public final class SyncDownloadManager {
    /* access modifiers changed from: private */
    public static final IBackoffPolicy DEF_BF_POLICY = new DefaultBFPolicy();
    private static final int DEF_CONCURRENCE = 1;
    private static final int DEF_CONN_TIMEOUT = 0;
    private static final int DEF_MAX_RETRY = 0;
    private static final int DEF_READ_TIMEOUT = 0;
    private static final int LOCAL_MSG_COMPLETE = 1004;
    private static final int LOCAL_MSG_START = 1001;
    /* access modifiers changed from: private */
    public DownloadCallback mCallback;
    private volatile boolean mDownloading;
    private DownloadHandler mHandler;
    /* access modifiers changed from: private */
    public HttpManager mManager;
    /* access modifiers changed from: private */
    public RequestParam mRequestParam;
    /* access modifiers changed from: private */
    public int mResCode;
    /* access modifiers changed from: private */
    public String mResTargetPath;

    public static class Builder {
        private DownloadCallback mCallback;
        private RequestParam mRequestParam = new RequestParam();

        public Builder setUrl(String str) {
            this.mRequestParam.url = str;
            return this;
        }

        public Builder setDestPath(String str) {
            this.mRequestParam.destPath = str;
            return this;
        }

        public Builder setAutoDecompress(boolean z) {
            this.mRequestParam.autoDecomp = z;
            return this;
        }

        public Builder setConcurrence(int i) {
            this.mRequestParam.concurrence = i;
            return this;
        }

        public Builder setMaxRetry(int i) {
            this.mRequestParam.maxRetry = i;
            return this;
        }

        public Builder setReadTimeout(int i) {
            this.mRequestParam.readTimeout = i;
            return this;
        }

        public Builder setConnTimeout(int i) {
            this.mRequestParam.connTimeout = i;
            return this;
        }

        public Builder setBackoffPolicy(IBackoffPolicy iBackoffPolicy) {
            this.mRequestParam.bfpolicy = iBackoffPolicy;
            return this;
        }

        public Builder setCallback(DownloadCallback downloadCallback) {
            this.mCallback = downloadCallback;
            return this;
        }

        public  SyncDownloadManager build() {
            SyncDownloadManager syncDownloadManager = new SyncDownloadManager();
            syncDownloadManager.mRequestParam = this.mRequestParam;
            syncDownloadManager.mCallback = this.mCallback;
            syncDownloadManager.refresh();
            return syncDownloadManager;
        }
    }

    public interface DownloadCallback {
        void onComplete(boolean z, String str, int i);

        void onProgress(int i);

        void onStart();

        void onStartDecompress();

        void onStop();
    }

    class DownloadHandler extends Handler {
        private final WeakReference<SyncDownloadManager> mDNManager;

        DownloadHandler(SyncDownloadManager syncDownloadManager) {
            super(Looper.getMainLooper());
            this.mDNManager = new WeakReference<>(syncDownloadManager);
        }

        public void handleMessage(Message message) {
            long j = 0;
            SyncDownloadManager syncDownloadManager = (SyncDownloadManager) this.mDNManager.get();
            if (syncDownloadManager != null) {
                switch (message.what) {
                    case 0:
                        HttpProgressor httpProgressor = (HttpProgressor) message.obj;
                        long currentSize = httpProgressor.getCurrentSize();
                        long totalSize = httpProgressor.getTotalSize();
                        if (totalSize > 0) {
                            j = (100 * currentSize) / totalSize;
                        }
                        int i = (int) j;
                        if (i < 0) {
                            i = 0;
                        } else if (i > 100) {
                            i = 100;
                        }
                        if (syncDownloadManager.mCallback != null) {
                            syncDownloadManager.mCallback.onProgress(i);
                            return;
                        }
                        return;
                    case 1:
                        if (syncDownloadManager.mCallback != null) {
                            syncDownloadManager.mCallback.onStartDecompress();
                            return;
                        }
                        return;
                    case 1001:
                        if (syncDownloadManager.mCallback != null) {
                            syncDownloadManager.mCallback.onStart();
                            return;
                        }
                        return;
                    case SyncDownloadManager.LOCAL_MSG_COMPLETE /*1004*/:
                        boolean booleanValue = ((Boolean) message.obj).booleanValue();
                        syncDownloadManager.mResCode = syncDownloadManager.mManager.getContext().getResponse().responseCode;
                        syncDownloadManager.mResTargetPath = syncDownloadManager.mManager.getContext().getResponse().getDownloadPath();
                        if (!booleanValue) {
                            if (syncDownloadManager.isCancelled() && syncDownloadManager.mCallback != null) {
                                syncDownloadManager.mCallback.onStop();
                            }
                            if (syncDownloadManager.mCallback != null) {
                                syncDownloadManager.mCallback.onComplete(false, syncDownloadManager.mResTargetPath, syncDownloadManager.mResCode);
                                return;
                            }
                            return;
                        } else if (syncDownloadManager.mCallback != null) {
                            syncDownloadManager.mCallback.onProgress(100);
                            syncDownloadManager.mCallback.onComplete(true, syncDownloadManager.mResTargetPath, syncDownloadManager.mResCode);
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    static class RequestParam {
        boolean autoDecomp;
        IBackoffPolicy bfpolicy;
        int concurrence;
        int connTimeout;
        String destPath;
        int maxRetry;
        int readTimeout;
        String url;

        private RequestParam() {
            this.autoDecomp = true;
            this.concurrence = 1;
            this.maxRetry = 0;
            this.readTimeout = 0;
            this.connTimeout = 0;
            this.bfpolicy = SyncDownloadManager.DEF_BF_POLICY;
        }
    }

    private SyncDownloadManager() {
        this.mRequestParam = new RequestParam();
        this.mDownloading = false;
        this.mHandler = new DownloadHandler(this);
    }

    /* access modifiers changed from: private */
    public void refresh() {
        HttpContext httpContext;
        if (this.mManager == null || this.mManager.getContext() == null) {
            httpContext = new HttpContext();
            this.mManager = new HttpManager(httpContext);
        } else {
            httpContext = this.mManager.getContext();
        }
        HttpRequest request = httpContext.getRequest();
        request.setUrl(this.mRequestParam.url);
        request.setMethod(HTTP_METHOD.GET);
        request.setDestPath(this.mRequestParam.destPath);
        request.setAutoDecompress(this.mRequestParam.autoDecomp);
        request.setMaxRetry(this.mRequestParam.maxRetry);
        request.setReadTimeout(this.mRequestParam.readTimeout);
        request.setConnTimeout(this.mRequestParam.connTimeout);
        request.setConcurrence(this.mRequestParam.concurrence);
        request.setBackoffPolicy(this.mRequestParam.bfpolicy);
    }

    public final void setUrl(String str) {
        this.mRequestParam.url = str;
        refresh();
    }

    public final String getUrl() {
        return this.mRequestParam.url;
    }

    public final void setDestPath(String str) {
        this.mRequestParam.destPath = str;
        refresh();
    }

    public final String getDestPath() {
        return this.mRequestParam.destPath;
    }

    public final void setAutoDecompress(boolean z) {
        this.mRequestParam.autoDecomp = z;
        refresh();
    }

    public final boolean isAutoDecompress() {
        return this.mRequestParam.autoDecomp;
    }

    public final void setConcurrence(int i) {
        this.mRequestParam.concurrence = i;
        refresh();
    }

    public final int getConcurrence() {
        return this.mRequestParam.concurrence;
    }

    public final void setMaxRetry(int i) {
        this.mRequestParam.maxRetry = i;
        refresh();
    }

    public final int getMaxRetry() {
        return this.mRequestParam.maxRetry;
    }

    public final void setReadTimeout(int i) {
        this.mRequestParam.readTimeout = i;
        refresh();
    }

    public final int getReadTimeout() {
        return this.mRequestParam.readTimeout;
    }

    public final void setConnTimeout(int i) {
        this.mRequestParam.connTimeout = i;
        refresh();
    }

    public final int getConnTimeout() {
        return this.mRequestParam.connTimeout;
    }

    public final void setBackoffPolicy(IBackoffPolicy iBackoffPolicy) {
        this.mRequestParam.bfpolicy = iBackoffPolicy;
        refresh();
    }

    public final void setCallback(DownloadCallback downloadCallback) {
        this.mCallback = downloadCallback;
        refresh();
    }

    public final int getResCode() {
        return this.mManager.getContext().getResponse().responseCode;
    }

    public final String getResTargetPath() {
        return this.mManager.getContext().getResponse().getDownloadPath();
    }

    public final boolean start() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("Must not start download in the main thread!");
        } else if (this.mDownloading) {
            return false;
        } else {
            this.mDownloading = true;
            if (this.mManager != null) {
                this.mManager.getContext().getResponse().isCancel = false;
                this.mManager.getContext().getResponse().cancelable.mCanceled = false;
            }
            sendStart();
            boolean downloadFile = this.mManager.downloadFile(this.mHandler);
            sendComplete(downloadFile);
            this.mDownloading = false;
            return downloadFile;
        }
    }

    public final boolean stop() {
        cancel();
        return true;
    }

    private synchronized void cancel() {
        if (this.mManager != null) {
            this.mManager.getContext().getResponse().isCancel = true;
            this.mManager.getContext().getResponse().cancelable.mCanceled = true;
        }
    }

    /* access modifiers changed from: private */
    public synchronized boolean isCancelled() {
        if (this.mManager == null) {
            throw new RuntimeException("invalid sync download manager, http manager is null.");
        }
        return this.mManager.getContext().getResponse().isCancel || this.mManager.getContext().getResponse().isCancel;
    }

    private void sendStart() {
        this.mHandler.sendEmptyMessage(1001);
    }

    private void sendComplete(boolean z) {
        Message obtainMessage = this.mHandler.obtainMessage(LOCAL_MSG_COMPLETE);
        obtainMessage.obj = Boolean.valueOf(z);
        this.mHandler.sendMessage(obtainMessage);
    }
}
