//package com.baicizhan.main.selftest.activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//import android.widget.CompoundButton.OnCheckedChangeListener;
//import android.widget.Toast;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.DeviceUtil;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.audio.AudioPlayer.OnPlaySateListener;
//import com.baicizhan.client.framework.audio.AudioPlayer.State;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.main.resource.ProblemAsset;
//import com.baicizhan.main.resource.TopicResourceManager;
//import com.baicizhan.main.selftest.strategy.SelfTestStrategy.Result;
//import com.baicizhan.main.selftest.strategy.SelfTestStrategyProxy;
//import com.baicizhan.main.selftest.strategy.SelfTestStrategyProxy.OnSelfTestDataListener;
//import com.baicizhan.main.selftest.util.DeviceTurnSensor;
//import com.baicizhan.main.selftest.util.DeviceTurnSensor.OnDirectionChangeListener;
//import com.baicizhan.main.selftest.util.WalkListenSettings;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.Collection;
//
//public class WalkListenEnter extends Activity implements OnPlaySateListener, OnDirectionChangeListener {
//    private static final int MAX_PRELOAD_COUNT = 3;
//    /* access modifiers changed from: private */
//    public Handler mHandler = new Handler();
//    AuthCallback<ProblemAsset> mObserver = new AuthCallback<ProblemAsset>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(ProblemAsset problemAsset) {
//            Log.d("CommonPreloadActivity", "onSuccess " + problemAsset);
//            WalkListenEnter.this.checkPrepared();
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//            WalkListenEnter.this.mHandler.postDelayed(new Runnable() {
//                public void run() {
//                    Toast.makeText(WalkListenEnter.this, R.string.download_res_fail, 0).show();
//                    WalkListenEnter.this.finish();
//                }
//            }, 300);
//        }
//
//        /* access modifiers changed from: protected */
//        public void onProgress(Object obj) {
//        }
//    };
//    private AudioPlayer mPlayer;
//    private boolean mPlayingZHW = false;
//    private int mPreloadCount;
//    private boolean mPreloading = true;
//    private BczLoadingDialog mProgressDialog;
//    /* access modifiers changed from: private */
//    public SelfTestStrategyProxy mSelfTestStrategy;
//    private SelfTestStrategyCallback mSelfTestStrategyCallback;
//    private TopicResourceManager mTopicResourceManager;
//    private DeviceTurnSensor mTurnSensor;
//
//    class SelfTestStrategyCallback implements OnSelfTestDataListener {
//        final WeakReference<WalkListenEnter> mEnter;
//
//        SelfTestStrategyCallback(WalkListenEnter walkListenEnter) {
//            this.mEnter = new WeakReference<>(walkListenEnter);
//        }
//
//        public void onContinueHistory(Result result) {
//            WalkListenEnter walkListenEnter = (WalkListenEnter) this.mEnter.get();
//            if (walkListenEnter != null) {
//                if (result == null || result.ids == null || result.ids.isEmpty()) {
//                    Toast.makeText(walkListenEnter, R.string.selftest_no_word, 0).show();
//                    walkListenEnter.finish();
//                    return;
//                }
//                walkListenEnter.goPreload(result.ids);
//                SelfTestStrategyProxy.CACHE_INIT_RESULT = result;
//            }
//        }
//
//        public void onExit() {
//            WalkListenEnter walkListenEnter = (WalkListenEnter) this.mEnter.get();
//            if (walkListenEnter != null) {
//                walkListenEnter.finish();
//            }
//        }
//
//        public void onSelfTestInit(Result result) {
//            WalkListenEnter walkListenEnter = (WalkListenEnter) this.mEnter.get();
//            if (walkListenEnter != null) {
//                if (result == null) {
//                    Toast.makeText(walkListenEnter, R.string.selftest_no_word, 0).show();
//                    walkListenEnter.finish();
//                } else if (result.ids == null || result.ids.isEmpty()) {
//                    walkListenEnter.mSelfTestStrategy.askResetAll(walkListenEnter, null);
//                } else if (result.today || !result.hasToday) {
//                    walkListenEnter.goPreload(result.ids);
//                    SelfTestStrategyProxy.CACHE_INIT_RESULT = result;
//                } else {
//                    walkListenEnter.mSelfTestStrategy.askResetToday(walkListenEnter, null);
//                }
//            }
//        }
//
//        public void onSelfTestReset(Result result) {
//            WalkListenEnter walkListenEnter = (WalkListenEnter) this.mEnter.get();
//            if (walkListenEnter != null) {
//                if (result == null || result.ids == null || result.ids.isEmpty()) {
//                    Toast.makeText(walkListenEnter, R.string.selftest_no_word, 0).show();
//                    walkListenEnter.finish();
//                    return;
//                }
//                walkListenEnter.goPreload(result.ids);
//                SelfTestStrategyProxy.CACHE_INIT_RESULT = result;
//            }
//        }
//    }
//
//    public static void start(Context context) {
//        context.startActivity(new Intent(context, WalkListenEnter.class));
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        setContentView(R.layout.walklisten_entrance);
//        initViews();
//        this.mPlayer = new AudioPlayer(this);
//        this.mPlayer.setOnPlaySateListener(this);
//        if (WalkListenSettings.isFirstWalkListen()) {
//            this.mPlayer.newPlayRaw(R.raw.walklisten_first);
//            WalkListenSettings.setFirstWalkListen(false);
//        }
//        this.mTurnSensor = DeviceTurnSensor.createInstance(this, this);
//        this.mTurnSensor.setEnabled(true);
//        initPreload();
//    }
//
//    private void initViews() {
//        CheckBox checkBox = (CheckBox) findViewById(R.id.walklisten_check_play_zhanhuwei);
//        ThemeResUtil.setCheckPlayButton(this, checkBox);
//        if (!DeviceUtil.IS_MI_2S) {
//            checkBox.setPadding(Common.dip2px(this, 10.0f), 0, 0, 0);
//        }
//        checkBox.setChecked(WalkListenSettings.isPlayZhanhuwei());
//        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
//                WalkListenSettings.setPlayZhanhuwei(z);
//            }
//        });
//        findViewById(R.id.walklisten_home).setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                WalkListenEnter.this.finish();
//            }
//        });
//    }
//
//    private void initPreload() {
//        this.mProgressDialog = new BczLoadingDialog(this);
//        this.mProgressDialog.setCancelable(false);
//        this.mProgressDialog.setMessage((int) R.string.loading_data);
//        this.mProgressDialog.show();
//        this.mTopicResourceManager = TopicResourceManager.getInstance();
//        this.mTopicResourceManager.getTopicWaitingHall().clearup();
//        this.mTopicResourceManager.getTopicWaitingHall().setObserver(this.mObserver);
//        this.mPreloading = true;
//        this.mSelfTestStrategyCallback = new SelfTestStrategyCallback(this);
//        this.mSelfTestStrategy = new SelfTestStrategyProxy(this, this.mSelfTestStrategyCallback);
//        this.mSelfTestStrategy.init();
//    }
//
//    /* access modifiers changed from: private */
//    public void goPreload(Collection<Integer> collection) {
//        this.mPreloadCount = collection == null ? 0 : Math.min(3, collection.size());
//        this.mTopicResourceManager.loadNextProblems(this, SelfTestStrategyProxy.getWordIds(new ArrayList(collection), 3), true);
//    }
//
//    /* access modifiers changed from: private */
//    public void checkPrepared() {
//        Log.d("CommonPreloadActivity", "ready count " + this.mTopicResourceManager.getTopicWaitingHall().getReadyWaiterCount());
//        if (this.mTopicResourceManager.getTopicWaitingHall().getReadyWaiterCount() >= this.mPreloadCount) {
//            if (this.mProgressDialog != null) {
//                this.mProgressDialog.cancel();
//            }
//            this.mPreloading = false;
//            if (!isFinishing()) {
//                this.mTopicResourceManager.getTopicWaitingHall().setObserver(null);
//                startWalkListen();
//            }
//        }
//    }
//
//    public void onResume() {
//        super.onResume();
//        UMStats.traceOnActivityResume(this);
//    }
//
//    public void onPause() {
//        super.onPause();
//        UMStats.traceOnActivityPause(this);
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        this.mPlayer.destroy();
//        this.mTurnSensor.setEnabled(false);
//    }
//
//    public void onPlayStateChanged(State state) {
//        if (this.mPlayingZHW && !isFinishing() && State.Completed == state) {
//            this.mPlayingZHW = false;
//            startWalkListen();
//        }
//    }
//
//    public void onDirectionChanged(int i) {
//        if (!isFinishing()) {
//            if (!WalkListenSettings.isPlayZhanhuwei()) {
//                if (1 == i) {
//                    startWalkListen();
//                }
//            } else if (1 == i && !this.mPlayingZHW) {
//                this.mPlayer.stop();
//                this.mPlayer.newPlayRaw(R.raw.walklisten_zhanhuwei);
//                this.mPlayingZHW = true;
//            } else if (i == 0 && this.mPlayingZHW) {
//                this.mPlayer.stop();
//                this.mPlayingZHW = false;
//            }
//        }
//    }
//
//    private void startWalkListen() {
//        Log.d("whiz", "start walk listen, playing: " + this.mPlayingZHW + "; preloading? " + this.mPreloading + "; face down? " + (1 == this.mTurnSensor.getDirection()));
//        if (!this.mPlayingZHW && !this.mPreloading && 1 == this.mTurnSensor.getDirection()) {
//            WalkListenActivity.start(this);
//            finish();
//        }
//    }
//}
