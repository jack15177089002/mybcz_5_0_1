package com.baicizhan.client.business.util;

import android.os.Handler;
import android.os.Looper;

public abstract class AuthCallback<Result> {
    private static Handler sHandler = new Handler(Looper.getMainLooper());

    public abstract void onError(Throwable th);

    public abstract void onSuccess(Result result);

    public static void post(Runnable runnable) {
        if (isMain()) {
            runnable.run();
        } else {
            sHandler.post(runnable);
        }
    }

    public static void postDelayed(Runnable runnable, long j) {
        sHandler.postDelayed(runnable, j);
    }

    public void postSuccess(final Result result) {
        if (isMain()) {
            onSuccess(result);
        } else {
            sHandler.post(new Runnable() {
                public void run() {
                    AuthCallback.this.onSuccess(result);
                }
            });
        }
    }

    public void postProgress(final Object obj) {
        if (isMain()) {
            onProgress(obj);
        } else {
            sHandler.post(new Runnable() {
                public void run() {
                    AuthCallback.this.onProgress(obj);
                }
            });
        }
    }

    public void postError(final Throwable th) {
        if (isMain()) {
            onError(th);
        } else {
            sHandler.post(new Runnable() {
                public void run() {
                    AuthCallback.this.onError(th);
                }
            });
        }
    }

    public static final boolean isMain() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    public void onProgress(Object obj) {
    }
}
