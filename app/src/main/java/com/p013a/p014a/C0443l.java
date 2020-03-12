package com.p013a.p014a;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewGroup;

/* renamed from: com.a.a.l */
/* compiled from: SwipeLayout */
final class C0443l extends SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ SwipeLayout f1707a;

    C0443l(SwipeLayout bVar) {
        this.f1707a = bVar;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.f1707a.mDoubleClickListener == null) {
            this.f1707a.performAdapterViewItemClick(motionEvent);
        }
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.f1707a.mDoubleClickListener != null) {
            this.f1707a.performAdapterViewItemClick(motionEvent);
        }
        return true;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        this.f1707a.performLongClick();
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f1707a.mDoubleClickListener != null) {
            ViewGroup bottomView = this.f1707a.getBottomView();
            this.f1707a.getSurfaceView();
            if (motionEvent.getX() > ((float) bottomView.getLeft()) && motionEvent.getX() < ((float) bottomView.getRight()) && motionEvent.getY() > ((float) bottomView.getTop())) {
                motionEvent.getY();
                bottomView.getBottom();
            }
//            this.f1707a.mDoubleClickListener;
        }
        return true;
    }
}
