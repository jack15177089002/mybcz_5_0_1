package com.baicizhan.client.wordtesting.view;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

public class AnimationLooper {
    public static void start(final View view, final int i) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), i);
                loadAnimation.setAnimationListener(new AnimationListener() {
                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        animation.reset();
                        animation.startNow();
                    }
                });
                view.startAnimation(loadAnimation);
            }
        });
    }

    public static void stop(final View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                Animation animation = view.getAnimation();
                if (animation != null) {
                    animation.setAnimationListener(null);
                    animation.cancel();
                }
                view.setAnimation(null);
            }
        });
    }
}
