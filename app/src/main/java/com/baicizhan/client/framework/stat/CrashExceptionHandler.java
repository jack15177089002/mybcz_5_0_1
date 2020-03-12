package com.baicizhan.client.framework.stat;

import java.lang.Thread.UncaughtExceptionHandler;

public class CrashExceptionHandler implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler mDefaultUEH;

    public CrashExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mDefaultUEH = uncaughtExceptionHandler;
    }

    public void destroy() {
        this.mDefaultUEH = null;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null && (th instanceof Exception)) {
            AbstractCrashManager.parse((Exception) th);
        }
        if (this.mDefaultUEH != null) {
            this.mDefaultUEH.uncaughtException(thread, th);
        }
    }
}
