package com.handmark.pulltorefresh.library;

/* renamed from: com.handmark.pulltorefresh.library.j */
/* compiled from: PullToRefreshBase */
final class C1616j implements C1626t {

    /* renamed from: a */
    final /* synthetic */ PullToRefreshBase f3852a;

    C1616j(PullToRefreshBase gVar) {
        this.f3852a = gVar;
    }

    /* renamed from: a */
    public final void mo16490a() {
        if (!this.f3852a.isRefreshing()) {
            this.f3852a.setState(C1629w.IDLE, new boolean[0]);
        }
    }
}
