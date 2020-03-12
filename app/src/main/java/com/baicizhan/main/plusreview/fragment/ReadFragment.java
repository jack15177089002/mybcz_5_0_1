//package com.baicizhan.main.plusreview.fragment;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.os.Handler;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.animation.AlphaAnimation;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//import android.widget.ViewSwitcher;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.CustomFont;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.TopicTextRenderHelper;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.main.fragment.PatternBaseFragment;
//import com.baicizhan.main.plusreview.data.RecognitionCache;
//import com.baicizhan.main.plusreview.data.RecognitionData;
//import com.baicizhan.main.plusreview.view.QuizStateVoiceView;
//import com.baicizhan.main.plusreview.view.QuizStateVoiceView.Initializer;
//import com.baicizhan.main.plusreview.view.QuizStateVoiceView.OnMicToggleListener;
//import com.baicizhan.main.utils.ResidentBitmapCache;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.RequestCreator;
//import edu.cmu.pocketsphinx.RecognitionListener;
//import edu.cmu.pocketsphinx.RecognizerWorker;
//import java.lang.ref.WeakReference;
//import java.util.Locale;
//import java.util.Map;
//
//public class ReadFragment extends PatternBaseFragment implements OnClickListener, OnMicToggleListener, RecognitionListener {
//    private static final int MAX_VOL_NUM = 6;
//    private boolean mAnswered;
//    private boolean mCanRecog;
//    /* access modifiers changed from: private */
//    public TextView mCnmean;
//    private DelayDispRun mDelayDispRun;
//    private TextView mEnmeanView;
//    private TextView mExampleView;
//    /* access modifiers changed from: private */
//    public Handler mHandler;
//    private boolean mHasHint;
//    private int mHintLevel;
//    private ViewSwitcher mHintSwitcher;
//    private ImageView mImage;
//    private ImageView[] mOptTags;
//    /* access modifiers changed from: private */
//    public ViewGroup[] mOpts;
//    /* access modifiers changed from: private */
//    public ViewGroup mOptsContainer;
//    /* access modifiers changed from: private */
//    public RecognizerWorker mRW;
//    private RecognitionData mRecogData;
//    private RecogRun mRecogRun;
//    /* access modifiers changed from: private */
//    public boolean mRecognizing;
//    private int mRightIndex;
//    private QuizStateVoiceView mVoiceView;
//
//    class DelayDispRun implements Runnable {
//        final WeakReference<ReadFragment> mFragment;
//
//        DelayDispRun(ReadFragment readFragment) {
//            this.mFragment = new WeakReference<>(readFragment);
//        }
//
//        public void run() {
//            ReadFragment readFragment = (ReadFragment) this.mFragment.get();
//            if (readFragment != null) {
//                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
//                alphaAnimation.setDuration(300);
//                if (readFragment.mCnmean.getVisibility() != 0) {
//                    readFragment.mCnmean.setVisibility(0);
//                    readFragment.mCnmean.startAnimation(alphaAnimation);
//                    readFragment.mHandler.postDelayed(this, 2000);
//                    return;
//                }
//                readFragment.mOptsContainer.setVisibility(0);
//                readFragment.mOptsContainer.startAnimation(alphaAnimation);
//                for (ViewGroup onClickListener : readFragment.mOpts) {
//                    onClickListener.setOnClickListener(readFragment);
//                }
//            }
//        }
//    }
//
//    class RecogRun implements Runnable {
//        final WeakReference<ReadFragment> mFragment;
//
//        RecogRun(ReadFragment readFragment) {
//            this.mFragment = new WeakReference<>(readFragment);
//        }
//
//        public void run() {
//            ReadFragment readFragment = (ReadFragment) this.mFragment.get();
//            if (readFragment != null) {
//                readFragment.mRW.mo18380c();
//                readFragment.mRecognizing = true;
//            }
//        }
//    }
//
//    public ReadFragment(Context context) {
//        this(context, null, 0);
//    }
//
//    public ReadFragment(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        this.mOpts = new ViewGroup[4];
//        this.mOptTags = new ImageView[4];
//        this.mRightIndex = 0;
//        this.mHandler = new Handler();
//        this.mCanRecog = true;
//        this.mRecognizing = false;
//        this.mHintLevel = 0;
//        this.mHasHint = true;
//        this.mAnswered = false;
//        onCreateView(LayoutInflater.from(context), this);
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.plusreview_fragment_read, viewGroup, true);
//        this.mExampleView = (TextView) viewGroup2.findViewById(R.id.plusreview_read_exam);
//        this.mEnmeanView = (TextView) viewGroup2.findViewById(R.id.plusreview_read_enmean);
//        this.mHintSwitcher = (ViewSwitcher) viewGroup2.findViewById(R.id.hint_switcher);
//        this.mImage = (ImageView) viewGroup2.findViewById(R.id.plusreview_read_image);
//        ThemeResUtil.setCardBg(getContext(), this.mImage);
//        this.mVoiceView = (QuizStateVoiceView) viewGroup2.findViewById(R.id.plusreview_read_voice);
//        this.mCnmean = (TextView) viewGroup2.findViewById(R.id.plusreview_read_cnmean);
//        this.mOptsContainer = (ViewGroup) viewGroup2.findViewById(R.id.plusreview_read_opts);
//        int i = 0;
//        while (true) {
//            int i2 = i;
//            if (i2 >= 4) {
//                return viewGroup2;
//            }
//            this.mOpts[i2] = (ViewGroup) this.mOptsContainer.getChildAt(i2);
//            this.mOpts[i2].setTag(Integer.valueOf(i2));
//            this.mOptTags[i2] = (ImageView) this.mOpts[i2].getChildAt(1);
//            i = i2 + 1;
//        }
//    }
//
//    private void initValues() {
//        Map datas = RecognitionCache.getCache().getDatas();
//        if (datas == null || datas.isEmpty()) {
//            this.mCanRecog = false;
//            return;
//        }
//        this.mRecogData = (RecognitionData) datas.get(Integer.valueOf(this.mRightOption.topicId));
//        if (this.mRecogData == null) {
//            this.mCanRecog = false;
//        } else if (!RecognizerWorker.m5376a()) {
//            this.mCanRecog = false;
//        } else {
//            RecognizerWorker b = RecognizerWorker.m5377b();
//            b.f5724d = this;
//            b.f5722b = this.mRecogData.getDicPath();
//            b.f5723c = this.mRecogData.getDmpPath();
//            b.f5721a = RecognitionData.VOICE_MODEL_PATH;
//            this.mRW = b;
//            if (isVoiceRecogEnabled()) {
//                this.mRecogRun = new RecogRun(this);
//                this.mHandler.postDelayed(this.mRecogRun, 300);
//                return;
//            }
//            this.mRecognizing = false;
//        }
//    }
//
//    public void onUpdateViews() {
//        boolean z;
//        boolean z2;
//        int i;
//        int i2;
//        this.mAnswered = false;
//        initValues();
//        this.mVoiceView.resetAnswer();
//        String str = this.mRightOption.sentence;
//        int[] firstMatchWordBorder = TopicTextRenderHelper.getFirstMatchWordBorder(this.mRightOption);
//        if (firstMatchWordBorder != null) {
//            str = str.replaceFirst(str.substring(firstMatchWordBorder[0], firstMatchWordBorder[1]), "____");
//        } else {
//            int[][] matchWordBorders = TopicTextRenderHelper.getMatchWordBorders(this.mRightOption);
//            if (matchWordBorders != null) {
//                String[] strArr = new String[matchWordBorders.length];
//                int length = matchWordBorders.length;
//                int i3 = 0;
//                int i4 = 0;
//                while (i3 < length) {
//                    int[] iArr = matchWordBorders[i3];
//                    int i5 = i4 + 1;
//                    strArr[i4] = str.substring(iArr[0], iArr[1]);
//                    i3++;
//                    i4 = i5;
//                }
//                int length2 = strArr.length;
//                int i6 = 0;
//                while (i6 < length2) {
//                    String replaceFirst = str.replaceFirst(strArr[i6], "____");
//                    i6++;
//                    str = replaceFirst;
//                }
//            }
//        }
//        this.mExampleView.setText(str);
//        this.mEnmeanView.setText(this.mRightOption.wordMeanEn);
//        if (!TextUtils.isEmpty(this.mRightOption.wordMeanEn)) {
//            z = true;
//        } else {
//            z = false;
//        }
//        this.mHasHint = z;
//        RequestCreator b = ZPackUtils.loadImageCompat(this.mRightOption, this.mRightOption.imagePath).error(R.drawable.image_broke_normal_default);
//        b.f3707c = true;
//        b.into(this.mImage, (Callback) null);
//        if (!isVoiceRecogEnabled() || !this.mCanRecog) {
//            z2 = false;
//        } else {
//            z2 = true;
//        }
//        new Initializer().wrap(this.mVoiceView).setMaxVol(6).setMicToggleListener(this).setOn(z2).setRightWord(this.mRightOption.word).initialize();
//        if (!this.mCanRecog) {
//            this.mVoiceView.setVisibility(8);
//        } else {
//            this.mVoiceView.setVisibility(0);
//        }
//        this.mCnmean.setText(this.mRightOption.wordMean);
//        TextView textView = this.mCnmean;
//        if (z2) {
//            i = 4;
//        } else {
//            i = 0;
//        }
//        textView.setVisibility(i);
//        ViewGroup viewGroup = this.mOptsContainer;
//        if (z2) {
//            i2 = 4;
//        } else {
//            i2 = 0;
//        }
//        viewGroup.setVisibility(i2);
//        if (z2) {
//            this.mDelayDispRun = new DelayDispRun(this);
//            this.mHandler.postDelayed(this.mDelayDispRun, 1000);
//        }
//        for (int i7 = 0; i7 < 4; i7++) {
//            TopicRecord topicRecord = (TopicRecord) this.mTopicOptions.get(i7);
//            int i8 = topicRecord.topicId;
//            ViewGroup viewGroup2 = (ViewGroup) this.mOpts[i7].getChildAt(0);
//            ((TextView) viewGroup2.getChildAt(0)).setText(topicRecord.word);
//            TextView textView2 = (TextView) viewGroup2.getChildAt(1);
//            CustomFont.setFont(textView2, 3);
//            textView2.setText(topicRecord.phonetic);
//            if (isRight(i8)) {
//                ResidentBitmapCache.setImageResource(this.mOptTags[i7], R.drawable.right_mid_normal_default);
//                this.mRightIndex = i7;
//            } else {
//                ResidentBitmapCache.setImageResource(this.mOptTags[i7], R.drawable.wrong_mid_normal_default);
//            }
//            this.mOptTags[i7].setVisibility(8);
//            if (!z2) {
//                this.mOpts[i7].setOnClickListener(this);
//            }
//        }
//    }
//
//    private static boolean isVoiceRecogEnabled() {
//        return Settings.getBoolean(Settings.PREF_VOICE_RECOG_ENABLED, true);
//    }
//
//    private static void setVoiceRecogEnabled(boolean z) {
//        Settings.putBoolean(Settings.PREF_VOICE_RECOG_ENABLED, z);
//    }
//
//    public void onDetach() {
//        super.onDetach();
//        this.mHandler.removeCallbacks(this.mDelayDispRun);
//        this.mHandler.removeCallbacks(this.mRecogRun);
//        if (this.mRecognizing) {
//            if (!this.mRW.mo18383f()) {
//                this.mRW.mo18382e();
//            }
//            this.mRecognizing = false;
//        }
//        if (this.mRW != null) {
//            this.mRW = null;
//        }
//        hintFirst();
//        this.mHintLevel = 0;
//        if (this.mAnswered) {
//            OperationStats.statMoreReviewDuju();
//        }
//    }
//
//    public boolean hint() {
//        if (!this.mHasHint) {
//            Toast.makeText(getContext(), R.string.no_hint, 0).show();
//            return false;
//        }
//        this.mHintLevel++;
//        if (this.mHintLevel < this.mHintSwitcher.getChildCount()) {
//            hint(this.mHintLevel);
//            return true;
//        }
//        this.mHintLevel = 0;
//        hint(0);
//        return false;
//    }
//
//    private void hint(int i) {
//        this.mHintSwitcher.setDisplayedChild(i);
//    }
//
//    private void hintFirst() {
//        if (this.mHintSwitcher.getDisplayedChild() != 0) {
//            this.mHintSwitcher.setDisplayedChild(0);
//        }
//    }
//
//    public void sound() {
//    }
//
//    public void clearOptionMask(boolean z) {
//        for (int i = 0; i < this.mOptTags.length; i++) {
//            if (this.mOptTags[i].getVisibility() != 0 || !z) {
//                this.mOptTags[i].setVisibility(8);
//                this.mOpts[i].setOnClickListener(this);
//            }
//        }
//        if (!this.mRecognizing && this.mRW != null) {
//            this.mRW.mo18380c();
//            this.mRecognizing = true;
//        }
//    }
//
//    public void onMicToggle(boolean z) {
//        if (!this.mRW.mo18383f()) {
//            if (z && !this.mRecognizing) {
//                this.mRW.mo18380c();
//                this.mRecognizing = true;
//                setVoiceRecogEnabled(true);
//            } else if (!z && this.mRecognizing) {
//                this.mRW.mo18381d();
//                this.mRecognizing = false;
//                setVoiceRecogEnabled(false);
//            }
//        }
//    }
//
//    public void onClick(View view) {
//        int intValue = ((Integer) view.getTag()).intValue();
//        this.mOptTags[intValue].setVisibility(0);
//        for (ViewGroup onClickListener : this.mOpts) {
//            onClickListener.setOnClickListener(null);
//        }
//        if (isRight(((TopicRecord) this.mTopicOptions.get(intValue)).topicId)) {
//            if (this.mRecognizing) {
//                if (!this.mRW.mo18383f()) {
//                    this.mRW.mo18382e();
//                }
//                this.mRecognizing = false;
//            }
//        } else if (this.mRecognizing) {
//            this.mRW.mo18381d();
//            this.mRecognizing = false;
//        }
//        answer(((TopicRecord) this.mTopicOptions.get(intValue)).topicId);
//        this.mAnswered = true;
//    }
//
//    public void onPartialResults(Bundle bundle) {
//        double d = bundle.getDouble("volume");
//        String string = bundle.getString("hyp");
//        int i = bundle.getInt("recordBuffSizeCount");
//        if (string != null && string.toLowerCase(Locale.US).indexOf(this.mRightOption.word.toLowerCase()) >= 0 && this.mRecognizing) {
//            this.mVoiceView.giveAnswer();
//            this.mOptTags[this.mRightIndex].setVisibility(0);
//            for (ViewGroup onClickListener : this.mOpts) {
//                onClickListener.setOnClickListener(null);
//            }
//            answer(((TopicRecord) this.mTopicOptions.get(this.mRightIndex)).topicId);
//            if (!this.mRW.mo18383f()) {
//                this.mRW.mo18382e();
//            }
//            this.mRecognizing = false;
//            this.mAnswered = true;
//        }
//        this.mVoiceView.setVolume((int) (d / 12.0d));
//        if (1260 == i) {
//            Toast.makeText(getContext(), getContext().getResources().getString(R.string.plusreview_read_recog_too_long), 0).show();
//            if (!this.mRW.mo18383f()) {
//                this.mRW.mo18382e();
//            }
//            this.mRecognizing = false;
//            this.mVoiceView.setVisibility(8);
//        }
//    }
//
//    public void onResults(Bundle bundle) {
//    }
//
//    public void onError(int i) {
//        if (!this.mRW.mo18383f()) {
//            this.mRW.mo18382e();
//        }
//        this.mRecognizing = false;
//        this.mVoiceView.setVisibility(8);
//    }
//}
