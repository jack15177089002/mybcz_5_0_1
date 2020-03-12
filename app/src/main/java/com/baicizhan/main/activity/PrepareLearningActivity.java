//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.download_service.DownloadService;
//import com.baicizhan.client.business.managers.AdLoader;
//import com.baicizhan.client.business.managers.AdLoader.AdLoaderListener;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.DeviceUtil;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.main.fragment.PatternFactory;
//import com.baicizhan.main.resource.ProblemAsset;
//import com.baicizhan.main.resource.TopicResourceManager;
//import com.baicizhan.main.utils.ResidentBitmapCache;
//import com.baicizhan.store.StoreItemDetailActivity;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//
//public class PrepareLearningActivity extends Activity {
//    private static final int MAX_PRELOAD_COUNT = 2;
//    static final String TAG = PrepareLearningActivity.class.getSimpleName();
//    /* access modifiers changed from: private */
//    public boolean mAdLoaded = false;
//    private AdLoader mAdLoader;
//    AuthCallback<ProblemAsset> mObserver = new AuthCallback<ProblemAsset>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(ProblemAsset problemAsset) {
//            Log.d(PrepareLearningActivity.TAG, "+++ onPrepare " + problemAsset.getId());
//            PrepareLearningActivity.this.checkPrepared();
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//            if (!PrepareLearningActivity.this.isFinishing()) {
//                Toast.makeText(PrepareLearningActivity.this, "下载失败，请稍后重试", 0).show();
//            }
//            PrepareLearningActivity.this.finish();
//        }
//
//        /* access modifiers changed from: protected */
//        public void onProgress(Object obj) {
//        }
//    };
//    private int mPreloadCount = 2;
//    private TopicResourceManager mTopicResourceManager;
//
//    class AdLoadCallback implements AdLoaderListener {
//        private final WeakReference<PrepareLearningActivity> mActivity;
//
//        private AdLoadCallback(PrepareLearningActivity prepareLearningActivity) {
//            this.mActivity = new WeakReference<>(prepareLearningActivity);
//        }
//
//        public void onAdLoaded() {
//            PrepareLearningActivity prepareLearningActivity = (PrepareLearningActivity) this.mActivity.get();
//            if (prepareLearningActivity != null) {
//                prepareLearningActivity.mAdLoaded = true;
//                prepareLearningActivity.checkPrepared();
//            }
//        }
//
//        public Intent getNativeStoreIntent(String str) {
//            PrepareLearningActivity prepareLearningActivity = (PrepareLearningActivity) this.mActivity.get();
//            if (prepareLearningActivity == null) {
//                return null;
//            }
//            return StoreItemDetailActivity.getStartIntent(prepareLearningActivity, str);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setVolumeControlStream(3);
//            if (StudyManager.getInstance().getLearningManager() == null) {
//                finish();
//                return;
//            }
//            setContentView(R.layout.advertisement_layout);
//            this.mAdLoader = AdLoader.createLoader(this, null).setListener(new AdLoadCallback());
//            UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//            if (currentUser != null && currentUser.getIsNewUser() > 0) {
//                this.mAdLoader.skipAd(true);
//            }
//            this.mAdLoader.load();
//            this.mTopicResourceManager = TopicResourceManager.getInstance();
//            this.mTopicResourceManager.getTopicWaitingHall().clearup();
//            this.mTopicResourceManager.getTopicWaitingHall().setObserver(this.mObserver);
//            PatternFactory.clear();
//            findViewById(R.id.ad_content).post(new Runnable() {
//                public void run() {
//                    PrepareLearningActivity.this.prepareDownload();
//                    PrepareLearningActivity.this.startLoad();
//                    PrepareLearningActivity prepareLearningActivity = PrepareLearningActivity.this;
//                    PatternFactory.reserve(prepareLearningActivity, 1, 2);
//                    PatternFactory.reserve(prepareLearningActivity, 2, 2);
//                    PatternFactory.reserve(prepareLearningActivity, 3, 2);
//                    ResidentBitmapCache.preload(prepareLearningActivity, ResidentBitmapCache.LEARN_RESIDENT_RESOURCES);
//                }
//            });
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
//    public void onDestroy() {
//        super.onDestroy();
//        PatternFactory.clear();
//        this.mAdLoader.cancel();
//    }
//
//    /* access modifiers changed from: private */
//    public void prepareDownload() {
//        int i = 3;
//        int deviceTotalMemoryGigaBytes = DeviceUtil.getDeviceTotalMemoryGigaBytes(this);
//        if (deviceTotalMemoryGigaBytes <= 3) {
//            i = deviceTotalMemoryGigaBytes;
//        }
//        if (i <= 0) {
//            i = 1;
//        }
//        LogWrapper.m2793d(TAG, "adjustPoolSize " + i);
//        DownloadService.getInstance().adjustPoolSize(i);
//    }
//
//    /* access modifiers changed from: private */
//    public void startLoad() {
//        this.mPreloadCount = this.mTopicResourceManager.loadNextProblems(this, StudyManager.getInstance().getLearningManager(), 2, false);
//    }
//
//    /* access modifiers changed from: private */
//    public void checkPrepared() {
//        if (this.mTopicResourceManager.getTopicWaitingHall().getReadyWaiterCount() >= this.mPreloadCount && this.mAdLoaded && !isFinishing()) {
//            LogWrapper.m2793d(TAG, "checkPrepared start learning");
//            this.mTopicResourceManager.getTopicWaitingHall().setObserver(null);
//            startActivity(new Intent(this, LearningActivity.class));
//            finish();
//        }
//    }
//}
