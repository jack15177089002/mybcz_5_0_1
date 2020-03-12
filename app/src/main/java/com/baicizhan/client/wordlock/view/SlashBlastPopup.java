package com.baicizhan.client.wordlock.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.jiongji.andriod.card.R;
//import com.baicizhan.client.wordlock.R;

public class SlashBlastPopup extends PopupWindow {
    private Handler mHandler = new Handler();
    private SlashBlastView mSlashBlastView;

    public SlashBlastPopup(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setWidth(-1);
        setHeight(-1);
        setFocusable(false);
        setTouchable(false);
        setAnimationStyle(R.style.slash_blast_animation);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.mSlashBlastView = new SlashBlastView(context);
        relativeLayout.addView(this.mSlashBlastView);
        setContentView(relativeLayout);
//        setBackgroundDrawable(context.getResources().getDrawable(17170445));
    }

    public SlashBlastView getSlashBlastView() {
        return this.mSlashBlastView;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, 0, 0);
        this.mSlashBlastView.clearAnimation();
        LayoutParams layoutParams = (LayoutParams) this.mSlashBlastView.getLayoutParams();
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) this.mSlashBlastView.getCalWidth(), 0.0f, (float) (-this.mSlashBlastView.getCalHeight()));
        translateAnimation.setInterpolator(new AccelerateInterpolator(1.1f));
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.3f, 1.0f, 1.3f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(200);
        animationSet.setFillAfter(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                SlashBlastPopup.this.dismiss();
            }
        });
        this.mSlashBlastView.startAnimation(animationSet);
    }
}
