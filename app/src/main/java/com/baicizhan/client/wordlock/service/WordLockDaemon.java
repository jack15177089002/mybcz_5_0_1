//package com.baicizhan.client.wordlock.service;
//
//import android.app.KeyguardManager;
//import android.app.KeyguardManager.KeyguardLock;
//import android.app.Service;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.os.IBinder;
//import android.util.Log;
//import com.baicizhan.client.wordlock.WordLockAppHandler;
//import com.baicizhan.client.wordlock.activity.WordLockClient;
//import com.baicizhan.client.wordlock.setting.Settings;
//import com.baicizhan.client.wordlock.util.AppMonitor;
//import com.baicizhan.client.wordlock.util.WordClientUsable;
//import com.baicizhan.client.wordlock.util.WordClientUsable.Callback;
//
//public class WordLockDaemon extends Service implements Callback {
//    private static final String ACTION_FORCE_STOP = "com.baicizhan.client.wordlock.action.FORCE_STOP";
//    private static final String EXTRA_HAS_WORD = "has_word";
//    private boolean mForceStop = false;
//    private KeyguardLock mKL;
//    private KeyguardManager mKM;
//    private int mMonitorPid = -1;
//    private ScreenOnOffReceiver mScreenOnOffReceiver = new ScreenOnOffReceiver();
//    private boolean mWordClientDisabled = false;
//    private WordClientUsable mWordClientUsable;
//
//    class ScreenOnOffReceiver extends BroadcastReceiver {
//        private ScreenOnOffReceiver() {
//        }
//
//        public void onReceive(Context context, Intent intent) {
//            String action = intent.getAction();
//            if (action != null) {
//                if (action.equals("android.intent.action.SCREEN_OFF")) {
//                    WordLockDaemon.this.wakeClient(true);
//                } else if (action.equals("android.intent.action.SCREEN_ON")) {
//                    WordLockDaemon.this.wakeClient(false);
//                    System.gc();
//                } else if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
//                    String stringExtra = intent.getStringExtra("reason");
//                    Log.d("whiz", "reason: " + stringExtra);
//                    if (!"homekey".equals(stringExtra)) {
//                        "lock".equals(stringExtra);
//                    }
//                }
//            }
//        }
//    }
//
//    public static final void start(Context context) {
//        if (context != null) {
//            Log.d("whiz", "wordlock daemon start");
//            context.startService(new Intent(context, WordLockDaemon.class));
//        }
//    }
//
//    public static final void notifyHasWord(Context context, boolean z) {
//        if (context != null) {
//            Intent intent = new Intent(context, WordLockDaemon.class);
//            intent.putExtra(EXTRA_HAS_WORD, z);
//            context.startService(intent);
//        }
//    }
//
//    public static final void stop(Context context) {
//        if (context != null) {
//            Intent intent = new Intent(context, WordLockDaemon.class);
//            intent.setAction(ACTION_FORCE_STOP);
//            context.startService(intent);
//        }
//    }
//
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    public void onCreate() {
//        super.onCreate();
//        this.mMonitorPid = AppMonitor.createAppMonitor(this, WordLockDaemon.class);
//        this.mWordClientUsable = new WordClientUsable(this, this);
//        this.mWordClientUsable.start();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.setPriority(1000);
//        intentFilter.addAction("android.intent.action.SCREEN_ON");
//        intentFilter.addAction("android.intent.action.SCREEN_OFF");
//        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
//        registerReceiver(this.mScreenOnOffReceiver, intentFilter);
//    }
//
//    /* access modifiers changed from: private */
//    public void wakeClient(boolean z) {
//        if (this.mWordClientDisabled) {
//            this.mWordClientDisabled = false;
//        } else if (Settings.isWordLockscreenEnabled()) {
//            Log.d("whiz", "has word? " + Settings.doesWordlockHasWord_daemon());
//            if (!Settings.doesWordlockHasWord_daemon()) {
//                WordLockService.startForRefreshTopN(this, null);
//            } else if (!this.mWordClientUsable.isUsable()) {
//            } else {
//                if (z) {
//                    WordLockClient.wakeAsScreenOff(WordLockAppHandler.getApp());
//                } else {
//                    WordLockClient.wakeAsScreenOn(WordLockAppHandler.getApp());
//                }
//            }
//        }
//    }
//
//    public int onStartCommand(Intent intent, int i, int i2) {
//        if (intent != null) {
//            if (ACTION_FORCE_STOP.equals(intent.getAction())) {
//                if (this.mMonitorPid > 0 && AppMonitor.isMonitorValid()) {
//                    AppMonitor.killChild(this.mMonitorPid);
//                }
//                this.mForceStop = true;
//                stopSelf();
//            } else if (intent.hasExtra(EXTRA_HAS_WORD)) {
//                Settings.setWordlockHasWord_daemon(intent.getBooleanExtra(EXTRA_HAS_WORD, true));
//            }
//        }
//        return 1;
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        enableKeyguard();
//        unregisterReceiver(this.mScreenOnOffReceiver);
//        this.mWordClientUsable.stop();
//        if (!this.mForceStop) {
//            start(this);
//        }
//    }
//
//    private void disableKeyguard() {
//        if (this.mKM == null) {
//            this.mKM = (KeyguardManager) getSystemService("keyguard");
//        }
//        if (this.mKL != null) {
//            this.mKL.reenableKeyguard();
//            this.mKL = null;
//        }
//        this.mKL = this.mKM.newKeyguardLock(getClass().toString());
//        this.mKL.disableKeyguard();
//    }
//
//    private void enableKeyguard() {
//        if (this.mKL != null) {
//            this.mKL.reenableKeyguard();
//            this.mKL = null;
//        }
//    }
//
//    public void onWordClientDisabled() {
//        this.mWordClientDisabled = true;
//    }
//}
