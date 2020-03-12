package com.baicizhan.client.framework.device;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import com.baicizhan.client.framework.BaseAppHandler;

public class DeviceInfo {
    public static final String ANDROID_VERSION = VERSION.RELEASE;
    private static String BAICIZHAN_VERSION = "";
    private static String BAICIZHAN_VERSION_CODE = "";
    private static String BAICIZHAN_VERSION_NAME = "";
    public static final String PHONE_MODEL = (Build.MODEL + " - " + Build.MANUFACTURER);

    public static final String getBaicizhanVersion() {
        return BAICIZHAN_VERSION;
    }

    public static final String getBaicizhanVersionName() {
        return BAICIZHAN_VERSION_NAME;
    }

    public static final String getBaicizhanVersionCode() {
        return BAICIZHAN_VERSION_CODE;
    }

    public static final synchronized void init() {
        synchronized (DeviceInfo.class) {
            try {
                PackageInfo packageInfo = BaseAppHandler.getApp().getPackageManager().getPackageInfo(BaseAppHandler.getApp().getPackageName(), 0);
                String str = packageInfo.versionName;
                int i = packageInfo.versionCode;
                BAICIZHAN_VERSION = str + " - " + i;
                BAICIZHAN_VERSION_NAME = str;
                BAICIZHAN_VERSION_CODE += i;
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
