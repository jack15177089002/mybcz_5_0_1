//package com.baicizhan.main.stats.appscan;
//
//public class Settings {
//    private static final String PREF_LAST_TIME_SCAN_APP = "last_time_scan_app";
//    private static final long SCAN_CYCLE = 1209600000;
//
//    private Settings() {
//    }
//
//    public static void setLastTimeScanApp(long j) {
//        com.baicizhan.client.business.settings.Settings.putLong(PREF_LAST_TIME_SCAN_APP, j);
//    }
//
//    public static long getLastTimeScanApp() {
//        return com.baicizhan.client.business.settings.Settings.getLong(PREF_LAST_TIME_SCAN_APP);
//    }
//
//    public static boolean needScan() {
//        if (System.currentTimeMillis() - getLastTimeScanApp() >= SCAN_CYCLE) {
//            return true;
//        }
//        return false;
//    }
//}
