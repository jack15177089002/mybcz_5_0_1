//package com.baicizhan.main.selftest.activity;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.support.p004v4.app.Fragment;
//import android.support.p004v4.app.FragmentActivity;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.AlphaAnimation;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.audio.AudioPlayer.OnPlayErrorListener;
//import com.baicizhan.client.framework.audio.AudioPlayer.OnPlaySateListener;
//import com.baicizhan.client.framework.audio.AudioPlayer.State;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.main.fragment.WikiFragment;
//import com.baicizhan.main.fragment.WikiFragment.WikiListener;
//import com.baicizhan.main.resource.ProblemAsset;
//import com.baicizhan.main.resource.TopicResourceManager;
//import com.baicizhan.main.selftest.strategy.SelfTestStrategy.Result;
//import com.baicizhan.main.selftest.strategy.SelfTestStrategyProxy;
//import com.baicizhan.main.selftest.strategy.SelfTestStrategyProxy.OnSelfTestDataListener;
//import com.baicizhan.main.selftest.util.DeviceTurnSensor;
//import com.baicizhan.main.selftest.util.DeviceTurnSensor.OnDirectionChangeListener;
//import com.baicizhan.main.utils.VividPlayManager;
//import com.jiongji.andriod.card.R;
//import com.p047d.p048a.C1548at;
//import com.p047d.p048a.ObjectAnimator;
//import com.p047d.p048a.ValueAnimator;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WalkListenActivity extends FragmentActivity implements OnClickListener, OnPlayErrorListener, OnPlaySateListener, WikiListener, OnDirectionChangeListener {
//    private static final int MAX_PRELOAD_COUNT = 25;
//    private static final int MSG_TRY_NEXT_PROBLEM = 0;
//    private static final int PRELOAD_THRESHOLD = 3;
//    private ProblemAsset mCurrentProblem;
//    /* access modifiers changed from: private */
//    public BczDialog mDownFailedDialog;
//    private boolean mFromUp = true;
//    private WalkListenHandler mHandler;
//    private boolean mIniting = false;
//    private ProblemAsset mLastProblem;
//    private TextView mLastTopic;
//    private View mMask;
//    AuthCallback<ProblemAsset> mObserver = new AuthCallback<ProblemAsset>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(ProblemAsset problemAsset) {
//            if (WalkListenActivity.this.isLoading() && problemAsset.getId() == WalkListenActivity.this.mWaitingTopicId) {
//                WalkListenActivity.this.exitLoading();
//                WalkListenActivity.this.tryNextProblem();
//            }
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//            if (!WalkListenActivity.this.isFinishing() && !WalkListenActivity.this.mDownFailedDialog.isShow()) {
//                WalkListenActivity.this.mDownFailedDialog.show();
//            }
//        }
//
//        /* access modifiers changed from: protected */
//        public void onProgress(Object obj) {
//            if (WalkListenActivity.this.mProgressLayout.getVisibility() == 0) {
//                ProblemAsset problemAsset = (ProblemAsset) obj;
//                if (problemAsset.getId() == WalkListenActivity.this.mWaitingTopicId) {
//                    WalkListenActivity.this.mProgress.setProgress(problemAsset.getProgress());
//                }
//            }
//        }
//    };
//    private VividPlayManager mPM;
//    private int mPassIndex;
//    private View mPlayFrame;
//    private ImageView mPlayView;
//    /* access modifiers changed from: private */
//    public AudioPlayer mPlayer;
//    private boolean mPlaying = false;
//    private boolean mPlayingToFinish = false;
//    private int mPreloadCount = 3;
//    /* access modifiers changed from: private */
//    public ProgressBar mProgress;
//    private BczLoadingDialog mProgressDialog;
//    /* access modifiers changed from: private */
//    public View mProgressLayout;
//    private Result mResult;
//    /* access modifiers changed from: private */
//    public SelfTestStrategyProxy mSelfTestStrategy;
//    private SelfTestStrategyCallback mSelfTestStrategyCallback;
//    private List<Integer> mTestedIds = new ArrayList();
//    private TopicResourceManager mTopicResourceManager;
//    /* access modifiers changed from: private */
//    public DeviceTurnSensor mTurnSensor;
//    private TextView mWaitingPass;
//    /* access modifiers changed from: private */
//    public int mWaitingTopicId;
//    /* access modifiers changed from: private */
//    public View mWikiContainer;
//    private WikiFragment mWikiFragment;
//    /* access modifiers changed from: private */
//    public TextView mWord;
//
//    class SelfTestStrategyCallback implements OnSelfTestDataListener {
//        final WeakReference<WalkListenActivity> mActivity;
//
//        SelfTestStrategyCallback(WalkListenActivity walkListenActivity) {
//            this.mActivity = new WeakReference<>(walkListenActivity);
//        }
//
//        public void onContinueHistory(Result result) {
//            WalkListenActivity walkListenActivity = (WalkListenActivity) this.mActivity.get();
//            if (walkListenActivity != null) {
//                if (result == null || result.ids == null || result.ids.isEmpty()) {
//                    Toast.makeText(walkListenActivity, R.string.selftest_no_word, 0).show();
//                    walkListenActivity.finish();
//                    return;
//                }
//                walkListenActivity.initPreload(result);
//                walkListenActivity.tryNextProblem();
//            }
//        }
//
//        public void onExit() {
//            WalkListenActivity walkListenActivity = (WalkListenActivity) this.mActivity.get();
//            if (walkListenActivity != null) {
//                walkListenActivity.dismissLoading();
//                walkListenActivity.finish();
//            }
//        }
//
//        public void onSelfTestInit(Result result) {
//            WalkListenActivity walkListenActivity = (WalkListenActivity) this.mActivity.get();
//            if (walkListenActivity != null) {
//                if (result == null) {
//                    Toast.makeText(walkListenActivity, R.string.selftest_no_word, 0).show();
//                    walkListenActivity.finish();
//                } else if (result.ids == null || result.ids.isEmpty()) {
//                    walkListenActivity.mSelfTestStrategy.askResetAll(walkListenActivity, null);
//                } else if (result.today || !result.hasToday) {
//                    walkListenActivity.initPreload(result);
//                } else {
//                    walkListenActivity.mSelfTestStrategy.askResetToday(walkListenActivity, null);
//                }
//            }
//        }
//
//        public void onSelfTestReset(Result result) {
//            WalkListenActivity walkListenActivity = (WalkListenActivity) this.mActivity.get();
//            if (walkListenActivity != null) {
//                if (result == null || result.ids == null || result.ids.isEmpty()) {
//                    Toast.makeText(walkListenActivity, R.string.selftest_no_word, 0).show();
//                    walkListenActivity.finish();
//                    return;
//                }
//                walkListenActivity.initPreload(result);
//                walkListenActivity.tryNextProblem();
//            }
//        }
//    }
//
//    class WalkListenHandler extends Handler {
//        final WeakReference<WalkListenActivity> mActivity;
//
//        WalkListenHandler(WalkListenActivity walkListenActivity) {
//            this.mActivity = new WeakReference<>(walkListenActivity);
//        }
//
//        public void handleMessage(Message message) {
//            WalkListenActivity walkListenActivity = (WalkListenActivity) this.mActivity.get();
//            if (walkListenActivity != null) {
//                switch (message.what) {
//                    case 0:
//                        if (1 == WalkListenActivity.this.mTurnSensor.getDirection()) {
//                            walkListenActivity.tryNextProblem();
//                            return;
//                        }
//                        return;
//                    default:
//                        return;
//                }
//            }
//        }
//    }
//
//    public static void start(Context context) {
//        context.startActivity(new Intent(context, WalkListenActivity.class));
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        setContentView(R.layout.walklisten_play);
//        this.mHandler = new WalkListenHandler(this);
//        initViews();
//        this.mTurnSensor = DeviceTurnSensor.createInstance(this, this);
//        this.mProgressDialog = new BczLoadingDialog(this);
//        this.mProgressDialog.setCancelable(false);
//        this.mProgressDialog.setMessage((int) R.string.loading_data);
//        this.mSelfTestStrategyCallback = new SelfTestStrategyCallback(this);
//        this.mSelfTestStrategy = new SelfTestStrategyProxy(this, this.mSelfTestStrategyCallback);
//        Result result = SelfTestStrategyProxy.CACHE_INIT_RESULT;
//        if (result == null || result.ids == null || result.ids.isEmpty()) {
//            showLoading();
//            this.mIniting = true;
//            this.mSelfTestStrategy.init();
//        } else {
//            initPreload(result);
//        }
//        this.mPlayer = new AudioPlayer(this);
//        this.mTopicResourceManager = TopicResourceManager.getInstance();
//        this.mTopicResourceManager.getTopicWaitingHall().setObserver(this.mObserver);
//        this.mDownFailedDialog = new Builder(this).setMessage((int) R.string.download_res_fail).setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                WalkListenActivity.this.finish();
//            }
//        }).create();
//        this.mDownFailedDialog.setCancelable(false);
//    }
//
//    /* access modifiers changed from: private */
//    public void initPreload(Result result) {
//        this.mIniting = false;
//        this.mPreloadCount = Math.min(result.ids.size(), 3);
//        this.mPassIndex = 0;
//        this.mResult = result;
//        this.mTestedIds.clear();
//        this.mTurnSensor.setEnabled(true);
//        dismissLoading();
//    }
//
//    private void initViews() {
//        findViewById(R.id.walklisten_home).setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                WalkListenActivity.this.finish();
//            }
//        });
//        this.mWaitingPass = (TextView) findViewById(R.id.walklisten_waitting_pass);
//        this.mLastTopic = (TextView) findViewById(R.id.walklisten_last_topic);
//        this.mLastTopic.setOnClickListener(this);
//        this.mWord = (TextView) findViewById(R.id.walklisten_word);
//        this.mPlayFrame = findViewById(R.id.walklisten_sound_frame);
//        this.mPlayView = (ImageView) this.mPlayFrame.findViewById(R.id.walklisten_sound);
//        ThemeResUtil.setSoundBg(this, this.mPlayView);
//        this.mWikiContainer = findViewById(R.id.walklisten_wiki_container);
//        this.mProgressLayout = findViewById(R.id.walklisten_progress_layout);
//        this.mProgressLayout.setOnClickListener(this);
//        this.mProgress = (ProgressBar) findViewById(R.id.walklisten_progress);
//        this.mMask = findViewById(R.id.walklisten_mask);
//        this.mMask.setVisibility(8);
//        this.mMask.setOnClickListener(this);
//    }
//
//    private void showLoading() {
//        if (this.mProgressDialog != null) {
//            this.mProgressDialog.show();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void dismissLoading() {
//        if (this.mProgressDialog != null) {
//            this.mProgressDialog.dismiss();
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
//        if (!this.mIniting) {
//            this.mResult = this.mSelfTestStrategy.save(new ArrayList(this.mTestedIds));
//            this.mPassIndex = 0;
//            this.mTestedIds.clear();
//        }
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        this.mTurnSensor.setEnabled(false);
//        this.mPlayer.destroy();
//        this.mHandler.removeMessages(0);
//        SelfTestStrategyProxy.CACHE_INIT_RESULT = null;
//    }
//
//    public void onClick(View view) {
//        if (view == this.mLastTopic && this.mLastProblem != null) {
//            this.mWikiContainer.setVisibility(0);
//            this.mWikiFragment = WikiFragment.getInstance(this.mLastProblem.getPrimary(), 7);
//            showWiki();
//        }
//    }
//
//    public boolean onKeyDown(int i, KeyEvent keyEvent) {
//        if (4 != i || !tryHideWiki()) {
//            return super.onKeyDown(i, keyEvent);
//        }
//        return false;
//    }
//
//    private boolean tryShowWiki() {
//        if (wikiShowed()) {
//            return true;
//        }
//        if (this.mCurrentProblem == null) {
//            return false;
//        }
//        this.mWikiContainer.setVisibility(0);
//        this.mWikiFragment = WikiFragment.getInstance(this.mCurrentProblem.getPrimary(), 7);
//        showWiki();
//        return true;
//    }
//
//    private void showWiki() {
//        this.mWikiFragment.setWikiListener(this);
//        getSupportFragmentManager().mo313a().mo178a((int) R.anim.business_push_down_in, (int) R.anim.business_push_down_out).mo179a((int) R.id.walklisten_wiki_container, (Fragment) this.mWikiFragment).mo186c();
//    }
//
//    private boolean tryHideWiki() {
//        if (!wikiShowed()) {
//            return false;
//        }
//        getSupportFragmentManager().mo313a().mo178a((int) R.anim.business_push_down_in, (int) R.anim.business_push_down_out).mo181a(this.mWikiFragment).mo186c();
//        this.mWikiContainer.postDelayed(new Runnable() {
//            public void run() {
//                WalkListenActivity.this.mWikiContainer.setVisibility(8);
//            }
//        }, 300);
//        return true;
//    }
//
//    private boolean wikiShowed() {
//        return this.mWikiContainer.getVisibility() == 0 && this.mWikiFragment != null && !this.mWikiFragment.isDetached();
//    }
//
//    private void checkPreload() {
//        Log.d("whiz", "!!! total waiter count: " + this.mTopicResourceManager.getTopicWaitingHall().getTotalWaiterCount());
//        if (this.mTopicResourceManager.getTopicWaitingHall().getTotalWaiterCount() <= this.mPreloadCount) {
//            int totalWaiterCount = this.mPassIndex + this.mTopicResourceManager.getTopicWaitingHall().getTotalWaiterCount();
//            Log.d("whiz", "!!! load count is: " + totalWaiterCount);
//            List wordIds = SelfTestStrategyProxy.getWordIds(this.mResult.ids, totalWaiterCount, 25);
//            if (wordIds != null && !wordIds.isEmpty()) {
//                this.mTopicResourceManager.loadNextProblems(this, wordIds, true);
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void tryNextProblem() {
//        if (isComplete()) {
//            onFinishToday();
//            return;
//        }
//        tryHideWiki();
//        checkPreload();
//        this.mLastProblem = this.mCurrentProblem;
//        this.mCurrentProblem = this.mTopicResourceManager.getTopicWaitingHall().tryCheckOut(((Integer) this.mResult.ids.get(this.mPassIndex)).intValue());
//        Log.d("whiz", "!!! current problem is: " + this.mCurrentProblem);
//        if (this.mCurrentProblem == null) {
//            this.mWaitingTopicId = ((Integer) this.mResult.ids.get(this.mPassIndex)).intValue();
//            enterLoading();
//            return;
//        }
//        exitLoading();
//        nextProblem();
//    }
//
//    private void nextProblem() {
//        this.mPassIndex++;
//        this.mWaitingPass.setText(getString(R.string.walklisten_waiting_pass, new Object[]{Integer.valueOf(this.mResult.ids.size() - this.mPassIndex)}));
//        TopicRecord primary = this.mCurrentProblem.getPrimary();
//        this.mTestedIds.add(Integer.valueOf(primary.topicId));
//        final String str = primary.word;
//        ObjectAnimator a = ObjectAnimator.m3360a(this.mWord, "alpha", 1.0f, 0.0f, 1.0f).mo16215a(800);
//        a.mo16184a((C1548at) new C1548at() {
//            boolean updated = false;
//
//            public void onAnimationUpdate(ValueAnimator amVar) {
//                if (amVar.f3476d >= 0.5f && !this.updated) {
//                    WalkListenActivity.this.mWord.setText(str);
//                    this.updated = true;
//                }
//            }
//        });
//        a.mo16161a();
//        playTopicAudio(primary);
//        this.mPM = new VividPlayManager(this.mPlayer, primary, primary.wordAudio, this.mPlayFrame, this.mPlayView);
//        if (this.mLastProblem != null) {
//            TopicRecord primary2 = this.mLastProblem.getPrimary();
//            this.mLastTopic.setText(primary2.word + " " + primary2.wordMean);
//        }
//    }
//
//    private void playTopicAudio(final TopicRecord topicRecord) {
//        this.mPlayer.setOnPlaySateListener(new OnPlaySateListener() {
//            public void onPlayStateChanged(State state) {
//                if (state == State.Completed) {
//                    WalkListenActivity.this.mPlayer.setOnPlaySateListener(WalkListenActivity.this);
//                    WalkListenActivity.this.mPlayer.setOnPlayErrorListener(WalkListenActivity.this);
//                    ZPackUtils.loadAudioCompat(WalkListenActivity.this.mPlayer, topicRecord, topicRecord.sentenceAudio);
//                }
//            }
//        });
//        this.mPlayer.setOnPlayErrorListener(new OnPlayErrorListener() {
//            public void onPlayError(int i, int i2) {
//                C0789L.log.error("walklisten play word error, what[{}], extra[{}], audio[{}]", Integer.valueOf(i), Integer.valueOf(i2), topicRecord.wordAudio);
//                WalkListenActivity.this.mPlayer.setOnPlaySateListener(WalkListenActivity.this);
//                WalkListenActivity.this.mPlayer.setOnPlayErrorListener(WalkListenActivity.this);
//                ZPackUtils.loadAudioCompat(WalkListenActivity.this.mPlayer, topicRecord, topicRecord.sentenceAudio);
//            }
//        });
//        this.mPlaying = ZPackUtils.loadAudioCompat(this.mPlayer, topicRecord, topicRecord.wordAudio);
//    }
//
//    private void onFinishToday() {
//        this.mPlayingToFinish = true;
//        this.mPlayer.newPlayRaw(R.raw.walklisten_end);
//    }
//
//    private boolean isComplete() {
//        return this.mPassIndex >= this.mResult.ids.size();
//    }
//
//    /* access modifiers changed from: private */
//    public boolean isLoading() {
//        return this.mProgressLayout.getVisibility() == 0;
//    }
//
//    private void enterLoading() {
//        this.mProgressLayout.setVisibility(0);
//    }
//
//    /* access modifiers changed from: private */
//    public void exitLoading() {
//        this.mProgressLayout.setVisibility(8);
//    }
//
//    private void switchMask(boolean z) {
//        if (z && 8 == this.mMask.getVisibility()) {
//            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
//            alphaAnimation.setDuration(300);
//            this.mMask.startAnimation(alphaAnimation);
//            this.mMask.setVisibility(0);
//        } else if (!z && this.mMask.getVisibility() == 0) {
//            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
//            alphaAnimation2.setDuration(300);
//            this.mMask.startAnimation(alphaAnimation2);
//            this.mMask.setVisibility(8);
//        }
//    }
//
//    public void onDirectionChanged(int i) {
//        if (!isFinishing()) {
//            if (1 == i) {
//                Log.d("whiz", "walk listen direction down, playing: " + this.mPlaying + "; from up: " + this.mFromUp);
//                if (!this.mPlaying && this.mFromUp && !this.mIniting) {
//                    tryNextProblem();
//                }
//                this.mFromUp = false;
//                switchMask(true);
//            } else if (i == 0) {
//                switchMask(false);
//                this.mFromUp = true;
//                tryShowWiki();
//            }
//        }
//    }
//
//    public void onPlayStateChanged(State state) {
//        if (State.Completed == state) {
//            processPlayComplete();
//        }
//    }
//
//    public void onPlayError(int i, int i2) {
//        C0789L.log.error("walklisten play sentence error, what[{}], extra[{}], record[{}]", Integer.valueOf(i), Integer.valueOf(i2), this.mLastProblem.getPrimary());
//        processPlayComplete();
//    }
//
//    private void processPlayComplete() {
//        this.mPlaying = false;
//        if (this.mPlayingToFinish) {
//            this.mPlayingToFinish = false;
//            this.mTurnSensor.setEnabled(false);
//            this.mIniting = true;
//            showLoading();
//            if (!this.mResult.today || !this.mResult.hasToday) {
//                this.mSelfTestStrategy.askResetAll(this, this.mTestedIds);
//            } else {
//                this.mSelfTestStrategy.askResetToday(this, this.mTestedIds);
//            }
//        } else if (1 == this.mTurnSensor.getDirection()) {
//            sendTryNextProblem();
//        }
//    }
//
//    public void onWikiExit() {
//        tryHideWiki();
//    }
//
//    private void sendTryNextProblem() {
//        this.mHandler.sendEmptyMessageDelayed(0, 1500);
//    }
//}
