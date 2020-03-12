//package com.baicizhan.main.activity;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.graphics.Point;
//import android.graphics.Rect;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.ColorDrawable;
//import android.graphics.drawable.Drawable;
//import android.graphics.drawable.GradientDrawable;
//import android.media.SoundPool;
//import android.os.Bundle;
//import android.os.Handler;
//import androidx.fragment.app.FragmentManager;//import android.support.p004v4.app.C0066v;
//import android.support.p004v4.app.FragmentActivity;
//import android.support.p004v4.view.C0156bm;
//import android.support.p004v4.view.ViewCompat;
//import android.text.SpannableString;
//import android.text.TextUtils;
//import android.text.style.ForegroundColorSpan;
//import android.util.Log;
//import android.util.SparseArray;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.MeasureSpec;
//import android.view.View.OnClickListener;
//import android.view.View.OnTouchListener;
//import android.view.ViewGroup;
//import android.view.ViewStub;
//import android.view.ViewTreeObserver.OnPreDrawListener;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationUtils;
//import android.view.animation.TranslateAnimation;
//import android.widget.FrameLayout;
//import android.widget.PopupWindow;
//import android.widget.ProgressBar;
//import android.widget.RelativeLayout.LayoutParams;
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
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.SimpleSpannableBuilder;
//import com.baicizhan.client.business.util.StringUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.business.widget.HollowDrawable;
//import com.baicizhan.client.business.widget.HollowDrawable.RectHollow;
//import com.baicizhan.client.business.widget.SwipeViewPager;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.iface.LearningManager;
//import com.baicizhan.learning_strategy.util.Pair;
//import com.baicizhan.main.adapter.WikiPagerAdapter;
//import com.baicizhan.main.adapter.WikiPagerAdapter.WikiEntry;
//import com.baicizhan.main.customview.PatternContainer;
//import com.baicizhan.main.customview.PatternContainer.Direction;
//import com.baicizhan.main.customview.PatternContainer.OnFlingListener;
//import com.baicizhan.main.fragment.PatternBaseFragment;
//import com.baicizhan.main.fragment.PatternBaseFragment.ExamplePatternListener;
//import com.baicizhan.main.fragment.PatternFactory;
//import com.baicizhan.main.fragment.WikiFragment.WikiListener;
//import com.baicizhan.main.popup.ComboPopupWindow;
//import com.baicizhan.main.resource.ProblemAsset;
//import com.baicizhan.main.resource.TopicDownloadTask;
//import com.baicizhan.main.resource.TopicResourceManager;
//import com.baicizhan.main.stats.study.StudyStats;
//import com.baicizhan.main.utils.GuideFlags;
//import com.baicizhan.main.utils.NoticeManager;
//import com.baicizhan.main.utils.ResidentBitmapCache;
//import com.baicizhan.online.bs_users.BBDoneWordStatLog;
//import com.baicizhan.online.bs_users.BBUserFinishPlanInfo;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Locale;
//import org.p100a.p101a.p107f.C2120g;
//import p012ch.qos.logback.classic.Level;
//
//public class LearningActivity extends FragmentActivity implements OnClickListener, ExamplePatternListener, WikiListener {
//    private static final int COMBO_DURATION = 400;
//    private static final long LOADING_TIMEOUT = 15000;
//    private static final int MAX_COMBO_COUNT = 999;
//    private static final int PRELOAD_BATCH_COUNT = 5;
//    private static final int PRELOAD_THRESHOLD = 3;
//    /* access modifiers changed from: private */
//    public static final String TAG = LearningActivity.class.getSimpleName();
//    private Animation animFadeOut;
//    private Animation animPushDownIn;
//    private Animation animPushLeftIn;
//    private Animation animPushUpOut;
//    private Animation animWikiPushRightOut;
//    private Runnable mAdvancedCheckingRunnable = new Runnable() {
//        public void run() {
//            if (LearningActivity.this.isLoading()) {
//                TopicDownloadTask.setSkipTopicUpdate(true);
//                if (LearningActivity.this.trySkipLoading(LearningActivity.this.mWaitingTopicId)) {
//                    LearningActivity.this.nextProblem();
//                }
//            }
//        }
//    };
//    /* access modifiers changed from: private */
//    public AudioPlayer mAudioPlayer;
//    private ViewGroup mBaoGuidePlaceholder;
//    /* access modifiers changed from: private */
//    public TextView mCancelLoading;
//    private Runnable mCancelLoadingRunnable = new Runnable() {
//        public void run() {
//            LearningActivity.this.mCancelLoading.setText("返回主界面");
//            LearningActivity.this.mCancelLoading.setEnabled(true);
//            Toast.makeText(LearningActivity.this, "客官，你的某些单词资源有缺失，需联网更新。\nTip：连接稳定的网络，即可自动更新", 1).show();
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
//    private OnTouchListener mGuideDismissListener;
//    /* access modifiers changed from: private */
//    public View mGuideLayout;
//    private OnTouchListener mGuideRetainListener;
//    private Handler mHandler = new Handler();
//    private boolean mHasDoneWrong;
//    private boolean mHasHinted;
//    private boolean mHasShowCurrentWiki;
//    /* access modifiers changed from: private */
//    public View mKillButton;
//    private TopicRecord mLastTopic;
//    private TextView mLastTopicTextView;
//    private int mLastWrongOptionId;
//    /* access modifiers changed from: private */
//    public LearningManager mLearningManager;
//    private PatternContainer mLearningPage;
//    /* access modifiers changed from: private */
//    public int mMaxComboCount;
//    private boolean mNeedCheckGuides;
//    /* access modifiers changed from: private */
//    public TextView mNewCountTextView;
//    AuthCallback<ProblemAsset> mObserver = new AuthCallback<ProblemAsset>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(ProblemAsset problemAsset) {
//            if (LearningActivity.this.isLoading() && problemAsset.getId() == LearningActivity.this.mWaitingTopicId) {
//                LogWrapper.m2796v(LearningActivity.TAG, "onSuccess " + LearningActivity.this.mWaitingTopicId);
//                LearningActivity.this.exitLoading();
//                LearningActivity.this.tryNextProblem();
//            }
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//        }
//
//        /* access modifiers changed from: protected */
//        public void onProgress(Object obj) {
//            if (LearningActivity.this.mProgressLayout.getVisibility() == 0) {
//                ProblemAsset problemAsset = (ProblemAsset) obj;
//                if (problemAsset.getId() == LearningActivity.this.mWaitingTopicId) {
//                    LogWrapper.m2796v(LearningActivity.TAG, "onProgress waitingTopic " + LearningActivity.this.mWaitingTopicId + ", " + problemAsset.getProgress());
//                    LearningActivity.this.mProgressBar.setProgress(problemAsset.getProgress());
//                }
//            }
//        }
//    };
//    /* access modifiers changed from: private */
//    public FrameLayout mPatternPlaceholder;
//    /* access modifiers changed from: private */
//    public boolean mPortraitMode = false;
//    private Runnable mPrepareWikiRunnable = new Runnable() {
//        public void run() {
//            LearningActivity.this.updateWikiAdapter(0);
//        }
//    };
//    /* access modifiers changed from: private */
//    public ProgressBar mProgressBar;
//    /* access modifiers changed from: private */
//    public View mProgressLayout;
//    /* access modifiers changed from: private */
//    public TextView mReviewCountTextView;
//    private SparseArray<Integer> mSoundMap = new SparseArray<>();
//    private SoundPool mSoundPool = new SoundPool(3, 3, 0);
//    private PopupWindow mStatusTipWindow;
//    private TopicResourceManager mTopicResourceManager;
//    private Runnable mUpdateStatusLineRunnable = new Runnable() {
//        public void run() {
//            Pair newLearningAndReviewCount = LearningActivity.this.mLearningManager.getSequenceStrategy().getNewLearningAndReviewCount();
//            if (LearningActivity.this.mPortraitMode) {
//                LearningActivity.this.mNewCountTextView.setText(LearningActivity.this.getString(R.string.main_new_count_portrait, new Object[]{newLearningAndReviewCount.getFirst(), newLearningAndReviewCount.getSecond()}));
//                return;
//            }
//            LearningActivity.this.mNewCountTextView.setText(LearningActivity.this.getString(R.string.main_new_count, new Object[]{newLearningAndReviewCount.getFirst()}));
//            LearningActivity.this.mReviewCountTextView.setText(LearningActivity.this.getString(R.string.main_review_count, new Object[]{newLearningAndReviewCount.getSecond()}));
//            LearningActivity.this.mComboCountTextView.setText(LearningActivity.this.getString(R.string.main_combo_count, new Object[]{Integer.valueOf(LearningActivity.this.mMaxComboCount)}));
//        }
//    };
//    /* access modifiers changed from: private */
//    public int mWaitingTopicId;
//    /* access modifiers changed from: private */
//    public Direction mWikiDirection;
//    private LinkedList<WikiEntry> mWikiEntries = new LinkedList<>();
//    /* access modifiers changed from: private */
//    public SwipeViewPager mWikiPager;
//    /* access modifiers changed from: private */
//    public WikiPagerAdapter mWikiPagerAdapter;
//    private boolean skipPatternAnim = false;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        getWindow().setFormat(-3);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setVolumeControlStream(3);
//            if (!StudyManager.getInstance().hasValidSchedule() || StudyManager.getInstance().getLearningManager() == null) {
//                LogWrapper.m2793d(TAG, "invalid StudyManager");
//                finish();
//                return;
//            }
//            this.mPortraitMode = PropertyHelper.getBoolean("portrait_mode");
//            if (this.mPortraitMode) {
//                setRequestedOrientation(1);
//                setContentView(R.layout.activity_learning_portrait);
//            } else {
//                setRequestedOrientation(0);
//                setContentView(R.layout.activity_learning);
//            }
//            initAnims();
//            initView();
//            this.mSoundMap.put(R.raw.answer_right, Integer.valueOf(this.mSoundPool.load(this, R.raw.answer_right, 1)));
//            this.mSoundMap.put(R.raw.answer_error, Integer.valueOf(this.mSoundPool.load(this, R.raw.answer_error, 1)));
//            this.mSoundMap.put(R.raw.chop, Integer.valueOf(this.mSoundPool.load(this, R.raw.chop, 1)));
//            this.mTopicResourceManager = TopicResourceManager.getInstance();
//            this.mTopicResourceManager.getTopicWaitingHall().setObserver(this.mObserver);
//            this.mLearningManager = StudyManager.getInstance().getLearningManager();
//            this.mAudioPlayer = new AudioPlayer(this);
//            OfflineStateRecord currentOfflineState = StudyManager.getInstance().getCurrentOfflineState();
//            if (currentOfflineState != null) {
//                this.mCurrentComboCount = currentOfflineState.comboCount;
//                this.mMaxComboCount = currentOfflineState.maxComboCount;
//            }
//            tryNextProblem();
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
//        try {
//            if (this.mWikiPager != null) {
//                this.mWikiPager.setAdapter(null);
//            }
//            super.onDestroy();
//            PatternFactory.clear();
//            if (this.mExamplePatternFragment != null) {
//                this.mExamplePatternFragment.onDetach();
//            }
//            if (this.mAudioPlayer != null) {
//                this.mAudioPlayer.destroy();
//                this.mAudioPlayer = null;
//            }
//            this.mSoundPool.release();
//            this.mSoundPool = null;
//            this.mHandler.removeCallbacksAndMessages(null);
//            StudyStats.getsInstance().stat(this);
//        } catch (Exception e) {
//            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//        }
//    }
//
//    private void initView() {
//        this.mLearningPage = (PatternContainer) findViewById(R.id.learning_page);
//        this.mLearningPage.setOnFlingListener(new OnFlingListener() {
//            public void onFling(Direction direction) {
//                if (direction == Direction.LEFT) {
//                    LearningActivity.this.showWiki(Direction.LEFT, 1);
//                } else if (direction == Direction.DOWN) {
//                    LearningActivity.this.notifyHint();
//                    LearningActivity.this.showWiki(Direction.DOWN, 0);
//                }
//            }
//        });
//        this.mPatternPlaceholder = (FrameLayout) findViewById(R.id.example_placeholder);
//        findViewById(R.id.home).setOnClickListener(this);
//        if (this.mPortraitMode) {
//            this.mNewCountTextView = (TextView) findViewById(R.id.new_count);
//        } else {
//            this.mNewCountTextView = (TextView) findViewById(R.id.new_count);
//            this.mReviewCountTextView = (TextView) findViewById(R.id.review_count);
//            this.mComboCountTextView = (TextView) findViewById(R.id.combo_count);
//        }
//        this.mLastTopicTextView = (TextView) findViewById(R.id.last_topic);
//        this.mLastTopicTextView.setOnClickListener(this);
//        findViewById(R.id.hint).setOnClickListener(this);
//        this.mKillButton = findViewById(R.id.kill);
//        this.mKillButton.setOnClickListener(this);
//        findViewById(R.id.voice).setOnClickListener(this);
//        this.mProgressLayout = findViewById(R.id.progress_layout);
//        this.mProgressBar = (ProgressBar) this.mProgressLayout.findViewById(R.id.loading_progress);
//        this.mCancelLoading = (TextView) this.mProgressLayout.findViewById(R.id.cancel_loading);
//        this.mCancelLoading.setOnClickListener(this);
//        this.mFragmentManager = getSupportFragmentManager();
//        this.mWikiPager = (SwipeViewPager) findViewById(R.id.wiki_pager);
//        ViewCompat.m543b(this.mWikiPager);
//        this.mWikiPager.setFlingListener(new SwipeViewPager.OnFlingListener() {
//            public void onFling(SwipeViewPager.Direction direction) {
//                if (LearningActivity.this.isInWiki() && LearningActivity.this.mWikiPager.getCurrentItem() == 0 && direction == SwipeViewPager.Direction.RIGHT) {
//                    LearningActivity.this.mWikiDirection = Direction.LEFT;
//                    LearningActivity.this.hideWiki();
//                }
//            }
//        });
//        this.mWikiPager.setOnPageChangeListener(new C0156bm() {
//            public void onPageScrolled(int i, float f, int i2) {
//            }
//
//            public void onPageSelected(int i) {
//                LearningActivity.this.mWikiPagerAdapter.stopMedia();
//            }
//
//            public void onPageScrollStateChanged(int i) {
//            }
//        });
//        this.mComboPopupWindow = new ComboPopupWindow(this);
//        if (!this.mPortraitMode) {
//            this.mReviewCountTextView.setOnClickListener(this);
//            this.mComboCountTextView.setOnClickListener(this);
//        }
//        if (!this.mPortraitMode) {
//            this.mNeedCheckGuides = GuideFlags.needCheckGuides();
//            if (this.mNeedCheckGuides) {
//                ((ViewStub) findViewById(R.id.guide_stub_simple)).inflate();
//                this.mGuideLayout = findViewById(R.id.guide_layout);
//                this.mBaoGuidePlaceholder = (ViewGroup) this.mGuideLayout.findViewById(R.id.bao_guide_placeholder);
//                this.mGuideLayout.setVisibility(4);
//                GradientDrawable gradientDrawable = new GradientDrawable();
//                gradientDrawable.setShape(0);
//                gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_common_white));
//                gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(this, 4.0f));
//                C1604j.m3631a(this.mBaoGuidePlaceholder, gradientDrawable);
//                this.mGuideDismissListener = new OnTouchListener() {
//                    public boolean onTouch(View view, MotionEvent motionEvent) {
//                        if (motionEvent.getAction() != 0) {
//                            return false;
//                        }
//                        LearningActivity.this.mGuideLayout.setVisibility(8);
//                        return true;
//                    }
//                };
//                this.mGuideRetainListener = new OnTouchListener() {
//                    public boolean onTouch(View view, MotionEvent motionEvent) {
//                        int action = motionEvent.getAction();
//                        if (action == 0 || action == 1) {
//                            return true;
//                        }
//                        return false;
//                    }
//                };
//                return;
//            }
//            return;
//        }
//        GuideFlags.putGuideFlags(0);
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
//        this.animFadeOut = AnimationUtils.loadAnimation(this, 17432577);
//        this.animFadeOut.setDuration(50);
//    }
//
//    private void normalGuideBackground() {
//        this.mGuideLayout.setBackgroundColor(Level.ALL_INT);
//    }
//
//    private void highlightGuideOptions() {
//        this.mExamplePatternFragment.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
//            public boolean onPreDraw() {
//                HollowDrawable maskColor = HollowDrawable.born().setMaskColor(Level.ALL_INT);
//                Rect rect = new Rect();
//                ViewGroup viewGroup = (ViewGroup) LearningActivity.this.mExamplePatternFragment.findViewById(R.id.option_container);
//                int dpToPx = DisplayUtils.dpToPx(LearningActivity.this, 4.0f);
//                int i = 0;
//                while (true) {
//                    int i2 = i;
//                    if (i2 < viewGroup.getChildCount()) {
//                        viewGroup.getChildAt(i2).getGlobalVisibleRect(rect);
//                        maskColor.digRectHollow(new RectHollow((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom, (float) dpToPx));
//                        i = i2 + 1;
//                    } else {
//                        C1604j.m3631a(LearningActivity.this.mGuideLayout, maskColor);
//                        LearningActivity.this.mExamplePatternFragment.getViewTreeObserver().removeOnPreDrawListener(this);
//                        LearningActivity.this.mGuideLayout.setOnTouchListener(new OnTouchListener() {
//                            public boolean onTouch(View view, MotionEvent motionEvent) {
//                                if (motionEvent.getAction() != 0) {
//                                    return false;
//                                }
//                                Drawable background = view.getBackground();
//                                if (!(background instanceof HollowDrawable) || !((HollowDrawable) background).isInHollow(motionEvent.getX(), motionEvent.getY())) {
//                                    return true;
//                                }
//                                return false;
//                            }
//                        });
//                        return true;
//                    }
//                }
//            }
//        });
//    }
//
//    private void showBaoGuideDialog(CharSequence charSequence, CharSequence charSequence2, OnClickListener onClickListener, CharSequence charSequence3, OnClickListener onClickListener2) {
//        boolean z = false;
//        boolean z2 = true;
//        this.mGuideLayout.setVisibility(0);
//        this.mBaoGuidePlaceholder.removeAllViews();
//        View inflate = getLayoutInflater().inflate(R.layout.fragment_guide_dialog, this.mBaoGuidePlaceholder, true);
//        ((TextView) inflate.findViewById(R.id.message)).setText(charSequence);
//        View findViewById = inflate.findViewById(R.id.button_line);
//        TextView textView = (TextView) inflate.findViewById(R.id.button_positive);
//        if (!TextUtils.isEmpty(charSequence2)) {
//            textView.setText(charSequence2);
//            textView.setOnClickListener(onClickListener);
//            z = true;
//        } else {
//            textView.setVisibility(8);
//        }
//        TextView textView2 = (TextView) inflate.findViewById(R.id.button_negative);
//        if (!TextUtils.isEmpty(charSequence3)) {
//            textView2.setText(charSequence3);
//            textView2.setOnClickListener(onClickListener2);
//        } else {
//            textView2.setVisibility(8);
//            z2 = z;
//        }
//        if (!z2) {
//            findViewById.setVisibility(8);
//        }
//        fixBaoGuidePosition();
//    }
//
//    private void showBaoGuideCustomView(int i) {
//        this.mBaoGuidePlaceholder.removeAllViews();
//        getLayoutInflater().inflate(i, this.mBaoGuidePlaceholder, true);
//        fixBaoGuidePosition();
//        this.mGuideLayout.setVisibility(0);
//        this.mGuideLayout.setOnTouchListener(this.mGuideDismissListener);
//    }
//
//    private void fixBaoGuidePosition() {
//        Point displayPixelSize = DisplayUtils.getDisplayPixelSize(this);
//        this.mGuideLayout.measure(MeasureSpec.makeMeasureSpec(displayPixelSize.x, 1073741824), MeasureSpec.makeMeasureSpec(displayPixelSize.y, 1073741824));
//        LayoutParams layoutParams = (LayoutParams) this.mBaoGuidePlaceholder.getLayoutParams();
//        layoutParams.leftMargin = DisplayUtils.dpToPx(this, 172.5f) - (this.mBaoGuidePlaceholder.getMeasuredWidth() / 2);
//        this.mBaoGuidePlaceholder.setLayoutParams(layoutParams);
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.hint /*2131296311*/:
//                hintMe(true);
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
//        this.mStatusTipWindow.showAtLocation(this.mLearningPage, 8388659, ((rect.left + rect.right) - DisplayUtils.dpToPx(this, 220.0f)) / 2, rect.bottom);
//    }
//
//    private void hintMe(boolean z) {
//        if (this.mExamplePatternFragment == null) {
//            return;
//        }
//        if (!this.mExamplePatternFragment.hint()) {
//            notifyHint();
//            showWiki(Direction.DOWN, 0);
//        } else if (z && GuideFlags.guideEnabled(32)) {
//            this.mGuideLayout.setOnTouchListener(this.mGuideDismissListener);
//            showBaoGuideDialog(getString(R.string.main_guide_hint), null, null, null, null);
//            GuideFlags.disableGuide(32);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void notifyHint() {
//        if (!this.mHasHinted) {
//            LearnRecordManager.getInstance().hint(this.mCurrentTopicId);
//        }
//        this.mHasHinted = true;
//    }
//
//    private void checkPreload() {
//        if (this.mTopicResourceManager.getTopicWaitingHall().getTotalWaiterCount() <= 3) {
//            this.mTopicResourceManager.loadNextProblems(this, this.mLearningManager, 5, false);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void tryNextProblem() {
//        checkPreload();
//        if (this.mCurrentAnswer != Answer.WRONG) {
//            ProblemProxy nextOne = this.mLearningManager.getSequenceStrategy().getNextOne();
//            if (nextOne == null) {
//                onFinishToday();
//                return;
//            }
//            this.mCurrentProblem = this.mTopicResourceManager.getTopicWaitingHall().tryCheckOut(nextOne.getId());
//            this.mCurrentType = this.mLearningManager.getTypeStrategy().getType(nextOne).getValue();
//            if (this.mCurrentProblem == null) {
//                int id = nextOne.getId();
//                if (!TopicDownloadTask.isSkipTopicUpdate() || !trySkipLoading(id)) {
//                    this.mWaitingTopicId = id;
//                    enterLoading();
//                    return;
//                }
//                nextProblem();
//                return;
//            }
//            exitLoading();
//            nextProblem();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void nextProblem() {
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
//            this.mLastTopicTextView.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(getResources(), ResidentBitmapCache.getBitmap(this, i)), null, null, null);
//        } else {
//            this.mLastTopicTextView.setText("");
//            this.mLastTopicTextView.setCompoundDrawables(null, null, null, null);
//        }
//        this.mHasDoneWrong = false;
//        this.mHasHinted = false;
//        this.mHasShowCurrentWiki = false;
//        this.mCurrentTopicId = this.mCurrentProblem.getId();
//        this.mWikiEntries.addFirst(new WikiEntry(this.mCurrentTopicId, this.mCurrentType));
//        this.mCurrentAnswer = Answer.WRONG;
//        this.mCurrentStartTime = System.currentTimeMillis();
//        this.mLastWrongOptionId = 0;
//        this.mKillButton.setEnabled(true);
//        this.mCurrentProblem.shuffle();
//        this.mCurrentTopic = this.mCurrentProblem.getPrimary();
//        final List optionRecords = this.mCurrentProblem.getOptionRecords();
//        final int indexOf = optionRecords.indexOf(this.mCurrentTopic);
//        final PatternBaseFragment patternBaseFragment = this.mExamplePatternFragment;
//        if (patternBaseFragment != null) {
//            final C10248 r12 = new Runnable() {
//                public void run() {
//                    LearningActivity.this.mPatternPlaceholder.removeView(patternBaseFragment);
//                    patternBaseFragment.onDetach();
//                    patternBaseFragment.setBackgroundColor(0);
//                    PatternFactory.release(patternBaseFragment);
//                    LearningActivity.this.mKillButton.setOnClickListener(LearningActivity.this);
//                }
//            };
//            if (this.skipPatternAnim) {
//                this.mPatternPlaceholder.post(r12);
//                this.skipPatternAnim = false;
//            } else {
//                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
//                translateAnimation.setDuration(300);
//                translateAnimation.setAnimationListener(new AnimationListener() {
//                    public void onAnimationStart(Animation animation) {
//                        patternBaseFragment.setBackgroundColor(ThemeUtil.getThemeColorWithAttr(LearningActivity.this, R.attr.color_common_bg));
//                    }
//
//                    public void onAnimationEnd(Animation animation) {
//                        LearningActivity.this.mPatternPlaceholder.post(r12);
//                    }
//
//                    public void onAnimationRepeat(Animation animation) {
//                    }
//                });
//                patternBaseFragment.startAnimation(translateAnimation);
//            }
//        }
//        this.mExamplePatternFragment = PatternFactory.obtain(this, this.mCurrentType);
//        this.mPatternPlaceholder.post(new Runnable() {
//            public void run() {
//                LearningActivity.this.mPatternPlaceholder.addView(LearningActivity.this.mExamplePatternFragment, 0);
//                LearningActivity.this.mExamplePatternFragment.onAttach(LearningActivity.this);
//                LearningActivity.this.mExamplePatternFragment.setTopicOptions(indexOf, optionRecords, LearningActivity.this.mAudioPlayer);
//            }
//        });
//        this.mHandler.removeCallbacks(this.mPrepareWikiRunnable);
//        this.mHandler.postDelayed(this.mPrepareWikiRunnable, 1000);
//        checkGuide();
//        updateStatusLine();
//    }
//
//    private void checkGuide() {
//        if (!this.mNeedCheckGuides) {
//            return;
//        }
//        if (GuideFlags.guideEnabled(128) && this.mCurrentType == 1) {
//            GuideFlags.disableGuide(128);
//            SimpleSpannableBuilder simpleSpannableBuilder = new SimpleSpannableBuilder();
//            simpleSpannableBuilder.append(getString(R.string.main_guide_image_option_part1));
//            int themeColorWithAttr = ThemeUtil.getThemeColorWithAttr(this, R.attr.color_progress);
//            simpleSpannableBuilder.append(getString(R.string.main_guide_image_option_part2), new ForegroundColorSpan(themeColorWithAttr));
//            highlightGuideOptions();
//            showBaoGuideDialog(simpleSpannableBuilder.build(), null, null, null, null);
//        } else if (GuideFlags.guideEnabled(256) && this.mCurrentType == 2) {
//            GuideFlags.disableGuide(256);
//            int themeColorWithAttr2 = ThemeUtil.getThemeColorWithAttr(this, R.attr.color_text_blue);
//            SpannableString spannableString = new SpannableString(getString(R.string.main_guide_pattern_2));
//            spannableString.setSpan(new ForegroundColorSpan(themeColorWithAttr2), 2, 5, 33);
//            normalGuideBackground();
//            this.mGuideLayout.setOnTouchListener(this.mGuideDismissListener);
//            showBaoGuideDialog(spannableString, null, null, null, null);
//        } else if (GuideFlags.guideEnabled(GuideFlags.FLAG_PATTERN_3) && this.mCurrentType == 3) {
//            GuideFlags.disableGuide(GuideFlags.FLAG_PATTERN_3);
//            int themeColorWithAttr3 = ThemeUtil.getThemeColorWithAttr(this, R.attr.color_text_blue);
//            SpannableString spannableString2 = new SpannableString(getString(R.string.main_guide_pattern_3));
//            spannableString2.setSpan(new ForegroundColorSpan(themeColorWithAttr3), 2, 5, 33);
//            highlightGuideOptions();
//            showBaoGuideDialog(spannableString2, null, null, null, null);
//        } else if (GuideFlags.guideEnabled(2)) {
//            GuideFlags.disableGuide(2);
//            normalGuideBackground();
//            this.mGuideLayout.setOnTouchListener(this.mGuideDismissListener);
//            showBaoGuideCustomView(R.layout.fragment_guide_wiki_gesture);
//        } else if (GuideFlags.guideEnabled(16) && LearnRecordManager.getInstance().getKillCount() > 0) {
//            GuideFlags.disableGuide(16);
//            normalGuideBackground();
//            this.mGuideLayout.setOnTouchListener(this.mGuideDismissListener);
//            showBaoGuideCustomView(R.layout.fragment_guide_review);
//        } else if (!GuideFlags.guideEnabled(8) || LearnRecordManager.getInstance().getKillCount() != 3) {
//            this.mGuideLayout.setVisibility(8);
//        } else {
//            GuideFlags.disableGuide(8);
//            SimpleSpannableBuilder simpleSpannableBuilder2 = new SimpleSpannableBuilder();
//            int themeColorWithAttr4 = ThemeUtil.getThemeColorWithAttr(this, R.attr.color_text_blue);
//            simpleSpannableBuilder2.append(getString(R.string.main_guide_triple_kill_part1)).append(getString(R.string.main_guide_triple_kill_part2), new ForegroundColorSpan(themeColorWithAttr4)).append(getString(R.string.main_guide_triple_kill_part3));
//            normalGuideBackground();
//            this.mGuideLayout.setOnTouchListener(this.mGuideDismissListener);
//            showBaoGuideDialog(simpleSpannableBuilder2.build(), null, null, null, null);
//        }
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
//            this.skipPatternAnim = true;
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
//    /* access modifiers changed from: private */
//    public boolean trySkipLoading(int i) {
//        ProblemAsset integrityProblemAsset = this.mTopicResourceManager.getIntegrityProblemAsset(i);
//        if (integrityProblemAsset == null) {
//            return false;
//        }
//        this.mCurrentProblem = integrityProblemAsset;
//        exitLoading();
//        return true;
//    }
//
//    private void enterLoading() {
//        this.mHandler.postDelayed(this.mAdvancedCheckingRunnable, 3000);
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
//        this.mWaitingTopicId = 0;
//        this.mHandler.removeCallbacks(this.mAdvancedCheckingRunnable);
//        this.mHandler.removeCallbacks(this.mCancelLoadingRunnable);
//        this.mProgressLayout.setVisibility(4);
//        this.mProgressLayout.setOnClickListener(this);
//    }
//
//    public boolean onAnswer(int i) {
//        boolean z;
//        boolean z2 = i == this.mCurrentTopicId;
//        int i2 = z2 ? R.raw.answer_right : R.raw.answer_error;
//        if (PropertyHelper.getBoolean(PropertyHelper.SOUND_EFFECT, true)) {
//            this.mSoundPool.play(((Integer) this.mSoundMap.get(i2)).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
//        }
//        if (!z2 || !LearnRecordManager.getInstance().isTodayNewLearned(this.mCurrentTopicId) || this.mCurrentType != 1 || this.mHasShowCurrentWiki) {
//            z = false;
//        } else {
//            z = true;
//        }
//        if (!z2) {
//            hintMe(false);
//            this.mHandler.postDelayed(new Runnable() {
//                public void run() {
//                    LearningActivity.this.mExamplePatternFragment.clearOptionMask(false);
//                }
//            }, 500);
//        } else if (z) {
//            this.mHandler.postDelayed(new Runnable() {
//                public void run() {
//                    LearningActivity.this.showWiki(Direction.DOWN, 0);
//                }
//            }, (long) (this.mHasDoneWrong ? 50 : 300));
//        }
//        if (z2) {
//            long elapseTime = elapseTime();
//            if (this.mHasDoneWrong) {
//                LearnRecordManager.getInstance().doneWrong(i, elapseTime);
//                onStatLog(Answer.WRONG, this.mLastWrongOptionId, elapseTime);
//            } else {
//                LearnRecordManager.getInstance().doneCorrect(i, elapseTime);
//                onStatLog(Answer.CORRECT, i, elapseTime);
//                this.mCurrentComboCount = this.mCurrentComboCount >= MAX_COMBO_COUNT ? MAX_COMBO_COUNT : this.mCurrentComboCount + 1;
//                if (this.mCurrentComboCount > this.mMaxComboCount) {
//                    this.mMaxComboCount = this.mCurrentComboCount;
//                }
//                this.mComboPopupWindow.showCombo(this.mPortraitMode ? this.mNewCountTextView : this.mComboCountTextView, this.mCurrentComboCount);
//                this.mHandler.postDelayed(new Runnable() {
//                    public void run() {
//                        if (LearningActivity.this.mComboPopupWindow != null) {
//                            LearningActivity.this.mComboPopupWindow.dismiss();
//                        }
//                    }
//                }, 400);
//            }
//            this.mCurrentAnswer = Answer.CORRECT;
//            if (!z) {
//                tryNextProblem();
//            }
//        } else {
//            this.mHasDoneWrong = true;
//            this.mLastWrongOptionId = i;
//            this.mCurrentComboCount = 0;
//            this.mCurrentAnswer = Answer.WRONG;
//            if (GuideFlags.guideEnabled(64)) {
//                int themeColorWithAttr = ThemeUtil.getThemeColorWithAttr(this, R.attr.color_text_blue);
//                SpannableString spannableString = new SpannableString(getString(R.string.main_guide_done_wrong));
//                spannableString.setSpan(new ForegroundColorSpan(themeColorWithAttr), spannableString.length() - 2, spannableString.length(), 33);
//                this.mGuideLayout.setOnTouchListener(this.mGuideDismissListener);
//                showBaoGuideDialog(spannableString, null, null, null, null);
//                GuideFlags.disableGuide(64);
//            }
//        }
//        return false;
//    }
//
//    public void onHinted() {
//        notifyHint();
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
//        if (GuideFlags.guideEnabled(4)) {
//            showBaoGuideDialog(getString(R.string.main_guide_first_blood), "废话，斩掉!", new OnClickListener() {
//                public void onClick(View view) {
//                    LearningActivity.this.mGuideLayout.setVisibility(4);
//                    GuideFlags.disableGuide(4);
//                    LearningActivity.this.kill();
//                }
//            }, "算了，我手滑", new OnClickListener() {
//                public void onClick(View view) {
//                    LearningActivity.this.mGuideLayout.setVisibility(4);
//                }
//            });
//            this.mGuideLayout.setOnTouchListener(this.mGuideRetainListener);
//            normalGuideBackground();
//            return;
//        }
//        kill();
//    }
//
//    /* access modifiers changed from: private */
//    public void kill() {
//        if (PropertyHelper.getBoolean(PropertyHelper.SOUND_EFFECT, true)) {
//            this.mSoundPool.play(((Integer) this.mSoundMap.get(R.raw.chop)).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
//        }
//        this.mCurrentAnswer = Answer.KILL;
//        long elapseTime = elapseTime();
//        LearnRecordManager.getInstance().kill(this.mCurrentTopicId, elapseTime);
//        onStatLog(this.mCurrentAnswer, -1, elapseTime);
//        this.mKillButton.startAnimation(this.animFadeOut);
//        this.mKillButton.setOnClickListener(null);
//        tryNextProblem();
//    }
//
//    private void onStatLog(Answer answer, int i, long j) {
//        BBDoneWordStatLog bBDoneWordStatLog = new BBDoneWordStatLog();
//        bBDoneWordStatLog.setTopic_id(this.mCurrentTopicId);
//        if (LearnRecordManager.getInstance().isTodayNewLearned(this.mCurrentTopicId)) {
//            bBDoneWordStatLog.setIs_today_new(1);
//        } else {
//            bBDoneWordStatLog.setIs_today_new(0);
//        }
//        bBDoneWordStatLog.setDone_type(this.mCurrentType);
//        if (answer == Answer.KILL) {
//            bBDoneWordStatLog.setOption(-1);
//        } else if (answer == Answer.CORRECT) {
//            bBDoneWordStatLog.setOption(0);
//        } else {
//            bBDoneWordStatLog.setOption(i);
//        }
//        bBDoneWordStatLog.setDuration((int) j);
//        bBDoneWordStatLog.setTag_id(ZPackUtils.getZpkTagIdCompat(this.mCurrentTopic));
//        StudyStats.getsInstance().fillCell(bBDoneWordStatLog);
//    }
//
//    private void updateStatusLine() {
//        this.mHandler.removeCallbacks(this.mUpdateStatusLineRunnable);
//        this.mHandler.postDelayed(this.mUpdateStatusLineRunnable, 500);
//    }
//
//    private void onFinishToday() {
//        boolean z = true;
//        NoticeManager.markNoticedToday(true);
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            startActivity(new Intent(this, DakaActivity.class));
//        }
//        LearnRecordManager instance = LearnRecordManager.getInstance();
//        final BBUserFinishPlanInfo bBUserFinishPlanInfo = new BBUserFinishPlanInfo();
//        bBUserFinishPlanInfo.setBook_id(instance.getBookId());
//        bBUserFinishPlanInfo.setTotal_words_count(instance.getTodayTouchCount());
//        int todayNewLearnedCount = instance.getTodayNewLearnedCount();
//        bBUserFinishPlanInfo.setNew_words_count(todayNewLearnedCount);
//        if (todayNewLearnedCount > 0) {
//            bBUserFinishPlanInfo.setIs_book_finished(false);
//        } else {
//            if (instance.getRemainCount() != 0) {
//                z = false;
//            }
//            bBUserFinishPlanInfo.setIs_book_finished(z);
//        }
//        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public Integer doInBackground(Client client) {
//                return Integer.valueOf(client.finish_plan_notify(bBUserFinishPlanInfo));
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                if (!(exc instanceof C2120g)) {
//                    LogWrapper.m2794e(LearningActivity.TAG, Log.getStackTraceString(exc));
//                }
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Integer num) {
//            }
//        });
//        finish();
//    }
//
//    public void onWikiExit() {
//        hideWiki();
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
