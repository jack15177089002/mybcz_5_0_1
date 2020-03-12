//package com.baicizhan.main.receiver;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.main.service.NoticeAlarmService;
//
//public class NoticeBroadcastReceiver extends BroadcastReceiver {
//    public static final String ACTION_NOTICE_ALARM = "notice_alarm";
//    private static final String TAG = NoticeBroadcastReceiver.class.getSimpleName();
//
//    public void onReceive(Context context, Intent intent) {
//        LogWrapper.m2793d(TAG, "NoticeBroadcastReceiver .... ");
//        if (Settings.getLong(Settings.PREF_NOTICE_SETTING_TIME) != 0) {
//            Intent intent2 = new Intent(context, NoticeAlarmService.class);
//            intent2.setFlags(268435456);
//            intent2.setAction("android.intent.action.RUN");
//            context.startService(intent2);
//        }
//    }
//}
