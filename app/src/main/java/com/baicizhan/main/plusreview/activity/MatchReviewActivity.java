//package com.baicizhan.main.plusreview.activity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.p004v4.app.Fragment;
//import android.support.p004v4.app.FragmentActivity;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.AlphaAnimation;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.view.QuizStateProgressBar;
//import com.baicizhan.client.business.view.QuizStateProgressBar.Initializer;
//import com.baicizhan.main.activity.DakaActivity;
//import com.baicizhan.main.plusreview.data.MatchTestCache;
//import com.baicizhan.main.plusreview.data.MatchTestlib;
//import com.baicizhan.main.plusreview.data.MatchTestlib.Word;
//import com.baicizhan.main.plusreview.data.load.MatchTestSyncService;
//import com.baicizhan.main.plusreview.data.p034db.MatchResultRecord;
//import com.baicizhan.main.plusreview.fragment.MatchFragment;
//import com.baicizhan.main.plusreview.fragment.MatchFragment.OnMatchFragmentInteractionListener;
//import com.baicizhan.main.plusreview.fragment.MatchWikiFragment;
//import com.baicizhan.main.plusreview.fragment.MatchWikiFragment.OnWikiFragmentInteractionListener;
//import com.baicizhan.main.resource.ProblemAsset;
//import com.baicizhan.main.resource.TopicResourceManager;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class MatchReviewActivity extends FragmentActivity implements OnClickListener, OnMatchFragmentInteractionListener, OnWikiFragmentInteractionListener {
//    private static final int PRELOAD_THRESHOLD = 3;
//    private static final String TAG = MatchReviewActivity.class.getName();
//    private static final int TEST_DIV_LINE = 10;
//    private BoomRun mBoomRun;
//    private View mBottom;
//    private boolean mCompleted = false;
//    private View mContinue;
//    private int mCurIndex = -1;
//    private ProblemAsset mCurrentProblem;
//    private Handler mHandler = new Handler();
//    private View mHome;
//    /* access modifiers changed from: private */
//    public int mIndex = -1;
//    AuthCallback<ProblemAsset> mObserver = new AuthCallback<ProblemAsset>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(ProblemAsset problemAsset) {
//            if (MatchReviewActivity.this.isLoading() && problemAsset.getId() == MatchReviewActivity.this.mWaitingTopicId) {
//                MatchReviewActivity.this.exitLoading();
//                MatchReviewActivity.this.tryNextProblem();
//            }
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//            Toast.makeText(MatchReviewActivity.this, "网络不畅，加载失败", 0).show();
//            MatchReviewActivity.this.finish();
//        }
//
//        /* access modifiers changed from: protected */
//        public void onProgress(Object obj) {
//            if (MatchReviewActivity.this.mProgressLayout.getVisibility() == 0) {
//                ProblemAsset problemAsset = (ProblemAsset) obj;
//                if (problemAsset.getId() == MatchReviewActivity.this.mWaitingTopicId) {
//                    MatchReviewActivity.this.mProgress.setProgress(problemAsset.getProgress());
//                }
//            }
//        }
//    };
//    private Map<Integer, ProblemAsset> mProblemCache = new HashMap();
//    /* access modifiers changed from: private */
//    public ProgressBar mProgress;
//    /* access modifiers changed from: private */
//    public View mProgressLayout;
//    private View mQAContainer;
//    /* access modifiers changed from: private */
//    public QuizStateProgressBar mQuizProgress;
//    private Map<Integer, MatchResultRecord> mResults;
//    private List<Word> mReviewWords;
//    private boolean mRunning = false;
//    private MatchTestlib mTestlib;
//    private View mTop;
//    private TopicResourceManager mTopicResourceManager;
//    private View mTowiki;
//    /* access modifiers changed from: private */
//    public int mWaitingTopicId;
//    private View mWikiContainer;
//
//    class BoomRun implements Runnable {
//        final WeakReference<MatchReviewActivity> mActivity;
//
//        BoomRun(MatchReviewActivity matchReviewActivity) {
//            this.mActivity = new WeakReference<>(matchReviewActivity);
//        }
//
//        public void run() {
//            MatchReviewActivity matchReviewActivity = (MatchReviewActivity) this.mActivity.get();
//            if (matchReviewActivity != null) {
//                matchReviewActivity.tryNextProblem();
//            }
//        }
//    }
//
//    public static void start(Context context) {
//        context.startActivity(new Intent(context, MatchReviewActivity.class));
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        if (this.mTestlib != null) {
//            MatchTestSyncService.start(this);
//        }
//        System.gc();
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        this.mTestlib = MatchTestCache.getCache().getTestlib();
//        if (this.mTestlib == null) {
//            LogWrapper.m2794e(TAG, TAG + " is recreated and data is lost, finish!");
//            finish();
//        } else if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.plusreview_match);
//            initViews();
//            this.mTopicResourceManager = TopicResourceManager.getInstance();
//            this.mTopicResourceManager.getTopicWaitingHall().setObserver(this.mObserver);
//            this.mReviewWords = this.mTestlib.getReview_words();
//            this.mResults = this.mTestlib.getResult_records();
//            this.mCompleted = offsetIndex();
//            initQuizProgress();
//            this.mBoomRun = new BoomRun(this);
//        }
//    }
//
//    private void initViews() {
//        this.mTop = findViewById(R.id.plusreview_match_top);
//        this.mHome = findViewById(R.id.plusreview_match_home);
//        this.mHome.setOnClickListener(this);
//        this.mQuizProgress = (QuizStateProgressBar) findViewById(R.id.plusereview_match_qsp);
//        this.mBottom = findViewById(R.id.plusreview_match_bottom);
//        this.mContinue = findViewById(R.id.plusreview_match_continue);
//        this.mContinue.setOnClickListener(this);
//        this.mContinue.setVisibility(8);
//        this.mTowiki = findViewById(R.id.plusreview_match_to_wiki);
//        this.mTowiki.setOnClickListener(this);
//        this.mTowiki.setVisibility(8);
//        this.mQAContainer = findViewById(R.id.plusereview_match_qa_container);
//        this.mWikiContainer = findViewById(R.id.plusreview_match_wiki_container);
//        this.mWikiContainer.setOnClickListener(this);
//        this.mProgressLayout = findViewById(R.id.plusreview_match_progress_layout);
//        this.mProgressLayout.setOnClickListener(this);
//        this.mProgress = (ProgressBar) findViewById(R.id.plusreview_match_progress);
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
//    private void showOrHideContent(boolean z) {
//        int i;
//        AlphaAnimation alphaAnimation;
//        AlphaAnimation alphaAnimation2;
//        int i2 = 0;
//        this.mTop.setVisibility(z ? 0 : 4);
//        View view = this.mBottom;
//        if (z) {
//            i = 0;
//        } else {
//            i = 4;
//        }
//        view.setVisibility(i);
//        View view2 = this.mQAContainer;
//        if (!z) {
//            i2 = 4;
//        }
//        view2.setVisibility(i2);
//        AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 1.0f);
//        alphaAnimation3.setDuration(300);
//        AlphaAnimation alphaAnimation4 = new AlphaAnimation(1.0f, 0.0f);
//        alphaAnimation4.setDuration(300);
//        View view3 = this.mTop;
//        if (z) {
//            alphaAnimation = alphaAnimation3;
//        } else {
//            alphaAnimation = alphaAnimation4;
//        }
//        view3.startAnimation(alphaAnimation);
//        View view4 = this.mBottom;
//        if (z) {
//            alphaAnimation2 = alphaAnimation3;
//        } else {
//            alphaAnimation2 = alphaAnimation4;
//        }
//        view4.startAnimation(alphaAnimation2);
//        View view5 = this.mQAContainer;
//        if (!z) {
//            alphaAnimation3 = alphaAnimation4;
//        }
//        view5.startAnimation(alphaAnimation3);
//    }
//
//    public void onClick(View view) {
//        if (view == this.mContinue) {
//            this.mQuizProgress.postDelayed(new Runnable() {
//                public void run() {
//                    MatchReviewActivity.this.mQuizProgress.setCursor(MatchReviewActivity.this.mIndex);
//                }
//            }, 400);
//            tryNextProblem();
//            OperationStats.statMoreReviewDapei();
//        } else if (view == this.mTowiki) {
//            showOrHideContent(false);
//            this.mWikiContainer.setVisibility(0);
//            getSupportFragmentManager().mo313a().mo178a((int) R.anim.business_push_down_in, (int) R.anim.business_push_down_out).mo179a((int) R.id.plusreview_match_wiki_container, (Fragment) MatchWikiFragment.newInstance(this.mCurIndex)).mo186c();
//        } else if (view == this.mHome) {
//            finish();
//        }
//    }
//
//    private void initQuizProgress() {
//        int size = this.mReviewWords.size();
//        int[] iArr = new int[size];
//        for (int i = 0; i < size; i++) {
//            switch (((MatchResultRecord) this.mResults.get(Integer.valueOf(((Word) this.mReviewWords.get(i)).getWord_topic_id()))).getResult()) {
//                case -1:
//                    iArr[i] = 0;
//                    break;
//                case 1:
//                    iArr[i] = 1;
//                    break;
//                default:
//                    iArr[i] = -1;
//                    break;
//            }
//        }
//        new Initializer().wrap(this.mQuizProgress).setCursorIndex(this.mIndex).setStates(iArr).initialize();
//    }
//
//    private boolean offsetIndex() {
//        boolean z;
//        boolean z2;
//        boolean z3;
//        int size = this.mReviewWords.size();
//        int min = Math.min(10, size);
//        int i = 0;
//        while (true) {
//            if (i >= min) {
//                z = true;
//                break;
//            }
//            if (((MatchResultRecord) this.mResults.get(Integer.valueOf(((Word) this.mReviewWords.get(i)).getWord_topic_id()))).getResult() != 1) {
//                z = false;
//                break;
//            }
//            i++;
//        }
//        if (this.mIndex >= min - 1 && !z) {
//            this.mIndex = -1;
//        } else if (this.mIndex >= size - 1) {
//            this.mIndex = min - 1;
//        }
//        int i2 = this.mIndex + 1;
//        while (true) {
//            if (i2 >= size) {
//                z2 = false;
//                break;
//            }
//            if (((MatchResultRecord) this.mResults.get(Integer.valueOf(((Word) this.mReviewWords.get(i2)).getWord_topic_id()))).getResult() != 1) {
//                this.mIndex = i2;
//                z2 = true;
//                break;
//            }
//            i2++;
//        }
//        if (!z2) {
//            int i3 = 0;
//            while (true) {
//                if (i3 >= size) {
//                    break;
//                }
//                if (((MatchResultRecord) this.mResults.get(Integer.valueOf(((Word) this.mReviewWords.get(i3)).getWord_topic_id()))).getResult() != 1) {
//                    this.mIndex = i3;
//                    z3 = true;
//                    break;
//                }
//                i3++;
//            }
//        }
//        z3 = z2;
//        if (!z3) {
//            return true;
//        }
//        return false;
//    }
//
//    private void checkPreload() {
//        if (this.mTopicResourceManager.getTopicWaitingHall().getTotalWaiterCount() <= 3) {
//            this.mTopicResourceManager.loadNextProblems(this, this.mTestlib.getUnfinishedTopicIds(this.mTestlib.getReview_words().size()), true);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void tryNextProblem() {
//        this.mCurIndex = this.mIndex;
//        if (this.mCompleted) {
//            onFinishToday();
//            return;
//        }
//        checkPreload();
//        this.mCurrentProblem = this.mTopicResourceManager.getTopicWaitingHall().tryCheckOut(((Word) this.mReviewWords.get(this.mIndex)).getWord_topic_id());
//        if (this.mCurrentProblem == null) {
//            this.mCurrentProblem = (ProblemAsset) this.mProblemCache.get(Integer.valueOf(this.mIndex));
//        }
//        if (this.mCurrentProblem == null) {
//            this.mWaitingTopicId = ((Word) this.mReviewWords.get(this.mIndex)).getWord_topic_id();
//            enterLoading();
//            return;
//        }
//        this.mProblemCache.put(Integer.valueOf(this.mIndex), this.mCurrentProblem);
//        exitLoading();
//        nextProblem();
//    }
//
//    private void onFinishToday() {
//        daka();
//        finish();
//    }
//
//    private void daka() {
//        startActivity(new Intent(this, DakaActivity.class));
//    }
//
//    private void nextProblem() {
//        this.mContinue.setVisibility(8);
//        this.mTowiki.setVisibility(8);
//        MatchTestCache.getCache().setTopicRecord(this.mCurrentProblem.getPrimary());
//        getSupportFragmentManager().mo313a().mo178a(17432576, (int) R.anim.business_push_right_out).mo184b(R.id.plusereview_match_qa_container, MatchFragment.newInstance(this.mIndex)).mo186c();
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
//    public void onAnswer(boolean z, int i) {
//        MatchResultRecord matchResultRecord;
//        int i2 = 1;
//        int word_topic_id = ((Word) this.mReviewWords.get(i)).getWord_topic_id();
//        MatchResultRecord matchResultRecord2 = (MatchResultRecord) this.mResults.get(Integer.valueOf(word_topic_id));
//        if (matchResultRecord2 == null) {
//            MatchResultRecord matchResultRecord3 = new MatchResultRecord();
//            matchResultRecord3.setTopicId(word_topic_id);
//            this.mResults.put(Integer.valueOf(word_topic_id), matchResultRecord3);
//            matchResultRecord = matchResultRecord3;
//        } else {
//            matchResultRecord = matchResultRecord2;
//        }
//        matchResultRecord.setResult(z ? 1 : -1);
//        this.mIndex = i;
//        QuizStateProgressBar quizStateProgressBar = this.mQuizProgress;
//        if (!z) {
//            i2 = 0;
//        }
//        quizStateProgressBar.setState(i, i2);
//        this.mCompleted = offsetIndex();
//        this.mContinue.setVisibility(0);
//        this.mTowiki.setVisibility(0);
//    }
//
//    public void onMatchDetach() {
//    }
//
//    public void onWikiAttach() {
//        showOrHideContent(false);
//    }
//
//    public void onContinue(Fragment fragment) {
//        getSupportFragmentManager().mo313a().mo178a((int) R.anim.business_push_down_in, (int) R.anim.business_push_down_out).mo181a(fragment).mo186c();
//    }
//
//    public void onWikiDetach() {
//        this.mWikiContainer.setVisibility(8);
//        showOrHideContent(true);
//    }
//}
