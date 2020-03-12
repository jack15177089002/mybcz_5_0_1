//package com.baicizhan.client.wordtesting.activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Process;
//import com.baicizhan.client.business.book.Book;
//import com.baicizhan.client.business.book.BookGetter;
//import com.baicizhan.client.business.book.BookGetter.onGetBookListener;
//import com.baicizhan.client.wordtesting.C0933R;
//import com.baicizhan.client.wordtesting.bean.VocabStats;
//import com.baicizhan.client.wordtesting.load.Script;
//import com.baicizhan.client.wordtesting.user.User;
//import com.baicizhan.client.wordtesting.view.VocabStatsView;
//import com.baicizhan.client.wordtesting.vocabstats.VocabStatsGetter;
//import com.baicizhan.client.wordtesting.vocabstats.VocabStatsGetter.OnGetVocabStatsListener;
//import com.umeng.p092a.MobclickAgent;
//import java.lang.ref.WeakReference;
//
//public class VocabStatsActivity extends Activity implements onGetBookListener, OnGetVocabStatsListener {
//    public static final String EXTRA_FROM_RESULT = "from_result";
//    public static final String EXTRA_USER = "user";
//    public static final int STATE_FAILED = 2;
//    public static final int STATE_NONE = 0;
//    public static final int STATE_SUCCESS = 1;
//    private boolean mBackPressed = false;
//    /* access modifiers changed from: private */
//    public Book mBook;
//    private boolean mFromResult = false;
//    private Handler mHandler = new Handler();
//    /* access modifiers changed from: private */
//    public int mState = 0;
//    /* access modifiers changed from: private */
//    public VocabStats mStats;
//    private User mUser;
//    /* access modifiers changed from: private */
//    public VocabStatsView mVocabStatsView;
//
//    class PresentRun implements Runnable {
//        final WeakReference<VocabStatsActivity> mActivity;
//
//        PresentRun(VocabStatsActivity vocabStatsActivity) {
//            this.mActivity = new WeakReference<>(vocabStatsActivity);
//        }
//
//        public void run() {
//            VocabStatsActivity vocabStatsActivity = (VocabStatsActivity) this.mActivity.get();
//            if (vocabStatsActivity != null) {
//                vocabStatsActivity.mVocabStatsView.present(vocabStatsActivity.mStats, vocabStatsActivity.mBook);
//            }
//        }
//    }
//
//    class ShowFailedRun implements Runnable {
//        final WeakReference<VocabStatsActivity> mActivity;
//        final VocabStats mVocabStats;
//
//        ShowFailedRun(VocabStatsActivity vocabStatsActivity, VocabStats vocabStats) {
//            this.mActivity = new WeakReference<>(vocabStatsActivity);
//            this.mVocabStats = vocabStats;
//        }
//
//        public void run() {
//            VocabStatsActivity vocabStatsActivity = (VocabStatsActivity) this.mActivity.get();
//            if (vocabStatsActivity != null) {
//                if (this.mVocabStats == null || this.mVocabStats.getError() == null || -9 != this.mVocabStats.getError().getCode()) {
//                    vocabStatsActivity.mVocabStatsView.showTip(C0933R.string.wordtesting_stats_toast_loading_failed, 0, true);
//                } else {
//                    vocabStatsActivity.mVocabStatsView.showTip(C0933R.string.wordtesting_stats_toast_loading_failed_4_null_data, 0, true);
//                }
//            }
//        }
//    }
//
//    class ShowLoadingRun implements Runnable {
//        final WeakReference<VocabStatsActivity> mActivity;
//
//        ShowLoadingRun(VocabStatsActivity vocabStatsActivity) {
//            this.mActivity = new WeakReference<>(vocabStatsActivity);
//        }
//
//        public void run() {
//            VocabStatsActivity vocabStatsActivity = (VocabStatsActivity) this.mActivity.get();
//            if (vocabStatsActivity != null && vocabStatsActivity.mState == 0) {
//                vocabStatsActivity.mVocabStatsView.showTip(C0933R.string.wordtesting_stats_toast_loading, 0, false);
//            }
//        }
//    }
//
//    class VocabStatsGetRun implements Runnable {
//        final WeakReference<VocabStatsActivity> mActivity;
//
//        VocabStatsGetRun(VocabStatsActivity vocabStatsActivity) {
//            this.mActivity = new WeakReference<>(vocabStatsActivity);
//        }
//
//        public void run() {
//            VocabStatsActivity vocabStatsActivity = (VocabStatsActivity) this.mActivity.get();
//            if (vocabStatsActivity != null) {
//                new BookGetter().asyncGet(vocabStatsActivity);
//            }
//        }
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        this.mFromResult = getIntent().getBooleanExtra(EXTRA_FROM_RESULT, false);
//        this.mUser = (User) getIntent().getParcelableExtra(EXTRA_USER);
//        setContentView(C0933R.layout.wordtesting_stats);
//        this.mVocabStatsView = (VocabStatsView) findViewById(C0933R.C0934id.wordtesting_vocab_stats);
//        this.mVocabStatsView.setFromResult(this.mFromResult);
//        this.mVocabStatsView.setUser(this.mUser);
//        this.mHandler.postDelayed(new VocabStatsGetRun(this), 0);
//        this.mHandler.postDelayed(new ShowLoadingRun(this), 0);
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        this.mHandler.removeCallbacksAndMessages(null);
//        this.mVocabStatsView.destroy();
//        if (this.mVocabStatsView.isLoading() && !this.mFromResult) {
//            Process.killProcess(Process.myPid());
//        } else if (this.mBackPressed && this.mFromResult) {
//            Script.getInstance().destroy();
//            Process.killProcess(Process.myPid());
//        }
//    }
//
//    public void onResume() {
//        super.onResume();
//        MobclickAgent.m5136b((Context) this);
//    }
//
//    public void onPause() {
//        super.onPause();
//        MobclickAgent.m5132a((Context) this);
//    }
//
//    public void onBackPressed() {
//        super.onBackPressed();
//        if (this.mFromResult) {
//            setResult(-1, null);
//        }
//        this.mBackPressed = true;
//        this.mVocabStatsView.release();
//    }
//
//    public void onGetBook(Book book) {
//        this.mBook = book;
//        new VocabStatsGetter().asyncGet(this);
//    }
//
//    public void onGetVocabStats(VocabStats vocabStats) {
//        if (vocabStats == null || !vocabStats.isValid()) {
//            this.mVocabStatsView.hideTip(0);
//            this.mHandler.postDelayed(new ShowFailedRun(this, vocabStats), 2000);
//            this.mState = 2;
//            return;
//        }
//        this.mVocabStatsView.hideTip(0);
//        this.mStats = vocabStats;
//        this.mHandler.postDelayed(new PresentRun(this), 0);
//        this.mState = 1;
//    }
//
//    public int getState() {
//        return this.mState;
//    }
//
//    public void finish(boolean z) {
//        this.mBackPressed = z;
//        super.finish();
//    }
//}
