package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.m */
public final class ContinueStatement extends Jump {

    /* renamed from: g */
    public Name f6230g;

    /* renamed from: h */
    private Loop f6231h;

    public ContinueStatement() {
        this.f6389a = 121;
    }

    public ContinueStatement(int i, int i2) {
        this.f6389a = 121;
        this.f6210m = i;
        this.f6211n = i2;
    }

    /* renamed from: a */
    public final void mo18810a(Loop ajVar) {
        m5915a(ajVar);
        this.f6231h = ajVar;
        mo18727b(ajVar);
    }
}
