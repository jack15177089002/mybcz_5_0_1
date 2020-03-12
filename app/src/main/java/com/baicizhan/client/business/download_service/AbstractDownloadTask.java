package com.baicizhan.client.business.download_service;

import android.os.Handler;
import android.os.Looper;

public abstract class AbstractDownloadTask {
    private static final Handler sHandler = new Handler(Looper.getMainLooper());
    public QiniuResourceDownloader mDownloader = new QiniuResourceDownloader();
    protected Listener mListener;

    public interface Listener {
        void onError(AbstractDownloadTask abstractDownloadTask, Throwable th);

        void onSuccess(AbstractDownloadTask abstractDownloadTask);
    }

    public abstract Object getUniqueKey();

    public abstract void run();

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public void postSuccess() {
        if (this.mListener != null) {
            sHandler.post(new Runnable() {
                public void run() {
                    AbstractDownloadTask.this.mListener.onSuccess(AbstractDownloadTask.this);
                }
            });
        }
    }

    public void postError(final Throwable th) {
        if (this.mListener != null) {
            sHandler.post(new Runnable() {
                public void run() {
                    AbstractDownloadTask.this.mListener.onError(AbstractDownloadTask.this, th);
                }
            });
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AbstractDownloadTask)) {
            return false;
        }
        Object uniqueKey = getUniqueKey();
        Object uniqueKey2 = ((AbstractDownloadTask) obj).getUniqueKey();
        if (uniqueKey == null || uniqueKey2 == null) {
            return false;
        }
        return uniqueKey.equals(uniqueKey2);
    }
}
