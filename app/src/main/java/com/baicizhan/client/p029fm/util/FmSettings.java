//package com.baicizhan.client.p029fm.util;
//
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//
///* renamed from: com.baicizhan.client.fm.util.FmSettings */
//public class FmSettings {
//    public static final int DEF_LOOP_NUM = 1;
//    public static final int DEF_PLUS_NUM = 50;
//    public static final String KEY_DOWN_HIGH = "key_fm_down_high";
//    public static final String KEY_LOOP_NUM = "key_fm_loop_num";
//    public static final String KEY_PLUS_NUM = "key_fm_plus_num";
//    public static final int MAX_LOOP_NUM = 4;
//    public static final int MAX_PLUS_NUM = 200;
//    public static final int PLUS_STEP = 10;
//
//    private FmSettings() {
//    }
//
//    public static void setDownloadHigh(boolean z) {
//        PropertyHelper.put(KEY_DOWN_HIGH, z);
//    }
//
//    public static boolean isDownloadHigh() {
//        return PropertyHelper.getBoolean(KEY_DOWN_HIGH);
//    }
//
//    public static void setLoopNum(int i) {
//        PropertyHelper.put(KEY_LOOP_NUM, i);
//    }
//
//    public static int getLoopNum() {
//        int i = PropertyHelper.getInt(KEY_LOOP_NUM);
//        if (i == 0) {
//            return 1;
//        }
//        return i;
//    }
//
//    public static void setPlusNum(int i) {
//        PropertyHelper.put(KEY_PLUS_NUM, i);
//    }
//
//    public static int getPlusNum() {
//        int i = PropertyHelper.getInt(KEY_PLUS_NUM);
//        if (i == 0) {
//            return 50;
//        }
//        return i;
//    }
//}
