package com.baicizhan.client.business.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
//import com.baicizhan.client.business.R;
import com.baicizhan.client.business.view.AnimationController.OnAnimateListener;
import com.jiongji.andriod.card.R;

public class RotatingImageView extends ImageView {
    private static final int DEFAULT_VELOCITY = 3;
    /* access modifiers changed from: private */
    public AnimationController mAnimationController;
    private int mHalfHeight;
    private int mHalfWidth;
    private boolean mIsRotate = true;
    private RIVAnimationListener mOnAnimateListener = new RIVAnimationListener();
    private int mRotateDegree;
    /* access modifiers changed from: private */
    public boolean mRotating = true;

    class RIVAnimationListener implements OnAnimateListener {
        private RIVAnimationListener() {
        }

        public void onAnimationStart() {
        }

        public boolean continueAnimating() {
            return RotatingImageView.this.mRotating;
        }

        public void onFrameUpdate(int i) {
            RotatingImageView.this.rotate(i);
        }

        public void onAnimateComplete() {
            if (RotatingImageView.this.mRotating) {
                RotatingImageView.this.mAnimationController.startAnimation(0, 360);
            }
        }
    }

    public RotatingImageView(Context context) {
        super(context);
        init(null, R.style.DefaultRotatingImageView);
    }

    public RotatingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, R.style.DefaultRotatingImageView);
    }

    public RotatingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, R.style.DefaultRotatingImageView);
    }

    private void init(AttributeSet attributeSet, int i) {
//        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RotatingImageView, 0, i);
//        int i2 = obtainStyledAttributes.getInt(R.styleable.RotatingImageView_velocity, 3);
//        this.mAnimationController = AnimationController.getDefault().init(this.mOnAnimateListener);
//        this.mAnimationController.setVelocity(i2);
//        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
//        super.onSizeChanged(i, i2, i3, i4);
//        this.mHalfWidth = (((i - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
//        this.mHalfHeight = (((i2 - getPaddingTop()) - getPaddingBottom()) / 2) + getPaddingTop();
    }

//    public void onFinishInflate() {
//        super.onFinishInflate();
//    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        this.mRotating = getVisibility() == 0;
//        if (this.mAnimationController != null && this.mRotating) {
//            this.mAnimationController.startAnimation(0, 360);
//        }
    }

    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        this.mRotating = false;
//        if (this.mAnimationController != null) {
//            this.mAnimationController.stopAnimation();
//        }
    }

    public void onDraw(Canvas canvas) {
        if (this.mIsRotate) {
            canvas.rotate((float) this.mRotateDegree, (float) this.mHalfWidth, (float) this.mHalfHeight);
        }
//        super.onDraw(canvas);
        canvas.restore();
    }

    public void setVisibility(int i) {
//        super.setVisibility(i);
//        if (i != 0 && this.mRotating) {
//            this.mRotating = false;
//            if (this.mAnimationController != null) {
//                this.mAnimationController.stopAnimation();
//            }
//        } else if (i == 0 && !this.mRotating) {
//            this.mRotating = true;
//            if (this.mAnimationController != null) {
//                this.mAnimationController.startAnimation(0, 360);
//            }
//        }
    }

    /* access modifiers changed from: private */
    public void rotate(int i) {
        this.mRotateDegree = (this.mRotateDegree + i) % 360;
//        invalidate();
    }

    public void setVelocity(int i) {
        if (this.mAnimationController != null) {
            this.mAnimationController.setVelocity(i);
        }
    }

    public boolean isRotate() {
        return this.mIsRotate;
    }

    public void setIsRotate(boolean z) {
        this.mIsRotate = z;
    }
}
