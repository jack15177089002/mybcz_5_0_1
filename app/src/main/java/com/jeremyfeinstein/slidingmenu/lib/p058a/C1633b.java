package com.jeremyfeinstein.slidingmenu.lib.p058a;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.a.b */
/* compiled from: SlidingActivityHelper */
final class C1633b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f3937a;

    /* renamed from: b */
    final /* synthetic */ boolean f3938b;

    /* renamed from: c */
    final /* synthetic */ SlidingActivityHelper f3939c;

    C1633b(SlidingActivityHelper aVar, boolean z, boolean z2) {
        this.f3939c = aVar;
        this.f3937a = z;
        this.f3938b = z2;
    }

    public final void run() {
        if (!this.f3937a) {
            this.f3939c.f3931b.mo16506c(false);
        } else if (this.f3938b) {
            this.f3939c.f3931b.mo16505b(false);
        } else {
            this.f3939c.f3931b.mo16503a(false);
        }
    }
}
