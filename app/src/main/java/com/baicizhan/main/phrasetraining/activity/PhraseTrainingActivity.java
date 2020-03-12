//package com.baicizhan.main.phrasetraining.activity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.p004v4.app.Fragment;
//import android.support.p004v4.app.FragmentActivity;
//import android.support.p004v4.app.FragmentTransaction;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.main.phrasetraining.data.Pattern;
//import com.baicizhan.main.phrasetraining.data.bean.Phrase;
//import com.baicizhan.main.phrasetraining.data.bean.PhraseGroup;
//import com.baicizhan.main.phrasetraining.data.bean.TopicPatterns;
//import com.baicizhan.main.phrasetraining.data.bean.TopicPatterns.Topic;
//import com.baicizhan.main.phrasetraining.data.load.SinglePhraseLoader;
//import com.baicizhan.main.phrasetraining.data.load.SinglePhraseLoader.Builder;
//import com.baicizhan.main.phrasetraining.data.load.SinglePhraseLoader.OnPhraseLoadListener;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class PhraseTrainingActivity extends FragmentActivity implements OnTrainingFragmentInteractionListener, OnPhraseLoadListener {
//    private static final String ARG_CUR_GROUP_INDEX = "cur_group_index";
//    private static final String ARG_GROUPS = "groups";
//    private static final String TAG = PhraseTrainingActivity.class.getName();
//    int mCurGroup;
//    int mCurGroupIndex;
//    private int mCurPhraseIndex;
//    Topic mCurTopic;
//    private boolean mDataPrepared = false;
//    private DelayLoadProgressRun mDelayLoadProgressRun;
//    private boolean mFinishSelf = false;
//    List<PhraseGroup> mGroupPhrases;
//    private ArrayList<Integer> mGroups;
//    private Handler mHandler = new Handler();
//    private View mHome;
//    /* access modifiers changed from: private */
//    public ProgressBar mLoadProgress;
//    private SinglePhraseLoader mLoader;
//    Map<Integer, Phrase> mPhrases;
//    AudioPlayer mPlayer;
//    private ProgressBar mProgress;
//    private TopicPatterns mTopicPatterns;
//    private int mTotalPhrases;
//
//    class DelayLoadProgressRun implements Runnable {
//        final WeakReference<PhraseTrainingActivity> mActivity;
//
//        DelayLoadProgressRun(PhraseTrainingActivity phraseTrainingActivity) {
//            this.mActivity = new WeakReference<>(phraseTrainingActivity);
//        }
//
//        public void run() {
//            PhraseTrainingActivity phraseTrainingActivity = (PhraseTrainingActivity) this.mActivity.get();
//            if (phraseTrainingActivity != null) {
//                phraseTrainingActivity.mLoadProgress.setVisibility(0);
//            }
//        }
//    }
//
//    public static void start(Context context, ArrayList<Integer> arrayList, int i) {
//        Intent intent = new Intent(context, PhraseTrainingActivity.class);
//        intent.putIntegerArrayListExtra(ARG_GROUPS, arrayList);
//        intent.putExtra(ARG_CUR_GROUP_INDEX, i);
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
//        if (!tryFinishSelf(bundle)) {
//            ThemeUtil.setThemeOnActivityCreate(this);
//            setContentView(R.layout.phrase_training_main);
//            initViews();
//            initDatas();
//            this.mPlayer = new AudioPlayer(this);
//        }
//    }
//
//    private boolean tryFinishSelf(Bundle bundle) {
//        if (bundle == null || !bundle.getBoolean(ConstantsUtil.STATE_EXIT_FOR_RECREATE, false)) {
//            return false;
//        }
//        LogWrapper.m2794e(TAG, TAG + " is recreated and data is lost, finish!");
//        this.mFinishSelf = true;
//        finish();
//        return true;
//    }
//
//    private void initViews() {
//        this.mHome = findViewById(R.id.phrase_training_home);
//        this.mHome.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                PhraseTrainingActivity.this.finish();
//            }
//        });
//        this.mProgress = (ProgressBar) findViewById(R.id.phrase_training_progress);
//        ThemeResUtil.setBacizhanProgress2(this, this.mProgress);
//        this.mLoadProgress = (ProgressBar) findViewById(R.id.phrase_training_load_progress);
//        this.mDelayLoadProgressRun = new DelayLoadProgressRun(this);
//    }
//
//    private boolean initDatas() {
//        Intent intent = getIntent();
//        this.mGroups = intent.getIntegerArrayListExtra(ARG_GROUPS);
//        this.mCurGroupIndex = intent.getIntExtra(ARG_CUR_GROUP_INDEX, 0);
//        if (this.mGroups == null || this.mGroups.isEmpty() || this.mGroups.size() <= this.mCurGroupIndex) {
//            return false;
//        }
//        this.mGroupPhrases = PhraseGroup.getPhraseGroups(getAssets());
//        doLoad();
//        return true;
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
//    private void doLoad() {
//        this.mLoadProgress.setProgress(0);
//        this.mHandler.postDelayed(this.mDelayLoadProgressRun, 1000);
//        this.mCurGroup = ((Integer) this.mGroups.get(this.mCurGroupIndex)).intValue();
//        this.mLoader = new Builder().setAssetManager(getAssets()).setCallback(this).setGroupId(this.mCurGroup).build();
//        this.mLoader.load();
//    }
//
//    private void doNextGroup(Fragment fragment) {
//        FragmentTransaction a = getSupportFragmentManager().mo313a();
//        a.mo181a(fragment);
//        a.mo183b();
//        this.mCurGroupIndex = (this.mCurGroupIndex + 1) % this.mGroups.size();
//        doLoad();
//    }
//
//    private void doNext(int i, Object obj) {
//        Fragment fragment;
//        int i2 = 100;
//        if (this.mDataPrepared) {
//            Fragment fragment2 = null;
//            List arrTopics = this.mTopicPatterns.getArrTopics();
//            if (1 == i) {
//                fragment = Training_66_Fragment.createInstance(true);
//            } else if (2 == i) {
//                FragmentTransaction a = getSupportFragmentManager().mo313a();
//                a.mo181a((Fragment) obj);
//                a.mo183b();
//                getSupportFragmentManager().mo317c();
//                fragment = null;
//            } else if (arrTopics == null || arrTopics.isEmpty()) {
//                Fragment createInstance = Training_over_Fragment.createInstance();
//                int i3 = (this.mCurPhraseIndex * 100) / this.mTotalPhrases;
//                if (i3 > 100) {
//                    i3 = 100;
//                }
//                this.mProgress.setProgress(i3);
//                this.mCurPhraseIndex++;
//                PropertyHelper.put(new StringBuilder(Pattern.STUDIED_KEY).append(this.mCurGroup).toString(), true);
//                fragment = createInstance;
//            } else {
//                this.mCurTopic = (Topic) arrTopics.remove(0);
//                int typeHint = this.mCurTopic.getTypeHint();
//                switch (typeHint) {
//                    case 59:
//                        fragment2 = Training_59_Fragment.createInstance();
//                        break;
//                    case 60:
//                    case 64:
//                        fragment2 = Training_60_64_Fragment.createInstance(typeHint);
//                        break;
//                    case 61:
//                    case 68:
//                        fragment2 = Training_61_68_Fragment.createInstance(typeHint);
//                        break;
//                    case 62:
//                        fragment2 = Training_62_Fragment.createInstance();
//                        break;
//                    case 65:
//                        fragment2 = Training_65_Fragment.createInstance();
//                        break;
//                    case 66:
//                        fragment2 = Training_66_Fragment.createInstance(false);
//                        break;
//                    case 67:
//                        fragment2 = Training_67_Fragment.createInstance();
//                        break;
//                }
//                if (fragment2 != null) {
//                    int i4 = (this.mCurPhraseIndex * 100) / this.mTotalPhrases;
//                    if (i4 <= 100) {
//                        i2 = i4;
//                    }
//                    this.mProgress.setProgress(i2);
//                    this.mCurPhraseIndex++;
//                }
//                fragment = fragment2;
//            }
//            if (fragment != null) {
//                FragmentTransaction a2 = getSupportFragmentManager().mo313a();
//                a2.mo178a((int) R.anim.alpha_fade_in, (int) R.anim.alpha_fade_out);
//                a2.mo184b(R.id.phrase_training_qa_container, fragment);
//                if (1 == i) {
//                    a2.mo177a();
//                }
//                a2.mo183b();
//            }
//        }
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        if (!this.mFinishSelf) {
//            this.mLoader.cancel();
//            this.mPlayer.destroy();
//            this.mHandler.removeCallbacks(this.mDelayLoadProgressRun);
//        }
//        System.gc();
//    }
//
//    public void onResult(boolean z) {
//        this.mPlayer.newPlayRaw(z ? R.raw.answer_right : R.raw.answer_error);
//    }
//
//    public void onNext(int i, Object obj) {
//        doNext(i, obj);
//    }
//
//    public void onNextGroup(Fragment fragment) {
//        doNextGroup(fragment);
//    }
//
//    public void onEnd() {
//        finish();
//    }
//
//    public void onLoadProgress(int i) {
//        this.mLoadProgress.setProgress(i);
//    }
//
//    public void onLoaded(boolean z, int i) {
//        this.mHandler.removeCallbacks(this.mDelayLoadProgressRun);
//        this.mLoadProgress.setVisibility(8);
//        this.mDataPrepared = z;
//        if (z) {
//            this.mProgress.setProgress(0);
//            this.mCurPhraseIndex = 0;
//            this.mTopicPatterns = this.mLoader.getTopicPatterns();
//            this.mTotalPhrases = this.mTopicPatterns.getArrTopics().size();
//            this.mPhrases = this.mLoader.getPhrases();
//            doNext(0, null);
//            return;
//        }
//        int i2 = R.string.phrase_training_load_failed;
//        switch (i) {
//            case -4:
//                i2 = R.string.phrase_training_load_failed_for_net_usr_reject;
//                break;
//            case -3:
//                i2 = R.string.phrase_training_load_failed_for_net_offline;
//                break;
//            case -2:
//                i2 = R.string.phrase_training_load_failed_for_net;
//                break;
//            case -1:
//                i2 = R.string.phrase_training_load_failed_for_data;
//                break;
//        }
//        Toast.makeText(this, i2, 0).show();
//        finish();
//    }
//
//    public void onCancelled() {
//    }
//}
