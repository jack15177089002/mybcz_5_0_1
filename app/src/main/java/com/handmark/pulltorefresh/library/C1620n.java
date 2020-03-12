package com.handmark.pulltorefresh.library;

/* renamed from: com.handmark.pulltorefresh.library.n */
/* compiled from: PullToRefreshBase */
public enum C1620n {
    DISABLED(0),
    PULL_FROM_START(1),
    PULL_FROM_END(2),
    BOTH(3),
    MANUAL_REFRESH_ONLY(4);
    

    /* renamed from: f */
    public static C1620n f3866f;

    /* renamed from: g */
    public static C1620n f3867g;

    /* renamed from: h */
    int f3869h;

    static {
        f3866f = PULL_FROM_START;
        f3867g = PULL_FROM_END;
    }

    /* renamed from: a */
    static C1620n m3641a(int i) {
        C1620n[] values;
        for (C1620n nVar : values()) {
            if (i == nVar.f3869h) {
                return nVar;
            }
        }
        return PULL_FROM_START;
    }

    /* renamed from: a */
    static C1620n m3640a() {
        return PULL_FROM_START;
    }

    private C1620n(int i) {
        this.f3869h = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final boolean mo16492b() {
        return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
    }

    /* renamed from: c */
    public final boolean mo16493c() {
        return this == PULL_FROM_START || this == BOTH;
    }

    /* renamed from: d */
    public final boolean mo16494d() {
        return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
    }
}
