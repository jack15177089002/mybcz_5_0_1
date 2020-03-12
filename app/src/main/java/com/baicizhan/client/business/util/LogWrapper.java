package com.baicizhan.client.business.util;

import android.util.Log;
import com.baicizhan.client.framework.log.C0789L;

public class LogWrapper {
    public static final int MODE_FILE = 2;
    public static final int MODE_LOGCAT = 1;
    public static final int MODE_NULL = 0;
    private static int sMode = 0;

    public static void setMode(int i) {
        sMode = i;
    }

    private static String getTagedMessage(String str, String str2) {
        return String.format("[%s] %s", new Object[]{str, str2});
    }

    /* renamed from: v */
    public static void m2796v(String str, String str2) {
        if ((sMode & 1) > 0) {
            Log.v(str, str2);
        }
        if ((sMode & 2) > 0) {
            C0789L.log.trace(getTagedMessage(str, str2));
        }
    }

    /* renamed from: d */
    public static void m2793d(String str, String str2) {
        if ((sMode & 1) > 0) {
            Log.d(str, str2);
        }
        if ((sMode & 2) > 0) {
            C0789L.log.debug(getTagedMessage(str, str2));
        }
    }

    /* renamed from: i */
    public static void m2795i(String str, String str2) {
        if ((sMode & 1) > 0) {
            Log.i(str, str2);
        }
        if ((sMode & 2) > 0) {
            C0789L.log.info(getTagedMessage(str, str2));
        }
    }

    /* renamed from: w */
    public static void m2797w(String str, String str2) {
        if ((sMode & 1) > 0) {
            Log.w(str, str2);
        }
        if ((sMode & 2) > 0) {
            C0789L.log.warn(getTagedMessage(str, str2));
        }
    }

    /* renamed from: e */
    public static void m2794e(String str, String str2) {
        if ((sMode & 1) > 0) {
            Log.e(str, str2);
        }
        if ((sMode & 2) > 0) {
            C0789L.log.error(getTagedMessage(str, str2));
        }
    }
}
