package p012ch.qos.logback.core.android;

import android.os.Environment;
import p012ch.qos.logback.core.util.EnvUtil;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.android.CommonPathUtil */
public abstract class CommonPathUtil {
    private static final String ASSETS_DIRECTORY = "assets";

    public static String getMountedExternalStorageDirectoryPath() {
        if (!EnvUtil.isAndroidOS()) {
            return "/mnt/sdcard";
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return null;
    }

    public static String getExternalStorageDirectoryPath() {
        if (EnvUtil.isAndroidOS()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        String env = OptionHelper.getEnv("EXTERNAL_STORAGE");
        return env == null ? "/sdcard" : env;
    }

    public static String getFilesDirectoryPath(String str) {
        return new StringBuilder(String.valueOf(EnvUtil.isAndroidOS() ? Environment.getExternalStorageDirectory() + "/Android/data" : "/mnt/sdcard/Android/data")).append("/").append(str).toString();
    }

    public static String getAssetsDirectoryPath() {
        return ASSETS_DIRECTORY;
    }

    public static String getDatabaseDirectoryPath(String str) {
        return new StringBuilder(String.valueOf(EnvUtil.isAndroidOS() ? Environment.getDataDirectory().getAbsolutePath() : "/data")).append("/data/").append(str).append("/databases").toString();
    }
}
