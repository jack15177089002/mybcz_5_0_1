package com.baicizhan.client.framework.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.baicizhan.client.friend.model.FriendRecord;
import java.util.LinkedList;
import java.util.List;

public class PackageUtils {
    private static String sChannel = null;
    private static float sFloatVersion = -1.0f;
    private static int sVersionCode = 0;
    private static String sVersionName = null;

    public class SimpleAppInfo {
        public String name;
        public String pkg;
        public String version;

        public String toString() {
            return "SimpleAppInfo [version=" + this.version + ", pkg=" + this.pkg + ", name=" + this.name + "]";
        }
    }

    public static String getPackageVersion(Context context) {
        if (sVersionName != null) {
            return sVersionName;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            sVersionName = str;
            return str;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            String str2 = "";
            sVersionName = str2;
            return str2;
        }
    }

    public static float getFloatPackageVersion(Context context) {
        float f = 0.0f;
        if (sFloatVersion >= 0.0f) {
            return sFloatVersion;
        }
        String packageVersion = getPackageVersion(context);
        if (packageVersion == null) {
            return 0.0f;
        }
        String[] split = packageVersion.split("\\.");
        float f2 = 1.0f;
        int i = 0;
        while (i < split.length) {
            float intValue = (((float) Integer.valueOf(split[i]).intValue()) * f2) + f;
            f2 *= 0.1f;
            i++;
            f = intValue;
        }
        sFloatVersion = f;
        return f;
    }

    public static int getPackageVersionCode(Context context) {
        if (sVersionCode > 0) {
            return sVersionCode;
        }
        try {
            int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            sVersionCode = i;
            return i;
        } catch (NameNotFoundException e) {
            sVersionCode = 0;
            return 0;
        }
    }

    public static String getChannel(Context context) {
        if (sChannel != null) {
            return sChannel;
        }
        try {
            sChannel = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            sChannel = FriendRecord.ACCOUNT_UNKNOWN;
        }
        return sChannel;
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

    public List<SimpleAppInfo> getInstallAppInfos(Context context) {
        LinkedList linkedList = new LinkedList();
        PackageManager packageManager = context.getPackageManager();
        for (PackageInfo packageInfo : packageManager.getInstalledPackages(0)) {
            SimpleAppInfo simpleAppInfo = new SimpleAppInfo();
            simpleAppInfo.name = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            simpleAppInfo.pkg = packageInfo.packageName;
            simpleAppInfo.version = packageInfo.versionName;
            linkedList.add(simpleAppInfo);
        }
        return linkedList;
    }
}
