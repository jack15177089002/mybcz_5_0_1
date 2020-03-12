package com.baicizhan.main.upgrade;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baicizhan.client.business.util.LogWrapper;
import com.baicizhan.client.friend.model.FriendRecord;

public class PackageUtils {
    public static String getPackageVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getPackageVersionCode(Context context) {
        boolean z = false;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getMetaData(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (Exception e) {
            LogWrapper.m2793d("debug", Log.getStackTraceString(e));
            return null;
        }
    }

    public static String getChannel(Context context) {
        String metaData = getMetaData(context, "UMENG_CHANNEL");
        if (TextUtils.isEmpty(metaData)) {
            return FriendRecord.ACCOUNT_UNKNOWN;
        }
        return metaData;
    }

    public static boolean isDebug(Context context) {
        String metaData = getMetaData(context, "DEBUG_MODE");
        if (TextUtils.isEmpty(metaData)) {
            return false;
        }
        return metaData.equals("enable");
    }

    public static String getAndroidId(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String getDeviceId(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    public static String getSerialNumber() {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.serialno"});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
