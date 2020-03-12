package com.p013a.p014a;

import android.graphics.Rect;
//import android.support.p004v4.widget.C0213az;
import android.view.View;
import java.util.Iterator;

/* renamed from: com.a.a.c */
/* compiled from: SwipeLayout */


//final class C0434c extends C0213az {
final class C0434c {
    /* renamed from: a */
    final /* synthetic */ SwipeLayout f1693a;

    C0434c(SwipeLayout bVar) {
        this.f1693a = bVar;
    }

    /* renamed from: a */
    public final int mo1001a(View view, int i) {
        if (view == this.f1693a.getSurfaceView()) {
            switch (C0435d.f1694a[this.f1693a.mDragEdge$85cc13e - 1]) {
                case 1:
                case 2:
                    return this.f1693a.getPaddingLeft();
                case 3:
                    if (i < this.f1693a.getPaddingLeft()) {
                        return this.f1693a.getPaddingLeft();
                    }
                    if (i > this.f1693a.getPaddingLeft() + this.f1693a.mDragDistance) {
                        return this.f1693a.getPaddingLeft() + this.f1693a.mDragDistance;
                    }
                    return i;
                case 4:
                    if (i > this.f1693a.getPaddingLeft()) {
                        return this.f1693a.getPaddingLeft();
                    }
                    if (i < this.f1693a.getPaddingLeft() - this.f1693a.mDragDistance) {
                        return this.f1693a.getPaddingLeft() - this.f1693a.mDragDistance;
                    }
                    return i;
                default:
                    return i;
            }
        } else if (view != this.f1693a.getBottomView()) {
            return i;
        } else {
            switch (C0435d.f1694a[this.f1693a.mDragEdge$85cc13e - 1]) {
                case 1:
                case 2:
                    return this.f1693a.getPaddingLeft();
                case 3:
                    if (this.f1693a.mShowMode$66cb888d != C0440i.f1701b || i <= this.f1693a.getPaddingLeft()) {
                        return i;
                    }
                    return this.f1693a.getPaddingLeft();
                case 4:
                    if (this.f1693a.mShowMode$66cb888d != C0440i.f1701b || i >= this.f1693a.getMeasuredWidth() - this.f1693a.mDragDistance) {
                        return i;
                    }
                    return this.f1693a.getMeasuredWidth() - this.f1693a.mDragDistance;
                default:
                    return i;
            }
        }
    }

    /* renamed from: a */
    public final int mo1002a(View view, int i, int i2) {
        if (view == this.f1693a.getSurfaceView()) {
            switch (C0435d.f1694a[this.f1693a.mDragEdge$85cc13e - 1]) {
                case 1:
                    if (i < this.f1693a.getPaddingTop()) {
                        return this.f1693a.getPaddingTop();
                    }
                    if (i > this.f1693a.getPaddingTop() + this.f1693a.mDragDistance) {
                        return this.f1693a.getPaddingTop() + this.f1693a.mDragDistance;
                    }
                    return i;
                case 2:
                    if (i < this.f1693a.getPaddingTop() - this.f1693a.mDragDistance) {
                        return this.f1693a.getPaddingTop() - this.f1693a.mDragDistance;
                    }
                    if (i > this.f1693a.getPaddingTop()) {
                        return this.f1693a.getPaddingTop();
                    }
                    return i;
                case 3:
                case 4:
                    return this.f1693a.getPaddingTop();
                default:
                    return i;
            }
        } else {
            switch (C0435d.f1694a[this.f1693a.mDragEdge$85cc13e - 1]) {
                case 1:
                    if (this.f1693a.mShowMode$66cb888d == C0440i.f1701b) {
                        if (i > this.f1693a.getPaddingTop()) {
                            return this.f1693a.getPaddingTop();
                        }
                        return i;
                    } else if (this.f1693a.getSurfaceView().getTop() + i2 < this.f1693a.getPaddingTop()) {
                        return this.f1693a.getPaddingTop();
                    } else {
                        if (this.f1693a.getSurfaceView().getTop() + i2 > this.f1693a.getPaddingTop() + this.f1693a.mDragDistance) {
                            return this.f1693a.getPaddingTop() + this.f1693a.mDragDistance;
                        }
                        return i;
                    }
                case 2:
                    if (this.f1693a.mShowMode$66cb888d == C0440i.f1701b) {
                        if (i < this.f1693a.getMeasuredHeight() - this.f1693a.mDragDistance) {
                            return this.f1693a.getMeasuredHeight() - this.f1693a.mDragDistance;
                        }
                        return i;
                    } else if (this.f1693a.getSurfaceView().getTop() + i2 >= this.f1693a.getPaddingTop()) {
                        return this.f1693a.getPaddingTop();
                    } else {
                        if (this.f1693a.getSurfaceView().getTop() + i2 <= this.f1693a.getPaddingTop() - this.f1693a.mDragDistance) {
                            return this.f1693a.getPaddingTop() - this.f1693a.mDragDistance;
                        }
                        return i;
                    }
                case 3:
                case 4:
                    return this.f1693a.getPaddingTop();
                default:
                    return i;
            }
        }
    }

    /* renamed from: a */
    public final boolean mo1007a(View view) {
        return view == this.f1693a.getSurfaceView() || view == this.f1693a.getBottomView();
    }

    /* renamed from: c */
    public final int mo1009c(View view) {
        return this.f1693a.mDragDistance;
    }

    /* renamed from: d */
    public final int mo1011d() {
        return this.f1693a.mDragDistance;
    }

    /* renamed from: a */
    public final void mo1005a(View view, float f, float f2) {
//        super.mo1005a(view, f, f2);
        Iterator it = this.f1693a.mSwipeListeners.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (view == this.f1693a.getSurfaceView()) {
            this.f1693a.processSurfaceRelease(f, f2);
        } else if (view == this.f1693a.getBottomView()) {
            if (this.f1693a.getShowMode$655cb86e() == C0440i.f1701b) {
                this.f1693a.processBottomPullOutRelease(f, f2);
            } else if (this.f1693a.getShowMode$655cb86e() == C0440i.f1700a) {
                this.f1693a.processBottomLayDownMode(f, f2);
            }
        }
        this.f1693a.invalidate();
    }

    /* renamed from: a */
    public final void mo1006a(View view, int i, int i2, int i3) {
        int left = this.f1693a.getSurfaceView().getLeft();
        int right = this.f1693a.getSurfaceView().getRight();
        int top = this.f1693a.getSurfaceView().getTop();
        int bottom = this.f1693a.getSurfaceView().getBottom();
        if (view == this.f1693a.getSurfaceView()) {
            if (this.f1693a.mShowMode$66cb888d == C0440i.f1701b) {
                if (this.f1693a.mDragEdge$85cc13e == C0437f.f1695a || this.f1693a.mDragEdge$85cc13e == C0437f.f1696b) {
                    this.f1693a.getBottomView().offsetLeftAndRight(i2);
                } else {
                    this.f1693a.getBottomView().offsetTopAndBottom(i3);
                }
            }
        } else if (view == this.f1693a.getBottomView()) {
            if (this.f1693a.mShowMode$66cb888d == C0440i.f1701b) {
                this.f1693a.getSurfaceView().offsetLeftAndRight(i2);
                this.f1693a.getSurfaceView().offsetTopAndBottom(i3);
            } else {
                Rect access$700$55e810d1 = this.f1693a.computeBottomLayDown$4fc6f390(this.f1693a.mDragEdge$85cc13e);
                this.f1693a.getBottomView().layout(access$700$55e810d1.left, access$700$55e810d1.top, access$700$55e810d1.right, access$700$55e810d1.bottom);
                int left2 = this.f1693a.getSurfaceView().getLeft() + i2;
                int top2 = this.f1693a.getSurfaceView().getTop() + i3;
                if (this.f1693a.mDragEdge$85cc13e == C0437f.f1695a && left2 < this.f1693a.getPaddingLeft()) {
                    left2 = this.f1693a.getPaddingLeft();
                } else if (this.f1693a.mDragEdge$85cc13e == C0437f.f1696b && left2 > this.f1693a.getPaddingLeft()) {
                    left2 = this.f1693a.getPaddingLeft();
                } else if (this.f1693a.mDragEdge$85cc13e == C0437f.f1697c && top2 < this.f1693a.getPaddingTop()) {
                    top2 = this.f1693a.getPaddingTop();
                } else if (this.f1693a.mDragEdge$85cc13e == C0437f.f1698d && top2 > this.f1693a.getPaddingTop()) {
                    top2 = this.f1693a.getPaddingTop();
                }
                this.f1693a.getSurfaceView().layout(left2, top2, this.f1693a.getMeasuredWidth() + left2, this.f1693a.getMeasuredHeight() + top2);
            }
        }
        this.f1693a.dispatchRevealEvent(left, top, right, bottom);
        this.f1693a.dispatchSwipeEvent(left, top, i2, i3);
        this.f1693a.invalidate();
    }
}
