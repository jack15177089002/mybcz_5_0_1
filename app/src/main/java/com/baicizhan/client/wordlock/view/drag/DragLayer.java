package com.baicizhan.client.wordlock.view.drag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
//import com.baicizhan.client.wordlock.R;
import com.baicizhan.client.wordlock.eventbus.WordLockEvents.DropBackEvent;
import com.baicizhan.client.wordlock.eventbus.WordLockEvents.KillTipEvent;
import com.jiongji.andriod.card.R;
//import p000a.p001a.p002a.EventBus;

public class DragLayer extends RelativeLayout implements DragController.DragListener, DragSource, DropTarget, IDragObserverAction {
    DragController mDragController;
    private DragObservers mDragObservers;
    TextView mDragTarget;

    public DragLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        //test
        super.onFinishInflate();
        this.mDragTarget = (TextView) findViewById(R.id.wordlock_word);
    }

    public void setDragController(DragController dragController) {
        this.mDragController = dragController;
        if (dragController != null) {
            dragController.addDragListener(this);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mDragController.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mDragController.onInterceptTouchEvent(motionEvent);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mDragController.onTouchEvent(motionEvent);
    }

    public boolean dispatchUnhandledMove(View view, int i) {
        return this.mDragController.dispatchUnhandledMove(view, i);
    }

    public boolean allowDrag() {
        return true;
    }

    public void onDropCompleted(View view, boolean z) {
    }

    public void onDrop(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
        View view = (View) obj;
        int i5 = i - i3;
        int i6 = i2 - i4;
        view.getLocationOnScreen(new int[2]);
        float popScale = dragView.getPopScale();
        TranslateAnimation translateAnimation = new TranslateAnimation(0, ((float) (i5 - view.getLeft())) / popScale, 0, 0.0f, 0, ((float) (i6 - view.getTop())) / popScale, 0, 0.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(popScale, 1.0f, popScale, 1.0f, (float) (view.getWidth() / 2), (float) (view.getHeight() / 2));
        scaleAnimation.setDuration(200);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        view.startAnimation(animationSet);
        if (this.mDragObservers != null) {
            this.mDragObservers.notifyEnd();
        }
        DropBackEvent dropBackEvent = new DropBackEvent();
        dropBackEvent.setFrom(0);
        dropBackEvent.setAnimdur(200);
//        EventBus.m0a().mo9c((Object) dropBackEvent);
    }

    public void onDragEnter(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
    }

    public void onDragOver(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
    }

    public void onDragExit(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
    }

    public boolean acceptDrop(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
        return true;
    }

    public Rect estimateDropLocation(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj, Rect rect) {
        return null;
    }

    public boolean underInnerTarget(int i, int i2) {
        return isViewHit(this.mDragTarget, i, i2);
    }

    private boolean isViewHit(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i3 = iArr2[0] + i;
        int i4 = iArr2[1] + i2;
        if (i3 < iArr[0] || i3 >= iArr[0] + view.getWidth() || i4 < iArr[1] || i4 >= iArr[1] + view.getHeight()) {
            return false;
        }
        return true;
    }

    public void setDragObservers(DragObservers dragObservers) {
        this.mDragObservers = dragObservers;
    }

    public void onDragStart(DragSource dragSource, Object obj, int i) {
        Log.d("whiz", "!!! onDragStart");
//        KillTipEvent killTipEvent = new KillTipEvent();
//        killTipEvent.setShowtip(true);
//        EventBus.m0a().mo9c((Object) killTipEvent);
    }

    public void onDragEnd() {
        Log.d("whiz", "!!! onDragEnd");
        if (this.mDragObservers != null) {
            this.mDragObservers.notifyEnd();
        }
//        KillTipEvent killTipEvent = new KillTipEvent();
//        killTipEvent.setShowtip(false);
//        EventBus.m0a().mo9c((Object) killTipEvent);
    }
}
