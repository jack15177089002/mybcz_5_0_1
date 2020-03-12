//package com.baicizhan.main.plusreview.activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.managers.AdLoader;
//import com.baicizhan.client.business.managers.AdLoader.AdLoaderListener;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.iface.LearningManager;
//import com.baicizhan.main.plusreview.data.MatchTestCache;
//import com.baicizhan.main.plusreview.data.MatchTestlib;
//import com.baicizhan.main.plusreview.data.RecognitionCache;
//import com.baicizhan.main.plusreview.data.RecognitionData;
//import com.baicizhan.main.plusreview.data.load.MatchTestLoader;
//import com.baicizhan.main.plusreview.data.load.MatchTestLoader.OnDownloadListener;
//import com.baicizhan.main.plusreview.data.load.RecognitionLoader;
//import com.baicizhan.main.plusreview.data.load.RecognitionLoader.RecognitionLoadListener;
//import com.baicizhan.main.resource.ProblemAsset;
//import com.baicizhan.main.resource.TopicResourceManager;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.main.utils.ResidentBitmapCache;
//import com.baicizhan.store.StoreItemDetailActivity;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class DefaultPreloadActivity extends Activity implements OnDownloadListener, RecognitionLoadListener {
//    private static final String EXTRA_TYPE = "type";
//    private static final int MAX_PRELOAD_COUNT = 3;
//    private static final int RECG_PRELOAD_COUNT = 5;
//    static final String TAG = DefaultPreloadActivity.class.getSimpleName();
//    private AdLoadCallback mAdLoadCallback;
//    /* access modifiers changed from: private */
//    public boolean mAdLoaded = false;
//    private AdLoader mAdLoader;
//    private MatchTestLoader mMatchTestLoader;
//    AuthCallback<ProblemAsset> mObserver = new AuthCallback<ProblemAsset>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(ProblemAsset problemAsset) {
//            Log.d("CommonPreloadActivity", "onSuccess " + problemAsset);
//            DefaultPreloadActivity.this.checkPrepared();
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//        }
//
//        /* access modifiers changed from: protected */
//        public void onProgress(Object obj) {
//        }
//    };
//    private int mPreloadCount = 3;
//    private RecognitionLoader mRecognitionLoader;
//    private TopicResourceManager mTopicResourceManager;
//    private int mType;
//
//    class AdLoadCallback implements AdLoaderListener {
//        private final WeakReference<DefaultPreloadActivity> mActivity;
//
//        private AdLoadCallback(DefaultPreloadActivity defaultPreloadActivity) {
//            this.mActivity = new WeakReference<>(defaultPreloadActivity);
//        }
//
//        public void onAdLoaded() {
//            DefaultPreloadActivity defaultPreloadActivity = (DefaultPreloadActivity) this.mActivity.get();
//            if (defaultPreloadActivity != null) {
//                defaultPreloadActivity.mAdLoaded = true;
//                defaultPreloadActivity.checkPrepared();
//            }
//        }
//
//        public Intent getNativeStoreIntent(String str) {
//            DefaultPreloadActivity defaultPreloadActivity = (DefaultPreloadActivity) this.mActivity.get();
//            if (defaultPreloadActivity == null) {
//                return null;
//            }
//            return StoreItemDetailActivity.getStartIntent(defaultPreloadActivity, str);
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
//    public static final boolean startMatch(Context context) {
//        return start(context, 7);
//    }
//
//    private static final boolean start(Context context, int i) {
//        if (i != 4 && i != 5 && i != 6 && i != 7) {
//            return false;
//        }
//        Intent intent = new Intent(context, DefaultPreloadActivity.class);
//        intent.putExtra("type", i);
//        context.startActivity(intent);
//        return true;
//    }
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setVolumeControlStream(3);
//            setContentView(R.layout.advertisement_layout);
//            this.mAdLoadCallback = new AdLoadCallback();
//            this.mAdLoader = AdLoader.createLoader(this, null).setListener(this.mAdLoadCallback);
//            UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//            if (currentUser != null && currentUser.getIsNewUser() > 0) {
//                this.mAdLoader.skipAd(true);
//            }
//            this.mAdLoader.load();
//            this.mTopicResourceManager = TopicResourceManager.getInstance();
//            this.mTopicResourceManager.getTopicWaitingHall().clearup();
//            this.mTopicResourceManager.getTopicWaitingHall().setObserver(this.mObserver);
//            startLoad();
//            ResidentBitmapCache.preload(this, ResidentBitmapCache.LEARN_RESIDENT_RESOURCES);
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
//    private void startLoad() {
//        this.mType = getIntent().getIntExtra("type", -1);
//        if (7 == this.mType) {
//            this.mMatchTestLoader = MatchTestLoader.createInstance((Context) this, (OnDownloadListener) this);
//            this.mMatchTestLoader.load();
//        } else if (5 == this.mType) {
//            StudyManager.getInstance().addRefreshRequestFlag(8);
//            LearningManager learningManager = StudyManager.getInstance().getLearningManager();
//            if (learningManager == null) {
//                finishOnStudyDataError();
//                return;
//            }
//            learningManager.setSequenceModeReviewMore(50, ConstantsUtil.REVIEW_MORE_EXTRA_ARGS);
//            List<ProblemProxy> next = learningManager.getSequenceStrategy().getNext(0, 50);
//            ArrayList arrayList = new ArrayList();
//            for (ProblemProxy id : next) {
//                arrayList.add(Integer.valueOf(id.getId()));
//            }
//            this.mRecognitionLoader = RecognitionLoader.createInstance(this, this, 5);
//            this.mRecognitionLoader.load(arrayList);
//        } else {
//            StudyManager.getInstance().addRefreshRequestFlag(8);
//            LearningManager learningManager2 = StudyManager.getInstance().getLearningManager();
//            if (learningManager2 == null) {
//                finishOnStudyDataError();
//                return;
//            }
//            learningManager2.setSequenceModeReviewMore(50, ConstantsUtil.REVIEW_MORE_EXTRA_ARGS);
//            this.mPreloadCount = this.mTopicResourceManager.loadNextProblems(this, learningManager2, 3, true);
//            processNoneWord();
//        }
//    }
//
//    private void finishOnStudyDataError() {
//        CommonUtils.toastStudyDataError(this);
//        finish();
//    }
//
//    /* access modifiers changed from: private */
//    public void checkPrepared() {
//        processNoneWord();
//        Log.d("CommonPreloadActivity", "ready count " + this.mTopicResourceManager.getTopicWaitingHall().getReadyWaiterCount());
//        if (this.mTopicResourceManager.getTopicWaitingHall().getReadyWaiterCount() >= this.mPreloadCount && this.mAdLoaded && !isFinishing()) {
//            this.mTopicResourceManager.getTopicWaitingHall().setObserver(null);
//            switch (this.mType) {
//                case 4:
//                    goListen();
//                    break;
//                case 5:
//                    goRead();
//                    break;
//                case 6:
//                    goWrite();
//                    break;
//                case 7:
//                    goMatch();
//                    break;
//            }
//            finish();
//        }
//    }
//
//    private void processNoneWord() {
//        if (this.mPreloadCount <= 0) {
//            Toast.makeText(this, R.string.no_word, 0).show();
//            finish();
//        }
//    }
//
//    private void goListen() {
//        DefaultReviewActivity.startListen(this);
//    }
//
//    private void goRead() {
//        DefaultReviewActivity.startRead(this);
//    }
//
//    private void goWrite() {
//        DefaultReviewActivity.startWrite(this);
//    }
//
//    private void goMatch() {
//        MatchReviewActivity.start(this);
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        if (this.mMatchTestLoader != null) {
//            this.mMatchTestLoader.destroy();
//        }
//        if (this.mRecognitionLoader != null) {
//            this.mRecognitionLoader.destroy();
//        }
//        this.mAdLoader.cancel();
//    }
//
//    public void onTestlibLoaded(boolean z, MatchTestlib matchTestlib, int i) {
//        String string;
//        if (z) {
//            MatchTestCache.getCache().setTestlib(matchTestlib);
//            Log.d("whiz", "loaded match test data: " + matchTestlib);
//            this.mTopicResourceManager.loadNextProblems(this, matchTestlib.getUnfinishedTopicIds(4), true);
//            this.mPreloadCount = 4;
//            return;
//        }
//        switch (i) {
//            case -2:
//                string = getString(R.string.plusreview_match_review_not_enough);
//                break;
//            case -1:
//                string = getString(R.string.plusreview_match_review_net_err);
//                break;
//            default:
//                string = getString(R.string.plusreview_match_review_unkonwn_err);
//                break;
//        }
//        Toast.makeText(this, string, 0).show();
//        finish();
//    }
//
//    public void onLoaded(boolean z, int i, Map<Integer, RecognitionData> map) {
//        if (z) {
//            RecognitionCache.getCache().setDatas(map);
//        }
//        Log.d("whiz", "recog load result: " + z + "; code: " + i + "; datas: " + map);
//        this.mPreloadCount = this.mTopicResourceManager.loadNextProblems(this, StudyManager.getInstance().getLearningManager(), 3, true);
//        processNoneWord();
//    }
//}
