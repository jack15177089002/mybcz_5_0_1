package com.handmark.pulltorefresh.library;

/* renamed from: com.handmark.pulltorefresh.library.w */
/* compiled from: PullToRefreshBase */
public enum C1629w {
    RESET(0),
    PULL_TO_REFRESH(1),
    RELEASE_TO_REFRESH(2),
    REFRESHING(8),
    MANUAL_REFRESHING(9),
    OVERSCROLLING(16),
    IDLE(32);
    

    /* renamed from: h */
    int f3890h;

    /* renamed from: a */
    static C1629w m3647a(int i) {
        C1629w[] values;
        for (C1629w wVar : values()) {
            if (i == wVar.f3890h) {
                return wVar;
            }
        }
        return RESET;
    }

    private C1629w(int i) {
        this.f3890h = i;
    }
}
