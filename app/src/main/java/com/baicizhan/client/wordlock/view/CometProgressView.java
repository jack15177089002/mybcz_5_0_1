package com.baicizhan.client.wordlock.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

import com.jiongji.andriod.card.R;
//import com.baicizhan.client.wordlock.R;

public class CometProgressView extends FrameLayout {
    private static final int ANIM_DUR = 2000;
    private View mBackground;
    private ImageView mComet;
    private int mCometHeight;
    private int mCometWidth;

    public CometProgressView(Context context) {
        super(context);
        init(context);
    }

    public CometProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CometProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        Drawable drawable = getResources().getDrawable(R.drawable.gradient_mark);
        this.mCometWidth = drawable.getIntrinsicWidth();
        this.mCometHeight = drawable.getIntrinsicHeight();
        LayoutParams layoutParams = new LayoutParams(-1, this.mCometHeight);
        this.mBackground = new View(context);
        this.mBackground.setLayoutParams(layoutParams);
        this.mBackground.setBackgroundColor(getResources().getColor(R.color.C27));
        addView(this.mBackground);
        LayoutParams layoutParams2 = new LayoutParams(-2, this.mCometHeight);
        this.mComet = new ImageView(context);
        this.mComet.setLayoutParams(layoutParams2);
        this.mComet.setImageDrawable(drawable);
        addView(this.mComet);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    public void start() {
        post(new Runnable() {
            public void run() {
                CometProgressView.this.doProgress();
            }
        });
    }

    /* access modifiers changed from: private */
    public void doProgress() {
        TranslateAnimation translateAnimation = new TranslateAnimation((float) (-this.mCometWidth), (float) getWidth(), 0.0f, 0.0f);
        translateAnimation.setDuration(2000);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(-1);
        this.mComet.startAnimation(translateAnimation);
    }

    public void stop() {
        this.mComet.clearAnimation();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            start();
        } else {
            stop();
        }
    }
}
