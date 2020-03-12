//package com.baicizhan.client.p029fm.util;
//
//import android.text.TextUtils;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.util.PathUtil;
////import com.baicizhan.online.bs_users.BBCheckInfo;
//
///* renamed from: com.baicizhan.client.fm.util.FmUtil */
//public class FmUtil {
//    private static final String DEF_CANDIDATE_RES_DNS = "http://baicizhan.qiniucdn.com";
//    private static final String DEF_RES_DNS = "http://baicizhan.qiniucdn.com";
//    public static final String FM_DIR = (PathUtil.BCZ_HOME + "/word_fm_audio_pack");
//
//    private FmUtil() {
//    }
//
//    public static String reformFmPath(String str) {
//        String reformSuffix = reformSuffix(str, ".amr");
//        if (reformSuffix == null) {
//            return reformSuffix(str, ".m4a");
//        }
//        return reformSuffix;
//    }
//
//    private static String reformSuffix(String str, String str2) {
//        if (str == null) {
//            return null;
//        }
//        int lastIndexOf = str.lastIndexOf(str2);
//        if (lastIndexOf >= 0) {
//            return str.substring(0, lastIndexOf) + PathUtil.BAICIZHAN_RESOURCE_EXTENSION;
//        }
//        if (str.lastIndexOf(PathUtil.BAICIZHAN_RESOURCE_EXTENSION) <= 0) {
//            return null;
//        }
//        return str;
//    }
//
//    public static String getDataDns() {
////        BBCheckInfo checkInfo = StudyManager.getInstance().getCheckInfo();
////        if (checkInfo == null) {
////            return ConstantsUtil.DEFAULT_DNS;
////        }
////        String res_dns = checkInfo.getRes_dns();
////        if (TextUtils.isEmpty(res_dns)) {
////            return ConstantsUtil.DEFAULT_DNS;
////        }
////        return res_dns;
//
//        return null;
//    }
//
//    public static String getCandDataDns() {
////        BBCheckInfo checkInfo = StudyManager.getInstance().getCheckInfo();
////        if (checkInfo == null) {
////            return ConstantsUtil.DEFAULT_DNS;
////        }
////        String other_res_dns = checkInfo.getOther_res_dns();
////        if (TextUtils.isEmpty(other_res_dns)) {
////            return ConstantsUtil.DEFAULT_DNS;
////        }
////        return other_res_dns;
//
//        return null;
//    }
//}
