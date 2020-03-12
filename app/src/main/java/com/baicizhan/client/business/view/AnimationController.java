package com.baicizhan.client.business.view;

import android.os.Handler;
import android.os.Message;

public class AnimationController {
    /* access modifiers changed from: private */
    public static int ANI_WHAT = 256;
    private static int DEFAULT_FRAME_DURATION = 16;
    private static int DEFAULT_VELOCITY = 7;
    /* access modifiers changed from: private */
    public boolean isAnimating = false;
    /* access modifiers changed from: private */
    public int mFrame;
    /* access modifiers changed from: private */
    public int mFrameDuration = DEFAULT_FRAME_DURATION;
    private int mFrom;
    /* access modifiers changed from: private */
    public AnimationHandler mHandler = new AnimationHandler();
    /* access modifiers changed from: private */
    public OnAnimateListener mOnAnimateListener;
    private int mTo;
    private int mVelocity = DEFAULT_VELOCITY;

    class AnimationHandler extends Handler {
        private AnimationHandler() {
        }

        public void handleMessage(Message message) {
            if (message.what == AnimationController.ANI_WHAT && message.obj != null) {
                ((Runnable) message.obj).run();
            }
        }
    }

    public interface OnAnimateListener {
        boolean continueAnimating();

        void onAnimateComplete();

        void onAnimationStart();

        void onFrameUpdate(int i);
    }

    class RequireNextFrame implements Runnable {
        RequireNextFrame() {
        }

        public void run() {
            if (AnimationController.this.isAnimating) {
                calcNextFrame();
                AnimationController.this.mOnAnimateListener.onFrameUpdate(AnimationController.this.mFrame);
                if (AnimationController.this.mOnAnimateListener.continueAnimating()) {
                    requireNextFrame();
                    return;
                }
                AnimationController.this.stopAnimation();
                AnimationController.this.mOnAnimateListener.onAnimateComplete();
            }
        }

        private void calcNextFrame() {
        }

        private void requireNextFrame() {
            Message obtainMessage = AnimationController.this.mHandler.obtainMessage();
            obtainMessage.what = AnimationController.ANI_WHAT;
            obtainMessage.obj = this;
            AnimationController.this.mHandler.sendMessageDelayed(obtainMessage, (long) AnimationController.this.mFrameDuration);
        }
    }

    private AnimationController() {
    }

    public static AnimationController getDefault() {
        return new AnimationController();
    }

    public AnimationController init(OnAnimateListener onAnimateListener) {
        if (onAnimateListener == null) {
            throw new IllegalArgumentException("onAnimateListener can not be null");
        }
        this.mOnAnimateListener = onAnimateListener;
        return this;
    }

    public void startAnimation(int i, int i2) {
        this.isAnimating = true;
        this.mFrom = i;
        this.mTo = i2;
        this.mFrame = this.mVelocity;
        if (this.mTo > this.mFrom) {
            this.mFrame = Math.abs(this.mVelocity);
        } else if (this.mTo < this.mFrom) {
            this.mFrame = -Math.abs(this.mVelocity);
        } else {
            this.isAnimating = false;
            this.mOnAnimateListener.onAnimateComplete();
            return;
        }
        this.mOnAnimateListener.onAnimationStart();
        new RequireNextFrame().run();
    }

    public void stopAnimation() {
        this.isAnimating = false;
        this.mHandler.removeMessages(ANI_WHAT);
    }

    public void setVelocity(int i) {
        if (i <= 0) {
            this.mVelocity = DEFAULT_VELOCITY;
        } else {
            this.mVelocity = i;
        }
    }

    public void setFrameDuration(int i) {
        if (i <= 0) {
            this.mFrameDuration = DEFAULT_FRAME_DURATION;
        } else {
            this.mFrameDuration = i;
        }
    }
}
