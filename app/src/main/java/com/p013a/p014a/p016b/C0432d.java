package com.p013a.p014a.p016b;

import com.p013a.p014a.SimpleSwipeListener;
import com.p013a.p014a.SwipeLayout;

/* renamed from: com.a.a.b.d */
/* compiled from: SwipeItemMangerImpl */
public final class C0432d extends SimpleSwipeListener {

    /* renamed from: a */
    public int f1687a;

    /* renamed from: b */
    final /* synthetic */ SwipeItemMangerImpl f1688b;

    C0432d(SwipeItemMangerImpl aVar, int i) {
        this.f1688b = aVar;
        this.f1687a = i;
    }

    /* renamed from: a */
    public final void mo2785a() {
        if (this.f1688b.f1676a == C0430b.f1683b) {
            this.f1688b.f1679d.remove(Integer.valueOf(this.f1687a));
        } else {
            this.f1688b.f1678c = -1;
        }
    }

    /* renamed from: a */
    public final void mo2786a(SwipeLayout bVar) {
        if (this.f1688b.f1676a == C0430b.f1682a) {
            this.f1688b.mo2848a(bVar);
        }
    }

    /* renamed from: b */
    public final void mo2787b(SwipeLayout bVar) {
        if (this.f1688b.f1676a == C0430b.f1683b) {
            this.f1688b.f1679d.add(Integer.valueOf(this.f1687a));
            return;
        }
        this.f1688b.mo2848a(bVar);
        this.f1688b.f1678c = this.f1687a;
    }
}
