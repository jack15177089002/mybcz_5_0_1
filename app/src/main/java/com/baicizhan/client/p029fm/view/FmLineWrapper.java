//package com.baicizhan.client.p029fm.view;
//
//import android.annotation.SuppressLint;
//import android.annotation.TargetApi;
//import android.content.Context;
//import android.graphics.Point;
//import android.os.Build.VERSION;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.widget.FrameLayout;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.client.p029fm.eventbus.FmEvents.ClickEvent;
//import com.baicizhan.client.p029fm.view.ViewPager.OnPageChangeListener;
////import p000a.p001a.p002a.EventBus;
//
///* renamed from: com.baicizhan.client.fm.view.FmLineWrapper */
//public class FmLineWrapper extends FrameLayout implements OnPageChangeListener {
//    private static final int MIN_DISTANCE_FOR_SWITCH_PAGE = 10;
//    private Point mCenter = new Point();
//    private int mDistanceForSwitch;
//    private boolean mDragging = false;
//    private FmLine mFmLine;
//    private Point mInitialTouch = new Point();
//    private boolean mNeedRedraw = false;
//    private boolean mStartTouch = false;
//
//    public FmLineWrapper(Context context) {
//        super(context);
//        init(context);
//    }
//
//    public FmLineWrapper(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        init(context);
//    }
//
//    public FmLineWrapper(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        init(context);
//    }
//
//    private void init(Context context) {
//        setClipChildren(false);
//        stopHardwareAcc();
//        this.mDistanceForSwitch = Common.dip2px(context, 10.0f);
//    }
//
//    @TargetApi(11)
//    private void stopHardwareAcc() {
//        if (VERSION.SDK_INT >= 11) {
//            setLayerType(1, null);
//        }
//    }
//
//    public void onFinishInflate() {
//        try {
//            this.mFmLine = (FmLine) getChildAt(0);
//            this.mFmLine.setOnPageChangeListener(this);
//        } catch (Exception e) {
//            throw new IllegalStateException("The root child of FmLineWrapper must be a ViewPager");
//        }
//    }
//
//    public ViewPager getViewPager() {
//        return this.mFmLine;
//    }
//
//    /* access modifiers changed from: protected */
//    public void onSizeChanged(int i, int i2, int i3, int i4) {
//        this.mCenter.x = i / 2;
//        this.mCenter.y = i2 / 2;
//    }
//
//    @SuppressLint({"ClickableViewAccessibility"})
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        if ((1 == motionEvent.getAction() || 3 == motionEvent.getAction()) && this.mDragging) {
//            if (((float) this.mInitialTouch.x) - motionEvent.getX() > ((float) this.mDistanceForSwitch)) {
//                this.mFmLine.smoothScrollTo(this.mFmLine.getCurrentItem() + 1);
//                this.mDragging = false;
//                this.mStartTouch = false;
//                return true;
//            } else if (motionEvent.getX() - ((float) this.mInitialTouch.x) > ((float) this.mDistanceForSwitch)) {
//                this.mFmLine.smoothScrollTo(this.mFmLine.getCurrentItem() - 1);
//                this.mDragging = false;
//                this.mStartTouch = false;
//                return true;
//            }
//        }
//        switch (motionEvent.getAction()) {
//            case 0:
//                break;
//            case 1:
//                if (!this.mDragging) {
////                    ClickEvent clickEvent = new ClickEvent();
////                    clickEvent.setClickType(0);
////                    EventBus.m0a().mo9c((Object) clickEvent);
////                    if (this.mInitialTouch.x > this.mCenter.x) {
////                        this.mFmLine.smoothScrollTo(this.mFmLine.getCurrentItem() + 1);
////                    } else if (this.mInitialTouch.x < this.mCenter.x) {
////                        this.mFmLine.smoothScrollTo(this.mFmLine.getCurrentItem() - 1);
////                    }
//                }
//                this.mDragging = false;
//                this.mStartTouch = false;
//                break;
//        }
//        this.mStartTouch = true;
//        this.mInitialTouch.x = (int) motionEvent.getX();
//        this.mInitialTouch.y = (int) motionEvent.getY();
//        motionEvent.offsetLocation((float) (this.mCenter.x - this.mInitialTouch.x), (float) (this.mCenter.y - this.mInitialTouch.y));
//        return this.mFmLine.dispatchTouchEvent(motionEvent);
//    }
//
//    public void onPageScrolled(int i, float f, int i2) {
//        if (this.mNeedRedraw) {
//            invalidate();
//        }
//        this.mFmLine.doPageScrolled(i, f, i2);
//    }
//
//    public void onPageSelected(int i) {
//        this.mFmLine.doPageSelected(i);
//    }
//
//    public void onPageScrollStateChanged(int i) {
//        boolean z = true;
//        if (1 == i && this.mStartTouch) {
//            this.mDragging = true;
//        }
//        if (i == 0) {
//            z = false;
//        }
//        this.mNeedRedraw = z;
//        this.mFmLine.doPageScrollStateChanged(i);
//    }
//}
