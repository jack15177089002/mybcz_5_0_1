package com.baicizhan.client.business.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.baicizhan.client.framework.device.DeviceInfo;
//import com.tencent.android.tpush.common.Constants;
import java.util.Locale;

public class DeviceUtil {
    public static final boolean IS_HONG_MI_1S = DeviceInfo.PHONE_MODEL.equals("HM 1SW - Xiaomi");
    public static final boolean IS_M1_NOTE_MEIZU = DeviceInfo.PHONE_MODEL.equals("m1 note - Meizu");
    public static final boolean IS_MI_2S = DeviceInfo.PHONE_MODEL.equals("MI 2S - Xiaomi");
    public static final boolean IS_MX4_MEIZU = DeviceInfo.PHONE_MODEL.equals("MX4 - Meizu");
    private static final String TAG = DeviceUtil.class.getSimpleName();
    private static long sTotalMemorySize = -1;

    public static final boolean isMeizu() {
        return DeviceInfo.PHONE_MODEL.toLowerCase(Locale.US).contains("meizu");
    }

    private DeviceUtil() {
    }

    public static long getDeviceTotalMemoryBytes(Context context) {
        if (sTotalMemorySize != -1) {
            return sTotalMemorySize;
        }
        if (VERSION.SDK_INT >= 16) {
            long deviceTotalMemoryBytesJellyBean = getDeviceTotalMemoryBytesJellyBean(context);
            if (deviceTotalMemoryBytesJellyBean > 0) {
                sTotalMemorySize = deviceTotalMemoryBytesJellyBean;
                return sTotalMemorySize;
            }
        }
        sTotalMemorySize = getDeviceTotalMemoryBytesDefault();
        return sTotalMemorySize;
    }

    public static int getDeviceTotalMemoryGigaBytes(Context context) {
        return (int) Math.round(((double) getDeviceTotalMemoryBytes(context)) / 1.0E9d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006b A[SYNTHETIC, Splitter:B:16:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0075 A[SYNTHETIC, Splitter:B:22:0x0075] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long getDeviceTotalMemoryBytesDefault() {
        /*
            r2 = 0
            r0 = 0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0068, all -> 0x0070 }
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ IOException -> 0x0068, all -> 0x0070 }
            java.lang.String r5 = "/proc/meminfo"
            r1.<init>(r5)     // Catch:{ IOException -> 0x0068, all -> 0x0070 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0068, all -> 0x0070 }
        L_0x000f:
            java.lang.String r0 = r4.readLine()     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            if (r0 == 0) goto L_0x0063
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            java.lang.String r1 = "memtotal"
            boolean r1 = r0.contains(r1)     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            if (r1 == 0) goto L_0x000f
            java.lang.String r1 = "\\s+"
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            java.lang.String r1 = "DeviceUtil"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            java.lang.String r6 = "/proc/meminfo: "
            r5.<init>(r6)     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            java.lang.String r6 = ","
            java.lang.String r6 = android.text.TextUtils.join(r6, r0)     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            com.baicizhan.client.business.util.LogWrapper.m2793d(r1, r5)     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            r1 = 1
            r0 = r0[r1]     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            r6 = 1024(0x400, double:5.06E-321)
            long r0 = r0 * r6
            java.lang.String r5 = TAG     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            java.lang.String r7 = "getDeviceTotalMemoryDefault "
            r6.<init>(r7)     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            java.lang.StringBuilder r6 = r6.append(r0)     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            com.baicizhan.client.business.util.LogWrapper.m2793d(r5, r6)     // Catch:{ IOException -> 0x0083, all -> 0x0081 }
            r4.close()     // Catch:{ IOException -> 0x0079 }
        L_0x0062:
            return r0
        L_0x0063:
            r4.close()     // Catch:{ IOException -> 0x007b }
        L_0x0066:
            r0 = r2
            goto L_0x0062
        L_0x0068:
            r1 = move-exception
        L_0x0069:
            if (r0 == 0) goto L_0x006e
            r0.close()     // Catch:{ IOException -> 0x007d }
        L_0x006e:
            r0 = r2
            goto L_0x0062
        L_0x0070:
            r1 = move-exception
            r4 = r0
            r0 = r1
        L_0x0073:
            if (r4 == 0) goto L_0x0078
            r4.close()     // Catch:{ IOException -> 0x007f }
        L_0x0078:
            throw r0
        L_0x0079:
            r2 = move-exception
            goto L_0x0062
        L_0x007b:
            r0 = move-exception
            goto L_0x0066
        L_0x007d:
            r0 = move-exception
            goto L_0x006e
        L_0x007f:
            r1 = move-exception
            goto L_0x0078
        L_0x0081:
            r0 = move-exception
            goto L_0x0073
        L_0x0083:
            r0 = move-exception
            r0 = r4
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.util.DeviceUtil.getDeviceTotalMemoryBytesDefault():long");
    }

    @TargetApi(16)
    private static long getDeviceTotalMemoryBytesJellyBean(Context context) {
//        ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
//        MemoryInfo memoryInfo = new MemoryInfo();
//        activityManager.getMemoryInfo(memoryInfo);
//        LogWrapper.m2793d(TAG, "getDeviceTotalMemoryJellyBean " + memoryInfo.totalMem);
//        return memoryInfo.totalMem;
        return 0;
    }
}
