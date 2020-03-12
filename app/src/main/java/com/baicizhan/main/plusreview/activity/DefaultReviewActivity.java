//package com.baicizhan.main.plusreview.activity;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Rect;
//import android.graphics.drawable.ColorDrawable;
//import android.graphics.drawable.GradientDrawable;
//import android.media.SoundPool;
//import android.os.Bundle;
//import android.os.Handler;
//import androidx.fragment.app.FragmentManager;//import android.support.p004v4.app.C0066v;
//import android.support.p004v4.app.FragmentActivity;
//import android.support.p004v4.view.C0156bm;
//import android.support.p004v4.view.ViewCompat;
//import android.util.Log;
//import android.util.SparseArray;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationUtils;
//import android.view.animation.TranslateAnimation;
//import android.widget.FrameLayout;
//import android.widget.PopupWindow;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.helpers.BookRecordHelper;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.dataset.models.OfflineStateRecord;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.LearnRecordManager.Answer;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.StringUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.business.widget.SwipeViewPager;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.iface.LearningManager;
//import com.baicizhan.learning_strategy.util.Pair;
//import com.baicizhan.main.activity.DakaActivity;
//import com.baicizhan.main.adapter.WikiPagerAdapter;
//import com.baicizhan.main.adapter.WikiPagerAdapter.WikiEntry;
//import com.baicizhan.main.customview.PatternContainer;
//import com.baicizhan.main.customview.PatternContainer.Direction;
//import com.baicizhan.main.customview.PatternContainer.OnFlingListener;
//import com.baicizhan.main.fragment.PatternBaseFragment;
//import com.baicizhan.main.fragment.PatternBaseFragment.ExamplePatternListener;
//import com.baicizhan.main.fragment.PatternFactory;
//import com.baicizhan.main.fragment.WikiFragment.WikiListener;
//import com.baicizhan.main.plusreview.data.RecognitionCache;
//import com.baicizhan.main.plusreview.data.RecognitionData;
//import com.baicizhan.main.plusreview.data.load.RecognitionLoader;
//import com.baicizhan.main.plusreview.data.load.RecognitionLoader.RecognitionLoadListener;
//import com.baicizhan.main.plusreview.fragment.ReadFragment;
//import com.baicizhan.main.plusreview.fragment.WriteFragment;
//import com.baicizhan.main.plusreview.fragment.WriteFragment.OnControlListener;
//import com.baicizhan.main.popup.ComboPopupWindow;
//import com.baicizhan.main.resource.ProblemAsset;
//import com.baicizhan.main.resource.TopicResourceManager;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//
//public class DefaultReviewActivity extends FragmentActivity implements OnClickListener, ExamplePatternListener, WikiListener, OnControlListener {
//    private static final int COMBO_DURATION = 400;
//    private static final String EXTRA_TYPE = "type";
//    private static final long LOADING_TIMEOUT = 15000;
//    private static final int MAX_COMBO_COUNT = 999;
//    private static final int PRELOAD_BATCH_COUNT = 10;
//    private static final int PRELOAD_THRESHOLD = 7;
//    private static final String TAG = DefaultReviewActivity.class.getName();
//    private Animation animPushDownIn;
//    private Animation animPushLeftIn;
//    private Animation animPushUpOut;
//    private Animation animWikiPushRightOut;
//    /* access modifiers changed from: private */
//    public AudioPlayer mAudioPlayer;
//    private BoomRun mBoomRun;
//    /* access modifiers changed from: private */
//    public TextView mCancelLoading;
//    private Runnable mCancelLoadingRunnable = new Runnable() {
//        public void run() {
//            DefaultReviewActivity.this.mCancelLoading.setText("返回主界面");
//            DefaultReviewActivity.this.mCancelLoading.setEnabled(true);
//            Toast.makeText(DefaultReviewActivity.this, "客官，你的某些单词资源有缺失，需联网更新。\nTip：连接稳定的网络，即可自动更新", 1).show();
//        }
//    };
//    /* access modifiers changed from: private */
//    public TextView mComboCountTextView;
//    /* access modifiers changed from: private */
//    public ComboPopupWindow mComboPopupWindow;
//    private Answer mCurrentAnswer = Answer.CORRECT;
//    private int mCurrentComboCount;
//    private ProblemAsset mCurrentProblem;
//    private long mCurrentStartTime;
//    private TopicRecord mCurrentTopic;
//    private int mCurrentTopicId;
//    private int mCurrentType;
//    /* access modifiers changed from: private */
//    public PatternBaseFragment mExamplePatternFragment;
//    private C0066v mFragmentManager;
//    private Handler mHandler = new Handler();
//    private boolean mHasDoneWrong;
//    private boolean mHasHinted;
//    private boolean mHasShowCurrentWiki;
//    private TopicRecord mLastTopic;
//    private TextView mLastTopicTextView;
//    /* access modifiers changed from: private */
//    public LearningManager mLearningManager;
//    private PatternContainer mLearningPage;
//    /* access modifiers changed from: private */
//    public int mMaxComboCount;
//    /* access modifiers changed from: private */
//    public TextView mNewCountTextView;
//    AuthCallback<ProblemAsset> mObserver = new AuthCallback<ProblemAsset>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(ProblemAsset problemAsset) {
//            if (DefaultReviewActivity.this.isLoading() && problemAsset.getId() == DefaultReviewActivity.this.mWaitingTopicId) {
//                DefaultReviewActivity.this.exitLoading();
//                DefaultReviewActivity.this.tryNextProblem();
//            }
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//        }
//
//        /* access modifiers changed from: protected */
//        public void onProgress(Object obj) {
//            if (DefaultReviewActivity.this.mProgressLayout.getVisibility() == 0) {
//                ProblemAsset problemAsset = (ProblemAsset) obj;
//                if (problemAsset.getId() == DefaultReviewActivity.this.mWaitingTopicId) {
//                    DefaultReviewActivity.this.mProgressBar.setProgress(problemAsset.getProgress());
//                }
//            }
//        }
//    };
//    /* access modifiers changed from: private */
//    public FrameLayout mPatternPlaceholder;
//    private Runnable mPrepareWikiRunnable = new Runnable() {
//        public void run() {
//            DefaultReviewActivity.this.updateWikiAdapter(0);
//        }
//    };
//    /* access modifiers changed from: private */
//    public ProgressBar mProgressBar;
//    /* access modifiers changed from: private */
//    public View mProgressLayout;
//    private RecogLoadCallback mRecogLoadCallback;
//    /* access modifiers changed from: private */
//    public boolean mRecogLoaded = false;
//    private RecognitionLoader mRecogLoader;
//    /* access modifiers changed from: private */
//    public TextView mReviewCountTextView;
//    private int mReviewType;
//    private boolean mRunning = false;
//    private SparseArray<Integer> mSoundMap = new SparseArray<>();
//    private SoundPool mSoundPool = new SoundPool(3, 3, 0);
//    private PopupWindow mStatusTipWindow;
//    private TopicResourceManager mTopicResourceManager;
//    private Runnable mUpdateStatusLineRunnable = new Runnable() {
//        public void run() {
//            Pair newLearningAndReviewCount = DefaultReviewActivity.this.mLearningManager.getSequenceStrategy().getNewLearningAndReviewCount();
//            DefaultReviewActivity.this.mNewCountTextView.setText(DefaultReviewActivity.this.getString(R.string.main_new_count, new Object[]{newLearningAndReviewCount.getFirst()}));
//            DefaultReviewActivity.this.mReviewCountTextView.setText(DefaultReviewActivity.this.getString(R.string.main_review_count, new Object[]{newLearningAndReviewCount.getSecond()}));
//            DefaultReviewActivity.this.mComboCountTextView.setText(DefaultReviewActivity.this.getString(R.string.main_combo_count, new Object[]{Integer.valueOf(DefaultReviewActivity.this.mMaxComboCount)}));
//        }
//    };
//    /* access modifiers changed from: private */
//    public boolean mWaitRecogLoad = false;
//    /* access modifiers changed from: private */
//    public boolean mWaitResLoad = false;
//    /* access modifiers changed from: private */
//    public int mWaitingTopicId;
//    /* access modifiers changed from: private */
//    public Direction mWikiDirection;
//    private LinkedList<WikiEntry> mWikiEntries = new LinkedList<>();
//    /* access modifiers changed from: private */
//    public SwipeViewPager mWikiPager;
//    /* access modifiers changed from: private */
//    public WikiPagerAdapter mWikiPagerAdapter;
//
//    class BoomRun implements Runnable {
//        final WeakReference<DefaultReviewActivity> mActivity;
//
//        BoomRun(DefaultReviewActivity defaultReviewActivity) {
//            this.mActivity = new WeakReference<>(defaultReviewActivity);
//        }
//
//        public void run() {
//            DefaultReviewActivity defaultReviewActivity = (DefaultReviewActivity) this.mActivity.get();
//            if (defaultReviewActivity != null) {
//                defaultReviewActivity.tryNextProblem();
//            }
//        }
//    }
//
//    class RecogLoadCallback implements RecognitionLoadListener {
//        final WeakReference<DefaultReviewActivity> mActivity;
//
//        RecogLoadCallback(DefaultReviewActivity defaultReviewActivity) {
//            this.mActivity = new WeakReference<>(defaultReviewActivity);
//        }
//
//        public void onLoaded(boolean z, int i, Map<Integer, RecognitionData> map) {
//            DefaultReviewActivity defaultReviewActivity = (DefaultReviewActivity) this.mActivity.get();
//            if (defaultReviewActivity != null) {
//                Log.d("whiz", "loading for load recog result: " + z);
//                defaultReviewActivity.mRecogLoaded = true;
//                defaultReviewActivity.mWaitRecogLoad = false;
//                if (defaultReviewActivity.isLoading() && !defaultReviewActivity.mWaitResLoad) {
//                    defaultReviewActivity.tryNextProblem();
//                }
//            }
//        }
//    }
//
//    public static final boolean startListen(Context context) {
//        return start(context, 4);
//    }
//
//    public static final boolean startRead(Context context) {
//        return start(context, 5);
//    }
//
//    public static final boolean startWrite(Context context) {
//        return start(context, 6);
//    }
//
//    private static final boolean start(Context context, int i) {
//        if (i != 4 && i != 5 && i != 6) {
//            return false;
//        }
//        Intent intent = new Intent(context, DefaultReviewActivity.class);
//        intent.putExtra("type", i);
//        context.startActivity(intent);
//        return true;
//    }
//
//    public void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        bundle.putBoolean(ConstantsUtil.STATE_EXIT_FOR_RECREATE, true);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        getWindow().setFormat(-3);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setVolumeControlStream(3);
//            if (!tryFinishSelf(bundle)) {
//                this.mReviewType = getIntent().getIntExtra("type", -1);
//                if (this.mReviewType < 0) {
//                    finish();
//                    return;
//                }
//                if (5 == this.mReviewType) {
//                    getWindow().addFlags(128);
//                }
//                setContentView(R.layout.activity_learning);
//                initAnims();
//                initView();
//                this.mSoundMap.put(R.raw.answer_right, Integer.valueOf(this.mSoundPool.load(this, R.raw.answer_right, 1)));
//                this.mSoundMap.put(R.raw.answer_error, Integer.valueOf(this.mSoundPool.load(this, R.raw.answer_error, 1)));
//                this.mSoundMap.put(R.raw.chop, Integer.valueOf(this.mSoundPool.load(this, R.raw.chop, 1)));
//                this.mTopicResourceManager = TopicResourceManager.getInstance();
//                this.mTopicResourceManager.getTopicWaitingHall().setObserver(this.mObserver);
//                this.mLearningManager = StudyManager.getInstance().getLearningManager();
//                this.mAudioPlayer = new AudioPlayer(this);
//                OfflineStateRecord currentOfflineState = StudyManager.getInstance().getCurrentOfflineState();
//                this.mCurrentComboCount = currentOfflineState.comboCount;
//                this.mMaxComboCount = currentOfflineState.maxComboCount;
//                tryLoadRecognition();
//                this.mBoomRun = new BoomRun(this);
//            }
//        }
//    }
//
//    private boolean tryFinishSelf(Bundle bundle) {
//        if (bundle == null || !bundle.getBoolean(ConstantsUtil.STATE_EXIT_FOR_RECREATE, false)) {
//            return false;
//        }
//        LogWrapper.m2794e(TAG, TAG + " is recreated and data is lost, finish!");
//        finish();
//        return true;
//    }
//
//    private void tryLoadRecognition() {
//        if (this.mReviewType == 5) {
//            List<ProblemProxy> next = this.mLearningManager.getSequenceStrategy().getNext(0, 50);
//            ArrayList arrayList = new ArrayList();
//            for (ProblemProxy id : next) {
//                arrayList.add(Integer.valueOf(id.getId()));
//            }
//            this.mRecogLoadCallback = new RecogLoadCallback(this);
//            this.mRecogLoader = RecognitionLoader.createInstance(this, this.mRecogLoadCallback);
//            this.mRecogLoader.load(arrayList);
//        }
//    }
//
//    public void onResume() {
//        super.onResume();
//        if (!this.mRunning) {
//            this.mHandler.postDelayed(this.mBoomRun, 300);
//            this.mRunning = true;
//        }
//        UMStats.traceOnActivityResume(this);
//    }
//
//    public void onPause() {
//        super.onPause();
//        UMStats.traceOnActivityPause(this);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onStop() {
//        super.onStop();
//        OfflineStateRecord currentOfflineState = StudyManager.getInstance().getCurrentOfflineState();
//        if (currentOfflineState != null) {
//            currentOfflineState.comboCount = this.mCurrentComboCount;
//            currentOfflineState.maxComboCount = this.mMaxComboCount;
//            BookRecordHelper.saveOfflineState(this, currentOfflineState);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDestroy() {
//        super.onDestroy();
//        PatternFactory.clear();
//        if (this.mExamplePatternFragment != null) {
//            this.mExamplePatternFragment.onDetach();
//        }
//        if (this.mAudioPlayer != null) {
//            this.mAudioPlayer.destroy();
//        }
//        this.mSoundPool.release();
//        this.mSoundPool = null;
//        this.mHandler.removeCallbacksAndMessages(null);
//        System.gc();
//    }
//
//    private void initView() {
//        PatternFactory.clear();
//        PatternFactory.reserve(this, 5, 2);
//        PatternFactory.reserve(this, 6, 2);
//        PatternFactory.reserve(this, 4, 2);
//        this.mFragmentManager = getSupportFragmentManager();
//        this.mLearningPage = (PatternContainer) findViewById(R.id.learning_page);
//        this.mLearningPage.setOnFlingListener(new OnFlingListener() {
//            public void onFling(Direction direction) {
//                if (direction == Direction.LEFT) {
//                    DefaultReviewActivity.this.showWiki(Direction.LEFT, 1);
//                }
//            }
//        });
//        this.mPatternPlaceholder = (FrameLayout) findViewById(R.id.example_placeholder);
//        findViewById(R.id.home).setOnClickListener(this);
//        this.mNewCountTextView = (TextView) findViewById(R.id.new_count);
//        this.mReviewCountTextView = (TextView) findViewById(R.id.review_count);
//        this.mComboCountTextView = (TextView) findViewById(R.id.combo_count);
//        this.mLastTopicTextView = (TextView) findViewById(R.id.last_topic);
//        this.mLastTopicTextView.setOnClickListener(this);
//        if (6 == this.mReviewType) {
//            findViewById(R.id.learning_footer).setVisibility(8);
//        } else {
//            findViewById(R.id.hint).setOnClickListener(this);
//            findViewById(R.id.kill).setOnClickListener(this);
//            findViewById(R.id.voice).setVisibility(8);
//        }
//        this.mProgressLayout = findViewById(R.id.progress_layout);
//        this.mProgressBar = (ProgressBar) this.mProgressLayout.findViewById(R.id.loading_progress);
//        this.mCancelLoading = (TextView) this.mProgressLayout.findViewById(R.id.cancel_loading);
//        this.mCancelLoading.setOnClickListener(this);
//        this.mWikiPager = (SwipeViewPager) findViewById(R.id.wiki_pager);
//        ViewCompat.m543b(this.mWikiPager);
//        this.mWikiPager.setFlingListener(new SwipeViewPager.OnFlingListener() {
//            public void onFling(SwipeViewPager.Direction direction) {
//                if (DefaultReviewActivity.this.isInWiki() && DefaultReviewActivity.this.mWikiPager.getCurrentItem() == 0 && direction == SwipeViewPager.Direction.RIGHT) {
//                    DefaultReviewActivity.this.mWikiDirection = Direction.LEFT;
//                    DefaultReviewActivity.this.hideWiki();
//                }
//            }
//        });
//        this.mWikiPager.setOnPageChangeListener(new C0156bm() {
//            public void onPageScrolled(int i, float f, int i2) {
//            }
//
//            public void onPageSelected(int i) {
//                DefaultReviewActivity.this.mWikiPagerAdapter.stopMedia();
//            }
//
//            public void onPageScrollStateChanged(int i) {
//            }
//        });
//        this.mComboPopupWindow = new ComboPopupWindow(this);
//        this.mReviewCountTextView.setOnClickListener(this);
//        this.mComboCountTextView.setOnClickListener(this);
//    }
//
//    private void initAnims() {
//        this.animPushUpOut = AnimationUtils.loadAnimation(this, R.anim.business_push_up_out);
//        this.animPushDownIn = AnimationUtils.loadAnimation(this, R.anim.business_push_down_in);
//        this.animPushDownIn.setDuration(150);
//        this.animPushLeftIn = AnimationUtils.loadAnimation(this, R.anim.business_push_left_in);
//        this.animPushLeftIn.setDuration(150);
//        this.animWikiPushRightOut = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
//        this.animWikiPushRightOut.setDuration(300);
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.hint /*2131296311*/:
//                hintMe();
//                return;
//            case R.id.home /*2131296343*/:
//            case R.id.cancel_loading /*2131296356*/:
//                finish();
//                return;
//            case R.id.review_count /*2131296345*/:
//                showStatusTip(view, getString(R.string.main_guide_review));
//                return;
//            case R.id.combo_count /*2131296346*/:
//                showStatusTip(view, getString(R.string.main_guide_combo));
//                return;
//            case R.id.last_topic /*2131296347*/:
//                showWiki(Direction.LEFT, 1);
//                return;
//            case R.id.voice /*2131296350*/:
//                if (this.mExamplePatternFragment != null) {
//                    this.mExamplePatternFragment.sound();
//                    return;
//                }
//                return;
//            case R.id.kill /*2131296351*/:
//                tryKill();
//                return;
//            default:
//                return;
//        }
//    }
//
//    @SuppressLint({"InflateParams"})
//    private void showStatusTip(View view, CharSequence charSequence) {
//        LogWrapper.m2793d("leijie", "showStatusTip " + charSequence);
//        if (this.mStatusTipWindow != null) {
//            this.mStatusTipWindow.dismiss();
//        }
//        View inflate = getLayoutInflater().inflate(R.layout.learning_status_tip_window, null, false);
//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setShape(0);
//        gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_common_white));
//        gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(this, 4.0f));
//        TextView textView = (TextView) inflate.findViewById(R.id.text);
//        C1604j.m3631a(textView, gradientDrawable);
//        textView.setText(charSequence);
//        this.mStatusTipWindow = new PopupWindow(inflate, -2, -2);
//        this.mStatusTipWindow.setTouchable(true);
//        this.mStatusTipWindow.setFocusable(true);
//        this.mStatusTipWindow.setOutsideTouchable(false);
//        this.mStatusTipWindow.setBackgroundDrawable(new ColorDrawable(0));
//        this.mStatusTipWindow.setAnimationStyle(2131492866);
//        Rect rect = new Rect();
//        view.getGlobalVisibleRect(rect);
//        this.mStatusTipWindow.showAtLocation(this.mLearningPage, 51, ((rect.left + rect.right) - DisplayUtils.dpToPx(this, 220.0f)) / 2, rect.bottom);
//    }
//
//    private void hintMe() {
//        if (this.mExamplePatternFragment != null) {
//            if (!this.mHasHinted) {
//                LearnRecordManager.getInstance().hint(this.mCurrentTopicId);
//            }
//            this.mHasHinted = true;
//            if (!this.mExamplePatternFragment.hint()) {
//                showWiki(Direction.DOWN, 0);
//            }
//        }
//    }
//
//    private void checkPreload() {
//        if (this.mTopicResourceManager.getTopicWaitingHall().getTotalWaiterCount() <= 7) {
//            this.mTopicResourceManager.loadNextProblems(this, this.mLearningManager, 10, true);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void tryNextProblem() {
//        checkPreload();
//        if (this.mProgressLayout.getVisibility() != 0 && this.mCurrentAnswer != Answer.WRONG) {
//            ProblemProxy nextOne = this.mLearningManager.getSequenceStrategy().getNextOne();
//            if (nextOne == null) {
//                onFinishToday();
//                return;
//            }
//            this.mCurrentProblem = this.mTopicResourceManager.getTopicWaitingHall().tryCheckOut(nextOne.getId());
//            if (this.mCurrentProblem == null) {
//                this.mWaitResLoad = true;
//                this.mWaitingTopicId = nextOne.getId();
//                enterLoading();
//            } else if (5 != this.mReviewType || !RecognitionCache.getCache().needLoad(nextOne.getId())) {
//                exitLoading();
//                nextProblem();
//            } else {
//                this.mWaitRecogLoad = true;
//                this.mWaitingTopicId = nextOne.getId();
//                enterLoading();
//            }
//        }
//    }
//
//    private void nextProblem() {
//        int i;
//        if (this.mCurrentTopic != null) {
//            this.mLastTopic = this.mCurrentTopic;
//            this.mLastTopicTextView.setText(String.format(Locale.CHINA, "%s %s", new Object[]{this.mLastTopic.word, StringUtil.firstLine(this.mLastTopic.wordMean)}));
//            if (this.mCurrentAnswer == Answer.KILL) {
//                i = R.drawable.satus_slash_normal_default;
//            } else if (this.mHasDoneWrong) {
//                i = R.drawable.satus_wrong_normal_default;
//            } else if (this.mHasHinted) {
//                i = R.drawable.satus_eye_normal_default;
//            } else {
//                i = R.drawable.satus_right_normal_default;
//            }
//            this.mLastTopicTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
//        } else {
//            this.mLastTopicTextView.setText("");
//            this.mLastTopicTextView.setCompoundDrawables(null, null, null, null);
//        }
//        this.mHasDoneWrong = false;
//        this.mHasHinted = false;
//        this.mHasShowCurrentWiki = false;
//        this.mCurrentTopicId = this.mCurrentProblem.getId();
//        this.mWikiEntries.addFirst(new WikiEntry(this.mCurrentTopicId, 0));
//        this.mCurrentAnswer = Answer.WRONG;
//        this.mCurrentStartTime = System.currentTimeMillis();
//        this.mCurrentProblem.shuffle();
//        this.mCurrentTopic = this.mCurrentProblem.getPrimary();
//        final List optionRecords = this.mCurrentProblem.getOptionRecords();
//        final int indexOf = optionRecords.indexOf(this.mCurrentTopic);
//        final PatternBaseFragment patternBaseFragment = this.mExamplePatternFragment;
//        if (patternBaseFragment != null) {
//            patternBaseFragment.onDetach();
//            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
//            translateAnimation.setDuration(300);
//            translateAnimation.setAnimationListener(new AnimationListener() {
//                public void onAnimationStart(Animation animation) {
//                    patternBaseFragment.setBackgroundColor(ThemeUtil.getThemeColorWithAttr(DefaultReviewActivity.this, R.attr.color_common_bg));
//                }
//
//                public void onAnimationEnd(Animation animation) {
//                    DefaultReviewActivity.this.mPatternPlaceholder.post(new Runnable() {
//                        public void run() {
//                            DefaultReviewActivity.this.mPatternPlaceholder.removeView(patternBaseFragment);
//                            patternBaseFragment.setBackgroundColor(0);
//                            PatternFactory.release(patternBaseFragment);
//                        }
//                    });
//                }
//
//                public void onAnimationRepeat(Animation animation) {
//                }
//            });
//            patternBaseFragment.startAnimation(translateAnimation);
//        }
//        this.mExamplePatternFragment = PatternFactory.obtain(this, this.mReviewType);
//        if (this.mExamplePatternFragment instanceof WriteFragment) {
//            ((WriteFragment) this.mExamplePatternFragment).setOnControlListener(this);
//        }
//        this.mLearningPage.post(new Runnable() {
//            public void run() {
//                DefaultReviewActivity.this.mPatternPlaceholder.addView(DefaultReviewActivity.this.mExamplePatternFragment, 0);
//                DefaultReviewActivity.this.mExamplePatternFragment.onAttach(DefaultReviewActivity.this);
//                DefaultReviewActivity.this.mExamplePatternFragment.setTopicOptions(indexOf, optionRecords, DefaultReviewActivity.this.mAudioPlayer);
//            }
//        });
//        this.mHandler.removeCallbacks(this.mPrepareWikiRunnable);
//        this.mHandler.postDelayed(this.mPrepareWikiRunnable, 1000);
//        updateStatusLine();
//    }
//
//    private void skip() {
//        LearnRecordManager.getInstance().doneCorrect(this.mCurrentTopicId, elapseTime());
//        this.mCurrentAnswer = Answer.CORRECT;
//        updateStatusLine();
//        tryNextProblem();
//    }
//
//    public void showWiki(Direction direction, int i) {
//        this.mHandler.removeCallbacks(this.mPrepareWikiRunnable);
//        if (i < this.mWikiEntries.size()) {
//            if (i == 0) {
//                this.mHasShowCurrentWiki = true;
//            }
//            Animation animation = direction == Direction.DOWN ? this.animPushDownIn : this.animPushLeftIn;
//            this.mLearningPage.setEnabled(false);
//            this.mWikiDirection = direction;
//            this.mWikiPager.startAnimation(animation);
//            this.mWikiPager.setVisibility(0);
//            updateWikiAdapter(i);
//            this.mWikiPager.setCurrentItem(0);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void updateWikiAdapter(int i) {
//        int size = this.mWikiEntries.size() - i;
//        if (this.mWikiPagerAdapter == null || this.mWikiPagerAdapter.getCount() != size) {
//            this.mWikiPagerAdapter = new WikiPagerAdapter(this.mFragmentManager, this, this.mWikiEntries.subList(i, this.mWikiEntries.size()));
//            this.mWikiPagerAdapter.setStyle(4);
//            this.mWikiPager.setAdapter(this.mWikiPagerAdapter);
//        }
//    }
//
//    public void hideWiki() {
//        Animation animation;
//        if (this.mExamplePatternFragment != null) {
//            this.mExamplePatternFragment.clearOptionMask(false);
//        }
//        this.mWikiPager.setVisibility(4);
//        this.mWikiPagerAdapter.stopMedia();
//        if (this.mLastTopic != null) {
//            this.mLastTopicTextView.setCompoundDrawablesWithIntrinsicBounds(LearnRecordManager.getInstance().isKilled(this.mLastTopic.topicId) ? R.drawable.satus_slash_normal_default : R.drawable.satus_eye_normal_default, 0, 0, 0);
//        }
//        if (LearnRecordManager.getInstance().isKilled(this.mCurrentTopicId)) {
//            this.mCurrentAnswer = Answer.KILL;
//        }
//        if (this.mCurrentAnswer == Answer.CORRECT || this.mCurrentAnswer == Answer.KILL) {
//            tryNextProblem();
//            animation = this.animWikiPushRightOut;
//        } else {
//            animation = this.mWikiDirection == Direction.DOWN ? this.animPushUpOut : this.mWikiDirection == Direction.LEFT ? this.animWikiPushRightOut : null;
//        }
//        if (animation != null) {
//            this.mLearningPage.setEnabled(true);
//            this.mWikiPager.startAnimation(animation);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public boolean isInWiki() {
//        return this.mWikiPager.getVisibility() == 0;
//    }
//
//    /* access modifiers changed from: private */
//    public boolean isLoading() {
//        return this.mProgressLayout.getVisibility() == 0;
//    }
//
//    private void enterLoading() {
//        LogWrapper.m2793d(TAG, "enterLoading");
//        this.mHandler.postDelayed(this.mCancelLoadingRunnable, LOADING_TIMEOUT);
//        this.mProgressLayout.setVisibility(0);
//        this.mProgressBar.setProgress(0);
//        this.mCancelLoading.setText("正在努力为您加载中o(｀ω´ )o");
//        this.mCancelLoading.setEnabled(false);
//        this.mProgressLayout.setOnClickListener(this);
//    }
//
//    /* access modifiers changed from: private */
//    public void exitLoading() {
//        this.mHandler.removeCallbacks(this.mCancelLoadingRunnable);
//        this.mProgressLayout.setVisibility(4);
//        this.mProgressLayout.setOnClickListener(this);
//    }
//
//    public boolean onAnswer(int i) {
//        boolean z = i == this.mCurrentTopicId;
//        int i2 = z ? R.raw.answer_right : R.raw.answer_error;
//        if (!(this.mExamplePatternFragment instanceof ReadFragment) || !z) {
//            if (PropertyHelper.getBoolean(PropertyHelper.SOUND_EFFECT, true)) {
//                this.mSoundPool.play(((Integer) this.mSoundMap.get(i2)).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
//            }
//        } else if (this.mExamplePatternFragment instanceof ReadFragment) {
//            ZPackUtils.loadAudioCompat(this.mAudioPlayer, this.mCurrentTopic, this.mCurrentTopic.wordAudio);
//        }
//        if (!z) {
//            this.mLearningPage.postDelayed(new Runnable() {
//                public void run() {
//                    DefaultReviewActivity.this.showWiki(Direction.DOWN, 0);
//                }
//            }, 50);
//        }
//        if (z) {
//            long elapseTime = elapseTime();
//            if (this.mHasDoneWrong) {
//                LearnRecordManager.getInstance().doneWrong(i, elapseTime);
//            } else {
//                LearnRecordManager.getInstance().doneCorrect(i, elapseTime);
//                this.mCurrentComboCount = this.mCurrentComboCount >= MAX_COMBO_COUNT ? MAX_COMBO_COUNT : this.mCurrentComboCount + 1;
//                if (this.mCurrentComboCount > this.mMaxComboCount) {
//                    this.mMaxComboCount = this.mCurrentComboCount;
//                }
//                this.mComboPopupWindow.showCombo(this.mComboCountTextView, this.mCurrentComboCount);
//                this.mHandler.postDelayed(new Runnable() {
//                    public void run() {
//                        if (DefaultReviewActivity.this.mComboPopupWindow != null) {
//                            DefaultReviewActivity.this.mComboPopupWindow.dismiss();
//                        }
//                    }
//                }, 400);
//            }
//            this.mCurrentAnswer = Answer.CORRECT;
//            tryNextProblem();
//        } else {
//            this.mHasDoneWrong = true;
//            this.mCurrentComboCount = 0;
//            this.mCurrentAnswer = Answer.WRONG;
//        }
//        return false;
//    }
//
//    public void onHinted() {
//        this.mHasHinted = true;
//    }
//
//    private long elapseTime() {
//        long currentTimeMillis = System.currentTimeMillis();
//        long j = currentTimeMillis - this.mCurrentStartTime;
//        this.mCurrentStartTime = currentTimeMillis;
//        return j;
//    }
//
//    private void tryKill() {
//        kill();
//    }
//
//    private void kill() {
//        if (PropertyHelper.getBoolean(PropertyHelper.SOUND_EFFECT, true)) {
//            this.mSoundPool.play(((Integer) this.mSoundMap.get(R.raw.chop)).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
//        }
//        this.mCurrentAnswer = Answer.KILL;
//        LearnRecordManager.getInstance().kill(this.mCurrentTopicId, elapseTime());
//        tryNextProblem();
//    }
//
//    private void updateStatusLine() {
//        this.mHandler.removeCallbacks(this.mUpdateStatusLineRunnable);
//        this.mHandler.postDelayed(this.mUpdateStatusLineRunnable, 1000);
//    }
//
//    private void onFinishToday() {
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            Intent intent = new Intent(this, DakaActivity.class);
//            intent.putExtra("portrait_mode", false);
//            startActivity(intent);
//        }
//        finish();
//    }
//
//    public void onWikiExit() {
//        hideWiki();
//    }
//
//    public void onKillWord() {
//        tryKill();
//    }
//
//    public void onBackPressed() {
//        if (isInWiki()) {
//            hideWiki();
//        } else {
//            super.onBackPressed();
//        }
//    }
//}
