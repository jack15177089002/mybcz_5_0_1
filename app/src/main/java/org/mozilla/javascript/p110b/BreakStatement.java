package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.i */
public final class BreakStatement extends Jump {

    /* renamed from: g */
    public Name f6215g;

    /* renamed from: h */
    private AstNode f6216h;

    public BreakStatement() {
        this.f6389a = 120;
    }

    public BreakStatement(int i, int i2) {
        this.f6389a = 120;
        this.f6210m = i;
        this.f6211n = i2;
    }

    /* renamed from: a */
    public final void mo18804a(Jump aeVar) {
        m5915a(aeVar);
        this.f6216h = aeVar;
        mo18727b(aeVar);
    }
}
