package com.handmark.pulltorefresh.library;

/* renamed from: com.handmark.pulltorefresh.library.i */
/* compiled from: PullToRefreshBase */
final class C1615i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PullToRefreshBase f3851a;

    C1615i(PullToRefreshBase gVar) {
        this.f3851a = gVar;
    }

    public final void run() {
        this.f3851a.requestLayout();
    }
}
