package com.baicizhan.client.wordlock.view.drag;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public abstract class DropSpot extends RelativeLayout implements DragController.DragListener, DropTarget, IDragObserverAction {
    protected DragController mDragController;
    protected DragLayer mDragLayer;
    protected DragObservers mDragObservers;
    private int mSavedBackground = 17170445;

    public abstract void doDrop(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj);

    public abstract int getEnteredBackgroundRes();

    public DropSpot(Context context) {
        super(context);
    }

    public DropSpot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DropSpot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DragController getDragController() {
        return this.mDragController;
    }

    public void setDragController(DragController dragController) {
        this.mDragController = dragController;
    }

    public DragLayer getDragLayer() {
        return this.mDragLayer;
    }

    public void setDragLayer(DragLayer dragLayer) {
        this.mDragLayer = dragLayer;
    }

    public int getSavedBackground() {
        return this.mSavedBackground;
    }

    public void setSavedBackground(int i) {
        this.mSavedBackground = i;
    }

    public void onDragStart(DragSource dragSource, Object obj, int i) {
    }

    public void onDragEnd() {
        if (this.mDragObservers != null) {
            this.mDragObservers.notifyEnd();
        }
        setBackgroundResource(getSavedBackground());
    }

    public void onDrop(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
        if (this.mDragLayer != null) {
            doDrop(dragSource, i, i2, i3, i4, dragView, obj);
            if (this.mDragObservers != null) {
                this.mDragObservers.notifyEnd();
            }
        }
    }

    public void onDragEnter(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
        setBackgroundResource(getEnteredBackgroundRes());
    }

    public void onDragOver(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
    }

    public void onDragExit(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
        setBackgroundResource(getSavedBackground());
    }

    public boolean acceptDrop(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
        return isEnabled();
    }

    public Rect estimateDropLocation(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj, Rect rect) {
        return null;
    }

    public boolean isEnabled() {
        return this.mDragLayer != null;
    }

    public void setup(DragLayer dragLayer, DragController dragController) {
        this.mDragLayer = dragLayer;
        this.mDragController = dragController;
        if (dragController != null) {
            dragController.addDragListener(this);
            dragController.addDropTarget(this);
        }
    }

    public boolean intersects(View view) {
        if (view == null) {
            return false;
        }
        Rect rectOnScreen = RectUtil.getRectOnScreen(this);
        Rect rectOnScreen2 = RectUtil.getRectOnScreen(view);
        return rectOnScreen.intersects(rectOnScreen2.left, rectOnScreen2.top, rectOnScreen2.right, rectOnScreen2.bottom);
    }

    public void setDragObservers(DragObservers dragObservers) {
        this.mDragObservers = dragObservers;
    }
}
