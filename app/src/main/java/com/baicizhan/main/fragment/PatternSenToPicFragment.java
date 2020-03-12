//package com.baicizhan.main.fragment;
//
//import android.content.Context;
//import android.graphics.drawable.GradientDrawable;
//import android.text.TextUtils;
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
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.TopicTextRenderHelper;
//import com.baicizhan.client.business.util.TopicTextRenderHelper.OnWordClickListener;
//import com.baicizhan.client.business.util.TopicTextRenderHelper.TopicTextRender;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.framework.audio.AudioPlayer.OnPlaySateListener;
//import com.baicizhan.client.framework.audio.AudioPlayer.State;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.utils.ResidentBitmapCache;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.Callback;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PatternSenToPicFragment extends PatternBaseFragment implements OnClickListener {
//    private TextView mCnMean;
//    private TextView mEnMean;
//    View mHintDivider;
//    private List<Integer> mHintIndex;
//    private int mHintLevel;
//    ViewAnimator mHintSwitcher;
//    ImageView[] mOptionImages;
//    ImageView[] mOptionMasks;
//    private TextView mSentence;
//    private TextView mTranslate;
//
//    public PatternSenToPicFragment(Context context) {
//        this(context, null, 0);
//    }
//
//    public PatternSenToPicFragment(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        this.mHintLevel = -1;
//        this.mHintIndex = new ArrayList(3);
//        this.mOptionMasks = new ImageView[4];
//        this.mOptionImages = new ImageView[4];
//        onCreateView(LayoutInflater.from(context), this);
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
//        View inflate;
//        if (PropertyHelper.getBoolean("portrait_mode")) {
//            inflate = layoutInflater.inflate(R.layout.fragment_learning_example_pattern_sen_to_pic_portrait, viewGroup, true);
//        } else {
//            inflate = layoutInflater.inflate(R.layout.fragment_learning_example_pattern_sen_to_pic, viewGroup, true);
//        }
//        this.mSentence = (TextView) inflate.findViewById(R.id.topic_sentence);
//        this.mHintDivider = inflate.findViewById(R.id.hint_divider);
//        this.mHintSwitcher = (ViewAnimator) inflate.findViewById(R.id.hint_switcher);
//        this.mTranslate = (TextView) inflate.findViewById(R.id.topic_sentence_translate);
//        this.mEnMean = (TextView) inflate.findViewById(R.id.topic_mean_en);
//        this.mCnMean = (TextView) inflate.findViewById(R.id.topic_mean_cn);
//        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.option_container);
//        this.mHintSwitcher.setInAnimation(getContext(), R.anim.business_push_up_in);
//        int dpToPx = DisplayUtils.dpToPx(getContext(), 4.0f);
//        int themeColorWithAttr = ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_card_bg);
//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setShape(0);
//        gradientDrawable.setCornerRadius((float) dpToPx);
//        gradientDrawable.setColor(themeColorWithAttr);
//        for (int i = 0; i < 4; i++) {
//            FrameLayout frameLayout = (FrameLayout) viewGroup2.getChildAt(i);
//            ImageView imageView = (ImageView) frameLayout.getChildAt(0);
//            frameLayout.getChildAt(1).setVisibility(8);
//            ImageView imageView2 = (ImageView) frameLayout.getChildAt(2);
//            this.mOptionImages[i] = imageView;
//            this.mOptionImages[i].setSoundEffectsEnabled(false);
//            this.mOptionMasks[i] = imageView2;
//            C1604j.m3631a(frameLayout, gradientDrawable);
//        }
//        this.mHintLevel = -1;
//        hint(this.mHintLevel);
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
//            this.mHintSwitcher.setVisibility(8);
//            return;
//        }
//        int intValue = ((Integer) this.mHintIndex.get(i)).intValue();
//        this.mHintDivider.setVisibility(0);
//        this.mHintSwitcher.setVisibility(0);
//        this.mHintSwitcher.setDisplayedChild(intValue);
//        ZPackUtils.loadAudioCompat(this.mAudioPlayer, this.mRightOption, this.mRightOption.wordAudio);
//    }
//
//    public void sound() {
//        if (ZPackUtils.loadAudioCompat(this.mAudioPlayer, this.mRightOption, this.mRightOption.wordAudio)) {
//            this.mAudioPlayer.setOnPlaySateListener(new OnPlaySateListener() {
//                public void onPlayStateChanged(State state) {
//                    if (state == State.Completed) {
//                        PatternSenToPicFragment.this.mAudioPlayer.setOnPlaySateListener(null);
//                        ZPackUtils.loadAudioCompat(PatternSenToPicFragment.this.mAudioPlayer, PatternSenToPicFragment.this.mRightOption, PatternSenToPicFragment.this.mRightOption.sentenceAudio);
//                    }
//                }
//            });
//        } else {
//            ZPackUtils.loadAudioCompat(this.mAudioPlayer, this.mRightOption, this.mRightOption.sentenceAudio);
//        }
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
//        TopicTextRender.with(this.mRightOption.sentence).highlightColor(ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_text_blue)).highlightSize(getContext().getResources().getDimensionPixelSize(R.dimen.T6)).highlightKey(this.mRightOption.word).clickable().skipClickHighlighted().setHighlightClickListener(new OnWordClickListener() {
//            public void onClick(String str) {
//                ZPackUtils.loadAudioCompat(PatternSenToPicFragment.this.mAudioPlayer, PatternSenToPicFragment.this.mRightOption, PatternSenToPicFragment.this.mRightOption.wordAudio);
//            }
//        }).into(this.mSentence);
//        this.mSentence.setVisibility(0);
//        this.mHintIndex.clear();
//        if (!TextUtils.isEmpty(this.mRightOption.sentenceTrans)) {
//            this.mTranslate.setText(this.mRightOption.sentenceTrans);
//            this.mHintIndex.add(Integer.valueOf(0));
//        }
//        if (!TextUtils.isEmpty(this.mRightOption.wordMeanEn)) {
//            TopicTextRenderHelper.showWordMeanEn(this.mEnMean, this.mRightOption);
//            this.mHintIndex.add(Integer.valueOf(1));
//        }
//        if (!TextUtils.isEmpty(this.mRightOption.wordMean)) {
//            TopicTextRenderHelper.showWordMeanCn(this.mCnMean, this.mRightOption);
//            this.mHintIndex.add(Integer.valueOf(2));
//        }
//        for (int i = 0; i < 4; i++) {
//            TopicRecord topicRecord = (TopicRecord) this.mTopicOptions.get(i);
//            this.mOptionImages[i].setImageDrawable(null);
//            ZPackUtils.loadImageCompat(topicRecord, topicRecord.imagePath).error(R.drawable.image_broke_normal_default).into(this.mOptionImages[i], (Callback) null);
//            this.mOptionImages[i].setTag(Integer.valueOf(i));
//            this.mOptionImages[i].setOnClickListener(this);
//            this.mOptionMasks[i].setVisibility(4);
//            ResidentBitmapCache.setImageResource(this.mOptionMasks[i], isRight(topicRecord.topicId) ? R.drawable.right_big_normal_default : R.drawable.wrong_big_normal_default);
//        }
//        this.mHintLevel = -1;
//        hint(this.mHintLevel);
//    }
//
//    public void onDetach() {
//        super.onDetach();
//        for (ImageView imageDrawable : this.mOptionImages) {
//            imageDrawable.setImageDrawable(null);
//        }
//        clearOptionMask(false);
//        this.mSentence.setText("");
//        this.mEnMean.setText("");
//    }
//}
