//package com.baicizhan.main.fragment;
//
//import android.content.Context;
//import android.graphics.Point;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.ViewAnimator;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.util.CustomFont;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.TopicTextRenderHelper;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.utils.ResidentBitmapCache;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.Callback;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PatternPicToChinFragment extends PatternBaseFragment implements OnClickListener {
//    private static final String TAG = PatternPicToChinFragment.class.getSimpleName();
//    private TextView mCnMean;
//    private ImageView mDeformationImageView;
//    private TextView mEnMean;
//    private int mHeightBig;
//    private int mHeightSmall;
//    View mHintDivider;
//    List<Integer> mHintIndex;
//    int mHintLevel;
//    ViewAnimator mHintSwitcher;
//    ImageView[] mOptionMasks;
//    TextView[] mOptionMeans;
//    View[] mOptions;
//    private TextView mPhoneticView;
//    private ImageView mQuestionView;
//    private TextView mSentence;
//    ImageView mTopicImage;
//    private int mWidthBig;
//    private int mWidthSmall;
//    /* access modifiers changed from: private */
//    public TextView mWordTextView;
//
//    public PatternPicToChinFragment(Context context) {
//        this(context, null, 0);
//    }
//
//    public PatternPicToChinFragment(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        this.mHintLevel = -1;
//        this.mHintIndex = new ArrayList(3);
//        this.mOptionMeans = new TextView[4];
//        this.mOptionMasks = new ImageView[4];
//        this.mOptions = new View[4];
//        onCreateView(LayoutInflater.from(context), this);
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
//        View inflate;
//        if (PropertyHelper.getBoolean("portrait_mode")) {
//            inflate = layoutInflater.inflate(R.layout.fragment_learning_example_pattern_pic_to_chin_portrait, viewGroup, true);
//        } else {
//            inflate = layoutInflater.inflate(R.layout.fragment_learning_example_pattern_pic_to_chin, viewGroup, true);
//        }
//        this.mDeformationImageView = (ImageView) inflate.findViewById(R.id.topic_deformation_image);
//        this.mQuestionView = (ImageView) inflate.findViewById(R.id.question);
//        this.mWordTextView = (TextView) inflate.findViewById(R.id.topic_word);
//        this.mPhoneticView = (TextView) inflate.findViewById(R.id.topic_phonetic);
//        CustomFont.setFont(this.mPhoneticView, 3);
//        this.mHintDivider = inflate.findViewById(R.id.hint_divider);
//        this.mHintSwitcher = (ViewAnimator) inflate.findViewById(R.id.hint_switcher);
//        this.mSentence = (TextView) inflate.findViewById(R.id.topic_sentence);
//        this.mTopicImage = (ImageView) inflate.findViewById(R.id.topic_image);
//        this.mEnMean = (TextView) inflate.findViewById(R.id.topic_mean_en);
//        this.mCnMean = (TextView) inflate.findViewById(R.id.topic_mean_cn);
//        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.option_container);
//        C11111 r1 = new OnClickListener() {
//            public void onClick(View view) {
//                if (PatternPicToChinFragment.this.mWordTextView.getVisibility() == 8) {
//                    PatternPicToChinFragment.this.mWordTextView.setVisibility(0);
//                } else {
//                    PatternPicToChinFragment.this.mWordTextView.setVisibility(8);
//                }
//            }
//        };
//        this.mQuestionView.setOnClickListener(r1);
//        this.mDeformationImageView.setOnClickListener(r1);
//        this.mHintSwitcher.setInAnimation(getContext(), R.anim.business_push_up_in);
//        for (int i = 0; i < 4; i++) {
//            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getChildAt(i);
//            TextView textView = (TextView) viewGroup3.getChildAt(0);
//            ImageView imageView = (ImageView) viewGroup3.getChildAt(1);
//            this.mOptions[i] = viewGroup3;
//            this.mOptions[i].setSoundEffectsEnabled(false);
//            this.mOptionMeans[i] = textView;
//            this.mOptionMasks[i] = imageView;
//            viewGroup3.setTag(Integer.valueOf(i));
//        }
//        return inflate;
//    }
//
//    public void onUpdateViews() {
//        int i = 0;
//        this.mWordTextView.setText(this.mRightOption.word);
//        if (TextUtils.isEmpty(this.mRightOption.phonetic)) {
//            this.mPhoneticView.setVisibility(8);
//        } else {
//            this.mPhoneticView.setVisibility(0);
//            this.mPhoneticView.setText(this.mRightOption.phonetic);
//        }
//        if (ZPackUtils.resourceFileExistsCompat(this.mRightOption, this.mRightOption.deformationImagePath)) {
//            this.mDeformationImageView.setVisibility(0);
//            if (ThemeUtil.getCurrentSettingThemeId() == R.style.StandardNight) {
//                this.mDeformationImageView.setBackgroundColor(getContext().getResources().getColor(R.color.C42));
//            }
//            this.mDeformationImageView.setImageDrawable(null);
//            Point calcBitmapSizeCompat = ZPackUtils.calcBitmapSizeCompat(this.mRightOption, this.mRightOption.deformationImagePath);
//            int dpToPx = DisplayUtils.dpToPx(getContext(), 240.0f);
//            int dpToPx2 = DisplayUtils.dpToPx(getContext(), 180.0f);
//            if (calcBitmapSizeCompat == null || calcBitmapSizeCompat.x <= 0 || calcBitmapSizeCompat.y <= 0) {
//                this.mWidthBig = dpToPx;
//                this.mHeightBig = dpToPx2;
//            } else {
//                float min = Math.min(((float) dpToPx) / ((float) calcBitmapSizeCompat.x), ((float) dpToPx2) / ((float) calcBitmapSizeCompat.y));
//                this.mWidthBig = (int) (((float) calcBitmapSizeCompat.x) * min);
//                this.mHeightBig = (int) (((float) calcBitmapSizeCompat.y) * min);
//            }
//            this.mWidthSmall = (int) (((double) this.mWidthBig) * 0.6d);
//            this.mHeightSmall = (int) (((double) this.mHeightBig) * 0.6d);
//            updateDeformationImageSize(-1);
//            ZPackUtils.loadImageCompat(this.mRightOption, this.mRightOption.deformationImagePath).error(R.drawable.image_broke_normal_default).into(this.mDeformationImageView, (Callback) null);
//            this.mQuestionView.setVisibility(0);
//            this.mWordTextView.setVisibility(8);
//            this.mWordTextView.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_button_text_mediabar));
//            this.mWordTextView.setTextSize(0, (float) getContext().getResources().getDimensionPixelSize(R.dimen.T3));
//        } else {
//            this.mDeformationImageView.setVisibility(8);
//            this.mQuestionView.setVisibility(8);
//            this.mWordTextView.setVisibility(0);
//            this.mWordTextView.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_list_text2));
//            this.mWordTextView.setTextSize(0, (float) getContext().getResources().getDimensionPixelSize(R.dimen.T9));
//        }
//        this.mHintIndex.clear();
//        if (!TextUtils.isEmpty(this.mRightOption.sentence)) {
//            TopicTextRenderHelper.showClickableHighlightSentence(this.mSentence, this.mRightOption.word, this.mRightOption.sentence);
//            if (!TextUtils.isEmpty(this.mRightOption.sentenceTrans)) {
//                this.mSentence.append("\n" + this.mRightOption.sentenceTrans);
//            }
//        } else {
//            this.mSentence.setText("");
//        }
//        this.mTopicImage.setImageDrawable(null);
//        ZPackUtils.loadImageCompat(this.mRightOption, this.mRightOption.imagePath).error(R.drawable.image_broke_normal_default).into(this.mTopicImage, (Callback) null);
//        this.mHintIndex.add(Integer.valueOf(0));
//        if (!TextUtils.isEmpty(this.mRightOption.wordMeanEn)) {
//            TopicTextRenderHelper.showWordMeanEn(this.mEnMean, this.mRightOption);
//            this.mHintIndex.add(Integer.valueOf(1));
//        }
//        if (!TextUtils.isEmpty(this.mRightOption.wordMean)) {
//            TopicTextRenderHelper.showWordMeanCn(this.mCnMean, this.mRightOption);
//            this.mHintIndex.add(Integer.valueOf(2));
//        }
//        while (true) {
//            int i2 = i;
//            if (i2 < 4) {
//                TopicRecord topicRecord = (TopicRecord) this.mTopicOptions.get(i2);
//                this.mOptions[i2].setOnClickListener(this);
//                this.mOptionMeans[i2].setText(topicRecord.wordMean);
//                this.mOptionMasks[i2].setVisibility(4);
//                ResidentBitmapCache.setImageResource(this.mOptionMasks[i2], isRight(topicRecord.topicId) ? R.drawable.right_mid_normal_default : R.drawable.wrong_mid_normal_default);
//                i = i2 + 1;
//            } else {
//                this.mHintLevel = -1;
//                hint(this.mHintLevel);
//                return;
//            }
//        }
//    }
//
//    public boolean hint() {
//        if (this.mHintLevel == this.mHintIndex.size() - 1) {
//            return false;
//        }
//        this.mHintLevel++;
//        hint(this.mHintLevel);
//        return true;
//    }
//
//    private void hint(int i) {
//        if (i == -1) {
//            this.mHintDivider.setVisibility(8);
//            this.mHintSwitcher.setVisibility(8);
//        } else {
//            this.mHintDivider.setVisibility(0);
//            this.mHintSwitcher.setVisibility(0);
//            this.mPhoneticView.setVisibility(8);
//            this.mHintSwitcher.setDisplayedChild(((Integer) this.mHintIndex.get(i)).intValue());
//            if (this.mHintSwitcher.getCurrentView().getId() == R.id.topic_sentence_hint) {
//                ZPackUtils.loadAudioCompat(this.mAudioPlayer, this.mRightOption, this.mRightOption.sentenceAudio);
//            } else {
//                ZPackUtils.loadAudioCompat(this.mAudioPlayer, this.mRightOption, this.mRightOption.wordAudio);
//            }
//        }
//        updateDeformationImageSize(i);
//    }
//
//    private void updateDeformationImageSize(int i) {
//        int i2 = i >= 0 ? this.mWidthSmall : this.mWidthBig;
//        int i3 = i >= 0 ? this.mHeightSmall : this.mHeightBig;
//        LayoutParams layoutParams = this.mDeformationImageView.getLayoutParams();
//        layoutParams.width = i2;
//        layoutParams.height = i3;
//        this.mDeformationImageView.setLayoutParams(layoutParams);
//    }
//
//    public void sound() {
//        ZPackUtils.loadAudioCompat(this.mAudioPlayer, this.mRightOption, this.mRightOption.wordAudio);
//    }
//
//    public void clearOptionMask(boolean z) {
//        for (int i = 0; i < 4; i++) {
//            if (this.mOptionMasks[i].getVisibility() != 0 || !z) {
//                this.mOptionMasks[i].setVisibility(4);
//                this.mOptions[i].setOnClickListener(this);
//            }
//        }
//    }
//
//    public void onDetach() {
//        super.onDetach();
//        this.mDeformationImageView.setImageDrawable(null);
//        this.mTopicImage.setImageDrawable(null);
//    }
//
//    public void onClick(View view) {
//        int intValue = ((Integer) view.getTag()).intValue();
//        int i = ((TopicRecord) this.mTopicOptions.get(intValue)).topicId;
//        this.mOptionMasks[intValue].setVisibility(0);
//        for (View onClickListener : this.mOptions) {
//            onClickListener.setOnClickListener(null);
//        }
//        answer(i);
//    }
//}
