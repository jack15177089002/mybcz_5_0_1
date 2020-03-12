package com.baicizhan.client.wordlock.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

public class CustomTextView extends TextView {
    public static final int LONG_CLICK_TIMEOUT = 200;
    public static final String TAG = "CustomTextView";
    /* access modifiers changed from: private */
    public OnLongClickListener mCustomLongClickListener = null;
    private int mDownX;
    private int mDownY;
    /* access modifiers changed from: private */
    public boolean mIsPressed = false;
    private Runnable mLongClickRunnable = new Runnable() {
        public void run() {
            CustomTextView.this.disallowParentInterceptTouch(false);
            if (CustomTextView.this.isLongClickable() && CustomTextView.this.mIsPressed && CustomTextView.this.isEnabled() && CustomTextView.this.mCustomLongClickListener != null) {
                CustomTextView.this.mCustomLongClickListener.onLongClick(CustomTextView.this);
            }
        }
    };
    private int mTouchSlop;

    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        setLongClickable(true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                removeCallbacks(this.mLongClickRunnable);
                disallowParentInterceptTouch(true);
                postDelayed(this.mLongClickRunnable, 200);
                this.mDownX = x;
                this.mDownY = y;
                this.mIsPressed = true;
                break;
            case 1:
            case 3:
                disallowParentInterceptTouch(false);
                removeCallbacks(this.mLongClickRunnable);
                this.mIsPressed = false;
                break;
            case 2:
                if (this.mIsPressed && (Math.abs(x - this.mDownX) > this.mTouchSlop || Math.abs(y - this.mDownY) > this.mTouchSlop)) {
                    removeCallbacks(this.mLongClickRunnable);
                    disallowParentInterceptTouch(false);
                    this.mIsPressed = false;
                    return false;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    public void disallowParentInterceptTouch(boolean z) {
        ViewParent parent = getParent();
        if (ViewGroup.class.isInstance(parent)) {
            ((ViewGroup) parent).requestDisallowInterceptTouchEvent(z);
        }
    }

    public OnLongClickListener getCustomLongClickListener() {
        return this.mCustomLongClickListener;
    }

    public void setCustomLongClickListener(OnLongClickListener onLongClickListener) {
        this.mCustomLongClickListener = onLongClickListener;
    }
}
