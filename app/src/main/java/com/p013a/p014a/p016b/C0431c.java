package com.p013a.p014a.p016b;

import com.p013a.p014a.C0438g;
import com.p013a.p014a.SwipeLayout;

/* renamed from: com.a.a.b.c */
/* compiled from: SwipeItemMangerImpl */
public final class C0431c implements C0438g {

    /* renamed from: a */
    public int f1685a;

    /* renamed from: b */
    final /* synthetic */ SwipeItemMangerImpl f1686b;

    C0431c(SwipeItemMangerImpl aVar, int i) {
        this.f1686b = aVar;
        this.f1685a = i;
    }

    /* renamed from: a */
    public final void mo2855a(SwipeLayout bVar) {
        if (this.f1686b.mo2854e(this.f1685a)) {
            bVar.open(false, false);
        } else {
            bVar.close(false, false);
        }
    }
}
