package kankan.wheel.widget;

import java.util.Iterator;

/* renamed from: kankan.wheel.widget.h */
/* compiled from: WheelView */
final class C2082h implements C2081g {

    /* renamed from: a */
    final /* synthetic */ WheelView f5773a;

    C2082h(WheelView wheelView) {
        this.f5773a = wheelView;
    }

    /* renamed from: a */
    public final void mo18431a() {
        this.f5773a.f5743o = true;
        Iterator it = this.f5773a.f5730b.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    /* renamed from: a */
    public final void mo18432a(int i) {
        WheelView.m5385a(this.f5773a, i);
        int height = this.f5773a.getHeight();
        if (this.f5773a.f5744p > height) {
            this.f5773a.f5744p = height;
            this.f5773a.f5742n.mo18423a();
        } else if (this.f5773a.f5744p < (-height)) {
            this.f5773a.f5744p = -height;
            this.f5773a.f5742n.mo18423a();
        }
    }

    /* renamed from: b */
    public final void mo18433b() {
        if (this.f5773a.f5743o) {
            Iterator it = this.f5773a.f5730b.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.f5773a.f5743o = false;
        }
        this.f5773a.f5744p = 0;
        this.f5773a.invalidate();
    }

    /* renamed from: c */
    public final void mo18434c() {
        if (Math.abs(this.f5773a.f5744p) > 1) {
            WheelScroller b = this.f5773a.f5742n;
            int a = this.f5773a.f5744p;
            b.f5763d.forceFinished(true);
            b.f5764e = 0;
            b.f5763d.startScroll(0, 0, 0, a, 400);
            b.mo18424a(0);
            b.mo18427d();
        }
    }
}
