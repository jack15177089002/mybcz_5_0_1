//package com.baicizhan.main.fragment;
//
//import android.app.Activity;
//import android.content.Context;
//import android.graphics.BitmapFactory;
//import android.graphics.drawable.AnimationDrawable;
//import android.graphics.drawable.GradientDrawable;
//import android.os.Bundle;
//import android.support.p004v4.app.Fragment;
//import android.support.p004v4.view.ViewCompat;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.animation.AnimationUtils;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.BaseAdapter;
//import android.widget.FrameLayout;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.LinearLayout.LayoutParams;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.auth.WXShareProxy;
//import com.baicizhan.client.business.auth.WeixinShare;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.dataset.models.SimilarWordRecord;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.download_service.QiniuResourceDownloader;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.CollectionUtils;
//import com.baicizhan.client.business.util.CustomFont;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.TopicTextRenderHelper;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.audio.AudioPlayer.OnPlaySateListener;
//import com.baicizhan.client.framework.audio.AudioPlayer.State;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.customview.WikiVideoView;
//import com.baicizhan.main.resource.TopicResourceManager;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.online.bs_words.BBGetWordAssetInfoArg;
//import com.baicizhan.online.bs_words.BBGetWordAssetInfoResult;
//import com.baicizhan.online.bs_words.BBWordShareInfo;
//import com.baicizhan.online.bs_words.BSWords.Client;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.Callback;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//public class WikiFragment extends Fragment implements OnClickListener {
//    private static final String KEY_PATTERN_TYPE = "key_pattern_type";
//    private static final String KEY_STYLE = "key_style";
//    private static final String KEY_TOPIC_RECORD = "key_topic_record";
//    public static final int STYLE_EXIT_ON_BACK = 2;
//    public static final int STYLE_FORCE_LAND = 4;
//    public static final int STYLE_NO_KILL = 1;
//    private static final String TAG = WikiFragment.class.getSimpleName();
//    /* access modifiers changed from: private */
//    public static AnimationDrawable mVoiceAnim;
//    /* access modifiers changed from: private */
//    public AudioPlayer mAudioPlayer;
//    private View mCancelKillView;
//    private LinearLayout mClauseContainer;
//    private TextView mContinueView;
//    private ViewGroup mDeformationClause;
//    private View mKillView;
//    private WikiListener mListener;
//    private TextView mMeanCn;
//    private ViewGroup mMeanEnClause;
//    private int mPatternType = 0;
//    private TextView mPhonetic;
//    private boolean mPortraitMode;
//    /* access modifiers changed from: private */
//    public BczLoadingDialog mProgressDialog = null;
//    private ViewGroup mSentenceClause;
//    private ViewGroup mSentenceTransClause;
//    private TextView mSentenceTransView;
//    private AuthCallback<Void> mShareCallback = new AuthCallback<Void>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(Void voidR) {
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//            Toast.makeText(WikiFragment.this.getActivity(), "分享失败,原因" + th.getMessage(), 0).show();
//        }
//    };
//    private ViewGroup mSimilarClause;
//    private SimilarWordDialog mSimilarWordDialog = null;
//    List<SimilarWordRecord> mSimilarWords;
//    private int mStyle;
//    private ViewGroup mTipsClaus;
//    private View mTodayNew;
//    /* access modifiers changed from: private */
//    public TopicRecord mTopic;
//    private ImageView mTopicImage;
//    private ViewGroup mVideoClause;
//    private WikiVideoView mVideoView;
//    /* access modifiers changed from: private */
//    public ImageView mVoice;
//    private WXShareProxy mWXShareProxy;
//    private WikiShareDialog mWikiShareDialog = null;
//    private TextView mWordView;
//
//    class SimilarWordsAdapter extends BaseAdapter {
//        List<SimilarWordRecord> similarWordRecords = Collections.emptyList();
//
//        public SimilarWordsAdapter(List<SimilarWordRecord> list) {
//            this.similarWordRecords = list;
//        }
//
//        public int getCount() {
//            return this.similarWordRecords.size();
//        }
//
//        public Object getItem(int i) {
//            return this.similarWordRecords.get(i);
//        }
//
//        public long getItemId(int i) {
//            return (long) i;
//        }
//
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            TextView textView;
//            Context context = viewGroup.getContext();
//            if (view == 0) {
//                TextView textView2 = new TextView(context);
//                textView2.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.dimen.T3));
//                textView2.setTextColor(context.getResources().getColor(ThemeUtil.getThemeResourceIdWithAttr(context, R.attr.color_text_blue)));
//                textView = textView2;
//                r7 = textView2;
//            } else {
//                textView = (TextView) view;
//                r7 = view;
//            }
//            textView.setText(((SimilarWordRecord) this.similarWordRecords.get(i)).word);
//            return r7;
//        }
//    }
//
//    public interface WikiListener {
//        void onWikiExit();
//    }
//
//    public static WikiFragment getInstance(TopicRecord topicRecord, int i) {
//        WikiFragment wikiFragment = new WikiFragment();
//        Bundle bundle = new Bundle();
//        bundle.putParcelable(KEY_TOPIC_RECORD, topicRecord);
//        bundle.putInt(KEY_STYLE, i);
//        wikiFragment.setArguments(bundle);
//        return wikiFragment;
//    }
//
//    public static WikiFragment getInstance(TopicRecord topicRecord, int i, int i2) {
//        WikiFragment wikiFragment = new WikiFragment();
//        Bundle bundle = new Bundle();
//        bundle.putParcelable(KEY_TOPIC_RECORD, topicRecord);
//        bundle.putInt(KEY_STYLE, i);
//        bundle.putInt(KEY_PATTERN_TYPE, i2);
//        wikiFragment.setArguments(bundle);
//        return wikiFragment;
//    }
//
//    public int getTopicId() {
//        return this.mTopic.topicId;
//    }
//
//    public void setWikiListener(WikiListener wikiListener) {
//        this.mListener = wikiListener;
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        Bundle arguments = getArguments();
//        if (arguments != null) {
//            this.mTopic = (TopicRecord) arguments.getParcelable(KEY_TOPIC_RECORD);
//            this.mStyle = arguments.getInt(KEY_STYLE);
//            this.mPatternType = arguments.getInt(KEY_PATTERN_TYPE);
//        }
//        this.mPortraitMode = (this.mStyle & 4) <= 0 && PropertyHelper.getBoolean("portrait_mode");
//        this.mWXShareProxy = WXShareProxy.born(getActivity());
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        if (getActivity() != null && getActivity().isFinishing()) {
//            return new FrameLayout(viewGroup.getContext());
//        }
//        View inflate = layoutInflater.inflate(this.mPortraitMode ? R.layout.fragment_wiki_portrait : R.layout.fragment_wiki, viewGroup, false);
//        ViewCompat.m543b(inflate.findViewById(R.id.wiki_scroll));
//        this.mClauseContainer = (LinearLayout) inflate.findViewById(R.id.clause_container);
//        this.mKillView = inflate.findViewById(R.id.kill);
//        this.mCancelKillView = inflate.findViewById(R.id.cancel_kill);
//        this.mTodayNew = inflate.findViewById(R.id.is_today_new);
//        this.mWordView = (TextView) inflate.findViewById(R.id.topic_word);
//        this.mPhonetic = (TextView) inflate.findViewById(R.id.topic_phonetic);
//        CustomFont.setFont(this.mPhonetic, 3);
//        this.mMeanCn = (TextView) inflate.findViewById(R.id.topic_mean_cn);
//        this.mTopicImage = (ImageView) inflate.findViewById(R.id.topic_image);
//        this.mContinueView = (TextView) inflate.findViewById(R.id.continue_learn);
//        this.mVoice = (ImageView) inflate.findViewById(R.id.voice);
//        this.mVoice.setImageResource(ThemeUtil.getThemeResourceIdWithAttr(getActivity(), R.attr.drawable_wiki_sound));
//        if (mVoiceAnim == null) {
//            mVoiceAnim = (AnimationDrawable) ThemeUtil.getThemeDrawableWithAttr(getActivity(), R.attr.animation_wiki_sound);
//        }
//        inflate.findViewById(R.id.basic_panel).setOnClickListener(this);
//        this.mVoice.setOnClickListener(this);
//        this.mKillView.setOnClickListener(this);
//        this.mCancelKillView.setOnClickListener(this);
//        this.mContinueView.setOnClickListener(this);
//        inflate.findViewById(R.id.share).setOnClickListener(this);
//        setData(this.mTopic, this.mStyle);
//        return inflate;
//    }
//
//    public void onStop() {
//        super.onStop();
//        if (this.mVideoView != null) {
//            this.mVideoView.pause();
//        }
//    }
//
//    public void setData(TopicRecord topicRecord, int i) {
//        this.mTopic = topicRecord;
//        this.mStyle = i;
//        if (this.mTopic != null) {
//            inflateWikiClauses(this.mTopic);
//            this.mTodayNew.setVisibility((!LearnRecordManager.getInstance().isTodayNewLearned(this.mTopic.topicId) || this.mPatternType != 1) ? 8 : 0);
//            this.mWordView.setText(this.mTopic.word);
//            this.mPhonetic.setText(this.mTopic.phonetic);
//            if (!TextUtils.isEmpty(this.mTopic.wordMean)) {
//                this.mMeanCn.setVisibility(0);
//                this.mMeanCn.setText(this.mTopic.wordMean);
//            } else {
//                this.mMeanCn.setVisibility(8);
//            }
//            this.mTopicImage.setImageDrawable(null);
//            ZPackUtils.loadImageCompat(this.mTopic, this.mTopic.imagePath).error(R.drawable.image_broke_normal_default).into(this.mTopicImage, (Callback) null);
//            if ((this.mStyle & 2) > 0) {
//                this.mContinueView.setText("返回");
//            } else {
//                this.mContinueView.setText("继续做题");
//            }
//        } else {
//            Toast.makeText(getActivity(), "Wiki显示错误", 0).show();
//            LogWrapper.m2794e(TAG, "wiki topic null " + this.mTopic);
//        }
//    }
//
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        this.mAudioPlayer = new AudioPlayer(getActivity());
//    }
//
//    public void onResume() {
//        super.onResume();
//        this.mWXShareProxy.resume();
//        updateKillStatus(LearnRecordManager.getInstance().isKilled(this.mTopic.topicId));
//    }
//
//    public void onDestroyView() {
//        super.onDestroyView();
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        this.mWXShareProxy.cancel();
//    }
//
//    public void onDetach() {
//        super.onDetach();
//        if (this.mAudioPlayer != null) {
//            this.mAudioPlayer.destroy();
//        }
//        if (this.mProgressDialog != null) {
//            this.mProgressDialog.dismiss();
//        }
//        if (this.mWikiShareDialog != null) {
//            this.mWikiShareDialog.dismiss();
//        }
//        if (this.mSimilarWordDialog != null) {
//            this.mSimilarWordDialog.dismiss();
//        }
//        Log.d("whiz", "wiki fragment detached, word: " + this.mTopic.word);
//    }
//
//    private void inflateWikiClauses(TopicRecord topicRecord) {
//        if (this.mSentenceClause == null) {
//            this.mSentenceClause = (ViewGroup) this.mClauseContainer.findViewById(R.id.clause_sentence);
//        }
//        if (!TextUtils.isEmpty(topicRecord.sentence)) {
//            this.mSentenceClause.setVisibility(0);
//            setLabelBackground(this.mSentenceClause.getChildAt(0));
//            TopicTextRenderHelper.showClickableHighlightSentence((TextView) this.mSentenceClause.getChildAt(1), topicRecord.word, topicRecord.sentence);
//        } else {
//            this.mSentenceClause.setVisibility(8);
//        }
//        if (this.mSentenceTransClause == null) {
//            this.mSentenceTransClause = (ViewGroup) this.mClauseContainer.findViewById(R.id.clause_sentence_trans);
//        }
//        if (!TextUtils.isEmpty(topicRecord.sentenceTrans)) {
//            this.mSentenceTransClause.setVisibility(0);
//            setLabelBackground(this.mSentenceTransClause.getChildAt(0));
//            this.mSentenceTransView = (TextView) this.mSentenceTransClause.getChildAt(1);
//            this.mSentenceTransView.setText(topicRecord.sentenceTrans);
//            if (PropertyHelper.getBoolean(PropertyHelper.SHOW_SENTENCE_TRANSLATION, true)) {
//                this.mSentenceTransClause.getChildAt(0).setOnClickListener(null);
//                this.mSentenceTransClause.getChildAt(0).setVisibility(4);
//                this.mSentenceTransView.setVisibility(0);
//            } else {
//                this.mSentenceTransClause.getChildAt(0).setOnClickListener(this);
//                this.mSentenceTransClause.getChildAt(0).setVisibility(0);
//                this.mSentenceTransView.setVisibility(4);
//            }
//        } else {
//            this.mSentenceTransClause.setVisibility(8);
//        }
//        if (this.mVideoClause == null) {
//            this.mVideoClause = (ViewGroup) this.mClauseContainer.findViewById(R.id.clause_video);
//        }
//        WordMediaRecord wordMediaRecord = TopicResourceManager.getInstance().getWordMediaRecord(topicRecord.topicId);
//        if (StudyManager.getInstance().isOfflined() || !NetworkUtils.isNetworkAvailable(getActivity()) || wordMediaRecord == null || TextUtils.isEmpty(wordMediaRecord.getTvpath()) || wordMediaRecord.getTvupdate() <= 0) {
//            this.mVideoClause.setVisibility(8);
//        } else {
//            this.mVideoView = (WikiVideoView) this.mVideoClause.findViewById(R.id.wiki_video_view);
//            this.mVideoView.setVideoURI(QiniuResourceDownloader.getResourceUrl(wordMediaRecord.getTvpath()));
//            if (NetworkUtils.getActiveNetworkType(getActivity()) == 0) {
//                this.mVideoView.setSnapshot(QiniuResourceDownloader.getResourceUrl(wordMediaRecord.getTvSnapshotPath()));
//            } else {
//                this.mVideoView.setSnapshot(null);
//            }
//        }
//        if (this.mDeformationClause == null) {
//            this.mDeformationClause = (ViewGroup) this.mClauseContainer.findViewById(R.id.clause_deformation);
//        }
//        if (ZPackUtils.resourceFileExistsCompat(topicRecord, topicRecord.deformationImagePath)) {
//            this.mDeformationClause.setVisibility(0);
//            setLabelBackground(this.mDeformationClause.getChildAt(0));
//            ImageView imageView = (ImageView) this.mDeformationClause.getChildAt(1);
//            if (ThemeUtil.getCurrentSettingThemeId() == R.style.StandardNight) {
//                imageView.setBackgroundColor(getActivity().getResources().getColor(R.color.C42));
//            }
//            ZPackUtils.loadImageCompat(topicRecord, topicRecord.deformationImagePath).error(R.drawable.image_broke_normal_default).into(imageView, (Callback) null);
//        } else {
//            this.mDeformationClause.setVisibility(8);
//        }
//        if (this.mTipsClaus == null) {
//            this.mTipsClaus = (ViewGroup) this.mClauseContainer.findViewById(R.id.clause_tips);
//        }
//        if (!TextUtils.isEmpty(topicRecord.wordEtyma)) {
//            this.mTipsClaus.setVisibility(0);
//            setLabelBackground(this.mTipsClaus.getChildAt(0));
//            ((TextView) this.mTipsClaus.getChildAt(1)).setText(topicRecord.wordEtyma);
//        } else {
//            this.mTipsClaus.setVisibility(8);
//        }
//        if (this.mMeanEnClause == null) {
//            this.mMeanEnClause = (ViewGroup) this.mClauseContainer.findViewById(R.id.clause_mean_en);
//        }
//        if (!TextUtils.isEmpty(topicRecord.wordMeanEn)) {
//            this.mMeanEnClause.setVisibility(0);
//            setLabelBackground(this.mMeanEnClause.getChildAt(0));
//            TopicTextRenderHelper.showWordMeanEn((TextView) this.mMeanEnClause.getChildAt(1), topicRecord);
//        } else {
//            this.mMeanEnClause.setVisibility(8);
//        }
//        if (this.mSimilarClause == null) {
//            this.mSimilarClause = (ViewGroup) this.mClauseContainer.findViewById(R.id.clause_word_diff);
//        }
//        this.mSimilarWords = TopicResourceManager.getInstance().getTopicSimilarWordRecords(topicRecord.topicId);
//        if (CollectionUtils.isEmpty((Collection<?>) this.mSimilarWords) || this.mPatternType == 0 || this.mPatternType == 1) {
//            this.mSimilarClause.setVisibility(8);
//        } else {
//            setLabelBackground(this.mSimilarClause.getChildAt(0));
//            GridView gridView = (GridView) this.mSimilarClause.findViewById(R.id.word_diff_grid);
//            gridView.setAdapter(new SimilarWordsAdapter(this.mSimilarWords));
//            gridView.setOnItemClickListener(new OnItemClickListener() {
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
//                    WikiFragment.this.fetchSimilarRecords((SimilarWordRecord) WikiFragment.this.mSimilarWords.get(i));
//                }
//            });
//        }
//        int childCount = this.mClauseContainer.getChildCount();
//        ArrayList<View> arrayList = new ArrayList<>();
//        for (int i = 0; i < childCount; i++) {
//            View childAt = this.mClauseContainer.getChildAt(i);
//            if (childAt.getTag() == this.mClauseContainer) {
//                arrayList.add(childAt);
//            }
//        }
//        for (View removeView : arrayList) {
//            this.mClauseContainer.removeView(removeView);
//        }
//        int childCount2 = this.mClauseContainer.getChildCount();
//        ArrayList arrayList2 = new ArrayList();
//        for (int i2 = 0; i2 < childCount2; i2++) {
//            View childAt2 = this.mClauseContainer.getChildAt(i2);
//            if (childAt2.getVisibility() == 0) {
//                arrayList2.add(childAt2);
//            }
//        }
//        int themeColorWithAttr = ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_line_wiki);
//        int size = arrayList2.size();
//        for (int i3 = 0; i3 < size - 1; i3++) {
//            View view = (View) arrayList2.get(i3);
//            View view2 = new View(getActivity());
//            view2.setBackgroundColor(themeColorWithAttr);
//            view2.setTag(this.mClauseContainer);
//            LayoutParams layoutParams = new LayoutParams(-1, 1);
//            layoutParams.leftMargin = DisplayUtils.dpToPx(getActivity(), 36.0f);
//            this.mClauseContainer.addView(view2, this.mClauseContainer.indexOfChild(view) + 1, layoutParams);
//        }
//    }
//
//    private void setLabelBackground(View view) {
//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setShape(0);
//        gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_wiki_bg2));
//        gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(getActivity(), 4.0f));
//        C1604j.m3631a(view, gradientDrawable);
//    }
//
//    private void updateKillStatus(boolean z) {
//        if ((this.mStyle & 1) == 1) {
//            this.mKillView.setVisibility(8);
//            this.mCancelKillView.setVisibility(8);
//            return;
//        }
//        long j = (long) Settings.getInt(Settings.PREF_GUIDE_FLAGS);
//        if (!this.mPortraitMode && (j & 1) > 0 && LearnRecordManager.getInstance().getKillCount() == 0) {
//            this.mKillView.setVisibility(4);
//            this.mCancelKillView.setVisibility(4);
//        } else if (z) {
//            this.mKillView.setVisibility(8);
//            this.mCancelKillView.setVisibility(0);
//        } else {
//            this.mKillView.setVisibility(0);
//            this.mCancelKillView.setVisibility(8);
//        }
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.voice /*2131296350*/:
//                this.mAudioPlayer.setOnPlaySateListener(null);
//                this.mVoice.setImageDrawable(mVoiceAnim);
//                mVoiceAnim.start();
//                ZPackUtils.loadAudioCompat(this.mAudioPlayer, this.mTopic, this.mTopic.sentenceAudio);
//                this.mAudioPlayer.setOnPlaySateListener(new OnPlaySateListener() {
//                    public void onPlayStateChanged(State state) {
//                        if (state == State.Completed || state == State.Stopped || state == State.Paused) {
//                            WikiFragment.mVoiceAnim.stop();
//                            WikiFragment.this.mVoice.setImageResource(ThemeUtil.getThemeResourceIdWithAttr(WikiFragment.this.getActivity(), R.attr.drawable_wiki_sound));
//                            WikiFragment.this.mAudioPlayer.setOnPlaySateListener(null);
//                        }
//                    }
//                });
//                return;
//            case R.id.kill /*2131296351*/:
//                if (PropertyHelper.getBoolean(PropertyHelper.SOUND_EFFECT, true)) {
//                    this.mAudioPlayer.newPlayRaw(R.raw.chop);
//                }
//                LearnRecordManager.getInstance().kill(this.mTopic.topicId, 0);
//                updateKillStatus(true);
//                if (this.mListener != null) {
//                    this.mListener.onWikiExit();
//                    return;
//                }
//                return;
//            case R.id.basic_panel /*2131296652*/:
//                if (this.mWordView != null) {
//                    this.mWordView.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.heart_beat));
//                }
//                ZPackUtils.loadAudioCompat(this.mAudioPlayer, this.mTopic, this.mTopic.wordAudio);
//                return;
//            case R.id.share /*2131296654*/:
//                this.mWikiShareDialog = new WikiShareDialog(getActivity());
//                this.mWikiShareDialog.setShareClickListener(this);
//                this.mWikiShareDialog.show();
//                return;
//            case R.id.cancel_kill /*2131296659*/:
//                LearnRecordManager.getInstance().cancelKill(this.mTopic.topicId);
//                updateKillStatus(false);
//                return;
//            case R.id.continue_learn /*2131296660*/:
//                if (this.mListener != null) {
//                    this.mListener.onWikiExit();
//                    return;
//                }
//                return;
//            case R.id.share_weixin_timeline /*2131297009*/:
//                share(1);
//                return;
//            case R.id.share_weixin_friends /*2131297010*/:
//                share(0);
//                return;
//            case R.id.translate /*2131297120*/:
//                if (this.mSentenceTransView == null) {
//                    return;
//                }
//                if (this.mSentenceTransView.getVisibility() == 0) {
//                    this.mSentenceTransView.setVisibility(4);
//                    return;
//                } else {
//                    this.mSentenceTransView.setVisibility(0);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    private void share(final int i) {
//        C11244 r0 = new ThriftRequest<Client, BBWordShareInfo>(BaicizhanThrifts.WORDS) {
//            /* access modifiers changed from: protected */
//            public BBWordShareInfo doInBackground(Client client) {
//                int i = WikiFragment.this.mTopic.topicId;
//                int currentBookId = StudyManager.getInstance().getCurrentBookId();
//                int zpkTagIdCompat = ZPackUtils.getZpkTagIdCompat(WikiFragment.this.mTopic);
//                client.word_share_notify(i, currentBookId);
//                return client.get_word_share_info_v2(i, currentBookId, zpkTagIdCompat);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                WikiFragment.this.mProgressDialog.dismiss();
//                Toast.makeText(WikiFragment.this.getActivity(), "呀！没有网络怎么分享", 0).show();
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(BBWordShareInfo bBWordShareInfo) {
//                WikiFragment.this.mProgressDialog.dismiss();
//                WikiFragment.this.shareToWeixin(bBWordShareInfo, i);
//            }
//        };
//        r0.setTag(TAG);
//        BaicizhanThrifts.getProxy().add(r0);
//        this.mProgressDialog = CommonUtils.createProgressDialog(getActivity());
//        this.mProgressDialog.show();
//    }
//
//    /* access modifiers changed from: private */
//    public void shareToWeixin(BBWordShareInfo bBWordShareInfo, int i) {
//        this.mWXShareProxy.share(new WeixinShare(getActivity(), bBWordShareInfo.getUrl(), bBWordShareInfo.getDesc(), bBWordShareInfo.getTitle(), BitmapFactory.decodeResource(getResources(), R.drawable.business_baicizhan), i, this.mShareCallback), this.mPortraitMode);
//    }
//
//    public void stopMedia() {
//        if (this.mVideoView != null) {
//            this.mVideoView.pause();
//            this.mVideoView.reset(true);
//        }
//        this.mAudioPlayer.stop();
//    }
//
//    /* access modifiers changed from: private */
//    public void fetchSimilarRecords(final SimilarWordRecord similarWordRecord) {
//        if (similarWordRecord != null) {
//            TopicRecord similarTopicRecord = TopicResourceManager.getInstance().getSimilarTopicRecord(similarWordRecord.similar_word_book_id, similarWordRecord.similar_word_id);
//            if (similarTopicRecord != null) {
//                showSimilarWordDialog(similarWordRecord, similarTopicRecord);
//                return;
//            }
//            BaicizhanThrifts.getProxy().cancelAllWithTag(TAG);
//            C11255 r0 = new ThriftRequest<Client, TopicRecord>(BaicizhanThrifts.WORDS) {
//                /* access modifiers changed from: protected */
//                public TopicRecord doInBackground(Client client) {
//                    TopicRecord topicRecord;
//                    ArrayList arrayList = new ArrayList(WikiFragment.this.mSimilarWords.size());
//                    for (SimilarWordRecord similarWordRecord : WikiFragment.this.mSimilarWords) {
//                        BBGetWordAssetInfoArg bBGetWordAssetInfoArg = new BBGetWordAssetInfoArg();
//                        bBGetWordAssetInfoArg.setBook_id(similarWordRecord.similar_word_book_id);
//                        bBGetWordAssetInfoArg.setTopic_id(similarWordRecord.similar_word_id);
//                        arrayList.add(bBGetWordAssetInfoArg);
//                    }
//                    List<BBGetWordAssetInfoResult> list = client.get_word_assets_info_by_topic_and_book_id(arrayList);
//                    TopicResourceManager instance = TopicResourceManager.getInstance();
//                    TopicRecord topicRecord2 = null;
//                    for (BBGetWordAssetInfoResult bBGetWordAssetInfoResult : list) {
//                        TopicRecord fromAssetInfo = TopicRecord.fromAssetInfo(bBGetWordAssetInfoResult.getAsset_info());
//                        instance.putSimilarTopicRecord(bBGetWordAssetInfoResult.getBook_id(), fromAssetInfo);
//                        if (bBGetWordAssetInfoResult.getBook_id() == similarWordRecord.similar_word_book_id && bBGetWordAssetInfoResult.getTopic_id() == similarWordRecord.similar_word_id) {
//                            topicRecord = fromAssetInfo;
//                        } else {
//                            topicRecord = topicRecord2;
//                        }
//                        topicRecord2 = topicRecord;
//                    }
//                    if (topicRecord2 != null) {
//                        return topicRecord2;
//                    }
//                    throw new Exception("Similar word null");
//                }
//
//                /* access modifiers changed from: protected */
//                public void onError(Exception exc) {
//                    WikiFragment.this.mProgressDialog.dismiss();
//                    Toast.makeText(WikiFragment.this.getActivity(), "网络不佳，无法加载易混词详细信息", 1).show();
//                }
//
//                /* access modifiers changed from: protected */
//                public void onResult(TopicRecord topicRecord) {
//                    WikiFragment.this.mProgressDialog.dismiss();
//                    if (topicRecord != null) {
//                        WikiFragment.this.showSimilarWordDialog(similarWordRecord, topicRecord);
//                    }
//                }
//            };
//            r0.setTag(TAG);
//            BaicizhanThrifts.getProxy().add(r0);
//            this.mProgressDialog = CommonUtils.createProgressDialog(getActivity());
//            this.mProgressDialog.show();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void showSimilarWordDialog(SimilarWordRecord similarWordRecord, TopicRecord topicRecord) {
//        this.mSimilarWordDialog = new SimilarWordDialog(getActivity(), this.mPortraitMode, similarWordRecord, this.mTopic, topicRecord);
//        this.mSimilarWordDialog.show();
//    }
//}
