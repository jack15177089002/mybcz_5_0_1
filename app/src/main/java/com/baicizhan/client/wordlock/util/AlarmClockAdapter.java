//package com.baicizhan.client.wordlock.util;
//
//import android.app.Application;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.IntentFilter;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.client.wordlock.WordLockAppHandler;
//
//public class AlarmClockAdapter {
//    private static final String ALARM_ACTIVITY_21 = "com.android.deskclock.alarms.AlarmActivity";
//    private static final String ALARM_ACTIVITY_7 = "";
//    private static final String ALARM_ACTIVITY_8 = "";
//    private static final String ALARM_ACTIVITY_DEF = "com.android.deskclock.alarms.AlarmActivity";
//    private static final String ALARM_ACTIVITY_HTC = "";
//    private static final String ALARM_ACTIVITY_MOTOROLA = "";
//    private static final String ALARM_ACTIVITY_SONY = "";
//    private static final String ALARM_ACTIVITY_SUMSUNG_S = "";
//    private static final String ALARM_ACTIVITY_XIAOMI = "com.android.deskclock.AlarmAlertFullScreen";
//    private static final String ALARM_ACTIVITY_ZTE = "";
//    private static final String ALARM_ALERT_7 = "com.android.alarmclock.ALARM_ALERT";
//    private static final String ALARM_ALERT_8 = "com.android.deskclock.ALARM_ALERT";
//    private static final String ALARM_ALERT_HTC = "com.htc.android.worldclock.ALARM_ALERT";
//    private static final String ALARM_ALERT_HTC_1 = "com.htc.android.worldclock.AlarmAlert";
//    private static final String ALARM_ALERT_MOTOROLA = "com.motorola.blur.alarmclock.ALARM_ALERT";
//    private static final String ALARM_ALERT_SONY = "com.sonyericsson.alarm.ALARM_ALERT";
//    private static final String ALARM_ALERT_SUMSUNG = "com.samsung.sec.android.clockpackage.alarm.ALARM_ALERT";
//    private static final String ALARM_ALERT_SUMSUNG_S = "com.sec.android.app.clockpackage.ALARM_ALERT";
//    private static final String ALARM_ALERT_ZTE = "zte.com.cn.alarmclock.ALARM_ALERT";
//    private static final String ALARM_PACKAGE_21 = "com.google.android.deskclock";
//    private static final String ALARM_PACKAGE_7 = "";
//    private static final String ALARM_PACKAGE_8 = "";
//    private static final String ALARM_PACKAGE_DEF = "com.android.deskclock";
//    private static final String ALARM_PACKAGE_HTC = "";
//    private static final String ALARM_PACKAGE_MOTOROLA = "";
//    private static final String ALARM_PACKAGE_SONY = "";
//    private static final String ALARM_PACKAGE_SUMSUNG_S = "";
//    private static final String ALARM_PACKAGE_XIAOMI = "com.android.deskclock";
//    private static final String ALARM_PACKAGE_ZTE = "";
//
//    public static final void registerAlarmAlert(Context context, BroadcastReceiver broadcastReceiver) {
//        if (context != null && broadcastReceiver != null) {
//            IntentFilter intentFilter = new IntentFilter(ALARM_ALERT_8);
//            intentFilter.addAction(ALARM_ALERT_7);
//            intentFilter.addAction(ALARM_ALERT_SUMSUNG_S);
//            intentFilter.addAction(ALARM_ALERT_SUMSUNG);
//            intentFilter.addAction(ALARM_ALERT_HTC);
//            intentFilter.addAction(ALARM_ALERT_HTC_1);
//            intentFilter.addAction(ALARM_ALERT_SONY);
//            intentFilter.addAction(ALARM_ALERT_ZTE);
//            intentFilter.addAction(ALARM_ALERT_MOTOROLA);
//            context.registerReceiver(broadcastReceiver, intentFilter);
//        }
//    }
//
//    public static final boolean isAlarmAlert(String str) {
//        if (str == null) {
//            return false;
//        }
//        if (str.equals(ALARM_ALERT_8) || str.equals(ALARM_ALERT_7) || str.equals(ALARM_ALERT_SUMSUNG_S) || str.equals(ALARM_ALERT_SUMSUNG) || str.equals(ALARM_ALERT_HTC) || str.equals(ALARM_ALERT_HTC_1) || str.equals(ALARM_ALERT_SONY) || str.equals(ALARM_ALERT_ZTE) || str.equals(ALARM_ALERT_MOTOROLA)) {
//            return true;
//        }
//        return false;
//    }
//
//    public static final boolean isAlarmRinging() {
//        Application app = WordLockAppHandler.getApp();
//        return Common.isActivityRunningTop(app, "", "") || Common.isActivityRunningTop(app, "", "") || Common.isActivityRunningTop(app, ALARM_PACKAGE_21, "com.android.deskclock.alarms.AlarmActivity") || Common.isActivityRunningTop(app, "com.android.deskclock", ALARM_ACTIVITY_XIAOMI) || Common.isActivityRunningTop(app, "com.android.deskclock", "com.android.deskclock.alarms.AlarmActivity") || Common.isActivityRunningTop(app, "", "") || Common.isActivityRunningTop(app, "", "") || Common.isActivityRunningTop(app, "", "") || Common.isActivityRunningTop(app, "", "") || Common.isActivityRunningTop(app, "", "");
//    }
//}
