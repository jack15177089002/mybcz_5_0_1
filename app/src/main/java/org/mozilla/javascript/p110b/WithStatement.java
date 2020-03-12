package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.bf */
public final class WithStatement extends AstNode {

    /* renamed from: g */
    public AstNode f6187g;

    /* renamed from: h */
    public AstNode f6188h;

    /* renamed from: i */
    public int f6189i;

    /* renamed from: j */
    public int f6190j;

    public WithStatement() {
        this.f6189i = -1;
        this.f6190j = -1;
        this.f6389a = 123;
    }

    public WithStatement(int i, int i2) {
        super(i, i2);
        this.f6189i = -1;
        this.f6190j = -1;
        this.f6389a = 123;
    }

    /* renamed from: a */
    public final void mo18781a(AstNode eVar) {
        m5915a(eVar);
        this.f6187g = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: d */
    public final void mo18782d(AstNode eVar) {
        m5915a(eVar);
        this.f6188h = eVar;
        eVar.mo18790b(this);
    }
}
