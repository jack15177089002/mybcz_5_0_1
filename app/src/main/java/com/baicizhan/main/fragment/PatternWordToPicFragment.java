//package com.baicizhan.main.fragment;
//
//import android.content.Context;
//import android.graphics.drawable.GradientDrawable;
//import android.text.TextUtils;
//import android.text.style.ForegroundColorSpan;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.ViewAnimator;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.util.CustomFont;
//import com.baicizhan.client.business.util.SimpleSpannableBuilder;
//import com.baicizhan.client.business.util.StringUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.TopicTextRenderHelper;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.utils.EtymaExtractor;
//import com.baicizhan.main.utils.ResidentBitmapCache;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.Callback;
//import java.util.ArrayList;
//import java.util.List;
//import org.slf4j.Marker;
//
//public class PatternWordToPicFragment extends PatternBaseFragment implements OnClickListener {
//    private static final int OPTION_IMAGE_INDEX = 0;
//    private static final int OPTION_MASK_INDEX = 2;
//    private static final int OPTION_MEAN_INDEX = 1;
//    private TextView mCnMean;
//    private TextView mEnMean;
//    CharSequence mEtymaText;
//    TextView mEtymaTextView;
//    private View mHintDivider;
//    private ViewAnimator mHintFlipper;
//    private List<Integer> mHintIndex;
//    /* access modifiers changed from: private */
//    public int mHintLevel;
//    ImageView[] mOptionImages;
//    ImageView[] mOptionMasks;
//    TextView[] mOptionMeans;
//    TextView mPhoneticTextView;
//    private TextView mSentence;
//    TextView mWordTextView;
//
//    public PatternWordToPicFragment(Context context) {
//        this(context, null, 0);
//    }
//
//    public PatternWordToPicFragment(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        this.mHintIndex = new ArrayList(3);
//        this.mOptionMasks = new ImageView[4];
//        this.mOptionImages = new ImageView[4];
//        this.mOptionMeans = new TextView[4];
//        onCreateView(LayoutInflater.from(context), this);
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
//        View inflate;
//        if (PropertyHelper.getBoolean("portrait_mode")) {
//            inflate = layoutInflater.inflate(R.layout.fragment_learning_example_pattern_word_to_pic_portrait, viewGroup, true);
//        } else {
//            inflate = layoutInflater.inflate(R.layout.fragment_learning_example_pattern_word_to_pic, viewGroup, true);
//        }
//        this.mWordTextView = (TextView) inflate.findViewById(R.id.topic_word);
//        this.mPhoneticTextView = (TextView) inflate.findViewById(R.id.topic_phonetic);
//        CustomFont.setFont(this.mPhoneticTextView, 3);
//        this.mEtymaTextView = (TextView) inflate.findViewById(R.id.topic_etyma);
//        this.mHintDivider = inflate.findViewById(R.id.hint_divider);
//        this.mHintFlipper = (ViewAnimator) inflate.findViewById(R.id.hint_switcher);
//        this.mSentence = (TextView) inflate.findViewById(R.id.topic_sentence);
//        this.mEnMean = (TextView) inflate.findViewById(R.id.topic_mean_en);
//        this.mCnMean = (TextView) inflate.findViewById(R.id.topic_mean_cn);
//        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.option_container);
//        this.mHintFlipper.setInAnimation(getContext(), R.anim.business_push_up_in);
//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setShape(0);
//        gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(getContext(), 4.0f));
//        gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_card_bg));
//        for (int i = 0; i < 4; i++) {
//            FrameLayout frameLayout = (FrameLayout) viewGroup2.getChildAt(i);
//            ImageView imageView = (ImageView) frameLayout.getChildAt(2);
//            TextView textView = (TextView) frameLayout.getChildAt(1);
//            this.mOptionImages[i] = (ImageView) frameLayout.getChildAt(0);
//            this.mOptionImages[i].setSoundEffectsEnabled(false);
//            this.mOptionMasks[i] = imageView;
//            this.mOptionMeans[i] = textView;
//            C1604j.m3631a(frameLayout, gradientDrawable);
//        }
//        return inflate;
//    }
//
//    public void onClick(View view) {
//        int intValue = ((Integer) view.getTag()).intValue();
//        int i = ((TopicRecord) this.mTopicOptions.get(intValue)).topicId;
//        this.mOptionMasks[intValue].setVisibility(0);
//        for (ImageView onClickListener : this.mOptionImages) {
//            onClickListener.setOnClickListener(null);
//        }
//        answer(i);
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
//            this.mHintFlipper.setVisibility(8);
//            foldEtyma();
//            return;
//        }
//        int intValue = ((Integer) this.mHintIndex.get(i)).intValue();
//        if (intValue == 0) {
//            this.mHintDivider.setVisibility(8);
//            this.mHintFlipper.setVisibility(8);
//            unfoldEtyma();
//            return;
//        }
//        this.mPhoneticTextView.setVisibility(8);
//        this.mHintDivider.setVisibility(0);
//        this.mHintFlipper.setVisibility(0);
//        this.mHintFlipper.setDisplayedChild(intValue - 1);
//        ZPackUtils.loadAudioCompat(this.mAudioPlayer, this.mRightOption, intValue == 1 ? this.mRightOption.sentenceAudio : this.mRightOption.wordAudio);
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
//                this.mOptionImages[i].setOnClickListener(this);
//            }
//        }
//    }
//
//    public void onUpdateViews() {
//        int i;
//        getContext().getResources().getDimensionPixelSize(R.dimen.T5);
//        int themeColorWithAttr = ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_text_blue);
//        this.mHintIndex.clear();
//        this.mWordTextView.setText(this.mRightOption.word);
//        if (TextUtils.isEmpty(this.mRightOption.phonetic)) {
//            this.mPhoneticTextView.setVisibility(8);
//        } else {
//            this.mPhoneticTextView.setText(this.mRightOption.phonetic);
//            this.mPhoneticTextView.setVisibility(0);
//        }
//        if (TextUtils.isEmpty(this.mRightOption.wordEtyma)) {
//            this.mWordTextView.setTextColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_darkblue));
//            this.mWordTextView.setOnClickListener(null);
//        } else {
//            this.mWordTextView.setTextColor(themeColorWithAttr);
//            List extractEtymaTokens = EtymaExtractor.extractEtymaTokens(this.mRightOption.word, this.mRightOption.wordEtyma);
//            int themeColorWithAttr2 = ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_text_review);
//            int themeColorWithAttr3 = ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_welcome_bg2);
//            if (extractEtymaTokens.size() > 0) {
//                SimpleSpannableBuilder simpleSpannableBuilder = new SimpleSpannableBuilder();
//                simpleSpannableBuilder.append((String) extractEtymaTokens.get(0), new ForegroundColorSpan(themeColorWithAttr));
//                for (int i2 = 1; i2 < extractEtymaTokens.size(); i2++) {
//                    simpleSpannableBuilder.append(Marker.ANY_NON_NULL_MARKER, new ForegroundColorSpan(themeColorWithAttr3));
//                    String str = (String) extractEtymaTokens.get(i2);
//                    Object[] objArr = new Object[1];
//                    if (i2 == extractEtymaTokens.size() - 1) {
//                        i = themeColorWithAttr;
//                    } else {
//                        i = themeColorWithAttr2;
//                    }
//                    objArr[0] = new ForegroundColorSpan(i);
//                    simpleSpannableBuilder.append(str, objArr);
//                }
//                this.mEtymaText = simpleSpannableBuilder.build();
//                this.mWordTextView.setOnClickListener(new OnClickListener() {
//                    public void onClick(View view) {
//                        if (PatternWordToPicFragment.this.mEtymaTextView.getVisibility() == 0) {
//                            PatternWordToPicFragment.this.foldEtyma();
//                            return;
//                        }
//                        if (PatternWordToPicFragment.this.mHintLevel < 0) {
//                            PatternWordToPicFragment.this.mHintLevel = 0;
//                        }
//                        PatternWordToPicFragment.this.unfoldEtyma();
//                    }
//                });
//                this.mEtymaTextView.setText(this.mRightOption.wordEtyma);
//                this.mHintIndex.add(Integer.valueOf(0));
//            }
//        }
//        this.mEtymaTextView.setVisibility(8);
//        if (!TextUtils.isEmpty(this.mRightOption.sentence)) {
//            TopicTextRenderHelper.showClickableHighlightSentence(this.mSentence, this.mRightOption.word, this.mRightOption.sentence);
//            if (!TextUtils.isEmpty(this.mRightOption.sentenceTrans)) {
//                this.mSentence.append("\n" + this.mRightOption.sentenceTrans);
//            }
//            this.mHintIndex.add(Integer.valueOf(1));
//        }
//        if (!TextUtils.isEmpty(this.mRightOption.wordMeanEn)) {
//            TopicTextRenderHelper.showWordMeanEn(this.mEnMean, this.mRightOption);
//            this.mHintIndex.add(Integer.valueOf(2));
//        }
//        if (!TextUtils.isEmpty(this.mRightOption.wordMean)) {
//            TopicTextRenderHelper.showWordMeanCn(this.mCnMean, this.mRightOption);
//            this.mHintIndex.add(Integer.valueOf(3));
//        }
//        for (int i3 = 0; i3 < 4; i3++) {
//            TopicRecord topicRecord = (TopicRecord) this.mTopicOptions.get(i3);
//            this.mOptionImages[i3].setImageDrawable(null);
//            ZPackUtils.loadImageCompat(topicRecord, topicRecord.imagePath).error(R.drawable.image_broke_normal_default).into(this.mOptionImages[i3], (Callback) null);
//            this.mOptionImages[i3].setTag(Integer.valueOf(i3));
//            this.mOptionImages[i3].setOnClickListener(this);
//            if (PropertyHelper.getBoolean(PropertyHelper.SHOW_IMAGE_MEAN)) {
//                this.mOptionMeans[i3].setText(StringUtil.unlines(topicRecord.wordMean));
//                this.mOptionMeans[i3].setVisibility(0);
//            } else {
//                this.mOptionMeans[i3].setVisibility(8);
//            }
//            this.mOptionMasks[i3].setVisibility(4);
//            ResidentBitmapCache.setImageResource(this.mOptionMasks[i3], isRight(topicRecord.topicId) ? R.drawable.right_big_normal_default : R.drawable.wrong_big_normal_default);
//        }
//        this.mHintLevel = -1;
//        hint(this.mHintLevel);
//    }
//
//    /* access modifiers changed from: private */
//    public void unfoldEtyma() {
//        if (this.mEtymaTextView.getVisibility() == 8) {
//            if (this.mListener != null) {
//                this.mListener.onHinted();
//            }
//            if (PropertyHelper.getBoolean(PropertyHelper.SOUND_EFFECT, true)) {
//                this.mAudioPlayer.newPlayRaw(R.raw.etyma_expand);
//            }
//            this.mEtymaTextView.setVisibility(0);
//            this.mWordTextView.setText(this.mEtymaText);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void foldEtyma() {
//        if (this.mEtymaTextView.getVisibility() == 0) {
//            this.mEtymaTextView.setVisibility(8);
//            this.mWordTextView.setText(this.mRightOption.word);
//        }
//    }
//
//    public void onDetach() {
//        super.onDetach();
//        for (ImageView imageDrawable : this.mOptionImages) {
//            imageDrawable.setImageDrawable(null);
//        }
//        clearOptionMask(false);
//    }
//}
