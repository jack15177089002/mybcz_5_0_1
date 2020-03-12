package com.baicizhan.client.framework.stat;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Environment;
import com.baicizhan.client.framework.BaseAppHandler;
import com.baicizhan.client.framework.log.C0789L;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class AbstractCrashManager {
    private static final long THRESHOLD = 5120;
    private String mCrashPath = (Environment.getExternalStorageDirectory() + "/Android/data/" + BaseAppHandler.getApp().getPackageName() + "/logs/crash.log");

    public abstract void upload(File file);

    private static boolean isFatal(Exception exc) {
        if (VERSION.SDK_INT >= 19) {
            return isFatal_API19(exc);
        }
        return exc instanceof RuntimeException;
    }

    @TargetApi(19)
    private static boolean isFatal_API19(Exception exc) {
        return (exc instanceof RuntimeException) || (exc instanceof ReflectiveOperationException);
    }

    public static void parse(Exception exc) {
        if (isFatal(exc)) {
            StringBuilder sb = new StringBuilder("\n[BCZ-CRASH] Fatal Exception, caused by: ");
            sb.append(exc);
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            sb.append("\n").append(stringWriter.toString());
            C0789L.log.error(sb.toString());
        }
    }

    public static void monitor() {
        Thread.currentThread().setUncaughtExceptionHandler(new CrashExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()));
    }

    public void checkAndUpload() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(this.mCrashPath);
            if (file.isFile() && file.exists() && needUpload(file.length())) {
                upload(file);
            }
        }
    }

    /* access modifiers changed from: protected */
    public long getThreshold() {
        return THRESHOLD;
    }

    /* access modifiers changed from: protected */
    public boolean needUpload(long j) {
        if (j >= getThreshold()) {
            return true;
        }
        return false;
    }
}
