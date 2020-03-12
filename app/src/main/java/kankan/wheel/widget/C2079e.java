package kankan.wheel.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* renamed from: kankan.wheel.widget.e */
/* compiled from: WheelScroller */
final class C2079e extends SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ WheelScroller f5771a;

    C2079e(WheelScroller dVar) {
        this.f5771a = dVar;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return true;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f5771a.f5764e = 0;
        this.f5771a.f5763d.fling(0, this.f5771a.f5764e, 0, (int) (-f2), 0, 0, -2147483647, Integer.MAX_VALUE);
        this.f5771a.mo18424a(0);
        return true;
    }
}
