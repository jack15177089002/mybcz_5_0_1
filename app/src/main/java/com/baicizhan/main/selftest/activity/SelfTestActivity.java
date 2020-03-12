//package com.baicizhan.main.selftest.activity;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Build.VERSION;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.p004v4.app.FragmentActivity;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.AlphaAnimation;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask.Listener;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.business.widget.DirectionalViewPager;
//import com.baicizhan.client.business.widget.DirectionalViewPager.OnPageChangeListener;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.main.activity.SingleWikiActivity;
//import com.baicizhan.main.adapter.SelfTestWordAdapter;
//import com.baicizhan.main.resource.TopicResourceChecker;
//import com.baicizhan.main.resource.TopicResourceManager;
//import com.baicizhan.main.selftest.strategy.SelfTestStrategy.Result;
//import com.baicizhan.main.selftest.strategy.SelfTestStrategyProxy;
//import com.baicizhan.main.selftest.strategy.SelfTestStrategyProxy.OnSelfTestDataListener;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SelfTestActivity extends FragmentActivity implements OnClickListener {
//    public static final int REQUEST_WIKI = 10000;
//    public static final String TAG = SelfTestActivity.class.getSimpleName();
//    /* access modifiers changed from: private */
//    public SelfTestWordAdapter mAdapter;
//    protected AudioPlayer mAudioPlayer;
//    private Listener mDownloadListener = new Listener() {
//        public void onSuccess(AbstractDownloadTask abstractDownloadTask) {
//            if (!SelfTestActivity.this.isFinishing()) {
//                SelfTestActivity.this.dismissLoading();
//                SelfTestActivity.this.showWord(SelfTestActivity.this.mDownloadToShowIndex);
//                if (SelfTestActivity.this.mPostKillRunnable != null) {
//                    SelfTestActivity.this.mHandler.postDelayed(SelfTestActivity.this.mPostKillRunnable, 600);
//                }
//            }
//        }
//
//        public void onError(AbstractDownloadTask abstractDownloadTask, Throwable th) {
//            if (!SelfTestActivity.this.isFinishing()) {
//                Toast.makeText(SelfTestActivity.this, R.string.download_res_fail, 0).show();
//                SelfTestActivity.this.finish();
//                SelfTestActivity.this.mPostKillRunnable = null;
//                SelfTestActivity.this.mKillBtn.setClickable(true);
//                View findViewWithTag = SelfTestActivity.this.mWordsSwitcher.findViewWithTag(SelfTestActivity.this.mAdapter.getData(SelfTestActivity.this.mWordsSwitcher.getCurrentItem()));
//                if (findViewWithTag != null) {
//                    findViewWithTag.clearAnimation();
//                }
//                SelfTestActivity.this.dismissLoading();
//            }
//        }
//    };
//    /* access modifiers changed from: private */
//    public int mDownloadToShowIndex = 0;
//    private Button mForgetBtn;
//    /* access modifiers changed from: private */
//    public Handler mHandler;
//    private ImageView mHomeBtn;
//    private boolean mInWiki = false;
//    private boolean mIniting = false;
//    /* access modifiers changed from: private */
//    public Button mKillBtn;
//    /* access modifiers changed from: private */
//    public TextView mLastWord;
//    /* access modifiers changed from: private */
//    public boolean mPermitDownload = false;
//    /* access modifiers changed from: private */
//    public Runnable mPostKillRunnable = null;
//    private BczLoadingDialog mProgressDialog;
//    private ImageButton mPronounceBtn;
//    private Button mRememberBtn;
//    /* access modifiers changed from: private */
//    public Result mResult;
//    /* access modifiers changed from: private */
//    public SelfTestStrategyProxy mSelfTestStrategy;
//    private SelfTestStrategyCallback mSelfTestStrategyCallback;
//    private List<Integer> mTestedIds = new ArrayList();
//    private TextView mWordsLeft;
//    /* access modifiers changed from: private */
//    public DirectionalViewPager mWordsSwitcher;
//
//    class SelfTestStrategyCallback implements OnSelfTestDataListener {
//        final WeakReference<SelfTestActivity> mActivity;
//
//        SelfTestStrategyCallback(SelfTestActivity selfTestActivity) {
//            this.mActivity = new WeakReference<>(selfTestActivity);
//        }
//
//        public void onContinueHistory(Result result) {
//            SelfTestActivity selfTestActivity = (SelfTestActivity) this.mActivity.get();
//            if (selfTestActivity != null) {
//                if (result == null || result.ids == null || result.ids.isEmpty()) {
//                    Toast.makeText(selfTestActivity, R.string.selftest_no_word, 0).show();
//                    selfTestActivity.finish();
//                    return;
//                }
//                selfTestActivity.initPreload(result);
//                selfTestActivity.startTest();
//            }
//        }
//
//        public void onExit() {
//            SelfTestActivity selfTestActivity = (SelfTestActivity) this.mActivity.get();
//            if (selfTestActivity != null) {
//                selfTestActivity.dismissLoading();
//                selfTestActivity.finish();
//            }
//        }
//
//        public void onSelfTestInit(Result result) {
//            SelfTestActivity selfTestActivity = (SelfTestActivity) this.mActivity.get();
//            if (selfTestActivity != null) {
//                if (result == null) {
//                    Toast.makeText(selfTestActivity, R.string.selftest_no_word, 0).show();
//                    selfTestActivity.finish();
//                } else if (result.ids == null || result.ids.isEmpty()) {
//                    selfTestActivity.mSelfTestStrategy.askResetAll(selfTestActivity, null);
//                } else if (result.today || !result.hasToday) {
//                    selfTestActivity.initPreload(result);
//                    selfTestActivity.startTest();
//                } else {
//                    selfTestActivity.mSelfTestStrategy.askResetToday(selfTestActivity, null);
//                }
//            }
//        }
//
//        public void onSelfTestReset(Result result) {
//            SelfTestActivity selfTestActivity = (SelfTestActivity) this.mActivity.get();
//            if (selfTestActivity != null) {
//                if (result == null || result.ids == null || result.ids.isEmpty()) {
//                    Toast.makeText(selfTestActivity, R.string.selftest_no_word, 0).show();
//                    selfTestActivity.finish();
//                    return;
//                }
//                selfTestActivity.initPreload(result);
//                selfTestActivity.startTest();
//            }
//        }
//    }
//
//    public static void start(Context context) {
//        context.startActivity(new Intent(context, SelfTestActivity.class));
//    }
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (VERSION.SDK_INT >= 11) {
//            getWindow().setFlags(16777216, 16777216);
//        }
//        ThemeUtil.setThemeOnActivityCreate(this);
//        setContentView(R.layout.activity_self_test);
//        init();
//    }
//
//    private void init() {
//        this.mHandler = new Handler();
//        this.mAudioPlayer = new AudioPlayer(this);
//        this.mProgressDialog = new BczLoadingDialog(this);
//        this.mProgressDialog.setMessage(getText(R.string.loading_progress));
//        this.mProgressDialog.setCancelable(false);
//        this.mSelfTestStrategyCallback = new SelfTestStrategyCallback(this);
//        this.mSelfTestStrategy = new SelfTestStrategyProxy(this, this.mSelfTestStrategyCallback);
//        this.mWordsSwitcher = (DirectionalViewPager) findViewById(R.id.words_gallery);
//        this.mWordsSwitcher.setOverScrollMode(2);
//        this.mAdapter = new SelfTestWordAdapter(getSupportFragmentManager());
//        this.mWordsSwitcher.setAdapter(this.mAdapter);
//        this.mWordsSwitcher.setOnPageChangeListener(new OnPageChangeListener() {
//            public void onPageSelected(int i) {
//                TopicRecord data = SelfTestActivity.this.mAdapter.getData(i - 1);
//                if (data == null) {
//                    SelfTestActivity.this.mLastWord.setText("");
//                    SelfTestActivity.this.mLastWord.setTag(null);
//                    return;
//                }
//                SelfTestActivity.this.mLastWord.setText(data.word + " " + data.wordMean);
//                SelfTestActivity.this.mLastWord.setTag(data);
//            }
//
//            public void onPageScrolled(int i, float f, int i2) {
//            }
//
//            public void onPageScrollStateChanged(int i) {
//            }
//        });
//        this.mHomeBtn = (ImageView) findViewById(R.id.home);
//        this.mRememberBtn = (Button) findViewById(R.id.remember_the_word_btn);
//        this.mForgetBtn = (Button) findViewById(R.id.forget_the_word_btn);
//        this.mPronounceBtn = (ImageButton) findViewById(R.id.pronounce_btn);
//        this.mKillBtn = (Button) findViewById(R.id.slash_btn);
//        this.mLastWord = (TextView) findViewById(R.id.last_topic);
//        this.mWordsLeft = (TextView) findViewById(R.id.words_left);
//        this.mHomeBtn.setOnClickListener(this);
//        this.mRememberBtn.setOnClickListener(this);
//        this.mForgetBtn.setOnClickListener(this);
//        this.mPronounceBtn.setOnClickListener(this);
//        this.mKillBtn.setOnClickListener(this);
//        this.mLastWord.setOnClickListener(this);
//        loadTestData();
//    }
//
//    /* access modifiers changed from: private */
//    public void initPreload(Result result) {
//        this.mIniting = false;
//        this.mResult = result;
//        this.mTestedIds.clear();
//        this.mAdapter = new SelfTestWordAdapter(getSupportFragmentManager());
//        this.mWordsSwitcher.setAdapter(this.mAdapter);
//        dismissLoading();
//    }
//
//    private void loadTestData() {
//        showLoading();
//        this.mSelfTestStrategy.init();
//        this.mIniting = true;
//    }
//
//    /* access modifiers changed from: private */
//    public void startTest() {
//        showWord(0);
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.home /*2131296343*/:
//                finish();
//                return;
//            case R.id.last_topic /*2131296347*/:
//                Object tag = view.getTag();
//                if (tag != null && (tag instanceof TopicRecord)) {
//                    showTopicWiki((TopicRecord) tag);
//                    return;
//                }
//                return;
//            case R.id.remember_the_word_btn /*2131296393*/:
//                showWord(this.mWordsSwitcher.getCurrentItem() + 1);
//                return;
//            case R.id.forget_the_word_btn /*2131296394*/:
//                showTopicWiki(this.mAdapter.getData(this.mWordsSwitcher.getCurrentItem()));
//                return;
//            case R.id.slash_btn /*2131296395*/:
//                this.mAudioPlayer.newPlayRaw(R.raw.chop);
//                LearnRecordManager.getInstance().kill(this.mAdapter.getData(this.mWordsSwitcher.getCurrentItem()).topicId, 0);
//                playKillAnimation();
//                return;
//            case R.id.pronounce_btn /*2131296396*/:
//                TopicRecord data = this.mAdapter.getData(this.mWordsSwitcher.getCurrentItem());
//                ZPackUtils.loadAudioCompat(this.mAudioPlayer, data, data.wordAudio);
//                return;
//            default:
//                return;
//        }
//    }
//
//    private void playKillAnimation() {
//        this.mKillBtn.setClickable(false);
//        final int currentItem = this.mWordsSwitcher.getCurrentItem();
//        final TopicRecord data = this.mAdapter.getData(currentItem);
//        View findViewWithTag = this.mWordsSwitcher.findViewWithTag(data);
//        if (findViewWithTag == null) {
//            postKillWord(currentItem, data);
//            return;
//        }
//        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
//        alphaAnimation.setFillAfter(true);
//        alphaAnimation.setDuration(500);
//        alphaAnimation.setAnimationListener(new AnimationListener() {
//            public void onAnimationStart(Animation animation) {
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            public void onAnimationEnd(Animation animation) {
//                SelfTestActivity.this.postKillWord(currentItem, data);
//            }
//        });
//        findViewWithTag.startAnimation(alphaAnimation);
//    }
//
//    /* access modifiers changed from: private */
//    public void postKillWord(final int i, final TopicRecord topicRecord) {
//        if (this.mWordsSwitcher.getCurrentItem() == this.mResult.ids.size() - 1) {
//            exitWhenNoMoreWords();
//            return;
//        }
//        final int currentItem = this.mWordsSwitcher.getCurrentItem();
//        this.mPostKillRunnable = new Runnable() {
//            public void run() {
//                SelfTestActivity.this.mResult.ids.remove(i);
//                SelfTestActivity.this.mAdapter.removeRecord(topicRecord);
//                SelfTestWordAdapter selfTestWordAdapter = new SelfTestWordAdapter(SelfTestActivity.this.getSupportFragmentManager());
//                selfTestWordAdapter.setRecordList(SelfTestActivity.this.mAdapter.getRecordList());
//                SelfTestActivity.this.mWordsSwitcher.removeAllViewsInLayout();
//                SelfTestActivity.this.mWordsSwitcher.setAdapter(selfTestWordAdapter);
//                SelfTestActivity.this.mAdapter = selfTestWordAdapter;
//                SelfTestActivity.this.mWordsSwitcher.setCurrentItem(currentItem, false);
//                SelfTestActivity.this.mKillBtn.setClickable(true);
//                SelfTestActivity.this.mPostKillRunnable = null;
//            }
//        };
//        if (!showWord(currentItem + 1)) {
//            this.mHandler.postDelayed(this.mPostKillRunnable, 600);
//        }
//    }
//
//    private void exitWhenNoMoreWords() {
//        showLoading();
//        this.mIniting = true;
//        if (!this.mResult.today || !this.mResult.hasToday) {
//            this.mSelfTestStrategy.askResetAll(this, this.mTestedIds);
//        } else {
//            this.mSelfTestStrategy.askResetToday(this, this.mTestedIds);
//        }
//    }
//
//    private void showTopicWiki(TopicRecord topicRecord) {
//        Intent intent = new Intent(this, SingleWikiActivity.class);
//        intent.putExtra(SingleWikiActivity.EXTRA_TOPIC_RECORD, topicRecord);
//        intent.putExtra(SingleWikiActivity.EXTRA_WIKI_STYLE, 1);
//        startActivityForResult(intent, 10000);
//        this.mInWiki = true;
//    }
//
//    /* access modifiers changed from: protected */
//    public void onActivityResult(int i, int i2, Intent intent) {
//        switch (i) {
//            case 10000:
//                this.mInWiki = false;
//                if (intent != null && intent.getBooleanExtra(SingleWikiActivity.EXTRA_IS_KILLED, false)) {
//                    playKillAnimation();
//                    return;
//                }
//                return;
//            default:
//                return;
//        }
//    }
//
//    private TopicRecord checkRecordResource(int i) {
//        TopicRecord integratedTopicRecord = TopicResourceManager.getInstance().getIntegratedTopicRecord(i);
//        if (integratedTopicRecord != null && TopicResourceChecker.checkIntegrity(integratedTopicRecord)) {
//            return integratedTopicRecord;
//        }
//        C0789L.log.error("self testing failed for resource not valid, record is [{}]", (Object) integratedTopicRecord);
//        return null;
//    }
//
//    /* access modifiers changed from: private */
//    public boolean showWord(int i) {
//        if (i <= this.mAdapter.getCount() - 1) {
//            this.mWordsSwitcher.setCurrentItem(i, true);
//            TopicRecord data = this.mAdapter.getData(this.mWordsSwitcher.getCurrentItem());
//            ZPackUtils.loadAudioCompat(this.mAudioPlayer, data, data.wordAudio);
//        } else if (i != this.mAdapter.getCount()) {
//            throw new IllegalArgumentException("index必须等于mAdapter.getCount()");
//        } else if (i > this.mResult.ids.size() - 1) {
//            this.mTestedIds.add(this.mResult.ids.get(this.mResult.ids.size() - 1));
//            exitWhenNoMoreWords();
//            return true;
//        } else {
//            TopicRecord checkRecordResource = checkRecordResource(((Integer) this.mResult.ids.get(i)).intValue());
//            if (checkRecordResource == null) {
//                requestResource(i);
//                return true;
//            }
//            this.mAdapter.addRecord(checkRecordResource);
//            this.mAdapter.notifyDataSetChanged();
//            this.mWordsSwitcher.setCurrentItem(i, true);
//            TopicRecord data2 = this.mAdapter.getData(this.mWordsSwitcher.getCurrentItem());
//            ZPackUtils.loadAudioCompat(this.mAudioPlayer, data2, data2.wordAudio);
//            this.mWordsLeft.setText(getString(R.string.words_left, new Object[]{Integer.valueOf(this.mResult.ids.size() - this.mAdapter.getCount())}));
//            if (i > 0) {
//                this.mTestedIds.add(this.mResult.ids.get(i - 1));
//            }
//        }
//        return false;
//    }
//
//    private void requestResource(final int i) {
//        if (NetworkUtils.isWiFiConnected(this) || this.mPermitDownload) {
//            doRequestResource(i);
//        } else if (NetworkUtils.isNetworkAvailable(this)) {
//            BczDialog create = new Builder(this).setMessage((int) R.string.main_alert_message_download_problem).setPositiveButton((int) R.string.main_alert_positive_wealthy, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    SelfTestActivity.this.mPermitDownload = true;
//                    SelfTestActivity.this.doRequestResource(i);
//                }
//            }).setNegativeButton((int) R.string.main_alert_negative_giveup, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    SelfTestActivity.this.finish();
//                }
//            }).setCancelable(false).create();
//            create.setCancelable(false);
//            create.show();
//        } else {
//            BczDialog create2 = new Builder(this).setTitle((int) R.string.attention).setMessage((CharSequence) "检测不到网络，请联网后重试").setPositiveButton((int) R.string.main_alert_positive_confirm, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    SelfTestActivity.this.finish();
//                }
//            }).setCancelable(false).create();
//            create2.setCancelable(false);
//            create2.show();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doRequestResource(int i) {
//        showLoading();
//        this.mDownloadToShowIndex = i;
//        TopicResourceManager.getInstance().downloadTopic(((Integer) this.mResult.ids.get(i)).intValue(), this.mDownloadListener);
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
//    /* access modifiers changed from: protected */
//    public void onPause() {
//        super.onPause();
//        UMStats.traceOnActivityPause(this);
//        if (!this.mIniting && !this.mInWiki) {
//            this.mResult = this.mSelfTestStrategy.save(new ArrayList(this.mTestedIds));
//            this.mTestedIds.clear();
//            TopicRecord data = this.mAdapter.getData(this.mAdapter.getCount() - 1);
//            this.mAdapter = new SelfTestWordAdapter(getSupportFragmentManager());
//            this.mWordsSwitcher.setAdapter(this.mAdapter);
//            this.mAdapter.addRecord(data);
//            this.mAdapter.notifyDataSetChanged();
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onResume() {
//        super.onResume();
//        UMStats.traceOnActivityResume(this);
//        if (this.mWordsSwitcher != null) {
//            int currentItem = this.mWordsSwitcher.getCurrentItem();
//            this.mWordsSwitcher.setAdapter(this.mAdapter);
//            this.mWordsSwitcher.setCurrentItem(currentItem);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDestroy() {
//        super.onDestroy();
//        if (this.mAudioPlayer != null) {
//            this.mAudioPlayer.destroy();
//            this.mAudioPlayer = null;
//        }
//        dismissLoading();
//    }
//}
