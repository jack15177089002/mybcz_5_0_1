//package com.baicizhan.client.wordlock.service;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import com.baicizhan.client.wordlock.setting.Settings;
//
//public class Boot2StartLockReceiver extends BroadcastReceiver {
//    public void onReceive(Context context, Intent intent) {
//        if (Settings.isWordLockscreenEnabled()) {
//            WordLockService.startForRefreshTopN(context, null);
//            WordLockDaemon.start(context);
//        }
//    }
//}
