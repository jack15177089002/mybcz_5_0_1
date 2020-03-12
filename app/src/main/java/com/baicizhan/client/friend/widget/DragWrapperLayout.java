package com.baicizhan.client.friend.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baicizhan.client.framework.util.DisplayUtils;

public class DragWrapperLayout extends FrameLayout {
    public static final String TAG = "DragWrapperLayout";
    private OnDetectDragListener mDectectDragListener;
    private Direction mDirection;
    private float mLastMotionY;
    private float mLastStartY;
    private boolean mNotified;
    private float mThreshold;

    enum Direction {
        None,
        UP,
        DOWN
    }

    public interface OnDetectDragListener {
        void onDragDown();

        void onDragUp();
    }

    public DragWrapperLayout(Context context) {
        this(context, null);
    }

    public DragWrapperLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DragWrapperLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDirection = Direction.None;
        this.mThreshold = (float) DisplayUtils.dpToPx(context, 20.0f);
    }

    public void setOnDectectDragListener(OnDetectDragListener onDetectDragListener) {
        this.mDectectDragListener = onDetectDragListener;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float rawY = motionEvent.getRawY();
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (action) {
            case 0:
                this.mLastMotionY = rawY;
                break;
            case 1:
            case 3:
                this.mDirection = Direction.None;
                this.mNotified = false;
                break;
            case 2:
                if (dispatchTouchEvent) {
                    if (rawY - this.mLastMotionY > 0.0f) {
                        if (this.mDirection != Direction.DOWN) {
                            Log.d(TAG, "mLastStartY=" + this.mLastStartY);
                            this.mDirection = Direction.DOWN;
                            this.mLastStartY = rawY;
                            this.mNotified = false;
                        } else if (rawY - this.mLastStartY > this.mThreshold && !this.mNotified && this.mDectectDragListener != null) {
                            this.mDectectDragListener.onDragDown();
                            this.mNotified = true;
                        }
                    } else if (this.mDirection != Direction.UP) {
                        this.mDirection = Direction.UP;
                        this.mLastStartY = rawY;
                        this.mNotified = false;
                    } else if (this.mLastStartY - rawY > this.mThreshold && !this.mNotified && this.mDectectDragListener != null) {
                        this.mDectectDragListener.onDragUp();
                        this.mNotified = true;
                    }
                    this.mLastMotionY = rawY;
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }
}
