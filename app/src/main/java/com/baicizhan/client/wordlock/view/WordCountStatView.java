//package com.baicizhan.client.wordlock.view;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.view.animation.OvershootInterpolator;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
////import com.baicizhan.client.wordlock.R;
//import com.baicizhan.client.wordlock.setting.Settings;
//import com.baicizhan.client.wordlock.util.CustomFont;
//import com.jiongji.andriod.card.R;
//import com.p047d.p050c.ViewHelper;
//
//public class WordCountStatView extends RelativeLayout {
//    private Animation mAnim;
//    private TextView mCount;
//    private TextView mPlus;
//    private boolean mShowCount = true;
//
//    public WordCountStatView(Context context) {
//        super(context);
//    }
//
//    public WordCountStatView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mCount = (TextView) findViewById(R.id.wordlock_word_count);
//        CustomFont.setFont(this.mCount, 0);
//        this.mPlus = (TextView) findViewById(R.id.wordlock_word_count_plus);
//        CustomFont.setFont(this.mPlus, 0);
//    }
//
//    public void shrinkWordCount(float f, long j) {
//        int cachedLockRevdCount = Settings.getCachedLockRevdCount();
//        if (cachedLockRevdCount > 0) {
//            if (f <= 0.7f) {
//                if (f <= 0.02f) {
//                    this.mShowCount = true;
//                    toggleWordCount(false);
//                } else {
//                    if (j <= 10) {
//                        this.mShowCount = false;
//                    } else if (j > 300) {
//                        this.mShowCount = true;
//                    }
//                    if (this.mShowCount) {
//                        feedCount(cachedLockRevdCount);
//                        toggleWordCount(true);
//                    }
//                }
//                ViewHelper.m3395g(this, 0.0f);
//            } else if (f >= 0.9f) {
//                setVisibility(8);
//            } else if (getVisibility() == 0) {
//                ViewHelper.m3395g(this, (-(((f - 0.7f) * 10.0f) / 2.0f)) * ((float) getHeight()));
//                if (this.mAnim != null) {
//                    this.mAnim.cancel();
//                }
//            }
//        }
//    }
//
//    private void feedCount(int i) {
//        if (i <= 99) {
//            setBackgroundResource(R.drawable.wordlock_word_count_stat_bg);
//            this.mPlus.setVisibility(4);
//        } else if (i <= 999) {
//            setBackgroundResource(R.drawable.wordlock_word_count_stat_bg_large);
//            this.mPlus.setVisibility(4);
//        } else {
//            setBackgroundResource(R.drawable.wordlock_word_count_stat_bg_large);
//            this.mPlus.setVisibility(0);
//            i = 999;
//        }
//        this.mCount.setText(String.valueOf(i));
//    }
//
//    private void toggleWordCount(boolean z) {
//        int i;
//        if (z && getVisibility() == 0) {
//            return;
//        }
//        if (z || 8 != getVisibility()) {
//            if (this.mAnim != null) {
//                this.mAnim.cancel();
//            }
//            this.mAnim = z ? AnimationUtils.loadAnimation(getContext(), R.anim.wordlock_down_in) : AnimationUtils.loadAnimation(getContext(), R.anim.wordlock_up_out);
//            if (z) {
//                i = 0;
//            } else {
//                i = 8;
//            }
//            setVisibility(i);
//            this.mAnim.setDuration(200);
//            this.mAnim.setInterpolator(new OvershootInterpolator(1.2f));
//            startAnimation(this.mAnim);
//        }
//    }
//}
