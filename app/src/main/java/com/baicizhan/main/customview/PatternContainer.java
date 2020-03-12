//package com.baicizhan.main.customview;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.GestureDetector;
//import android.view.GestureDetector.OnGestureListener;
//import android.view.MotionEvent;
//import android.view.ViewConfiguration;
//import android.widget.LinearLayout;
//
//public class PatternContainer extends LinearLayout {
//    GestureDetector mDetector;
//    OnGestureListener mGestureListener;
//    OnFlingListener mOnFlingListener;
//
//    public enum Direction {
//        LEFT,
//        UP,
//        RIGHT,
//        DOWN
//    }
//
//    public interface OnFlingListener {
//        void onFling(Direction direction);
//    }
//
//    public PatternContainer(Context context) {
//        this(context, null);
//    }
//
//    public PatternContainer(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        final int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
//        this.mGestureListener = new OnGestureListener() {
//            public boolean onSingleTapUp(MotionEvent motionEvent) {
//                return false;
//            }
//
//            public void onShowPress(MotionEvent motionEvent) {
//            }
//
//            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
//                return true;
//            }
//
//            public void onLongPress(MotionEvent motionEvent) {
//            }
//
//            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
//                Direction direction;
//                if (Math.abs(f) > Math.abs(f2)) {
//                    if (Math.abs(motionEvent2.getX() - motionEvent.getX()) < ((float) scaledTouchSlop)) {
//                        return false;
//                    }
//                    direction = f < 0.0f ? Direction.LEFT : Direction.RIGHT;
//                } else if (Math.abs(motionEvent2.getY() - motionEvent.getY()) < ((float) scaledTouchSlop)) {
//                    return false;
//                } else {
//                    direction = f2 < 0.0f ? Direction.UP : Direction.DOWN;
//                }
//                if (PatternContainer.this.mOnFlingListener != null) {
//                    PatternContainer.this.mOnFlingListener.onFling(direction);
//                }
//                return true;
//            }
//
//            public boolean onDown(MotionEvent motionEvent) {
//                return true;
//            }
//        };
//        this.mDetector = new GestureDetector(context, this.mGestureListener);
//    }
//
//    public void setOnFlingListener(OnFlingListener onFlingListener) {
//        this.mOnFlingListener = onFlingListener;
//    }
//
//    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
//        return super.dispatchTouchEvent(motionEvent) | this.mDetector.onTouchEvent(motionEvent);
//    }
//}
