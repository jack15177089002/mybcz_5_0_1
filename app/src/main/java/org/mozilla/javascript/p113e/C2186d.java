package org.mozilla.javascript.p113e;

import java.util.LinkedList;

/* renamed from: org.mozilla.javascript.e.d */
/* compiled from: Codegen */
final class C2186d {

    /* renamed from: a */
    LinkedList<C2187e> f6597a = new LinkedList<>();

    /* renamed from: b */
    final /* synthetic */ Codegen f6598b;

    C2186d(Codegen cVar) {
        this.f6598b = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo19067a(int i, int i2) {
        C2187e a = mo19068a();
        if (a.f6601c[i] == 0) {
            return 0;
        }
        int i3 = a.f6601c[i];
        mo19069a(a, i, i2);
        a.f6601c[i] = 0;
        return i3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19069a(C2187e eVar, int i, int i2) {
        if (eVar.f6602d[i] == 0) {
            throw new IllegalStateException("bad exception start");
        }
        if (this.f6598b.f6571a.mo18597m(eVar.f6602d[i]) != this.f6598b.f6571a.mo18597m(i2)) {
            this.f6598b.f6571a.mo18567a(eVar.f6602d[i], i2, eVar.f6601c[i], Codegen.m6517a(i));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C2187e mo19068a() {
        return (C2187e) this.f6597a.getLast();
    }
}
