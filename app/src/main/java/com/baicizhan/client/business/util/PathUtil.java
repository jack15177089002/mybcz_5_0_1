package com.baicizhan.client.business.util;

import android.text.TextUtils;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.online.bs_users.BBCheckInfo;
import java.io.File;

public class PathUtil {
    public static final String BAICIZHAN_RESOURCE_EXTENSION = ".baicizhan";
    public static String BCZ_HOME = null;
    private static final String DEF_CANDIDATE_RES_DNS = "http://baicizhan.qiniucdn.com";
    private static final String DEF_RES_DNS = "http://baicizhan.qiniucdn.com";

    private PathUtil() {
    }

    public static void init() {
        BCZ_HOME = getBaicizhanAppRoot();
    }

    public static String reformFmPath(String str) {
        String reformSuffix = reformSuffix(str, ".amr");
        if (reformSuffix == null) {
            reformSuffix = reformSuffix(str, ".m4a");
        }
        if (reformSuffix == null) {
            return reformSuffix(str, ".mp3");
        }
        return reformSuffix;
    }

    public static String reformSuffix(String str, String str2) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf >= 0) {
            return str.substring(0, lastIndexOf) + BAICIZHAN_RESOURCE_EXTENSION;
        }
        if (str.lastIndexOf(BAICIZHAN_RESOURCE_EXTENSION) <= 0) {
            return null;
        }
        return str;
    }

    public static String getResDns() {
//        BBCheckInfo checkInfo = StudyManager.getInstance().getCheckInfo();
//        if (checkInfo == null) {
//            return ConstantsUtil.DEFAULT_DNS;
//        }
//        String res_dns = checkInfo.getRes_dns();
//        if (TextUtils.isEmpty(res_dns)) {
//            return ConstantsUtil.DEFAULT_DNS;
//        }
//        return res_dns;

        return null;
    }

    public static String getCandResDns() {
//        BBCheckInfo checkInfo = StudyManager.getInstance().getCheckInfo();
//        if (checkInfo == null) {
//            return ConstantsUtil.DEFAULT_DNS;
//        }
//        String other_res_dns = checkInfo.getOther_res_dns();
//        if (TextUtils.isEmpty(other_res_dns)) {
//            return ConstantsUtil.DEFAULT_DNS;
//        }
//        return other_res_dns;

        return null;
    }

    public static String getBaicizhanAppRoot() {
//        return PropertyHelper.getString(PropertyHelper.APP_ROOT);
        //test
        return "";
    }

    public static File getBaicizhanFile(String str) {
        String baicizhanAppRoot = getBaicizhanAppRoot();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(baicizhanAppRoot)) {
            return null;
        }
        return new File(baicizhanAppRoot, str);
    }

    public static File getBaicizhanResourceFile(String str) {
        return getBaicizhanResourceFile(str, BAICIZHAN_RESOURCE_EXTENSION);
    }

    public static File getBaicizhanResourceFile(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getBaicizhanFile(FileUtils.replaceExtension(str, str2));
    }

    public static String getBaicizhanResourcePath(String str) {
        File baicizhanResourceFile = getBaicizhanResourceFile(str);
        if (baicizhanResourceFile != null) {
            return baicizhanResourceFile.getAbsolutePath();
        }
        return null;
    }

    public static boolean isBaicizhanResourceFileExist(String str) {
        return isBaicizhanResourceFileExist(str, BAICIZHAN_RESOURCE_EXTENSION);
    }

    public static boolean isBaicizhanResourceFileExist(String str, String str2) {
        File baicizhanResourceFile = getBaicizhanResourceFile(str, str2);
        return baicizhanResourceFile != null && baicizhanResourceFile.exists() && baicizhanResourceFile.length() > 0;
    }
}
