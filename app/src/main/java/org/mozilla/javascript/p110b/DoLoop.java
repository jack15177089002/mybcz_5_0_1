package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.o */
public final class DoLoop extends Loop {

    /* renamed from: g */
    public AstNode f6232g;

    /* renamed from: h */
    public int f6233h;

    public DoLoop() {
        this.f6233h = -1;
        this.f6389a = 118;
    }

    public DoLoop(int i) {
        super(i);
        this.f6233h = -1;
        this.f6389a = 118;
    }

    /* renamed from: d */
    public final void mo18811d(AstNode eVar) {
        m5915a(eVar);
        this.f6232g = eVar;
        eVar.mo18790b(this);
    }
}
