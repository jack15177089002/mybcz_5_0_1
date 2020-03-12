package com.jeremyfeinstein.slidingmenu.lib;

import android.util.Log;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.l */
/* compiled from: SlidingMenu */
final class C1643l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f3961a;

    /* renamed from: b */
    final /* synthetic */ SlidingMenu f3962b;

    C1643l(SlidingMenu slidingMenu, int i) {
        this.f3962b = slidingMenu;
        this.f3961a = i;
    }

    public final void run() {
        Log.v(SlidingMenu.f3895b, "changing layerType. hardware? " + (this.f3961a == 2));
        this.f3962b.getContent().setLayerType(this.f3961a, null);
        this.f3962b.getMenu().setLayerType(this.f3961a, null);
        if (this.f3962b.getSecondaryMenu() != null) {
            this.f3962b.getSecondaryMenu().setLayerType(this.f3961a, null);
        }
    }
}
