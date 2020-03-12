package com.baicizhan.client.wordlock.util;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.UserManager;
//import com.baicizhan.client.wordtesting.activity.VocabStatsActivity;

public class AppMonitor {
    public static final String TAG = AppMonitor.class.getSimpleName();
    private static boolean mIsValid;

    private static native int createWatcher(String str, String str2);

    public static native void killChild(int i);

    static {
        mIsValid = true;
        try {
            System.loadLibrary("monitor");
        } catch (Throwable th) {
            mIsValid = false;
        }
    }

    @TargetApi(17)
    public static String getUserSerial(Context context) {
//        if (VERSION.SDK_INT < 17) {
            return null;
//        }
//        UserManager userManager = (UserManager) context.getSystemService(VocabStatsActivity.EXTRA_USER);
//        if (userManager == null) {
//            return null;
//        }
//        try {
//            return String.valueOf(userManager.getSerialNumberForUser(Process.myUserHandle()));
//        } catch (Exception e) {
//            return null;
//        }
    }

    public static int createAppMonitor(Context context, Class<? extends Service> cls) {
        if (!mIsValid) {
            return 0;
        }
        return createWatcher(getUserSerial(context), context.getApplicationInfo().packageName + "/" + cls.getCanonicalName());
    }

    public static boolean isMonitorValid() {
        return mIsValid;
    }
}
