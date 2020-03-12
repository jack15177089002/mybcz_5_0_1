package com.baicizhan.client.business.widget;

import android.content.Context;
//import androidx.viewpager.widget.ViewPager;// import android.support.p004v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class SwipeViewPager extends ViewPager {
    /* access modifiers changed from: private */
    public OnFlingListener mFlingListener;
    private GestureDetector mGestureDetector;

    public enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN
    }

    public interface OnFlingListener {
        void onFling(Direction direction);
    }

    public SwipeViewPager(Context context) {
        super(context);
    }

    public SwipeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDetector = new GestureDetector(context, new SimpleOnGestureListener() {
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                Direction direction = Math.abs(f) > Math.abs(f2) ? f < 0.0f ? Direction.LEFT : Direction.RIGHT : f2 < 0.0f ? Direction.UP : Direction.DOWN;
                if (SwipeViewPager.this.mFlingListener != null) {
                    SwipeViewPager.this.mFlingListener.onFling(direction);
                }
                return true;
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mGestureDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void setFlingListener(OnFlingListener onFlingListener) {
        this.mFlingListener = onFlingListener;
    }
}
