package kankan.wheel.widget;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.Scroller;

/* renamed from: kankan.wheel.widget.d */
public final class WheelScroller {

    /* renamed from: a */
    C2081g f5760a;

    /* renamed from: b */
    Context f5761b;

    /* renamed from: c */
    GestureDetector f5762c;

    /* renamed from: d */
    Scroller f5763d;

    /* renamed from: e */
    int f5764e;

    /* renamed from: f */
    float f5765f;

    /* renamed from: g */
    boolean f5766g;

    /* renamed from: h */
    Handler f5767h = new C2080f(this);

    /* renamed from: i */
    private SimpleOnGestureListener f5768i = new C2079e(this);

    /* renamed from: j */
    private final int f5769j = 0;

    /* renamed from: k */
    private final int f5770k = 1;

    public WheelScroller(Context context, C2081g gVar) {
        this.f5762c = new GestureDetector(context, this.f5768i);
        this.f5762c.setIsLongpressEnabled(false);
        this.f5763d = new Scroller(context);
        this.f5760a = gVar;
        this.f5761b = context;
    }

    /* renamed from: a */
    public final void mo18423a() {
        this.f5763d.forceFinished(true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18424a(int i) {
        mo18425b();
        this.f5767h.sendEmptyMessage(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo18425b() {
        this.f5767h.removeMessages(0);
        this.f5767h.removeMessages(1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo18426c() {
        this.f5760a.mo18434c();
        mo18424a(1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final void mo18427d() {
        if (!this.f5766g) {
            this.f5766g = true;
            this.f5760a.mo18431a();
        }
    }
}
