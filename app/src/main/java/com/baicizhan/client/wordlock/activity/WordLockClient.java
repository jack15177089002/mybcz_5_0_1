//package com.baicizhan.client.wordlock.activity;
//
//import android.annotation.TargetApi;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Build.VERSION;
//import android.os.Bundle;
////import android.support.p004v4.app.FragmentActivity;
//import android.util.Log;
//import android.view.KeyEvent;
//
//import androidx.fragment.app.FragmentActivity;
//
//import com.baicizhan.client.framework.util.Common;
////import com.baicizhan.client.wordlock.R;
//import com.baicizhan.client.wordlock.WordLockApp;
//import com.baicizhan.client.wordlock.WordLockAppHandler;
//import com.baicizhan.client.wordlock.data.WordLockDataCollector;
//import com.baicizhan.client.wordlock.data.p033db.WordLockHelper;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.RefreshKilledWordCountEvent;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.RefreshTopNEvent;
//import com.baicizhan.client.wordlock.fragment.NavigationManager;
//import com.baicizhan.client.wordlock.fragment.WordLockFragment.OnWordLockListener;
//import com.baicizhan.client.wordlock.setting.Settings;
//import com.baicizhan.client.wordlock.stat.OperationUtil;
//import com.baicizhan.client.wordlock.stat.UseStat;
//import com.baicizhan.client.wordlock.util.Utils;
//import com.baicizhan.client.wordlock.util.WordClientUsable;
//import com.baicizhan.client.wordlock.util.WordClientUsable.Callback;
//import com.baicizhan.client.wordlock.view.LockShell;
//import com.baicizhan.client.wordlock.view.LockShell.OnShellChangeListener;
//import com.baicizhan.client.wordlock.view.WordCountStatView;
//import com.baicizhan.client.wordlock.view.drag.DragObservers;
//import com.jiongji.andriod.card.R;
////import p000a.p001a.p002a.EventBus;
//
//public class WordLockClient extends FragmentActivity implements OnWordLockListener, Callback, OnShellChangeListener {
//    private static final String EXTRA_SCREEN_OFF = "screen_off";
//    public static final String TAG = WordLockClient.class.getSimpleName();
//    private DragObservers mDragObservers = new DragObservers();
//    private LockShell mLockShell;
//    private boolean mScreenOff = false;
//    private boolean mWillRefreshWhenStop = true;
//    private WordClientUsable mWordClientUsable;
//    private WordCountStatView mWordCountStat;
//
//    public DragObservers getDragObservers() {
//        return this.mDragObservers;
//    }
//
//    public static void wakeAsScreenOn(Context context) {
//        if (context != null) {
//            Intent intent = new Intent(context, WordLockClient.class);
////            intent.addFlags(269484032);
//            intent.putExtra(EXTRA_SCREEN_OFF, false);
//            context.startActivity(intent);
//        }
//    }
//
//    public static void wakeAsScreenOff(Context context) {
//        if (context != null) {
//            Intent intent = new Intent(context, WordLockClient.class);
////            intent.addFlags(269484032);
//            intent.putExtra(EXTRA_SCREEN_OFF, true);
//            context.startActivity(intent);
//        }
//    }
//
//    @TargetApi(11)
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (VERSION.SDK_INT > 11) {
//            getWindow().setFlags(16777216, 16777216);
//        }
//        this.mWordClientUsable = new WordClientUsable(this, this);
//        if (!this.mWordClientUsable.isUsable()) {
//            finish();
//            return;
//        }
//        this.mWordClientUsable.start();
//        overridePendingTransition(0, 0);
//        getWindow().setType(2004);
//        getWindow().addFlags(4718592);
//        if (Utils.shouldFullScreen()) {
//            getWindow().addFlags(1024);
//        }
//        setContentView(R.layout.wordlock_client_layout);
//        this.mLockShell = (LockShell) findViewById(R.id.wordlock_shell);
//        this.mLockShell.init(this, this);
//        this.mWordCountStat = (WordCountStatView) findViewById(R.id.wordlock_word_count_stat);
//        this.mWillRefreshWhenStop = false;
////        EventBus.m0a().mo5a((Object) this);
//        setVolumeControlStream(3);
//    }
//
//    public void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        Log.d("whiz", "on new intent");
//        if (!Settings.doesWordlockHasWord()) {
//            finish();
//            return;
//        }
//        this.mScreenOff = intent.getBooleanExtra(EXTRA_SCREEN_OFF, false);
//        if (this.mScreenOff) {
////            EventBus.m0a().mo9c((Object) new RefreshTopNEvent());
//        } else if (this.mLockShell != null) {
//            this.mLockShell.setCurrentItem(0);
//            this.mLockShell.resetWordLine(true, true);
//        }
//    }
//
//    public void onRestart() {
//        super.onRestart();
//        Log.d("whiz", "on restart");
//    }
//
//    public void onStart() {
//        super.onStart();
//        Log.d("whiz", "on start");
//        if (!Settings.doesWordlockHasWord()) {
//            finish();
//            return;
//        }
//        if (this.mLockShell != null) {
//            this.mLockShell.setCurrentItem(0);
//            this.mLockShell.resetWordLine(true, false);
//        }
//        if (Common.isScreenOn(this)) {
//            OperationUtil.getInstance().accumRevdCount();
//        }
//    }
//
//    public void onResume() {
//        super.onResume();
////        EventBus.m0a().mo9c((Object) new RefreshKilledWordCountEvent());
//        Log.d("whiz", "on resume");
//    }
//
//    public void onPause() {
//        super.onPause();
//        Log.d("whiz", "on pause");
//        NavigationManager.reset();
//        if (!Settings.doesWordlockHasWord()) {
//            finish();
//        }
//    }
//
//    public void onStop() {
//        super.onStop();
//        Log.d("whiz", "on stop");
//        if (this.mWillRefreshWhenStop) {
////            EventBus.m0a().mo9c((Object) new RefreshTopNEvent());
//        } else {
//            this.mWillRefreshWhenStop = true;
//        }
//        OperationUtil.getInstance().notifyCloseLock(this);
//        UseStat.born().stat();
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        this.mWordClientUsable.stop();
////        EventBus.m0a().mo8b((Object) this);
//        if (WordLockApp.killOnDestroy()) {
//            System.exit(0);
//        }
//    }
//
//    public void finish() {
//        super.finish();
//        overridePendingTransition(0, 0);
//        System.gc();
//    }
//
//    public void onUserLeaveHint() {
//        finish();
//    }
//
//    public void onWordClientDisabled() {
//        Log.d("whiz", "on word client disabled.");
//        finish();
//    }
//
//    public boolean onKeyDown(int i, KeyEvent keyEvent) {
//        if (4 != i) {
//            return super.onKeyDown(i, keyEvent);
//        }
////        EventBus.m0a().mo9c((Object) keyEvent);
//        return false;
//    }
//
//    public void onShellUncovered() {
//        finish();
//    }
//
//    public void onGuideUnlock() {
//    }
//
//    public void onWordLockFreeze(boolean z) {
//        if (this.mLockShell != null) {
//            this.mLockShell.setActivate(!z);
//        }
//    }
//
//    public void shrinkWordCount(float f, long j) {
//        if (!Settings.isLockScreenFirstSet()) {
//            this.mWordCountStat.shrinkWordCount(f, j);
//        }
//    }
//
//    public void setWillRefreshWhenStop(boolean z) {
//        this.mWillRefreshWhenStop = z;
//    }
//
//    public void onEventBackgroundThread(RefreshKilledWordCountEvent refreshKilledWordCountEvent) {
//        int deltaCount = refreshKilledWordCountEvent.getDeltaCount();
//        if (deltaCount < 0) {
//            int killedWordCount = WordLockHelper.getKilledWordCount(WordLockAppHandler.getApp());
//            Log.d(TAG, "killedCount:" + killedWordCount);
//            WordLockDataCollector.getInstance().setKilledWordCount(killedWordCount);
//            return;
//        }
//        WordLockDataCollector.getInstance().addKilledWordCount(deltaCount);
//    }
//}
