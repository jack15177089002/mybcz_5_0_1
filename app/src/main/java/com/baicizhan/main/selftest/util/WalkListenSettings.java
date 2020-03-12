//package com.baicizhan.main.selftest.util;
//
//import com.baicizhan.client.business.settings.Settings;
//
//public class WalkListenSettings {
//    private static final String PREF_FIRST_WALKLISTEN = "pref_first_walklisten";
//    private static final String PREF_PLAY_ZHANHUWEI = "pref_play_zhanhuwei";
//
//    private WalkListenSettings() {
//    }
//
//    public static boolean isPlayZhanhuwei() {
//        return Settings.getSharedPreferences().getBoolean(PREF_PLAY_ZHANHUWEI, true);
//    }
//
//    public static void setPlayZhanhuwei(boolean z) {
//        Settings.getSharedPreferences().edit().putBoolean(PREF_PLAY_ZHANHUWEI, z).commit();
//    }
//
//    public static boolean isFirstWalkListen() {
//        return Settings.getSharedPreferences().getBoolean(PREF_FIRST_WALKLISTEN, true);
//    }
//
//    public static void setFirstWalkListen(boolean z) {
//        Settings.getSharedPreferences().edit().putBoolean(PREF_FIRST_WALKLISTEN, z).commit();
//    }
//}
