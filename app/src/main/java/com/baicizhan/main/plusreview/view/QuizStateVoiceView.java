//package com.baicizhan.main.plusreview.view;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.AlphaAnimation;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.LinearLayout.LayoutParams;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.jiongji.andriod.card.R;
//
//public class QuizStateVoiceView extends LinearLayout implements OnClickListener {
//    private OnMicToggleListener mListener;
//    private ImageView[] mMicVols;
//    private LinearLayout mMicVolsContainer;
//    private boolean mOn = true;
//    private TextView mRightWord;
//    private ImageView mToggleMic;
//    private ImageView mWrongTag;
//
//    public class Initializer {
//        private int mMaxVol;
//        private OnMicToggleListener mMicToggleListener;
//        private boolean mOn;
//        private CharSequence mRightWord;
//        private QuizStateVoiceView mTarget;
//
//        public Initializer wrap(QuizStateVoiceView quizStateVoiceView) {
//            this.mTarget = quizStateVoiceView;
//            return this;
//        }
//
//        public Initializer setMaxVol(int i) {
//            this.mMaxVol = i;
//            return this;
//        }
//
//        public Initializer setMicToggleListener(OnMicToggleListener onMicToggleListener) {
//            this.mMicToggleListener = onMicToggleListener;
//            return this;
//        }
//
//        public Initializer setRightWord(CharSequence charSequence) {
//            this.mRightWord = charSequence;
//            return this;
//        }
//
//        public Initializer setOn(boolean z) {
//            this.mOn = z;
//            return this;
//        }
//
//        public QuizStateVoiceView initialize() {
//            if (this.mTarget == null) {
//                return null;
//            }
//            this.mTarget.setMaxVol(this.mMaxVol);
//            this.mTarget.setMicToggleListener(this.mMicToggleListener);
//            this.mTarget.setRightWord(this.mRightWord);
//            this.mTarget.toggle(this.mOn, false);
//            return this.mTarget;
//        }
//    }
//
//    public interface OnMicToggleListener {
//        void onMicToggle(boolean z);
//    }
//
//    public QuizStateVoiceView(Context context) {
//        super(context);
//    }
//
//    public QuizStateVoiceView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        ThemeResUtil.setVoiceBg(getContext(), this);
//        this.mToggleMic = (ImageView) findViewById(R.id.plusreview_read_mic);
//        this.mToggleMic.setOnClickListener(this);
//        this.mMicVolsContainer = (LinearLayout) findViewById(R.id.plusreview_read_mic_vols);
//        this.mWrongTag = (ImageView) findViewById(R.id.plusreview_read_wrong_tag);
//        this.mRightWord = (TextView) findViewById(R.id.plusreview_read_right_word);
//    }
//
//    public void setMaxVol(int i) {
//        if (i >= 0) {
//            if (this.mMicVols != null) {
//                for (ImageView removeView : this.mMicVols) {
//                    this.mMicVolsContainer.removeView(removeView);
//                }
//            }
//            this.mMicVols = new ImageView[i];
//            for (int i2 = 0; i2 < i; i2++) {
//                LayoutParams layoutParams = new LayoutParams(-2, -2);
//                layoutParams.gravity = 80;
//                layoutParams.rightMargin = DisplayUtils.dpToPx(getContext(), 1.0f);
//                ImageView imageView = new ImageView(getContext());
//                imageView.setImageResource(R.drawable.mic_vol_normal_default);
//                imageView.setLayoutParams(layoutParams);
//                imageView.setVisibility(4);
//                this.mMicVolsContainer.addView(imageView);
//                this.mMicVols[i2] = imageView;
//            }
//        }
//    }
//
//    public void setMicToggleListener(OnMicToggleListener onMicToggleListener) {
//        this.mListener = onMicToggleListener;
//    }
//
//    public void setRightWord(CharSequence charSequence) {
//        if (this.mRightWord != null) {
//            this.mRightWord.setText(charSequence);
//        }
//    }
//
//    public void giveAnswer() {
//        if (this.mRightWord != null) {
//            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
//            alphaAnimation.setDuration(200);
//            this.mWrongTag.setVisibility(4);
//            this.mRightWord.setVisibility(0);
//            this.mRightWord.startAnimation(alphaAnimation);
//        }
//    }
//
//    public void resetAnswer() {
//        if (this.mRightWord != null) {
//            this.mWrongTag.setVisibility(4);
//            this.mRightWord.setVisibility(4);
//        }
//    }
//
//    public void tipWrong() {
//        if (this.mWrongTag != null) {
//            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
//            alphaAnimation.setDuration(200);
//            this.mRightWord.setVisibility(4);
//            this.mWrongTag.setVisibility(0);
//            this.mWrongTag.startAnimation(alphaAnimation);
//        }
//    }
//
//    public void setVolume(int i) {
//        if (i >= 0 && this.mMicVols != null) {
//            int min = Math.min(i, this.mMicVols.length);
//            for (int i2 = 0; i2 < min; i2++) {
//                this.mMicVols[i2].setVisibility(0);
//            }
//            while (min < this.mMicVols.length) {
//                this.mMicVols[min].setVisibility(4);
//                min++;
//            }
//        }
//    }
//
//    public void toggle(boolean z) {
//        toggle(z, true);
//    }
//
//    public void toggle(boolean z, boolean z2) {
//        if (this.mToggleMic != null) {
//            this.mToggleMic.setImageResource(ThemeUtil.getThemeResourceIdWithAttr(getContext(), z ? R.attr.drawable_mic_on : R.attr.drawable_mic_off));
//            this.mOn = z;
//            if (this.mListener != null && z2) {
//                this.mListener.onMicToggle(this.mOn);
//            }
//        }
//    }
//
//    public void onClick(View view) {
//        this.mToggleMic.setImageResource(ThemeUtil.getThemeResourceIdWithAttr(getContext(), this.mOn ? R.attr.drawable_mic_off : R.attr.drawable_mic_on));
//        this.mOn = !this.mOn;
//        if (this.mListener != null) {
//            this.mListener.onMicToggle(this.mOn);
//        }
//    }
//}
