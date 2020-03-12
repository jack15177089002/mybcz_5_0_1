package com.baicizhan.client.business.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.baicizhan.client.business.util.StorageUtils.StorageInfo;
import java.io.File;
import java.util.List;

public class StoragePathDetector {
    public static final String DATA_DB_FOLDER = "Android/data/com.jiongji.andriod.card/files/baicizhan/";
    static final String DATA_PATH = "baicizhan/";
    public static final String LEGACY_DB_FOLDER = "baicizhan/";
    public static final String PACKAGE_NAME = "com.jiongji.andriod.card";
    private static final String TAG = StoragePathDetector.class.getSimpleName();
    static final String USER_DB_NAME = "baicizhanuser.db";
    private static List<StorageInfo> mStorageList = null;
    final int VERSION_FORCE_STANDARD_FILE_DIR = 19;

    public static String getSDAbsolutePath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
    }

    public static String detect(Context context) {
        List<StorageInfo> allStorageInfo = getAllStorageInfo();
        LogWrapper.m2793d(TAG, "StorageList " + TextUtils.join(", ", allStorageInfo));
        try {
            for (StorageInfo isStorageAvailable : allStorageInfo) {
                String isStorageAvailable2 = isStorageAvailable(isStorageAvailable);
                if (isStorageAvailable2 != null) {
                    LogWrapper.m2793d(TAG, "dectect legacy " + isStorageAvailable2);
                    return isStorageAvailable2;
                }
            }
            return findBestStoragePath(allStorageInfo);
        } catch (Exception e) {
            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
            return findBestStoragePath(allStorageInfo);
        }
    }

    public static List<StorageInfo> getAllStorageInfo() {
        if (mStorageList == null) {
            mStorageList = StorageUtils.getStorageList();
        }
        return mStorageList;
    }

    private static String findBestStoragePath(List<StorageInfo> list) {
        LogWrapper.m2793d(TAG, "try findBestStoragePath");
        long j = -1;
        String str = null;
        for (StorageInfo storageInfo : list) {
            try {
                File file = new File(storageInfo.path, DATA_DB_FOLDER);
                file.mkdirs();
                String absolutePath = file.getAbsolutePath();
                if (!isFileCanReadWrite(absolutePath)) {
                    LogWrapper.m2793d(TAG, "file cant readwrite " + absolutePath);
                } else {
                    StatFs statFs = new StatFs(absolutePath);
                    long blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
                    LogWrapper.m2793d(TAG, "availableSize " + blockSize);
                    if (blockSize >= j) {
                        try {
                            LogWrapper.m2793d(TAG, "currentMaxPath " + absolutePath);
                        } catch (Exception e) {
                            j = blockSize;
                            String str2 = absolutePath;
                            e = e;
                            str = str2;
                            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
                        }
                    } else {
                        absolutePath = str;
                        blockSize = j;
                    }
                    str = absolutePath;
                    j = blockSize;
                }
            } catch (Exception e2) {
//                e = e2;
//                LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
            }
        }
        if (str != null) {
            return str;
        }
        LogWrapper.m2793d(TAG, "use default path ");
        return new File(Environment.getExternalStorageDirectory(), DATA_DB_FOLDER).getAbsolutePath();
    }

    private static String isStorageAvailable(StorageInfo storageInfo) {
        File file = new File(storageInfo.path, "baicizhan/");
        if (isFileCanReadWrite(file.getAbsolutePath())) {
            File file2 = new File(file, "baicizhanuser.db");
            if (isExist(file2.getAbsolutePath()) && isFileCanReadWrite(file2.getAbsolutePath())) {
                return file.getAbsolutePath();
            }
        }
        File file3 = new File(storageInfo.path, DATA_DB_FOLDER);
        if (isFileCanReadWrite(file3.getAbsolutePath())) {
            File file4 = new File(file3, "baicizhanuser.db");
            if (isExist(file4.getAbsolutePath()) && isFileCanReadWrite(file4.getAbsolutePath())) {
                return file3.getAbsolutePath();
            }
        }
        return null;
    }

    public static boolean isExist(String str) {
        try {
            File file = new File(str);
            boolean exists = file.exists();
            if (!exists || file.length() != 0) {
                return exists;
            }
            return false;
        } catch (Exception e) {
            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
            return false;
        }
    }

    public static boolean isFileCanReadWrite(String str) {
        try {
            File file = new File(str);
            if (!file.canRead() || !file.canWrite()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
            return false;
        }
    }
}
