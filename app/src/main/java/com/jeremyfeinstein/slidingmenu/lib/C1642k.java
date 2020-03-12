package com.jeremyfeinstein.slidingmenu.lib;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.k */
/* compiled from: SlidingMenu */
final class C1642k implements C1636d {

    /* renamed from: a */
    final /* synthetic */ SlidingMenu f3960a;

    C1642k(SlidingMenu slidingMenu) {
        this.f3960a = slidingMenu;
    }

    /* renamed from: a */
    public final void mo16599a(int i) {
        if (i == 0 && this.f3960a.f3899e != null) {
            this.f3960a.f3899e.onOpen();
        } else if (i == 1 && this.f3960a.f3901g != null) {
            this.f3960a.f3901g.onClose();
        } else if (i == 2 && this.f3960a.f3900f != null) {
            this.f3960a.f3900f.onOpen();
        }
    }
}
