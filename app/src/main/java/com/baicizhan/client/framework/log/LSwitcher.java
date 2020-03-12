package com.baicizhan.client.framework.log;

import android.os.Looper;

public class LSwitcher {
    private static volatile boolean sOpenInMainFW = true;
    private static volatile boolean sOpenOnNet = false;

    public static final void toggle(boolean z) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            sOpenInMainFW = z;
        }
    }

    public static final boolean isOpened() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return sOpenInMainFW;
        }
        return true;
    }

    public static final void openOnNet(boolean z) {
        sOpenOnNet = z;
    }

    public static final boolean isOpenOnNet() {
        return sOpenOnNet;
    }
}
