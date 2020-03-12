//package com.baicizhan.main.wordlist.activity;
//
//import android.annotation.TargetApi;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Build.VERSION;
//import android.os.Bundle;
//import android.support.p004v4.app.Fragment;
//import android.support.p004v4.app.FragmentActivity;
//import android.view.View;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask.Listener;
//import com.baicizhan.client.business.managers.AdLoader;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.main.fragment.WikiFragment;
//import com.baicizhan.main.fragment.WikiFragment.WikiListener;
//import com.baicizhan.main.resource.TopicResourceManager;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//
//public class WordListWikiActivity extends FragmentActivity {
//    private static final String EXTRA_WORD_ID = "word_id";
//    private static final String TAG = WordListWikiActivity.class.getName();
//    /* access modifiers changed from: private */
//    public AdLoader mAdLoader;
//    private TopicGetCallback mCallback;
//    /* access modifiers changed from: private */
//    public TopicRecord mTopicRecord;
//    private View mWikiAll;
//    /* access modifiers changed from: private */
//    public int mWordId;
//
//    class TopicGetCallback implements Listener {
//        final WeakReference<WordListWikiActivity> mActivity;
//
//        TopicGetCallback(WordListWikiActivity wordListWikiActivity) {
//            this.mActivity = new WeakReference<>(wordListWikiActivity);
//        }
//
//        public void onSuccess(AbstractDownloadTask abstractDownloadTask) {
//            WordListWikiActivity wordListWikiActivity = (WordListWikiActivity) this.mActivity.get();
//            if (wordListWikiActivity != null) {
//                wordListWikiActivity.mTopicRecord = TopicResourceManager.getInstance().getIntegratedTopicRecord(wordListWikiActivity.mWordId);
//                if (wordListWikiActivity.mTopicRecord == null) {
//                    wordListWikiActivity.finish();
//                } else if (!wordListWikiActivity.isDead()) {
//                    wordListWikiActivity.mAdLoader.gone();
//                    wordListWikiActivity.showWiki();
//                }
//            }
//        }
//
//        public void onError(AbstractDownloadTask abstractDownloadTask, Throwable th) {
//            WordListWikiActivity wordListWikiActivity = (WordListWikiActivity) this.mActivity.get();
//            if (wordListWikiActivity != null) {
//                wordListWikiActivity.finish();
//            }
//        }
//    }
//
//    public static void start(Context context, int i) {
//        Intent intent = new Intent(context, WordListWikiActivity.class);
//        intent.putExtra("word_id", i);
//        context.startActivity(intent);
//    }
//
//    public void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        bundle.putBoolean(ConstantsUtil.STATE_EXIT_FOR_RECREATE, true);
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        getWindow().setFormat(-3);
//        if (!tryFinishSelf(bundle)) {
//            ThemeUtil.setThemeOnActivityCreate(this);
//            this.mWordId = getIntent().getIntExtra("word_id", -1);
//            if (this.mWordId < 0) {
//                finish();
//                return;
//            }
//            overridePendingTransition(R.anim.business_push_down_in, R.anim.business_push_down_out);
//            setContentView(R.layout.wordlist_wiki);
//            initViews();
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
//    private void initViews() {
//        this.mWikiAll = findViewById(R.id.wordlist_wiki_all);
//        this.mAdLoader = AdLoader.createLoader(this, this.mWikiAll).skipAd(true);
//        this.mTopicRecord = TopicResourceManager.getInstance().getIntegratedTopicRecord(this.mWordId);
//        if (this.mTopicRecord == null) {
//            this.mAdLoader.enableFadeout(true).load();
//            this.mCallback = new TopicGetCallback(this);
//            TopicResourceManager.getInstance().downloadTopic(this.mWordId, this.mCallback);
//            return;
//        }
//        this.mAdLoader.gone();
//        showWiki();
//    }
//
//    /* access modifiers changed from: private */
//    public void showWiki() {
//        WikiFragment instance = WikiFragment.getInstance(this.mTopicRecord, 7);
//        instance.setWikiListener(new WikiListener() {
//            public void onWikiExit() {
//                WordListWikiActivity.this.finish();
//            }
//        });
//        getSupportFragmentManager().mo313a().mo179a((int) R.id.wordlist_wiki_container, (Fragment) instance).mo186c();
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
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.business_push_down_in, R.anim.business_push_down_out);
//    }
//
//    /* access modifiers changed from: private */
//    public boolean isDead() {
//        if (VERSION.SDK_INT >= 17) {
//            return isDead_API17();
//        }
//        return isDead_normal();
//    }
//
//    @TargetApi(17)
//    private boolean isDead_API17() {
//        return isDestroyed() || isFinishing();
//    }
//
//    private boolean isDead_normal() {
//        return isFinishing();
//    }
//}
