//package com.baicizhan.main;
//
//import android.content.Context;
//import android.content.IntentFilter;
//import android.os.Process;
//import android.support.p003a.MultiDex;
//import android.util.Log;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.fight.WordVSAppHandler;
//import com.baicizhan.client.framework.BaseApp;
//import com.baicizhan.client.framework.handler.AbstractAppHandler;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.client.video.VideoAppHandler;
//import com.baicizhan.client.wordlock.WordLockAppHandler;
//import com.baicizhan.client.wordtesting.application.WordTestingApplicationHandler;
//
//public class DemoApp extends BaseApp {
//    public static final String BROADCAST_ACTION_EXIT_APP = "baicizhan_exit_app";
//    public static final String TOP_PEMISSION = "com.baicizhan.permission.TOP_LEVEL";
//
//    public void onCreate() {
//        super.onCreate();
//        Log.d("DemoApp", "!!!!! DemoApp onCreate " + Process.myPid() + ", " + Common.getProcessName(getApplicationContext()));
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(BROADCAST_ACTION_EXIT_APP);
//        registerReceiver(new ExitBroadcastReceiver(), intentFilter, TOP_PEMISSION, null);
//    }
//
//    public void onTerminate() {
//        super.onTerminate();
//        LogWrapper.m2793d("DemoApp", "onTerminate");
//        Settings.putLong(Settings.PREF_LAST_USER_INFO_TIME, 0);
//    }
//
//    public AbstractAppHandler[] getRawHandlers() {
//        return new AbstractAppHandler[]{new DemoHandler(), new WordLockAppHandler(), new WordVSAppHandler(), new WordTestingApplicationHandler(), new VideoAppHandler()};
//    }
//
//    /* access modifiers changed from: protected */
//    public void attachBaseContext(Context context) {
//        super.attachBaseContext(context);
//        MultiDex.m22a((Context) this);
//    }
//
//    public void onLowMemory() {
//        super.onLowMemory();
//        LogWrapper.m2793d("DemoApp", "onLowMemory");
//        PicassoUtil.releaseMemory();
//        System.gc();
//    }
//}
